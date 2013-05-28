public class Lista {
	
	
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
	
	public static void removerNo(List a, int b){
		
		if (a.init == null)
			return;
		
		if (b > a.size)
			return
		
		NodeList c = a.init;
		
		if (b == 0){		
			a.init = c.next;
			c.next = null;
			return;
		}
				
		for (int d = 0; d < (b - 2); d++)
			c = c.next;
		
		NodeList e = c.next;
		c.next = c.next.next;
		e.next = null;
		
		
	}
	
	
	
}