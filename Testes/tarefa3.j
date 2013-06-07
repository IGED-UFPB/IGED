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

.class Main
.method static main() V
.limit locals 4
	new BinaryTree
	astore_0
	aload_0
	invokespecial BinaryTree/<init>() V
	new NodeTree
	astore_1
	aload_1
	ldc 35
	invokespecial NodeTree/<init>(I) V
	aload_0
	aload_1
	putfield BinaryTree/root LNodeTree;
	aload_0
	getfield BinaryTree/root LNodeTree;
	astore_3
	return
.end method
.end class

CREATE_REF BINARY_TREE t
CREATE_STRUCT BINARY_TREE
WRITE_REF
END_COMMAND
CREATE_REF NODE_TREE n
CREATE_STRUCT NODE_TREE
WRITE_REF
END_COMMAND
READ_REF n
LOAD_INT 35
WRITE_INFO 35
END_COMMAND
READ_REF t
READ_REF n
WRITE_REF_FIELD NODE_ROOT
END_COMMAND
CREATE_REF NODE_TREE c
READ_REF c
READ_REF t
READ_REF_FIELD NODE_ROOT
WRITE_REF
END_COMMAND


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

CREATE_REF BINARY_TREE t
CREATE_STRUCT BINARY_TREE
WRITE_REF
END_COMMAND
READ_REF t
LOAD_INT 0
WRITE_SIZE 0
END_COMMAND
CREATE_REF NODE_TREE n
CREATE_STRUCT NODE_TREE
WRITE_REF
END_COMMAND
READ_REF n
LOAD_INT 4
WRITE_INFO 4
END_COMMAND
READ_REF n
LOAD_INT 0
WRITE_HEIGHT 0
END_COMMAND




new NodeTree
	astore_1
	aload_1
	iconst_4
	invokespecial NodeTree/<init>(I) V