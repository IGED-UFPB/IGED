package iged.grafico.struct;

import java.awt.Color;
import java.awt.geom.Point2D;


import iged.IGEDConst;
import iged.grafico.geometria.Circulo;
import iged.grafico.geometria.Label;
import iged.grafico.manager.Quadro;

public class NodeTree extends Node{
	
	private int sizeRadius = 30;
	
	private Circulo circ;
	
	private NodeTree rightChield = null;
	private NodeTree leftChield = null;
	
	private Label valor = null;
	private Label altura = null;
	private Traco tracoRightChield = null;
	private Traco tracoLeftChield = null;
	
	private Point2D pp; //ponto de incidência do pai
	private Point2D pd; // ponto-marca da direita
	private Point2D pe; // ponto-marca da esquerda
	private Point2D pc; // ponto-marca do centro
	private Point2D ph; // ponto-marca do label altura no node
	
	
	// retorna o ponto base do filho à esquerda
	public Point2D getPBEsq(){
		return new Point2D.Double(this.pb.getX()-(3*this.sizeRadius),this.pb.getY()+(3*this.sizeRadius)); 
	}		
	
	// retorna o ponto base do filho à direita
	public Point2D getPBDir(){
		return new Point2D.Double(this.pb.getX()+(3*this.sizeRadius),this.pb.getY()+(3*this.sizeRadius)); 
	}	
	
	public void setAltura(String h){
		this.altura.setText(h);
        this.repintar();
		
	}
	
		
	public NodeTree(Point2D pb){
		super.setPoint(pb);
                this.type = IGEDConst.NODE_TREE;
		
		pp = new Point2D.Double(this.pb.getX(), this.pb.getY()-this.sizeRadius);
		pd = new Point2D.Double(this.pb.getX()+this.sizeRadius, this.pb.getY()+(4*(this.sizeRadius/10)));
		pe = new Point2D.Double(this.pb.getX()-this.sizeRadius, this.pb.getY()+(4*(this.sizeRadius/10)));
		pc = new Point2D.Double(pb.getX() - 13, pb.getY() + 7);
		pi = pp;
		ph = new Point2D.Double(this.pb.getX()+this.sizeRadius, this.pb.getY()-this.sizeRadius);
                pr = new Point2D.Double(this.pb.getX()-70,(this.pb.getY()-45));
		
		this.circ = new Circulo(this.pb, sizeRadius);
		this.conteudo.add(circ);
		
		valor = new Label("-",this.pc);
		altura = new Label(" ",this.ph);
		this.textos.add(valor);
		this.textos.add(altura);
		
	}
	
	/*public Point2D add(Referencia ref){
		if(!this.referencias.contains(ref) ){
			this.referencias.add(ref);
	       		
	    }
	    if(!ref.isFixa()){
	    	++this.numRef;
	    	
	    }
	    return new Point2D.Double(this.pb.getX()-70,((this.pb.getY()-45) -(15*numRef)));
        }
	
	public void remove(Referencia ref){
            if(this.referencias.contains(ref)){
			int j = this.referencias.indexOf(ref);
        	this.numRef = j - 1;
        	this.referencias.remove(ref);

            for(int i = j; i<this.referencias.size(); ++i){
                    this.referencias.get(i).config(this);
            }
        }
}*/

	
	
		//   >> Olhar depois <<
	//----------------------------------------------------------
	public void setTracoLeftChield(Point2D ppe){
		Traco spe = new Traco(this.pe, new Point2D.Double(ppe.getX(), ppe.getY()-4), false);
		this.elementos.add(spe);
		Quadro.getInstance().add(spe);
		Quadro.getInstance().atualizar();
	}
	
	public void setTracoRightChield(Point2D ppd){
		Traco spd = new Traco(this.pd, new Point2D.Double(ppd.getX(), ppd.getY()-4), false);
		this.elementos.add(spd);
		Quadro.getInstance().add(spd);
		Quadro.getInstance().atualizar();
	}
	
	//--------------------------------------------------
	

		/** Métodos que limpam as tracos p/ para os filhos deste nó
		 * 
		 * limpam também os nós filhos
		 * 
		 * */
	//----------------------------------------
	
	public void clearTracoRightChield(){
	    if(this.tracoRightChield != null){
	    	this.elementos.remove(this.tracoRightChield);
	    	Quadro.getInstance().remove(this.tracoRightChield);
	        this.tracoRightChield = null;
	        this.rightChield = null;
	    }
	}
	
	public void clearTracoLeftChield(){
	    if(this.tracoLeftChield != null){
	    	this.elementos.remove(this.tracoLeftChield);
	    	Quadro.getInstance().remove(this.tracoLeftChield);
	    	this.tracoLeftChield = null;
	        this.leftChield = null;
	    }
	}

	//----------------------------------------
	
	
	public void setRightChield(NodeTree nt){
		if(nt == null){
			this.tracoRightChield = null;
			return;
		}
		if(this.tracoRightChield!=null)
			clearTracoRightChield();
		this.rightChield = nt;
		this.tracoRightChield = new Traco(this.pd, nt.getPP(), false);
	    this.elementos.add(this.tracoRightChield);
	    Quadro.getInstance().add(this.tracoRightChield);
	    Quadro.getInstance().atualizar();
		
	}
	
	public void setLeftChield(NodeTree nt){
		if(nt == null){
			this.tracoLeftChield = null;
			return;
		}
		if(this.tracoLeftChield!=null)
			clearTracoLeftChield();
		this.leftChield = nt;
	    this.tracoLeftChield = new Traco(this.pe, nt.getPP(), false);
	    this.elementos.add(this.tracoLeftChield);
	    Quadro.getInstance().add(this.tracoLeftChield);
	    Quadro.getInstance().atualizar();
		
	}
	
	
	/**Método provisório para repintar os tracos dos nós filhos
	 * o método 'seta' novamente os filhos para as novas
	 * coordenadas após a chamada ao 'adjust'
	 * */
	
	public void repintarTracos(){
		if(this.leftChield!=null){
			this.leftChield.repintarTracos();
			this.setLeftChield(this.leftChield);
			
		}
		if(this.rightChield!=null){
			this.rightChield.repintarTracos();
			this.setRightChield(this.rightChield);
			
		}
	}
	
	public Point2D adjust(Point2D p){
//		NodeTree nt = this;
		
		Point2D np = p;
		
		if(this.leftChield != null){
			np = this.leftChield.adjust(new Point2D.Double(np.getX(), np.getY()+(3*this.sizeRadius)));
		}
		
		
		
		this.mover(np);
		atualizar();

		if(this.rightChield != null){
			Point2D aux = this.rightChield.adjust(new Point2D.Double(np.getX()+(3*this.sizeRadius),
					np.getY()+(3*this.sizeRadius)));
			
			if(aux.getY()==np.getY())
				return new Point2D.Double(aux.getX(),aux.getY()-(3*this.sizeRadius));
			return aux;
		}else
			return new Point2D.Double(np.getX()+(3*this.sizeRadius), np.getY()-(3*this.sizeRadius));
		
	}
	
	/**Após recalculado as cordenadas dos nós
	 * este método atualiza o 
	 * ponto do pai, ponto direito, ponto esquerdo e 
	 * ponto central
	 * */
	
	public void atualizar(){
		this.pp = new Point2D.Double(this.pb.getX(), this.pb.getY()-this.sizeRadius);
		this.pd = new Point2D.Double(this.pb.getX()+this.sizeRadius, this.pb.getY()+(4*(this.sizeRadius/10)));
		this.pe = new Point2D.Double(this.pb.getX()-this.sizeRadius, this.pb.getY()+(4*(this.sizeRadius/10)));
		this.pc = new Point2D.Double(pb.getX() - 13, pb.getY() + 7);
		this.pi = new Point2D.Double(this.pb.getX()-this.sizeRadius, this.pb.getY());
		this.ph = new Point2D.Double(this.pb.getX()+this.sizeRadius, this.pb.getY()-this.sizeRadius);
		this.pr = new Point2D.Double(this.pb.getX()-70,(this.pb.getY()-45));
	}
	
	
	// seta o label deste node
	public void setValue(String v){
		this.valor.setText(v);
                this.circ.evidencia(Color.red, 4);
        
	}
	
	
	public boolean mover(Point2D np) {
		super.mover(np);
                               
		return true;
	}
	
	public Point2D getPP(){
		return this.pp;
	}

	
	@Override
	public Point2D getPInit() {
		return this.pi;
	}

	
	@Override
	public int getBond() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public void repintar() {
		if(!this.repintado){
			
			Quadro.getInstance().add(this);
			this.repintado = true;
			
			if(this.leftChield!=null)
				this.leftChield.repintar();
			if(this.rightChield!=null)
				this.rightChield.repintar();
		}
		
	}

	
	@Override
	public boolean isRepintado() {
		return this.repintado;
	}

	
	@Override
	public void startRepaint() {
		this.repintado = false;
		
		if(this.leftChield!=null)
			this.leftChield.startRepaint();
		
		if(this.rightChield!=null)
			this.rightChield.startRepaint();
	}

	@Override
	public void writeField(Struct s, int field) {
		if(field == IGEDConst.LEFT_CHIELD)
			this.setLeftChield((NodeTree)s);
		else if(field == IGEDConst.RIGHT_CHIELD)
			this.setRightChield((NodeTree)s);
		
	}
	

	@Override
	public String readInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void writeInfo(String value) {
		this.circ.evidencia(Color.red, 4);
		this.valor.setText(value);
        this.repintar();
		
	}

	@Override
	public Struct readField(int field) {
		switch(field){
			case IGEDConst.RIGHT_CHIELD:
				return this.rightChield;
			case IGEDConst.LEFT_CHIELD:
				return this.leftChield;
				
			default:
				return null;
		}
	}
	
        public void setRepintado(boolean state){
            this.repintado = state;
        }
}
