Invers�o de um vetor por meio de um campo est�tico

.class Main
.field static vetor LVector;
.method static main() V
.limit locals 1
	new Vector
	putstatic Main/vetor LVector;
	getstatic Main/vetor LVector;
	iconst_4
	invokespecial Vector/<init>(I) V
	iconst_0
	istore_0	
L1:	iload_0
	getstatic Main/vetor LVector;
	getfield Vector/size I
	if_icmplt L2
	invokestatic Main/inverterVetor() V
	return
L2: getstatic Main/vetor LVector;
	getfield Vector/data [I;
	iload_0
	iload_0
	iinc
	iastore
	iload_0
	iinc
	istore_0
	goto L1
.end method
.method static inverterVetor() V
.limit locals 4
	getstatic Main/vetor LVector;
	getfield Vector/size I
	iconst_1
	isub
	istore_1
	iconst_0
	istore_0
L1:	iload_0
	getstatic Main/vetor LVector;
	getfield Vector/size I
	iconst_2
	idiv
	if_icmplt L2
	return
L2:	getstatic Main/vetor LVector;
	getfield Vector/data [I;
	iload_1
	iaload
	istore_2
	getstatic Main/vetor LVector;
	getfield Vector/data [I;
	iload_1
	getstatic Main/vetor LVector;
	getfield Vector/data [I;
	iload_0
	iaload
	iastore
	getstatic Main/vetor LVector;
	getfield Vector/data [I;
	iload_0
	iload_2
	iastore
	iload_0
	iinc
	istore_0
	iload_1
	iconst_1
	isub
	istore_1
	goto L1
.end method
.end class