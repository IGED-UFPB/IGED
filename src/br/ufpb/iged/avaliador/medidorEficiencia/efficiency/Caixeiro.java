package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;
/**
 * Esta classe gera e imprime as diferentes permutações de n objetos
 * 
 */

public class Caixeiro {

	// numero da permutacao atual
	private static int cont = 0;

	// armazena a permutacao corrente


	static int[][] mapa = { { 0, 3, 2 }, 
							{ 3, 0, 3 }, 
							{ 4, 3, 0 }};

	private static int v[] = {0, 1, 2};
	
	private static int[] p = new int[v.length];
	
	private static int menorDistancia = 0;

	private static int tamanho = v.length+1;

	/**
	 * metodo principal: recebe o vetor cujos elementos que serao permutados
	 * 
	 * @param v2
	 * @return
	 */

	/**
	 * método recursivo que implementa as permutacoes
	 * 
	 * @param v2
	 * @param n
	 * @return 
	 */
	public static void CalcularRotas(int dim, efficiencyMeter medidor){
		
		medidor.arrayAllocation(dim);
		medidor.attributionArray();
		medidor.indexArray();
		medidor.indexArray();
		mapa = new int[dim][dim];
		
		medidor.arrayAllocation(dim);
		medidor.attributionArray();
		medidor.indexArray();
		v = new int [dim];
		
		
		medidor.arrayAllocation(dim);
		medidor.attributionArray();
		medidor.indexArray();
		p = new int[v.length];
		
		medidor.simpleVariableAllocation();
		medidor.simpleVariableAllocation();
		medidor.acessVariable();
		tamanho = v.length+1;
		
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 0; i < v.length; i++) {
			medidor.operationAritimetic();
			medidor.operationLogic();
			
			medidor.indexArray();
			medidor.attributionArray();
			medidor.acessVariable();
			v[i] = i;
			
			System.out.print(v[i] + " ");
			
		}
		
		System.out.println(" ");
		System.out.println(" ");
		
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 0; i < mapa.length; i++) {
			medidor.operationAritimetic();
			medidor.acessVariable();
			medidor.operationLogic();
			
			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			for (int j = 0; j < mapa.length; j++) {
				medidor.operationAritimetic();
				medidor.acessVariable();
				medidor.operationLogic();
				
				medidor.acessVariable();
				medidor.acessVariable();
				medidor.operationAritimetic();
				medidor.operation();
				
				if(j == i){
					
					medidor.indexArray();
					medidor.indexArray();
					medidor.attributionArray();
					medidor.operationAritimetic();
					mapa[i][j] = 0;
					
					System.out.print(mapa[i][j] + " ");
					
				}else{
				
					medidor.indexArray();
					medidor.indexArray();
					medidor.attributionVariable();
					medidor.methodInvocation();
					medidor.methodReturn();
					medidor.operationAritimetic();
					medidor.acessVariable();
					medidor.operation();
					mapa[i][j] = (int) (Math.random() * 100 );
					System.out.print(mapa[i][j] + " ");
				}
			}
			
			System.out.println(" ");
		}
		
		medidor.indexArray();
		medidor.acessArray();
		medidor.methodInvocation();
		permuta(v, 0, v[0], medidor);
		
	}
	
	private static int[] permuta(int[] v2, int n, int v3, efficiencyMeter medidor) {

		
		medidor.operation();
		medidor.operationLogic();
		medidor.operationLogic();
		medidor.operationLogic();
		medidor.acessVariable();
		medidor.acessArray();
		medidor.acessVariable();
		medidor.indexArray();
		
		if (n == v2.length  && (p[0] == v3)) {
			
			medidor.operationAritimetic();
			medidor.attributionVariable();
	
			cont++;
			
			medidor.methodInvocation();
			medidor.methodReturn();
			return imprime(medidor);

		} else {


			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			for (int i = 0; i < v2.length; i++) {
				medidor.operationAritimetic();
				medidor.acessVariable();
				medidor.operationLogic();

				medidor.simpleVariableAllocation();
				medidor.operationAritimetic();
				medidor.acessVariable();
				boolean achou = false;

				medidor.simpleVariableAllocation();
				medidor.attributionVariable();
				for (int j = 0; j < n; j++) {
					medidor.operationAritimetic();
					medidor.acessVariable();
					medidor.operationLogic();
					
					medidor.operation();
					medidor.operationLogic();
					medidor.indexArray();
					medidor.indexArray();
					if (p[j] == v2[i]){
						medidor.attributionVariable();
						medidor.acessVariable();
						achou = true;
					}
				}

				medidor.acessVariable();
				medidor.operationLogic();
				medidor.operation();
				if (!achou) {

					medidor.indexArray();
					medidor.indexArray();
					medidor.attributionArray();
					p[n] = v2[i];
					
					medidor.methodInvocation();
					permuta(v2, n + 1, v3, medidor);
				}

			} // --for

		} // --if/else
		
		medidor.methodReturn();
		return null;

	} // --permuta

	/** imprime a permutacao corrente 
	 * @param medidor */
	private static int[] imprime(efficiencyMeter medidor) {

		medidor.arrayAllocation(tamanho);
		int[] result = new int[tamanho];
		System.out.println();
		// System.out.print("(" + cont + ") : ");

		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 0; i < p.length; i++) {
			medidor.operationAritimetic();
			medidor.acessVariable();
			medidor.operationLogic();
			//System.out.print(p[i] + " ");
			
			medidor.indexArray();
			medidor.indexArray();
			medidor.attributionArray();
			result[i] = p[i];
		}
		//System.out.print(p[0]);
		
		medidor.indexArray();
		medidor.indexArray();
		medidor.attributionVariable();
		result[tamanho - 1] = p[0];
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		
		medidor.operationLogic();
		medidor.operation();
		medidor.acessVariable();
		if(menorDistancia == 0){
		
			//System.out.println("Entrou");
			
			medidor.acessVariable();
			medidor.methodInvocation();
			menorDistancia = Distancia(result, medidor);
			//System.out.println(" = " +menorDistancia);
			
		}else if((menorDistancia > Distancia(result, medidor))){
			
			//System.out.println("Entrou");
			medidor.acessVariable();
			medidor.methodInvocation();
			menorDistancia = Distancia(result, medidor);
			//System.out.println(" = " +menorDistancia);
			
		}
		
		System.out.println(" = " +menorDistancia);
		
		medidor.methodReturn();
		return result;

	} // --imprime

	private static int Distancia(int[] result , efficiencyMeter medidor) {
		
		medidor.simpleVariableAllocation();
		medidor.acessVariable();
		medidor.operationAritimetic();
		int distancia = 0;
		
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 0 ; i < result.length-1; ++i) {
			medidor.operationAritimetic();
			medidor.acessVariable();
			medidor.operationLogic();
					
			medidor.acessVariable();
			medidor.operationAritimetic();
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.operationAritimetic();
			distancia += mapa[result[i]][result[i+1]];

		}

		medidor.methodReturn();
		return distancia;
		
	}

//	/** metodo principal para teste da classe */
//	public static void main(String[] args) {
//
//		//Permutacoes.permuta(v, v[0]);
//		
//		int[] result = null;
//		
////		result = permuta(v, 0 ,v[0]);
////		
////		System.out.println(" ");
////		System.out.println("Menor distacia = " + menorDistancia);
////		
//		
//		CalcularRotas(4);
//		System.out.println(" ");
//		System.out.println("Menor distâcia = " + menorDistancia);
//		//System.out.println(result.length);
//		
//		//Distancia(permuta(v, v[0]));
//
//	}
//
}
