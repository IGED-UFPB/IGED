/**
 * 
 */
package iged.grafico.struct;

import iged.IGEDConst;
import iged.grafico.geometria.Label;
import iged.grafico.manager.Quadro;

import java.awt.geom.Point2D;

/**
 * @author Smith
 *
 */
public class BinaryTree extends Struct{
	
	
	private Point2D pi = new Point2D.Double(150, 150);
	
	private Referencia ref = null;
	private NodeTree ini = null;
	private Label l;
	private Null n;
	
	
	private Quadro quadro = Quadro.getInstance();
	
	private boolean repintado = false;
	private int yBase = 0;
	private int bond = 100;
	private int espaco = 85;
	
	private String referencia;
	private String tamanho = "0";

	
	public Point2D getPInit() {
		return this.pi;
		//return new Point2D.Double(VarInteiro.LARGURA + 120, yBase + (bond + 30));
	}
	
	public int getBond() {
		return this.bond;
	}
	
	public void repintar() {
		if(!this.repintado){
			this.desenhar(yBase);
			NodeTree n1 = this.ini;

			if(!n1.isRepintado())
				n1.repintar();
		
			if(this.ini !=null)
				this.adjust();
			
			this.repintado = true;
		}
		
		
	}

	public boolean isRepintado() {
		return this.repintado;
	}
	
	public void startRepaint() {
		this.repintado = false;
		
		NodeTree n1 = this.ini;
		/**Essa chamada será feita para a referência de nodetree desta classe
		 * de forma recursiva, na classe nodetree, será feita para os filhos à direita e 
		 * à esquerda de n1.
		 * */
		n1.startRepaint();
		
		
	}
	
	public Struct readField(int field) {
		switch(field){
			case IGEDConst.NODE_TREE_ROOT:
				return this.ini;
		}
		return null;
	}

	public void writeField(Struct s, int field) {
		switch (field) {
		case IGEDConst.NODE_TREE_ROOT:
			this.setInit(((NodeTree) s));

		}
		
	}

	public String readInfo() {
		return this.tamanho;
	}

	public void writeInfo(String value) {
		this.tamanho = value;
//		
//		if (tam != null) {
//			quadro.remove(tam);
//			tam = new VarInteiro(new Point2D.Double(30, yBase + 100),
//					referencia + ".tamanho");
//			tam.setValor(tamanho);
//			quadro.add(tam);
//		} else {
//			tam = new VarInteiro(new Point2D.Double(30, yBase + 100),
//					referencia + ".tamanho");
//			tam.setValor(tamanho);
//			quadro.add(tam);
//		}
		quadro.atualizar();
		
	}

	public Point2D add(Referencia ref) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void remove(Referencia ref) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void add(String ref) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public void desenhar(int yBase){
		this.yBase = yBase;
		
		if (this.ini == null) {
			// desenhar lista vazia "referencia solta"
			if (n == null) {
				this.ref = new Referencia(new Point2D.Double(60, yBase+ espaco
						+ 10), referencia + ".raiz", true);

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
						+ 10), referencia + ".raiz", true);// apontando para
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

			ref = new Referencia(ini, referencia + ".raiz",
					new Point2D.Double(60, yBase + espaco + 10));
			ref.setFixa(true);

			quadro.add(ref);
			quadro.atualizar();
		}

		quadro.atualizar();
	}

	public void adjust(){
		double beforeValueX = this.ini.getPInit().getX();
		this.ini.adjust(this.getPInit());
		this.ini.repintarSetas();
		
		if(this.ini!= null && this.ini.getPInit().getX()!=beforeValueX)
			this.writeField(this.ini, IGEDConst.NODE_TREE_ROOT);
		
	}
	
	public void setInit(NodeTree nt){
		if(this.ini!=null)
			this.ini.remove(this.ref);
		if(n!=null)
			this.quadro.remove(n);
		this.ini = nt;
		this.desenhar(yBase);
	}

	public NodeTree getInit() {
		return ini;
	}
	
	public void setyBase(int yBase) {
		this.yBase = yBase;
	}

	public void setBond(int bond) {
		this.bond = bond;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
		this.desenhar(yBase);
	}

	public boolean isVista() {
		return this.repintado;
	}
	
	public void serVista(boolean vista) {
		this.repintado = vista;
	}
	
	public void setPointPI(Point2D p){
		this.pi = p;
	}

	

}
