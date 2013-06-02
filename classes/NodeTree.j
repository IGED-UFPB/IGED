.class NodeTree
.field leftchild LNodeTree;
.field rightchild LNodeTree;
.field info I
.field height I
.method <init>() V
.limit locals 1
	aload_0
	aconst_null
	putfield NodeTree/leftchild LNodeTree;
	aload_0
	aconst_null
	putfield NodeTree/rightchild LNodeTree;
	aload_0
	iconst_0
	putfield NodeTree/info I
	aload_0
	iconst_0
	putfield NodeTree/height I
	return
.end method
.method <init>(I) V
.limit locals 2
	aload_0
	aconst_null
	putfield NodeTree/leftchild LNodeTree;
	aload_0
	aconst_null
	putfield NodeTree/rightchild LNodeTree;
	aload_0
	iload_1
	putfield NodeTree/info I
	aload_0
	iconst_0
	putfield NodeTree/height I
	return
.end method
.method <init>(II) V
.limit locals 3
	aload_0
	aconst_null
	putfield NodeTree/leftchild LNodeTree;
	aload_0
	aconst_null
	putfield NodeTree/rightchild LNodeTree;
	aload_0
	iload_1
	putfield NodeTree/info I
	aload_0
	iload_2
	putfield NodeTree/height I
	return
.end method
.end class