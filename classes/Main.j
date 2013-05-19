.class Main
.method static main() V
.limit locals 4
	ldc 5
	istore_0
	iconst_3
	istore_1
	iload_1
	istore_0
	new List
	astore_2
	aload_2
	invokespecial List/<init>() V
	return
.end method
.end class