Remo��o de um n� na posi��o informada

.class Main
.method static main() V
.limit locals 1
	new List
	astore_0
	aload_0
	invokespecial List/<init>() V
	aload_0
	ldc 5
	invokestatic ListaUtils/preencherLista(LList;I) V
	aload_0
	ldc 5
	invokestatic ListaUtils/removerNo(LList;I) V
	return
.end method
.end class