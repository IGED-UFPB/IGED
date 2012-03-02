package iged.grafico.struct;

import iged.IGEDConst;
import java.awt.geom.Point2D;

import iged.grafico.geometria.Label;
import iged.grafico.manager.Quadro;
import iged.grafico.manager.StructManager;


public class Lista extends Struct {

	private int bond = 100;
	private boolean repintado = false;
	private String referencia;
	private String tamanho = "0";

	private Label l;
	private Referencia ref;
	private VarInteiro tam = null;

	private LinkedListNode ini = null;
	private Quadro quadro = Quadro.getInstance();
	private int yBase = 0;
	private int espaco = 85;

	private Null n;

	public void desenhar(int yBase) {
		this.yBase = yBase;

		if (this.ini == null) {
			// desenhar lista vazia "referencia solta"
			if (n == null) {
				this.ref = new Referencia(new Point2D.Double(60, yBase + espaco
						+ 10), referencia + ".inicio", true);

				n = new Null(new Point2D.Double(
						120 + (7 * referencia.length()), yBase + espaco + 5),
						true);// apontando para null
				quadro.add(n);
				quadro.add(ref);
				quadro.atualizar();
			} else {
				quadro.remove(ref);
				quadro.remove(n);
				this.ref = new Referencia(new Point2D.Double(60, yBase + espaco
						+ 10), referencia + ".inicio", true);// apontando para
																// null
				n = new Null(new Point2D.Double(
						120 + (7 * referencia.length()), yBase + espaco + 5),
						true);
				quadro.add(n);
				quadro.add(ref);
				quadro.atualizar();
			}
		} else {

			if (n != null) {
				quadro.remove(n);
				n = null;
			}
			if (ref != null) {
				quadro.remove(ref);
				ini.remove(ref);
                        }

			ref = new Referencia(ini, referencia + ".inicio",
					new Point2D.Double(60, yBase + espaco + 10));
			ref.setFixa(true);

			quadro.add(ref);
			quadro.atualizar();
		}
		if (tam != null) {
			quadro.remove(tam);
			quadro.add(tam);
		} else {
			tam = new VarInteiro(new Point2D.Double(30, yBase + 100),referencia + ".tamanho");
			tam.setValor(tamanho);
			quadro.add(tam);
		}
		quadro.atualizar();
	}

	public void setyBase(int yBase) {
		this.yBase = yBase;
	}

	public void setBond(int bond) {
		this.bond = bond;
	}

	@Override
	public int getBond() {
		return this.bond;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
		this.desenhar(yBase);
	}

	public LinkedListNode getInit() {
		return ini;
	}

	public void setInit(Struct ini) {
		if(this.ini != null){
			this.ini.remove(this.ref);
		}
		if(n != null){
			quadro.remove(n);
		}
		this.ini = ((LinkedListNode) ini);
		this.desenhar(yBase);

	}

	public void adjust() {

		this.ini.adjust(this.getPInit());

	}

	public boolean isVista() {
		return this.repintado;
	}

	public void serVista(boolean vista) {
		this.repintado = vista;
	}

	public void setSize(String value) {
		this.tamanho = value;
		if (tam != null) {
			quadro.remove(tam);
			tam = new VarInteiro(new Point2D.Double(30, yBase + 100),referencia + ".tamanho");
			tam.setValor(tamanho);
			quadro.add(tam);
		} else {
			tam = new VarInteiro(new Point2D.Double(30, yBase + 100),referencia + ".tamanho");
			tam.setValor(tamanho);
			quadro.add(tam);
		}
		quadro.atualizar();
	}

	public Point2D getPInit() {
		return new Point2D.Double(VarInteiro.LARGURA + 120, yBase + (bond + 30));
	}

	public void repintar() {
		
// redesenhando
		
		if(!this.repintado){
			this.desenhar(yBase);
			LinkedListNode n1 = this.ini;

				n1 = this.ini;
				
				while (n1 != null) {
					if(!n1.isRepintado()){
						n1.repintar();
					}else{
						break;
					}
					
					n1 = n1.getProx();
					if (n1 != null && n1.equals(this.ini)) {
						break;
					}
				}
				
				if(this.ini !=null){
					this.adjust();
				}
			
			this.repintado = true;
		}
		
	}

	@Override
	public Struct readField(int field) {
		switch (field) {
		case IGEDConst.LISTA_INICIO:
			return this.ini;

		}
		return null;
	}

	@Override
	public void writeField(Struct s, int field) {
		switch (field) {
		case IGEDConst.LISTA_INICIO:
			this.setInit(((LinkedListNode) s));

		}

	}

	@Override
	public String readInfo() {
		return this.tamanho;
	}

	@Override
	public void writeInfo(String value) {
		this.tamanho = value;
		if (tam != null) {
			quadro.remove(tam);
			tam = new VarInteiro(new Point2D.Double(30, yBase + 100),
					referencia + ".tamanho");
			tam.setValor(tamanho);
			quadro.add(tam);
		} else {
			tam = new VarInteiro(new Point2D.Double(30, yBase + 100),
					referencia + ".tamanho");
			tam.setValor(tamanho);
			quadro.add(tam);
		}
		quadro.atualizar();
	}


	@Override
	public boolean isRepintado() {
		return this.repintado;
	}

	@Override
	public void startRepaint() {
		this.repintado = false;
		
		LinkedListNode n1 = this.ini;
		while (n1 != null) {
			n1.startRepaint();
			n1 = n1.getProx();
			if (n1 != null && n1.equals(this.ini)) {
				break;
			}
		}

	}

	@Override
	public String toString() {
		return "Lista " + referencia;
	}

    @Override
    public Point2D add(Referencia ref) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Referencia ref) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Point2D getPointPI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
