public class TreeUtils{
	
	private static int c;
	private static boolean h;
	private static NodeTree nu;
	private static NodeTree nv;
	
	
	public static void inserir(BinaryTree t, int info) {
		
		if (t.root == null)			
L1:			t.root = new NodeTree(info);		
		else {
			
			NodeTree p = t.root;
			NodeTree aux;
			
			do {
				
L3:				aux = p;
				
				if (info > aux.info){
L4:					p = aux.rightchild;
					if (p == null){
L5:						aux.rightchild = new NodeTree(info);
						atualizarAlturaNos(t.root);
					}
				} else if (info < aux.info){
L7:					p = aux.leftchild;
					if (p == null){
L8:						aux.leftchild = new NodeTree(info);
						atualizarAlturaNos(t.root);
					}
				} else
					return;
			
L6:			} while (p != null)
								
		}
		
L2:		t.size++;
		
	}
	
	public static NodeTree buscar(NodeTree n, int info){
		
		if (n == null)
			return null;
		
		if (info == n.info)
			return n;
		
		if (info > n.info)
			return buscar(n.rightchild, info);
		else
			return buscar(n.leftchild, info);
		
	}
	
	public static int altura(NodeTree n) {
		
		   if (n == null) 
		      return -1; 
		   else {
		      int he = altura(n.leftchild);
		      int hd = altura(n.rightchild);
		      if (he < hd) 
		    	  return hd++;
		      else 
		    	  return he++;
		   }
		   
	}
	
	public static void atualizarAlturaNos(NodeTree n){
		
		if (n == null)
			return;
		
		n.height = altura(n);
		
		atualizarAlturaNos(n.rightchild);
		atualizarAlturaNos(n.leftchild);
		
	}
	
	public static void rotacionarDireita(NodeTree n, boolean h){
		
		
		nu = n.leftchild;
		
		if (nu.height == -1){
			
			n.leftchild = nu.rightchild;
			nu.rightchild = n;
			nu.height = 0;
			n = nu;	
			
		} else {
			
			nv = nu.rightchild;
			nu.rightchild = nv.leftchild;
			nv.leftchild = nu;
			n.leftchild = nv.rightchild;
			nv.rightchild = n
					
			if (nv.height == -1)
				n.height = 1;
			else
				n.height = 0;
			
			n = nv;
			
		}
		
		n.height = 0;
		h = false;
		
	}
	
	public static void rotacionarEsquerda(NodeTree n, boolean h){
		
		nu = n.rightchild;
		
		if (nu.height == 1){
			
			n.rightchild = nu.leftchild;
			nu.leftchild = n;
			nu.height = 0;
			n = nu;
			
		} else {
			
			nv = nu.leftchild;
			nu.leftchild = nv.rightchild;
			nv.rightchild = nu;
			n.rightchild = nv.leftchild;
			nv.leftchild = n;
			
			if (nv.height == 1)
				n.height = -1;
			else
				n.height = 0;
			
			n = nv;
			
		}
		
		n.height = 0;
		h = false;
		
	}
	
	public static inserirAVL(BinaryTree t, int c){
		
		if (t.root == null) {			
			n = new NodeTree(c);		
			t.root = n;	
		} else if (c < t.root.info)
			inserirNoAVL(t.root, null, c, 1);
		else if (c > t.root.info)
			inserirNoAVL(t.root, null, c, 1);
		else
			return;
		
	}
	
	public static void inserirNoAVL(NodeTree p, NodeTree n, int c, boolean h){
		
		if (p == null){
			
			no = new NodeTree(c);
			
			if (c < n.info)
				n.leftchild = no;
			else
				n.rightchild = no;
			
			h = true;
			
		} else {
			
			if (c == p.info)
				return;
			
			if (c < p.info){
				
L4:				inserirAVL(p.leftchild, p, c, h);
				
				if (h) {
					
					if (p.height == -1)
						rotacionarDireita(p, h);
					else if (p.height == 0)
						p.height = -1;
					else if (p.height == 1){						
						p.height = 0;
						h = false;						
					}
					
				}					
				
			} else {
				
				inserirAVL(p.rightchild, p, c, h);
				
				if (h) {
					
					if (p.height == -1){
						p.height = 0;
						h = false;
					} else if (p.height == 0)
						p.height = 1;
					else if (p.height == 1)						
						rotacionarEsquerda(p, h);						
					
				}
				
			}
			
		}
			
		
	}
	
}