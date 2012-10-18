import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.grafico.manager.AcaoUsuario;
import br.ufpb.iged.grafico.manager.GraphicManager;
import br.ufpb.iged.grafico.manager.PaintUI;
import br.ufpb.iged.grafico.manager.Quadro;
import br.ufpb.iged.grafico.struct.BinaryTree;
import br.ufpb.iged.grafico.struct.NodeTree;
import br.ufpb.iged.grafico.struct.Vetor;
import br.ufpb.iged.grafico.struct.VetorAdjacencyList;

import java.awt.geom.Point2D;




public class TesteVetor implements AcaoUsuario{

	/**
	 * @param args
	 */
	GraphicManager gm = new GraphicManager();
	int passo = 0;
	
	VetorAdjacencyList al = new VetorAdjacencyList(200, gm.getQuadro());
	
	
	
	
	
	public static void main(String[] args) {
		new TesteVetor().init();

	}
	
	public void pass(){
		al.setSize(4);
		this.al.setNome("al");
		gm.getQuadro().add(al);
		al.repintar();
		gm.getQuadro().atualizar();
	}
	
	public void pass1(){
		al.escrever(2, "bt");
		al.repintar();
		gm.getQuadro().atualizar();
	}
	
	public void pass2(){
		al.remove("vt");
		al.repintar();
		gm.getQuadro().atualizar();
	}
	
//	public void pass3(){
//		// add nt3 como filho à direita do filho à esquerda da raiz
//		this.bt.readField(IGEDConst.NODE_TREE_ROOT).readField(IGEDConst.RIGHT_CHIELD)
//							.writeField(nt3, IGEDConst.LEFT_CHIELD);
//		
//		
//		gm.getQuadro().add(nt3);
//		gm.getQuadro().atualizar();
//		
//	}
//	
//	public void pass4(){
//	
//		
//		this.bt.adjust();
//		gm.getQuadro().atualizar();
//	}
//	
//	public void pass5(){
//		this.nt.writeInfo("6");
//		gm.getQuadro().atualizar();
//	}
//	
//	public void pass6(){
//		this.nt.setHeight("0");
//		this.nt2.setHeight("1");
//		this.nt3.setHeight("2");
//		gm.getQuadro().atualizar();
//	}
//	
//	public void pass7(){
//		NodeTree nt4 = new NodeTree(this.nt.getPBEsq(), gm.getQuadro());
//		this.nt.writeField(nt4, IGEDConst.LEFT_CHIELD);
//		nt4.setHeight("1");
//		
//		gm.getQuadro().add(nt4);
//		gm.getQuadro().atualizar();
//	}
//	
//	public void pass8(){
//		this.bt.adjust();
//		
//		gm.getQuadro().atualizar();
//	}
	
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
//				pass3();
//				break;
//			case 4:
//				pass4();
//				break;
//		
//			case 5:
//				pass5();
//				break;
//			case 6:
//				pass6();
//				break;
//			case 7:
//				pass7();
//				break;
//			case 8:
//				pass8();
//				break;
		
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
