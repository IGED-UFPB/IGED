/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

/**
 *
 * @author GILBERTO FARIAS
 */
public class LinearRegression extends EvaluatorAsymptotic{

    @Override
    protected void initSeries() {
        
    }

    @Override
    public int getCategory(double[] y) {
        double rss[] = new double[8];
        
        //Constante
        int vars = 0; // 2
        double[] data = new double[y.length*(vars+1)];
        //double[][] dataX = new double[50][3];
        int obs = y.length;
        int j = 0;
        for (int i = 0; i < y.length; i++) {
            data[j++] = y[i];
        }
        rss[T_1] = this.getRSS(data, obs, vars);
        
        //Logaritmo
        vars = 1; // 2
        data = new double[y.length*(vars+1)];
        obs = y.length;
        j = 0;
        for (int i = 0; i < y.length; i++) {
            data[j++] = y[i];
            double v = n[i];
            data[j++] = Math.log(v)/Math.log(2);
        }
        rss[T_LN] = this.getRSS(data, obs, vars);
        
        //Linear
        vars = 1; // 2
        data = new double[y.length*(vars+1)];
        obs = y.length;
        j = 0;
        for (int i = 0; i < y.length; i++) {
            data[j++] = y[i];
            double v = n[i];
            //data[j++] = Math.log(v)/Math.log(2);
            data[j++] = v;
        }
        rss[T_N] = this.getRSS(data, obs, vars);
        
        //NLogN
        vars = 1; // 2
        data = new double[y.length*(vars+1)];
        obs = y.length;
        j = 0;
        for (int i = 0; i < y.length; i++) {
            data[j++] = y[i];
            double v = n[i];
            //data[j++] = Math.log(v)/Math.log(2);
            //data[j++] = v;
            data[j++] = v*Math.log(v)/Math.log(2);
        }
        rss[T_NLN] = this.getRSS(data, obs, vars);
        
        //Quadratico
        vars = 1; // 2
        data = new double[y.length*(vars+1)];
        obs = y.length;
        j = 0;
        for (int i = 0; i < y.length; i++) {
            data[j++] = y[i];
            double v = n[i];
            //data[j++] = Math.log(v)/Math.log(2);
            //data[j++] = v;
            //data[j++] = v*Math.log(v)/Math.log(2);
            data[j++] = v*v;
        }
        rss[T_N2] = this.getRSS(data, obs, vars);
        
        //Cubico
        vars = 1; // 2
        data = new double[y.length*(vars+1)];
        obs = y.length;
        j = 0;
        for (int i = 0; i < y.length; i++) {
            data[j++] = y[i];
            double v = n[i];
            //data[j++] = Math.log(v)/Math.log(2);
            //data[j++] = v;
            //data[j++] = v*Math.log(v)/Math.log(2);
            //data[j++] = v*v;
            data[j++] = v*v*v;
        }
        rss[T_N3] = this.getRSS(data, obs, vars);
        
        //Exponencial
        vars = 1; // 2
        data = new double[y.length*(vars+1)];
        obs = y.length;
        j = 0;
        for (int i = 0; i < y.length; i++) {
            data[j++] = y[i];
            double v = n[i];
            data[j++] = Math.exp(v);
        }
        rss[T_EXP] = this.getRSS(data, obs, vars);
        
        //Fatorial
        vars = 1; // 2
        data = new double[y.length*(vars+1)];
        obs = y.length;
        j = 0;
        for (int i = 0; i < y.length; i++) {
            data[j++] = y[i];
            double v = n[i];
            data[j++] = this.fat(v);
        }
        rss[T_FAT] = this.getRSS(data, obs, vars);
       
        double min = Double.MAX_VALUE;
        int tipo = UNKNOWN;
        for(int i=0; i < rss.length; ++i){
            if((rss[i] != Double.NaN) &&(rss[i] < min)){
                tipo = i;
                min = rss[i];
            }
            
        }
        
        for(int i=0; i<rss.length;++i)
            System.out.println("Rss["+i+"]: " + rss[i]);
        
        return tipo;
    }
    
    private double getRSS(double data[], int obs, int vars){
        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();
        try {
            ols.newSampleData(data, obs, vars); // 3
        } catch (IllegalArgumentException e) {
            System.out.print("Can't sample data: ");
            e.printStackTrace();
            return Double.MAX_VALUE;
        }
        try {
            return ols.calculateResidualSumOfSquares();
        } catch (Exception e) { // 5
            System.out.print("Can't estimate parameters: ");
            e.printStackTrace();
            return Double.MAX_VALUE;
        }
    }
    
      public static void main(String arg[]){
        /*double Tbubble[] = {45416, 172680, 365992, 611186, 938493, 1308529, 1744667, 2234946, 2775631, 3401894};
        double Tcouting[] = {3986, 7113, 10213, 13313, 16413, 19513, 22613, 25713, 28813, 31913};
        double Tmerge[] = {19020, 42630, 68010, 94524, 121167, 149755, 178585, 207525, 236547, 265180};
        double n[] = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};*/
        double bb[] = {87.0, 188.0, 289.0,376.0, 463.0, 550.0, 609.0, 682.0, 769.0, 870.0};

        
        EvaluatorAsymptotic c = new LinearRegression();
        /*System.out.println("Cat: " + c.getCategory(Tbubble));
        System.out.println("Cat: " + c.getCategory(Tcouting));
        System.out.println("Cat: " + c.getCategory(Tmerge));
        System.out.println("Cat: " + c.getCategory(n));*/
        System.out.println("Cat: " + c.getCategory(bb));
        
        System.out.print(Math.log(8)/Math.log(2));
    }
    
}
