public class Main{
	
	public static void main(String args[]) {
		
		List a = new List();
		
		preencherLista(a, 5);
		
		inverterLista(a);
			
		
	}
	
	public static void preencherLista(List a, int b) {
		
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
	
	public static void inverterLista(List a) {
		
		NodeList b = a.init;
		
		while(b.next != null)
			b = b.next;
		
		NodeList c = a.init;
		
		while (c != b) {
			
			a.init = c.next;
			c.next = b.next;
			b.next = c;
			c = a.init;
			
		}
				
		
	}
		
}