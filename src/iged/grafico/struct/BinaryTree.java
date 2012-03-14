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
	
	
	private NodeTree ini = null;
	private Label l;
	private Null n;
	
	
	private Quadro quadro = Quadro.getInstance();
	
	private int yBase = 0;
	private int bond = 100;
	private int espaco = 85;
	
	private String referencia;
	private String tamanho = "0";

	public BinaryTree(){
		this.type = IGEDConst.BINARY_TREE;

		this.pi = new Point2D.Double(150, 150);
	}
	
    @Override
	public Point2D getPInit() {
		return this.pi;
	}
	
    @Override
	public int getBond() {
		return this.bond;
	}
	
    @Override
	public void repintar() {
    	if(this.ini !=null)
			this.adjust();
    	
		this.desenhar(yBase);
		NodeTree n1 = this.ini;

		if(n1!=null && !n1.isRepintado())
			n1.repintar();
		
		this.repintado = true;
		
		
		
	}

	public boolean isRepintado() {
		return this.repintado;
	}
	
	public void startRepaint() {
		this.repintado = false;
		
		if(this.ini!=null){
		
		NodeTree n1 = this.ini;
		/**Essa chamada será feita para a referência de nodetree desta classe
		 * de forma recursiva, na classe nodetree, será feita para os filhos à direita e 
		 * à esquerda de n1.
		 * */
		n1.startRepaint();
		}
		
		
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

	public void add(String ref) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public void desenhar(int yBase){
		this.yBase = yBase;
		
		if (this.ini == null) {
			// desenhar lista vazia "referencia solta"
			if (n == null) {
				this.ref = new Referencia(new Point2D.Double(60, yBase+ espaco
						+ 10), referencia + ".raiz");
				
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
						+ 10), referencia + ".raiz");// apontando para
																// null
				
				n = new Null(new Point2D.Double(
						120 + (7 * referencia.length()), yBase + espaco + 5),true);
				
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
					new Point2D.Double(60, yBase+ espaco+ 10));
			ref.setFixa(false);
			
			quadro.add(ref);
			//quadro.atualizar();
		}

		quadro.atualizar();
		System.out.println("ds");
	}

	public void adjust(){
		if(this.ini!=null){
			this.ini.adjust(this.getPInit());
			this.ini.repintarTracos();
		}
	}
	
	public void setInit(NodeTree nt){
		if((this.ini!=null)&&(this.ref !=null))
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
