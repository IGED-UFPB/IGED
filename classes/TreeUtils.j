.class TreeUtils
.field static c I
.field static h I
.field static nu LNodeTree;
.field static nv LNodeTree;
.method static inserir(LBinaryTree;I) V
.limit locals 4
	aload_0
	getfield BinaryTree/root LNodeTree;
	ifnull L1
	aload_0
	getfield BinaryTree/root LNodeTree;
	astore_2
L3: aload_2
	astore_3
	iload_1
	aload_3
	getfield NodeTree/info I
	if_icmpgt L4
	iload_1
	aload_3
	getfield NodeTree/info I
	if_icmplt L7
	return
L7: aload_3
	getfield NodeTree/leftchild LNodeTree;
	astore_2
	aload_2
	ifnull L8
	goto L6
L8: aload_3
	new NodeTree
	putfield NodeTree/leftchild LNodeTree;
	aload_3
	getfield NodeTree/leftchild LNodeTree;
	iload_1
	invokespecial NodeTree/<init>(I) V
	aload_0
	getfield BinaryTree/root LNodeTree;
	invokestatic TreeUtils/atualizarAlturaNos(LNodeTree;) V
	goto L6
L4: aload_3
	getfield NodeTree/rightchild LNodeTree;
	astore_2
	aload_2
	ifnull L5
	goto L6
L5: aload_3
	new NodeTree
	putfield NodeTree/rightchild LNodeTree;
	aload_3
	getfield NodeTree/rightchild LNodeTree;
	iload_1
	invokespecial NodeTree/<init>(I) V
	aload_0
	getfield BinaryTree/root LNodeTree;
	invokestatic TreeUtils/atualizarAlturaNos(LNodeTree;) V
	goto L6
L6:	aload_2
	ifnonnull L3
	goto L2
L1:	aload_0
	new NodeTree
	putfield BinaryTree/root LNodeTree;
	aload_0
	getfield BinaryTree/root LNodeTree;
	iload_1
	invokespecial NodeTree/<init>(I) V
L2: aload_0
	aload_0
	getfield BinaryTree/size I
	iinc
	putfield BinaryTree/size I
	return
.end method
.method static buscar(LNodeTree;I) LNodeTree;
.limit locals 2
	aload_0
	ifnull L1
	iload_1
	aload_0
	getfield NodeTree/info I
	if_icmpeq L2
	iload_1
	aload_0
	getfield NodeTree/info I
	if_icmpgt L3
	aload_0
	getfield NodeTree/leftchild LNodeTree;
	iload_1
	invokestatic TreeUtils/buscar(LNodeTree;I) LNodeTree;
	areturn
L3: aload_0
	getfield NodeTree/rightchild LNodeTree;
	iload_1
	invokestatic TreeUtils/buscar(LNodeTree;I) LNodeTree;
	areturn
L2: aload_0
	areturn
L1:	aconst_null
	areturn
.end method
.method static altura(LNodeTree;) I
.limit locals 3
	aload_0
	ifnull L1
	aload_0
	getfield NodeTree/leftchild LNodeTree;
	invokestatic TreeUtils/altura(LNodeTree;) I
	istore_1
	aload_0
	getfield NodeTree/rightchild LNodeTree;
	invokestatic TreeUtils/altura(LNodeTree;) I
	istore_2
	iload_1
	iload_2
	if_icmplt L2
	iload_1
	iinc
	ireturn
L2:	iload_2
	iinc
	ireturn
L1:	iconst_m1
	ireturn
.end method
.method static atualizarAlturaNos(LNodeTree;) V
.limit locals 1
	aload_0
	ifnull L1
	aload_0
	aload_0
	invokestatic TreeUtils/altura(LNodeTree;) I
	putfield NodeTree/height I
	aload_0
	getfield NodeTree/rightchild LNodeTree;
	invokestatic TreeUtils/atualizarAlturaNos(LNodeTree;) V
	aload_0
	getfield NodeTree/leftchild LNodeTree;
	invokestatic TreeUtils/atualizarAlturaNos(LNodeTree;) V
L1:	return	
.end method
.method static rotacionarDireita(LNodeTree;I) V
.limit locals 2
	aload_0
	getfield NodeTree/leftchild LNodeTree;
	putstatic TreeUtils/nu LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	getfield NodeTree/height LNodeTree;
	iconst_m1
	if_icmpeq L1
	getstatic TreeUtils/nu LNodeTree;
	getfield NodeTree/rightchild LNodeTree;
	putstatic TreeUtils/nv LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	getstatic TreeUtils/nv LNodeTree;
	getfield NodeTree/leftchild LNodeTree;
	putfield NodeTree/rightchild LNodeTree;
	getstatic TreeUtils/nv LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	putfield NodeTree/leftchild LNodeTree;
	aload_0
	getstatic TreeUtils/nv LNodeTree;
	getfield NodeTree/rightchild LNodeTree;
	putfield NodeTree/leftchild LNodeTree;
	getstatic TreeUtils/nv LNodeTree;
	aload_0
	putfield NodeTree/rightchild LNodeTree;
	getstatic TreeUtils/nv LNodeTree;
	getfield NodeTree/height I
	iconst_m1
	if_icmpeq L3
	aload_0
	iconst_0
	putfield NodeTree/height I
L4: getstatic TreeUtils/nv LNodeTree;
	astore_0
	goto L2
L3:	aload_0
	iconst_1
	putfield NodeTree/height I
	goto L4
L1:	aload_0
	getstatic TreeUtils/nu LNodeTree;
	getfield NodeTree/rightchild LNodeTree;
	putfield NodeTree/leftchild LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	aload_0
	putfield NodeTree/rightchild LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	iconst_0
	putfield NodeTree/height I
	getstatic TreeUtils/nu LNodeTree;
	astore_0
L2: aload_0
	iconst_0
	putfield NodeTree/height I
	iconst_0
	istore_1
	return
.end method
.method static rotacionarEsquerda(LNodeTree;I) V
.limit locals 2
	aload_0
	getfield NodeTree/rightchild LNodeTree;
	putstatic TreeUtils/nu LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	getfield NodeTree/height LNodeTree;
	iconst_1
	if_icmpeq L1
	getstatic TreeUtils/nu LNodeTree;
	getfield NodeTree/leftchild LNodeTree;
	putstatic TreeUtils/nv LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	getstatic TreeUtils/nv LNodeTree;
	getfield NodeTree/rightchild LNodeTree;
	putfield NodeTree/leftchild LNodeTree;
	getstatic TreeUtils/nv LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	putfield NodeTree/rightchild LNodeTree;
	aload_0
	getstatic TreeUtils/nv LNodeTree;
	getfield NodeTree/leftchild LNodeTree;
	putfield NodeTree/rightchild LNodeTree;
	getstatic TreeUtils/nv LNodeTree;
	aload_0
	putfield NodeTree/leftchild LNodeTree;
	getstatic TreeUtils/nv LNodeTree;
	getfield NodeTree/height I
	iconst_1
	if_icmpeq L3
	aload_0
	iconst_0
	putfield NodeTree/height I
L4: getstatic TreeUtils/nv LNodeTree;
	astore_0
	goto L2
L3:	aload_0
	iconst_m1
	putfield NodeTree/height I
	goto L4
L1:	aload_0
	getstatic TreeUtils/nu LNodeTree;
	getfield NodeTree/leftchild LNodeTree;
	putfield NodeTree/rightchild LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	aload_0
	putfield NodeTree/leftchild LNodeTree;
	getstatic TreeUtils/nu LNodeTree;
	iconst_0
	putfield NodeTree/height I
	getstatic TreeUtils/nu LNodeTree;
	astore_0
L2: aload_0
	iconst_0
	putfield NodeTree/height I
	iconst_0
	istore_1
	return
.end method
.method static inserirAVL(LBinaryTree;I) V
	aload_0
	getfield BinaryTree/root LNodeTree;
	ifnull L1
	iload_1
	aload_0
	getfield BinaryTree/root LNodeTree;
	getfield NodeTree/info I
	if_icmplt L3
	iload_1
	aload_0
	getfield BinaryTree/root LNodeTree;
	getfield NodeTree/info I
	if_icmpgt L4
	goto L2
L4: aload_0
	getfield BinaryTree/root LNodeTree;
	aconst_null
	iload_1
	iconst_1
	invokestatic TreeUtils/inserirNoAVL(LNodeTree;LNodeTree;II) V
	goto L2
L3:	aload_0
	getfield BinaryTree/root LNodeTree;
	aconst_null
	iload_1
	iconst_1
	invokestatic TreeUtils/inserirNoAVL(LNodeTree;LNodeTree;II) V
	goto L2
L1:	new NodeTree
	astore_2
	aload_2
	iload_1
	invokespecial NodeTree/<init>(I) V
	aload_0
	aload_2
	putfield BinaryTree/root LNodeTree;
L2:	return
.end method
.method static inserirNoAVL(LNodeTree;LNodeTree;II) V
.limit locals 5
	aload_0
	ifnull L1
	iload_2
	aload_0
	getfield NodeTree/info I
	if_icmpeq L3
	iload_2
	aload_0
	getfield NodeTree/info I
	if_icmplt L4
	aload_0
	getfield NodeTree/rightchild LNodeTree;
	aload_0
	iload_2
	iload_3
	invokestatic TreeUtils/inserirNoAVL(LNodeTree;LNodeTree;II) V
	iload_3
	ifne L9
	goto L2
L9:	aload_0
	getfield NodeTree/height I
	iconst_m1
	if_icmpeq L10
	aload_0
	getfield NodeTree/height I
	ifeq L11
	aload_0
	getfield NodeTree/height I
	iconst_1
	if_icmpeq L12
	goto L2
L12: aload_0
	iload_3
	invokestatic TreeUtils/rotacionarEsquerda(LNodeTree;I) V
	goto L2
L11: aload_0
	iconst_1
	putfield NodeTree/height I
	goto L2
L10: aload_0
	iconst_0
	putfield NodeTree/height I
	iconst_0
	istore_3
	goto L2
L4:	aload_0
	getfield NodeTree/leftchild LNodeTree;
	aload_0
	iload_2
	iload_3
    invokestatic TreeUtils/inserirNoAVL(LNodeTree;LNodeTree;II) V
    iload_3
    ifne L5
    goto L2
L5: aload_0
	getfield NodeTree/height LNodeTree;
	iconst_m1
	if_icmpeq L6
	aload_0
	getfield NodeTree/height LNodeTree;
	ifeq L7
	aload_0
	putfield NodeTree/height I
	iconst_1
	if_icmpeq L8
	goto L2
L8: aload_0
	iconst_0
	putfield NodeTree/height I
	iconst_0
	istore_3
	goto L2
L7: aload_0
	iconst_m1
	putfield NodeTree/height I
	goto L2
L6: aload_0
	iload_3
	invokestatic TreeUtils/rotacionarDireita(LNodeTree;I) V
	goto L2
L3: return
L1:	new NodeTree
	astore 4
	aload 4
	iload_2
	invokespecial NodeTree/<init>(I) V
	iload_2
	aload_1
	getfield NodeTree/info I
	if_icmplt L13
	aload_1
	aload 4
	putfield NodeTree/rightchild LNodeTree;
	goto L14
L13: aload_1
	aload 4
	putfield NodeTree/leftchild LNodeTree;
L14: iconst_1
	istore_3
L2: return
.end method
.end class