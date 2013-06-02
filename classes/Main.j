.class Main
.method static main() V
.limit locals 2
	new BinaryTree
	astore_0
	aload_0
	invokespecial BinaryTree/<init>() V
	new NodeTree
	astore_1
	aload_1
	iconst_4
	invokespecial NodeTree/<init>(I) V
	aload_0
	aload_1
	putfield BinaryTree/root LNodeTree;
	return
.end method
.end class