package iged;

import iged.grafico.manager.ReferenceExistingException;
import java.util.List;

import iged.AED.Appraiser;
import iged.AED.StructManager;
import iged.grafico.manager.GraphicManager;
import iged.grafico.manager.Quadro;


public class GraficoAED {

	
	private GraphicManager gm = GraphicManager.getInstance();
	private StructManager sm =  StructManager.getInstance();
	private Appraiser ap;
	
        private int mode = IGEDConst.MODE_BOTH;
	
	public void createStruct(int tipo){
		sm.createStruct(tipo);
		if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.createStruct(tipo);
	}
	
	public void createReference(String reference, int type) throws ReferenceExistingException {
		sm.createReference(reference, type);
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.createReference(reference, type);
	}
	
	public void readReference(String reference) {
		sm.readReference(reference);
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.readReference(reference);
	}
	
	public void writeReference() {
		sm.writeReference();
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.writeReference();
	}
	
	public void readReferenceField(int field) {
		sm.readReferenceField(field);
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.readReferenceField(field);
	}
	
	
	public void writeReferenceField(int field) {
		sm.writeReferenceField(field);
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.writeReferenceField(field);
	}
	
	
	public void writeReferenceFieldNull(int field) {
		sm.writeReferenceFieldNull(field);
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.writeReferenceFieldNull(field);
		
	}
	
	public int readStructInfo() {
		int i = sm.readInfo();
		if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.readInfo();
		return i;
	}
	

	public void writeStructInfo(int value) {
		sm.writeInfo(value);
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.writeInfo(String.valueOf(value));
	}


	public void writeStructLength(int value) {
		sm.set_LengthStruct(value);
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.regVet(value);
	}
        
	public void removeReference(String reference) {
		sm.removeStruct(reference);
                if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.removeReference(reference);
	}

	
	public void creat_Int(String referencia){
		if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.create_Int(referencia);
	}
        
        public void remove_int(String referencia){
		if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.remove_int(referencia);
	}
	
	public void readReferenceInt(String referencia){
		if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.readReferenceInt(referencia);
	}
	
	public void setValueInt(int value){
		if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.setValue(String.valueOf(value));
	}
	public void ler_Int(String referencia){
		if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.read_Int(referencia);
	}
	
	public void endCommand(){
		sm.endCommand();
		if(mode != IGEDConst.MODE_PROFESSOR)
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
		if(mode != IGEDConst.MODE_PROFESSOR)
                    gm.regVet(pos);
	}
	
	public static Quadro quadro(){
		return iged.grafico.manager.Quadro.getInstance(); 
	}
	
	public void setMode(int mode){
                this.mode = mode;
		sm.setMode(mode);
	}
        
        public void clearStruct(){
            this.sm.clear();
            this.gm.clearAll();
        }
}
