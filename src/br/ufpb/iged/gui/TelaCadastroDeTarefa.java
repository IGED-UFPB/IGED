/*
 * CadastroDeTarefa.java
 *
 * Created on 07/02/2012, 22:30:45
 */
package br.ufpb.iged.gui;

import br.ufpb.iged.gerenciadorIGEDlet.GerenciadorAtividade;
import br.ufpb.iged.gerenciadorIGEDlet.Metadado;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDletSubjetiva;
import br.ufpb.iged.gerenciadorIGEDlet.PortifolioXml;
import java.awt.Color;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Dorgi, Renan Oliveira
 */
public class TelaCadastroDeTarefa extends javax.swing.JInternalFrame {

    //Interpretador iter = Interpretador.getInstance();
    
    
    /** Creates new form CadastroDeTarefa */
    public TelaCadastroDeTarefa() {
        initComponents();
    }
/*
private void initComponents() {

        titulo = new javax.swing.JLabel();
        autor = new javax.swing.JLabel();
        fieldAutor = new javax.swing.JTextField();
        descricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();
        panelCodigoIni = new javax.swing.JPanel();
        panelInicializacao = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        inicializacaoTextA = new javax.swing.JTextArea();
        okInicializacao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textTitulo = new javax.swing.JTextArea();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        panelAnimacao = new javax.swing.JPanel();
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

        fieldAutor.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        fieldAutor.setAutoscrolls(false);

        descricao.setText("Descrição");

        textDescricao.setColumns(20);
        textDescricao.setFont(new java.awt.Font("Bookman Old Style", 0, 12));
        textDescricao.setRows(5);
        textDescricao.setTabSize(10);
        textDescricao.setAutoscrolls(false);
        jScrollPane1.setViewportView(textDescricao);

        panelCodigoIni.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Inicialização"));

        panelInicializacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inicializacaoTextA.setColumns(20);
        inicializacaoTextA.setRows(5);
        jScrollPane4.setViewportView(inicializacaoTextA);

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

        solucaoText.setColumns(20);
        solucaoText.setRows(5);
        jScrollPane5.setViewportView(solucaoText);

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
                            .addComponent(panelCodigoIni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelCodigoSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(descricao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(titulo)
                                            .addComponent(autor))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                                            .addComponent(fieldAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(area)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(okInformacao)))))
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
                                                .addComponent(autor))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(fieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(descricao))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(okInformacao)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addContainerGap(38, Short.MAX_VALUE))
        );
            pack();
    }
    */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        autor = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();
        panelCodigoIni = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        panelAnimacao = new javax.swing.JPanel();
        panelCodigoSol = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        area = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrador de Tarefa");
        setName("cadastradorDeTarefa"); // NOI18N
        setResizable(false);

        titulo.setText("Título");

        autor.setText("Autor");

        descricao.setText("Descrição");

        textDescricao.setColumns(20);
        textDescricao.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        textDescricao.setRows(5);
        textDescricao.setTabSize(10);
        jScrollPane1.setViewportView(textDescricao);

        panelCodigoIni.setBorder(javax.swing.BorderFactory.createTitledBorder("Código de Inicialização"));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane7.setViewportView(jTextArea2);

        javax.swing.GroupLayout panelCodigoIniLayout = new javax.swing.GroupLayout(panelCodigoIni);
        panelCodigoIni.setLayout(panelCodigoIniLayout);
        panelCodigoIniLayout.setHorizontalGroup(
            panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoIniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCodigoIniLayout.setVerticalGroup(
            panelCodigoIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoIniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane6.setViewportView(jTextArea1);

        javax.swing.GroupLayout panelCodigoSolLayout = new javax.swing.GroupLayout(panelCodigoSol);
        panelCodigoSol.setLayout(panelCodigoSolLayout);
        panelCodigoSolLayout.setHorizontalGroup(
            panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoSolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        panelCodigoSolLayout.setVerticalGroup(
            panelCodigoSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoSolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        area.setText("Área");

        comboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash" }));
        comboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCodigoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descricao)
                                    .addComponent(autor)
                                    .addComponent(titulo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField2)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(area)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addComponent(panelCodigoSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelAnimacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelAnimacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(titulo)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(autor)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(area)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descricao)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(panelCodigoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCodigoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    public void okInicializacaoActionPerformed(java.awt.event.ActionEvent evt) {
        StringTokenizer st = new StringTokenizer(inicializacaoTextA.getText(), "\n");
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println(c);
//            iter.interprete(c);
        }
    }

    public void okSolucaoActionPerformed(java.awt.event.ActionEvent evt) {
        StringTokenizer st = new StringTokenizer(solucaoText.getText(), "\n");
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println(c);
           // iter.interprete(c);
        }
    }
  
    
    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        //while (validado != true) {
        try {
            validarCodInicializacao();
            validarCodSolucao();
            
            Metadado mt = new Metadado();
            mt.setArea(getAreaStr());
            mt.setTitulo(getTituloStr());
            mt.setAutor(getAutorStr());
            
            IGEDletSubjetiva tarefa = new IGEDletSubjetiva();
            //tarefa.setMetadado(mt);
            //tarefa.setCodInicializacao(inicializacaoStr);
            //tarefa.setCodSolucao(solucaoStr);
            
            GerenciadorAtividade gt = GerenciadorAtividade.getInstance();
            gt.cadastrar(tarefa);
            
            PortifolioXml.lerXml();
            //IGEDletXml.lerXml(tarefa.getMetadado());
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
        
        this.setVisible(false);
    
    }
    
    
    private void comboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreaActionPerformed
    }//GEN-LAST:event_comboAreaActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public void apagarCampos() {
        comboArea.setSelectedIndex(0);
        fieldAutor.setText("");
        textDescricao.setText("");
        textTitulo.setText("");
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

   protected static String getAutorStr() {
        return autorStr;
    }

    protected static String getDescricaoStr() {
        return descricaoStr;
    }

    protected static String getAreaStr() {
        return areaStr;
    }
    
    public void showTela(){
    
         UIManager.put("nimbusBase", new Color(140, 42, 42));
        UIManager.put("nimbusBlueGrey", new Color(190, 167, 167));
        UIManager.put("control", new Color(223, 215, 214));
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TelaCadastroDeTarefa cadastrador = new TelaCadastroDeTarefa();
                cadastrador.setVisible(true);
            }
        });
    
    }      

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel area;
    private javax.swing.JLabel autor;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox comboArea;
    private javax.swing.JLabel descricao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panelAnimacao;
    private javax.swing.JPanel panelCodigoIni;
    private javax.swing.JPanel panelCodigoSol;
    private javax.swing.JTextArea textDescricao;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
     

    private javax.swing.JTextField fieldAutor;
    private javax.swing.JTextField fieldId;
    private javax.swing.JLabel id;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;

    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton okInformacao;
    private javax.swing.JButton okInicializacao;
    private javax.swing.JButton okSolucao;

    private javax.swing.JPanel panelSolucao;
    private javax.swing.JTextArea textTitulo;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTextArea inicializacaoTextA;
    private static javax.swing.JTextArea solucaoText;
    private javax.swing.JScrollPane jScrollPane5;
    
    
}
