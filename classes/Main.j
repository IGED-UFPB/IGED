.class Main
.method static main() V
.limit locals 8
	ldc 5
	istore_0
	iconst_3
	istore_1
	iload_1
	istore_0
	new List
	astore_2
	aload_2
	aconst_null
	putfield List/init LNodeList;
	aload_2
	iconst_0
	putfield List/size I
	new NodeList
	astore_3	
	aload_3
	ldc 4
	putfield NodeList/info I
	aload_3
	aconst_null
	putfield NodeList/next LNodeList;
	aload_2
	aload_3
	putfield List/init LNodeList;
	aload_2
	getfield List/size I
	iconst_1
	iadd
	istore 4
	aload_2
	iload 4
	putfield List/size I	
	new NodeList
	astore 5
	aload 5
	iconst_3
	putfield NodeList/info I
	aload 5
	aconst_null
	putfield NodeList/next LNodeList;
	aload_3
	aload 5
	putfield NodeList/next LNodeList;
	aload_2
	getfield List/size I
	iconst_1
	iadd
	istore 4
	aload_2
	iload 4
	putfield List/size I
	new Vector
	astore 6
	aload 6
	iconst_0
	putfield Vector/pos I
	aload 6
	ldc 10
	putfield Vector/size I
	aload 6
	getfield Vector/size I
	newarray int
	astore 7
	aload 6
	aload 7
	putfield Vector/data [I;
	return
.end method
.end class