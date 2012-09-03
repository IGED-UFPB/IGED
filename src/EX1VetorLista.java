import br.ufpb.iged.GraficoAED;
import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.grafico.manager.AcaoUsuario;
import br.ufpb.iged.grafico.manager.GraphicManager;
import br.ufpb.iged.grafico.manager.PaintUI;
import br.ufpb.iged.grafico.manager.Quadro;
import br.ufpb.iged.grafico.struct.LinkedList;
import br.ufpb.iged.grafico.struct.LinkedListNode;
import br.ufpb.iged.grafico.struct.Struct;

import java.util.Timer;
import java.util.TimerTask;


//play

public class EX1VetorLista implements AcaoUsuario{

	

    private Quadro quadro;
    private GraficoAED con = new GraficoAED();
    
    Timer timer;
	
    public EX1VetorLista(){
	this.quadro =con.quadro();
	TestTask tt = new TestTask();
        tt.initEditor();
        
        timer = new Timer();
        timer.schedule(tt, 200, 2000);
        
    }

    @Override
    public void color() {
    }
    
    
    class TestTask extends TimerTask{
        int count = 0;
        
        private void initEditor(){
        	con.createReference("l", IGEDConst.LISTA);
        	con.createStruct(IGEDConst.LISTA);
        	con.writeReference();
        	
        	con.createReference("v", IGEDConst.VETOR);
        	con.setPosVector(4); //asdasdas o erro � pq ele ta criando um vetor com 0 casas pq na criacao do vc nao ta atualizando
            con.createStruct(IGEDConst.VETOR);
            con.writeReference();

            con.endCommand();
        }
    
        public void Passo0(){
        	con.readReference("v");
        	con.setPosVector(0);
        	con.writeStructInfo(0);
            
        	con.readReference("v");
        	con.setPosVector(1);
        	con.writeStructInfo(1);
            
        	con.readReference("v");
        	con.setPosVector(2);
        	con.writeStructInfo(9);
            
        	con.readReference("v");
        	con.setPosVector(3);
        	con.writeStructInfo(1);
        	
        	
        	con.createReference("n", IGEDConst.NODE);
        	
        	con.creat_Int("cont");
        	con.readReferenceInt("cont");
        	con.setValueInt(0);
        	
        	con.endCommand();
            
        
        }
        
        public void Passo1(){
        	
        	con.readReference("n");
        	con.createStruct(IGEDConst.NODE);
        	con.writeReference();
        	
        	con.readReference("n");
        	con.createStruct(IGEDConst.NODE);
        	con.writeReferenceField(IGEDConst.NODE_PROX);
        	
        	con.readReference("n");
        	con.readReferenceField(IGEDConst.NODE_PROX);
        	con.writeStructInfo(0);
        	
        	con.readReferenceInt("cont");
        	con.setValueInt(1);
    	
        	con.endCommand();
        }
        
        public void Passo2(){
        	
        	con.readReference("n");
        	con.writeStructInfo(1);
        	
        	con.readReferenceInt("cont");
        	con.setValueInt(2);
        	
        	con.endCommand();	
        }
    
        public void Passo3(){
        	con.readReference("l");
        	con.readReference("n");
        	con.writeReferenceField(IGEDConst.LISTA_INICIO);
        	
        	con.readReference("n");
        	con.createStruct(IGEDConst.NODE);
        	con.writeReference();
        	
        	con.readReference("n");
        	con.createStruct(IGEDConst.NODE);
        	con.writeReferenceField(IGEDConst.NODE_PROX);
        	
        	con.endCommand();
        }
        
        public void Passo4(){
        	con.readReference("n");
        	con.readReferenceField(IGEDConst.NODE_PROX);
        	con.writeStructInfo(9);
        	
        	con.readReferenceInt("cont");
        	con.setValueInt(3);
    	
        	con.endCommand();
        }
        
        public void Passo5(){
    	
        	con.readReference("n");
        	con.writeStructInfo(1);
        	
        	con.endCommand();
    	
        }
        
        public void Passo6(){
        	con.readReference("n");
        	con.readReferenceField(IGEDConst.NODE_PROX);
        	con.readReference("l");
        	con.readReferenceField(IGEDConst.LISTA_INICIO);
        	con.writeReferenceField(IGEDConst.NODE_PROX);
        	
        	con.endCommand();
        	
        }
        
        public void Passo7(){
        	con.readReference("l");
        	con.readReference("n");
        	con.writeReferenceField(IGEDConst.LISTA_INICIO);
        	con.endCommand();
        	
        }
    
	 public void execut(){
		switch(count){
                    case 0:
                    	Passo0();
                        break;
                    case 1:
                    	Passo1();
                        break;
                    case 2:
                    	Passo2();
                        break;
                    case 3:
                    	Passo3();
                        break;
                    case 4:
                    	Passo4();
                        break;
                    case 5:
                    	Passo5();
                        break;
                    case 6:
                    	Passo6();
                    	break;
                    case 7:
                    	Passo7();
                    	break;
                }
                ++count;
	}

        @Override
        public void run() {
            execut();
        }
    }
	public void move(){
		/*v.mover(new Point2D.Double(20, 70));*/
	}


	public Quadro getQuadro(){
		return quadro;
	}

	public void init(){
		new PaintUI("IGED V0.1", this);
	}

	@Override
	public void zoom() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	public static void main(String[] args) {
		new EX1VetorLista().init();
	}
	
	
	
	
	
	
	
}
