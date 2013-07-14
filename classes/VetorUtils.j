.class VetorUtils
.method static swap([I;II) V
.limit locals 4
	aload_0
	iload_1
	iaload
	istore_3
	aload_0
	iload_1
	aload_0
	iload_2
	iaload
	iastore
	aload_0
	iload_2
	iload_3
	iastore
	return
.end method
.method static bubblesort(LVector;I) V
.limit locals 4
	iconst_0
	istore_2
L4:	iload_2
	iload_1
	iconst_1
	isub
	if_icmplt L1
	goto L2
L1:	iload_1
	iconst_1
	isub
	istore_3
L7:	iload_3
	iload_2
	if_icmpgt L3
	iload_2
	iinc
	istore_2
	goto L4
L3:	aload_0
	getfield Vector/data [I;
	iload_3
	iaload
	aload_0
	getfield Vector/data [I;
	iload_3
	iconst_1
	isub
	iaload
	if_icmplt L5
L6: iload_3
	iconst_1
	isub
	istore_3
	goto L7
L5:	aload_0
	getfield Vector/data [I;
	iload_3
	iload_3
	iconst_1
	isub
	invokestatic VetorUtils/swap([I;II) V
	goto L6
L2:	return
.end method
.method static insertionsort(LVector;I) V
.limit locals 5
	iconst_1
	istore_2
L1:	iload_2
	iload_1
	if_icmplt L2
	goto L3
L2:	aload_0
	getfield Vector/data [I;
	iload_2
	iaload
	istore_3
	iload_2
	iconst_1
	isub
	istore 4
L4: iload 4
	ifge L5
L6:	aload_0
	getfield Vector/data [I;
	iload 4
	iinc
	iload_3
	iastore
	iload_2
	iinc
	istore_2
	goto L1
L5: aload_0
	getfield Vector/data [I;
	iload 4
	iaload
	iload_3
	if_icmpgt L7
	goto L6
L7: aload_0
	getfield Vector/data [I;
	iload 4
	iinc
	aload_0
	getfield Vector/data [I;
	iload 4
	iaload
	iastore
	iload 4
	iconst_1
	isub
	istore 4
	goto L4
L3: return
.end method
.method static merge([I;III) V
.limit locals 11
	iload_2
	iload_1
	isub
	iinc
	istore 4
	iload_3
	iload_2
	isub
	istore 5
	iload_1
	iconst_1
	isub
	istore_1
	iload 4
	newarray int
	astore 6
	iload 5
	newarray int
	astore 7
	iconst_0
	istore 8
L1:	iload 8
	iload 4
	if_icmplt L2
	iconst_0
	istore 8
L3:	iload 8
	iload 5
	if_icmplt L4
	iconst_0
	istore 8
	iconst_0
	istore 9
	iload_1
	istore 10
L5:	iload 10
	iload_3
	if_icmplt L6
	return
L6:	iload 8
	iload 4
	if_icmpeq L8
	goto L9
L8:	iload 9
	iload 5
	if_icmplt L10
L9:	iload 8
	iload 4
	if_icmplt L12
	goto L13
L12: iload 9
	iload 5
	if_icmpeq L14
L13: iload 8
	iload 4
	if_icmplt L16
	goto L7
L16: iload 9
	iload 5
	if_icmplt L17
	goto L7
L17: aload 6
	iload 8
	iaload
	aload 7
	iload 9
	iaload
	if_icmple L18
	aload_0
	iload 10
	aload 7
	iload 9
	iaload
	iastore
	iload 9
	iinc
	istore 9
	goto L7
L18: aload_0
	iload 10
	aload 6
	iload 8
	iaload
	iastore
	iload 8
	iinc
	istore 8
	goto L7
L14: iload 10
	iload_3
	if_icmplt L15
	goto L7
L15: aload_0
	iload 10
	aload 6
	iload 8
	iaload
	iastore
	iload 10
	iinc
	istore 10
	iload 8
	iinc
	istore 8
	goto L14
L10: iload 10
	iload_3
	if_icmplt L11
	goto L7
L11: aload_0
	iload 10
	aload 7
	iload 9
	iaload
	iastore
	iload 10
	iinc
	istore 10
	iload 9
	iinc
	istore 9
	goto L10
L4:	aload 7
	iload 8
	aload_0
	iload_2
	iload 8
	iadd
	iaload
	iastore
	iload 8
	iinc
	istore 8
	goto L3
L2:	aload 6
	iload 8
	aload_0
	iload_1
	iload 8
	iadd
	iaload
	iastore
	iload 8
	iinc
	istore 8
	goto L1
L7:	iload 10
	iinc
	istore 10
	goto L5
	return
.end method
.method static mergesort(LVector;II) V
	iload_1
	iload_2
	if_icmplt L1
	goto L2
L1: iload_1
	iload_2
	iadd
	iconst_2
	idiv
	istore_3
	aload_0
	iload_1
	iload_3
	invokestatic VetorUtils/mergesort (LVector;II) V
	aload_0
	iload_3
	iinc
	iload_2
	invokestatic VetorUtils/mergesort (LVector;II) V
	aload_0
	getfield Vector/data [I;
	iload_1
	iload_3
	iload_2
	invokestatic VetorUtils/merge([I;III) V
L2:	return
.end method
.end class