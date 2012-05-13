package br.ufpb.iged.avaliador.AED;

public class Vector extends Struct {

	private int[]vet ;
	private int pos = 0;
	
	
	public Vector(int length){
		super(1);
		vet = new int[length];
	}
	
	public int read(int index)throws ArrayIndexOutOfBoundsException{
		return vet[index];
	} 
	
	public boolean write(int index, int value){
		try{
			vet[index] = value;
			return true;
		}catch (ArrayIndexOutOfBoundsException ae) {
			return false;
		}
	}
	
	public int getLength(){
		return vet.length;
	}


	public boolean compare(Struct o){
		if(!(o instanceof Vector))
                    return false;
                Vector v = ((Vector)o);
		if(this.vet.length == v.vet.length ){
			int pos = 0;
			for(int i: vet){
				if(i != v.vet[pos]){
					return false;
				}
				pos++;
			}
		}else {
			return false;
		}
		return true;
	}

	@Override
	public Node readField(int field) {
		return null;
	}

	@Override
	public void writeField(Struct n, int field) {
	}

	@Override
	public void writeInfo(int value) {
		vet[pos] = value;
	}

	@Override
	public int readInfo() {
		return vet[pos];
	}
	
	public void setField(int pos){
		this.pos = pos;
	}
	
	
}
