package com;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	FileWriter writer1 = new FileWriter("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\data5.csv");
	
    //writer1.close();
    //FIN DE MI NUEVO DATA CSV
	
	CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Colo\\eclipse-workspace\\ApiRestRomper\\data4.csv"));
	FileWriter writer = new FileWriter("out4.csv");
    
	List<String[]> myEntries = reader.readAll();
	List<Punto> puntos = new ArrayList<Punto>();

	
	for (String[] strings : myEntries) {
	    Punto p = new Punto(strings);
	    puntos.add(p);
	    //System.out.println("myEntries p: "+p);
	}
	
	System.out.println("misParticulas: "+puntos);	
	System.out.println("myEntries puntos: "+puntos);

	KMeans kmeans = new KMeans();
	int k = Integer.parseInt(particula1.get(0));
	
	    KMeansResultado resultado = kmeans.calcular(puntos, k);
	    writer.write("------- Con k=" + k + " ofv=" + resultado.getOfv()
		    + "-------\n");
	    int i = 0;
	    for (Cluster cluster : resultado.getClusters()) {
	    	
	    //System.out.println("Centro de clusters en start: "+cluster);
	    
		i++;
		writer.write("-- Cluster " + i + " --\n");
		for (Punto punto : cluster.getPuntos()) {
		    //System.out.println("Puntos en start: "+punto);
		    writer.write(punto.toString() + "\n");
		}
		writer.write("\n");
		writer.write(cluster.getCentroide().toString());
		writer.write("\n\n");
	    }
	
	writer.close();
	reader.close();
    }
}