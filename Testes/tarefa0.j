Inversão de um vetor com passagem de referência a um método

.class Main
.method static main() V
.limit locals 2
	new Vector
	astore_0
	aload_0
	iconst_4
	invokespecial Vector/<init>(I) V
	iconst_0
	istore_1	
L1:	iload_1
	aload_0
	getfield Vector/size I
	if_icmplt L2
	aload_0
	invokestatic Main/inverterVetor(LVector;) V
	return
L2: aload_0
	getfield Vector/data [I;
	iload_1
	iload_1
	iinc
	iastore
	iload_1
	iinc
	istore_1
	goto L1
.end method
.method static inverterVetor(LVector;) V
.limit locals 4
	aload_0
	getfield Vector/size I
	iconst_1
	isub
	istore_2
	iconst_0
	istore_1
L1:	iload_1
	aload_0
	getfield Vector/size I
	iconst_2
	idiv
	if_icmplt L2
	return
L2:	aload_0
	getfield Vector/data [I;
	iload_2
	iaload
	istore_3
	aload_0
	getfield Vector/data [I;
	iload_2
	aload_0
	getfield Vector/data [I;
	iload_1
	iaload
	iastore
	aload_0
	getfield Vector/data [I;
	iload_1
	iload_3
	iastore
	iload_1
	iinc
	istore_1
	iload_2
	iconst_1
	isub
	istore_2
	goto L1
.end method
.end class