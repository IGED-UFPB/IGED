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
L5:						if (aux.leftchild == null)
L6:							aux.height++;
L7:						n = new NodeTree(info);
						aux.rightchild = n;
					}
				} else if (info < aux.info){
L9:					p = aux.leftchild;
					if (p == null){
L10:					if (aux.rightchild == null)
L11:						aux.height++;
L12:					n = new NodeTree(info);
						aux.leftchild = n;
					}
				} else
					return;
			
L8:			} while (p != null)
								
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
	
}