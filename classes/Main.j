.class Main
.method static main() V
.limit locals 1
	new BinaryTree
	astore_0
	aload_0
	invokespecial BinaryTree/<init>() V
	aload_0
	ldc 8
	invokestatic TreeUtils/inserirAVL(LBinaryTree;I) V
	aload_0
	ldc 12
	invokestatic TreeUtils/inserirAVL(LBinaryTree;I) V
	aload_0
	ldc 15
	invokestatic TreeUtils/inserirAVL(LBinaryTree;I) V
	aload_0
	ldc 18
	invokestatic TreeUtils/inserirAVL(LBinaryTree;I) V
	return
.end method
.end class