.class NodeList
.field info I
.field next LList;
.method <init>() V
	aload_0
	iconst_0
	putfield NodeList/info I
	aconst_null
	putfield NodeList/next LList;
	return
.end method
.method <init>(I) V
	aload_0
	iload_1
	putfield NodeList/info I
	aconst_null
	putfield NodeList/next LList;
	return
.end method  
.end class