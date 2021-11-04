package CaseStudy_Observer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class HexaObserver extends JFrame implements Observer, ActionListener {
	
	protected Compteur ctp ;
	private JLabel label = new JLabel("State Hexa Value : Undefined");
	private JPanel labelPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel emptyPanel = new JPanel();
	private JButton subscribe = new JButton("Subscribe-Me");
	private JButton unsubscribe = new JButton("Unsubscribe-Me");
	
	   public HexaObserver(Compteur ctp){
		   super("Welcome to the Hexa Observer!");
		   this.ctp = ctp;
		   this.setLayout(new FlowLayout());
		   labelPanel.setLayout(new FlowLayout());
		   buttonPanel.setLayout(new FlowLayout());
		   labelPanel.add(label);
		   buttonPanel.add(subscribe);
		   buttonPanel.add(unsubscribe);
		   emptyPanel.setPreferredSize(new Dimension(300,150));
		   subscribe.addActionListener(this);
		   unsubscribe.addActionListener(this);
		   this.add(labelPanel);
		   this.add(emptyPanel);
		   this.add(buttonPanel);
		   this.subscribe.setEnabled(true);
		   this.unsubscribe.setEnabled(false);
		   this.setSize(300, 300);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setVisible(true); 
	   }
	   
	   
	   public JLabel getLabel() {
		   return this.label;
	   }
	   
	   public void setLabel(JLabel label) {
		   this.label = label;
	   }
	   



	@Override
	public void update(Observable o, Object arg) {
		
		this.getLabel().setText("State Hexa Value: " + Integer.toHexString(ctp.getState()).toUpperCase());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== subscribe) {
			this.ctp.addObserver(this);
			this.subscribe.setEnabled(false);
			this.unsubscribe.setEnabled(true);
		}
		else if(e.getSource()== unsubscribe) {
			this.ctp.deleteObserver(this);
			this.getLabel().setText("State Hexa Value : Undefined");
			this.subscribe.setEnabled(true);
			this.unsubscribe.setEnabled(false);
		}
		
	}
	

}
