package com;

/**
 * Sources:
 * Kennedy, J. and Eberhart, R. C. Particle swarm optimization.
 * 
 * IGNACIO GIAMPAOLI ---- UNSTA
 * 
 */
 
import java.util.ArrayList;
import java.util.Random;

public class PSO
{
    private static final int TARGET = 250;
    private static final int MAX_INPUTS = 3;
    private static final int MAX_PARTICLES = 100;
    private static final int V_MAX = 1;     
    
    // Maximum velocity change allowed.
    //1000
    // x + y = TARGET, x + y = 2000
    // x (0 - 1)
    //y (0 - 1) 
    private static final int MAX_EPOCHS = 100;
    // The particles will be initialized with data randomly chosen within the range
    // of these starting min and max values: 
    private static final int START_RANGE_MIN = 0;
    private static final int START_RANGE_MAX = 10;

    private static ArrayList<Particle> particles = new ArrayList<Particle>();
    
    
    //ANTES DE INICIALIZAR SE DEBE NORMALIZAR!!!!!!!!!
    //FORMULA PARA NORMALIZAR ES X-MIN/MAX-MIN = % *100
    private static void initialize()
    {
        for(int i = 0; i < MAX_PARTICLES; i++)
        {
            Particle newParticle = new Particle();
            int total = 0;
            for(int j = 0; j < MAX_INPUTS; j++)
            {
                newParticle.data(j, getRandomNumber(START_RANGE_MIN, START_RANGE_MAX));
                total += newParticle.data(j);
            } // j
            newParticle.pBest(total);
            particles.add(newParticle);
        } // i
        return;
    }
    
    private static void PSOAlgorithm()
    {
        int gBest = 0;
        int gBestTest = 0;
        Particle aParticle = null;
        int epoch = 0;
        boolean done = false;

        initialize();

        while(!done)
        {
            // Two conditions can end this loop:
            //    if the maximum number of epochs allowed has been reached, or,
            //    if the Target value has been found.
            if(epoch < MAX_EPOCHS){

                for(int i = 0; i < MAX_PARTICLES; i++)
                {
                    aParticle = particles.get(i);
                    System.out.print("aParticle "+i+": "+aParticle.data(0)+"\n");
                    System.out.print("aParticle "+i+": "+aParticle.data(1)+"\n");
                    //System.out.print("aParticle 2: "+aParticle.data(2)+"\n");
                    //System.out.print("aParticle 3: "+aParticle.data(3)+"\n");
                    for(int j = 0; j < MAX_INPUTS; j++)
                    {
                        if(j < MAX_INPUTS - 1){
                            System.out.print(aParticle.data(j) + " + ");
                        }else{
                            System.out.print(aParticle.data(j) + " = ");
                        }
                    } // j

                    System.out.print(testProblem(i)+ "\n");
                    if(testProblem(i) == TARGET){
                        done = true;
                    }
                } // i

                gBestTest = minimum();
                aParticle = particles.get(gBest);
                // if(any particle's pBest value is better than the gBest value, make it the new gBest value.
                if(Math.abs(TARGET - testProblem(gBestTest)) < Math.abs(TARGET - testProblem(gBest))){
                    gBest = gBestTest;
                }

                getVelocity(gBest);

                updateparticles(gBest);
                
                System.out.println("epoch number: " + epoch);

                epoch += 1;

            }else{
                done = true;
            }
        }
        return;
    }
    
    private static void getVelocity(int gBestindex)
    {
    //  from Kennedy & Eberhart(1995).
    //    vx[][] = vx[][] + 2 * rand() * (pbestx[][] - presentx[][]) + 
    //                      2 * rand() * (pbestx[][gbest] - presentx[][])

        int testResults = 0;
        int bestResults = 0;
        double vValue = 0.0;
        Particle aParticle = null;

        bestResults = testProblem(gBestindex);

        for(int i = 0; i < MAX_PARTICLES; i++)
        {
            testResults = testProblem(i);
            aParticle = particles.get(i);
            vValue = aParticle.velocity() + 2 * new Random().nextDouble() * (aParticle.pBest() - testResults) + 2 * new Random().nextDouble() * (bestResults - testResults);

            if(vValue > V_MAX){
                aParticle.velocity(V_MAX);
            }else if(vValue < -V_MAX){
                aParticle.velocity(-V_MAX);
            }else{
                aParticle.velocity(vValue);
            }
        }
        return;
    }
    
    private static void updateparticles(int gBestindex)
    {
        Particle gBParticle = particles.get(gBestindex);

        for(int i = 0; i < MAX_PARTICLES; i++)
        {
            for(int j = 0; j < MAX_INPUTS; j++)
            {
                if(particles.get(i).data(j) != gBParticle.data(j)){
                    particles.get(i).data(j, particles.get(i).data(j) + (int)Math.round(particles.get(i).velocity()));
                }
            } // j

            // Check pBest value.
            int total = testProblem(i);
            if(Math.abs(TARGET - total) < particles.get(i).pBest()){
                particles.get(i).pBest(total);
            }

        } // i
        return;
    }
    
    private static int testProblem(int index)
    {
        int total = 0;
        Particle aParticle = null;

        aParticle = particles.get(index);
        
        //ACA METER LA FUNCION DE FITNESS, POR AHORA SE PRUEBA CON LA SUMA
        //ES DECIR, X + Y + ... + Z = TARGET ????
        //EL CODIGO DEL 'PSO2' DECLARA UN ERR_TOLERANCE
        //ADEMAS CALCULA UN err = ProblemSet.evaluate(gBestLocation) - 0;
        //A TRAVES DE LA FUNCION EVALUATE PARA VER QUE TAN BUENA ES LA PARTICULA
        //SI ERR < ERR_TOLERANCE, VA MINIMIZANDO EL ERROR Y SIGNIFICA QUE SE ACERCA A LA SOLUCION
        
        for(int i = 0; i < MAX_INPUTS; i++)
        {
            total += aParticle.data(i);
        }
        return total;
    }
    
    private static void printSolution()
    {
        // Find solution particle.
        int i = 0;
        for(; i < particles.size(); i++)
        {
            if(testProblem(i) == TARGET){
            	System.out.println("Hago break");
                //ACA METER ARRAY CON RANKING DE PARTICULAS QUE LLEGAN
            	//ADEMAS REINICIAR EL CONTADOR Y EL PROCESO PARA VER CUAL ES LA SEGUNDA, 
            	//TERCERA, CUARTA.., ETC PARTICULA QUE ALCANZA EL OBJETIVO.
            	break;
            }
        }
        // Print it.
        System.out.println("Particle " + i + " has achieved target.");
        for(int j = 0; j < MAX_INPUTS; j++)
        {
            if(j < MAX_INPUTS - 1){
                System.out.print(particles.get(i).data(j) + " + ");
            }else{
                System.out.print(particles.get(i).data(j) + " = " + TARGET);
            }
        } // j
        System.out.print("\n");
        return;
    }
    
    private static int getRandomNumber(int low, int high)
    {
        return (int)((high - low) * new Random().nextDouble() + low);
    }
    
    private static int minimum()
    {
    // Returns an array index.
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            for(int i = 0; i < MAX_PARTICLES; i++)
            {
                if(i != winner){             // Avoid self-comparison.
                    // The minimum has to be in relation to the Target.
                    if(Math.abs(TARGET - testProblem(i)) < Math.abs(TARGET - testProblem(winner))){
                        winner = i;
                        foundNewWinner = true;
                    }
                }
            }

            if(foundNewWinner == false){
                done = true;
            }
        }

        return winner;
    }
    
    private static class Particle
    {
        private int mData[] = new int[MAX_INPUTS];
        private int mpBest = 0;
        private double mVelocity = 0.0;
    
        public Particle()
        {
            this.mpBest = 0;
            this.mVelocity = 0.0;
        }
    
        public int data(int index)
        {
            return this.mData[index];
        }
        
        public void data(int index, int value)
        {
            this.mData[index] = value;
            return;
        }
    
        public int pBest()
        {
            return this.mpBest;
        }

        public void pBest(int value)
        {
            this.mpBest = value;
            return;
        }
    
        public double velocity()
        {
            return this.mVelocity;
        }
        
        public void velocity(double velocityScore)
        {
           this.mVelocity = velocityScore;
           return;
        }
    } // Particle
    
    public static void main(String[] args)
    {
        PSOAlgorithm();
        printSolution();
        return;
    }

}