/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

import java.io.IOException;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ImageNode extends ContentNode{

    @Override
    public void run() {
        try {
            System.out.println("Digite");
            System.in.read();
        } catch (IOException ex) {
            
        }
        System.out.println("Selects Anchor.");
        ((ContentAnchor)(this.getAnchor("aAtividade1"))).selects();
        //throw new UnsupportedOperationException("Not supported yet.");
        try {
            while(true){
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println("Fim Image");
        }
    }
    
}
