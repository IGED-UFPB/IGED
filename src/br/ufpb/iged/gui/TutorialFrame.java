/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TutorialFrame.java
 *
 * Created on 20/01/2012, 16:06:46
 */
package br.ufpb.iged.gui;

import br.ufpb.iged.gui.Tocador;
import br.ufpb.iged.gui.gerenciador.CadastroTarefa;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dorgi
 */
public class TutorialFrame extends javax.swing.JFrame {

    /** Creates new form TutorialFrame */
    public TutorialFrame() {
        initComponents();

    }
    Tocador ts = new Tocador();

    public void abrirTocador() {
        if (ts != null) { //se aula for vazio, instanciamos o objeto
            JFrame ts = new Tocador();
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(ts);
            ts.setVisible(true); //mostrar a tela aula
        } else {
            System.out.println("erro!");
            ts.setVisible(true);
            ts.setState(this.NORMAL); //Define que a tela será mostrada com o seu tamanho Normal
        }
    }

    public void criarImagemPanel() {
        System.out.println(CadastroTarefa.getContador());
        int cont = CadastroTarefa.getContador();
        while (cont != -1) {
            desenharComponente();
            exibirDados();
            cont--;
        }
    }

    /*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        imgPanel = new javax.swing.JPanel();
        descPanel = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        autor = new javax.swing.JLabel();
        conteudoAutor = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        conteudoAno = new javax.swing.JLabel();
        ano = new javax.swing.JLabel();
        conteudoDescricao = new javax.swing.JLabel();
        conteudoTitulo = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        conteudoArea = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuConteudos = new javax.swing.JMenu();
        jCheckBoxTodos = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxLista = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        imgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imgPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgPanelLayout = new javax.swing.GroupLayout(imgPanel);
        imgPanel.setLayout(imgPanelLayout);
        imgPanelLayout.setHorizontalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        imgPanelLayout.setVerticalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );

        descPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        descPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descPanelMouseClicked(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        titulo.setText("Título:");

        autor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        autor.setText("Autor:");

        descricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        descricao.setText("Descrição:");

        ano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ano.setText("Ano:");

        area.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        area.setText("Área");

        javax.swing.GroupLayout descPanelLayout = new javax.swing.GroupLayout(descPanel);
        descPanel.setLayout(descPanelLayout);
        descPanelLayout.setHorizontalGroup(
            descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(descPanelLayout.createSequentialGroup()
                        .addComponent(descricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conteudoDescricao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, descPanelLayout.createSequentialGroup()
                        .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, descPanelLayout.createSequentialGroup()
                                .addComponent(titulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conteudoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                            .addGroup(descPanelLayout.createSequentialGroup()
                                .addComponent(autor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conteudoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                .addGap(33, 33, 33)))
                        .addGap(25, 25, 25)
                        .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(area)
                            .addComponent(ano))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(conteudoAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(conteudoArea, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                .addContainerGap())
        );
        descPanelLayout.setVerticalGroup(
            descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(conteudoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(conteudoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(area)
                    .addComponent(titulo))
                .addGap(8, 8, 8)
                .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(descPanelLayout.createSequentialGroup()
                        .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(conteudoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autor))
                        .addGap(14, 14, 14)
                        .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descricao)
                            .addComponent(conteudoDescricao)))
                    .addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ano)
                        .addComponent(conteudoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenuConteudos.setText("Conteúdos");

        jCheckBoxTodos.setSelected(true);
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });
        jMenuConteudos.add(jCheckBoxTodos);

        jCheckBoxLista.setSelected(true);
        jCheckBoxLista.setText("Lista");
        jMenuConteudos.add(jCheckBoxLista);

        jMenuBar1.add(jMenuConteudos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     */
    private void imgPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgPanelMouseClicked
        abrirTocador();
    }//GEN-LAST:event_imgPanelMouseClicked

    private void descPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descPanelMouseClicked
        abrirTocador();
    }//GEN-LAST:event_descPanelMouseClicked

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        abrirTocador();
    }//GEN-LAST:event_panelMouseClicked

    private void jCheckBoxTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxTodosItemStateChanged
        exibirDados();
    }//GEN-LAST:event_jCheckBoxTodosItemStateChanged
    ImageIcon img;
    TelaCadastradorDeTutorial t;
    protected static LinkedList<File> itens = new LinkedList<File>();
    static String imagemArray;
    static LinkedList<String> selecionado = new LinkedList<String>();
    static File novoRaiz;
    static String nome;

    public static void listarTodosTutoriais() {
        File raiz = new File("C:\\Tutoriais");
        lerDiretorio(raiz);
    }

    public static LinkedList lerDiretorio(File raiz) {

        String item = raiz.getName();
        System.out.println(item);

        for (File f : raiz.listFiles()) {
            if (f.isDirectory()) {
                novoRaiz = f.getAbsoluteFile();
                System.out.println("\t" + novoRaiz);
                for (File f1 : novoRaiz.listFiles()) {
                    if ((f1.isFile()) && (f1.getName().contains("Slide0"))) {
                        itens.add(f1);
                        System.out.println(f1.getName());
                    }
                }
            }
        }
        return itens;
    }

    public void desenharMiniaturaTutorial() {
        String dirArquivo;
        listarTodosTutoriais();
        for (int i = 0; i < itens.size(); i++) {
            dirArquivo = itens.get(i).toString();
            selecionado.add(dirArquivo);
        }
        ListIterator<String> iterador = selecionado.listIterator();
        while (iterador.hasNext()) {
            imgPanel.removeAll();
            img = new ImageIcon(iterador.next().toString());
            Image newimg = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            //GridLayout gridL = new GridLayout(1, 1);
            FlowLayout layout = new FlowLayout();
            imgPanel.setLayout(layout);
            imgPanel.add(new JLabel(newIcon));
            imgPanel.repaint();
        }
    }

    private void initComponents() {
        desenharComponente();
        pack();

    }

    public ArrayList buscarArquivoPorNome(String palavra, String caminhoInicial) {
        ArrayList lista = new ArrayList();
        try {
            File arquivo = new File(caminhoInicial);
            lista = buscar(arquivo, palavra, lista);
            JOptionPane.showMessageDialog(null, "Encontrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Caminho Inválido");
        }
        return lista;
    }

    public ArrayList buscar(File arquivo, String palavra, ArrayList lista) {
        if (arquivo.isDirectory()) {
            File[] subPastas = arquivo.listFiles();
            for (int i = 0; i < subPastas.length; i++) {
                lista = buscar(subPastas[i], palavra, lista);
                if (arquivo.getName().equalsIgnoreCase(palavra)) {
                    lista.add(arquivo.getAbsolutePath());
                } else if (arquivo.getName().indexOf(palavra) > -1) {
                    lista.add(arquivo.getAbsolutePath());
                }
            }
        } else if (arquivo.getName().equalsIgnoreCase(palavra)) {
            lista.add(arquivo.getAbsolutePath());
        } else if (arquivo.getName().indexOf(palavra) > -1) {
            lista.add(arquivo.getAbsolutePath());
        }
        return lista;
    }
    LeitorXML l = new LeitorXML();

    private void desenharComponente() {
        panel = new javax.swing.JPanel();
        imgPanel = new javax.swing.JPanel();
        descPanel = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        autor = new javax.swing.JLabel();
        conteudoAutor = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        conteudoAno = new javax.swing.JLabel();
        ano = new javax.swing.JLabel();
        conteudoDescricao = new javax.swing.JLabel();
        conteudoTitulo = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        conteudoArea = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuConteudos = new javax.swing.JMenu();
        jCheckBoxTodos = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxLista = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        imgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imgPanel.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgPanelLayout = new javax.swing.GroupLayout(imgPanel);
        imgPanel.setLayout(imgPanelLayout);
        imgPanelLayout.setHorizontalGroup(
                imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));
        imgPanelLayout.setVerticalGroup(
                imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 102, Short.MAX_VALUE));

        descPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        descPanel.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descPanelMouseClicked(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        titulo.setText("Título:");

        autor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        autor.setText("Autor:");

        descricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        descricao.setText("Descrição:");

        ano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ano.setText("Ano:");

        area.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        area.setText("Área");

        javax.swing.GroupLayout descPanelLayout = new javax.swing.GroupLayout(descPanel);
        descPanel.setLayout(descPanelLayout);
        descPanelLayout.setHorizontalGroup(
                descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(descPanelLayout.createSequentialGroup().addContainerGap().addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(descPanelLayout.createSequentialGroup().addComponent(descricao).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(conteudoDescricao)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, descPanelLayout.createSequentialGroup().addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, descPanelLayout.createSequentialGroup().addComponent(titulo).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(conteudoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)).addGroup(descPanelLayout.createSequentialGroup().addComponent(autor).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(conteudoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE).addGap(33, 33, 33))).addGap(25, 25, 25).addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(area).addComponent(ano)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(conteudoAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(conteudoArea, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))).addContainerGap()));
        descPanelLayout.setVerticalGroup(
                descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(descPanelLayout.createSequentialGroup().addContainerGap().addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(conteudoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(conteudoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(titulo))).addComponent(area)).addGap(8, 8, 8).addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(descPanelLayout.createSequentialGroup().addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(conteudoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(autor)).addGap(14, 14, 14).addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(descricao).addComponent(conteudoDescricao))).addGroup(descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(ano).addComponent(conteudoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(61, Short.MAX_VALUE)));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelLayout.createSequentialGroup().addContainerGap().addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(descPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(descPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(93, 93, 93)));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenuConteudos.setText("Conteúdos");

        jCheckBoxTodos.setSelected(true);
        jCheckBoxTodos.setText("Todos");
        jCheckBoxTodos.addItemListener(new java.awt.event.ItemListener() {

            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxTodosItemStateChanged(evt);
            }
        });
        jMenuConteudos.add(jCheckBoxTodos);

        jCheckBoxLista.setSelected(true);
        jCheckBoxLista.setText("Lista");
        jMenuConteudos.add(jCheckBoxLista);

        jMenuBar1.add(jMenuConteudos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))));

        pack();
    }

    public void exibirDados() {
        l.lerXML();
        conteudoTitulo.setText(l.infoTitulo());
        conteudoAutor.setText(l.infoAutor());
        conteudoAno.setText(l.infoAno());
        conteudoDescricao.setText(l.infoDescricao());
        conteudoArea.setText(l.infoArea());
        desenharMiniaturaTutorial();
    }

    public static void main(String args[]) {
        try {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(TutorialFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TutorialFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TutorialFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TutorialFrame.class.getName()).log(Level.SEVERE, null, ex);

        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TutorialFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ano;
    private javax.swing.JLabel area;
    private javax.swing.JLabel autor;
    private javax.swing.JLabel conteudoAno;
    private javax.swing.JLabel conteudoArea;
    private javax.swing.JLabel conteudoAutor;
    private javax.swing.JLabel conteudoDescricao;
    private javax.swing.JLabel conteudoTitulo;
    private javax.swing.JPanel descPanel;
    private javax.swing.JLabel descricao;
    private javax.swing.JPanel imgPanel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxLista;
    private javax.swing.JCheckBoxMenuItem jCheckBoxTodos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConteudos;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
