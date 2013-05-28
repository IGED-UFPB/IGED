.class Vector
.field pos I
.field size I
.field data [I;
.method <init>(I) V
.limit locals 2
	aload_0
	iconst_0
	putfield Vector/pos I
	aload_0
	iload_1
	putfield Vector/size I
	aload_0
	iload_1
	newarray int
	putfield Vector/data [I;	
	return
.end method
.end class