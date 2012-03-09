import iged.IGEDConst;
import iged.Interpretador;
import iged.grafico.manager.AcaoUsuario;
import iged.grafico.manager.PaintUI;
import iged.grafico.manager.Quadro;
import java.util.StringTokenizer;

public class IGED implements AcaoUsuario{

	
	static PaintUI pait ;
        private Interpretador iter = new Interpretador();
	
	
	private IGED(){
	}
	

	public void init(){
		pait = new PaintUI("IGED V 1.1", this);
		pait.lastLine();
                
                iter.init();
	}


	
	public Quadro getQuadro() {
		return iter.getQuadro();
	}

	public static void main (String args[]) throws InterruptedException{
		IGED iged = new IGED();	
	
                iged.init();
                iged.move();
	}


	@Override
	public void color() {
            new Thread(){
                public void run(){
                    StringTokenizer st = new StringTokenizer(pait.Lines(), "\n");
                    while (st.hasMoreTokens()) {
                        String c = st.nextToken();
                        System.out.println(c);
                        iter.interprete(c);
                    }
                }
            }.start();
	}


	@Override
	public void move() {
		// TODO Auto-generated method stub
            String s = "CREATE_REF LIST l \n CREATE_STRUCT LIST \n WRITE_REF \n	END_COMMAND \n CREATE_REF NODE n \n CREATE_STRUCT NODE \n WRITE_REF \n END_COMMAND \n READ_REF n \n WRITE_INFO 10 \n END_COMMAND \n READ_REF l \n READ_REF n \n WRITE_REF_FIELD INIT \n END_COMMAND";// \n DELETE_REF n \n END_COMMAND";
	
            StringTokenizer st = new StringTokenizer(s, "\n");
            iter.setMode(IGEDConst.MODE_BOTH);
            while (st.hasMoreTokens()) {
                String c = st.nextToken();
                System.out.println(c);
                iter.interprete(c);
            }
        }


	@Override
	public void zoom() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
