import iged.IGEDConst;
import iged.grafico.manager.AcaoUsuario;
import iged.grafico.manager.GraphicManager;
import iged.grafico.manager.PaintUI;
import iged.grafico.manager.Quadro;
import iged.grafico.struct.BinaryTree;
import iged.grafico.struct.NodeTree;

import java.awt.geom.Point2D;




public class TesteBinaryTree implements AcaoUsuario{

	/**
	 * @param args
	 */
	
	int passo = 0;
	
	GraphicManager gm = GraphicManager.getInstance();
	
	BinaryTree bt  = new BinaryTree();
	
	NodeTree nt = new NodeTree(new Point2D.Double(150,150));
	NodeTree nt2 = new NodeTree(this.nt.getPBDir());
	NodeTree nt3 = new NodeTree(this.nt2.getPBEsq());
	
	
	
	
	public static void main(String[] args) {
		new TesteBinaryTree().init();

	}
	
	public void pass(){
		
		this.bt.setReferencia("bt");
		Quadro.getInstance().add(bt);
		Quadro.getInstance().atualizar();
	}
	
	public void pass1(){
		this.bt.writeField(nt, IGEDConst.NODE_TREE_ROOT);
		Quadro.getInstance().add(nt);
		Quadro.getInstance().atualizar();
	}
	
	public void pass2(){
		this.bt.readField(IGEDConst.NODE_TREE_ROOT).writeField(nt2, IGEDConst.RIGHT_CHIELD);
		
		
		Quadro.getInstance().add(nt2);
		Quadro.getInstance().atualizar();
	}
	
	public void pass3(){
		// add nt3 como filho à direita do filho à esquerda da raiz
		this.bt.readField(IGEDConst.NODE_TREE_ROOT).readField(IGEDConst.RIGHT_CHIELD)
							.writeField(nt3, IGEDConst.LEFT_CHIELD);
		
		
		Quadro.getInstance().add(nt3);
		Quadro.getInstance().atualizar();
		
	}
	
	public void pass4(){
		/**para ser mais sucinto em comandos, fiz neste e
		 * nos próximos passos, manipulações diretas
		 * com as referencias dos nodes
		 * */
		
		this.bt.adjust();
		Quadro.getInstance().atualizar();
	}
	
	public void pass5(){
		this.nt.writeInfo("6");
		Quadro.getInstance().atualizar();
	}
	
	public void pass6(){
		this.nt.setAltura("0");
		this.nt2.setAltura("1");
		this.nt3.setAltura("2");
		Quadro.getInstance().atualizar();
	}
	
	public void pass7(){
		NodeTree nt4 = new NodeTree(this.nt.getPBEsq());
		this.nt.writeField(nt4, IGEDConst.LEFT_CHIELD);
		nt4.setAltura("1");
		
		Quadro.getInstance().add(nt4);
		Quadro.getInstance().atualizar();
	}
	
	public void pass8(){
		this.bt.adjust();
		
		Quadro.getInstance().atualizar();
	}
	
	@Override
	public void init() {
		
		new PaintUI("IGED-Teste", this);
		
	}

	@Override
	public void color() {
		switch(passo){
			case 0:
				pass();
				break;
			case 1:
				pass1();
				break;
			case 2:
				pass2();
				break;
			case 3:
				pass3();
				break;
			case 4:
				pass4();
				break;
		
			case 5:
				pass5();
				break;
			case 6:
				pass6();
				break;
			case 7:
				pass7();
				break;
			case 8:
				pass8();
				break;
		
		}
		++passo;
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zoom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Quadro getQuadro() {
		
		return Quadro.getInstance();
	}

}
