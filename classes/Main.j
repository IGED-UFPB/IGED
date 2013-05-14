.class Main
.method static main() V
.limit locals 2
	new List
	astore_0
	aload_0
	aconst_null
	putfield List/init LNodeList;
	aload_0
	iconst_0
	putfield List/size I
	new NodeList
	astore_1
	aload_1
	iconst_2
	putfield NodeList/info I
	aload_1
	aconst_null
	putfield NodeList/next LNodeList;
	aload_0
	aload_1
	putfield List/init LNodeList;
	new NodeList
	astore_1
	aload_1
	ldc 12
	putfield NodeList/info I
	aload_1
	aconst_null
	putfield NodeList/next LNodeList;
	aload_0
	getfield List/init LNodeList;
	aload_1
	putfield NodeList/next LNodeList;
	new NodeList
	astore_1
	aload_1
	ldc 23
	putfield NodeList/info I
	aload_1
	aconst_null
	putfield NodeList/next LNodeList;
	aload_0
	getfield List/init LNodeList;
	getfield NodeList/next LNodeList;
	aload_1
	putfield NodeList/next LNodeList;	
	return
.end method
.end class