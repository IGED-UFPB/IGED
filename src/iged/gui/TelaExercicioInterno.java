/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaExercicioInterno.java
 *
 * Created on 14/03/2012, 13:57:59
 */
package iged.gui;

import iged.Interpretador;
import iged.gerenciadorTarefa.GerenciadorTarefa;
import iged.gerenciadorTarefa.MetadadoTarefa;
import iged.gerenciadorTarefa.Tarefa;
import iged.grafico.manager.Quadro;
import java.io.File;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dorgi
 */
public class TelaExercicioInterno extends javax.swing.JInternalFrame {

     public static final File raiz = new File("./Tarefas");
    Interpretador iter = Interpretador.getInstance();

    /** Creates new form TelaExercicioInterno */
    public TelaExercicioInterno() {
        initComponents();
        executarTarefa(8);
    }

    private void initLabels(Tarefa tf){
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Questão: " + tf.getMetadado().getTitulo()));
        descricaoText.setText(tf.getDescricao());
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        descricaoText = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelDesenho = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        executarBotao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuPesquisar = new javax.swing.JMenu();


        //Tarefa tf = TarefaXml.lerXml(14);
        setTitle("Responder Exercício");

        JPanel panelAnimacao = Quadro.getInstance();
        panelAnimacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Animação"));
        jSplitPane1.setLeftComponent(panelAnimacao);

        jPanel1.setAutoscrolls(true);


        descricaoText.setEditable(false);
        descricaoText.setLineWrap(true);
        descricaoText.setColumns(20);
        descricaoText.setRows(5);
        jScrollPane3.setViewportView(descricaoText);

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
       
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setDividerLocation(450);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea1);

        jSplitPane1.setRightComponent(jScrollPane2);

       javax.swing.GroupLayout panelDesenhoLayout = new javax.swing.GroupLayout(panelDesenho);
        panelDesenho.setLayout(panelDesenhoLayout);
        panelDesenhoLayout.setHorizontalGroup(
                panelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDesenhoLayout.createSequentialGroup().addContainerGap().addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)));
        panelDesenhoLayout.setVerticalGroup(
                panelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDesenhoLayout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)));


        executarBotao.setText("Executar");
        executarBotao.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executarBotaoActionPerformed(evt);
            }
        });
       
        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);


        jMenuPesquisar.setText("Pesquisar");
        jMenuBar1.add(jMenuPesquisar);

        setJMenuBar(jMenuBar1);
        
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(executarBotao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(executarBotao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                .addComponent(panelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())

                .addComponent(panelDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(executarBotao)
                //.addContainerGap(27, Short.MAX_VALUE))

        );

        
        pack();
    }

    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descricaoText = new javax.swing.JTextArea();
        panelDesenho = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        executarBotao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuPesquisar = new javax.swing.JMenu();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Questão"));
        jPanel1.setAutoscrolls(true);

        descricaoText.setColumns(20);
        descricaoText.setRows(5);
        jScrollPane3.setViewportView(descricaoText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setAutoscrolls(true);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea1);

        jSplitPane1.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout panelDesenhoLayout = new javax.swing.GroupLayout(panelDesenho);
        panelDesenho.setLayout(panelDesenhoLayout);
        panelDesenhoLayout.setHorizontalGroup(
            panelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDesenhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
        );
        panelDesenhoLayout.setVerticalGroup(
            panelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDesenhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
        );

        executarBotao.setText("Executar");
        executarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executarBotaoActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenuPesquisar.setText("Pesquisar");
        jMenuBar1.add(jMenuPesquisar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(executarBotao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(executarBotao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                .addComponent(panelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
=======
                .addComponent(panelDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(executarBotao)
                .addContainerGap(27, Short.MAX_VALUE))
>>>>>>> 7dd42befc355415f02ee06b1f5cc213f99cd6a7d
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     */
    public void executarTarefa(int id) {
        GerenciadorTarefa gt = GerenciadorTarefa.getInstance();
        List<MetadadoTarefa> metadados = gt.listarTarefas();
        Tarefa tf = gt.loadTarefa(metadados.get(id));
        gt.executar(tf);
        
        this.initLabels(tf);
    }

    private void executarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executarBotaoActionPerformed

        StringTokenizer st = new StringTokenizer(jTextArea1.getText(), "\n");
                    while (st.hasMoreTokens()) {
                        String c = st.nextToken();
                        System.out.println(c);
                        iter.interprete(c);
                    }  
                    if(iter.taskIsCorrect())
                        JOptionPane.showInternalMessageDialog(this, "Tarefa Correta", "Tarefa Correta",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./imagens/8.png"));
                    else
                        JOptionPane.showInternalMessageDialog(this, "Tarefa Incorreta", "Tarefa Incorreta",JOptionPane.PLAIN_MESSAGE, new ImageIcon("./imagens/9.png"));
    }                                             
/*
    }//GEN-LAST:event_executarBotaoActionPerformed
/*
    private void todosRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosRadioActionPerformed
        
    }//GEN-LAST:event_todosRadioActionPerformed

    private void areaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaRadioActionPerformed
       
    }//GEN-LAST:event_areaRadioActionPerformed
    /*

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descricaoText;
    private javax.swing.JButton executarBotao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panelDesenho;
    // End of variables declaration//GEN-END:variables
     */

    private javax.swing.JButton executarBotao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panelDesenho;
    private javax.swing.JTextArea descricaoText;
    private javax.swing.JMenu jMenuPesquisar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu1;

    public static void main(String args[]) {
        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");




        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaExercicioInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaExercicioInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaExercicioInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaExercicioInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaExercicioInterno().setVisible(true);

            }
        });
    }
}
