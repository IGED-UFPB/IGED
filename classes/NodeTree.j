.class NodeTree
.field parent LNodeTree;
.field leftchild LNodeTree;
.field rightchild LNodeTree;
.field info I
.method <init>() V
	aload_0
	aconst_null
	putfield NodeTree/parent LNodeTree;
	aconst_null
	putfield NodeTree/leftchild LNodeTree;
	aconst_null
	putfield NodeTree/rightchild LNodeTree;
	iconst_0
	putfield NodeTree/info I
	return
.end method
.method <init>(I) V
	aload_0
	aconst_null
	putfield NodeTree/parent LNodeTree;
	aconst_null
	putfield NodeTree/leftchild LNodeTree;
	aconst_null
	putfield NodeTree/rightchild LNodeTree;
	iload_1
	putfield NodeTree/info I
	return
.end method
.end class