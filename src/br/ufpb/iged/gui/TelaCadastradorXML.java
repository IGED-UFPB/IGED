/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastradorXML.java
 *
 * Created on 15/08/2011, 23:53:55
 */
package br.ufpb.iged.gui;


import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Dorgi
 */
public class TelaCadastradorXML extends javax.swing.JFrame {
    private Component cadastradorPanel;
    //private List<File> arqSelecionados;

    /** Creates new form CadastradorXML */
    public TelaCadastradorXML() {

        initComponents();        
      //  arqSelecionados = new LinkedList<File>();


    }

    private void initComponents() {

        cadastradorPanel = new javax.swing.JPanel();
        //Container container = this.getContentPane();  //modificado
        labelImagem = new javax.swing.JLabel(img);
        panelCadastradorXML = new javax.swing.JPanel();
        frameCadastradorXML = new javax.swing.JFrame();
        imagemPanel = new javax.swing.JPanel();
        conteudoComboBox = new javax.swing.JComboBox();
        tituloLabel = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        autorLabel = new javax.swing.JLabel();
        campoAutor = new javax.swing.JTextField();
        anoLabel = new javax.swing.JLabel();
        campoAno = new javax.swing.JTextField();
        descricaoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        botaoSelecionar = new javax.swing.JButton();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        areaLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        img = new ImageIcon();
        diretorioArqSel= new String();
        botaoOk = new javax.swing.JButton();
        

        conteudoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash"}));

        setTitle("Criador de XML");
        //setMinimumSize(new java.awt.Dimension(506, 261));
        //setMaximumSize(new java.awt.Dimension(507, 262));
        setName("frameCadastradorXML"); // NOI18N
        panelCadastradorXML.setSize(507, 262);
        //frameCadastradorXML.setSize(507, 262);
        setResizable(false);

        imagemPanel.setPreferredSize(new Dimension(100, 100));
        //imagemPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //imagemPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        areaLabel.setText("Área");

        tituloLabel.setText("Titulo");
        campoTitulo.setToolTipText("Digite o título da Apresentação");
        
        autorLabel.setText("Autor");
        campoAutor.setToolTipText("Digite o nome do autor da apresentação");

        anoLabel.setText("Ano");
        anoLabel.setToolTipText("Digite o ano de criação da apresentação");

        campoAno.setToolTipText("Digite o ano que a apresentação foi criada");

        descricaoLabel.setText("Descrição");

        campoDescricao.setLineWrap(true);
        jScrollPane1 = new JScrollPane(campoDescricao);

        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botaoSelecionarActionPerformed(evt);
                } catch (br.ufpb.iged.gui.CampoObrigatorioException ex) {
                    Logger.getLogger(TelaCadastradorXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setToolTipText("Cadastrar a apresentação");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }

            
        });

        botaoOk.setText("OK");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    try {
                        try {
                            botaoOkActionPerformed(evt);
                        } catch (CampoInvalidoException ex) {
                            Logger.getLogger(TelaCadastradorXML.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (DiretorioExistenteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } catch (br.ufpb.iged.gui.CampoObrigatorioException ex) {
                    Logger.getLogger(TelaCadastradorXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });



        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        conteudoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Árvore", "Fila", "Lista", "Ordenação", "Pilha", "Tabela Hash"}));

         javax.swing.GroupLayout frameCadastradorXMLLayout = new javax.swing.GroupLayout(panelCadastradorXML);
        panelCadastradorXML.setLayout(frameCadastradorXMLLayout);
        frameCadastradorXMLLayout.setHorizontalGroup(
            frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(botaoCancelar)
                        .addGap(51, 51, 51)
                        .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameCadastradorXMLLayout.createSequentialGroup()
                        .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(botaoSelecionar)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(tituloLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                            .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(autorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                                .addComponent(descricaoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        frameCadastradorXMLLayout.setVerticalGroup(
            frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                        .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(botaoSelecionar))
                    .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                        .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frameCadastradorXMLLayout.createSequentialGroup()
                                .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(areaLabel)
                                        .addComponent(conteudoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tituloLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(autorLabel)
                                    .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(anoLabel))
                                    .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(frameCadastradorXMLLayout.createSequentialGroup()
                                        .addComponent(descricaoLabel)
                                        .addGap(138, 138, 138))
                                    .addComponent(jScrollPane1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(frameCadastradorXMLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoOk)
                    .addComponent(botaoCadastrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastradorXML, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCadastradorXML, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    public void apagarCampos(){
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
        } else{
            Pattern p = Pattern.compile("[0-9\\s]+");
            Matcher m = p.matcher(anoStr);
            boolean encontrou = m.matches();
            if (encontrou){
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
        } else{
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
    
     protected static String getTituloStr(){
        return tituloStr;
    }
    
    protected static String getAnoStr(){
        return anoStr;
    }
    
    protected static String getAutorStr(){
        return autorStr;
    }
     
    protected static String getDescricaoStr(){
        return descricaoStr;
    }
      
    protected static String getAreaStr(){
          return areaStr;
      }
    
    public void sair() {
        System.exit(0);
    }

    LeitorXML l = new LeitorXML();
    
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //OPÇÃO INSERIDA APENAS PARA TESTAR A FUNCIONALIDADE, DEPOIS REMOVER!! 
        l.lerXML();
        // TODO add your handling code here:
        Object[] opcoes = {"Sim", "Não"};
        //JOptionPane.showOptionDialog (Centro na janela, mensagem, titulo, opção, tipo de mensagem, nome do ícone, texto do botão com descrição a cima, label default dos botões);
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja cancelar esta operação?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        //int opcao = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja cancelar esta operação?");

        if (opcao == JOptionPane.YES_OPTION) {
            frameCadastradorXML.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
        }

    }                                             

    public void selecionadorDeArquivo() throws IOException {
        JFileChooser jfc = new JFileChooser();
        File arq;
        File[] selecionados;
        
        File swingFile = new File("C:\\Users\\Dorgi");
 	if(swingFile.exists()) {
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
            for (int i=0; i < selecionados.length; i++){
                diretorioArqSel = selecionados[i].toString();
                BufferedImage imagem = ImageIO.read(new File(diretorioArqSel));
                System.out.println(diretorioArqSel);
                ImageIO.write(imagem, "JPG", new File("C:\\Tutoriais\\"+getTituloStr()+"\\Slide"+i+".jpg"));
            }
            //criar capa do cadastrador
            imagemPanel.removeAll();
            String dirArquivo = jfc.getSelectedFile().getAbsolutePath();
            arq = jfc.getSelectedFile(); 
            img = new ImageIcon(dirArquivo);
            Image newimg = img.getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            String nomeArquivo = jfc.getName(arq);
            System.out.println(nomeArquivo);
            imagemPanel.add(new JLabel(newIcon));
            imagemPanel.repaint();

            //adiciona o panel no container
            panelCadastradorXML.add(this.imagemPanel, BorderLayout.CENTER);
            frameCadastradorXML.pack();
            imagemPanel.repaint();
            this.pack();
    }
    
        else{
            System.out.println("Imagem não carregada!");
        }
       }
        
   ConversorXmlTutorial cXml = new ConversorXmlTutorial();
    
    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) throws br.ufpb.iged.gui.CampoObrigatorioException, DiretorioExistenteException, CampoInvalidoException {
        Object[] opcoes = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que os campos estão preenchidos corretamente?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        do{
        if (opcao == JOptionPane.YES_OPTION) {
            try {
                validarCampos();
                //validarArea();
                cXml.criarDiretorio();
                cXml.converterStringXML();
                //cXml.salvar();
            } catch (CampoObrigatorioException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }}while (opcao !=JOptionPane.YES_OPTION);
            System.out.println("Saindo...");
    }  
                
    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) throws br.ufpb.iged.gui.CampoObrigatorioException {                                                
        
        try {
            //posição absoluta
            selecionadorDeArquivo();
            Insets insets = panelCadastradorXML.getInsets();
            Dimension size = botaoSelecionar.getPreferredSize();
            botaoSelecionar.setBounds(25 + insets.left, 150 + insets.top,size.width, size.height);
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastradorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                               


    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                               

        Object[] opcoes = {"Sim", "Não"};
        int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja cadastrar agora?", "Saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        do{
        if (opcao == JOptionPane.YES_OPTION) {
            apagarCampos();
        }}while (opcao !=JOptionPane.YES_OPTION);
            System.out.println("Saindo...");
    }                                              

    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaCadastradorXML().setVisible(true);
                
            }
        });
    }
    
    private javax.swing.JLabel anoLabel;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JLabel autorLabel;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSelecionar;
    private javax.swing.JTextField campoAno;
    private javax.swing.JTextField campoAutor;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JComboBox conteudoComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JPanel panelCadastradorXML;
    private javax.swing.JFrame frameCadastradorXML;
    private javax.swing.JPanel imagemPanel;
    private javax.swing.JSeparator jSeparator3;
    //Container container = this.getContentPane();  //modificado
    private ImageIcon img;
    private String diretorioArqSel=null;
    private javax.swing.JButton botaoOk;
    
            
    //private javax.swing.JPanel cadastradorPanel;
    
}

