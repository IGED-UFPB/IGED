/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class EvaluatorAsymptotic {
    
    protected static int nsize = 10;
    
    
    //protected static int n[] = {62, 125, 250, 500, 1000, 2000, 4000, 8000, 16000, 32000};
    protected static int n[] = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
    //protected static int n[] = {30, 90, 270, 810, 2430, 7290, 21870, 65610};
    public static void initX(double x[]){
        n = new int[x.length];
        nsize = x.length;
        System.arraycopy(x, 0, n, 0, nsize);
    }
    
    public static  int[] getX()
    {
        return n;
    }
    
    protected abstract void initSeries();
    public abstract int getCategory(double T[]);
    
    protected double fat(double n){
        double fat = 1;
        for(int i=2; i <= n; ++i)
            fat *= i;
        return fat;
    }
    
    protected static final int NUM_T = 8;
    
    public static final int UNKNOWN = -1;
    
    public static final int T_1 = 0;
    public static final int T_LN = 1;
    public static final int T_N = 2;
    public static final int T_NLN = 3;
    public static final int T_N2 = 4;
    public static final int T_N3 = 5;
    public static final int T_EXP = 6;
    public static final int T_FAT = 7;
}
