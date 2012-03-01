package iged.grafico.manager;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iged.grafico.struct.VarInteiro;


public class VarInteiroManager {

	private Quadro quadro = Quadro.getInstance();
	
	private Map<String , VarInteiro> ints =  new HashMap<String , VarInteiro>();
	private List<VarInteiro> lista = new ArrayList<VarInteiro>();
	private VarInteiro reg = null;
	private int x = 20;
	private int y = 5;
	private int dis = 10;
	private static VarInteiroManager vim = null;
	
	private VarInteiroManager(){}
	
	public static VarInteiroManager getInstance(){
		if(vim == null){
			vim = new VarInteiroManager();
		}
		return vim;
	}
	
	public void createVarInteiro(String referencia){
		atualizarX();
		this.reg = new VarInteiro(new Point2D.Double(x+ (dis*lista.size()), y),referencia);
		this.ints.put(referencia, reg);
		this.lista.add(reg);
		quadro.add(this.reg);
		quadro.atualizar();
	}
	
	public void setValor(String referencia,String valor){
		try{
			this.ints.get(referencia).setValor(valor);
			quadro.atualizar();
		}catch (NullPointerException e) {
		}
	}
	
	public void ler(String referencia){
		try{
			this.ints.get(referencia).ler();
		}catch (NullPointerException e) {
		}
	}
	
	public void remover(String referencia){
		try{
			VarInteiro vi = this.ints.remove(referencia);
			this.quadro.remove(vi);
			this.quadro.atualizar();
			int l = this.lista.indexOf(vi);
			this.lista.remove(l);
			for(int i = l ; i<lista.size() ; i++){
				VarInteiro aux = this.lista.get(i);
				aux.mover(new Point2D.Double(((VarInteiro.LARGURA*i) + 20 + (dis*i)), y));
			}
			
		}catch (NullPointerException e) {
		}
	}
	
	
	
	
	private void atualizarX(){
		if(!ints.isEmpty()){
			if(ints.size() == 0){
				x= 20 + VarInteiro.LARGURA;
			}else{
				x = (VarInteiro.LARGURA*ints.size()) + 20 ;
			}
		}
	}
	
	public void repintar(){
		for(VarInteiro vi : lista){
			quadro.add(vi);
		}
	}
	public static final int SPACE  = 100;
	
}
