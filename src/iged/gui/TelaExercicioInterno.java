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

import com.sun.java.swing.plaf.nimbus.OptionPaneOptionPaneMessageAreaOptionPaneLabelPainter;
import com.sun.org.apache.bcel.internal.generic.TABLESWITCH;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import iged.Interpretador;
import iged.gerenciadorTarefa.GerenciadorTarefa;
import iged.gerenciadorTarefa.MetadadoTarefa;
import iged.gerenciadorTarefa.Portifolio;
import iged.gerenciadorTarefa.PortifolioXml;
import iged.gerenciadorTarefa.Tarefa;
import iged.gerenciadorTarefa.TarefaXml;
import iged.gerenciadorTarefa.XmlPersistencia;
import iged.grafico.manager.Quadro;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dorgi
 */
public class TelaExercicioInterno extends javax.swing.JInternalFrame {

    public static final File raiz = new File("./Tarefas");
    Interpretador iter = Interpretador.getInstance();

    /** Creates new form TelaExercicioInterno */
    public TelaExercicioInterno() {
<<<<<<< HEAD
        executarTarefa(14);
=======
>>>>>>> 7dd42befc355415f02ee06b1f5cc213f99cd6a7d
        initComponents();
        
        executarTarefa(4);
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

<<<<<<< HEAD
        Tarefa tf = TarefaXml.lerXml(14);
        setTitle("Responder Exercício");
=======
        //Tarefa tf = TarefaXml.lerXml(14);
>>>>>>> 7dd42befc355415f02ee06b1f5cc213f99cd6a7d

        JPanel panelAnimacao = Quadro.getInstance();
        panelAnimacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Animação"));
        jSplitPane1.setLeftComponent(panelAnimacao);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Questão"));
        jPanel1.setAutoscrolls(true);

<<<<<<< HEAD
        descricaoText.setText(tf.getMetadado().getTitulo()+"\n"+tf.getDescricao());
        descricaoText.setEditable(false);
        descricaoText.setLineWrap(true);
        descricaoText.setColumns(20);
        descricaoText.setRows(5);
        jScrollPane3.setViewportView(descricaoText);
=======
        //tituloLabel.setText(tf.getMetadado().getTitulo());
        //descricaoLabel.setText(tf.getDescricao());
        //jTextArea1.setText(tf.getCodInicializacao());
>>>>>>> 7dd42befc355415f02ee06b1f5cc213f99cd6a7d

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
        
        jTextArea1.setText(tf.getCodInicializacao());
       
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

<<<<<<< HEAD
        jMenuPesquisar.setText("Pesquisar");
        jMenuBar1.add(jMenuPesquisar);

        setJMenuBar(jMenuBar1);
        
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
=======
        areaRadio.setText("Área");
        areaRadio.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaRadioActionPerformed(evt);
            }
        });


        idRadio.setText("Id");

        autorRadio.setText("Autor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
>>>>>>> 7dd42befc355415f02ee06b1f5cc213f99cd6a7d
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

        tituloLabel.setText(tf.getMetadado().getTitulo());
        descricaoLabel.setText(tf.getDescricao());


    }

    private void executarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executarBotaoActionPerformed
<<<<<<< HEAD
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
    }//GEN-LAST:event_executarBotaoActionPerformed

        /*
=======
        new Thread() {
            public void run() {
                StringTokenizer st = new StringTokenizer(jTextArea1.getText(), "\n");
                while (st.hasMoreTokens()) {
                    String c = st.nextToken();
                    System.out.println(c);
                    iter.interprete(c);
                }

                if (iter.taskIsCorrect()) {
                    System.out.println("Tarefa Correta!");
                } else {
                    System.out.println("Tarefa Incorreta!");
                }
            }
        }.start();
    }//GEN-LAST:event_executarBotaoActionPerformed

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

    public void listarTodasTarefas() {
        File raiz = new File("./Tarefas");
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Tarefa"};
        SimpleTableModel modelo = new SimpleTableModel(dados, colunas);
        for (File f : raiz.listFiles()) {
            if ((f.isFile()) && !(f.getName().contains("tarefas"))) {
                dados.add(new String[]{f.getName()});
            }
        }
        jTable1.setModel(modelo);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

    public void listarAreaTarefas() throws AreaInexistenteException, FileNotFoundException {
        String area = pesquisaText.getText();
        Portifolio p = new Portifolio();
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Tarefa"};
        SimpleTableModel modelo = new SimpleTableModel(dados, colunas);
        LinkedList<String> port = new LinkedList<String>();
        PortifolioXml.lerXml();

        XStream x = new XStream(new DomDriver());
        // carrega o arquivo XML
        FileInputStream input = new FileInputStream(new File(XmlPersistencia.DIRTAREFAS + "tarefas.xml"));
        // informa o nome do nó raiz do xml
        x.alias("portifolio", Portifolio.class);
        x.alias("metadados", MetadadoTarefa.class);
        // cria um objeto da classe, contendo os dados lidos no xml
        Portifolio pf = (Portifolio) x.fromXML(input);
        if (pf.getTarefas() == null) {
            pf.setTarefas(new LinkedList<MetadadoTarefa>());
        }

        for (MetadadoTarefa mt : pf.getTarefas()) {
            if ((mt.getArea().equals(area))) {
                dados.add(new String[]{"TESTE"});
            }
        }

        /*
        port.add(PortifolioXml.lerXml().toString());
        
        for (int i=0; i< port.size();i++){
        System.out.println(port.get(i).toString());
        }
        /*
        for (int i = 0; i < port.size(); i++) {
        if (area.equals(port.get(i).getTarefas().get(i).getArea())) {
        dados.add(new String[]{port.get(i).getTarefas().get(i).toString()});
        } 
        }*/
        jTable1.setModel(modelo);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void todosRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosRadioActionPerformed
        listarTodasTarefas();
    }//GEN-LAST:event_todosRadioActionPerformed

    private void areaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaRadioActionPerformed
        try {
            try {
                listarAreaTarefas();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaExercicioInterno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (AreaInexistenteException ex) {
            Logger.getLogger(TelaExercicioInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_areaRadioActionPerformed
    /*
>>>>>>> 7dd42befc355415f02ee06b1f5cc213f99cd6a7d
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
