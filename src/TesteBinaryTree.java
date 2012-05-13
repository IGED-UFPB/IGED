import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.grafico.manager.AcaoUsuario;
import br.ufpb.iged.grafico.manager.GraphicManager;
import br.ufpb.iged.grafico.manager.PaintUI;
import br.ufpb.iged.grafico.manager.Quadro;
import br.ufpb.iged.grafico.struct.BinaryTree;
import br.ufpb.iged.grafico.struct.NodeTree;

import java.awt.geom.Point2D;




public class TesteBinaryTree implements AcaoUsuario{

	/**
	 * @param args
	 */
	
	int passo = 0;
	
	GraphicManager gm = new GraphicManager();
	
	BinaryTree bt  = new BinaryTree(gm.getQuadro());
	
	NodeTree nt = new NodeTree(new Point2D.Double(150,150), gm.getQuadro());
	NodeTree nt2 = new NodeTree(this.nt.getPBDir(), gm.getQuadro());
	NodeTree nt3 = new NodeTree(this.nt2.getPBEsq(), gm.getQuadro());
	
	
	
	
	public static void main(String[] args) {
		new TesteBinaryTree().init();

	}
	
	public void pass(){
		
		this.bt.setReferencia("bt");
		gm.getQuadro().add(bt);
		gm.getQuadro().atualizar();
	}
	
	public void pass1(){
		this.bt.writeField(nt, IGEDConst.NODE_TREE_ROOT);
		gm.getQuadro().add(nt);
		gm.getQuadro().atualizar();
	}
	
	public void pass2(){
		this.bt.readField(IGEDConst.NODE_TREE_ROOT).writeField(nt2, IGEDConst.RIGHT_CHIELD);
		
		
		gm.getQuadro().add(nt2);
		gm.getQuadro().atualizar();
	}
	
	public void pass3(){
		// add nt3 como filho à direita do filho à esquerda da raiz
		this.bt.readField(IGEDConst.NODE_TREE_ROOT).readField(IGEDConst.RIGHT_CHIELD)
							.writeField(nt3, IGEDConst.LEFT_CHIELD);
		
		
		gm.getQuadro().add(nt3);
		gm.getQuadro().atualizar();
		
	}
	
	public void pass4(){
		/**para ser mais sucinto em comandos, fiz neste e
		 * nos próximos passos, manipulações diretas
		 * com as referencias dos nodes
		 * */
		
		this.bt.adjust();
		gm.getQuadro().atualizar();
	}
	
	public void pass5(){
		this.nt.writeInfo("6");
		gm.getQuadro().atualizar();
	}
	
	public void pass6(){
		this.nt.setAltura("0");
		this.nt2.setAltura("1");
		this.nt3.setAltura("2");
		gm.getQuadro().atualizar();
	}
	
	public void pass7(){
		NodeTree nt4 = new NodeTree(this.nt.getPBEsq(), gm.getQuadro());
		this.nt.writeField(nt4, IGEDConst.LEFT_CHIELD);
		nt4.setAltura("1");
		
		gm.getQuadro().add(nt4);
		gm.getQuadro().atualizar();
	}
	
	public void pass8(){
		this.bt.adjust();
		
		gm.getQuadro().atualizar();
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
		
		return gm.getQuadro();
	}

}
