package iged.grafico.struct;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import iged.grafico.geometria.Circulo;
import iged.grafico.geometria.Label;
import iged.grafico.manager.Quadro;

public class NodeTree extends Elemento implements Node{
	
	private int sizeRadius = 30;
	public boolean repintado = false;
	
	private List<Referencia> referencias = new ArrayList<Referencia>();
	private int numRef = -1;
	
	private Circulo circ;
	
	private NodeTree rightChield = null;
	private NodeTree leftChield = null;
	
	private Label valor = null;
	private Seta sRightChield = null;
	private Seta sLeftChield = null;
	
	private Point2D pp; //ponto de incidência do pai
	private Point2D pd; // ponto-marca da direita
	private Point2D pe; // ponto-marca da esquerda
	private Point2D pc; // ponto-marca do centro
	
	/**ponto de incidência da seta da referência para este node*/
	private Point2D pi;

	
	// retorna o ponto base do filho à esquerda
	public Point2D getPBEsq(){
		return new Point2D.Double(this.pb.getX()-(3*this.sizeRadius),this.pb.getY()+(3*this.sizeRadius)); 
	}		
	
	// retorna o ponto base do filho à direita
	public Point2D getPBDir(){
		return new Point2D.Double(this.pb.getX()+(3*this.sizeRadius),this.pb.getY()+(3*this.sizeRadius)); 
	}	
	
	// retorna o ponto de incidência da referência para este node
	public Point2D getPointPI(){
		return this.pi;
	}
	
	
	public NodeTree(Point2D pb){
		super.setPoint(pb);
		
		pp = new Point2D.Double(this.pb.getX(), this.pb.getY()-this.sizeRadius);
		pd = new Point2D.Double(this.pb.getX()+this.sizeRadius, this.pb.getY()+(4*(this.sizeRadius/10)));
		pe = new Point2D.Double(this.pb.getX()-this.sizeRadius, this.pb.getY()+(4*(this.sizeRadius/10)));
		pc = new Point2D.Double(pb.getX() - 13, pb.getY() + 7);
		pi = new Point2D.Double(this.pb.getX()-this.sizeRadius, this.pb.getY());
		
		this.circ = new Circulo(this.pb, sizeRadius);
		this.conteudo.add(circ);
		
		valor = new Label("-",this.pc);
		this.textos.add(valor);
		
	}
	
	public Point2D add(Referencia ref){
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
}

	
	
		//   >> Olhar depois <<
	//----------------------------------------------------------
	public void setSLeftChield(Point2D ppe){
		Seta spe = new Seta(this.pe, new Point2D.Double(ppe.getX(), ppe.getY()-4));
		this.elementos.add(spe);
		Quadro.getInstance().add(spe);
		Quadro.getInstance().atualizar();
	}
	
	public void setSRightChield(Point2D ppd){
		Seta spd = new Seta(this.pd, new Point2D.Double(ppd.getX(), ppd.getY()-4));
		this.elementos.add(spd);
		Quadro.getInstance().add(spd);
		Quadro.getInstance().atualizar();
	}
	
	//--------------------------------------------------
	

		/** Métodos que limpam as setas p/ para os filhos deste nó
		 * 
		 * limpam também os nós filhos
		 * 
		 * */
	//----------------------------------------
	
	public void clearSRightChield(){
	    if(this.sRightChield != null){
	    	this.elementos.remove(this.sRightChield);
	    	Quadro.getInstance().remove(this.sRightChield);
	        this.sRightChield = null;
	        this.rightChield = null;
	    }
	}
	
	public void clearSLeftChield(){
	    if(this.sLeftChield != null){
	    	this.elementos.remove(this.sLeftChield);
	    	Quadro.getInstance().remove(this.sLeftChield);
	    	this.sLeftChield = null;
	        this.leftChield = null;
	    }
	}

	//----------------------------------------
	
	
	public void setRightChield(NodeTree nt){
		if(nt == null){
			this.sRightChield = null;
			return;
		}
		if(this.sRightChield!=null)
			clearSRightChield();
		this.rightChield = nt;
		this.sRightChield = new Seta(this.pd, nt.getPP());
	    this.elementos.add(this.sRightChield);
	    Quadro.getInstance().add(this.sRightChield);
	    Quadro.getInstance().atualizar();
		
	}
	
	public void setLeftChield(NodeTree nt){
		if(nt == null){
			this.sLeftChield = null;
			return;
		}
		if(this.sLeftChield!=null)
			clearSLeftChield();
		this.leftChield = nt;
	    this.sLeftChield = new Seta(this.pe, nt.getPP());
	    this.elementos.add(this.sLeftChield);
	    Quadro.getInstance().add(this.sLeftChield);
	    Quadro.getInstance().atualizar();
		
	}
	
	
	/**Método provisório para repintar as setas dos nós filhos
	 * o método 'seta' novamente os filhos para as novas
	 * coordenadas após a chamada ao 'adjust'
	 * */
	
	public void repintarSetas(){
		if(this.leftChield!=null){
			this.leftChield.repintarSetas();
			this.setLeftChield(this.leftChield);
			
		}
		if(this.rightChield!=null){
			this.rightChield.repintarSetas();
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
		
	}
	
	// seta o label deste node
	public void setValue(String v){
		this.valor.setText(v);
                this.circ.evidencia(Color.red, 4);
        
	}
	
	
	public boolean mover(Point2D np) {
		this.circ.evidencia(Color.red, 4);
		super.mover(np);
		
		return true;
	}
	
	public Point2D getPP(){
		return this.pp;
	}

	
	@Override
	public Point2D getPInit() {
		// TODO Auto-generated method stub
		return null;
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

	
	public static int RC = 1;//right chield
	
	public static int LC = 1;// left chield
	
	@Override
	public void writeField(Struct s, int field) {
		if(field == NodeTree.LC)
			this.setLeftChield((NodeTree)s);
		else if(field == NodeTree.RC)
			this.setRightChield((NodeTree)s);
		
	}
	

	@Override
	public String readInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void writeInfo(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Struct readField(int field) {
		// TODO Auto-generated method stub
		return null;
	}
	
        public void setRepintado(boolean state){
            this.repintado = state;
        }
	

}
