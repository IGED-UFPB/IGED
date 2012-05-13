
import br.ufpb.iged.grafico.manager.AcaoUsuario;
import br.ufpb.iged.grafico.manager.PaintUI;
import br.ufpb.iged.grafico.manager.Quadro;
import br.ufpb.iged.grafico.struct.NodeTree;
import java.awt.geom.Point2D;


public class MainTree implements AcaoUsuario {

		int count = 0;
	    private Quadro quadro;
	    
	    private Point2D pi = new Point2D.Double(40, 400);	//ponto inicial para os nós no quadro
	    
	    private Point2D pbTree = new Point2D.Double(100,100);// ponto base, o nó mais alto(raiz) terá y=100
	    																// o nó mais à esquerda terá  x=100
	    NodeTree node =  null;
	    NodeTree node2 = null;
	    NodeTree node3 = null;
	    NodeTree node4 = null;
	    NodeTree node5 = null;
	    NodeTree node6 = null;
	    NodeTree node7 = null;
	    
	    
	    public MainTree(){
	    	this.quadro = Quadro.getInstance();
	    	
	    }
	    
	    	


		public Quadro getQuadro(){
			return quadro;
		}


	    
		public void init(){
			new PaintUI("IGED V0.1", this);
		}
	    
	    
	    
	    @Override
	    public void color() {
	    
		    
	    	switch (count){
	    	case 0:
	    		passo0();
	    		break;
	    	case 1:
	    		passo1();
	    		break;
	    	case 2:
	    		passo2();
	    		break;
	    	case 3:
	    		passo3();
	    		break;
	    	case 4:
	    		passo4();
	    		break;
	    	case 5:
	    		passo5();
	    		break;
	    	case 6:
	    		passo6();
	    		break;
	    	case 7:
	    		passo7();
	    		break;
	    	case 8:
	    		passo8();
	    		break;
	    	case 9:
	    		passo9();
	    		break;
	    	case 10:
	    		passo10();
	    		break;
	    	case 11:
	    		passo11();
	    		break;
	    	case 12:
	    		passo12();
	    		break;
	    	case 13:
	    		passo13();
	    		break;
	    	case 14:
	    		passo14();
	    		break;
	    	case 15:
	    		passo15();
	    		break;
	    	case 16:
	    		passo16();
	    		break;
	    	case 17:
	    		passo17();
	    		break;
	    	case 18:
	    		passo18();
	    		break;
	    	case 19:
	    		passo19();
	    		break;
	    	case 20:
	    		passo20();
	    		break;
	    	case 21:
	    		passo21();
	    		break;
	    	}
	    	
	    	this.count++;
	    }
	    
	   public void passo0(){
		   node = new NodeTree(this.pi);
	    	
		   this.quadro.add(node);
		   this.quadro.atualizar();
	    }
	    
	   public void passo1(){
		   node.adjust(this.pbTree);
	    	
		   this.quadro.atualizar();
	  }
	    
	    
	    
	   public void passo2(){
		   node.setValue("12");
	    	
		   this.quadro.atualizar();
	   }
	    
	   public void passo3(){
		   node2 = new NodeTree(pi);
		   
		   this.quadro.add(node2);
		   this.quadro.atualizar();
		   
	   }
	   
	   public void passo4(){
		   node.setRightChield(node2);
		   
		   this.quadro.atualizar();
	   }
	   
	   public void passo5(){
		   node.adjust(this.pbTree);
		   node.repintarTracos();
		   this.quadro.atualizar();
		   
		   }
	   
	   public void passo6(){
		   //node.repintarSetas();
		   node3 = new NodeTree(pi);
		 
		   this.quadro.add(node3);
		   this.quadro.atualizar();
	   }
	   
	   public void passo7(){
		   node.setLeftChield(node3);
		   
		   this.quadro.atualizar();
	   }
	   
	   public void passo8(){
		   node.adjust(this.pbTree);
		   node.repintarTracos();
		  
		   this.quadro.atualizar();
		   	  
		  
	   }
	   
	   public void passo9(){
		   //node.repintarSetas();
		   node4 = new NodeTree(pi);
			 
		   this.quadro.add(node4);
		   this.quadro.atualizar();
		   }
	   
	   public void passo10(){
		   node3.setRightChield(node4);
		   
		   this.quadro.atualizar();
	   }
	    
	   public void passo11(){
		   node.adjust(this.pbTree);
		   node.repintarTracos();
		   this.quadro.atualizar();
		   
		  
	   }
	   
	   public void passo12(){
		   //node.repintarSetas();
		   node5 = new NodeTree(pi);
			 
		   this.quadro.add(node5);
		   this.quadro.atualizar();
		   }
	   
	   public void passo13(){
		   node4.setRightChield(node5);
		   
		   this.quadro.atualizar();
	   }
	    
	   public void passo14(){
		   node.adjust(this.pbTree);
		   node.repintarTracos();
		   this.quadro.atualizar();
		   
		   
	   }

	   public void passo15(){
		   //node.repintarSetas();
		   node6 = new NodeTree(pi);
			 
		   this.quadro.add(node6);
		   this.quadro.atualizar();
		   }
	   
	   public void passo16(){
		   node4.setLeftChield(node6);
		   
		   this.quadro.atualizar();
	   }
	    
	   public void passo17(){
		   node.adjust(this.pbTree);
		   node.repintarTracos();
		   this.quadro.atualizar();
		   
	   }
	   
	   public void passo18(){
		   //node.repintarSetas();
		   node7 = new NodeTree(pi);
		   
		   this.quadro.add(node7);
		   this.quadro.atualizar();
	   }
	   
	   public void passo19(){
		   node3.setLeftChield(node7);
		   
		   this.quadro.atualizar();
	   }
	    
	   public void passo20(){
		   node.adjust(this.pbTree);
		   node.repintarTracos();
		   this.quadro.atualizar();
		   
	   }
	   
	   public void passo21(){
		   //node.repintarSetas();
	   }
	   
	  
	   
	   
		@Override
		public void zoom() {
			// TODO Auto-generated method stub
			
		}

		public static void main(String[] args) {
			new MainTree().init();
		}

		@Override
		public void move() {
			// TODO Auto-generated method stub
			
		}
	    	


	

}
