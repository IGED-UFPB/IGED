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