public class TreeUtils{
	
	public static void inserir(BinaryTree t, int info) {
		
		NodeTree n;
		
		if (t.root == null) {			
L1:			n = new NodeTree(info);		
			t.root = n;			
		} else {
			
			NodeTree p = t.root;
			NodeTree aux;
			
			do {
				
L3:				aux = p;
				
				if (info > aux.info){
L4:					p = aux.rightchild;
					if (p == null){
L5:						n = new NodeTree(info);
						aux.rightchild = n;
						atualizarAlturaNos(t.root);
					}
				} else if (info < aux.info){
L7:					p = aux.leftchild;
					if (p == null){
L8:						n = new NodeTree(info);
						aux.leftchild = n;
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
	
}