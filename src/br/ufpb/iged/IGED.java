package br.ufpb.iged;

import br.ufpb.iged.grafico.manager.AcaoUsuario;
import br.ufpb.iged.grafico.manager.PaintUI;
import br.ufpb.iged.grafico.manager.Quadro;
import br.ufpb.iged.interpretador.principal.Interpretador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class IGED implements AcaoUsuario{
	
	public static PaintUI pait ;
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
           /*final StringTokenizer st = new StringTokenizer(pait.Lines(), "\n");
            new Thread(){
                @Override
                public void run(){
                    while (st.hasMoreTokens()) {
                        String c = st.nextToken();
                        System.out.println(c);
                        iter.interprete(c);
                    }
                }
            }.start();*/
		
		String codigoArquivo = pait.Lines();
		try {
			FileWriter fw = new FileWriter("classes/Main.j");
			BufferedWriter bw =  new BufferedWriter(fw);
			bw.write(codigoArquivo);
			bw.close();
			fw.close();
			iter.interpretar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
