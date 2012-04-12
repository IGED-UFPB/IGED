/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaCadastroDeTarefaInterno.java
 *
 * Created on 14/03/2012, 14:23:30
 */
package br.ufpb.iged.gui;

import br.ufpb.iged.Interpretador;
import br.ufpb.iged.gerenciadorApresentacao.CampoInvalidoException;
import br.ufpb.iged.gerenciadorApresentacao.CampoObrigatorioException;
import br.ufpb.iged.gerenciadorApresentacao.DiretorioExistenteException;
import br.ufpb.iged.gerenciadorIGEDlet.GerenciadorAtividade;
import br.ufpb.iged.gerenciadorIGEDlet.Metadado;
import br.ufpb.iged.gerenciadorIGEDlet.Portifolio;
import br.ufpb.iged.gerenciadorIGEDlet.PortifolioXml;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDletSubjetiva;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDletSubjetivaDAO;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDletXml;
import br.ufpb.iged.gerenciadorIGEDlet.XmlPersistencia;
import br.ufpb.iged.gui.gerenciador.LeitorXmlGerenciador;
import java.io.File;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dorgi
 */
public class TelaCadastroDeTarefaInterno extends javax.swing.JInternalFrame {

    //Interpretador iter = Interpretador.getInstance();
    /** Creates new form TelaCadastroDeTarefaInterno */
    public TelaCadastroDeTarefaInterno() {
        initComponents();
    }

    private void initComponents() {

        area = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        fieldAutor = new javax.swing.JTextField();
        okInformacao = new javax.swing.JButton();
        comboArea = new javax.swing.JComboBox();
        botaoCadastrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textTitulo = new javax.swing.JTextArea();
        autor = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        panelCodigoIni = new javax.swing.JPanel();
        panelInicializacao = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        inicializacaoTextA = new javax.swing.JTextArea();
        okInicializacao = new javax.swing.JButton();
        panelCodigoSol = new javax.swing.JPanel();
        panelSolucao = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        solucaoText = new javax.swing.JTextArea();
        okSolucao = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        panelAnimacao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("Cadastro de Exercício");
        
        area.setText("Área");

        descricao.setText("Descrição");

        fieldAutor.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        fieldAutor.setAutoscrolls(false);

        okInformacao.setText("OK");
        okInformacao.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okInformacaoActionPerformed(evt);
            }
        });

        comboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash"}));
        comboArea.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
            }
        });

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        jScrollPane2.setToolTipText("Digite o texto da questão");

        textTitulo.setColumns(20);
        textTitulo.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        textTitulo.setRows(5);
        textTitulo.setAutoscrolls(false);
        jScrollPane2.setViewportView(textTitulo);

        autor.setText("Autor");

        titulo.setText("Título");

        panelCodigoIni.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Inicialização"));

        panelInicializacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inicializacaoTextA.setColumns(20);
        inicializacaoTextA.setRows(5);
        jScrollPane4.setViewportView(inicializacaoTextA);

        javax.swing.GroupLayout panelInicializacaoLayout = new javax.swing.GroupLayout(panelInicializacao);
        panelInicializacao.setLayout(panelInicializacaoLayout);
        panelInicializacaoLayout.setHorizontalGroup(
                panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE));
        panelInicializacaoLayout.setVerticalGroup(
                panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE));

        okInicializacao.setText("OK");
        okInicializacao.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okInicializacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCodigoIniLayout = new javax.swing.GroupLayout(panelCodigoIni);
        panelCodigoIni.setLayout(panelCodigoIniLayout);
        panelCodigoIniLayout.setHorizontalGroup(
                panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelCodigoIniLayout.createSequentialGroup().addContainerGap().addComponent(panelInicializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE).addComponent(okInicializacao).addContainerGap()));
        panelCodigoIniLayout.setVerticalGroup(
                panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelCodigoIniLayout.createSequentialGroup().addGroup(panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(okInicializacao).addComponent(panelInicializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        panelCodigoSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Solução"));

        panelSolucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSolucao.setPreferredSize(new java.awt.Dimension(501, 193));

        solucaoText.setColumns(20);
        solucaoText.setRows(5);
        jScrollPane5.setViewportView(solucaoText);

        javax.swing.GroupLayout panelSolucaoLayout = new javax.swing.GroupLayout(panelSolucao);
        panelSolucao.setLayout(panelSolucaoLayout);
        panelSolucaoLayout.setHorizontalGroup(
                panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE));
        panelSolucaoLayout.setVerticalGroup(
                panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE));

        okSolucao.setText("OK");
        okSolucao.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okSolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCodigoSolLayout = new javax.swing.GroupLayout(panelCodigoSol);
        panelCodigoSol.setLayout(panelCodigoSolLayout);
        panelCodigoSolLayout.setHorizontalGroup(
                panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelCodigoSolLayout.createSequentialGroup().addContainerGap().addComponent(panelSolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(okSolucao).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panelCodigoSolLayout.setVerticalGroup(
                panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoSolLayout.createSequentialGroup().addGroup(panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(panelCodigoSolLayout.createSequentialGroup().addContainerGap().addComponent(okSolucao)).addComponent(panelSolucao, 0, 124, Short.MAX_VALUE)).addContainerGap()));

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
                panelAnimacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 426, Short.MAX_VALUE));
        panelAnimacaoLayout.setVerticalGroup(
                panelAnimacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 485, Short.MAX_VALUE));

        textDescricao.setColumns(20);
        textDescricao.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        textDescricao.setRows(5);
        textDescricao.setTabSize(10);
        textDescricao.setAutoscrolls(false);
        jScrollPane1.setViewportView(textDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(panelCodigoIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(descricao).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(titulo).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(autor).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(fieldAutor))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(area).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(okInformacao)))).addComponent(panelCodigoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(panelAnimacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addGap(432, 432, 432).addComponent(botaoCadastrar).addGap(48, 48, 48).addComponent(botaoCancelar))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(titulo)).addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(fieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(autor))).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(area))).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGap(43, 43, 43).addComponent(descricao).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(okInformacao)).addGroup(layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(panelCodigoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panelCodigoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(panelAnimacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(botaoCadastrar).addComponent(botaoCancelar)).addContainerGap()));

        pack();
    }

    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        area = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        fieldAutor = new javax.swing.JTextField();
        okInformacao = new javax.swing.JButton();
        comboArea = new javax.swing.JComboBox();
        botaoCadastrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textTitulo = new javax.swing.JTextArea();
        autor = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        panelCodigoIni = new javax.swing.JPanel();
        panelInicializacao = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        inicializacaoTextA = new javax.swing.JTextArea();
        okInicializacao = new javax.swing.JButton();
        panelCodigoSol = new javax.swing.JPanel();
        panelSolucao = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        solucaoText = new javax.swing.JTextArea();
        okSolucao = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        panelAnimacao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("Cadastro de IGEDletSubjetiva");

        area.setText("Área");

        descricao.setText("Descrição");

        fieldAutor.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        fieldAutor.setAutoscrolls(false);

        okInformacao.setText("OK");
        okInformacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okInformacaoActionPerformed(evt);
            }
        });

        comboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash" }));
        comboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
            }
        });

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        jScrollPane2.setToolTipText("Digite o texto da questão");

        textTitulo.setColumns(20);
        textTitulo.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        textTitulo.setRows(5);
        textTitulo.setAutoscrolls(false);
        jScrollPane2.setViewportView(textTitulo);

        autor.setText("Autor");

        titulo.setText("Título");

        panelCodigoIni.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Inicialização"));

        panelInicializacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inicializacaoTextA.setColumns(20);
        inicializacaoTextA.setRows(5);
        jScrollPane4.setViewportView(inicializacaoTextA);

        javax.swing.GroupLayout panelInicializacaoLayout = new javax.swing.GroupLayout(panelInicializacao);
        panelInicializacao.setLayout(panelInicializacaoLayout);
        panelInicializacaoLayout.setHorizontalGroup(
            panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        panelInicializacaoLayout.setVerticalGroup(
            panelInicializacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );

        okInicializacao.setText("OK");
        okInicializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okInicializacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCodigoIniLayout = new javax.swing.GroupLayout(panelCodigoIni);
        panelCodigoIni.setLayout(panelCodigoIniLayout);
        panelCodigoIniLayout.setHorizontalGroup(
            panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoIniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInicializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(okInicializacao)
                .addContainerGap())
        );
        panelCodigoIniLayout.setVerticalGroup(
            panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoIniLayout.createSequentialGroup()
                .addGroup(panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okInicializacao)
                    .addComponent(panelInicializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCodigoSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Solução"));

        panelSolucao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSolucao.setPreferredSize(new java.awt.Dimension(501, 193));

        solucaoText.setColumns(20);
        solucaoText.setRows(5);
        jScrollPane5.setViewportView(solucaoText);

        javax.swing.GroupLayout panelSolucaoLayout = new javax.swing.GroupLayout(panelSolucao);
        panelSolucao.setLayout(panelSolucaoLayout);
        panelSolucaoLayout.setHorizontalGroup(
            panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        panelSolucaoLayout.setVerticalGroup(
            panelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        okSolucao.setText("OK");
        okSolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okSolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCodigoSolLayout = new javax.swing.GroupLayout(panelCodigoSol);
        panelCodigoSol.setLayout(panelCodigoSolLayout);
        panelCodigoSolLayout.setHorizontalGroup(
            panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoSolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okSolucao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCodigoSolLayout.setVerticalGroup(
            panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCodigoSolLayout.createSequentialGroup()
                .addGroup(panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCodigoSolLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(okSolucao))
                    .addComponent(panelSolucao, 0, 124, Short.MAX_VALUE))
                .addContainerGap())
        );

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
            .addGap(0, 426, Short.MAX_VALUE)
        );
        panelAnimacaoLayout.setVerticalGroup(
            panelAnimacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        textDescricao.setColumns(20);
        textDescricao.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        textDescricao.setRows(5);
        textDescricao.setTabSize(10);
        textDescricao.setAutoscrolls(false);
        jScrollPane1.setViewportView(textDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(panelCodigoIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(descricao)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(titulo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(autor)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fieldAutor)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(area)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(okInformacao))))
                            .addComponent(panelCodigoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelAnimacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(botaoCadastrar)
                        .addGap(48, 48, 48)
                        .addComponent(botaoCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(titulo))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(autor)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(area)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(descricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(okInformacao))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCodigoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCodigoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelAnimacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     */
    private void comboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreaActionPerformed
    }//GEN-LAST:event_comboAreaActionPerformed

        private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
    }//GEN-LAST:event_botaoCancelarActionPerformed
    XmlPersistencia xml = new XmlPersistencia();
    LeitorXmlGerenciador lxml = new LeitorXmlGerenciador();
    File tarefas = new File("C:\\Tarefas\\tarefas.xml");
    //PortifolioXml pxml = new PortifolioXml();
    Portifolio p;

    private void okInformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okInformacaoActionPerformed
        Object[] opcoes = {"Sim", "Não"};
        int opcao = JOptionPane.showInternalOptionDialog(this, "Tem certeza que os campos estão preenchidos corretamente?", "Informação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("./imagens/25.png"), opcoes, iconable);
        if (opcao == JOptionPane.YES_OPTION) {
            try {
                try {
                    validarTexto();
                    comboArea.setEnabled(false);
                    fieldAutor.setEnabled(false);
                    textDescricao.setEnabled(false);
                    textTitulo.setEnabled(false);
                    okInformacao.setEnabled(false);
                } catch (CampoObrigatorioException ex) {
                    JOptionPane.showInternalMessageDialog(this, ex.getMessage());
                }
            } catch (DiretorioExistenteException ex) {
                JOptionPane.showInternalMessageDialog(this, ex.getMessage());
            } catch (CampoInvalidoException ex) {
                JOptionPane.showInternalMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_okInformacaoActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        try {
            validarCodInicializacao();
            validarCodSolucao();

            Metadado mt = new Metadado();
            mt.setArea(getAreaStr());
            mt.setTitulo(getTituloStr());
            mt.setAutor(getAutorStr());

            IGEDletSubjetivaDAO tarefa = new IGEDletSubjetivaDAO();
            tarefa.setMetadado(mt);
            tarefa.setCodInicializacao(inicializacaoStr);
            tarefa.setCodSolucao(solucaoStr);
            tarefa.setDescricao(descricaoStr);

            IGEDletSubjetiva ts = new IGEDletSubjetiva();
            ts.setDAO(tarefa);
            GerenciadorAtividade gt = GerenciadorAtividade.getInstance();
            gt.cadastrar(ts);

            PortifolioXml.lerXml();
            IGEDletXml.lerXml(tarefa.getMetadado());
            apagarCampos();
            //lxml.lerXmlTarefa();
            //lxml.lerXmlGerTarefas(tarefas);
            //pxml.atualizar();
            //xml.salvarPortifolioXmlAtualizado();
        } catch (CampoObrigatorioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void okInicializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okInicializacaoActionPerformed
        StringTokenizer st = new StringTokenizer(inicializacaoTextA.getText(), "\n");
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println(c);
//            iter.interprete(c);
        }
    }//GEN-LAST:event_okInicializacaoActionPerformed

    private void okSolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okSolucaoActionPerformed
        StringTokenizer st = new StringTokenizer(solucaoText.getText(), "\n");
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println(c);
            //iter.interprete(c);
        }
    }
    /* 
        StringTokenizer st = new StringTokenizer(solucaoText.getText(), "\n");         while (st.hasMoreTokens()) {             String c = st.nextToken();             System.out.println(c);             iter.interprete(c);         }     }//GEN-LAST:event_okSolucaoActionPerformed
     */

    public void apagarCampos() {
        comboArea.setSelectedIndex(0);
        fieldAutor.setText("");
        textDescricao.setText("");
        textTitulo.setText("");
        inicializacaoTextA.setText("");
        solucaoText.setText("");
    }
    static String tituloStr;
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
            validarArea();
            validarAutor();
            validarDescricao();
            validado = true;
        } catch (CampoInvalidoException ex) {
            validado = false;
            JOptionPane.showInternalMessageDialog(this, ex.getMessage());
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
                Logger.getLogger(TelaCadastroDeTarefaInterno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastroDeTarefaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaCadastroDeTarefaInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaCadastroDeTarefaInterno.class.getName()).log(Level.SEVERE, null, ex);

        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaCadastroDeTarefaInterno();

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
    private javax.swing.JTextArea inicializacaoTextA;
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
    private javax.swing.JTextArea solucaoText;
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
    private static javax.swing.JTextArea inicializacaoTextA;
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
    private static javax.swing.JTextArea solucaoText;
    private javax.swing.JTextArea textDescricao;
    private javax.swing.JTextArea textTitulo;
    private javax.swing.JLabel titulo;
    private javax.swing.JScrollBar jScrollBar1;
}