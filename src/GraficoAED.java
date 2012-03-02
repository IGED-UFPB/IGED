import java.util.List;

import iged.AED.Appraiser;
import iged.AED.StructManager;
import iged.grafico.manager.GraphicManager;
import iged.grafico.manager.Quadro;


public class GraficoAED {

	
	private GraphicManager gm = new GraphicManager();
	private StructManager sm =  StructManager.getIntance();
	private Appraiser ap;
	
	
	
	
	public void createStruct(int tipo){
		sm.createStruct(tipo);
		gm.createStruct(tipo);
	}
	
	public void createReference(String reference, int type) {
		sm.createReference(reference, type);
		gm.createReference(reference, type);
	}
	
	public void readReference(String reference) {
		sm.readReference(reference);
		gm.readReference(reference);
	}
	
	public void writeReference() {
		sm.writeReference();
		gm.writeReference();
	}
	
	public void readReferenceField(int field) {
		sm.readReferenceField(field);
		gm.readReferenceField(field);
	}
	
	
	public void writeReferenceField(int field) {
		sm.writeReferenceField(field);
		gm.writeReferenceField(field);
	}
	
	
	public void writeReferenceFieldNull(int field) {
		sm.writeReferenceFieldNull(field);
		gm.writeReferenceFieldNull(field);
		
	}
	
	public int readStructInfo() {
		int i = sm.readInfo();
		gm.readInfo();
		return i;
	}
	

	public void writeStructInfo(int value) {
		sm.writeInfo(value);
		gm.writeInfo(String.valueOf(value));
	}
        
        /*public int readStructLength() {
		int i = sm.readLength();
		//gm.readLength();
		return i;
	}*/
	

	public void writeStructLength(int value) {
		sm.set_LengthStruct(value);
		gm.regVet(value);
	}
        
	public void removeReference(String reference) {
		sm.removeStruct(reference);
		gm.removeReference(reference);
	}

	
	public void creat_Int(String referencia){
		gm.create_Int(referencia);
	}
        
        public void remove_int(String referencia){
		gm.remove_int(referencia);
	}
	
	public void readReferenceInt(String referencia){
		gm.readReferenceInt(referencia);
	}
	
	public void setValueInt(int value){
		gm.setValue(String.valueOf(value));
	}
	public void ler_Int(String referencia){
		gm.read_Int(referencia);
	}
	
	public void endCommand(){
		sm.endCommand();
		gm.lixeiro();
	}
	
	public boolean correctTask(){
		ap = new Appraiser(sm);
		return ap.assess();
	}
	
	public List<String> correctStructs(){
		return ap.correct();
	}
	
	public void setPosVector(int pos){
		sm.setPosVector(pos);
		sm.set_LengthStruct(pos);
		gm.regVet(pos);
	}
	
	public static Quadro quadro(){
		return iged.grafico.manager.Quadro.getInstance(); 
	}
	
	public void setMode(int mode){
		sm.setMode(mode);
	}	
}
