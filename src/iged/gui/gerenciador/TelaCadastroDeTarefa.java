/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroDeTarefa.java
 *
 * Created on 07/02/2012, 22:30:45
 */
package iged.gui.gerenciador;

import iged.Interpretador;
import iged.gerenciadorTarefa.GerenciadorTarefa;
import iged.gerenciadorTarefa.MetadadoTarefa;
import iged.gerenciadorTarefa.Tarefa;
import iged.grafico.manager.Quadro;
import iged.gerenciadorTarefa.XmlPersistencia;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dorgi
 */
public class TelaCadastroDeTarefa extends javax.swing.JFrame {

    Interpretador iter = new Interpretador();

    /** Creates new form CadastroDeTarefa */
    public TelaCadastroDeTarefa() {
        initComponents();
    }

    private void initComponents() {

        titulo = new javax.swing.JLabel();
        autor = new javax.swing.JLabel();
        fieldAutor = new javax.swing.JTextField();
        descricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();
        id = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        panelCodigoIni = new javax.swing.JPanel();
        panelInicializacao = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        inicializacaoTextA = new javax.swing.JTextArea();
        okInicializacao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textTitulo = new javax.swing.JTextArea();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        panelAnimacao = Quadro.getInstance();
        panelCodigoSol = new javax.swing.JPanel();
        panelSolucao = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        solucaoText = new javax.swing.JTextArea();
        okSolucao = new javax.swing.JButton();
        area = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox();
        okInformacao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrador de Tarefa");
        setName("cadastradorDeTarefa"); // NOI18N
        setResizable(false);

        titulo.setText("Título");

        autor.setText("Autor");

        fieldAutor.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        fieldAutor.setAutoscrolls(false);

        descricao.setText("Descrição");

        textDescricao.setColumns(20);
        textDescricao.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        textDescricao.setRows(5);
        textDescricao.setTabSize(10);
        textDescricao.setAutoscrolls(false);
        jScrollPane1.setViewportView(textDescricao);

        id.setText("ID");
        fieldId.setText(idStr);

        fieldId.setEditable(false);
        fieldId.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        fieldId.setAutoscrolls(false);
        fieldId.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdActionPerformed(evt);
            }
        });

        panelCodigoIni.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Inicialização"));

        panelInicializacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelInicializacao.setAutoscrolls(false);

        inicializacaoTextA.setColumns(20);
        inicializacaoTextA.setRows(5);
        jScrollPane4.setViewportView(inicializacaoTextA);

        javax.swing.GroupLayout panelInicializacaoLayout = new javax.swing.GroupLayout(panelInicializacao);
        panelInicializacao.setLayout(panelInicializacaoLayout);
        panelInicializacaoLayout.setHorizontalGroup(
                panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE));
        panelInicializacaoLayout.setVerticalGroup(
                panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE));

        okInicializacao.setText("OK");
        okInicializacao.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okInicializacaoActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout panelCodigoIniLayout = new javax.swing.GroupLayout(panelCodigoIni);
        panelCodigoIni.setLayout(panelCodigoIniLayout);
        panelCodigoIniLayout.setHorizontalGroup(
                panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoIniLayout.createSequentialGroup().addContainerGap().addComponent(panelInicializacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(okInicializacao)));
        panelCodigoIniLayout.setVerticalGroup(
                panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelCodigoIniLayout.createSequentialGroup().addContainerGap().addGroup(panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(panelInicializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(okInicializacao)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jScrollPane2.setToolTipText("Digite o texto da questão");

        textTitulo.setColumns(20);
        textTitulo.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        textTitulo.setRows(5);
        textTitulo.setAutoscrolls(false);
        jScrollPane2.setViewportView(textTitulo);

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        panelAnimacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização"));
        panelAnimacao.setAutoscrolls(false);

        javax.swing.GroupLayout panelAnimacaoLayout = new javax.swing.GroupLayout(panelAnimacao);
        panelAnimacao.setLayout(panelAnimacaoLayout);
        panelAnimacaoLayout.setHorizontalGroup(
                panelAnimacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 468, Short.MAX_VALUE));
        panelAnimacaoLayout.setVerticalGroup(
                panelAnimacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 624, Short.MAX_VALUE));

        panelCodigoSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Solução"));

        panelSolucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSolucao.setPreferredSize(new java.awt.Dimension(501, 193));

        solucaoText.setColumns(20);
        solucaoText.setRows(5);
        jScrollPane5.setViewportView(solucaoText);

        javax.swing.GroupLayout panelSolucaoLayout = new javax.swing.GroupLayout(panelSolucao);
        panelSolucao.setLayout(panelSolucaoLayout);
        panelSolucaoLayout.setHorizontalGroup(
                panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE));
        panelSolucaoLayout.setVerticalGroup(
                panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE));

        okSolucao.setText("OK");
        okSolucao.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okSolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCodigoSolLayout = new javax.swing.GroupLayout(panelCodigoSol);
        panelCodigoSol.setLayout(panelCodigoSolLayout);
        panelCodigoSolLayout.setHorizontalGroup(
                panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoSolLayout.createSequentialGroup().addContainerGap().addComponent(panelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(okSolucao)));
        panelCodigoSolLayout.setVerticalGroup(
                panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoSolLayout.createSequentialGroup().addGroup(panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(panelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(panelCodigoSolLayout.createSequentialGroup().addContainerGap().addComponent(okSolucao))).addContainerGap()));

        area.setText("Área");

        comboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash"}));
        comboArea.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
            }
        });

        okInformacao.setText("OK");
        okInformacao.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okInformacaoActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(descricao, javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(titulo).addComponent(autor)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)).addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addComponent(fieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(id).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(area).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(okInformacao))).addComponent(panelCodigoIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panelCodigoSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(layout.createSequentialGroup().addGap(334, 334, 334).addComponent(botaoCadastrar).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE).addComponent(botaoCancelar))).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panelAnimacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(29, 29, 29).addComponent(titulo)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(panelAnimacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(autor).addGap(33, 33, 33).addComponent(descricao)).addGroup(layout.createSequentialGroup().addGap(9, 9, 9).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(okInformacao).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(fieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(id)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(area)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panelCodigoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panelCodigoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(botaoCadastrar).addComponent(botaoCancelar))))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        autor = new javax.swing.JLabel();
        fieldAutor = new javax.swing.JTextField();
        descricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();
        id = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        panelCodigoIni = new javax.swing.JPanel();
        panelInicializacao = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        inicializacao = new javax.swing.JTextArea();
        okInicializacao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textTitulo = new javax.swing.JTextArea();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        panelAnimacao = new javax.swing.JPanel();
        panelCodigoSol = new javax.swing.JPanel();
        panelSolucao = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        solucao = new javax.swing.JTextArea();
        okSolucao = new javax.swing.JButton();
        area = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox();
        okInformacao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrador de Tarefa");
        setName("cadastradorDeTarefa"); // NOI18N
        setResizable(false);

        titulo.setText("Título");

        autor.setText("Autor");

        fieldAutor.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        fieldAutor.setAutoscrolls(false);

        descricao.setText("Descrição");

        textDescricao.setColumns(20);
        textDescricao.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        textDescricao.setRows(5);
        textDescricao.setTabSize(10);
        textDescricao.setAutoscrolls(false);
        jScrollPane1.setViewportView(textDescricao);

        id.setText("ID");

        fieldId.setEditable(false);
        fieldId.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        fieldId.setAutoscrolls(false);
        fieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdActionPerformed(evt);
            }
        });

        panelCodigoIni.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Inicialização"));

        panelInicializacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inicializacao.setColumns(20);
        inicializacao.setRows(5);
        jScrollPane4.setViewportView(inicializacao);

        javax.swing.GroupLayout panelInicializacaoLayout = new javax.swing.GroupLayout(panelInicializacao);
        panelInicializacao.setLayout(panelInicializacaoLayout);
        panelInicializacaoLayout.setHorizontalGroup(
            panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        panelInicializacaoLayout.setVerticalGroup(
            panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );

        okInicializacao.setText("OK");

        javax.swing.GroupLayout panelCodigoIniLayout = new javax.swing.GroupLayout(panelCodigoIni);
        panelCodigoIni.setLayout(panelCodigoIniLayout);
        panelCodigoIniLayout.setHorizontalGroup(
            panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoIniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInicializacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okInicializacao))
        );
        panelCodigoIniLayout.setVerticalGroup(
            panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoIniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelInicializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okInicializacao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setToolTipText("Digite o texto da questão");

        textTitulo.setColumns(20);
        textTitulo.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        textTitulo.setRows(5);
        textTitulo.setAutoscrolls(false);
        jScrollPane2.setViewportView(textTitulo);

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        panelAnimacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização"));

        javax.swing.GroupLayout panelAnimacaoLayout = new javax.swing.GroupLayout(panelAnimacao);
        panelAnimacao.setLayout(panelAnimacaoLayout);
        panelAnimacaoLayout.setHorizontalGroup(
            panelAnimacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );
        panelAnimacaoLayout.setVerticalGroup(
            panelAnimacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        panelCodigoSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Solução"));

        panelSolucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSolucao.setPreferredSize(new java.awt.Dimension(501, 193));

        solucao.setColumns(20);
        solucao.setRows(5);
        jScrollPane5.setViewportView(solucao);

        javax.swing.GroupLayout panelSolucaoLayout = new javax.swing.GroupLayout(panelSolucao);
        panelSolucao.setLayout(panelSolucaoLayout);
        panelSolucaoLayout.setHorizontalGroup(
            panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        panelSolucaoLayout.setVerticalGroup(
            panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );

        okSolucao.setText("OK");

        javax.swing.GroupLayout panelCodigoSolLayout = new javax.swing.GroupLayout(panelCodigoSol);
        panelCodigoSol.setLayout(panelCodigoSolLayout);
        panelCodigoSolLayout.setHorizontalGroup(
            panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoSolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okSolucao))
        );
        panelCodigoSolLayout.setVerticalGroup(
            panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoSolLayout.createSequentialGroup()
                .addGroup(panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCodigoSolLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(okSolucao)))
                .addContainerGap())
        );

        area.setText("Área");

        comboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash" }));
        comboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
            }
        });

        okInformacao.setText("OK");
        okInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okInformacaoActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(descricao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titulo)
                                    .addComponent(autor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(id)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(area)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(okInformacao)))
                            .addComponent(panelCodigoIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelCodigoSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(botaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(botaoCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAnimacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelAnimacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(autor)
                                                .addGap(33, 33, 33)
                                                .addComponent(descricao))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(okInformacao)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(fieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(id))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(area))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCodigoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCodigoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCadastrar)
                            .addComponent(botaoCancelar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     */
    private void fieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdActionPerformed

    public void okInicializacaoActionPerformed(java.awt.event.ActionEvent evt) {
        StringTokenizer st = new StringTokenizer(inicializacaoTextA.getText(), "\n");
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println(c);
            iter.interprete(c);
        }
    }

    public void okSolucaoActionPerformed(java.awt.event.ActionEvent evt) {
        StringTokenizer st = new StringTokenizer(solucaoText.getText(), "\n");
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println(c);
            iter.interprete(c);
        }
    }
    XmlPersistencia xml = new XmlPersistencia();
    LeitorXmlGerenciador lxml = new LeitorXmlGerenciador();
    File tarefas = new File("C:\\Tarefas\\tarefas.xml");
    PortifolioXml pxml = new PortifolioXml();

    
    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        //while (validado != true) {
        try {
            validarCodInicializacao();
            validarCodSolucao();
            MetadadoTarefa mt = new MetadadoTarefa();
            mt.setArea(getAreaStr());
            mt.setTitulo(getTituloStr());
            mt.setAutor(getAutorStr());
            
            Tarefa tarefa = new Tarefa();
            tarefa.setMetadado(mt);
            tarefa.setCodInicializacao(inicializacaoStr);
            tarefa.setCodSolucao(solucaoStr);
            
            GerenciadorTarefa gt = GerenciadorTarefa.getInstance();
            gt.cadastrarTarefa(tarefa);
            
            
            apagarCampos();
            //lxml.lerXmlTarefa();
            //lxml.lerXmlGerTarefas(tarefas);
            //pxml.atualizar();
            //xml.salvarPortifolioXmlAtualizado();
        } catch (CampoObrigatorioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed
/*
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
    }//GEN-LAST:event_botaoCancelarActionPerformed
*/
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
    }
    
    
    private void comboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreaActionPerformed
    }//GEN-LAST:event_comboAreaActionPerformed

    private void okInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okInformacaoActionPerformed

        Object[] opcoes = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que os campos estão preenchidos corretamente?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            try {
                try {
                    validarTexto();

                    comboArea.setEnabled(false);
                    fieldAutor.setEnabled(false);
                    fieldId.setEnabled(false);
                    textDescricao.setEnabled(false);
                    textTitulo.setEnabled(false);
                    okInformacao.setEnabled(false);
                } catch (CampoObrigatorioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } catch (DiretorioExistenteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (CampoInvalidoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_okInformacaoActionPerformed

    public void apagarCampos() {
        comboArea.setSelectedIndex(0);
        fieldAutor.setText("");
        fieldId.setText("");
        textDescricao.setText("");
        textTitulo.setText("");
    }
    static String tituloStr;
    static String idStr = new Integer(CadastroTarefa.idIncrementado()).toString();
    static String autorStr;
    static String descricaoStr;
    static String areaStr;
    static String inicializacaoStr;
    static String solucaoStr;

    public static String getCodigoInicializacao() {
        inicializacaoStr = inicializacaoTextA.getText();
        return inicializacaoStr;
    }

    public void validarCodInicializacao() throws CampoObrigatorioException {
        inicializacaoStr = inicializacaoTextA.getText();
        if (inicializacaoStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo Código de Inicialização é obrigatório! Preencha-o!");
        } else {
            System.out.println(getCodigoInicializacao().toString());
        }
    }

    public static String getCodigoSolucao() {
        solucaoStr = solucaoText.getText();
        return solucaoStr;
    }

    public void validarCodSolucao() throws CampoObrigatorioException {
        solucaoStr = solucaoText.getText();
        if (solucaoStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo Código de Inicialização é obrigatório! Preencha-o!");
        } else {
            System.out.println(solucaoStr);
        }
    }

    public void validarTitulo() throws CampoObrigatorioException, CampoInvalidoException {
        tituloStr = textTitulo.getText();
        if (tituloStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo " + titulo.getText() + " é obrigatório! Preencha-o!");
        } else {
            Pattern p = Pattern.compile("[a-zA-Z0-9áÁàÀãÃçÇéÉêÊíÍôÔúÚ,.;+=^~<>:!@#$%¨&*(){}\\s]+");
            Matcher m = p.matcher(tituloStr);
            boolean encontrou = m.matches();
            if (encontrou) {
                System.out.println("OK");
            } else {
                textTitulo.setText("");
                throw new CampoInvalidoException("O campo " + titulo.getText() + " contém caracteres inválidos");
            }
        }
    }

    public void validarID() throws CampoObrigatorioException, CampoInvalidoException, DiretorioExistenteException {
        idStr = fieldId.getText();
        if (idStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo " + id.getText() + " é obrigatório! Preencha-o!");
        } else {
            Pattern p = Pattern.compile("[0-9\\s]+");
            Matcher m = p.matcher(idStr);
            boolean encontrou = m.matches();
            if (encontrou) {
                //criarDiretorioTarefa();
                System.out.println("OK");
            } else {
                fieldId.setText("");
                throw new CampoInvalidoException("O campo " + id.getText() + " contém caracteres inválidos");
            }
        }
    }

    public void validarArea() throws CampoObrigatorioException, CampoInvalidoException {
        areaStr = comboArea.getSelectedItem().toString();
        if (areaStr == comboArea.getItemAt(0)) {
            comboArea.setSelectedIndex(0);
            throw new CampoObrigatorioException("O Campo" + area.getText() + " é Obrigatório! Selecione uma área!");
        } else {
            if (areaStr == comboArea.getItemAt(1)) {
                System.out.println("Área: Árvore!");
            } else {
                if (areaStr == comboArea.getItemAt(2)) {
                    System.out.println("Área: Fila!");
                } else {
                    if (areaStr == comboArea.getItemAt(3)) {
                        System.out.println("Área: Lista!");
                    } else {
                        if (areaStr == comboArea.getItemAt(4)) {
                            System.out.println("Área: Ordenação!");
                        } else {
                            if (areaStr == comboArea.getItemAt(5)) {
                                System.out.println("Área: Pilha!");
                            } else {
                                if (areaStr == comboArea.getItemAt(6)) {
                                    System.out.println("Área: Tabela Hash!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void validarAutor() throws CampoObrigatorioException, CampoInvalidoException {
        autorStr = fieldAutor.getText();
        if (autorStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo " + autor.getText() + " é obrigatório! Preencha-o!");
        } else {
            Pattern p = Pattern.compile("[a-zA-Z0-9áÁàÀãÃçÇéÉêÊíÍôÔúÚ,.;+=^~<>:!@#$%¨&*(){}\\s]+");
            Matcher m = p.matcher(autorStr);
            boolean encontrou = m.matches();
            if (encontrou) {
                System.out.println("OK");
            } else {
                fieldAutor.setText("");
                throw new CampoInvalidoException("O campo " + autor.getText() + " contém caracteres inválidos");

            }
        }
    }

    public void validarDescricao() throws CampoObrigatorioException, CampoInvalidoException {
        descricaoStr = textDescricao.getText();
        if (descricaoStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo " + textDescricao.getText() + " é obrigatório! Preencha-o!");
        } else {
            Pattern p = Pattern.compile("[a-zA-Z0-9áÁàÀãÃçÇéÉêÊíÍôÔúÚ,.;+=^~<>:!@#$%¨&*(){}\\s]+");
            Matcher m = p.matcher(descricaoStr);
            boolean encontrou = m.matches();
            if (encontrou) {
                System.out.println("OK");
            } else {
                textDescricao.setText("");
                throw new CampoInvalidoException("O campo " + textDescricao.getText() + " contém caracteres inválidos");

            }
        }
    }
    private boolean validado;

    public boolean validarTexto() throws CampoObrigatorioException, CampoInvalidoException, DiretorioExistenteException {
        try {
            validarTitulo();
            validarID();
            validarArea();
            validarAutor();
            validarDescricao();
            validado = true;
        } catch (CampoInvalidoException ex) {
            validado = false;
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return validado;
    }

    protected static String getInicializacaoStr() {
        return inicializacaoStr;
    }

    protected static String getSolucaoStr() {
        return solucaoStr;
    }

    protected static String getTituloStr() {
        return tituloStr;
    }

    public String getIdStr() {
        return idStr;
    }

    protected static String getAutorStr() {
        return autorStr;
    }

    protected static String getDescricaoStr() {
        return descricaoStr;
    }

    protected static String getAreaStr() {
        return areaStr;
    }

    public static void main(String args[]) {
            try {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame cadastrador = new TelaCadastroDeTarefa();
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                gd.setFullScreenWindow(cadastrador);
            }
        });
    }
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel area;
    private javax.swing.JLabel autor;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox comboArea;
    private javax.swing.JLabel descricao;
    private javax.swing.JTextField fieldAutor;
    private javax.swing.JTextField fieldId;
    private javax.swing.JLabel id;
    private javax.swing.JTextArea inicializacao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton okInformacao;
    private javax.swing.JButton okInicializacao;
    private javax.swing.JButton okSolucao;
    private javax.swing.JPanel panelAnimacao;
    private javax.swing.JPanel panelCodigoIni;
    private javax.swing.JPanel panelCodigoSol;
    private javax.swing.JPanel panelInicializacao;
    private javax.swing.JPanel panelSolucao;
    private javax.swing.JTextArea solucao;
    private javax.swing.JTextArea textDescricao;
    private javax.swing.JTextArea textTitulo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
     */
    private javax.swing.JLabel area;
    private javax.swing.JLabel autor;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox comboArea;
    private javax.swing.JLabel descricao;
    private javax.swing.JTextField fieldAutor;
    private javax.swing.JTextField fieldId;
    private javax.swing.JLabel id;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton okInformacao;
    private javax.swing.JButton okInicializacao;
    private javax.swing.JButton okSolucao;
    private javax.swing.JPanel panelCodigoIni;
    private javax.swing.JPanel panelCodigoSol;
    private javax.swing.JPanel panelAnimacao;
    private javax.swing.JPanel panelInicializacao;
    private javax.swing.JPanel panelSolucao;
    private javax.swing.JTextArea textDescricao;
    private javax.swing.JTextArea textTitulo;
    private javax.swing.JLabel titulo;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTextArea inicializacaoTextA;
    private static javax.swing.JTextArea solucaoText;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane4;
}
