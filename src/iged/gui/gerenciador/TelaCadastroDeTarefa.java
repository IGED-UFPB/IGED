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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Dorgi
 */
public class TelaCadastroDeTarefa extends javax.swing.JFrame {

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
        jScrollPane2 = new javax.swing.JScrollPane();
        textTitulo = new javax.swing.JTextArea();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelCodigoSol = new javax.swing.JPanel();
        panelSolucao = new javax.swing.JPanel();
        area = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane3 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrador de Tarefa");
        setName("cadastradorDeTarefa"); // NOI18N
        setResizable(false);

        titulo.setText("Título");


        autor.setText("Autor");

        fieldAutor.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        fieldAutor.setAutoscrolls(false);

        descricao.setText("Descrição");

        textDescricao.setLineWrap(true);
        jScrollPane3 = new JScrollPane(textDescricao);
        textDescricao.setColumns(10);
        textDescricao.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        textDescricao.setRows(5);
        textDescricao.setTabSize(10);

        jScrollPane1.setViewportView(textDescricao);

        id.setText("ID");

        //CadastroTarefa ct = new CadastroTarefa();

        fieldId.setEditable(false);
        fieldId.setText(idStr);
        fieldId.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        fieldId.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdActionPerformed(evt);
            }
        });

        panelCodigoIni.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Inicialização"));

        panelInicializacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelInicializacaoLayout = new javax.swing.GroupLayout(panelInicializacao);
        panelInicializacao.setLayout(panelInicializacaoLayout);
        panelInicializacaoLayout.setHorizontalGroup(
                panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 463, Short.MAX_VALUE));
        panelInicializacaoLayout.setVerticalGroup(
                panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 189, Short.MAX_VALUE));

        javax.swing.GroupLayout panelCodigoIniLayout = new javax.swing.GroupLayout(panelCodigoIni);
        panelCodigoIni.setLayout(panelCodigoIniLayout);
        panelCodigoIniLayout.setHorizontalGroup(
                panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelCodigoIniLayout.createSequentialGroup().addContainerGap().addComponent(panelInicializacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        panelCodigoIniLayout.setVerticalGroup(
                panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelCodigoIniLayout.createSequentialGroup().addComponent(panelInicializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jScrollPane2.setToolTipText("Digite o texto da questão");

        textTitulo.setLineWrap(true);
        textTitulo.setColumns(10);
        textTitulo.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        textTitulo.setRows(5);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização"));
        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 462, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 613, Short.MAX_VALUE));

        panelCodigoSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Solução"));

        panelSolucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSolucao.setPreferredSize(new java.awt.Dimension(501, 193));

        javax.swing.GroupLayout panelSolucaoLayout = new javax.swing.GroupLayout(panelSolucao);
        panelSolucao.setLayout(panelSolucaoLayout);
        panelSolucaoLayout.setHorizontalGroup(
                panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 463, Short.MAX_VALUE));
        panelSolucaoLayout.setVerticalGroup(
                panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 189, Short.MAX_VALUE));

        javax.swing.GroupLayout panelCodigoSolLayout = new javax.swing.GroupLayout(panelCodigoSol);
        panelCodigoSol.setLayout(panelCodigoSolLayout);
        panelCodigoSolLayout.setHorizontalGroup(
                panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelCodigoSolLayout.createSequentialGroup().addContainerGap().addComponent(panelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE).addContainerGap()));
        panelCodigoSolLayout.setVerticalGroup(
                panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoSolLayout.createSequentialGroup().addComponent(panelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

        area.setText("Área");

        comboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash"}));
        comboArea.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
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
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(descricao, javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(titulo).addComponent(autor)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)).addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addComponent(fieldAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(id).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(area).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(panelCodigoIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(panelCodigoSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addGroup(layout.createSequentialGroup().addGap(334, 334, 334).addComponent(botaoCadastrar).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE).addComponent(botaoCancelar))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(29, 29, 29).addComponent(titulo)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(autor).addGap(33, 33, 33).addComponent(descricao)).addGroup(layout.createSequentialGroup().addGap(9, 9, 9).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(fieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(id)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(area)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panelCodigoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panelCodigoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(botaoCadastrar).addComponent(botaoCancelar)))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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
        jScrollPane2 = new javax.swing.JScrollPane();
        textTitulo = new javax.swing.JTextArea();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelCodigoSol = new javax.swing.JPanel();
        panelSolucao = new javax.swing.JPanel();
        area = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox();
        OK = new javax.swing.JButton();
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
        jScrollPane1.setViewportView(textDescricao);

        id.setText("ID");

        fieldId.setEditable(false);
        fieldId.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        fieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdActionPerformed(evt);
            }
        });

        panelCodigoIni.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Inicialização"));

        panelInicializacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelInicializacaoLayout = new javax.swing.GroupLayout(panelInicializacao);
        panelInicializacao.setLayout(panelInicializacaoLayout);
        panelInicializacaoLayout.setHorizontalGroup(
            panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        panelInicializacaoLayout.setVerticalGroup(
            panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelCodigoIniLayout = new javax.swing.GroupLayout(panelCodigoIni);
        panelCodigoIni.setLayout(panelCodigoIniLayout);
        panelCodigoIniLayout.setHorizontalGroup(
            panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoIniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInicializacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCodigoIniLayout.setVerticalGroup(
            panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoIniLayout.createSequentialGroup()
                .addComponent(panelInicializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setToolTipText("Digite o texto da questão");

        textTitulo.setColumns(20);
        textTitulo.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        textTitulo.setRows(5);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização"));
        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        panelCodigoSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Solução"));

        panelSolucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSolucao.setPreferredSize(new java.awt.Dimension(501, 193));

        javax.swing.GroupLayout panelSolucaoLayout = new javax.swing.GroupLayout(panelSolucao);
        panelSolucao.setLayout(panelSolucaoLayout);
        panelSolucaoLayout.setHorizontalGroup(
            panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        panelSolucaoLayout.setVerticalGroup(
            panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelCodigoSolLayout = new javax.swing.GroupLayout(panelCodigoSol);
        panelCodigoSol.setLayout(panelCodigoSolLayout);
        panelCodigoSolLayout.setHorizontalGroup(
            panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoSolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCodigoSolLayout.setVerticalGroup(
            panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoSolLayout.createSequentialGroup()
                .addComponent(panelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        area.setText("Área");

        comboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash" }));
        comboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
            }
        });

        OK.setText("OK");

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
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(id)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(area)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(OK)
                                        .addGap(16, 16, 16))))
                            .addComponent(panelCodigoIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCodigoSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(botaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(botaoCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                                    .addComponent(OK)
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
    ConversorXmlTarefa cxml = new ConversorXmlTarefa();

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        while (validado != true){
        try {
            validarTexto();
        } catch (CampoObrigatorioException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CampoInvalidoException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DiretorioExistenteException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
            cxml.converter();
            cxml.salvarXML();
            //Depois que cadastrar chamar o método apagar para limpar os campos
            apagarCampos();
        }
            
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void comboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreaActionPerformed
    }//GEN-LAST:event_comboAreaActionPerformed

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

    protected static String getTituloStr() {
        return tituloStr;
    }

    protected String getIdStr() {
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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
    private javax.swing.JButton OK;
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
    private javax.swing.JPanel panelCodigoIni;
    private javax.swing.JPanel panelCodigoSol;
    private javax.swing.JPanel panelInicializacao;
    private javax.swing.JPanel panelSolucao;
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
    private javax.swing.JPanel panelCodigoIni;
    private javax.swing.JPanel panelCodigoSol;
    private javax.swing.JPanel panelInicializacao;
    private javax.swing.JPanel panelSolucao;
    private javax.swing.JTextArea textDescricao;
    private javax.swing.JTextArea textTitulo;
    private javax.swing.JLabel titulo;
    private javax.swing.JScrollPane jScrollPane3;
}
