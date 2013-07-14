public class Main{
	
	private static Vector vetor;
	
	public static void main(String args[]) {
		
		vetor = new Vector(4);
		int b;
		
		for (b = 0; b < vetor.size; b++)
			vetor.data[b] = b + 1;
		
		inveterVetor();
		
	}
	
	public static void inverterVetor() {
		
		int c = vetor.size - 1;
		int b, d;
		
		for (b = 0; b < (vetor.size / 2); b++, c--) {		
			d = vetor.data[c];
			vetor.data[c] = vetor.data[b];
			vetor.data[b] = d;		
		}
		
		
	}
	
}