package br.ufpb.iged.avaliador.AED;

import br.ufpb.iged.IGEDConst;

public class NodeTree extends Node {
	
	private NodeTree leftChield;
	private NodeTree rightChield;
	

	public NodeTree() {
		super(IGEDConst.NODE_TREE);
		
	}

	
	public NodeTree getLeftChield() {
		return this.leftChield;
	}

	public void setLeftChield(NodeTree leftChield) {
		this.leftChield = leftChield;
	}

	public NodeTree getRightChield() {
		return this.rightChield;
	}

	public void setRightChield(NodeTree rightChield) {
		this.rightChield = rightChield;
	}

	
	

	public Node readField(int field) {
		switch(field){
		case IGEDConst.LEFT_CHIELD:
			return this.leftChield;
		case IGEDConst.RIGHT_CHIELD:
			return this.rightChield;
		
		default:
			return null;
		}
		
		
	}

	public void writeField(Struct n, int field) {
		if( n instanceof NodeTree){
			NodeTree f = (NodeTree)n;
			
			switch(field){
			case IGEDConst.LEFT_CHIELD:
				this.leftChield = f;
				break;
			case IGEDConst.RIGHT_CHIELD:
				this.rightChield = f;
				break;
			}
		}
	}

	public void writeInfo(int value) {
		this.content = value;
	}

	public int readInfo() {
		return this.content;
	}

	public boolean compare(Struct s) {
		if (s instanceof NodeTree){
			NodeTree nt = (NodeTree)s;
			return this.content == nt.content;
		}
		
		return false;
	}
	

}
