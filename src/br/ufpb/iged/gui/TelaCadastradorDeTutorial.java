/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaCadastradorDeTutorial.java
 *
 * Created on 07/03/2012, 12:06:10
 */
package br.ufpb.iged.gui;

import br.ufpb.iged.IGEDProperties;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
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
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dorgi
 */
public class TelaCadastradorDeTutorial extends javax.swing.JFrame {

    /** Creates new form TelaCadastradorDeTutorial */
    public TelaCadastradorDeTutorial() {
        initComponents();
    }

       private void initComponents() {

        labelTocador = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        panelCadastradorXML = new javax.swing.JPanel();
        imagemPanel = new javax.swing.JPanel();
        labelImagem = new javax.swing.JLabel(img);
        jSeparator1 = new javax.swing.JSeparator();
        tituloLabel = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        autorLabel = new javax.swing.JLabel();
        campoAutor = new javax.swing.JTextField();
        anoLabel = new javax.swing.JLabel();
        campoAno = new javax.swing.JTextField();
        descricaoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        botaoSelecionar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoOk = new javax.swing.JButton();
        botaoCadastrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        areaLabel = new javax.swing.JLabel();
        conteudoComboBox = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JSeparator();
        panelTocador = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();

        setResizable(false);
        setTitle("Cadastrador de Tutorial");
        
        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tituloLabel.setText("Título:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        autorLabel.setText("Autor:");

        anoLabel.setText("Ano:");

        descricaoLabel.setText("Descrição:");

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        botaoSelecionar.setEnabled(false);
        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botaoSelecionarActionPerformed(evt);
                } catch (CampoObrigatorioException ex) {
                    Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoOk.setText("OK");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botaoOkActionPerformed(evt);
                } catch (CampoObrigatorioException ex) {
                    Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DiretorioExistenteException ex) {
                    Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CampoInvalidoException ex) {
                    Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        botaoCadastrar.setEnabled(false);
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        areaLabel.setText("Área:");

        conteudoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash"}));

        javax.swing.GroupLayout panelCadastradorXMLLayout = new javax.swing.GroupLayout(panelCadastradorXML);
        panelCadastradorXML.setLayout(panelCadastradorXMLLayout);
        panelCadastradorXMLLayout.setHorizontalGroup(
            panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoSelecionar)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(tituloLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(descricaoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(autorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(botaoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCadastrar)
                        .addContainerGap())))
            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        panelCadastradorXMLLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCadastrar, botaoCancelar, botaoOk});

        panelCadastradorXMLLayout.setVerticalGroup(
            panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(areaLabel)
                        .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoSelecionar))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tituloLabel)
                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autorLabel)
                            .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anoLabel)
                            .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descricaoLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCancelar)
                            .addComponent(botaoOk)
                            .addComponent(botaoCadastrar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelTocador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTocadorLayout = new javax.swing.GroupLayout(panelTocador);
        panelTocador.setLayout(panelTocadorLayout);
        panelTocadorLayout.setHorizontalGroup(
            panelTocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTocador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        panelTocadorLayout.setVerticalGroup(
            panelTocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTocador, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );


        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }

        });

        proximo.setText("Próximo");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(anterior)
                        .addGap(35, 35, 35)
                        .addComponent(proximo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(panelTocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCadastradorXML, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCadastradorXML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTocador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anterior)
                    .addComponent(proximo))
                .addContainerGap())
        );

        pack();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    /*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        panelCadastradorXML = new javax.swing.JPanel();
        imagemPanel = new javax.swing.JPanel();
        labelImagem = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tituloLabel = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        autorLabel = new javax.swing.JLabel();
        campoAutor = new javax.swing.JTextField();
        anoLabel = new javax.swing.JLabel();
        campoAno = new javax.swing.JTextField();
        descricaoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        botaoSelecionar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoOk = new javax.swing.JButton();
        botaoCadastrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        areaLabel = new javax.swing.JLabel();
        conteudoComboBox = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JSeparator();
        panelTocador = new javax.swing.JPanel();
        labelTocador = new javax.swing.JLabel();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tituloLabel.setText("Título:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        autorLabel.setText("Autor:");

        anoLabel.setText("Ano:");

        descricaoLabel.setText("Descrição:");

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarActionPerformed(evt);
            }
        });

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

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        areaLabel.setText("Área:");

        conteudoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelCadastradorXMLLayout = new javax.swing.GroupLayout(panelCadastradorXML);
        panelCadastradorXML.setLayout(panelCadastradorXMLLayout);
        panelCadastradorXMLLayout.setHorizontalGroup(
            panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoSelecionar)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(tituloLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTitulo))
                            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(descricaoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(autorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(botaoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCadastrar)
                        .addContainerGap())))
            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelCadastradorXMLLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoCadastrar, botaoCancelar, botaoOk});

        panelCadastradorXMLLayout.setVerticalGroup(
            panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(areaLabel)
                        .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoSelecionar))
                    .addComponent(jSeparator1)
                    .addGroup(panelCadastradorXMLLayout.createSequentialGroup()
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tituloLabel)
                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autorLabel)
                            .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anoLabel)
                            .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descricaoLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCancelar)
                            .addComponent(botaoOk)
                            .addComponent(botaoCadastrar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelTocador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTocadorLayout = new javax.swing.GroupLayout(panelTocador);
        panelTocador.setLayout(panelTocadorLayout);
        panelTocadorLayout.setHorizontalGroup(
            panelTocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTocador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        panelTocadorLayout.setVerticalGroup(
            panelTocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTocador, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        proximo.setText("Proximo");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(anterior)
                        .addGap(35, 35, 35)
                        .addComponent(proximo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(panelTocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCadastradorXML, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCadastradorXML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTocador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anterior)
                    .addComponent(proximo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_botaoOkActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_anteriorActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_proximoActionPerformed

    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSelecionarActionPerformed
*/
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

    private void anteriorActionPerformed(ActionEvent evt) {
                desenhar();
            }
    
     private void proximoActionPerformed(ActionEvent evt) {
                desenhar();
            }
    
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        //OPÇÃO INSERIDA APENAS PARA TESTAR A FUNCIONALIDADE, DEPOIS REMOVER!! 
        l.lerXML();
        // TODO add your handling code here:
        Object[] opcoes = {"Sim", "Não"};
        //JOptionPane.showOptionDialog (Centro na janela, mensagem, titulo, opção, tipo de mensagem, nome do ícone, texto do botão com descrição a cima, label default dos botões);
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja cancelar esta operação?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        //int opcao = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja cancelar esta operação?");

        if (opcao == JOptionPane.YES_OPTION) {
            jFrame1.setDefaultCloseOperation(EXIT_ON_CLOSE);

        }

    }

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
                ImageIO.write(imagem, "JPG", new File(IGEDProperties.getInstance().getPropety("nclPath") + getTituloStr() + "slide" + i + ".jpg"));
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
            panelCadastradorXML.add(this.imagemPanel, BorderLayout.CENTER);
            jFrame1.pack();
            imagemPanel.repaint();
            this.pack();
        } else {
            System.out.println("Imagem não carregada!");
        }
    }
    ConversorXmlTutorial cXml = new ConversorXmlTutorial();

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) throws br.ufpb.iged.gui.CampoObrigatorioException, DiretorioExistenteException, CampoInvalidoException {
        Object[] opcoes = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que os campos estão preenchidos corretamente?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        do {
            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    validarCampos();
                    //validarArea();
                    cXml.criarDiretorio();
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
    }

    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) throws br.ufpb.iged.gui.CampoObrigatorioException {

        try {
            //posição absoluta
            selecionadorDeArquivo();
            Insets insets = panelCadastradorXML.getInsets();
            Dimension size = botaoSelecionar.getPreferredSize();
            botaoSelecionar.setBounds(25 + insets.left, 150 + insets.top, size.width, size.height);
            botaoCadastrar.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

        Object[] opcoes = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja cadastrar agora?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        do {
            if (opcao == JOptionPane.YES_OPTION) {
                apagarCampos();
            }
        } while (opcao != JOptionPane.YES_OPTION);
        System.out.println("Saindo...");
    }
    
    protected static LinkedList<File> itens = new LinkedList<File>();
    static String imagemArray;
    static LinkedList<String> selecionado = new LinkedList<String>();
    static File novoRaiz = new File(IGEDProperties.getInstance().getPropety("nclPath"));
    
     public void desenhar() {
        String dirArquivo;
        itens = TutorialFrame.lerDiretorio(novoRaiz);
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
        
        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaCadastradorDeTutorial().setVisible(true);
                
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
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JLabel labelTocador;
    private javax.swing.JPanel panelCadastradorXML;
    private javax.swing.JPanel panelTocador;
    private javax.swing.JButton proximo;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
    private ImageIcon img;
    private String diretorioArqSel = null;
}
