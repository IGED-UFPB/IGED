public class Main{
	
	public static void main(String args[]) {
		
		List a = new List();
		
		preencherLista(5);
			
		
	}
	
	public static void preencherLista(Lista a, int b) {
		
		NodeList c = new NodeList(10);
		a.init = c;
		a.size = 1;
		
		NodeList d = a.init
		
		for (int e = 1; e < b; e++){			
			c = new NodeList((e + 1) * 10);
			d.next = c;
			a.size++;
			d = d.next;			
		}
		
	}
	
}