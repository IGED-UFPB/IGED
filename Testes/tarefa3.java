public class Main{
	
	public static void main(String args[]) {
		
		BinaryTree a = new BinaryTree();
		
		TreeUtils.inserir(a, 35);
		
		TreeUtils.inserir(a, 22);
		
		TreeUtils.inserir(a, 59);
		
		TreeUtils.inserir(a, 15);
		
		TreeUtils.inserir(a, 19);
		
		TreeUtils.inserir(a, 28);
		
		TreeUtils.inserir(a, 72);
		
		TreeUtils.inserir(a, 41);
				
		b = TreeUtils.buscar(a.root, 41);
		
		a.root.height = altura(a.root);
		
	}
	
	
}