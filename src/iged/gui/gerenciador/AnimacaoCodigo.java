/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui.gerenciador;

import iged.Interpretador;
import iged.grafico.manager.PaintUI;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import iged.grafico.manager.Quadro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author Dorgi
 */
public class AnimacaoCodigo {

    Interpretador iter = Interpretador.getInstance();
    
    public AnimacaoCodigo() {
    }

    //Questao q = new Questao();
    public JFrame montarSplit() {


        JFrame horizontalFrame = new JFrame();
        //remove toda a decoração de um frame
        horizontalFrame.setUndecorated(true);

        JPanel panelAnimacao = Quadro.getInstance();
        JPanel panelCodigo = new JPanel();
        final JTextArea text = new JTextArea();
        JButton executar = new JButton("Executar");

        panelCodigo.add(text);
        panelCodigo.add(executar);

        
        
        executar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                StringTokenizer st = new StringTokenizer(text.getText(), "\n");
                while (st.hasMoreTokens()) {
                    String c = st.nextToken();
                    System.out.println(c);
                    iter.interprete(c);
                }
            }
        });

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
