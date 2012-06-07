package br.ufpb.iged;

import br.ufpb.iged.grafico.manager.AcaoUsuario;
import br.ufpb.iged.grafico.manager.PaintUI;
import br.ufpb.iged.grafico.manager.Quadro;
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
	}


	@Override
	public void color() {
            final StringTokenizer st = new StringTokenizer(pait.Lines(), "\n");
            new Thread(){
                @Override
                public void run(){
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
		
	}


	@Override
	public void zoom() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
