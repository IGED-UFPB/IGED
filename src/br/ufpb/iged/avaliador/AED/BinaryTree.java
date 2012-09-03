package br.ufpb.iged.avaliador.AED;

import br.ufpb.iged.IGEDConst;

public class BinaryTree extends Struct{
	
	private NodeTree root;
	private int size = 0;

	public BinaryTree() {
		super(IGEDConst.BINARY_TREE);
	}

	
	public void setSize(int value){
		this.size = value;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public NodeTree getRoot(){
		return this.root;
	}
	
	public void setRoot(NodeTree nt){
		this.root = nt;
	}
	
	
	
	public Node readField(int field) {
		switch(field){
		case IGEDConst.NODE_TREE_ROOT:
			return this.root;
			
		default:
			return null;
		}
	}

	public void writeField(Struct n, int field) {
		if(n instanceof NodeTree){
			NodeTree bt = (NodeTree)n;
			
			switch(field){
			case IGEDConst.NODE_TREE_ROOT:
				this.root = bt;
				break;
			
			}
	
		}
	}

	public void writeInfo(int value) {
		this.size = value;
	
	}

	public int readInfo() {
		return this.size;
	}

	public boolean compare(Struct s) {
		if(s instanceof BinaryTree){
			BinaryTree bt = (BinaryTree)s;
			
			if(this.size == bt.size){
				boolean resultLeftSide = true;
				boolean resultRightSide = true;
				
				NodeTree self = this.root;
				NodeTree nt = bt.root;
				while(self != null && nt != null && resultLeftSide){
					resultLeftSide = self.compare(nt);
					self = self.getLeftChield();
					nt = nt.getLeftChield();
				}
				if(self != null || nt != null)resultLeftSide = false;
				
				self = this.root.getRightChield();
				nt = bt.root.getRightChield();
				while(self != null && nt != null && resultRightSide){
					resultRightSide = self.compare(nt);
					self = self.getRightChield();
					nt = nt.getRightChield();
				}
				if(self != null || nt != null)resultRightSide = false;
				
				return resultLeftSide && resultRightSide;
				
			}
		}
		
		return false;
	}

}
