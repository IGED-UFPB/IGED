
package br.ufpb.iged.tutor.ncm.entity;

import java.io.IOException;

/**
 *
 * @author GILBERTO FARIAS
 */
public class IGEDletNode extends ContentNode{
    @Override
    public void run() {
        System.out.println("Iniciado IGEDlet: " + this.getId());
        
        try {
            System.out.println("Digite IGED");
            System.in.read();
        } catch (IOException ex) {
        }
        final IGEDletNode iged = this;
        new Thread(){
            public void run(){
                iged.finish();
            }
        }.start();
        
        try {
            while(true){
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println("Fim IGElet");
            //ex.printStackTrace();
        }
        
    }
}
