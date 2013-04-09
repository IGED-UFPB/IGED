package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

public class VectorGenerate {

	public final int[] generateMelhor() {
		
		double[] n = Lagrange.VetorX;
		
		
		
		for (int k = 0; k < n.length; ++k) {
			// System.out.println("Test Simples");
			int[] vetorMelhor = new int[(int) n[k]];
			for (int i = 0; i < vetorMelhor.length; ++i) {
				
				
				vetorMelhor[i] = (int) (Math.random() * n[k]);
			
			}

		

		return null;
	}

	public final int[] generatePior() {

		return null;
	}

	public final int[] generateMedio() {

		return null;
	}

}
