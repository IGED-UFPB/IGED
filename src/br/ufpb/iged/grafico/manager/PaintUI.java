package br.ufpb.iged.grafico.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class PaintUI extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 604149682055649395L;
	javax.swing.JScrollPane scroll;
	javax.swing.JScrollPane scroll2;
	javax.swing.JTextArea text;
	
	
	public JButton colorB = new JButton("", new ImageIcon("icons/exe.png"));
	//public JButton moveB = new JButton("Mover", new ImageIcon("icons/move.png"));
	//public JButton zoomB = new JButton("Zoom", new ImageIcon("icons/zoom.png"));

	public PaintUI(String nome, final AcaoUsuario paint) {
		super(nome);
		Container framePane = this.getContentPane();
		framePane.setLayout(new BorderLayout());
		
                //framePane.setLayout(null);
		//JPanel exec = new JPanel();
                //exec.setBackground(Color.LIGHT_GRAY);
		//exec.setLayout(null);
                
                //JPanel botao = new JPanel();
                //botao.setLayout(null);
                //botoes.setLayout(new GridLayout(3,1));

                //colorB.setBounds(10, 10, 50, 30);
		//botao.add(colorB);
		//botoes.add(moveB);
		//botoes.add(zoomB);

                //JTextArea tp = new JTextArea();
                //exec.add(tp);
                //exec.add(botao);
		Container c = paint.getQuadro();
		c.setBackground(Color.white);
                c.setLayout(null);

                colorB.setBounds(690, 490, 60, 60);
                //colorB.setLocation(650, 450);
                
                //c.add(colorB);
        
                text = new javax.swing.JTextArea();
        		scroll = new javax.swing.JScrollPane();
        		scroll2 = new javax.swing.JScrollPane();
   
        		text.setColumns(10);
        		text.setRows(5);
        		scroll2.setViewportView(text);        
        		scroll.setViewportView(c);
                
        		framePane.add(scroll,BorderLayout.CENTER);
        		
        		framePane.add(scroll2,BorderLayout.SOUTH);
		this.setSize(1024,768);
		this.addWindowListener(new ExitListener());
		this.setVisible(true);
                
        c.add(colorB);// Tirar essa linha, � somente para teste        
		colorB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paint.color();
			}
		});

		/*moveB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paint.move();
			}
		});

		zoomB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paint.zoom();
			}
		});*/
	}
	
	public StringTokenizer lastLine(){
		
		StringTokenizer st = new StringTokenizer(text.getText());
		StringTokenizer last = null;
		while(st.hasMoreTokens()){
			last = new StringTokenizer(st.nextToken("\n"));
		}
		return last;
	}
	
	public String Lines(){
		return  text.getText();
	}
	
	public javax.swing.JTextArea getTextArea(){
		return text;
	}
	
	
	

}