/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui.gerenciador;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author Dorgi
 */
public class AnimacaoCodigo {

    
    public AnimacaoCodigo(){
        
    }

    //Questao q = new Questao();
    
    public JFrame montarSplit(){

        
        JFrame horizontalFrame = new JFrame();
        //remove toda a decoração de um frame
        horizontalFrame.setUndecorated(true);
        
        JPanel panelAnimacao = new JPanel();
        JPanel panelCodigo = new JPanel();

        panelAnimacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Animação"));
        panelCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

                
        JComponent leftButton = panelAnimacao;
        JComponent rightButton = panelCodigo;
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(leftButton);
        splitPane.setRightComponent(rightButton);

        horizontalFrame.add(splitPane, BorderLayout.CENTER);
        horizontalFrame.setSize(1280, 525);
        horizontalFrame.setLocation(0, 235);
        horizontalFrame.setVisible(true);
        

        return horizontalFrame;
    }
}
