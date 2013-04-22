package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

//import br.ufpb.iged.avaliador.medidorEficiencia.gui.ReportGraph;

import java.util.List;
import java.util.Random;

public class MainTesteLagrange {

	public static void main(String[] args) {

		WriteTxt gravadorBS = new WriteTxt("Arquivo BS");
		WriteTxt gravadorBB = new WriteTxt("Arquivo BB");
		WriteTxt gravadorCS = new WriteTxt("Arquivo CS");
		WriteTxt gravadorMS = new WriteTxt("Arquivo MS");
		WriteTxt gravadorQS = new WriteTxt("Arquivo QS");
		WriteTxt gravadorCV = new WriteTxt("Arquivo CV");

		// INSTANCIAS USADAS NA MEDI��O
		double[] n = Lagrange.VetorX;
		double[] nCaix = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// ARRAYS FINAIS PARA VERIFICA��O
		double bsMedio[] = new double[n.length];
		double bsMin[] = new double[n.length];
		double bsMax[] = new double[n.length];

		double bbMedio[] = new double[n.length];
		double bbMin[] = new double[n.length];
		double bbMax[] = new double[n.length];

		double cs[] = new double[n.length];
		double csMin[] = new double[n.length];
		double csMax[] = new double[n.length];

		double qsMedio[] = new double[n.length];
		double qsMin[] = new double[n.length];
		double qsMax[] = new double[n.length];

		double msMedio[] = new double[n.length];
		double msMin[] = new double[n.length];
		double msMax[] = new double[n.length];

		double cvMedio[] = new double[n.length];

		int MediaInicial = 0;
		int MediaParada = 1;

		// MEDIDORES DE EFICI�NCIA
		// efficiencyMeter meterBubleSort = new efficiencyMeter();
		// efficiencyMeter meterCountSort = new efficiencyMeter();
		// efficiencyMeter meterQuickSort = new efficiencyMeter();
		// efficiencyMeter meterMergeSort = new efficiencyMeter();

		// ----------------------------------------------------------------//

		// TESTE CAIXEIRO

		while (MediaInicial != MediaParada) {

			for (int i = 0; i < msMax.length; i++) {
				efficiencyMeter meterCaixeiro = new efficiencyMeter();

				Caixeiro.CalcularRotas((int) nCaix[i], meterCaixeiro);

				cvMedio[i] += meterCaixeiro.registerMeter.processingTotal;

				gravadorCV.escreve(String
						.valueOf(meterCaixeiro.registerMeter.processingTotal));
				gravadorCV.escreve(" ");

				meterCaixeiro.finalizador(0, 0, "Caixeiro Viajante",
						(int) nCaix[i], meterCaixeiro);

			}
			
			MediaInicial++;

		}
		
		MediaInicial = 0;
		
		for (int i = 0; i < n.length; ++i) {

			cvMedio[i] = cvMedio[i] / MediaParada;
		}

		// FIM TESTE CAIXEIRO

		while (MediaInicial != MediaParada) {

			// TESTE BUSCA BINaRIA E BUBLE SORT
			for (int k = 0; k < n.length; ++k) {
				// System.out.println("Test Simples");
				int[] vetor1 = new int[(int) n[k]];
				for (int i = 0; i < vetor1.length; ++i) {
					vetor1[i] = (int) (Math.random() * n[k]);
				}

				for (int i = 0; i < vetor1.length; ++i) {
					// System.out.print(vetor1[i] + " ");
				}
				// System.out.println("");

				efficiencyMeter meterBubleSort = new efficiencyMeter();
				efficiencyMeter meterBuscaBinaria = new efficiencyMeter();

				vetor1 = bublleSort(vetor1, meterBubleSort);
				binarySearch(vetor1, -1, meterBuscaBinaria);

				for (int i = 0; i < vetor1.length; ++i) {
					// System.out.print(vetor1[i] + " ");
				}
				// System.out.println("");
				// System.out.println("");
				// System.out.println("Tabela de medicao");

				meterBubleSort.finalizador(0, 0, "Bublle Sort", (int) n[k],
						meterBubleSort);
				meterBuscaBinaria.finalizador(0, 0, "Busca Binaria",
						(int) n[k], meterBuscaBinaria);

				// GRAVANDO DADOS
				gravadorBB
						.escreve(String
								.valueOf(meterBuscaBinaria.registerMeter.processingTotal));
				gravadorBB.escreve(" ");

				gravadorBS.escreve(String
						.valueOf(meterBubleSort.registerMeter.processingTotal));
				gravadorBS.escreve(" ");

				// System.out.println(meterBubleSort.registerMeter.processingTotal);
				bsMedio[k] += meterBubleSort.registerMeter.processingTotal;

				// System.out.println(meterBuscaBinaria.registerMeter.processingTotal);
				// if(n[k] == 1000){

				// System.out.println(meterBuscaBinaria.registerMeter.processingTotal);
				bbMedio[k] += meterBuscaBinaria.registerMeter.processingTotal;

				// System.out.println(meterBuscaBinaria.registerMeter.processingTotal);
				// System.out.println(bb[k]);
				// System.out.println("--------------------------");

				// MIN BB
				if (MediaInicial == 0) {

					bbMin[k] = meterBuscaBinaria.registerMeter.processingTotal;

				} else if (bbMin[k] > meterBuscaBinaria.registerMeter.processingTotal) {

					bbMin[k] = meterBuscaBinaria.registerMeter.processingTotal;

				}

				// MAX BB
				if (MediaInicial == 0) {

					bbMax[k] = meterBuscaBinaria.registerMeter.processingTotal;

				} else if (bbMin[k] < meterBuscaBinaria.registerMeter.processingTotal) {

					bbMax[k] = meterBuscaBinaria.registerMeter.processingTotal;

				}

				// MIN BS
				if (MediaInicial == 0) {

					bsMin[k] = meterBubleSort.registerMeter.processingTotal;

				} else if (bbMin[k] > meterBubleSort.registerMeter.processingTotal) {

					bsMin[k] = meterBubleSort.registerMeter.processingTotal;

				}

				// MAX BS
				if (MediaInicial == 0) {

					bsMax[k] = meterBubleSort.registerMeter.processingTotal;

				} else if (bsMin[k] < meterBubleSort.registerMeter.processingTotal) {

					bsMax[k] = meterBubleSort.registerMeter.processingTotal;

				}
			}

			gravadorBB.escreve("\n\r");
			gravadorBS.escreve("\n\r");

			MediaInicial++;

		}

		MediaInicial = 0;

		for (int i = 0; i < n.length; ++i) {

			bsMedio[i] = bsMedio[i] / MediaParada;

			// System.out.println("---------Media----------");
			bbMedio[i] = bbMedio[i] / MediaParada;
			// System.out.println(bb[i]);
			// }

		}

		TableMeter table;
		// System.out.println(" ");

		table = TableMeter.getInstance();
		// registryMeter register;
		List<registryMeter> list = table.getTable();

		for (registryMeter register : list) {
			// System.out.println(register);
			// System.out.println(" ");
		}

		// FIM DOS TESTES BUSCA BINARIA E BUBLE SORT

		// ----------------------------------------------------------------//

		while (MediaInicial != MediaParada) {
			// TESTE COUNT SORT
			for (int k = 0; k < n.length; ++k) {
				// System.out.println("Test Simples");
				int[] vetor2 = new int[(int) n[k]];
				for (int i = 0; i < vetor2.length; ++i) {
					vetor2[i] = (int) (Math.random() * n[k]);
				}

				for (int i = 0; i < vetor2.length; ++i) {
					// System.out.print(vetor2[i] + " ");
				}
				// System.out.println("");

				efficiencyMeter meterCountSort = new efficiencyMeter();

				vetor2 = countSort(vetor2, meterCountSort);

				for (int i = 0; i < vetor2.length; ++i) {
					// System.out.print(vetor2[i] + " ");
				}
				// System.out.println("");
				// System.out.println("");
				// System.out.println("Tabela de medicao");

				meterCountSort.finalizador(0, 0, "Count Sort", (int) n[k],
						meterCountSort);
				cs[k] += meterCountSort.registerMeter.processingTotal;

				gravadorCS.escreve(String
						.valueOf(meterCountSort.registerMeter.processingTotal));
				gravadorCS.escreve(" ");

				// MIN CS
				if (MediaInicial == 0) {

					csMin[k] = meterCountSort.registerMeter.processingTotal;

				} else if (csMin[k] > meterCountSort.registerMeter.processingTotal) {

					csMin[k] = meterCountSort.registerMeter.processingTotal;

				}

				// MAX CS
				if (MediaInicial == 0) {

					csMax[k] = meterCountSort.registerMeter.processingTotal;

				} else if (csMin[k] < meterCountSort.registerMeter.processingTotal) {

					csMax[k] = meterCountSort.registerMeter.processingTotal;

				}

			}
			gravadorCS.escreve("\n\r");
			MediaInicial++;

		}

		MediaInicial = 0;

		for (int i = 0; i < n.length; ++i) {

			cs[i] = cs[i] / MediaParada;
		}
		// FIM DOS TESTES COUNT SORT

		// ----------------------------------------------------------------//

		while (MediaInicial != MediaParada) {
			// TESTE MERGE SORT E QUICK SORT
			for (int k = 0; k < n.length; ++k) {
				// System.out.println("Test Simples");
				int[] vetor3 = new int[(int) n[k]];
				int[] vetor4 = new int[(int) n[k]];
				for (int i = 0; i < vetor3.length; ++i) {
					vetor3[i] = (int) (Math.random() * n[k]);
					vetor4[i] = (int) vetor3[i];
				}

				for (int i = 0; i < vetor3.length; ++i) {
					// System.out.print(vetor3[i] + " ");
				}

				efficiencyMeter meterQuickSort = new efficiencyMeter();
				efficiencyMeter meterMergeSort = new efficiencyMeter();

				// System.out.println("");

				mergeSort(vetor3, 0, vetor3.length - 1, meterMergeSort);
				quickSort(vetor4, 0, vetor4.length - 1, meterQuickSort);

				for (int i = 0; i < vetor3.length; ++i) {
					// System.out.print(vetor3[i] + " ");
				}
				// System.out.println("");
				// System.out.println("");
				// System.out.println("Tabela de medicao");

				meterMergeSort.finalizador(0, 0, "Merge Sort", (int) n[k],
						meterMergeSort);
				meterQuickSort.finalizador(0, 0, "Quick Sort", (int) n[k],
						meterQuickSort);

				gravadorMS.escreve(String
						.valueOf(meterMergeSort.registerMeter.processingTotal));
				gravadorMS.escreve(" ");

				gravadorQS.escreve(String
						.valueOf(meterQuickSort.registerMeter.processingTotal));
				gravadorQS.escreve(" ");

				msMedio[k] += meterMergeSort.registerMeter.processingTotal;

				qsMedio[k] += meterQuickSort.registerMeter.processingTotal;

				// MIN MS
				if (MediaInicial == 0) {

					msMin[k] = meterMergeSort.registerMeter.processingTotal;

				} else if (msMin[k] > meterMergeSort.registerMeter.processingTotal) {

					msMin[k] = meterMergeSort.registerMeter.processingTotal;

				}

				// MAX MS
				if (MediaInicial == 0) {

					msMax[k] = meterMergeSort.registerMeter.processingTotal;

				} else if (msMax[k] < meterMergeSort.registerMeter.processingTotal) {

					msMax[k] = meterMergeSort.registerMeter.processingTotal;

				}

				// MIN QS
				if (MediaInicial == 0) {

					qsMin[k] = meterQuickSort.registerMeter.processingTotal;

				} else if (qsMin[k] > meterQuickSort.registerMeter.processingTotal) {

					qsMin[k] = meterQuickSort.registerMeter.processingTotal;

				}

				// MAX QS
				if (MediaInicial == 0) {

					qsMax[k] = meterQuickSort.registerMeter.processingTotal;

				} else if (bsMin[k] < meterQuickSort.registerMeter.processingTotal) {

					qsMax[k] = meterQuickSort.registerMeter.processingTotal;

				}

			}
			gravadorMS.escreve("\n\r");
			gravadorQS.escreve("\n\r");

			MediaInicial++;

		}

		MediaInicial = 0;

		for (int i = 0; i < n.length; ++i) {

			msMedio[i] = msMedio[i] / MediaParada;
			qsMedio[i] = qsMedio[i] / MediaParada;

		}

		TableMeter table1;
		// System.out.println(" ");

		table1 = TableMeter.getInstance();
		// registryMeter register;
		List<registryMeter> list1 = table.getTable();

		for (registryMeter register : list1) {

			// System.out.println(register);
			// System.out.println(" ");

		}
		// FIM DOS TESTES MERGE SORT E QUICK SORT

		// ----------------------------------------------------------------//

		// GERANDO GRAFICOS DE CRESCIMENTO
		//ReportGraph reportGraph = new ReportGraph();

		// reportGraph.addSeries("Bublle Sort");
		// reportGraph.addSeries("Busca Binaria");
		// reportGraph.addSeries("Count Sort");
		// reportGraph.addSeries("Merge Sort");
		// reportGraph.addSeries("Quick Sort");
		// reportGraph.showSeries();
		// FIM DA GERAcaoO DOS GRaFICOS

		// ----------------------------------------------------------------//

		// CLASSIFICACAO POR LAGRANGE

		double alpha = 355;
		double beta = 680;

		System.out.println("--------Caixeiro Viajante-------");
		System.out.println("--------Caso Aleat�rio-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(cvMedio[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, cvMedio)));

		System.out.println(" ");

		System.out.println("--------Bublle Sort-------");
		System.out.println("--------Melhor caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(bsMin[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, bsMin)));

		System.out.println("--------Medio caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(bsMedio[j]);

		}

		System.out.println(Math.abs(Lagrange.fC(alpha, beta, bsMedio)));

		System.out.println("--------Pior caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(bsMax[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, bsMax)));

		System.out.println(" ");

		System.out.println("--------Busca Binaria-------");
		System.out.println("--------Melhor caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(bbMin[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, bbMin)));

		System.out.println("--------Medio caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(bbMedio[j]);

		}

		System.out.println(Math.abs(Lagrange.fC(alpha, beta, bbMedio)));

		System.out.println("--------Pior caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(bbMax[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, bbMax)));

		System.out.println(" ");

		System.out.println("--------Count Sort-------");
		System.out.println("--------Melhor caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(csMin[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, csMin)));

		System.out.println("--------Medio caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(cs[j]);

		}

		System.out.println(Math.abs(Lagrange.fC(alpha, beta, cs)));

		System.out.println("--------Pior caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(csMax[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, csMax)));

		System.out.println(" ");

		System.out.println("--------Merge Sort-------");
		System.out.println("--------Melhor caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(msMin[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, msMin)));

		System.out.println("--------Medio caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(msMedio[j]);

		}

		System.out.println(Math.abs(Lagrange.fC(alpha, beta, msMedio)));

		System.out.println("--------Pior caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(msMax[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, msMax)));

		System.out.println(" ");

		System.out.println("--------Quick Sort-------");
		System.out.println("--------Melhor caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(qsMin[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, qsMin)));

		System.out.println("--------Medio caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(qsMedio[j]);

		}

		System.out.println(Math.abs(Lagrange.fC(alpha, beta, qsMedio)));

		System.out.println("--------Pior caso-------");

		for (int j = 0; j < msMax.length; j++) {

			System.out.println(qsMax[j]);

		}
		System.out.println(Math.abs(Lagrange.fC(alpha, beta, qsMax)));

		System.out.println(" ");

		System.out.println("-------------------");
		System.out.println("---------Classificacao----------");
		System.out.println("------Constante-----");

		System.out.println("0");

		System.out.println("-------------------");

		System.out.println("-----Linear-----");

		System.out.println(Math.abs(beta - alpha));

		System.out.println("-------------------");

		System.out.println("-----Quadratica-----");

		System.out.println(Math.abs((beta - alpha) / 2));

		System.out.println("-------------------");

		System.out.println("----Cubica-----");

		System.out.println(Math.abs((beta - alpha) / 3));

		System.out.println("-------------------");

		System.out.println("----LogN-----");

		System.out.println(Math.abs((beta * (Math.log(beta)))
				- (alpha * (Math.log(alpha)))));

		System.out.println("-------------------");

		System.out.println("----NLogN-----");

		System.out.println(Math.abs(((beta * (Math.log(beta))) / (1 + (Math
				.log(beta))))
				- ((alpha * (Math.log(alpha))) / (1 + (Math.log(alpha))))));

		System.out.println("-------------------");

		// FIM DA CLASSIFICA��O

	}

	public static final int NOT_FOUND = -1;

	/**
	 * @return posi��o onde o item foi encontrado, ou n�o.
	 */

	// BOSO SORT
	public static void bogoSort(int length, int range) {
		int[] array = randomIntArray(length, range);

		while (!isSorted(array))
			array = randomArray(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	private static boolean isSorted(int[] array) {
		for (int i = 0; i < (array.length - 1); ++i) {
			if (array[i] > array[i + 1])
				return false;
		}

		return true;
	}

	private static int[] randomArray(int[] array) {

		int size = array.length;
		int[] indices = new int[size];
		for (int i = 0; i < size; i++) {
			indices[i] = i;
		}

		Random random = new Random();
		for (int i = 0; i < size; i++) {
			boolean unique = false;
			int nRandom = 0;
			while (!unique) {
				unique = true;
				nRandom = random.nextInt(size);
				for (int j = 0; j < i; j++) {
					if (indices[j] == nRandom) {
						unique = false;
						break;
					}
				}
			}

			indices[i] = nRandom;
		}

		int[] result = new int[size];
		for (int k = 0; k < size; k++) {
			result[indices[k]] = array[k];
		}

		return result;
	}

	private static int[] randomIntArray(int length, int n) {
		int[] a = new int[length];
		Random generator = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = generator.nextInt(n);
		}
		return a;
	}

	// FIM BOSO SORT

	public static int binarySearch(int[] a, int x, efficiencyMeter medidor) {

		int low = 0;
		medidor.simpleVariableAllocation();

		int high = a.length - 1;
		medidor.simpleVariableAllocation();
		medidor.operationAritimetic();

		int mid;

		medidor.simpleVariableAllocation();

		while (low <= high) {
			medidor.operationLogic();

			mid = (low + high) / 2;
			medidor.attributionVariable();
			medidor.operationAritimetic();
			medidor.operationAritimetic();

			// Promeiro IF
			medidor.indexArray();
			medidor.operationLogic();

			// Primeiro ELSE
			medidor.indexArray();
			medidor.operationLogic();

			// Segundo ELSE
			medidor.operationLogic();

			if (a[mid] > x) {
				high = mid - 1;
				medidor.operationAritimetic();
				medidor.attributionVariable();
			} else if (a[mid] < x) {
				low = mid + 1;
				medidor.attributionVariable();
				medidor.operationLogic();
			} else {

				medidor.methodReturn();
				return mid;
			}
		}
		medidor.operationLogic();

		medidor.simpleVariableDeAllocation();
		medidor.simpleVariableDeAllocation();
		medidor.simpleVariableDeAllocation();

		medidor.methodReturn();
		return NOT_FOUND; // NOT_FOUND = -1
	}

	public static int[] bublleSort(int[] vetor, efficiencyMeter medidor) {

		// C�digo simulador do interpretador.
		// inicializa��o de i
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int k = 0; k < vetor.length; ++k) {
			// compara��o de i com v.lenght
			medidor.operation();

			// inicializa��o de j
			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			for (int l = k + 1; l < vetor.length; ++l) {
				// compara��o de j com v.lenght
				medidor.operation();

				// Indexa��o de v[i]
				medidor.indexArray();
				// Indexa��o de v[j]
				medidor.indexArray();
				// Compara��o de v[i] com v[j]
				medidor.operation();

				// medidor.operacaoAritmetica; Fazer alter��es
				// medidor.operacaoLogica; Fazer alter��es

				if (vetor[k] > vetor[l]) {
					int aux = vetor[k];
					// Inicializacao de aux
					medidor.simpleVariableAllocation();
					// Indexa��o de v[k]
					medidor.indexArray();
					// Atribui��o
					medidor.attributionArray();

					vetor[k] = vetor[l];
					// Indexa��o v[k]
					medidor.indexArray();
					// Indexa��o v[l]
					medidor.indexArray();
					// Atribui��o
					medidor.attributionArray();

					vetor[l] = aux;
					// Indexa��o v[k]
					medidor.indexArray();
					// Atribui��o
					medidor.attributionArray();
					medidor.simpleVariableDeAllocation();
				}

				// Adi��o j+1
				// atribui��o de j
				medidor.attributionVariable();
				medidor.operation();
			}
			// compara��o de j com v.lenght (esta �ltima compara��o
			// dar� false e
			// sair� do for interno)
			medidor.operation();
			medidor.simpleVariableDeAllocation();

			// Adi��o i+1
			// atribui��o de i
			medidor.operation();
			medidor.attributionVariable();
		}
		// compara��o de i com v.lenght (esta �ltima compara��o dar�
		// false e
		// sair� do for externo)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		return vetor;

	}

	public static int[] countSort(int[] vetor, efficiencyMeter medidor) {

		// Alocacao do vetor a ser ordenado.
		int B[] = new int[vetor.length];
		medidor.arrayAllocation(vetor.length);

		// procurando o maior elemento
		// Aloca��o Simples "maior";
		int maior = 0;
		medidor.simpleVariableAllocation();

		// Aloca��o Simples "i" do for
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 0; i < vetor.length; ++i) {
			// Compara��o i com o tamanho do vetor;
			medidor.operationLogic();

			// Indexa��o e compara��o do vetor com a variavel;
			medidor.indexArray();
			medidor.operationLogic();
			if (vetor[i] > maior) {
				maior = vetor[i];
			}
			// atribi��o da vari�vel com a indexa��o do vetor;
			medidor.attributionVariable();
			medidor.indexArray();

			// Adi��o i+1
			// atribui��o de i
			medidor.attributionVariable();
			medidor.operation();
		}

		// compara��o de i com v.lenght (esta �ltima compara��o dar�
		// false e
		// sair� do for interno)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		// Aloca��o de Vetor de contagens
		int C[] = new int[maior + 1];
		medidor.arrayAllocation(maior + 1);

		// Aloca��o Simples "i" do for
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 0; i < vetor.length; ++i) {
			// Compara��o i com o tamanho do vetor;
			medidor.operationLogic();

			C[vetor[i]] = C[vetor[i]] + 1;
			// Indexa��es e atribui��es
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.operationAritimetic();
			medidor.attributionArray();

			// Adi��o i+1
			// atribui��o de i
			medidor.attributionVariable();
			medidor.operation();
		}
		// compara��o de i com v.lenght (esta �ltima compara��o dar�
		// false e
		// sair� do for interno)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		// Aloca��o Simples "i" do for
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = 1; i < C.length; ++i) {
			// Compara��o i com o tamanho do vetor;
			medidor.operationLogic();

			C[i] = C[i] + C[i - 1];
			// indexa��es atribui��es e opera��es
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.attributionArray();
			medidor.operationAritimetic();
			medidor.operationAritimetic();

			// Adi��o i+1
			// atribui��o de i
			medidor.attributionVariable();
			medidor.operation();
		}

		// compara��o de i com v.lenght (esta �ltima compara��o dar�
		// false e
		// sair� do for interno)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		// Aloca��o Simples "i" do for
		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		for (int i = vetor.length - 1; i >= 0; --i) {
			// Compara��o i com o tamanho do vetor;
			medidor.operationLogic();

			B[C[vetor[i]] - 1] = vetor[i];
			// Indexa��es opera��es atribui�oes
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.operationAritimetic();
			medidor.attributionArray();

			C[vetor[i]] = C[vetor[i]] - 1;
			// Indexa��es opera��es atribui�oes
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.indexArray();
			medidor.operationAritimetic();
			medidor.attributionArray();

			// Adi��o i+1
			// atribui��o de i
			medidor.attributionVariable();
			medidor.operation();
		}

		// compara��o de i com v.lenght (esta �ltima compara��o dar�
		// false e
		// sair� do for interno)
		medidor.operation();
		medidor.simpleVariableDeAllocation();

		// Desaloca��o maior
		medidor.simpleVariableDeAllocation();

		// desaloca��o dos vetores;
		medidor.arrayDeAllocation(maior + 1);
		medidor.arrayDeAllocation(vetor.length);

		return B;

	}

	// Merge Sort
	private static int[] mergeSort(int[] vetor, int inicio, int fim,
			efficiencyMeter medidor) {
		medidor.methodInvocation();

		medidor.operationLogic();
		if (inicio < fim) {

			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			medidor.operationAritimetic();
			medidor.operationAritimetic();
			medidor.operationAritimetic();
			int meio = (inicio + fim - 1) / 2;

			mergeSort(vetor, inicio, meio, medidor);

			medidor.operationAritimetic();
			mergeSort(vetor, meio + 1, fim, medidor);

			medidor.methodInvocation();
			merge(vetor, inicio, meio, fim, medidor);

			medidor.simpleVariableDeAllocation();
		}

		medidor.methodReturn();

		return vetor;

	}

	/*
	 * Ordena dois trechos ordenados e adjacente de vetores e ordena-os
	 * conjuntamente
	 */
	private static void merge(int[] vetor, int inicio, int meio, int fim,
			efficiencyMeter medidor) {
		if (inicio < fim) {
			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			medidor.operationAritimetic();
			medidor.operationAritimetic();
			int tamanho = fim - inicio + 1;

			/*
			 * Inicializa��o de um vetor temporario para auxiliar na
			 * ordena��o O vetor tempor�rio � uma c�pia do trecho que
			 * ser� ordenado
			 */

			medidor.arrayAllocation(tamanho);
			int[] temp = new int[tamanho];

			// Como contar o array copy;;
			medidor.simpleVariableAllocation();
			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			medidor.attributionVariable();

			for (int i = inicio, j = 0; i <= fim; ++i, ++j) {
				medidor.operationLogic();

				medidor.indexArray();
				medidor.indexArray();
				medidor.attributionVariable();
				temp[j] = vetor[i];

				medidor.attributionVariable();
				medidor.operationAritimetic();
				medidor.attributionVariable();
				medidor.operationAritimetic();
			}

			medidor.operationLogic();
			medidor.simpleVariableDeAllocation();
			medidor.simpleVariableDeAllocation();

			// System.arraycopy(vetor, inicio, temp, 0, tamanho);

			/*
			 * La�o para ordena��o do vetor, utilizando o vetor
			 * tempor�rio, usando �ndices i e j para cada trecho de vetor da
			 * mesclagem
			 */

			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			int i = 0;

			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			medidor.operationAritimetic();
			medidor.operationAritimetic();
			int j = meio - inicio + 1;

			// A depender das condi��es, recebe um elemento de um trecho ou
			// outro
			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			for (int posicao = 0; posicao < tamanho; posicao++) {
				medidor.operationLogic();

				medidor.operationAritimetic();
				medidor.operationLogic();
				if (j <= tamanho - 1) {

					medidor.operationAritimetic();
					medidor.operationLogic();
					if (i <= meio - inicio) {

						medidor.operationAritimetic();
						medidor.indexArray();
						medidor.indexArray();
						if (temp[i] < temp[j]) {

							medidor.indexArray();
							medidor.indexArray();
							medidor.operationAritimetic();
							medidor.operationAritimetic();
							medidor.attributionArray();
							vetor[inicio + posicao] = temp[i++];
						} else {

							medidor.indexArray();
							medidor.indexArray();
							medidor.operationAritimetic();
							medidor.operationAritimetic();
							medidor.attributionArray();
							vetor[inicio + posicao] = temp[j++];
						}
					} else {

						medidor.indexArray();
						medidor.indexArray();
						medidor.operationAritimetic();
						medidor.operationAritimetic();
						medidor.attributionArray();
						vetor[inicio + posicao] = temp[j++];
					}
				} else {

					medidor.indexArray();
					medidor.indexArray();
					medidor.operationAritimetic();
					medidor.operationAritimetic();
					medidor.attributionArray();
					vetor[inicio + posicao] = temp[i++];
				}

				medidor.attributionVariable();
				medidor.operation();
			}

			medidor.operation();
			medidor.simpleVariableDeAllocation();

			medidor.simpleVariableDeAllocation();
			medidor.simpleVariableDeAllocation();
			medidor.simpleVariableDeAllocation();

			medidor.arrayDeAllocation(tamanho);
		}
		medidor.methodReturn();
	}

	// Quick Sort
	public static void quickSort(int[] vetor, int inicio, int fim,
			efficiencyMeter medidor) {

		medidor.operationLogic();
		if (inicio < fim) {

			medidor.simpleVariableAllocation();
			medidor.attributionVariable();
			medidor.methodInvocation();
			int q = Partition(vetor, inicio, fim, medidor);

			medidor.methodInvocation();
			medidor.operationAritimetic();
			quickSort(vetor, inicio, q - 1, medidor);

			medidor.methodInvocation();
			medidor.operationAritimetic();
			quickSort(vetor, q + 1, fim, medidor);

			medidor.simpleVariableDeAllocation();
		}

		medidor.methodReturn();
	}

	// Patition
	public static int Partition(int[] vetor, int inicio, int fim,
			efficiencyMeter medidor) {

		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		medidor.indexArray();
		int x = vetor[inicio];

		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		medidor.operationAritimetic();
		int a = inicio + 1;

		medidor.simpleVariableAllocation();
		medidor.attributionVariable();
		int b = fim;

		while (true) {
			medidor.operationLogic();

			while ((a <= fim) && (vetor[a] <= x)) {
				medidor.operationLogic();
				medidor.operationLogic();
				medidor.operationLogic();
				// medidor.operationLogic();
				medidor.indexArray();

				medidor.operationAritimetic();
				medidor.attributionVariable();
				++a;
			}
			medidor.operationLogic();
			medidor.operationLogic();
			medidor.operationLogic();
			medidor.indexArray();

			while ((b > inicio) && (vetor[b] >= x)) {
				medidor.operationLogic();
				medidor.operationLogic();
				medidor.operationLogic();
				medidor.indexArray();

				medidor.operationAritimetic();
				medidor.attributionVariable();
				--b;
			}
			medidor.operationLogic();
			medidor.operationLogic();
			medidor.operationLogic();
			medidor.indexArray();

			medidor.operationLogic();
			if (a <= b) {
				medidor.attributionVariable();
				medidor.simpleVariableAllocation();
				medidor.indexArray();
				int aux = vetor[a];
				medidor.attributionVariable();
				medidor.indexArray();
				medidor.indexArray();
				vetor[a] = vetor[b];
				medidor.attributionVariable();
				medidor.indexArray();
				vetor[b] = aux;

				medidor.simpleVariableDeAllocation();
			} else {

				medidor.attributionVariable();
				medidor.simpleVariableAllocation();
				medidor.indexArray();
				int aux = vetor[inicio];
				medidor.attributionVariable();
				medidor.indexArray();
				medidor.indexArray();
				vetor[inicio] = vetor[b];
				medidor.attributionVariable();
				medidor.indexArray();
				vetor[b] = aux;

				medidor.simpleVariableDeAllocation();

				medidor.methodReturn();
				return b;
			}
		}
	}

	// Swap
	private static void swap(int[] vetor, int a, int b, efficiencyMeter medidor) {

		medidor.simpleVariableAllocation();
		medidor.indexArray();
		medidor.attributionVariable();
		int tmp = vetor[a];

		medidor.indexArray();
		medidor.indexArray();
		medidor.attributionVariable();
		vetor[a] = vetor[b];

		medidor.indexArray();
		medidor.attributionVariable();
		vetor[b] = tmp;

		medidor.simpleVariableDeAllocation();

		medidor.methodReturn();
	}

	// Merge Sort
	private static int[] mergeSort1(int[] vetor, int inicio, int fim) {

		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort1(vetor, inicio, meio);
			mergeSort1(vetor, meio + 1, fim);
			merge1(vetor, inicio, meio, fim);
		}
		return vetor;

	}

	/*
	 * Ordena dois trechos ordenados e adjacente de vetores e ordena-os
	 * conjuntamente
	 */
	private static void merge1(int[] vetor, int inicio, int meio, int fim) {

		int tamanho = fim - inicio + 1;

		/*
		 * Inicializa��o de um vetor temporario para auxiliar na
		 * ordena��o O vetor tempor�rio � uma c�pia do trecho que
		 * ser� ordenado
		 */

		int[] temp = new int[tamanho];

		for (int i = inicio, j = 0; i <= fim; ++i, ++j) {
			// medidor.operationLogic();

			// medidor.indexArray();
			// medidor.indexArray();
			// medidor.attributionVariable();
			temp[j] = vetor[i];

			// medidor.attributionVariable();
			// medidor.operationAritimetic();
			// medidor.attributionVariable();
			// medidor.operationAritimetic();
		}

		// medidor.operationLogic();
		// medidor.simpleVariableDeAllocation();
		// medidor.simpleVariableDeAllocation();
		// System.arraycopy(vetor, inicio, temp, 0, tamanho);

		/*
		 * La�o para ordena��o do vetor, utilizando o vetor tempor�rio,
		 * usando �ndices i e j para cada trecho de vetor da mesclagem
		 */

		int i = 0;
		int j = meio - inicio + 1;

		// A depender das condi��es, recebe um elemento de um trecho ou
		// outro
		for (int posicao = 0; posicao < tamanho; posicao++) {
			if (j <= tamanho - 1) {
				if (i <= meio - inicio) {
					if (temp[i] < temp[j]) {
						vetor[inicio + posicao] = temp[i++];
					} else {
						vetor[inicio + posicao] = temp[j++];
					}
				} else {
					vetor[inicio + posicao] = temp[j++];
				}
			} else {
				vetor[inicio + posicao] = temp[i++];
			}
		}
	}
}
