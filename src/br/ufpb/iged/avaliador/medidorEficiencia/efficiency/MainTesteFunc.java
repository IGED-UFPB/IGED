package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

import br.ufpb.iged.avaliador.medidorEficiencia.gui.ReportGraph;

import java.util.List;

public class MainTesteFunc {

	public static void main(String[] args) {

		// INSTANCIAS USADAS NA MEDIÇÃO
		int n[] = PearsonCorrelation.getX();

		// ARRAYS FINAIS PARA VERIFICAÇÃO
		double bs[] = new double[n.length];
		double bb[] = new double[n.length];
		double cs[] = new double[n.length];
		double qs[] = new double[n.length];
		double ms[] = new double[n.length];

		PearsonCorrelation c = PearsonCorrelation.getInstance();
		
		cs[0] = 2.71828182;
		cs[1] = 7.389056;
		cs[2] = 20.085536;
		cs[3] = 54.598150;
		cs[4] = 148.413159;
		cs[5] = 403.428797;
		cs[6] = 1096.633158;
		cs[7] = 2980.957987;
		cs[8] = 8103.083928;
		cs[9] = 22026.46579;
		
		System.out.println("Teste Linear");
		System.out.println(c.getCategory(cs));
		
	}
}
