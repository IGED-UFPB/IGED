/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gui;


import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author GILBERTO FARIAS
 */
public class TutorialFrameGilberto extends javax.swing.JFrame{

    LeitorXMLGilberto leitor = null;

    /** Creates new form Aulas */
    public TutorialFrameGilberto() {
        super("Tutoriais IGED");
        leitor = new LeitorXMLGilberto();
        leitor.initTutorials();

        initComponents();
    }

    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();

        TutorialInterface ti = new TutorialInterface(leitor.getTutorials());
        ti.draw();

        pack();
    }// </editor-fold>

    class TutorialInterface{

        List<TutorialPanel> panels = new LinkedList<TutorialPanel>();
        List<TutorialXML> txmls = null;

        public TutorialInterface(List<TutorialXML> t){
            this.txmls = t;

            for(TutorialXML tx : this.txmls){
                panels.add(new TutorialPanel(tx));
            }
        }

        public void draw(){
             javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
             getContentPane().setLayout(layout);


             GroupLayout.ParallelGroup pg = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false);
             GroupLayout.SequentialGroup sg = layout.createSequentialGroup();

             for(int i=0; i<panels.size(); ++i){
                 TutorialPanel tp = panels.get(i);
                 pg.addComponent(tp.getPanel(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                 sg.addComponent(tp.getPanel(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);

                 if(i < panels.size()-1)
                    sg.addGap(18, 18, 18);
                 else
                    sg.addContainerGap();
             }

             layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pg)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                        .addGroup(sg)))
            );
         }

         public class TutorialPanel{

            TutorialXML txml = null;

            javax.swing.JPanel panel;
            javax.swing.JPanel imgPanel;
            javax.swing.JPanel descPanel;
            javax.swing.JTextField tituloField;
            javax.swing.JLabel titulo;
            ImageIcon img;

            public TutorialPanel(TutorialXML txml){
                this.txml = txml;
                panel = new javax.swing.JPanel();
                imgPanel = new javax.swing.JPanel();
                descPanel = new javax.swing.JPanel();

                //titulo = new javax.swing.JLabel();
                //tituloField = new javax.swing.JTextField();

                img = new ImageIcon(this.txml.dir + "\\" + "Slide1.jpg");
                this.createPanels();
            }

            public javax.swing.JPanel getPanel(){
                return panel;
            }

            private void createPanels(){

                panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));
                imgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                descPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                Image newimg = img.getImage().getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);

                imgPanel.add(new JLabel(newIcon));

                javax.swing.GroupLayout descLayout = new javax.swing.GroupLayout(descPanel);
                descPanel.setLayout(descLayout);
                descLayout.setHorizontalGroup(
                    descLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 480, Short.MAX_VALUE)
                );

                descLayout.setVerticalGroup(
                    descLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 100, Short.MAX_VALUE)
                );

                javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
                panel.setLayout(panelLayout);
                panelLayout.setHorizontalGroup(
                    panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(descPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );

                panelLayout.setVerticalGroup(
                    panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
         }

    }

    private javax.swing.JScrollBar jScrollBar1;
}
