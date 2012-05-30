package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

import java.util.LinkedList;
import java.util.List;



public class TableMeter {
	
	List<registryMeter> table = new LinkedList<registryMeter>();
	static private TableMeter tableMeter = null;
	
	
	
	 private TableMeter(){
	
		// this.getInstance();
		 
	 }
	
	public List<registryMeter> getTable() {
		return this.table;
	}

	public void addTable(registryMeter registerMeter) {
		this.table.add(registerMeter);
		
		//System.out.println(registerMeter);
	}
	
	public static TableMeter getInstance(){
		
		if(tableMeter == null){
			tableMeter = new TableMeter();
		}
		return tableMeter;
	}
	
	private List<registryMeter> subListRegistry(String id_function){
		
		List<registryMeter> tableRegistry = new LinkedList<registryMeter>();
		
		for(registryMeter registry: this.table){
			
			if(registry.getId_function().equals(id_function)){
				
				tableRegistry.add(registry);
								
			}
			
		}
		
		return tableRegistry;
	}
	
	public XYSeries getXYSeries(String id_function) {
		
		List<registryMeter> tableRegistry = subListRegistry(id_function);
		
		XYSeries xy = new XYSeries(id_function);
		
		for(registryMeter registry: tableRegistry){
			
			xy.addPoint2D((double)registry.dimension, (double)registry.processingTotal);
								
		}
				
		return xy;
		
		
	}

}
