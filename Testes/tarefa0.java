public class Main{
	
	public static void main(String args[]) {
		
		Vector a = new Vector(4);
		int b;
		
		for (b = 0; b < a.size; b++)
			a.data[b] = b + 1;
		
		inveterVetor(a);
		
	}
	
	public static void inverterVetor(LVector a) {
		
		int c = a.size - 1;
		int b, d;
		
		for (b = 0; b < (a.size / 2); b++, c--) {		
			d = a.data[c];
			a.data[c] = a.data[b];
			a.data[b] = d;		
		}
		
		
	}
	
}