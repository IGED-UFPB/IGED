package iged.AED;

public abstract class Node extends Struct{

	protected int content;
	
	public Node(int type){
                super(type);
	}
	
	public int getContent(){
		return content;
	}
	
	public void setContent(int content){
		this.content = content;
	}
	
}
