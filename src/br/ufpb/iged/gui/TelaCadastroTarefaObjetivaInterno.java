/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaCadastroTarefaObjetivaInterno.java
 *
 * Created on 27/03/2012, 00:39:22
 */
package br.ufpb.iged.gui;

/**
 *
 * @author Dorgi
 */
public class TelaCadastroTarefaObjetivaInterno extends javax.swing.JInternalFrame {

    /** Creates new form TelaCadastroTarefaObjetivaInterno */
    public TelaCadastroTarefaObjetivaInterno() {
        initComponents();
    }

    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        questaoLabel = new javax.swing.JLabel();
        cont = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        alternativaA = new javax.swing.JRadioButton();
        alternativaB = new javax.swing.JRadioButton();
        alternativaC = new javax.swing.JRadioButton();
        alternativaD = new javax.swing.JRadioButton();
        alternativaE = new javax.swing.JRadioButton();
        jTextFieldA = new javax.swing.JTextField();
        jTextFieldB = new javax.swing.JTextField();
        jTextFieldC = new javax.swing.JTextField();
        jTextFieldD = new javax.swing.JTextField();
        jTextFieldE = new javax.swing.JTextField();
        novaQuestao = new javax.swing.JButton();
        removeQuestao = new javax.swing.JButton();
        removerQuestao = new javax.swing.JCheckBox();
        cadastrar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        questaoLabel.setText("Questão");

        cont.setText(getCont());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        alternativaA.setText("a");

        alternativaB.setText("b");

        alternativaC.setText("c");

        alternativaD.setText("d");

        alternativaE.setText("e");

        jTextFieldA.setText("");

        jTextFieldB.setText("");

        jTextFieldC.setText("");

        jTextFieldD.setText("");

        jTextFieldE.setText("");

        novaQuestao.setText("Adicionar Questão");

        removeQuestao.setText("Remover Questão");

        removerQuestao.setText("Remover");

        cadastrar.setText("Cadastrar");

        cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(removerQuestao).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(alternativaD).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextFieldD, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(alternativaC).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextFieldC, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(alternativaB).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextFieldB, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(alternativaA).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextFieldA)).addGroup(layout.createSequentialGroup().addComponent(questaoLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cont).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addComponent(alternativaE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextFieldE, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))).addContainerGap(22, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(219, Short.MAX_VALUE).addComponent(novaQuestao).addGap(48, 48, 48).addComponent(removeQuestao).addGap(197, 197, 197)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(287, Short.MAX_VALUE).addComponent(cancelar).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cadastrar).addGap(255, 255, 255)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(40, 40, 40).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(questaoLabel).addComponent(cont).addComponent(removerQuestao))).addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(alternativaA).addComponent(jTextFieldA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(alternativaB).addComponent(jTextFieldB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(alternativaC).addComponent(jTextFieldC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(alternativaD).addComponent(jTextFieldD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(alternativaE).addComponent(jTextFieldE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(removeQuestao).addComponent(novaQuestao)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(cadastrar).addComponent(cancelar)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }
    private int contador = 0;

    public String getCont() {
        contador++;
        String c = String.valueOf(contador);
        return c;
    }

    public void alternativaCorreta() {
        if (alternativaA.isSelected()) {
            
        }
    }
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        questaoLabel = new javax.swing.JLabel();
        cont = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        alternativaA = new javax.swing.JRadioButton();
        alternativaB = new javax.swing.JRadioButton();
        alternativaC = new javax.swing.JRadioButton();
        alternativaD = new javax.swing.JRadioButton();
        alternativaE = new javax.swing.JRadioButton();
        jTextFieldA = new javax.swing.JTextField();
        jTextFieldB = new javax.swing.JTextField();
        jTextFieldC = new javax.swing.JTextField();
        jTextFieldD = new javax.swing.JTextField();
        jTextFieldE = new javax.swing.JTextField();
        novaQuestao = new javax.swing.JButton();
        removeQuestao = new javax.swing.JButton();
        removerQuestao = new javax.swing.JCheckBox();
        cadastrar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        questaoLabel.setText("Questão");

        cont.setText("jLabel1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        alternativaA.setText("a");

        alternativaB.setText("b");

        alternativaC.setText("c");

        alternativaD.setText("d");

        alternativaE.setText("e");

        jTextFieldB.setText("jTextField1");
        jTextFieldB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBActionPerformed(evt);
            }
        });

        jTextFieldC.setText("jTextField1");

        jTextFieldD.setText("jTextField1");

        jTextFieldE.setText("jTextField1");

        novaQuestao.setText("Adicionar Questão");

        removeQuestao.setText("Remover Questão");

        removerQuestao.setText("Remover");

        cadastrar.setText("Cadastrar");

        cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removerQuestao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alternativaD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldD, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alternativaC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldC, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alternativaB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldB, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alternativaA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldA))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(questaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cont)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alternativaE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldE, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(novaQuestao)
                .addGap(48, 48, 48)
                .addComponent(removeQuestao)
                .addGap(197, 197, 197))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addComponent(cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastrar)
                .addGap(255, 255, 255))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questaoLabel)
                            .addComponent(cont)
                            .addComponent(removerQuestao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternativaA)
                    .addComponent(jTextFieldA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternativaB)
                    .addComponent(jTextFieldB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternativaC)
                    .addComponent(jTextFieldC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(alternativaD)
                    .addComponent(jTextFieldD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(alternativaE)
                    .addComponent(jTextFieldE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeQuestao)
                    .addComponent(novaQuestao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTextFieldBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alternativaA;
    private javax.swing.JRadioButton alternativaB;
    private javax.swing.JRadioButton alternativaC;
    private javax.swing.JRadioButton alternativaD;
    private javax.swing.JRadioButton alternativaE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel cont;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldA;
    private javax.swing.JTextField jTextFieldB;
    private javax.swing.JTextField jTextFieldC;
    private javax.swing.JTextField jTextFieldD;
    private javax.swing.JTextField jTextFieldE;
    private javax.swing.JButton novaQuestao;
    private javax.swing.JLabel questaoLabel;
    private javax.swing.JButton removeQuestao;
    private javax.swing.JCheckBox removerQuestao;
    // End of variables declaration//GEN-END:variables
    }*/
    private javax.swing.JRadioButton alternativaA;
    private javax.swing.JRadioButton alternativaB;
    private javax.swing.JRadioButton alternativaC;
    private javax.swing.JRadioButton alternativaD;
    private javax.swing.JRadioButton alternativaE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel cont;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldA;
    private javax.swing.JTextField jTextFieldB;
    private javax.swing.JTextField jTextFieldC;
    private javax.swing.JTextField jTextFieldD;
    private javax.swing.JTextField jTextFieldE;
    private javax.swing.JButton novaQuestao;
    private javax.swing.JLabel questaoLabel;
    private javax.swing.JButton removeQuestao;
    private javax.swing.JCheckBox removerQuestao;
}
