package br.ufpb.iged.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufpb.iged.gui.event.ClosedTelaIGEDletEvent;
import br.ufpb.iged.gui.event.TelaIGEDletEvent;



public class ApresSwing extends JFrame {
	
	
	JFrame frame;
	JButton buttonPlay;
	JButton buttonNext;
	JButton buttonPrevius;
	
	public ApresSwing(){
		frame = new JFrame();
		buttonPlay = new JButton();
		buttonNext = new JButton();
		buttonPrevius = new JButton();
	}
	
	public void initSwing(){
		
		initComponente();
		initEvent();
		
	}
	
	public void initComponente(){
		

		frame.setTitle("IGED");
		frame.setLayout(null);		
  				
		buttonPrevius.setLocation(580,670);
  		buttonPrevius.setSize(100, 50);
  		buttonPrevius.setText("PREVIUS");
  		
  		buttonNext.setLocation(720, 670);
  		buttonNext.setSize(100, 50);
  		buttonNext.setText("NEXT");
  		
		//frame.add(buttonPlay);
		frame.add(buttonPrevius);
		frame.add(buttonNext);
		
		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
  		gd.setFullScreenWindow(frame);
  		frame.setVisible(true);
		
		
	}
	
	public void initEvent(){
		
		
		this.buttonNext.addActionListener( new OuvinteNext());
		this.buttonPrevius.addActionListener( new OuvintePrevius());
		
		
	}
	
	 class OuvinteNext implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
				System.out.print("NEXT");
		}
		 		 
	 }
	

	 class OuvintePrevius implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
				System.out.print("PREVIUS");	
		} 	
		
	class WindowEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent evt) {
				System.out.println("Window Closed!");
            
        }
		
	}
	
	}
}
