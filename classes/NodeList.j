.class NodeList
.field info I
.field next LNodeList;
.method <init>() V
	aload_0
	iconst_0
	putfield NodeList/info I
	aconst_null
	putfield NodeList/next LNodeList;
	return
.end method
.method <init>(I) V
	aload_0
	iload_1
	putfield NodeList/info I
	aconst_null
	astore_2
	aload_2
	putfield NodeList/next LNodeList;
	return
.end method  
.end class