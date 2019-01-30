package com;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Path("/solucion2")
public class CalcularSolucion2 {
    
    @GET
    @Path("/{query}")
    @Produces(MediaType.TEXT_HTML)
    public String getSolucion(@QueryParam("descripcion") String descripcion, @QueryParam("variable1nombre") String variable1nombre, @QueryParam("variable1rangomin") String variable1rangomin, @QueryParam("variable1rangomax") String variable1rangomax, @QueryParam("demo1") String demo1, @QueryParam("variable1color") String variable1color, @QueryParam("variable2nombre") String variable2nombre, @QueryParam("variable2rangomin") String variable2rangomin, @QueryParam("variable2rangomax") String variable2rangomax, @QueryParam("demo2") String demo2, @QueryParam("variable2color") String variable2color, @QueryParam("variable3nombre") String variable3nombre, @QueryParam("variable3rangomin") String variable3rangomin, @QueryParam("variable3rangomax") String variable3rangomax, @QueryParam("demo3") String demo3, @QueryParam("variable3color") String variable3color, @QueryParam("variable4nombre") String variable4nombre, @QueryParam("variable4rangomin") String variable4rangomin, @QueryParam("variable4rangomax") String variable4rangomax, @QueryParam("demo4") String demo4, @QueryParam("variable4color") String variable4color, @QueryParam("variable5nombre") String variable5nombre, @QueryParam("variable5rangomin") String variable5rangomin, @QueryParam("variable5rangomax") String variable5rangomax, @QueryParam("demo5") String demo5, @QueryParam("variable5color") String variable5color, @QueryParam("variable6nombre") String variable6nombre, @QueryParam("variable6rangomin") String variable6rangomin, @QueryParam("variable6rangomax") String variable6rangomax, @QueryParam("demo6") String demo6, @QueryParam("variable6color") String variable6color, @QueryParam("variable7nombre") String variable7nombre, @QueryParam("variable7rangomin") String variable7rangomin, @QueryParam("variable7rangomax") String variable7rangomax, @QueryParam("demo7") String demo7, @QueryParam("variable7color") String variable7color, @QueryParam("variable8nombre") String variable8nombre, @QueryParam("variable8rangomin") String variable8rangomin, @QueryParam("variable8rangomax") String variable8rangomax, @QueryParam("demo8") String demo8, @QueryParam("variable8color") String variable8color, @QueryParam("variable9nombre") String variable9nombre, @QueryParam("variable9rangomin") String variable9rangomin, @QueryParam("variable9rangomax") String variable9rangomax, @QueryParam("demo9") String demo9, @QueryParam("variable9color") String variable9color, @QueryParam("variable10nombre") String variable10nombre, @QueryParam("variable10rangomin") String variable10rangomin, @QueryParam("variable10rangomax") String variable10rangomax, @QueryParam("demo10") String demo10, @QueryParam("variable10color") String variable10color, @QueryParam("islas") String islas, @QueryParam("iteraciones") String iteraciones, @QueryParam("tipoSolucion") String tipoSolucion, @QueryParam("variablesAct") String variablesAct, @QueryParam("accept") String accept) {    	
    //ARRIBA EN LA FUNCION FALTA RESOLVER SI LA VARIABLE ES CONTINUA O DISCRETA!!!!
   	//TAMBIEN FALTA RESOLVER LA VARIABLE variablesAct
    	
    	String[][] variable = new String[12][5];
    	
		variable[1][0] = variable1nombre;
		variable[1][1] = variable1rangomin;
		variable[1][2] = variable1rangomax;
		variable[1][3] = demo1;
		variable[1][4] = variable1color;
		
		variable[2][0] = variable2nombre;
		variable[2][1] = variable2rangomin;
		variable[2][2] = variable2rangomax;
		variable[2][3] = demo2;
		variable[2][4] = variable2color;
		
		variable[3][0] = variable3nombre;
		variable[3][1] = variable3rangomin;
		variable[3][2] = variable3rangomax;
		variable[3][3] = demo3;
		variable[3][4] = variable3color;
		
		variable[4][0] = variable4nombre;
		variable[4][1] = variable4rangomin;
		variable[4][2] = variable4rangomax;
		variable[4][3] = demo4;
		variable[4][4] = variable4color;
		
		variable[5][0] = variable5nombre;
		variable[5][1] = variable5rangomin;
		variable[5][2] = variable5rangomax;
		variable[5][3] = demo5;
		variable[5][4] = variable5color;
		
		variable[6][0] = variable6nombre;
		variable[6][1] = variable6rangomin;
		variable[6][2] = variable6rangomax;
		variable[6][3] = demo6;
		variable[6][4] = variable6color;
		
		variable[7][0] = variable7nombre;
		variable[7][1] = variable7rangomin;
		variable[7][2] = variable7rangomax;
		variable[7][3] = demo7;
		variable[7][4] = variable7color;
		
		variable[8][0] = variable8nombre;
		variable[8][1] = variable8rangomin;
		variable[8][2] = variable8rangomax;
		variable[8][3] = demo8;
		variable[8][4] = variable8color;
		
		variable[9][0] = variable9nombre;
		variable[9][1] = variable9rangomin;
		variable[9][2] = variable9rangomax;
		variable[9][3] = demo9;
		variable[9][4] = variable9color;
		
		variable[10][0] = variable10nombre;
		variable[10][1] = variable10rangomin;
		variable[10][2] = variable10rangomax;
		variable[10][3] = demo10;
		variable[10][4] = variable10color;
		
		variable[11][0] = islas;
		variable[11][1] = iteraciones;
		variable[11][2] = variablesAct;
		variable[11][3] = accept;
 		
    	/*
    	System.out.println(variable1nombre);
    	System.out.println(variable5nombre);
    	System.out.println(demo5);
    	*/

		System.out.println(Arrays.deepToString(variable));
		
		System.out.println("Islas: "+variable[11][0]);
		System.out.println("Iteraciones: "+variable[11][1]);
		
		int islasInt = Integer.parseInt(islas);
		
		//DEBO AVERIGUAR LA CANTIDAD DE VARIABLES QUE INGRESO EL USUARIO
		int variablesActInt = Integer.parseInt(variablesAct);
		int poblacionTotal = islasInt*10;
		
		ArrayList<String> particula1 = new ArrayList<String>();
		ArrayList<String> ListaValoresParticulas = new ArrayList<String>();
		String[][] particula = new String[poblacionTotal][30];
		
		particula1.add(islas);
		particula1.add(iteraciones);
		particula1.add(variablesAct);
		particula1.add(accept);
		
		//POR AHORA SERA CONSTANTE HASTA CAMBIAR EL FRONTEND Y DIVIDIR EL INPUT DEL RANGO
		//AL DIVIDIR EN INPUT RANGO EN DOS INPUT: TENDREMOS UN MIN Y UN MAX POR SEPARADO
		//Y ASIGNAREMOS ESE MIN Y ESE MAX A LAS SIGUIENTES VARIABLES
		
		//ASIGNO ALEATORIOS A LAS PARTICULAS EQUIVALENTE AL NUMERO DE ISLAS
		Random rand = new Random();
		int variable1rangoMin = 0;
		int variable1rangoMax = 50;
		int variable1rangoMin1 = 51;
		int variable1rangoMax1 = 100;
		
		//PROBANDO CON ARRAY LIST PARA VALORES DE PARTICULAS, ASIGNANDO RANGOS QUE DESP SE CAMBIARA POR LOS QUE VIENEN DEL FRONTEND
		int[] rangoVariableMin = new int[10];
		int[] rangoVariableMax = new int[10];
		for(int i=0;i<variablesActInt;i++) {
			
			if(i==0){
				
				if(variable1rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable1rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable1rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable1rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==1){
				
				if(variable2rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable2rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable2rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable2rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==2){

				if(variable3rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable3rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable3rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable3rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==3){
				
				if(variable4rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable4rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable4rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable4rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==4){

				if(variable5rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable5rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable5rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable5rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==5){

				if(variable6rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable6rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable6rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable6rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==6){
				
				if(variable7rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable7rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable7rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable7rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==7){

				if(variable8rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable8rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable8rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable8rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==8){
				
				if(variable9rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable9rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable9rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable9rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}else if(i==9){
				
				if(variable10rangomin!=""){
					rangoVariableMin[i] = Integer.parseInt(variable10rangomin);
				}else{
					rangoVariableMin[i] = 0;
				}
				if(variable10rangomax!=""){
					rangoVariableMax[i] = Integer.parseInt(variable10rangomax);
				}else{
					rangoVariableMax[i] = 0;
				}
				
			}

		//System.out.println("Variable "+i+" Min: "+rangoVariableMin[i]);
		//System.out.println("Variable "+i+" Max: "+rangoVariableMax[i]);
		}
		//FIN
		
		//GENERACION DE VARIABLES DE CADA PARTICULA
		/*
		for(int i=1;i<variablesActInt;i++) {
			
			//Nombre variable
			particula[1][1] = variable[i][0];
			//Valor Random
			particula[1][2] = variable[i][1];
			
		}
		*/
		
		//PROBANDO CON ARRAY LIST VALORES PARTICULAS
		for(int i=0;i<rangoVariableMin.length;i++) {
			if(i<variablesActInt) {
				int result1 = rand.nextInt(rangoVariableMax[i]-rangoVariableMin[i]) + rangoVariableMin[i];
				ListaValoresParticulas.add(Integer.toString(result1));
				//System.out.println(particula1);
			}else {
				ListaValoresParticulas.add(Integer.toString(0));
			}
		}
		System.out.println("Lista de valores particulas: "+ListaValoresParticulas);
		
		
		
		

		for(int j=0;j<poblacionTotal;j++) {
			
			//Numero de particula
			/*
			particula[j][0] = "Particula "+j;
			System.out.println(particula[j][0]);
			*/
			
			
			//PROBANDO CON ARRAY LIST
			particula1.add("Particula "+j);
			
			for(int i=0;i<variablesActInt;i++) {
				//PROBANDO CON ARRAY LIST
				particula1.add(variable[i+1][0]);
				//System.out.println("Nombre: "+variable[i+1][0]);
				//System.out.println("Max: "+rangoVariableMax[i]);
				//System.out.println("Min: "+rangoVariableMin[i]);
				int result1 = rand.nextInt(rangoVariableMax[i]-rangoVariableMin[i]) + rangoVariableMin[i];
				//int result1 = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
				particula1.add(Integer.toString(result1));
				//System.out.println("Valor: "+result1);
				//System.out.println(particula1);
				
				//PROBANDO CON ARRAY
				/*
				particula[j][i] = variable[i][0];
				int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
				particula[j][i+1] = Integer.toString(result);
				*/
				//System.out.println(particula[j][i]);
			}		
			
			
			/*
			for(int i=0;i<=variablesActInt*2;i++) {
				
				if(i==0) {
					//Nombre variable
					particula[j][i+1] = variable[i+1][0];
					//Valor Random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+2] = Integer.toString(result);
				}else if(i==1) {
					//Nombre variable
					particula[j][i+2] = variable[i+1][0];
					//Valor Random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+3] = Integer.toString(result);
				}else if(i==2){
					//Nombre variable
					particula[j][i+3] = variable[i+1][0];
					//Valor random variable					
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+4] = Integer.toString(result);
				}else if(i==3){
					//Nombre variable
					particula[j][i+4] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+5] = Integer.toString(result);
				}else if(i==4){
						//Nombre variable
						particula[j][i+5] = variable[i+1][0];
						//Valor random variable
						int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
						particula[j][i+6] = Integer.toString(result);
				}else if(i==5){
					//Nombre variable
					particula[j][i+7] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+8] = Integer.toString(result);				
				}else if(i==6){
					//Nombre variable
					particula[j][i+8] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+9] = Integer.toString(result);				
				}else if(i==7){
					//Nombre variable
					particula[j][i+10] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+11] = Integer.toString(result);				
				}else if(i==8){
					//Nombre variable
					particula[j][i+12] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+13] = Integer.toString(result);				
				}else if(i==9){
					//Nombre variable
					particula[j][i+14] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+15] = Integer.toString(result);				
				}else if(i==10){
					//Nombre variable
					particula[j][i+16] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+17] = Integer.toString(result);				
				}else if(i==11){
					//Nombre variable
					particula[j][i+17] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+18] = Integer.toString(result);				
				}else if(i==12){
					//Nombre variable
					particula[j][i+19] = variable[i+1][0];
					//Valor random variable
					int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
					particula[j][i+20] = Integer.toString(result);				
				}
			 	*/
				
			}
			
			System.out.println(particula1);
			
			/*
			for(int i=2;i<=variablesActInt;i++) {
				
				//Nombre variable
				particula[j][3] = variable[i][0];
				//Valor Random
				int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
				particula[j][4] = Integer.toString(result);
				break;
				
			}
			
			for(int i=3;i<=variablesActInt;i++) {
				
				//Nombre variable
				particula[j][5] = variable[i][0];
				//Valor Random
				int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
				particula[j][6] = Integer.toString(result);
				break;
				
			}
			
			for(int i=4;i<=variablesActInt;i++) {
				
				//Nombre variable
				particula[j][7] = variable[i][0];
				//Valor Random
				int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
				particula[j][8] = Integer.toString(result);
				break;
				
			}
			*/
			
			//ESTRUCT. PARTICULA: { 0: { 1: 'Peso', 2: 'Valor Random(1.50)' }, 1: { 1: 'Peso', 2: 'Valor Random(1.50)' },..... }
			/*
			particula[j][0] = "Particula "+j;
			particula[j][1] = variable[j][0];
			int result = rand.nextInt(variable1rangoMax-variable1rangoMin) + variable1rangoMin;
			particula[j][2] = Integer.toString(result);
			*/
			
		/*
			System.out.println(particula[j][0]);
			System.out.println(particula[j][1]);
			System.out.println(particula[j][2]);
			System.out.println(particula[j][3]);
			System.out.println(particula[j][4]);
			System.out.println(particula[j][5]);
			System.out.println(particula[j][6]);
			System.out.println(particula[j][7]);
			System.out.println(particula[j][8]);
			*/
		
		
		Start comienzo = new Start();
		
		try {
			comienzo.main(particula1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    	
		String datos = "";
		
		
		for (int i=1;i<=10;i++) {
			
			datos = datos + "Variable "+ i + ":" + variable[i][0] + ", " + variable[i][1] + ", " + variable[i][2] + ", " + variable[i][3] + "<br>"; 
			
		}
		
		System.out.println(datos);
		
    	return "<body><h1>" + datos + "</body></h1>";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSaludoPlain() {
        return "Hola mundo!"  ;
    }

    public static Object[] add(Object[] arr, Object... elements){
        Object[] tempArr = new Object[arr.length+elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        
        for(int i=0; i < elements.length; i++)
            tempArr[arr.length+i] = elements[i];
        return tempArr;
        
    }
    
}

