package com;
/**
 * Sources:
 * Kennedy, J. and Eberhart, R. C. Particle swarm optimization.
 * 
 * IGNACIO GIAMPAOLI ---- UNSTA
 * 
 */
 
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Swarm
{
    final int TARGET = 568;
    final int MAX_INPUTS = 10;
    final int MAX_PARTICLES = 400;
    final int V_MAX = 5;             // Maximum velocity change allowed.

    final int MAX_EPOCHS = 250;
    // The particles will be initialized with data randomly chosen within the range
    // of these starting min and max values: 
    final int START_RANGE_MIN = 0;
    final int START_RANGE_MAX = 50;

    ArrayList<Particle> particles = new ArrayList<Particle>(100);
    
    
    //ANTES DE INICIALIZAR SE DEBE NORMALIZAR!!!!!!!!!
    //FORMULA PARA NORMALIZAR ES X-MIN/MAX-MIN = % *100
    void miInitialize(String miCluster, String variablesAct)
    {
    	int variablesActInt = Integer.parseInt(variablesAct);
        String[] miCluster2 = miCluster.split(",");
        System.out.println("tamaño de mi cluster: "+miCluster2.length);
        
        int aux = 0;
        for(int i = 0; i < miCluster2.length/variablesActInt; i++)
        {
            Particle newParticle = new Particle();
            int total = 0;
            for(int j = 0; j < variablesActInt; j++)
            {
            	//A LA DATA-NORMALIZED LA MULTIPLICO POR 100 Y AGARRO SOLO LA PARTE ENTERA
            	//HAGO ESTO PARA PODER USAR LA INFO NORMALIZADA Y QUE EL PSO SIGA TRABAJANDO CON
            	//ENTEROS Y NO CON FLOATS
                newParticle.data(j, (int) (Float.parseFloat(miCluster2[j+aux])*100));
                total += newParticle.data(j);
                //System.out.println("particula "+ i +", elemento: "+j+", valor:"+(int) (Float.parseFloat(miCluster2[j+aux])*100));
            } // j
            aux = aux + variablesActInt;
            newParticle.pBest(total);
            particles.add(newParticle);
            //System.out.println("particlessssssssssssssss: "+particles);
        } // i
        return;
    }
    
    void initialize()
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
    
    void PSOAlgorithm(String miCluster, String variablesAct, int maxEpochs)
    {
    	
        int gBest = 0;
        int gBestTest = 0;
        Particle aParticle = null;
        int epoch = 0;
        boolean done = false;

        //initialize();
        miInitialize(miCluster, variablesAct);
    	int variablesActInt = Integer.parseInt(variablesAct);
        String[] miCluster2 = miCluster.split(",");
        System.out.println("tamaño maxepochs: "+maxEpochs);
        System.out.println("tamaño PSOALGORTIHM foo: "+miCluster2.length/variablesActInt);
        int maxParticles = miCluster2.length/variablesActInt;
        
        while(!done)
        {
            // Two conditions can end this loop:
            //    if the maximum number of epochs allowed has been reached, or,
            //    if the Target value has been found.
            if(epoch < maxEpochs){

                for(int i = 0; i < maxParticles; i++)
                {
                    aParticle = particles.get(i);
                    //System.out.print("aParticle "+i+": "+aParticle.data(0)+"\n");
                    //System.out.print("aParticle "+i+": "+aParticle.data(1)+"\n");
                    //System.out.print("aParticle 2: "+aParticle.data(2)+"\n");
                    //System.out.print("aParticle 3: "+aParticle.data(3)+"\n");
                    for(int j = 0; j < variablesActInt; j++)
                    {
                        if(j < variablesActInt - 1){
                            //System.out.print(aParticle.data(j) + " + ");
                        }else{
                            //System.out.print(aParticle.data(j) + " = ");
                        }
                    } // j

                    //System.out.print("Test problem: "+testProblem(i, variablesActInt)+ "\n");
                    if(testProblem(i, variablesActInt) == TARGET){
                        done = true;
                    }
                } // i

                gBestTest = minimum(maxParticles, variablesActInt);
                aParticle = particles.get(gBest);
                // if(any particle's pBest value is better than the gBest value, make it the new gBest value.
                if(Math.abs(TARGET - testProblem(gBestTest, variablesActInt)) < Math.abs(TARGET - testProblem(gBest, variablesActInt))){
                    gBest = gBestTest;
                }

                getVelocity(gBest, variablesActInt, maxParticles);

                updateparticles(gBest, variablesActInt, maxParticles);
                
                System.out.println("epoch number: " + epoch);

                epoch += 1;

            }else{
                done = true;
            }
        }
        return;
    }
    
    void getVelocity(int gBestindex, int variablesActInt, int maxParticles)
    {
    //  from Kennedy & Eberhart(1995).
    //    vx[][] = vx[][] + 2 * rand() * (pbestx[][] - presentx[][]) + 
    //                      2 * rand() * (pbestx[][gbest] - presentx[][])

        int testResults = 0;
        int bestResults = 0;
        double vValue = 0.0;
        Particle aParticle = null;

        bestResults = testProblem(gBestindex, variablesActInt);

        for(int i = 0; i < maxParticles; i++)
        {
            testResults = testProblem(i, variablesActInt);
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
    
    void updateparticles(int gBestindex, int variablesActInt, int maxParticles)
    {
    	
        Particle gBParticle = particles.get(gBestindex);

        for(int i = 0; i < maxParticles; i++)
        {
            for(int j = 0; j < variablesActInt; j++)
            {
                if(particles.get(i).data(j) != gBParticle.data(j)){
                    particles.get(i).data(j, particles.get(i).data(j) + (int)Math.round(particles.get(i).velocity()));
                }
            } // j

            // Check pBest value.
            int total = testProblem(i, variablesActInt);
            if(Math.abs(TARGET - total) < particles.get(i).pBest()){
                particles.get(i).pBest(total);
            }

        } // i
        return;
    }
    
    int testProblem(int index, int variablesActInt)
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

        //Math.pow(x[i], 2);
        for(int i = 0; i < variablesActInt; i++)
        {
            total += aParticle.data(i);
            //total += Math.pow(aParticle.data(i), 2);
        }
        
        return total;
    }
    
    void printSolution(int variablesActInt, int clusterId) throws IOException
    {

        // Find solution particle.
        int i = 0;
        for(; i < particles.size(); i++)
        {
            if(testProblem(i, variablesActInt) == TARGET){
            	System.out.println("Hago break");
            	FileWriter writer = new FileWriter("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\resultado"+clusterId+".csv");
            	writer.write("Particle " + i + " has achieved target.\n");
            	writer.close();
                System.out.println("Particle " + i + " has achieved target.");
                //ACA METER ARRAY CON RANKING DE PARTICULAS QUE LLEGAN
            	break;
            }else if(i == particles.size()-1) {
            	FileWriter writer = new FileWriter("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\resultado"+clusterId+".csv");
            	writer.write("NINGUNA has achieved target.\n");
            	writer.close();
                System.out.println("NINGUNA has achieved target.");
            	break;
            }
        }
        // Print it.
    	//FileWriter writer = new FileWriter("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\resultado"+clusterId+".csv");
    	//writer.write("Particle " + i + " has achieved target.\n");
    	//writer.close();
        //System.out.println("Particle " + i + " has achieved target.");
        for(int j = 0; j < variablesActInt; j++)
        {
        	
            if(j < variablesActInt - 1){
                System.out.print(particles.get(i).data(j) + " + ");
            }else{
                System.out.print(particles.get(i).data(j) + " = " + TARGET);
            }
        } // j
        System.out.print("\n");
        return;
    }
    
    int getRandomNumber(int low, int high)
    {
        return (int)((high - low) * new Random().nextDouble() + low);
    }
    
    int minimum(int maxParticles, int variablesActInt)
    {
    // Returns an array index.
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            for(int i = 0; i < maxParticles; i++)
            {
                if(i != winner){             // Avoid self-comparison.
                    // The minimum has to be in relation to the Target.
                    if(Math.abs(TARGET - testProblem(i, variablesActInt)) < Math.abs(TARGET - testProblem(winner, variablesActInt))){
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
    
    class Particle
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
        /*
        public void setVariablesAct(int VariablesActInt)
        {
        int mData[] = new int[VariablesActInt];
           return;
        }
        */
    } // Particle
    
    public static void main(String miCluster, String variablesAct, int clusterId, int maxEpochs) throws IOException
    {
    	System.out.println("entra al main con epochsmax: "+maxEpochs);
    	System.out.println("entra al main con el cluster: "+miCluster);
    	System.out.println("separar el cluster cada (comas): "+variablesAct);
    	int variablesActInt = Integer.parseInt(variablesAct);
    	Swarm myObject = new Swarm();
        myObject.PSOAlgorithm(miCluster, variablesAct, maxEpochs);
        myObject.printSolution(variablesActInt, clusterId);
        return;
    }

}