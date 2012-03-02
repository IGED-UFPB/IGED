import iged.GraficoAED;
import iged.IGEDConst;
import iged.grafico.manager.AcaoUsuario;
import iged.grafico.manager.GraphicManager;
import iged.grafico.manager.PaintUI;
import iged.grafico.manager.Quadro;
import iged.grafico.struct.Lista;
import iged.grafico.struct.LinkedListNode;
import iged.grafico.struct.Struct;

public class Ex2Listas implements AcaoUsuario {



	private Quadro quadro;
    private GraficoAED con = new GraficoAED();
	
    int count = 0;
	
	
    public Ex2Listas(){
		this.quadro = con.quadro();
		con.setMode(IGEDConst.MODE_PROFESSOR);
		initEditor();
	}
        
    private void initEditor(){
    	con.creat_Int("l");
    	con.readReferenceInt("l");
    	con.setValueInt(2);

    	con.creat_Int("cont");
    	con.readReferenceInt("cont");
    	con.setValueInt(7);

    	con.creat_Int("i");
    	con.readReferenceInt("i");
    	con.setValueInt(0);
    	
    	
    	
       con.createReference("n", IGEDConst.NODE);
       con.createStruct(IGEDConst.NODE);
       con.writeReference();
       con.endCommand();
       
       con.readReference("n");
       con.writeStructInfo(-1);
       
       con.createReference("n2", IGEDConst.NODE);
       con.endCommand();
       
       
       
       con.createReference("l", IGEDConst.LISTA);
       con.createStruct(IGEDConst.LISTA);
       con.writeReference();
       
       con.endCommand();
    }
    
    public void Passo0(){
    	con.readReference("l");
    	con.readReference("n");
    	con.writeReferenceField(IGEDConst.LISTA_INICIO);
    	
    	con.endCommand();
    }
    public void Passo1(){
    	con.readReference("n2");
    	con.createStruct(IGEDConst.NODE);
    	con.writeReference();
    	
    	con.endCommand();
    }
    public void Passo2(){
    	con.readReference("l");
    	con.readReferenceField(IGEDConst.LISTA_INICIO);
    	con.readReference("n2");
    	con.writeReferenceField(IGEDConst.NODE_PROX);
    	
    	con.readReference("n2");
   		con.writeStructInfo(5);
    	
    	con.endCommand();
    		
    }
    public void Passo3(){
    	con.readReference("n");
    	con.createStruct(IGEDConst.NODE);
    	con.writeReference();
    	
    	con.endCommand();
    }
    public void Passo4(){
    	
    	con.readReference("n2");
    	con.readReference("n");
    	con.writeReferenceField(IGEDConst.NODE_PROX);

    	con.endCommand();
    }
    public void Passo5(){
    	con.readReference("n");
    	con.createStruct(IGEDConst.NODE);
    	con.writeReference();
    	
    	con.endCommand();
    	
    	
    }
    public void Passo6(){
    	
    	// Olhar que ta feio
    	con.createReference("lista", IGEDConst.LISTA);
    	con.createStruct(IGEDConst.LISTA);
    	con.writeReference();
    	
    	con.readReference("lista");
    	con.readReference("n2");
    	con.writeReferenceField(IGEDConst.LISTA_INICIO);
    	
    	
    	con.endCommand();
    	
    }
    
    
	@Override
	 public void color(){
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
                }
                ++count;
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
		new Ex2Listas().init();
	}
	
	
}
