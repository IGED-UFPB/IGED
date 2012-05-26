package br.ufpb.iged.avaliador.AED;

import br.ufpb.iged.IGEDConst;

public class LinkedListNode extends Node{

	private LinkedListNode next;

	public LinkedListNode() {
		super(IGEDConst.NODE);
	}

	public void setNext(LinkedListNode nodeNext){
		this.next = nodeNext;
	}

	public LinkedListNode next(){
		return this.next;
	}

	@Override
	public Node readField(int field) {

		switch(field){

			case IGEDConst.NODE_PROX:

				return this.next;


			default:
				break;

		}
		return null;
	}

	@Override
	public void writeField(Struct n, int field) {
		if(field == IGEDConst.NODE_PROX){
			this.next = (LinkedListNode)n;
		}
	}

    @Override
	public boolean compare(Struct node){
                if(node instanceof LinkedListNode)
                    return content == ((LinkedListNode)node).getContent();
                else
                    return false;
	}

	@Override
	public void writeInfo(int value) {
		this.content = value;

	}

	@Override
	public int readInfo() {
		return this.content;
	}

}