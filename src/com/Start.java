package com;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Start {
    public static void main(ArrayList<String> particula1) throws IOException {
    	
    System.out.println("Islas: "+particula1.get(0));
    	
    System.out.println("entraaaaaaa");
    System.out.println("Particulas: "+particula1);
    	
	//CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\data4.csv"));
	//FileWriter writer = new FileWriter("out4.csv");
	
    //MI NUEVO DATA CSV
	FileWriter writer1 = new FileWriter("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\data.csv");

	System.out.println("Particula size: "+particula1.size());
	
	//for (int i=6;i<Integer.parseInt(particula1.get(0))*20;i++) {
	for (int i=26;i<particula1.size();i++) {		
	    //System.out.println("Particula que se escribira en csv: "+particula1.get(i));
	    if(Integer.parseInt(particula1.get(2))==1) {
	    	writer1.write(particula1.get(i+3).toString() + "\n");
	    	i = i + 2;
	    }else if(Integer.parseInt(particula1.get(2))==2) {
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + "\n");
		    i = i + 4;    	
	    }else if(Integer.parseInt(particula1.get(2))==3) {
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + ", ");
		    writer1.write(particula1.get(i+4).toString() + "\n");
		    i = i + 6;
	    }else if(Integer.parseInt(particula1.get(2))==4) {
	    	System.out.println("Hola: "+i);
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + ", ");
		    writer1.write(particula1.get(i+4).toString() + ", ");
		    writer1.write(particula1.get(i+6).toString() + "\n");
		    i = i + 8;
	    }else if(Integer.parseInt(particula1.get(2))==5) {
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + ", ");
		    writer1.write(particula1.get(i+4).toString() + ", ");
		    writer1.write(particula1.get(i+6).toString() + ", ");
		    writer1.write(particula1.get(i+8).toString() + "\n");
		    i = i + 10;
	    }else if(Integer.parseInt(particula1.get(2))==6) {
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + ", ");
		    writer1.write(particula1.get(i+4).toString() + ", ");
		    writer1.write(particula1.get(i+6).toString() + ", ");
		    writer1.write(particula1.get(i+8).toString() + ", ");
		    writer1.write(particula1.get(i+10).toString() + "\n");
		    i = i + 12;
	    }else if(Integer.parseInt(particula1.get(2))==7) {
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + ", ");
		    writer1.write(particula1.get(i+4).toString() + ", ");
		    writer1.write(particula1.get(i+6).toString() + ", ");
		    writer1.write(particula1.get(i+8).toString() + ", ");
		    writer1.write(particula1.get(i+10).toString() + ", ");
		    writer1.write(particula1.get(i+12).toString() + "\n");
		    i = i + 14;
	    }else if(Integer.parseInt(particula1.get(2))==8) {
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + ", ");
		    writer1.write(particula1.get(i+4).toString() + ", ");
		    writer1.write(particula1.get(i+6).toString() + ", ");
		    writer1.write(particula1.get(i+8).toString() + ", ");
		    writer1.write(particula1.get(i+10).toString() + ", ");
		    writer1.write(particula1.get(i+12).toString() + ", ");
		    writer1.write(particula1.get(i+14).toString() + "\n");
		    i = i + 16;
	    }else if(Integer.parseInt(particula1.get(2))==9) {
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + ", ");
		    writer1.write(particula1.get(i+4).toString() + ", ");
		    writer1.write(particula1.get(i+6).toString() + ", ");
		    writer1.write(particula1.get(i+8).toString() + ", ");
		    writer1.write(particula1.get(i+10).toString() + ", ");
		    writer1.write(particula1.get(i+12).toString() + ", ");
		    writer1.write(particula1.get(i+14).toString() + ", ");
		    writer1.write(particula1.get(i+16).toString() + "\n");
		    i = i + 18;
	    }else if(Integer.parseInt(particula1.get(2))==10) {
		    writer1.write(particula1.get(i).toString() + ", ");
		    writer1.write(particula1.get(i+2).toString() + ", ");
		    writer1.write(particula1.get(i+4).toString() + ", ");
		    writer1.write(particula1.get(i+6).toString() + ", ");
		    writer1.write(particula1.get(i+8).toString() + ", ");
		    writer1.write(particula1.get(i+10).toString() + ", ");
		    writer1.write(particula1.get(i+12).toString() + ", ");
		    writer1.write(particula1.get(i+14).toString() + ", ");
		    writer1.write(particula1.get(i+16).toString() + ", ");
		    writer1.write(particula1.get(i+18).toString() + "\n");
		    i = i + 20;
	    }

	}
    writer1.close();
    
	FileWriter writer2 = new FileWriter("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\data-normalized.csv");

	//for (int i=6;i<Integer.parseInt(particula1.get(0))*20;i++) {
	for (int i=26;i<particula1.size();i++) {		
	    //System.out.println("Particula que se escribira en csv normalizado: "+particula1.get(i));
	    if(Integer.parseInt(particula1.get(2))==1) {
	    	writer2.write((Float.parseFloat(particula1.get(i+3))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + "\n");
	    	i = i + 2;
	    }else if(Integer.parseInt(particula1.get(2))==2) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + "\n");		   
	    	i = i + 4;
	    }else if(Integer.parseInt(particula1.get(2))==3) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+4))-Float.parseFloat(particula1.get(8)))/(Float.parseFloat(particula1.get(9))-Float.parseFloat(particula1.get(8))) + "\n");		   
		    i = i + 6;
	    }else if(Integer.parseInt(particula1.get(2))==4) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+4))-Float.parseFloat(particula1.get(8)))/(Float.parseFloat(particula1.get(9))-Float.parseFloat(particula1.get(8))) + ", ");    	
	    	writer2.write((Float.parseFloat(particula1.get(i+6))-Float.parseFloat(particula1.get(10)))/(Float.parseFloat(particula1.get(11))-Float.parseFloat(particula1.get(10))) + "\n");		   
		    i = i + 8;
	    }else if(Integer.parseInt(particula1.get(2))==5) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+4))-Float.parseFloat(particula1.get(8)))/(Float.parseFloat(particula1.get(9))-Float.parseFloat(particula1.get(8))) + ", ");    	
	    	writer2.write((Float.parseFloat(particula1.get(i+6))-Float.parseFloat(particula1.get(10)))/(Float.parseFloat(particula1.get(11))-Float.parseFloat(particula1.get(10))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+8))-Float.parseFloat(particula1.get(12)))/(Float.parseFloat(particula1.get(13))-Float.parseFloat(particula1.get(12))) + "\n");		   
	    	i = i + 10;
	    }else if(Integer.parseInt(particula1.get(2))==6) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+4))-Float.parseFloat(particula1.get(8)))/(Float.parseFloat(particula1.get(9))-Float.parseFloat(particula1.get(8))) + ", ");    	
	    	writer2.write((Float.parseFloat(particula1.get(i+6))-Float.parseFloat(particula1.get(10)))/(Float.parseFloat(particula1.get(11))-Float.parseFloat(particula1.get(10))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+8))-Float.parseFloat(particula1.get(12)))/(Float.parseFloat(particula1.get(13))-Float.parseFloat(particula1.get(12))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+10))-Float.parseFloat(particula1.get(14)))/(Float.parseFloat(particula1.get(15))-Float.parseFloat(particula1.get(14))) + "\n");		   
	    	i = i + 12;
	    }else if(Integer.parseInt(particula1.get(2))==7) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+4))-Float.parseFloat(particula1.get(8)))/(Float.parseFloat(particula1.get(9))-Float.parseFloat(particula1.get(8))) + ", ");    	
	    	writer2.write((Float.parseFloat(particula1.get(i+6))-Float.parseFloat(particula1.get(10)))/(Float.parseFloat(particula1.get(11))-Float.parseFloat(particula1.get(10))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+8))-Float.parseFloat(particula1.get(12)))/(Float.parseFloat(particula1.get(13))-Float.parseFloat(particula1.get(12))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+10))-Float.parseFloat(particula1.get(14)))/(Float.parseFloat(particula1.get(15))-Float.parseFloat(particula1.get(14))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+12))-Float.parseFloat(particula1.get(16)))/(Float.parseFloat(particula1.get(17))-Float.parseFloat(particula1.get(16))) + "\n");		   
	    	i = i + 14;
	    }else if(Integer.parseInt(particula1.get(2))==8) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+4))-Float.parseFloat(particula1.get(8)))/(Float.parseFloat(particula1.get(9))-Float.parseFloat(particula1.get(8))) + ", ");    	
	    	writer2.write((Float.parseFloat(particula1.get(i+6))-Float.parseFloat(particula1.get(10)))/(Float.parseFloat(particula1.get(11))-Float.parseFloat(particula1.get(10))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+8))-Float.parseFloat(particula1.get(12)))/(Float.parseFloat(particula1.get(13))-Float.parseFloat(particula1.get(12))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+10))-Float.parseFloat(particula1.get(14)))/(Float.parseFloat(particula1.get(15))-Float.parseFloat(particula1.get(14))) + ",");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+12))-Float.parseFloat(particula1.get(16)))/(Float.parseFloat(particula1.get(17))-Float.parseFloat(particula1.get(16))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+14))-Float.parseFloat(particula1.get(18)))/(Float.parseFloat(particula1.get(19))-Float.parseFloat(particula1.get(18))) + "\n");		   
	    	i = i + 16;
	    }else if(Integer.parseInt(particula1.get(2))==9) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+4))-Float.parseFloat(particula1.get(8)))/(Float.parseFloat(particula1.get(9))-Float.parseFloat(particula1.get(8))) + ", ");    	
	    	writer2.write((Float.parseFloat(particula1.get(i+6))-Float.parseFloat(particula1.get(10)))/(Float.parseFloat(particula1.get(11))-Float.parseFloat(particula1.get(10))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+8))-Float.parseFloat(particula1.get(12)))/(Float.parseFloat(particula1.get(13))-Float.parseFloat(particula1.get(12))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+10))-Float.parseFloat(particula1.get(14)))/(Float.parseFloat(particula1.get(15))-Float.parseFloat(particula1.get(14))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+12))-Float.parseFloat(particula1.get(16)))/(Float.parseFloat(particula1.get(17))-Float.parseFloat(particula1.get(16))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+14))-Float.parseFloat(particula1.get(18)))/(Float.parseFloat(particula1.get(19))-Float.parseFloat(particula1.get(18))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+16))-Float.parseFloat(particula1.get(20)))/(Float.parseFloat(particula1.get(21))-Float.parseFloat(particula1.get(20))) + "\n");		   
	    	i = i + 18;
	    }else if(Integer.parseInt(particula1.get(2))==10) {
	    	writer2.write((Float.parseFloat(particula1.get(i))-Float.parseFloat(particula1.get(4)))/(Float.parseFloat(particula1.get(5))-Float.parseFloat(particula1.get(4))) + ", ");
	    	writer2.write((Float.parseFloat(particula1.get(i+2))-Float.parseFloat(particula1.get(6)))/(Float.parseFloat(particula1.get(7))-Float.parseFloat(particula1.get(6))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+4))-Float.parseFloat(particula1.get(8)))/(Float.parseFloat(particula1.get(9))-Float.parseFloat(particula1.get(8))) + ", ");    	
	    	writer2.write((Float.parseFloat(particula1.get(i+6))-Float.parseFloat(particula1.get(10)))/(Float.parseFloat(particula1.get(11))-Float.parseFloat(particula1.get(10))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+8))-Float.parseFloat(particula1.get(12)))/(Float.parseFloat(particula1.get(13))-Float.parseFloat(particula1.get(12))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+10))-Float.parseFloat(particula1.get(14)))/(Float.parseFloat(particula1.get(15))-Float.parseFloat(particula1.get(14))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+12))-Float.parseFloat(particula1.get(16)))/(Float.parseFloat(particula1.get(17))-Float.parseFloat(particula1.get(16))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+14))-Float.parseFloat(particula1.get(18)))/(Float.parseFloat(particula1.get(19))-Float.parseFloat(particula1.get(18))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+16))-Float.parseFloat(particula1.get(20)))/(Float.parseFloat(particula1.get(21))-Float.parseFloat(particula1.get(20))) + ", ");		   
	    	writer2.write((Float.parseFloat(particula1.get(i+18))-Float.parseFloat(particula1.get(22)))/(Float.parseFloat(particula1.get(23))-Float.parseFloat(particula1.get(22))) + "\n");		   
	    	i = i + 20;
	    }

	}
    writer2.close();
    //FIN DE MI NUEVO DATA CSV
	
	CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\data-normalized.csv"));
	FileWriter writer = new FileWriter("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\out.csv");
    
	List<String[]> myEntries = reader.readAll();
	List<Punto> puntos = new ArrayList<Punto>();

	
	for (String[] strings : myEntries) {
	    Punto p = new Punto(strings);
	    puntos.add(p);
	    //System.out.println("myEntries p: "+p);
	}
	
	//System.out.println("misParticulas: "+puntos);	
	System.out.println("myEntries puntos: "+puntos);

	KMeans kmeans = new KMeans();
	int k = Integer.parseInt(particula1.get(0));
	//CREAR CLUSTERS QUE IRAN A PSO
	ArrayList<String> misClusters = new ArrayList<String>();
	
	    KMeansResultado resultado = kmeans.calcular(puntos, k);
	    writer.write("------- Con k=" + k + "-------\n");
	    int i = 0;
	    for (Cluster cluster : resultado.getClusters()) {
	
	    //System.out.println("Centro de clusters en start: "+cluster);
	    
		i++;
		writer.write("-- Cluster " + i + " --\n");
		for (Punto punto : cluster.getPuntos()) {
		    //System.out.println("clusterrrrrrrrr: "+cluster);
		    writer.write(punto.toString() + "\n");
		    //Agregar punto al cluster
		    misClusters.add(punto.toString());
		}
		misClusters.add("----");
		//System.out.println("misClusters: "+misClusters);
		writer.write("\n");
		writer.write(cluster.getCentroide().toString());
		writer.write("\n\n");	
	    } 
    
	writer.close();
	reader.close();
	//    LLAMAR A PSOOOOOOOOOOOOOOOOOOOOOO AQUI!!!!!!!!!!!!!!!!!!!!!!!!!!
	//LLAMAR A PSO POR CADA CLUSTER EN AL TERMINAR DE ARMARLOS
	System.out.println("misClusters Terminados: "+misClusters);
	String res = String.join(",", misClusters);
    System.out.println("res: "+res);
    String[] miCluster = res.split(",----");
    String[] miCluster2 = miCluster[0].split(",");
    System.out.println("tamaño de miCluster2 en Start: "+miCluster2.length/Integer.parseInt(particula1.get(2)));
    //System.out.println("Primer caracter: "+miCluster[0].charAt(0));
    int maxEpochs = Integer.parseInt(particula1.get(1));
    
    for(int x=0;x<miCluster.length;x++) {
    	
    	System.out.println("Primer caracter del cluster: "+miCluster[x].charAt(0));
    	System.out.println("micluster antes de la coma: "+miCluster[x]);
        // prints the substring after index 7 till index 17
    	if(miCluster[x].charAt(0)==',') {
        	miCluster[x] = miCluster[x].substring(1); 
        	System.out.println("micluster despues de la coma: "+miCluster[x]);
    	}
    	//System.out.println("entra al for: "+x);
    	//System.out.println("entra al for: "+miCluster[x]);
    	//Swarm miPSO = new Swarm();
    	Swarm.main(miCluster[x], particula1.get(2), x, maxEpochs);
    }
    
   	
    
    }
}