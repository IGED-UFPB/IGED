package efficiency;



public class efficiencyMeter {

	
	//Definir as variáveis que faltam.
	
	
	public registryMeter registerMeter;
	static TableMeter tableMeter = TableMeter.getInstance();
	
	

	public efficiencyMeter() {
		this.inicializador();
		
	}
	
	
	public final void inicializador() {
		
		registerMeter = new registryMeter();
		
		registerMeter.processingTotal = 0;
		//this.totalMemory = 0;
		registerMeter.temporaryMemory =0;
		registerMeter.peakMemory = 0;
		registerMeter.finalAllocation = 0;
		registerMeter.finalDesallocation = 0;
		registerMeter.operatingVariable = 0;
		registerMeter.operatingArray = 0;
		registerMeter.operatingMethod = 0;
		registerMeter.operating = 0;
		registerMeter.operatingLogic = 0;
		registerMeter.operatingAritmetic = 0;
		
	}
	
	public final void finalizador(int id, int id_exer, String i, int dimension, efficiencyMeter meter){
		
		
		registerMeter.id = id;
		registerMeter.id_exerc = id_exer;
		registerMeter.id_function = i;
		registerMeter.dimension = dimension;
		
		tableMeter.addTable(registerMeter);
		
	}
	

	//Alocação
	
	// Variável simples
	public final void simpleVariableAllocation(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		registerMeter.temporaryMemory += 1;
		registerMeter.finalAllocation +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	//Referência
	public final void referenceAllocation(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		registerMeter.temporaryMemory += 1;	
		registerMeter.finalAllocation +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}

	//Objeto	
	public final void objectAllocation(int n){
		registerMeter.processingTotal += 1;
		//this.totalMemory += n;
		registerMeter.temporaryMemory += n;
		registerMeter.finalAllocation +=n;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	//Vetor
	public final void arrayAllocation(int n){
		registerMeter.processingTotal += 1;
		//this.totalMemory += n;
		registerMeter.temporaryMemory += n;
		registerMeter.finalAllocation +=n;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	
	}
	
	
	//Desalocação 
	
	//Variável simples
	public final void simpleVariableDeAllocation(){	
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		registerMeter.temporaryMemory -= 1;
		registerMeter.finalDesallocation +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
		
	}
	
	//Referência
	public final void referenceDeAllocation(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		registerMeter.temporaryMemory -= 1;
		registerMeter.finalDesallocation +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	//Objeto
	public final void objectDeAllocation(int n){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		registerMeter.temporaryMemory -= n;
		registerMeter.finalDesallocation +=n;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	//Vetor
	public final void arrayDeAllocation(int n){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		registerMeter.temporaryMemory -= n;
		registerMeter.finalDesallocation +=n;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	
	//Operações (variáveis, referências ou objetos)
	
	//Atribuição
	public final void attributionVariable(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		//this.finalMemory += 1;
		registerMeter.operatingVariable +=1;
		
	}
	
	//Acesso
	public final void acessVariable(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		//this.finalMemory += 1;
		registerMeter.operatingVariable +=1;
	}
	
	
	//Operações (vetor)
	
	//Atribuição
	public final void attributionArray(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		//this.finalMemory += 1;
		registerMeter.operatingArray +=1;
	}
	
	//Acesso
	public final void acessArray(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		//this.finalMemory += 1;
		registerMeter.operatingArray +=1;
	}
	
	//Indexação
	public final void indexArray(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		//this.finalMemory += 1;
		registerMeter.operatingArray +=1;
	}
	
	
	//Metodos
	
	//Invocação
	public final void methodInvocation(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		registerMeter.temporaryMemory += 1;
		registerMeter.operatingMethod +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	//Retorno
	public final void methodReturn(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		registerMeter.temporaryMemory -= 1;
		registerMeter.operatingMethod +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	
	//Operações
	
	public final void operation(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		//this.finalMemory += 1;
		registerMeter.operating +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	//Operações Logicas
	public final void operationLogic(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		//this.finalMemory += 1;
		registerMeter.operatingLogic +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	public final void operationAritimetic(){
		registerMeter.processingTotal += 1;
		//this.totalMemory += 1;
		//this.finalMemory += 1;
		registerMeter.operatingAritmetic +=1;
		
			if(registerMeter.temporaryMemory > registerMeter.peakMemory){
				registerMeter.peakMemory = registerMeter.temporaryMemory;
			}
	}
	
	
	
}
