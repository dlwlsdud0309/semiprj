package com.tech.semiprj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoffeeHot extends JPanel{
	JPanel[] hotBeverage_panel;
	JButton[] hotBeverage_buttons;
	JLabel[] hotBeverage_labelsNames, hotBeverage_labelsPrices, hotBeverage_imageLabel;
	String[] h_strNames = {
			"(HOT)아메리카노", "(HOT)카페모카", "(HOT)바닐라라떼", "(HOT)티라미수라떼"
	};
	String[] h_strPrices = {
			"1500원", "3700원", "3700원", "3900원"
	};
	ImageIcon[] imageIconChange, hotBeverage_image;
	Image[] imageGetImage;
	
	public CoffeeHot() {
		setBackground(new Color(230, 230, 230));
		
		//컴포넌트
		hotBeverage_panel = new JPanel[h_strNames.length];
		hotBeverage_labelsNames = new JLabel[h_strNames.length];
		hotBeverage_labelsPrices = new JLabel[h_strNames.length];
		hotBeverage_buttons = new JButton[h_strNames.length];
		
		//이미지
		imageIconChange = new ImageIcon[h_strNames.length];
		imageGetImage = new Image[h_strNames.length];
		hotBeverage_image = new ImageIcon[h_strNames.length];
		hotBeverage_imageLabel = new JLabel[h_strNames.length];
		
		for (int i = 0; i < h_strNames.length; i++) {
			hotBeverage_panel[i] = new JPanel();
			hotBeverage_panel[i].setOpaque(false);
			hotBeverage_panel[i].setLayout(null);
						
			hotBeverage_buttons[i] = new JButton();
			hotBeverage_buttons[i].setPreferredSize(new Dimension(200, 200));
	
			hotBeverage_labelsNames[i] = new JLabel(h_strNames[i]);
			hotBeverage_labelsNames[i].setFont(new Font("맑은고딕", Font.BOLD, 15)); //폰트 지정
			hotBeverage_labelsNames[i].setForeground(new Color(51,51,51)); //이름표색
		
			if(h_strNames[i].length()==9) {
				hotBeverage_labelsNames[i].setBounds(32, 80, 150, 150);
			}else if(h_strNames[i].length()==10) {
				hotBeverage_labelsNames[i].setBounds(25, 80, 150, 150);
			}else if(h_strNames[i].length()==11) {
				hotBeverage_labelsNames[i].setBounds(15, 80, 150, 150);
			}else if(h_strNames[i].length()>11) {
				hotBeverage_labelsNames[i].setBounds(12, 80, 150, 150);
			}
			
			hotBeverage_labelsPrices[i] = new JLabel(h_strPrices[i]);
			hotBeverage_labelsPrices[i].setFont(new Font("맑은고딕", Font.BOLD, 15));
			hotBeverage_labelsPrices[i].setForeground(new Color(192, 57, 43)); //가격표색
			hotBeverage_labelsPrices[i].setBounds(60, 100, 200, 150);
			
			imageIconChange[i] = new ImageIcon(h_strNames[i]+".png");
			imageGetImage[i] = imageIconChange[i].getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			hotBeverage_image[i] = new ImageIcon(imageGetImage[i]);
			hotBeverage_imageLabel[i] = new JLabel(hotBeverage_image[i]);
			hotBeverage_imageLabel[i].setBounds(35,5,100,140);
			
			hotBeverage_panel[i].add(hotBeverage_labelsNames[i]);
			hotBeverage_panel[i].add(hotBeverage_labelsPrices[i]);
			hotBeverage_panel[i].add(hotBeverage_imageLabel[i]);
			
			hotBeverage_buttons[i].add(hotBeverage_panel[i]);
			hotBeverage_buttons[i].setBorderPainted(false); //버튼외곽선 제거
			hotBeverage_buttons[i].setBackground(Color.white);
			hotBeverage_buttons[i].setFocusPainted(false); //버튼이 선택되었을 때 생기는 테두리 사용안함
			
			add(hotBeverage_buttons[i]);
		}
	}
}
