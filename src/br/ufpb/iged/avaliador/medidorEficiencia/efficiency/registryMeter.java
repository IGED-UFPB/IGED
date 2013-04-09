package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

import java.util.LinkedList;
import java.util.List;


public class registryMeter {

	
	
			
	 int id; //Identificador �nico do algoritmo;
	 int id_exerc; //Identificador unico do exercicio;
	 String id_function; //Identificador �nico da fun��o;
	 int dimension; //Dimens�o da entrada de dados;
	 //efficiencyMeter meter; //Objeto resultante da medi��o do algoritmo;
	 	public long processingTotal;
		//static int totalMemory;
	 	public long temporaryMemory;
	 	public long peakMemory;
	 	public long finalAllocation;
	 	public long finalDesallocation;
	 	public long operatingVariable;
	 	public long operatingArray;
	 	public long operatingMethod;
	 	public long operating;	
	 	public long operatingLogic;
	 	public long operatingAritmetic;
	 
	
	public registryMeter(){
		
	}
	
	public final void zerar(){
		
		processingTotal = 0;
		//static int totalMemory;
	 	temporaryMemory = 0;
	 	peakMemory = 0;
	 	finalAllocation = 0;
	 	finalDesallocation = 0;
	 	operatingVariable = 0;
	 	operatingArray = 0;
	 	operatingMethod = 0;
	 	operating = 0;	
	 	operatingLogic = 0;
	 	operatingAritmetic = 0;
		
	}
	
	public registryMeter(int id, int id_exerc, String id_function, int dimension){
				
		this.setId(id);
		this.setId_exerc(id_exerc);
		this.setId_function(id_function);
		this.setDimension(dimension);
		//this.setMeter(meter);
		
		
		
	}
	
	public final int getId() {
		return id;
	}
	
	public final void setId(int id) {
		this.id = id;
	}
	
	public final int getId_exerc() {
		return id_exerc;
	}
	
	public final void setId_exerc(int id_exerc) {
		this.id_exerc = id_exerc;
	}
	
	public final String getId_function() {
		return id_function;
	}
	
	public final void setId_function(String id_function) {
		this.id_function = id_function;
	}
	
	public final int getDimension() {
		return dimension;
	}
	
	public final void setDimension(int dimension) {
		this.dimension = dimension;
	}
	
//	public final efficiencyMeter getMeter() {
//		return meter;
//	}
//	
//	public final void setMeter(efficiencyMeter meter) {
//		this.meter = meter;
//	}
	
public final String toString(){
		
		String s = "this.processingTotal = " + processingTotal + "\n" +
				"this.temporaryMemory = " + temporaryMemory +"\n" +
				"this.peakMemory = " + peakMemory +"\n" +
				"this.finalAllocation = " + finalAllocation +"\n" +
				"this.finalDesallocatio = " + finalDesallocation +"\n" +
				"this.operatingVariable = " + operatingVariable +"\n" +
				"this.operatingArray = " + operatingArray +"\n" +
				"this.operatingMethod = " + operatingMethod +"\n" +
				"this.operating = " + operating +"\n" +
				"this.operttingAritmetic" + operatingAritmetic +"\n" +
				"this.operatingLogic" + operatingLogic + "\n" +
				"this.ID = " + id + "\n" +	
				"this.ID_EXERCICIO = " + id_exerc + "\n" +
				"this.ID_FUNCTION = " + id_function + "\n" +
				"this.DIMENSION = " + dimension + "\n" ;
		
		return 	s;
	}
	
	


	
	
		
}
