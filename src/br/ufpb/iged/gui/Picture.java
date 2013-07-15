package br.ufpb.iged.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Picture extends JPanel {

    private Image img;
    private BufferedImage buffer;

    Picture(String pathImagem) {
        
        setDoubleBuffered(true);
        img = Toolkit.getDefaultToolkit().getImage(pathImagem);
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(img, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            System.out.println("Erro ao abrir a imagem [" + pathImagem + "] !");
        }
        setSize(img.getWidth(this), img.getHeight(this));
        buffer = new BufferedImage(img.getWidth(this), img.getHeight(this), BufferedImage.TYPE_INT_RGB);
        Graphics gb = buffer.createGraphics();
        gb.drawImage(img, 0, 0, this);
        
    }

    public void paintComponent(Graphics g) {
        g.drawImage(buffer, 0, 0, this);
    }

    int retLargura() {
        return img.getWidth(this);
    }

    int retAltura() {
        return img.getHeight(this);
    }
    
    public void setBounds(){
        
        
    
    }
}