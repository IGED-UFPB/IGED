.class Main
.method static main() V
	new List
	astore_0
	aload_0
	invokespecial List/<init>() V
	new NodeList
	astore_1
	aload_1
	ldc 10
	invokespecial NodeList/<init>(I) V
	aload_0
	aload_1
	putfield List/init LNodeList;
	aload_0
	aload_0
	getfield List/size I
	iinc
	putfield List/size I
	aload_0
	getfield List/init LNodeList;
	astore_2	
	return
.end method
.end class