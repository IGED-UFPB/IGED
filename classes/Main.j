.class Main
.method static main() V
.limit locals 2
	new BinaryTree
	astore_0
	aload_0
	invokespecial BinaryTree/<init>() V
	aload_0
	ldc 35
	invokestatic TreeUtils/inserir(LBinaryTree;I) V
	aload_0
	ldc 22
	invokestatic TreeUtils/inserir(LBinaryTree;I) V
	aload_0
	ldc 59
	invokestatic TreeUtils/inserir(LBinaryTree;I) V
	aload_0
	ldc 15
	invokestatic TreeUtils/inserir(LBinaryTree;I) V
	aload_0
	ldc 19
	invokestatic TreeUtils/inserir(LBinaryTree;I) V
	aload_0
	ldc 28
	invokestatic TreeUtils/inserir(LBinaryTree;I) V
	aload_0
	ldc 72
	invokestatic TreeUtils/inserir(LBinaryTree;I) V
	aload_0
	ldc 41
	invokestatic TreeUtils/inserir(LBinaryTree;I) V
	aload_0
	getfield BinaryTree/root LNodeTree;
	ldc 41
	invokestatic TreeUtils/buscar(LNodeTree;I) LNodeTree;
	astore_1
	return
.end method
.end class