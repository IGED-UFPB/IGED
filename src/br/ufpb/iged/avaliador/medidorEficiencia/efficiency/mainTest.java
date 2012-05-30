package efficiency;

import gui.ReportGraph;

import java.util.List;

public class mainTest {

	public static void main(String[] args) {

		int n[] = {10,20,30,40,50,60,70,80,90,100};

		// tableMeter table = new tableMeter();

		// Test Simples
		for (int k = 0; k < n.length; ++k) {
			System.out.println("Test Simples");
			int[] vetor1 = new int[n[k]];
			for (int i = 0; i < vetor1.length; ++i) {
				vetor1[i] = (int) (Math.random() * 100);
			}

			efficiencyMeter meter = new efficiencyMeter();

			for (int i = 0; i < vetor1.length; ++i) {
				System.out.print(vetor1[i] + " ");
			}
			System.out.println("");

			vetor1 = bublleSort(vetor1, meter);
			for (int i = 0; i < vetor1.length; ++i) {
				System.out.print(vetor1[i] + " ");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("Tabela de medição");
			// System.out.println("");
			// System.out.println(meter.toString());
			// System.out.println("");

			meter.finalizador(0, 0, "Bublle Sort", n[k], meter);
		}

		TableMeter table;
		System.out.println(" ");

		table = TableMeter.getInstance();
		// registryMeter register;
		List<registryMeter> list = table.getTable();

		for (registryMeter register : list) {

			System.out.println(register);
			System.out.println(" ");

		}

		// Teste Simples

		for (int k = 0; k < n.length; ++k) {
			System.out.println("Test Simples");
			int[] vetor2 = new int[n[k]];
			for (int i = 0; i < vetor2.length; ++i) {
				vetor2[i] = (int) (Math.random() * 100);
			}

			efficiencyMeter meter = new efficiencyMeter();

			for (int i = 0; i < vetor2.length; ++i) {
				System.out.print(vetor2[i] + " ");
			}
			System.out.println("");

			vetor2 = countSort(vetor2, meter);
			for (int i = 0; i < vetor2.length; ++i) {
				System.out.print(vetor2[i] + " ");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("Tabela de medição");
			// System.out.println("");
			// System.out.println(meter.toString());
			// System.out.println("");

			meter.finalizador(0, 0, "Count Sort", n[k], meter);
		}

		TableMeter table1;
		System.out.println(" ");

		table1 = TableMeter.getInstance();
		// registryMeter register;
		List<registryMeter> list1 = table.getTable();

		for (registryMeter register : list1) {

			System.out.println(register);
			System.out.println(" ");

		}

		// System.out.println(table.getTable().size());

		ReportGraph reportGraph = new ReportGraph();

		reportGraph.addSeries("Bublle Sort");
		reportGraph.addSeries("Count Sort");
		reportGraph.showSeries();

	}

	//
	//
	//
	//
	// //Bubble Sort
	// public static int[] bubbleSort(int aux[]){
	// int tmp;
	// int Parada = aux.length;
	// for(int i=0 ; i < Parada; ++i ){
	// for(int j=i+1 ; j < Parada; ++j){
	// if(aux[i] > aux[j]){
	// tmp = aux[i];
	// aux[i] = aux[j];
	// aux[j] = tmp;
	// }
	// }
	// }
	// return aux;
	// }
	//

	public static int[] bublleSort(int[] vetor, efficiencyMeter medidor) {

		// Código simulador do interpretador.
		// inicialização de i
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int k = 0; k < vetor.length; ++k) {
			// comparação de i com v.lenght
			medidor.operation();

			// inicialização de j
			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			for (int l = k + 1; l < vetor.length; ++l) {
				// comparação de j com v.lenght
				medidor.operation();

				// Indexação de v[i]
				medidor.indexArray();
				// Indexação de v[j]
				medidor.indexArray();
				// Comparação de v[i] com v[j]
				medidor.operation();

				// medidor.operacaoAritmetica; Fazer alterções
				// medidor.operacaoLogica; Fazer alterções

				if (vetor[k] > vetor[l]) {
					int aux = vetor[k];
					// Inicializacao de aux
					medidor.simpleVariableAllocation();
					// Indexação de v[k]
					medidor.indexArray();
					// Atribuição
					medidor.attributionArray();

					vetor[k] = vetor[l];
					// Indexação v[k]
					medidor.indexArray();
					// Indexação v[l]
					medidor.indexArray();
					// Atribuição
					medidor.attributionArray();

					vetor[l] = aux;
					// Indexação v[k]
					medidor.indexArray();
					// Atribuição
					medidor.attributionArray();
					medidor.simpleVariableDeAllocation();
				}

				// Adição j+1
				// atribuição de j
				medidor.attributionVariable();
				medidor.operation();
			}
			// comparação de j com v.lenght (esta última comparação dará false e
			// sairá do for interno)
			medidor.operation();
			medidor.simpleVariableDeAllocation();

			// Adição i+1
			// atribuição de i
			medidor.operation();
			medidor.attributionVariable();
		}
		// comparação de i com v.lenght (esta última comparação dará false e
		// sairá do for externo)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		return vetor;

	}

	public static int[] countSort(int[] vetor, efficiencyMeter medidor) {

		// Alocacao do vetor a ser ordenado.
		int B[] = new int[vetor.length];
		medidor.arrayAllocation(vetor.length);

		// procurando o maior elemento
		// Alocação Simples "maior";
		int maior = 0;
		medidor.simpleVariableAllocation();

		// Alocação Simples "i" do for
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 0; i < vetor.length; ++i) {
			// Comparação i com o tamanho do vetor;
			medidor.operationLogic();

			// Indexação e comparação do vetor com a variavel;
			medidor.indexArray();
			medidor.operationLogic();
			if (vetor[i] > maior)

				maior = vetor[i];
			// atribição da variável com a indexação do vetor;
			medidor.attributionVariable();
			medidor.indexArray();

			// Adição i+1
			// atribuição de i
			medidor.attributionVariable();
			medidor.operation();
		}

		// comparação de i com v.lenght (esta última comparação dará false e
		// sairá do for interno)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		// Alocação de Vetor de contagens
		int C[] = new int[maior + 1];
		medidor.arrayAllocation(maior + 1);

		// Alocação Simples "i" do for
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 0; i < vetor.length; ++i) {
			// Comparação i com o tamanho do vetor;
			medidor.operationLogic();

			C[vetor[i]] = C[vetor[i]] + 1;
			// Indexações e atribuições
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.operationAritimetic();
			medidor.attributionArray();

			// Adição i+1
			// atribuição de i
			medidor.attributionVariable();
			medidor.operation();
		}
		// comparação de i com v.lenght (esta última comparação dará false e
		// sairá do for interno)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		// Alocação Simples "i" do for
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 1; i < C.length; ++i) {
			// Comparação i com o tamanho do vetor;
			medidor.operationLogic();

			C[i] = C[i] + C[i - 1];
			// indexações atribuições e operações
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.attributionArray();
			medidor.operationAritimetic();
			medidor.operationAritimetic();

			// Adição i+1
			// atribuição de i
			medidor.attributionVariable();
			medidor.operation();
		}

		// comparação de i com v.lenght (esta última comparação dará false e
		// sairá do for interno)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		// Alocação Simples "i" do for
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = vetor.length - 1; i >= 0; --i) {
			// Comparação i com o tamanho do vetor;
			medidor.operationLogic();

			B[C[vetor[i]] - 1] = vetor[i];
			// Indexações operações atribuiçoes
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.operationAritimetic();
			medidor.attributionArray();

			C[vetor[i]] = C[vetor[i]] - 1;
			// Indexações operações atribuiçoes
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.operationAritimetic();
			medidor.attributionArray();

			// Adição i+1
			// atribuição de i
			medidor.attributionVariable();
			medidor.operation();
		}

		// comparação de i com v.lenght (esta última comparação dará false e
		// sairá do for interno)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		// Desalocação maior
		medidor.simpleVariableDeAllocation();

		// desalocação dos vetores;
		medidor.arrayDeAllocation(maior + 1);
		medidor.arrayDeAllocation(vetor.length);

		return B;

	}

}
