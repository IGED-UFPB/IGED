.class TreeUtils
.method static inserir(LBinaryTree;I) V
.limit locals 5
	aload_0
	getfield BinaryTree/root LNodeTree;
	ifnull L1
	aload_0
	getfield BinaryTree/root LNodeTree;
	astore_3
L3: aload_3
	astore 4
	iload_1
	aload 4
	getfield NodeTree/info I
	if_icmpgt L4
	iload_1
	aload 4
	getfield NodeTree/info I
	if_icmplt L9
	return
L9: aload 4
	getfield NodeTree/leftchild LNodeTree;
	astore_3
	aload_3
	ifnull L10
	goto L8
L10: aload 4
	getfield NodeTree/rightchild LNodeTree;
	ifnull L11
	goto L12
L11: aload 4
	aload 4
	getfield NodeTree/height I
	iinc
	putfield NodeTree/height I
L12: new NodeTree
	astore_2
	aload_2
	iload_1
	invokespecial NodeTree/<init>(I) V
	aload 4
	aload_2
	putfield NodeTree/leftchild LNodeTree;
	goto L8
L4: aload 4
	getfield NodeTree/rightchild LNodeTree;
	astore_3
	aload_3
	ifnull L5
	goto L8
L5: aload 4
	getfield NodeTree/leftchild LNodeTree;
	ifnull L6
L7: new NodeTree
	astore_2
	aload_2
	iload_1
	invokespecial NodeTree/<init>(I) V
	aload 4
	aload_2
	putfield NodeTree/rightchild LNodeTree;
L8:	aload_3
	ifnonnull L3
	goto L2
L6: aload 4
	aload 4
	getfield NodeTree/height I
	iinc
	putfield NodeTree/height I
	goto L7
L1:	new NodeTree
	astore_2
	aload_2
	iload_1
	invokespecial NodeTree/<init>(I) V
	aload_0
	aload_2
	putfield BinaryTree/root LNodeTree;
L2: aload_0
	aload_0
	getfield BinaryTree/size I
	iinc
	putfield BinaryTree/size I
	return
.end method
.end class