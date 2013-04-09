package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

/**
 *
 * @author GILBERTO FARIAS
 */
public class PearsonCorrelation extends EvaluatorAsymptotic{
    
    
    private double T[][];
    
    private static PearsonCorrelation cor = null;
    
    public static synchronized PearsonCorrelation getInstance(){
        if(cor == null)
            cor = new PearsonCorrelation();
        return cor;
    }
    
        
    private PearsonCorrelation(){
        this.initSeries();
    }
    
    @Override
    protected void initSeries(){
        this.T = new double[NUM_T][this.nsize];
        
        for(int t=0; t < NUM_T; ++t){
            for(int i=0; i < this.nsize; ++i){
                switch(t){
                    case T_1:
                        this.T[t][i] = 1;
                        break;
                    case T_LN:
                        this.T[t][i] = Math.log(n[i])/Math.log(2);
                        break;
                    case T_N:
                        this.T[t][i] = n[i];
                        break;
                    case T_NLN:
                        this.T[t][i] = n[i]*Math.log(n[i])/Math.log(2);
                        break;
                    case T_N2:
                        this.T[t][i] = n[i]*n[i];
                        break;
                    case T_N3:
                        this.T[t][i] = n[i]*n[i]*n[i];
                        break;
                    case T_EXP:
                        this.T[t][i] = Math.pow(2, n[i]);
                        break;
                    case T_FAT:
                        this.T[t][i] = this.fat(n[i]);
                        break;
                }
            }
        }
    }
    public static double getPearsonCorrelation(double[] scores1, double[] scores2) {
        double result = 0;
        double sum_sq_x = 0;
        double sum_sq_y = 0;
        double sum_coproduct = 0;
        double mean_x = scores1[0];
        double mean_y = scores2[0];
        for (int i = 2; i < scores1.length + 1; i += 1) {
            double sweep = Double.valueOf(i - 1) / i;
            double delta_x = scores1[i - 1] - mean_x;
            double delta_y = scores2[i - 1] - mean_y;
            sum_sq_x += delta_x * delta_x * sweep;
            sum_sq_y += delta_y * delta_y * sweep;
            sum_coproduct += delta_x * delta_y * sweep;
            mean_x += delta_x / i;
            mean_y += delta_y / i;
        }
        double pop_sd_x = (double) Math.sqrt(sum_sq_x / scores1.length);
        double pop_sd_y = (double) Math.sqrt(sum_sq_y / scores1.length);
        double cov_x_y = sum_coproduct / scores1.length;
        result = cov_x_y / (pop_sd_x * pop_sd_y);
        return result;
    }
    
    @Override
    public int getCategory(double T[]){
        double PC[] = new double[NUM_T];
        for(int t = 0; t < NUM_T; ++t){
            PC[t] = PearsonCorrelation.getPearsonCorrelation(T, this.T[t]);
            if(PC[t] == Double.NaN)
                PC[t] = 0;
            System.out.println("PC[" + t+"]: " + PC[t]);
        }
        
        int category = UNKNOWN;
        double maxValue = -1;
        for(int t=0; t < NUM_T; ++t){
            if(maxValue < PC[t]){
                maxValue = PC[t];
                category = t;
            }
        }
        return category;
    }
    
//    public static void main(String arg[]){
//        /*double Tbubble[] = {45416, 172680, 365992, 611186, 938493, 1308529, 1744667, 2234946, 2775631, 3401894};
//        double Tcouting[] = {3986, 7113, 10213, 13313, 16413, 19513, 22613, 25713, 28813, 31913};
//        double Tmerge[] = {19020, 42630, 68010, 94524, 121167, 149755, 178585, 207525, 236547, 265180};
//        double bb[] = {107.0, 208.0, 295.0, 410.0, 483.0, 584.0, 629.0, 716.0, 831.0, 918.0};
//        */
//        double bb[] = {87.0, 188.0, 289.0,376.0, 463.0, 550.0, 609.0, 682.0, 769.0, 870.0};
//        
//        PearsonCorrelation c = PearsonCorrelation.getInstance();
//        /*System.out.println("Cat: " + c.getCategory(Tbubble));
//        System.out.println("Cat: " + c.getCategory(Tcouting));
//        System.out.println("Cat: " + c.getCategory(Tmerge));*/
//        System.out.println("Cat: " + c.getCategory(bb));
//    }
}
