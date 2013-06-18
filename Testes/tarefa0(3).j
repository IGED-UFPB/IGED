.class Main
.field static vetor1 LVector;
.field static vetor2 LVector;
.field static vetor3 LVector;
.method static main() V
.limit locals 1
	new Vector
	putstatic Main/vetor3 LVector;
	getstatic Main/vetor3 LVector;
	invokestatic Main/preencherVetor(LVector;) V
	getstatic Main/vetor3 LVector;
	iconst_1
	ldc 15
	invokestatic VetorUtils/mergesort(LVector;II) V
	return
.end method
.method static preencherVetor(LVector;) V
.limit locals 1
	aload_0
	ldc 15
	invokespecial Vector/<init>(I) V
	aload_0
	getfield Vector/data [I;
	iconst_0
	ldc 51
	iastore
	aload_0
	getfield Vector/data [I;
	iconst_1
	ldc 100
	iastore
	aload_0
	getfield Vector/data [I;
	iconst_2
	ldc 20
	iastore
	aload_0
	getfield Vector/data [I;
	iconst_3
	ldc 93
	iastore
	aload_0
	getfield Vector/data [I;
	iconst_4
	ldc 11
	iastore
	aload_0
	getfield Vector/data [I;
	iconst_5
	ldc 65
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 6
	ldc 92
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 7
	ldc 76
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 8
	ldc 61
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 9
	ldc 40
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 10
	ldc 39
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 11
	ldc 52
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 12
	ldc 10
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 13
	ldc 62
	iastore
	aload_0
	getfield Vector/data [I;
	ldc 14
	ldc 91
	iastore
	return
.end method
.end class