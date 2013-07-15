.class NodeList
.field info I
.field next LNodeList;
.method <init>() V
.limit locals 1
	aload_0
	iconst_0
	putfield NodeList/info I
	aload_0
	aconst_null
	putfield NodeList/next LNodeList;
	return
.end method
.method <init>(I) V
.limit locals 2
	aload_0
	iload_1
	putfield NodeList/info I
	aload_0
	aconst_null
	putfield NodeList/next LNodeList;
	return
.end method  
.end class