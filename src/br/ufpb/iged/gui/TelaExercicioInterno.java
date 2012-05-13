/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaExercicio.java
 *
 * Created on 20/03/2012, 11:09:51
 */
package br.ufpb.iged.gui;

import br.ufpb.iged.gerenciadorIGEDlet.IGEDlet;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDletEvent;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDletListener;
import br.ufpb.iged.gerenciadorIGEDlet.GerenciadorAtividade;
import br.ufpb.iged.gerenciadorIGEDlet.Metadado;
import java.awt.Color;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dorgi
 */
public class TelaExercicioInterno extends javax.swing.JInternalFrame implements IGEDletListener{

     public static final File raiz = new File("./Tarefas");
     IGEDlet tf;
     TelaPesquisaInterno tp = new TelaPesquisaInterno();
     
     //Interpretador iter = Interpretador.getInstance();

    /** Creates new form TelaExercicioInterno */
    public TelaExercicioInterno() {
        GerenciadorAtividade gt = GerenciadorAtividade.getInstance();
        List<Metadado> metadados = gt.listarTarefas();
        this.tf = gt.loadTarefa(metadados.get(TelaPesquisaInterno.cont));
        this.tf.addListener(this);

        initComponents();
        executarTarefa();
    }

    private void initLabels(IGEDlet tf){
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Questão: " + tf.getDAO().getMetadado().getTitulo()));
        descricaoText.setText(tf.getDAO().getDescricao());
    }

        private void initComponents() {

        jButton3 = new javax.swing.JButton();
        corrigir = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoText = new javax.swing.JTextArea();
        recarregar = new javax.swing.JButton();
        executar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setTitle("Responder Exercício");

        JPanel panelAnimacao = this.tf.getQuadro();
        panelAnimacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Animação"));
        jSplitPane1.setLeftComponent(panelAnimacao);

        jPanel1.setAutoscrolls(true);
        
        jButton3.setText("jButton3");

        

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Questao"));
        jPanel1.setAutoscrolls(true);

        descricaoText.setEditable(false);
        descricaoText.setLineWrap(true);
        descricaoText.setColumns(20);
        descricaoText.setRows(5);
        jScrollPane1.setViewportView(descricaoText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        //recarregar.setText("Recarregar");
        recarregar.setIcon(new ImageIcon("./imagens/refresh.png"));
        recarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recarregarActionPerformed(evt);
            }
        });

        //executar.setText("Executar");
        executar.setIcon(new ImageIcon("./imagens/play.png"));
        executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executarActionPerformed(evt);
            }
        });

        jLabel1.setText("");

         jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setDividerLocation(450);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(true);
        jScrollPane2.setViewportView(jTextArea1);

        jSplitPane1.setRightComponent(jScrollPane2);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(corrigir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(recarregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(executar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recarregar)
                            .addComponent(executar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(corrigir)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

        

/*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoText = new javax.swing.JTextArea();
        recarregar = new javax.swing.JButton();
        executar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        corrigir = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Questao"));
        jPanel1.setAutoscrolls(true);

        descricaoText.setColumns(20);
        descricaoText.setLineWrap(true);
        descricaoText.setRows(5);
        jScrollPane1.setViewportView(descricaoText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        recarregar.setText("jButton2");
        recarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recarregarActionPerformed(evt);
            }
        });

        executar.setText("jButton4");
        executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executarActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jSplitPane1.setRightComponent(jScrollPane2);

        corrigir.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(corrigir)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(recarregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(executar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recarregar)
                            .addComponent(executar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(corrigir))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
    private void recarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recarregarActionPerformed
        this.tf.reinicio();
        jTextArea1.setText("");
        jLabel1.setText("");
        corrigir.setVisible(false);
    }//GEN-LAST:event_recarregarActionPerformed

    private void executarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executarActionPerformed
        this.tf.resolve(jTextArea1.getText());
        corrigir.setVisible(true);
            //JOptionPane.showInternalMessageDialog(this, "Tarefa Incorreta", "Tarefa Incorreta",JOptionPane.PLAIN_MESSAGE, new ImageIcon("./imagens/9.png"));
    }//GEN-LAST:event_executarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel corrigir;
    private javax.swing.JTextArea descricaoText;
    private javax.swing.JButton executar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton recarregar;
    // End of variables declaration//GEN-END:variables

       
    
    public void executarTarefa() {
        this.tf.inicio();
        this.initLabels(this.tf);
    }

    
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

    @Override
    public void atividadeIniciada(IGEDletEvent event) {
        if(event.getStatus() == IGEDletEvent.INIT){
            System.out.println("Atividade INICIADA");
        }
    }

    @Override
    public void atividadeResolvida(IGEDletEvent event) {
        if(event.getStatus() == IGEDletEvent.SUCCESS){
            corrigir.setIcon(new ImageIcon("./imagens/correct.png"));
            jLabel1.setBackground(Color.GREEN);  
            jLabel1.setText("Correto!");
        }else{
            corrigir.setIcon(new ImageIcon("./imagens/wrong.png"));
            jLabel1.setBackground(Color.RED); 
            jLabel1.setText("Incorreto!");
        }
    }
}
