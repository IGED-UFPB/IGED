.class Vector
.field pos I
.field size I
.field data [I;
.method <init>(I) V
	aload_0
	iconst_0
	putfield Vector/pos I
	iload_1
	putfield Vector/size I
	getfield Vector/size I
	newarray int
	putfield Vector/data [I;	
	return
.end method
.end class