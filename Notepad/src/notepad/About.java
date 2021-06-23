package notepad;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class About extends JFrame implements ActionListener {
	JButton b1;
	About() {
		setBounds(350, 100, 700, 600);
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(280, 100, 150, 150);
		add(l1);
		
		JLabel l2 = new JLabel("<html>Notepad coded by Somya Goyal<br>Notepad is a text proceesing application used to create text files.<br>All rigths reserved... ");
		l2.setFont(new Font("SAN_SERIF" , Font.PLAIN,20));
		l2.setBounds(130,170,500,300);
		add(l2);
		
		b1 = new JButton("OK");
		b1.setBounds(320,450,80,25);
		b1.addActionListener(this);
//		b1.addKeyListener(KeyListener.);
		add(b1);
	}

	public static void main(String[] args) {
		new About().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		
	}
}
