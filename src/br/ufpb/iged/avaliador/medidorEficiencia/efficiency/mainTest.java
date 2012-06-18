package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

import br.ufpb.iged.avaliador.medidorEficiencia.gui.ReportGraph;

import java.util.List;

public class mainTest {

    public static void main(String[] args) {

        int n[] = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

        //Meter usado na busca binária!!!
        efficiencyMeter meter1 = new efficiencyMeter();
        
        // tableMeter table = new tableMeter();

        // Test Simples Bublle Sort

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
            meter1.finalizador(0, 0, "Busca Binária", n[k], meter1);
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

        for (int k = 0; k < n.length; ++k) {
            System.out.println("Test Simples");
            int[] vetor3 = new int[n[k]];
            for (int i = 0; i < vetor3.length; ++i) {
                vetor3[i] = (int) (Math.random() * 100);
            }

            efficiencyMeter meter = new efficiencyMeter();

            for (int i = 0; i < vetor3.length; ++i) {
                System.out.print(vetor3[i] + " ");
            }
            System.out.println("");

            mergeSort(vetor3, 0, vetor3.length - 1, meter);

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
        reportGraph.addSeries("Busca Binária");
        reportGraph.showSeries();

    }


  public static final int NOT_FOUND = -1;
    
    /**
     * @return posição onde o item foi encontrado, ou não.
     */
    public static int binarySearch( int [ ] a, int x, efficiencyMeter medidor)
    {
        int low = 0;
        medidor.simpleVariableAllocation();
        
        int high = a.length - 1;
        medidor.simpleVariableAllocation();
        
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

        // Cï¿½digo simulador do interpretador.
        // inicializaï¿½ï¿½o de i
        medidor.simpleVariableAllocation();
        medidor.attributionVariable();
        for (int k = 0; k < vetor.length; ++k) {
            // comparaï¿½ï¿½o de i com v.lenght
            medidor.operation();

            // inicializaï¿½ï¿½o de j
            medidor.simpleVariableAllocation();
            medidor.attributionVariable();
            for (int l = k + 1; l < vetor.length; ++l) {
                // comparaï¿½ï¿½o de j com v.lenght
                medidor.operation();

                // Indexaï¿½ï¿½o de v[i]
                medidor.indexArray();
                // Indexaï¿½ï¿½o de v[j]
                medidor.indexArray();
                // Comparaï¿½ï¿½o de v[i] com v[j]
                medidor.operation();

                // medidor.operacaoAritmetica; Fazer alterï¿½ï¿½es
                // medidor.operacaoLogica; Fazer alterï¿½ï¿½es

                if (vetor[k] > vetor[l]) {
                    int aux = vetor[k];
                    // Inicializacao de aux
                    medidor.simpleVariableAllocation();
                    // Indexaï¿½ï¿½o de v[k]
                    medidor.indexArray();
                    // Atribuiï¿½ï¿½o
                    medidor.attributionArray();

                    vetor[k] = vetor[l];
                    // Indexaï¿½ï¿½o v[k]
                    medidor.indexArray();
                    // Indexaï¿½ï¿½o v[l]
                    medidor.indexArray();
                    // Atribuiï¿½ï¿½o
                    medidor.attributionArray();

                    vetor[l] = aux;
                    // Indexaï¿½ï¿½o v[k]
                    medidor.indexArray();
                    // Atribuiï¿½ï¿½o
                    medidor.attributionArray();
                    medidor.simpleVariableDeAllocation();
                }

                // Adiï¿½ï¿½o j+1
                // atribuiï¿½ï¿½o de j
                medidor.attributionVariable();
                medidor.operation();
            }
            // comparaï¿½ï¿½o de j com v.lenght (esta ï¿½ltima comparaï¿½ï¿½o
            // darï¿½ false e
            // sairï¿½ do for interno)
            medidor.operation();
            medidor.simpleVariableDeAllocation();

            // Adiï¿½ï¿½o i+1
            // atribuiï¿½ï¿½o de i
            medidor.operation();
            medidor.attributionVariable();
        }
        // comparaï¿½ï¿½o de i com v.lenght (esta ï¿½ltima comparaï¿½ï¿½o darï¿½
        // false e
        // sairï¿½ do for externo)
        medidor.operation();
        medidor.simpleVariableDeAllocation();

        return vetor;

    }

    public static int[] countSort(int[] vetor, efficiencyMeter medidor) {

        // Alocacao do vetor a ser ordenado.
        int B[] = new int[vetor.length];
        medidor.arrayAllocation(vetor.length);

        // procurando o maior elemento
        // Alocaï¿½ï¿½o Simples "maior";
        int maior = 0;
        medidor.simpleVariableAllocation();

        // Alocaï¿½ï¿½o Simples "i" do for
        medidor.simpleVariableAllocation();
        medidor.attributionVariable();
        for (int i = 0; i < vetor.length; ++i) {
            // Comparaï¿½ï¿½o i com o tamanho do vetor;
            medidor.operationLogic();

            // Indexaï¿½ï¿½o e comparaï¿½ï¿½o do vetor com a variavel;
            medidor.indexArray();
            medidor.operationLogic();
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
            // atribiï¿½ï¿½o da variï¿½vel com a indexaï¿½ï¿½o do vetor;
            medidor.attributionVariable();
            medidor.indexArray();

            // Adiï¿½ï¿½o i+1
            // atribuiï¿½ï¿½o de i
            medidor.attributionVariable();
            medidor.operation();
        }

        // comparaï¿½ï¿½o de i com v.lenght (esta ï¿½ltima comparaï¿½ï¿½o darï¿½
        // false e
        // sairï¿½ do for interno)
        medidor.operation();
        medidor.simpleVariableDeAllocation();

        // Alocaï¿½ï¿½o de Vetor de contagens
        int C[] = new int[maior + 1];
        medidor.arrayAllocation(maior + 1);

        // Alocaï¿½ï¿½o Simples "i" do for
        medidor.simpleVariableAllocation();
        medidor.attributionVariable();
        for (int i = 0; i < vetor.length; ++i) {
            // Comparaï¿½ï¿½o i com o tamanho do vetor;
            medidor.operationLogic();

            C[vetor[i]] = C[vetor[i]] + 1;
            // Indexaï¿½ï¿½es e atribuiï¿½ï¿½es
            medidor.indexArray();
            medidor.indexArray();
            medidor.indexArray();
            medidor.indexArray();
            medidor.operationAritimetic();
            medidor.attributionArray();

            // Adiï¿½ï¿½o i+1
            // atribuiï¿½ï¿½o de i
            medidor.attributionVariable();
            medidor.operation();
        }
        // comparaï¿½ï¿½o de i com v.lenght (esta ï¿½ltima comparaï¿½ï¿½o darï¿½
        // false e
        // sairï¿½ do for interno)
        medidor.operation();
        medidor.simpleVariableDeAllocation();

        // Alocaï¿½ï¿½o Simples "i" do for
        medidor.simpleVariableAllocation();
        medidor.attributionVariable();
        for (int i = 1; i < C.length; ++i) {
            // Comparaï¿½ï¿½o i com o tamanho do vetor;
            medidor.operationLogic();

            C[i] = C[i] + C[i - 1];
            // indexaï¿½ï¿½es atribuiï¿½ï¿½es e operaï¿½ï¿½es
            medidor.indexArray();
            medidor.indexArray();
            medidor.indexArray();
            medidor.attributionArray();
            medidor.operationAritimetic();
            medidor.operationAritimetic();

            // Adiï¿½ï¿½o i+1
            // atribuiï¿½ï¿½o de i
            medidor.attributionVariable();
            medidor.operation();
        }

        // comparaï¿½ï¿½o de i com v.lenght (esta ï¿½ltima comparaï¿½ï¿½o darï¿½
        // false e
        // sairï¿½ do for interno)
        medidor.operation();
        medidor.simpleVariableDeAllocation();

        // Alocaï¿½ï¿½o Simples "i" do for
        medidor.simpleVariableAllocation();
        medidor.attributionVariable();
        for (int i = vetor.length - 1; i >= 0; --i) {
            // Comparaï¿½ï¿½o i com o tamanho do vetor;
            medidor.operationLogic();

            B[C[vetor[i]] - 1] = vetor[i];
            // Indexaï¿½ï¿½es operaï¿½ï¿½es atribuiï¿½oes
            medidor.indexArray();
            medidor.indexArray();
            medidor.indexArray();
            medidor.indexArray();
            medidor.operationAritimetic();
            medidor.attributionArray();

            C[vetor[i]] = C[vetor[i]] - 1;
            // Indexaï¿½ï¿½es operaï¿½ï¿½es atribuiï¿½oes
            medidor.indexArray();
            medidor.indexArray();
            medidor.indexArray();
            medidor.indexArray();
            medidor.operationAritimetic();
            medidor.attributionArray();

            // Adiï¿½ï¿½o i+1
            // atribuiï¿½ï¿½o de i
            medidor.attributionVariable();
            medidor.operation();
        }

        // comparaï¿½ï¿½o de i com v.lenght (esta ï¿½ltima comparaï¿½ï¿½o darï¿½
        // false e
        // sairï¿½ do for interno)
        medidor.operation();
        medidor.simpleVariableDeAllocation();

        // Desalocaï¿½ï¿½o maior
        medidor.simpleVariableDeAllocation();

        // desalocaï¿½ï¿½o dos vetores;
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
             * Inicializaï¿½ï¿½o de um vetor temporario para auxiliar na ordenaï¿½ï¿½o O
             * vetor temporï¿½rio ï¿½ uma cï¿½pia do trecho que serï¿½ ordenado
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
             * Laï¿½o para ordenaï¿½ï¿½o do vetor, utilizando o vetor temporï¿½rio, usando
             * ï¿½ndices i e j para cada trecho de vetor da mesclagem
             */

            medidor.simpleVariableAllocation();
            medidor.attributionVariable();
            int i = 0;


            medidor.simpleVariableAllocation();
            medidor.attributionVariable();
            medidor.operationAritimetic();
            medidor.operationAritimetic();
            int j = meio - inicio + 1;

            //A depender das condiï¿½ï¿½es, recebe um elemento de um trecho ou outro
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
         * Inicializaï¿½ï¿½o de um vetor temporario para auxiliar na ordenaï¿½ï¿½o O
         * vetor temporï¿½rio ï¿½ uma cï¿½pia do trecho que serï¿½ ordenado
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
         * Laï¿½o para ordenaï¿½ï¿½o do vetor, utilizando o vetor temporï¿½rio, usando
         * ï¿½ndices i e j para cada trecho de vetor da mesclagem
         */

        int i = 0;
        int j = meio - inicio + 1;

        //A depender das condiï¿½ï¿½es, recebe um elemento de um trecho ou outro
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
