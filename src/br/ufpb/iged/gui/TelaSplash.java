package br.ufpb.iged.gui;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaSplash extends javax.swing.JWindow {

    private int duration;

    public TelaSplash(int d) {
        duration = d;
    }
    
    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        // Configura a posição e o tamanho da janela
        int width = 450;
        int height = 115;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Constrói o splash screen
        JLabel label = new JLabel(new ImageIcon("99.png"));
        JLabel copyrt = new JLabel("Copyright 2012, IGED", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 11));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(156, 20, 20, 255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 8));
        // Torna visível
        setVisible(true);

        // Espera ate que os recursos estejam carregados
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();
    }

    public static void main(String[] args) {
        // Mostra uma imagem com o título da aplicação 
        TelaSplash splash = new TelaSplash(5000);
        splash.showSplashAndExit();
        TelaMain tela = new TelaMain();
        tela.showTela();
    }
}
