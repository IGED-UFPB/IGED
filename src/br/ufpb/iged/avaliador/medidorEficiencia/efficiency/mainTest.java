package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

import br.ufpb.iged.avaliador.medidorEficiencia.gui.ReportGraph;

import java.util.List;

public class mainTest {

    public static void main(String[] args) {

        int n[] = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

        //Meter usado na busca bin�ria!!!
        efficiencyMeter meter1 = new efficiencyMeter();
        
        // tableMeter table = new tableMeter();

        // Test Simples Bublle Sort
        double bb[] = new double[n.length];
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
            binarySearch(vetor1, 80, meter1);
            
            for (int i = 0; i < vetor1.length; ++i) {
                System.out.print(vetor1[i] + " ");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("Tabela de medicao");
            // System.out.println("");
            // System.out.println(meter.toString());
            // System.out.println("");

            meter.finalizador(0, 0, "Bublle Sort", n[k], meter);
            meter1.finalizador(0, 0, "Busca Binaria", n[k], meter1);
            bb[k] = meter1.registerMeter.processingTotal;
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

        // Teste Simples Count Sort

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
            System.out.println("Tabela de medicao");
            // System.out.println("");
            // System.out.println(meter.toString());
            // System.out.println("");

            meter.finalizador(0, 0, "Count Sort", n[k], meter);
        }


        // Teste Simples Count Sort
double qs[] = new double[n.length];
        for (int k = 0; k < n.length; ++k) {
            System.out.println("Test Simples");
            int[] vetor3 = new int[n[k]];
            int[] vetor4 = new int[n[k]];
            for (int i = 0; i < vetor3.length; ++i) {
                vetor3[i] = (int) (Math.random() * 100);
                vetor4[i] = (int) vetor3[i];
            }

            efficiencyMeter meter = new efficiencyMeter();
            efficiencyMeter meter2 = new efficiencyMeter();

            for (int i = 0; i < vetor3.length; ++i) {
                System.out.print(vetor3[i] + " ");
            }
            System.out.println("");

            mergeSort(vetor3, 0, vetor3.length - 1, meter);
            quickSort(vetor4, 0, vetor4.length-1, meter2);

            for (int i = 0; i < vetor3.length; ++i) {
                System.out.print(vetor3[i] + " ");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("Tabela de medicao");
            // System.out.println("");
            System.out.println(meter.toString());
            // System.out.println("");

            meter.finalizador(0, 0, "Merge Sort", n[k], meter);
            meter2.finalizador(0, 0, "Quick Sort", n[k], meter2);
            qs[k] = meter2.registerMeter.processingTotal;
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

        reportGraph.addSeries("Merge Sort");
        reportGraph.addSeries("Bublle Sort");
        reportGraph.addSeries("Count Sort");
        reportGraph.addSeries("Busca Binaria");
        reportGraph.addSeries("Quick Sort");
        reportGraph.showSeries();
        
        PearsonCorrelation c = PearsonCorrelation.getInstance();
        System.out.println("Busca Binaria:");
        for(int i=0; i<bb.length;++i)
            System.out.println(bb[i]);
        System.out.println("Cat: " + c.getCategory(bb));
        System.out.println("QS: ");
        for(int i=0; i<qs.length;++i)
            System.out.println(qs[i]);
        System.out.println("Cat: " + c.getCategory(qs));

    }


  public static final int NOT_FOUND = -1;
    
    /**
     * @return posi��o onde o item foi encontrado, ou n�o.
     */
    public static int binarySearch( int [ ] a, int x, efficiencyMeter medidor)
    {
        int low = 0;
        medidor.simpleVariableAllocation();
        
        int high = a.length - 1;
        medidor.simpleVariableAllocation();
        medidor.operationAritimetic();
        
        int mid;

        medidor.simpleVariableAllocation();
        

        while( low <= high )
        {
            mid = ( low + high ) / 2;
            medidor.attributionVariable();
            medidor.operationAritimetic();
            medidor.operationLogic();

            //Promeiro IF
            medidor.operationLogic();
            medidor.indexArray();
            medidor.operationLogic();
            medidor.operationAritimetic();
            	
            //Primeiro ELSE
            medidor.operationLogic();
            medidor.indexArray();
            medidor.operationLogic();
            medidor.operationAritimetic();
            
            //Segundo ELSE
            medidor.operationLogic();
            
          if( a[ mid ] > x ){
                low = mid + 1;
          		medidor.operationAritimetic();
          		medidor.attributionVariable();
          }else if( a[ mid ] < x ){
                high = mid - 1;
          		medidor.attributionVariable();
          		medidor.operationLogic();
          }else
              
        	  medidor.methodReturn();
        	  return mid;
        }
        medidor.operationLogic();

        medidor.simpleVariableDeAllocation();
        medidor.simpleVariableDeAllocation();
        medidor.simpleVariableDeAllocation();
        
        medidor.methodReturn();
        return NOT_FOUND;     // NOT_FOUND = -1
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
    private static int[] mergeSort(int[] vetor, int inicio, int fim, efficiencyMeter medidor) {
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
    private static void merge(int[] vetor, int inicio, int meio, int fim, efficiencyMeter medidor) {
        if (inicio < fim) {
            medidor.simpleVariableAllocation();
            medidor.attributionVariable();
            medidor.operationAritimetic();
            medidor.operationAritimetic();
            int tamanho = fim - inicio + 1;


            /*
             * Inicializa��o de um vetor temporario para auxiliar na ordena��o O
             * vetor tempor�rio � uma c�pia do trecho que ser� ordenado
             */


            medidor.arrayAllocation(tamanho);
            int[] temp = new int[tamanho];


            //Como contar o array copy;;
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

            //System.arraycopy(vetor, inicio, temp, 0, tamanho);


            /*
             * La�o para ordena��o do vetor, utilizando o vetor tempor�rio, usando
             * �ndices i e j para cada trecho de vetor da mesclagem
             */

            medidor.simpleVariableAllocation();
            medidor.attributionVariable();
            int i = 0;


            medidor.simpleVariableAllocation();
            medidor.attributionVariable();
            medidor.operationAritimetic();
            medidor.operationAritimetic();
            int j = meio - inicio + 1;

            //A depender das condi��es, recebe um elemento de um trecho ou outro
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

    //Quick Sort
    public static void quickSort(int[] vetor, int inicio, int fim, efficiencyMeter medidor) {

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
        }

        medidor.simpleVariableDeAllocation();
        medidor.methodReturn();
    }

    //Patition
    public static int Partition(int[] vetor, int inicio, int fim, efficiencyMeter medidor) {

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
                //medidor.operationLogic();
                medidor.indexArray();

                medidor.operationAritimetic();
                medidor.attributionVariable();
                ++a;
            }
            medidor.operationLogic();

            while ((b >= inicio + 1) && (vetor[b] >= x)) {
                medidor.operationLogic();
                medidor.operationLogic();
                medidor.operationLogic();
                medidor.operationAritimetic();
                medidor.indexArray();

                medidor.operationAritimetic();
                medidor.attributionVariable();
                --b;
            }
            medidor.operationLogic();


            medidor.operationLogic();
            if (a <= b) {

                medidor.methodInvocation();
                swap(vetor, a, b, medidor);

            } else {

                medidor.methodInvocation();
                swap(vetor, inicio, b, medidor);


                medidor.methodReturn();
                return b;
            }
        }
    }

    //Swap
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

    //Merge Sort
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
         * Inicializa��o de um vetor temporario para auxiliar na ordena��o O
         * vetor tempor�rio � uma c�pia do trecho que ser� ordenado
         */

        int[] temp = new int[tamanho];


        for (int i = inicio, j = 0; i <= fim; ++i, ++j) {
            //medidor.operationLogic();

            //medidor.indexArray();
            //medidor.indexArray();
            //medidor.attributionVariable();
            temp[j] = vetor[i];

            //  medidor.attributionVariable();
            //		medidor.operationAritimetic();
            //	medidor.attributionVariable();
            //medidor.operationAritimetic();
        }

        //  medidor.operationLogic();
        //	medidor.simpleVariableDeAllocation();
        //	medidor.simpleVariableDeAllocation();
        //  System.arraycopy(vetor, inicio, temp, 0, tamanho);


        /*
         * La�o para ordena��o do vetor, utilizando o vetor tempor�rio, usando
         * �ndices i e j para cada trecho de vetor da mesclagem
         */

        int i = 0;
        int j = meio - inicio + 1;

        //A depender das condi��es, recebe um elemento de um trecho ou outro
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
