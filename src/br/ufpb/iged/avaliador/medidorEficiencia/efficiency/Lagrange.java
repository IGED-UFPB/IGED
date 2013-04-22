package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;
public class Lagrange {
	
	public static double alpha ;
	public static double beta ;

	//static double[] VetorX = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };

	//static double[] VetorX = { 1, 9, 25, 49, 81, 121, 169, 225, 289, 361 };
	
	//static double[] VetorX = { 100, 400, 700, 1000, 1300, 1600, 1900, 2200, 2500, 2800};
	
	static double[] VetorX = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
	
	//static double[] VetorX = { 800, 820, 840, 880, 900, 920, 940, 960, 980, 1000};
	
	static double[] VetorY;


	public static void VetorY(){
		
		for (int i = 0; i < VetorX.length; i++) {
			
			//VetorY[i] = Math.pow(5, VetorX[i]);
			VetorY[i] = VetorX[i] * (Math.log(VetorX[i]));
			
		}
		
	}
	
	static int tamanho = 10;
	
	public static double L(double x, int m) {

		double produtorio = 1;

		for (int j = 0; j < tamanho; j++) {

			if (j != m) {

				produtorio = produtorio
						* ((x - VetorX[j]) / (VetorX[m] - VetorX[j]));

			}

		}

		return produtorio;
	}

	public static double F(double x) {

		double somatorio = 0;

		for (int j = 0; j < tamanho; j++) {

			somatorio = somatorio + VetorY[j] * L(x, j);

		}

		return somatorio;
	}

	// DERIVADA SEGUNDA DA FUNcaO

	public static double dF2(double x) {

		double resultado = 0;

		for (int m = 0; m < tamanho; m++) {

			resultado += VetorY[m] * (dL2(x, m));

		}

		return resultado;
	}

	public static double dL2(double x, int m) {

		double resultado = 0;
		double somatorioA = 0;
		double produtorio;

		for (int i = 0; i < tamanho; i++) {

			if ((i != m)) {

				double a = (1.0 / (VetorX[m] - VetorX[i]));

				double somatorioB = 0;
				
				for (int k = 0; k < tamanho; k++) {

					if (((k != i) && (k != m))) {

						double b = (1.0 / (VetorX[m] - VetorX[k]));
						
						produtorio = 1;

						for (int j = 0; j < tamanho; j++) {

							if ((j != i) && (j != k) && (j != m)) {

								produtorio *= (((x - VetorX[j]) / (VetorX[m] - VetorX[j])));

							}
								
						}
						somatorioB += b * produtorio;

					}
				}
				
				somatorioA += (somatorioB * a);
			}

		}

		resultado = somatorioA;

		return resultado;
	}

	// DERIVADA PRIMEIRA DA FUNcaO

	public static double dF1(double x) {

		double resultado = 0;

		for (int m = 0; m < tamanho; m++) {

			resultado += VetorY[m] * (dL1(x, m));

		}

		return resultado;
	}

	public static double dL1(double x, int m) {

		double resultado = 0;
		double somatorio = 0;
		double produtorio;

		for (int i = 0; i < tamanho; i++) {

			if ((i != m)) {

				double a = (1.0 / (VetorX[m] - VetorX[i]));

				produtorio = 1;

				for (int j = 0; j < tamanho; j++) {

					if ((j != i) && (j != m)) {

						produtorio *= (((x - VetorX[j]) / (VetorX[m] - VetorX[j])));

					}

				}

				somatorio += a * produtorio;

			}

		}

		resultado = somatorio;

		return resultado;
	}
	
	public static double fC(double alphaT, double betaT, double[] vetorYT){
		
		alpha = alphaT;
		beta = betaT;
		double result;
		
		VetorY = vetorYT;
		
		//System.out.println(F(alpha)/dF1(alpha));
		//System.out.println(F(beta)/dF1(beta));
		System.out.println("---------------------");
		
		result =  (F(alpha)/dF1(alpha))-(F(beta)/dF1(beta));
		
		return result;
	}

}
