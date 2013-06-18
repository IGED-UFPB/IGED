.class ListaUtils
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
L1: iload 4
	iload_1
	if_icmplt L2
	return	
L2: new NodeList
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
	goto L1
.end method
.method static inverterLista(LList;) V
.limit locals 3
	aload_0
	getfield List/init LNodeList;
	astore_1
L1: aload_1
	getfield NodeList/next LNodeList;
	aconst_null
	if_acmpne L2
	aload_0
	getfield List/init LNodeList;
	astore_2
L3: aload_2
    aload_1
    if_acmpne L4
    return    
L2:	aload_1
	getfield NodeList/next LNodeList;
	astore_1
	goto L1	
L4: aload_0
    aload_2
    getfield NodeList/next LNodeList;
    putfield List/init LNodeList;
    aload_2
    aload_1
    getfield NodeList/next LNodeList;
    putfield NodeList/next LNodeList;
    aload_1
    aload_2
    putfield NodeList/next LNodeList;
    aload_0
    getfield List/init LNodeList;
    astore_2
   	goto L3
.end method
.method static removerNo(LList;I) V
.limit locals 5
	aload_0
	getfield List/init LNodeList;
	ifnull L1
	iload_1
	aload_0
	getfield List/size I
	if_icmpgt L1
	goto L2
L1: return
L2: aload_0
	getfield List/init LNodeList;
	astore_2
	iload_1
	iconst_1
	if_icmpeq L3
	iconst_0
	istore_3
L4: iload_3
	iload_1
	iconst_2
	isub
	if_icmplt L5
	aload_2
	getfield NodeList/next LNodeList;
	astore 4
	aload_2
	aload_2
	getfield NodeList/next LNodeList;
	getfield NodeList/next LNodeList;
	putfield NodeList/next LNodeList;
	aload 4
	aconst_null
	putfield NodeList/next LNodeList;
	return
L5: aload_2
	getfield NodeList/next LNodeList;
	astore_2	
	iload_3
	iinc
	istore_3	
	goto L4
L3: aload_0
	aload_2
	getfield NodeList/next LNodeList;
	putfield List/init LNodeList;
	aload_2
	aconst_null
	putfield NodeList/next LNodeList;
	return
.end method
.end class