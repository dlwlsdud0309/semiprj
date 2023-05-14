package com.tech.semiprjOrigin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainCoffee extends JFrame {

	JPanel mainPanel, imagePanel, mainFinalPanel;
	JLabel clickedLabel;
	CoffeeOrder co;
	
	public MainCoffee() {
		
		setTitle("세미 프로젝트: MEGACOFFEE");
		setSize(1000,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		mainPanel =new JPanel();
		mainPanel.setLayout(new GridLayout(0,1));
		mainPanel.setOpaque(false);
		
		imagePanel=new JPanel();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(null);
		
		
		clickedLabel=new JLabel("화면을 클릭해주세요",JLabel.CENTER);
		clickedLabel.setOpaque(false);
		clickedLabel.setFont(new Font("맑은고딕", Font.BOLD, 15));
		clickedLabel.setForeground(new Color(158, 158, 158));
		
		mainFinalPanel=new JPanel();
		mainFinalPanel.setBackground(new Color(255,255,255));
		mainFinalPanel.setLayout(new BorderLayout());
		
		
		ImageIcon mbChange=new ImageIcon("megacoffee2.png");
		Image mbChange2=mbChange.getImage();
		Image mbChange3=mbChange2.getScaledInstance(640,320, Image.SCALE_SMOOTH);
		ImageIcon mbImageIcon=new ImageIcon(mbChange3);
		JLabel mbLabel=new JLabel(mbImageIcon); //라벨만들어서 위치지정
		mbLabel.setBounds(170, 100, 640, 320);
		mbLabel.setOpaque(false);
		
		imagePanel.add(mbLabel);
		mainPanel.add(imagePanel);
		mainPanel.add(clickedLabel);
		mainFinalPanel.add(imagePanel,BorderLayout.CENTER);
		mainFinalPanel.add(mainPanel,BorderLayout.SOUTH);
		
		add(mainFinalPanel);
		
		setVisible(true);
		
		mainFinalPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CoffeeOrder();
				dispose();			
			} 
		});
		};
		

	public static void main(String[] args) {
		new MainCoffee();
	}
	
}




























