/**
 * 
 */
package br.ufpb.iged.grafico.struct;

import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.grafico.geometria.Label;
import br.ufpb.iged.grafico.manager.Quadro;

import java.awt.geom.Point2D;

/**
 * @author Smith
 *
 */
public class BinaryTree extends Struct{
		/**desta forma quando criamos uma estrutura do tipo bt
		 * a sua coordenada x � X_INIT + "espa�o entre estruturas", que por sua vez � igual a 250
		 * assim a coordenada x inicial ser� 150 (o valor que desejamos)
		 * ou seja, igual ao X_BOUND que � o limite da coordenada x inicial */
		public static double X_INIT = -100;
        public static double X_BOUND = 150;
	
	private NodeTree ini = null;
	
	private Label size;
	private Null n;
	
	private int yBase = 0;
	private int bond = 100;
	private int space = 85;
	
	private String referencia;
	private String tamanho = "0";
	
	/**Representam o deslocamento, para ajustar o label 'size', nos eixos x e y no momento em que a BinaryTree � criada
	 * quando ainda n�o possui elementos*/
	private int sprainXInit = 90;
	private int sprainYInit = 75;
	
	/**Deslocamento nos eixos x e y quando a BT j� possui elementos*/
	private int sprainX = 28;
	private int sprainY = 20;
	
	
	
	public BinaryTree(Quadro q, double xCoord){
            super(q);
            this.type = IGEDConst.BINARY_TREE;
            this.pi = new Point2D.Double(xCoord, q.YBASE+150);
            
            this.size = new Label(this.referencia+".size = "+this.tamanho, 
            		new Point2D.Double(pi.getX()-this.sprainXInit,pi.getY()-this.sprainYInit));
            this.textos.add(this.size);
	}
	
	public BinaryTree(Quadro q){
        this(q,150);
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
		this.desenhar(yBase);
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
			System.out.println(">>>>>> tá entrando aki");
			// desenhar lista vazia "referencia solta"
			
			double xPosition = this.pi.getX()-40;
			
			if (n == null) {
				this.ref = new Referencia(new Point2D.Double(this.pi.getX()-90, yBase+ space
						+ 10), referencia + ".raiz", quadro);
				
				n = new Null(new Point2D.Double(
						xPosition + (7 * referencia.length()), yBase + space + 5),
						true, this.quadro);// apontando para null
				
//				n = new Null(new Point2D.Double(
//						120 + (7 * referencia.length()), yBase + space + 5),
//						true, this.quadro);// apontando para null
				
				quadro.add(n);
				quadro.add(ref);
				quadro.atualizar();
			} else {
				quadro.remove(ref);
				quadro.remove(n);
				
				this.ref = new Referencia(new Point2D.Double(this.pi.getX()-90, yBase + space
						+ 10), referencia + ".raiz", quadro);// apontando para
																// null
				
				n = new Null(new Point2D.Double(
						xPosition + (7 * referencia.length()), yBase + space + 5),true, this.quadro);
				
				quadro.add(n);
				quadro.add(ref);
				quadro.atualizar();
			}
			this.size.mover(new Point2D.Double(pi.getX()-this.sprainXInit,pi.getY()-this.sprainYInit));
			
		} else {

			if (n != null) {
				quadro.remove(n);
				n = null;
			}
			if (ref != null) {
				quadro.remove(ref);
				ini.remove(ref);
			}
			
			
			ref = new Referencia(ini, referencia + ".raiz", quadro);
			
//			ref = new Referencia(ini, referencia + ".raiz",
//					new Point2D.Double(60, yBase+ espaco+ 10), quadro);
			ref.setFixa(true);
			
			this.size.mover(new Point2D.Double(this.ref.getPB().getX()-this.sprainX,
					this.ref.getPB().getY()-this.sprainY));
			
			quadro.add(ref);
			//quadro.atualizar();
		}
		
		this.size.setText(this.referencia+".size = "+this.tamanho);
		
		quadro.add(this.size);
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
		this.desenhar(yBase);
	}

	

}
