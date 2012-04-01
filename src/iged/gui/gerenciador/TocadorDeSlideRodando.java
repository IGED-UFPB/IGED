/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 31/08/2011, 20:13:39
 */
package iged.gui.gerenciador;

import iged.gui.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Dorgi
 */
public class TocadorDeSlideRodando extends javax.swing.JFrame {

    LinkedList<File> arquivos;
    String[] imagens;
    private int indexPicture;

    /** Creates new form NewJFrame */
    public TocadorDeSlideRodando() {

        initComponents();
        desenhar();
        lerDiretorio(raiz);
        arquivos = new LinkedList<File>();
        indexPicture = 1;

    }

    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 0));

        anterior.setText("<<");
        anterior.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        proximo.setText(">>");
        proximo.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setAutoscrolls(true);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 584, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 352, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(246, 246, 246).addComponent(anterior).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE).addComponent(proximo).addGap(280, 280, 280)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(136, 136, 136).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(150, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(110, 110, 110).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(167, 167, 167).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(proximo).addComponent(anterior)).addContainerGap()));

        pack();
    }
    /**
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

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
        setBackground(new java.awt.Color(0, 204, 0));

        anterior.setText("<<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        proximo.setText(">>");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setAutoscrolls(true);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(anterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(proximo)
                .addGap(280, 280, 280))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proximo)
                    .addComponent(anterior))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     **/
    private static final File raiz = new File("./Tutoriais");
    protected static ArrayList<File> itens = new ArrayList<File>();
    static String imagemArray;
    static ArrayList<String> selecionado = new ArrayList<String>();
    //static File[] selecionado;
    static File novoRaiz;
    static String nome;

    public ArrayList<File> getItens() {
        return itens;
    }

    public static ArrayList lerDiretorio(File raiz) {

        String item = raiz.getName();
        System.out.println(item);

        for (File f : raiz.listFiles()) {
            if (f.isDirectory()) {
                novoRaiz = f.getAbsoluteFile();
                System.out.println("\t" + novoRaiz);
                for (File f1 : novoRaiz.listFiles()) {
                    if (f1.isFile() && f1.getName().contains("Slide")) {
                        itens.add(f1);
                        System.out.println(f1.getName());
                    }
                }

            }

        }
        return itens;
    }

    /*
    public void reproduzir() throws IOException {
        String arqSelecionado = null;
        for (int i = 0; i < lerDiretorio(raiz).size(); i++) {
            arqSelecionado = lerDiretorio(raiz).get(i).toString();
            BufferedImage imagem = ImageIO.read(new File(arqSelecionado));
            System.out.println(arqSelecionado);
        }
    }
    Portifolio pf = PortifolioXml.lerXml();
    String id;
    
    for (MetadadoAtividade mt

    : pf.getTarefas () 
        ) {
            id = String.valueOf(mt.getId());
        dados.add(new String[]{mt.getTitulo(), mt.getArea(), id});
        System.out.println("Encontrado área:" + mt.getArea());
    }

    jTable1.setModel (modelo);

    jTable1.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);

    /*
    ImageIO.write(imagem, "JPG", new File("./Tutoriais/" + getTituloStr() + "\\" + nome));
    System.out.println(nome);
    if (nome.equals("Slide1.JPG")) {
    ImageIcon icone = new ImageIcon("./Tutoriais/" + getTituloStr() + "\\" + nome);
    Image newimg = icone.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon newIcon = new ImageIcon(newimg);
    JLabel L1 = new JLabel(newIcon);
    imagemPanel.add(L1);
    imagemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    setVisible(true);
    imagemPanel.repaint();
    }
    
    for (int i = 0; i < itens.size(); i++) {
    imagemArray = itens.get(i).getAbsolutePath();
    System.out.println(imagemArray);
    selecionado.add(imagemArray);
    //labelImg.removeAll();
    }
    }
     */
    public void desenhar() {
        setVisible(true);
        for (int i = 0; i < getItens().size(); i++) {
            ImageIcon icone = new ImageIcon(getItens().get(i).getAbsolutePath());
            Image newimg = icone.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            JLabel L1 = new JLabel(newIcon);
            jPanel1.add(L1);
            jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        }
    }

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        System.out.println("proximo...");
        //proximo();

        //pintar();

    }//GEN-LAST:event_proximoActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        System.out.println("anterior...");
        anterior();

    }//GEN-LAST:event_anteriorActionPerformed

    public void proximo() {
        lerDiretorio(raiz);
        //indexPicture++;
        //} catch (IOException ex) {
        //  Logger.getLogger(TocadorDeSlideRodando.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }

    public void anterior() {
        lerDiretorio(raiz);
        //} catch (IOException ex) {
        //  Logger.getLogger(TocadorDeSlideRodando.class.getName()).log(Level.SEVERE, null, ex);
        //}
        indexPicture--;
        //labelImg.setIcon(new ImageIcon(getClass().getResource("C:\\Tutoriais\\Slide"+indexPicture+".jpg")));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame tocador = new TocadorDeSlideRodando();
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                gd.setFullScreenWindow(tocador);
            }
        });
    }
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton proximo;
    // End of variables declaration//GEN-END:variables
     */
    private javax.swing.JFrame jFrame1;
    private javax.swing.JButton anterior;
    private javax.swing.JLabel exbicaoLabel;
    private static javax.swing.JLabel labelImg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton proximo;
}
