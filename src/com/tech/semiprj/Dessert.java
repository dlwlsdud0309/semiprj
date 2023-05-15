package com.tech.semiprj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dessert extends JPanel{
	JPanel[] desert_panel;
	JButton[] desert_buttons;
	JLabel[] desert_labelsNames, desert_labelsPrices, desert_imageLabel;
	String[] d_strNames = {
		"허니브레드", "말차스모어쿠키", "아이스크림크로플"
	};
	String[] d_strPrices = {
		"4500원", "2900원", "3000원"
	};
	ImageIcon[] imageIconChange, desert_image;
	Image[] imageGetImage;
	
	public Dessert() {
		setBackground(new Color(230, 230, 230));
		
		//컴포넌트
		desert_panel = new JPanel[d_strNames.length];
		desert_labelsNames = new JLabel[d_strNames.length];
		desert_labelsPrices = new JLabel[d_strNames.length];
		desert_buttons = new JButton[d_strNames.length];
		
		//이미지
		imageIconChange = new ImageIcon[d_strNames.length];
		imageGetImage = new Image[d_strNames.length];
		desert_image = new ImageIcon[d_strNames.length];
		desert_imageLabel = new JLabel[d_strNames.length];
		
		for (int i = 0; i < d_strNames.length; i++) {
			desert_panel[i] = new JPanel();
			desert_panel[i].setOpaque(false);
			desert_panel[i].setLayout(null);

			desert_buttons[i] = new JButton();
			desert_buttons[i].setPreferredSize(new Dimension(200, 200));
			
			desert_labelsNames[i] = new JLabel(d_strNames[i]);
			desert_labelsNames[i].setFont(new Font("맑은고딕", Font.BOLD, 15)); //폰트 지정
			desert_labelsNames[i].setForeground(new Color(51,51,51)); //이름표색
	
			if (d_strNames[i].length()==5) {
				desert_labelsNames[i].setBounds(45,80,150,150);
			}else if (d_strNames[i].length()==7) {
				desert_labelsNames[i].setBounds(25,80,150,150);
			}else if (d_strNames[i].length()==8) {
				desert_labelsNames[i].setBounds(20,80,150,150);
			}
			
			desert_labelsPrices[i] = new JLabel(d_strPrices[i]);
			desert_labelsPrices[i].setFont(new Font("맑은고딕", Font.BOLD, 15));
			desert_labelsPrices[i].setForeground(new Color(192, 57, 43)); //가격표색
			desert_labelsPrices[i].setBounds(60, 100, 200, 150);
			
			imageIconChange[i] = new ImageIcon(d_strNames[i]+".png");
			imageGetImage[i] = imageIconChange[i].getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			desert_image[i] = new ImageIcon(imageGetImage[i]);
			desert_imageLabel[i] = new JLabel(desert_image[i]);
			desert_imageLabel[i].setBounds(-20,-25,200,200);
			
			desert_panel[i].add(desert_labelsNames[i]);
			desert_panel[i].add(desert_labelsPrices[i]);
			desert_panel[i].add(desert_imageLabel[i]);
			
			desert_buttons[i].add(desert_panel[i]);
			desert_buttons[i].setBorderPainted(false); //버튼외곽선 제거
			desert_buttons[i].setBackground(Color.white);
			desert_buttons[i].setFocusPainted(false); //버튼이 선택되었을 때 생기는 테두리 사용안함
			
			add(desert_buttons[i]);
		}
	}
}
