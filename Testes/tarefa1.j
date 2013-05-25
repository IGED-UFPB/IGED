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

new NodeList
	astore_1
	aload_1
	ldc 20
	invokespecial NodeList/<init>(I) V
	aload_2
	aload_1
	putfield NodeList/next LNodeList;

CREATE_REF LIST l
CREATE_STRUCT LIST
WRITE_REF
END_COMMAND
CREATE_REF NODE n
CREATE_STRUCT NODE
WRITE_REF
END_COMMAND 
READ_REF n
WRITE_INFO 30
END_COMMAND
READ_REF l
WRITE_INFO 1
END_COMMAND
READ_REF l
READ_REF n
WRITE_REF_FIELD INIT
END_COMMAND
CREATE_REF NODE aux
READ_REF aux
READ_REF l
READ_REF_FIELD INIT
WRITE_REF 
END_COMMAND

READ_REF n
READ_REF l
READ_REF_FIELD INIT
WRITE_REF_FIELD NEXT
END_COMMAND
