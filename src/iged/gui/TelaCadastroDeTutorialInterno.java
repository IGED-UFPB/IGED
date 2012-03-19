/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaCadastroDeTutorialInterno.java
 *
 * Created on 14/03/2012, 14:40:49
 */
package iged.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dorgi
 */
public class TelaCadastroDeTutorialInterno extends javax.swing.JInternalFrame {

    /** Creates new form TelaCadastroDeTutorialInterno */
    public TelaCadastroDeTutorialInterno() {
        initComponents();
    }

    
    
private void initComponents() {

        proximo = new javax.swing.JButton();
        panelTocador = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        botaoSelecionar = new javax.swing.JButton();
        imagemPanel = new javax.swing.JPanel();
        labelImagem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        tituloLabel = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoOk = new javax.swing.JButton();
        autorLabel = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        campoAutor = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        campoTitulo = new javax.swing.JTextField();
        anoLabel = new javax.swing.JLabel();
        descricaoLabel = new javax.swing.JLabel();
        campoAno = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        areaLabel = new javax.swing.JLabel();
        conteudoComboBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        labelTocador = new javax.swing.JLabel();

        setTitle("Cadastro de Apresentação");
        
        proximo.setText("Proximo");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        panelTocador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTocadorLayout = new javax.swing.GroupLayout(panelTocador);
        panelTocador.setLayout(panelTocadorLayout);
        panelTocadorLayout.setHorizontalGroup(
            panelTocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        panelTocadorLayout.setVerticalGroup(
            panelTocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botaoSelecionarActionPerformed(evt);
                } catch (CampoObrigatorioException ex) {
                    Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout imagemPanelLayout = new javax.swing.GroupLayout(imagemPanel);
        imagemPanel.setLayout(imagemPanelLayout);
        imagemPanelLayout.setHorizontalGroup(
            imagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagemPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelImagem)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        imagemPanelLayout.setVerticalGroup(
            imagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagemPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelImagem)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        tituloLabel.setText("Título:");

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoOk.setText("OK");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        autorLabel.setText("Autor:");

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        anoLabel.setText("Ano:");

        descricaoLabel.setText("Descrição:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        areaLabel.setText("Área:");

        conteudoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash"}));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(botaoSelecionar)))
                                .addGap(139, 139, 139)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(areaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tituloLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoTitulo))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(84, 84, 84)
                                            .addComponent(botaoCancelar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(botaoCadastrar))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(autorLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(anoLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoAno))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(descricaoLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(7, 7, 7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(645, Short.MAX_VALUE)
                        .addComponent(anterior)
                        .addGap(35, 35, 35)
                        .addComponent(proximo)
                        .addGap(207, 207, 207)))
                .addComponent(labelTocador, javax.swing.GroupLayout.DEFAULT_SIZE, 2, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botaoSelecionar)
                            .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(areaLabel)
                        .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLabel)
                    .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autorLabel)
                    .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoLabel)
                    .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descricaoLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoOk)
                    .addComponent(botaoCadastrar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTocador, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelTocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(anterior)
                                    .addComponent(proximo))))
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );

        pack();
    }
    
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        proximo = new javax.swing.JButton();
        panelTocador = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        botaoSelecionar = new javax.swing.JButton();
        imagemPanel = new javax.swing.JPanel();
        labelImagem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        tituloLabel = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoOk = new javax.swing.JButton();
        autorLabel = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        campoAutor = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        campoTitulo = new javax.swing.JTextField();
        anoLabel = new javax.swing.JLabel();
        descricaoLabel = new javax.swing.JLabel();
        campoAno = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        areaLabel = new javax.swing.JLabel();
        conteudoComboBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        labelTocador = new javax.swing.JLabel();

        proximo.setText("Proximo");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        panelTocador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTocadorLayout = new javax.swing.GroupLayout(panelTocador);
        panelTocador.setLayout(panelTocadorLayout);
        panelTocadorLayout.setHorizontalGroup(
            panelTocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        panelTocadorLayout.setVerticalGroup(
            panelTocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagemPanelLayout = new javax.swing.GroupLayout(imagemPanel);
        imagemPanel.setLayout(imagemPanelLayout);
        imagemPanelLayout.setHorizontalGroup(
            imagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagemPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelImagem)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        imagemPanelLayout.setVerticalGroup(
            imagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagemPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelImagem)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        tituloLabel.setText("Título:");

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoOk.setText("OK");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        autorLabel.setText("Autor:");

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        anoLabel.setText("Ano:");

        descricaoLabel.setText("Descrição:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        areaLabel.setText("Área:");

        conteudoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(botaoSelecionar)))
                                .addGap(139, 139, 139)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(areaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tituloLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoTitulo))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(84, 84, 84)
                                            .addComponent(botaoCancelar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(botaoCadastrar))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(autorLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(anoLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoAno))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(descricaoLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(7, 7, 7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(645, Short.MAX_VALUE)
                        .addComponent(anterior)
                        .addGap(35, 35, 35)
                        .addComponent(proximo)
                        .addGap(207, 207, 207)))
                .addComponent(labelTocador, javax.swing.GroupLayout.DEFAULT_SIZE, 2, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botaoSelecionar)
                            .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(areaLabel)
                        .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLabel)
                    .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autorLabel)
                    .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoLabel)
                    .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descricaoLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoOk)
                    .addComponent(botaoCadastrar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTocador, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelTocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(anterior)
                                    .addComponent(proximo))))
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
        private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed

        Object[] opcoes = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja cadastrar agora?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        do {
            if (opcao == JOptionPane.YES_OPTION) {
                apagarCampos();
            }
        } while (opcao != JOptionPane.YES_OPTION);
        System.out.println("Saindo...");

    }//GEN-LAST:event_botaoCadastrarActionPerformed
/*
    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarActionPerformed
    }//GEN-LAST:event_botaoSelecionarActionPerformed
*/
        public void selecionadorDeArquivo() throws IOException {
        JFileChooser jfc = new JFileChooser();
        File arq;
        File[] selecionados;

        File swingFile = new File("C:\\Users\\Dorgi");
        if (swingFile.exists()) {
            jfc.setCurrentDirectory(swingFile);
            jfc.setSelectedFile(swingFile);
        }

        //Permite selecionar vários arquivos
        jfc.setMultiSelectionEnabled(true);

        //Cria o filtro para aceitar apenas arquivos jpg
        jfc.setFileFilter(new javax.swing.filechooser.FileFilter() {

            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".jpg") || f.isDirectory();
            }
            //Mensagem exibida para o usuário

            public String getDescription() {
                return "Arquivos de imagem (.jpg)";
            }
        });
        //FileChooser com botão para salvar
        //jfc.showSaveDialog(this);

        //Alterar o título da janela
        jfc.setDialogTitle("Abrir apresentacao");


        //CamposXML c = new CamposXML();

        //Selecionar arquivo
        int retorno = jfc.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            //pega o caminho de cada arquivo selecionado
            selecionados = jfc.getSelectedFiles();
            for (int i = 0; i < selecionados.length; i++) {
                diretorioArqSel = selecionados[i].toString();
                BufferedImage imagem = ImageIO.read(new File(diretorioArqSel));
                System.out.println(diretorioArqSel);
                ImageIO.write(imagem, "JPG", new File("C:\\Tutoriais\\" + getTituloStr() + "\\Slide" + i + ".jpg"));
            }
            //criar capa do cadastrador
            imagemPanel.removeAll();
            String dirArquivo = jfc.getSelectedFile().getAbsolutePath();
            arq = jfc.getSelectedFile();
            img = new ImageIcon(dirArquivo);
            Image newimg = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            String nomeArquivo = jfc.getName(arq);
            System.out.println(nomeArquivo);
            imagemPanel.add(new JLabel(newIcon));
            imagemPanel.repaint();

            //adiciona o panel no container
            //panelCadastradorXML.add(this.imagemPanel, BorderLayout.CENTER);
            //jFrame1.pack();
            imagemPanel.repaint();
            this.pack();
        } else {
            System.out.println("Imagem não carregada!");
        }}
        
        ConversorXmlTutorial cXml = new ConversorXmlTutorial();
        
    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
 Object[] opcoes = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que os campos estão preenchidos corretamente?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        do {
            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    try {
                        validarCampos();
                    } catch (CampoInvalidoException ex) {
                        Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DiretorioExistenteException ex) {
                        Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        //validarArea();
                        cXml.criarDiretorio();
                    } catch (DiretorioExistenteException ex) {
                        Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cXml.converterStringXML();
                    cXml.salvarXmlTutorial();
                    botaoSelecionar.setEnabled(true);
                    botaoOk.setEnabled(false);
                } catch (CampoObrigatorioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        } while (opcao != JOptionPane.YES_OPTION);
        System.out.println("Saindo...");
    }//GEN-LAST:event_botaoOkActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
      //OPÇÃO INSERIDA APENAS PARA TESTAR A FUNCIONALIDADE, DEPOIS REMOVER!! 
        l.lerXML();
        // TODO add your handling code here:
        Object[] opcoes = {"Sim", "Não"};
        //JOptionPane.showOptionDialog (Centro na janela, mensagem, titulo, opção, tipo de mensagem, nome do ícone, texto do botão com descrição a cima, label default dos botões);
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja cancelar esta operação?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        //int opcao = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja cancelar esta operação?");

        if (opcao == JOptionPane.YES_OPTION) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }
    }//GEN-LAST:event_botaoCancelarActionPerformed

    public void apagarCampos() {
        campoTitulo.setText("");
        campoAutor.setText("");
        campoAno.setText("");
        campoDescricao.setText("");
        conteudoComboBox.setSelectedIndex(0);
        imagemPanel.removeAll();
        imagemPanel.repaint();
    }
    static String tituloStr;
    static String anoStr;
    static String autorStr;
    static String descricaoStr;
    static String areaStr;

    public void validarTitulo() throws CampoObrigatorioException, CampoInvalidoException {
        tituloStr = campoTitulo.getText();
        if (tituloStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo " + tituloLabel.getText() + " é obrigatório! Preencha-o!");
        } else {
            Pattern p = Pattern.compile("[a-zA-Z0-9áÁàÀãÃçÇéÉêÊíÍôÔúÚ,.;+=^~<>:!@#$%¨&*(){}\\s]+");
            Matcher m = p.matcher(tituloStr);
            boolean encontrou = m.matches();
            if (encontrou) {
                System.out.println("OK");
            } else {
                campoTitulo.setText("");
                throw new CampoInvalidoException("O campo " + tituloLabel.getText() + " contém caracteres inválidos");
            }
        }
    }

    public void validarAno() throws CampoObrigatorioException, CampoInvalidoException, DiretorioExistenteException {
        anoStr = campoAno.getText();
        if (anoStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo " + anoLabel.getText() + " é obrigatório! Preencha-o!");
        } else {
            Pattern p = Pattern.compile("[0-9\\s]+");
            Matcher m = p.matcher(anoStr);
            boolean encontrou = m.matches();
            if (encontrou) {
                //criarDiretorioTarefa();
                System.out.println("OK");
            } else {
                campoAno.setText("");
                throw new CampoInvalidoException("O campo " + anoLabel.getText() + " contém caracteres inválidos");
            }
        }
    }

    //Verifica se houve seleção de uma área
    public void validarArea() throws CampoObrigatorioException {
        areaStr = conteudoComboBox.getSelectedItem().toString();
        if (areaStr == conteudoComboBox.getItemAt(0)) {
            throw new CampoObrigatorioException("O Campo" + areaLabel.getText() + " é Obrigatório! Selecione uma área!");
        } else {
            if (areaStr == conteudoComboBox.getItemAt(1)) {
                System.out.println("Área: Árvore!");
            } else {
                if (areaStr == conteudoComboBox.getItemAt(2)) {
                    System.out.println("Área: Fila!");
                } else {
                    if (areaStr == conteudoComboBox.getItemAt(3)) {
                        System.out.println("Área: Lista!");
                    } else {
                        if (areaStr == conteudoComboBox.getItemAt(4)) {
                            System.out.println("Área: Ordenação!");
                        } else {
                            if (areaStr == conteudoComboBox.getItemAt(5)) {
                                System.out.println("Área: Pilha!");
                            } else {
                                if (areaStr == conteudoComboBox.getItemAt(6)) {
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
        autorStr = campoAutor.getText();
        if (autorStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo " + autorLabel.getText() + " é obrigatório! Preencha-o!");
        } else {
            Pattern p = Pattern.compile("[a-zA-Z0-9áÁàÀãÃçÇéÉêÊíÍôÔúÚ,.;+=^~<>:!@#$%¨&*(){}\\s]+");
            Matcher m = p.matcher(autorStr);
            boolean encontrou = m.matches();
            if (encontrou) {
                System.out.println("OK");
            } else {
                campoAutor.setText("");
                throw new CampoInvalidoException("O campo " + autorLabel.getText() + " contém caracteres inválidos");

            }
        }
    }

    public void validarDescricao() throws CampoObrigatorioException, CampoInvalidoException {
        descricaoStr = campoDescricao.getText();
        if (descricaoStr.isEmpty()) {
            throw new CampoObrigatorioException("O campo " + descricaoLabel.getText() + " é obrigatório! Preencha-o!");
        } else {
            Pattern p = Pattern.compile("[a-zA-Z0-9áÁàÀãÃçÇéÉêÊíÍôÔúÚ,.;+=^~<>:!@#$%¨&*(){}\\s]+");
            Matcher m = p.matcher(descricaoStr);
            boolean encontrou = m.matches();
            if (encontrou) {
                System.out.println("OK");
            } else {
                campoDescricao.setText("");
                throw new CampoInvalidoException("O campo " + descricaoLabel.getText() + " contém caracteres inválidos");

            }
        }
    }
    private boolean validado;

    public boolean validarCampos() throws CampoObrigatorioException, CampoInvalidoException, DiretorioExistenteException {
        try {
            validarTitulo();
            validarAno();
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

    protected static String getAnoStr() {
        return anoStr;
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

    public void sair() {
        System.exit(0);
    }
    LeitorXML l = new LeitorXML();
    
    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
            desenhar();
    }//GEN-LAST:event_anteriorActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        desenhar();
    }//GEN-LAST:event_proximoActionPerformed

        private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) throws iged.gui.CampoObrigatorioException {

        try {
            //posição absoluta
            selecionadorDeArquivo();
            Insets insets = getInsets();
            Dimension size = botaoSelecionar.getPreferredSize();
            botaoSelecionar.setBounds(25 + insets.left, 150 + insets.top, size.width, size.height);
            botaoCadastrar.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
         protected static LinkedList<File> itens = new LinkedList<File>();
    static String imagemArray;
    static LinkedList<String> selecionado = new LinkedList<String>();
    static File novoRaiz = new File("C:\\Tutoriais");
    
     public void desenhar() {
        String dirArquivo;
        itens = TelaTutorialFrameInterno.lerDiretorio(novoRaiz);
        for (int i = 0; i < itens.size(); i++) {
            dirArquivo = itens.get(i).toString();
            selecionado.add(dirArquivo);
        }
        ListIterator<String> iterador = selecionado.listIterator();
        while (iterador.hasNext()) {
            panelTocador.removeAll();
            img = new ImageIcon(iterador.next().toString());
            Image newimg = img.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            //GridLayout gridL = new GridLayout(1, 1);
            FlowLayout layout = new FlowLayout();
            panelTocador.setLayout(layout);
            panelTocador.add(new JLabel(newIcon));
            panelTocador.repaint();
        }
    }
        
            public static void main(String args[]) {
        
        try {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
        
        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaCadastroDeTutorialInterno().setVisible(true);
                
            }
        });
            }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anoLabel;
    private javax.swing.JButton anterior;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JLabel autorLabel;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoOk;
    private javax.swing.JButton botaoSelecionar;
    private javax.swing.JTextField campoAno;
    private javax.swing.JTextField campoAutor;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JComboBox conteudoComboBox;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JPanel imagemPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JLabel labelTocador;
    private javax.swing.JPanel panelTocador;
    private javax.swing.JButton proximo;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
 private ImageIcon img;
    private String diretorioArqSel = null;
}
