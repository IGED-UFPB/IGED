/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaInicial.java
 *
 * Created on 13/09/2011, 15:35:58
 */
package br.ufpb.iged.gui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author Dorgi
 */
public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null);
    }
    //TutorialFrameGilberto aula;
    TutorialFrame aula;
    TelaExercicio exercicio;
    TelaCadastradorDeTutorial cadastrador;
    TelaCadastroDeTarefa t;

    private void initComponents() {

        buttonCadastrarExercicio = new javax.swing.JButton();
        buttonResponderExercicio = new javax.swing.JButton();
        buttonAbrirArquivo = new javax.swing.JButton();
        buttonVisualizarAula = new javax.swing.JButton();
        buttonCadastrar = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        buttonSobre = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IGED - Interpretador Gráfico de Estruturas de Dados");
        setBackground(new java.awt.Color(204, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Times New Roman", 1, 12));
        setName("Principal"); // NOI18N
        setResizable(false);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Times New Roman", 1, 36));
        label1.setText("Bem-Vindo ao IGED!");

        //label2.setAlignment(java.awt.Label.CENTER);
        label2.setFont(new java.awt.Font("Times New Roman", 1, 24));
        label2.setText("O que você quer fazer?");

        buttonCadastrarExercicio.setIcon(new javax.swing.ImageIcon("./imagens/37.png"));
        buttonCadastrarExercicio.setText("Cadastrar Exercício");
        buttonCadastrarExercicio.setToolTipText("Cadastrar Exercício");
        buttonCadastrarExercicio.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarExercicioActionPerformed(evt);
            }
        });

        buttonResponderExercicio.setIcon(new javax.swing.ImageIcon("./imagens/2.png")); // NOI18N
        buttonResponderExercicio.setText("Responder Exercício");
        buttonResponderExercicio.setToolTipText("Responder Exercício");
        buttonResponderExercicio.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResponderExercicioActionPerformed(evt);
            }
        });

        buttonAbrirArquivo.setIcon(new javax.swing.ImageIcon("./imagens/119.png")); // NOI18N
        buttonAbrirArquivo.setText("Abrir Arquivo");
        buttonAbrirArquivo.setToolTipText("Abrir Arquivo");
        buttonAbrirArquivo.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbrirArquivoActionPerformed(evt);
            }
        });

        buttonVisualizarAula.setIcon(new javax.swing.ImageIcon("./imagens/10.png")); // NOI18N
        buttonVisualizarAula.setText("Visualizar Aula");
        buttonVisualizarAula.setToolTipText("Visualizar Aula");
        buttonVisualizarAula.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVisualizarAulaActionPerformed(evt);
            }
        });

        buttonCadastrar.setIcon(new javax.swing.ImageIcon("./imagens/49.png")); // NOI18N
        buttonCadastrar.setText("Cadastrar Tutorial");
        buttonCadastrar.setToolTipText("Cadastrar Apresentação [Professor]");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        buttonSobre.setText("Sobre");
        buttonSobre.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSobreActionPerformed(evt);
            }
        });



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(buttonAbrirArquivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addComponent(buttonCadastrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(buttonCadastrarExercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(48, 48, 48).addComponent(buttonSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(58, 58, 58)).addGroup(layout.createSequentialGroup().addComponent(buttonVisualizarAula, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(buttonResponderExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()))).addGroup(layout.createSequentialGroup().addGap(301, 301, 301).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(label1)).addContainerGap(52, Short.MAX_VALUE)));

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{buttonSair, buttonSobre});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{buttonResponderExercicio, buttonAbrirArquivo});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{buttonVisualizarAula, buttonCadastrar});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addComponent(label1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(label2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(buttonAbrirArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(buttonResponderExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(buttonVisualizarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(buttonCadastrarExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(buttonSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(19, Short.MAX_VALUE)));

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{buttonSair, buttonSobre});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{buttonVisualizarAula, buttonResponderExercicio, buttonAbrirArquivo, buttonCadastrar});

        pack();
    }

    private void sair() {
        System.exit(0);
    }

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {
        sair();
    }

    private void buttonSobreActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Interpretador de Comandos e Avaliador Gráfico para o Ensino de Estrutura de Dados!\n Versão 1.0");
    }

    private void buttonAbrirArquivoActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser jfc = new JFileChooser();
        File swingFile = new File("C:\\Users\\Public\\Documents\\");
        if (swingFile.exists()) {
            jfc.setCurrentDirectory(swingFile);
            jfc.setSelectedFile(swingFile);
        }

        //Permite selecionar vários arquivos
        jfc.setMultiSelectionEnabled(true);
        File[] file = jfc.getSelectedFiles();

        //Cria o filtro
        jfc.setFileFilter(new javax.swing.filechooser.FileFilter() {

            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".iged") || f.isDirectory();
            }
            //Mensagem exibida para o usuário

            public String getDescription() {
                return "Arquivos de imagem (.iged)";
            }
        });
        //FileChooser com botão para salvar
        //jfc.showSaveDialog(this);
        //Alterar o título da janela
        jfc.setDialogTitle("Abrir apresentacao");

        int retorno = jfc.showOpenDialog(null);
        //JOptionPane.showMessageDialog(this,"Funcionalidade ainda não implementada!");
    }

    private void mostrarAula() {
        if (aula == null) { //se aula for vazio, instanciamos o objeto
            aula = new TutorialFrame();
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(aula);
            aula.setVisible(true); //mostrar a tela aula
        } else {
            aula.setVisible(true);
            aula.setState(JFrame.NORMAL); //Define que a tela será mostrada com o seu tamanho Normal
        }
    }

    private void buttonVisualizarAulaActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarAula();
    }

    public void cadastrarApresentacao() {
        if (cadastrador == null) {
            cadastrador = new TelaCadastradorDeTutorial();
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(cadastrador);
            cadastrador.setVisible(true);
        } else {
            cadastrador.setVisible(true);
            cadastrador.setState(JFrame.NORMAL);
        }
    }

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

        cadastrarApresentacao();
    }

    public void mostrarExercicio() {
        if (exercicio == null) {
            //exercicio = new Exercicio();
            exercicio = new TelaExercicio();
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(exercicio);
            exercicio.setVisible(true);
        } else {
            exercicio.setVisible(true);
            exercicio.setState(JFrame.NORMAL);
        }
    }

    private void buttonResponderExercicioActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarExercicio();
    }

    public void cadastrarExercicio() {
        
    }

    private void buttonCadastrarExercicioActionPerformed(java.awt.event.ActionEvent evt) {
        cadastrarExercicio();
    }

    /*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }
    //Declaração das Variáveis
    private javax.swing.JButton buttonCadastrarExercicio;
    private javax.swing.JButton buttonAbrirArquivo;
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonResponderExercicio;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonSobre;
    private javax.swing.JButton buttonVisualizarAula;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // Fim da Declaração das Variáveis
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
