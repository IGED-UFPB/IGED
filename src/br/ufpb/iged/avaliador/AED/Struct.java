package br.ufpb.iged.avaliador.AED;

public abstract class Struct{

	private int type;

	public Struct(int type){
		this.type = type;
	}

	public boolean equalsType(Struct s){
		return this.type == s.getType();
	}

	public int getType() {
		return type;
	}

	public abstract Node readField(int field);

	public abstract void writeField(Struct n ,int field);

	public abstract void writeInfo(int value);

	public abstract int readInfo();

	public abstract boolean compare(Struct s);
}