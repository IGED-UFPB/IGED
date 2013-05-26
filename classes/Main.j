.class Main
.method static main() V
.limit locals 1
	new List
	astore_0
	aload_0
	invokespecial List/<init>() V
	aload_0
	ldc 5
	invokestatic Main/preencherLista(LList;I) V
	aload_0
	invokestatic Main/inverterLista(LList;) V
	return
.end method
.method static preencherLista(LList;I) V
.limit locals 5
	new NodeList
	astore_2
	aload_2
	ldc 10
	invokespecial NodeList/<init>(I) V
	aload_0
	aload_2
	putfield List/init LNodeList;
	aload_0
	iconst_1
	putfield List/size I
	aload_0
	getfield List/init LNodeList;
	astore_3
	iconst_1
	istore 4	
L1: new NodeList
	astore_2
	aload_2
	iload 4
	iinc
	ldc 10
	imul
	invokespecial NodeList/<init>(I) V
	aload_3
	aload_2
	putfield NodeList/next LNodeList;
	aload_0
	aload_0
	getfield List/size I
	iinc
	putfield List/size I
	aload_3
	getfield NodeList/next LNodeList;
	astore_3
	iload 4
	iinc
	istore 4
	iload 4
	iload_1
	if_icmplt L1
	return
.end method
.method static inverterLista(LList;) V
.limit locals 2
	aload_0
	getfield List/init LNodeList;
	astore_1
L1:	aload_1
	getfield NodeList/next LNodeList;
	astore_1
	aload_1
	getfield NodeList/next LNodeList;
	aconst_null
	if_acmpne L1
	return
.end method
.end class