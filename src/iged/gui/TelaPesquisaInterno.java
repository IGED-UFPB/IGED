/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaPesquisaInterno.java
 *
 * Created on 19/03/2012, 13:52:29
 */
package iged.gui;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import iged.gerenciadorAtividade.Atividade;
import iged.gerenciadorAtividade.AtividadeXml;
import iged.gerenciadorAtividade.GerenciadorAtividade;
import iged.gerenciadorAtividade.MetadadoAtividade;
import iged.gerenciadorAtividade.Portifolio;
import iged.gerenciadorAtividade.PortifolioXml;
import iged.gerenciadorAtividade.XmlPersistencia;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dorgi
 */
public class TelaPesquisaInterno extends javax.swing.JInternalFrame {

    ArrayList dados = new ArrayList();
    String[] colunas = new String[]{"ID", "Titulo", "Área"};
    Atividade tf;
    public static int id;
    public static int cont;
    static Object valueLinha;

    /** Creates new form TelaPesquisaInterno */
    public TelaPesquisaInterno() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idRadio = new javax.swing.JRadioButton();
        tituloRadio = new javax.swing.JRadioButton();
        areaRadio = new javax.swing.JRadioButton();
        pesquisaLabel = new javax.swing.JLabel();
        todosRadio = new javax.swing.JRadioButton();
        pesquisaText = new javax.swing.JTextField();
        pesquisarBotao = new javax.swing.JButton();

        jTable1.setModel(new SimpleTableModel(dados, colunas));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        idRadio.setText("Id");
        idRadio.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idRadioActionPerformed(evt);
            }
        });

        tituloRadio.setText("Título");
        tituloRadio.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloRadioActionPerformed(evt);
            }
        });

        areaRadio.setText("Área");
        areaRadio.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaRadioActionPerformed(evt);
            }
        });

        pesquisaLabel.setText("Pesquisa:");

        todosRadio.setText("Todos");
        todosRadio.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosRadioActionPerformed(evt);
            }
        });

        pesquisarBotao.setText("Pesquisar");
        pesquisarBotao.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addComponent(pesquisaLabel).addGap(5, 5, 5).addComponent(pesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pesquisarBotao)))).addGroup(layout.createSequentialGroup().addGap(139, 139, 139).addComponent(todosRadio).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(areaRadio).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(idRadio).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(tituloRadio))).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(pesquisaLabel).addComponent(pesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(pesquisarBotao)).addGap(7, 7, 7).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(todosRadio).addComponent(areaRadio).addComponent(idRadio).addComponent(tituloRadio)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE).addContainerGap()));

        pack();
    }
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idRadio = new javax.swing.JRadioButton();
        tituloRadio = new javax.swing.JRadioButton();
        areaRadio = new javax.swing.JRadioButton();
        pesquisaLabel = new javax.swing.JLabel();
        todosRadio = new javax.swing.JRadioButton();
        pesquisaText = new javax.swing.JTextField();
        pesquisarBotao = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Resultado da Busca"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        idRadio.setText("Id");
        idRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idRadioActionPerformed(evt);
            }
        });

        tituloRadio.setText("Título");
        tituloRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloRadioActionPerformed(evt);
            }
        });

        areaRadio.setText("Área");
        areaRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaRadioActionPerformed(evt);
            }
        });

        pesquisaLabel.setText("Pesquisa:");

        todosRadio.setText("Todos");
        todosRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosRadioActionPerformed(evt);
            }
        });

        pesquisarBotao.setText("Pesquisar");
        pesquisarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pesquisaLabel)
                                .addGap(5, 5, 5)
                                .addComponent(pesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisarBotao))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(todosRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(areaRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloRadio)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisaLabel)
                    .addComponent(pesquisaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarBotao))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(todosRadio)
                    .addComponent(areaRadio)
                    .addComponent(idRadio)
                    .addComponent(tituloRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     */
    private void todosRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosRadioActionPerformed
        idRadio.setEnabled(false);
        tituloRadio.setEnabled(false);
        areaRadio.setEnabled(false);
        //buscarTodasTarefa();
    }//GEN-LAST:event_todosRadioActionPerformed

    private void areaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaRadioActionPerformed
        //
    }//GEN-LAST:event_areaRadioActionPerformed

    private void idRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idRadioActionPerformed
        //buscarId();
    }//GEN-LAST:event_idRadioActionPerformed

    private void tituloRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloRadioActionPerformed
        //buscarTitulo();
    }//GEN-LAST:event_tituloRadioActionPerformed

    private void pesquisarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarBotaoActionPerformed
        if (areaRadio.isSelected()) {
            try {
                buscarArea();
            } catch (TarefaInvalidaException ex) {
                JOptionPane.showInternalMessageDialog(this, ex.getMessage());
            }
        } else {
            if (idRadio.isSelected()) {
                try {
                    buscarId();
                } catch (TarefaInvalidaException ex) {
                    JOptionPane.showInternalMessageDialog(this, ex.getMessage());
                }
            } else {
                if (tituloRadio.isSelected()) {
                    try {
                        buscarTitulo();
                    } catch (TarefaInvalidaException ex) {
                        JOptionPane.showInternalMessageDialog(this, ex.getMessage());
                    }
                } else {
                    if (todosRadio.isSelected()) {
                        try {
                            buscarTodasTarefa();
                        } catch (TarefaInvalidaException ex) {
                            JOptionPane.showInternalMessageDialog(this, ex.getMessage());
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_pesquisarBotaoActionPerformed

    public static int valorLinha() throws TarefaInvalidaException{
        GerenciadorAtividade gt = GerenciadorAtividade.getInstance();
        List<MetadadoAtividade> metadados = gt.listarTarefas();
        valueLinha = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        String valorId = valueLinha.toString();
        int i;

        for (i = 0; i < metadados.size(); i++) {
            if (valorId.equals(String.valueOf(metadados.get(i).getId()))) {
                id = i;
            }  
            else {
                throw new TarefaInvalidaException("Tarefa inexistente!");
            }
        }
        return id;
    }
   
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() >= 2) {
            try {
                valorLinha();
                cont = valorLinha();
            } catch (TarefaInvalidaException ex) {
                Logger.getLogger(TelaPesquisaInterno.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    class SimpleTableModel extends AbstractTableModel {

        ArrayList linhas = null;
        String[] colunas = null;

        public SimpleTableModel(ArrayList dados, String[] colunas) {
            setLinhas(dados);
            setColunas(colunas);
        }

        public String[] getColunas() {
            return colunas;
        }

        public ArrayList getLinhas() {
            return linhas;
        }

        public void setColunas(String[] strings) {
            colunas = strings;
        }

        public void setLinhas(ArrayList list) {
            linhas = list;
        }

        @Override
        public int getRowCount() {
            return getLinhas().size();
        }

        @Override
        public int getColumnCount() {
            return getColunas().length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            String[] linha = (String[]) getLinhas().get(rowIndex);
            // Retorna o objeto que esta na coluna  
            return linha[columnIndex];
        }

        public void addRow(String[] dadosLinha) {
            getLinhas().add(dadosLinha);
            // Informa a jtable de que houve linhas incluidas no modelo  
            // COmo adicionamos no final, pegamos o tamanho total do modelo  
            // menos 1 para obter a linha incluida.  
            int linha = getLinhas().size() - 1;
            fireTableRowsInserted(linha, linha);
            return;
        }
    }

    public void recuperarDados() {
        int linhas = jTable1.getRowCount();
        int colunas = jTable1.getColumnCount();
        for (int linha = 0; linha < linhas; linha++) {
            for (int col = 0; col < colunas; col++) {
                jTable1.getModel().getValueAt(linha, col); // Pra recuparar o valor de uma celula da tabela  
            }
        }
    }

    public void buscarTodasTarefa() throws TarefaInvalidaException{
        Portifolio pf = PortifolioXml.lerXml();
        String id;
        for (MetadadoAtividade mt : pf.getTarefas()) {
            id = String.valueOf(mt.getId());
            if (mt.getArea().equalsIgnoreCase(pesquisaText.getText())) {
                dados.add(new String[]{id, mt.getTitulo(), mt.getArea()});
                System.out.println("Encontrado área:" + mt.getArea());
            } else {
                if (mt.getTitulo().contains(pesquisaText.getText())) {
                    dados.add(new String[]{id, mt.getTitulo(), mt.getArea()});
                    System.out.println("Encontrado titulo:" + mt.getTitulo());
                } else {
                    if (id.equals(pesquisaText.getText())) {
                        dados.add(new String[]{id, mt.getTitulo(), mt.getArea()});
                        System.out.println("Encontrado id:" + mt.getId());
                    }
                    throw new TarefaInvalidaException("Não existe tarefa com o termo pesquisado!");
                }
                SimpleTableModel modelo = new SimpleTableModel(dados, colunas);
                jTable1.setModel(modelo);
                jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        }
    }

    public void buscarArea() throws TarefaInvalidaException{
        Portifolio pf = PortifolioXml.lerXml();
        String id;
        for (MetadadoAtividade mt : pf.getTarefas()) {
            id = String.valueOf(mt.getId());
            if (mt.getArea().equalsIgnoreCase(pesquisaText.getText())) {
                dados.add(new String[]{id, mt.getTitulo(), mt.getArea()});
                System.out.println("Encontrado área:" + mt.getArea());
            } else {
                throw new TarefaInvalidaException("Não existe tarefa com a área pesquisada!");
            }
            SimpleTableModel modelo = new SimpleTableModel(dados, colunas);
            jTable1.setModel(modelo);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    public void buscarId() throws TarefaInvalidaException{
        SimpleTableModel modelo = new SimpleTableModel(dados, colunas);
        Portifolio pf = PortifolioXml.lerXml();
        String id;
        for (MetadadoAtividade mt : pf.getTarefas()) {
            id = String.valueOf(mt.getId());
            if (id.equals(pesquisaText.getText())) {
                dados.add(new String[]{id, mt.getTitulo(), mt.getArea()});
                System.out.println("Encontrado id:" + mt.getId());
            } else {
                throw new TarefaInvalidaException("Não existe tarefa com o id pesquisado!");
            }
            jTable1.setModel(modelo);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    public void buscarTitulo() throws TarefaInvalidaException{
        SimpleTableModel modelo = new SimpleTableModel(dados, colunas);
        Portifolio pf = PortifolioXml.lerXml();
        String id;
        for (MetadadoAtividade mt : pf.getTarefas()) {
            id = String.valueOf(mt.getId());
            if (mt.getTitulo().contains(pesquisaText.getText())) {
                dados.add(new String[]{id, mt.getTitulo(), mt.getArea()});
                System.out.println("Encontrado Título:" + mt.getTitulo());
            } else {
                throw new TarefaInvalidaException("Não existe tarefa com o título pesquisado!");
            }
            jTable1.setModel(modelo);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton areaRadio;
    private javax.swing.JRadioButton idRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel pesquisaLabel;
    private javax.swing.JTextField pesquisaText;
    private javax.swing.JButton pesquisarBotao;
    private javax.swing.JRadioButton tituloRadio;
    private javax.swing.JRadioButton todosRadio;
    // End of variables declaration//GEN-END:variables
     */
    private javax.swing.JRadioButton areaRadio;
    private javax.swing.JRadioButton autorRadio;
    private javax.swing.JRadioButton idRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JLabel pesquisaLabel;
    private javax.swing.JTextField pesquisaText;
    private javax.swing.JRadioButton todosRadio;
    private javax.swing.JRadioButton tituloRadio;
    private javax.swing.JButton pesquisarBotao;

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPesquisaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaPesquisaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaPesquisaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPesquisaInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaExercicioInterno().setVisible(true);

            }
        });
    }
}
