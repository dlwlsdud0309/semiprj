package com.tech.semiprj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoffeeIce extends JPanel{
	
	//필드 배열 사용
	JPanel[] iceBeverage_panel;
	JButton[] iceBeverage_buttons;
	JLabel[] iceBeverage_labelsNames, iceBeverage_labelsPrices, iceBeverage_imageLabel;
	String[] i_strNames = { "(ICE)아메리카노","(ICE)헤이즐넛 라떼","(ICE)콜드브루 라떼" };
	String[] i_strPrices = { "2000원","3200원","3800원" };

	ImageIcon[] imageIconChange, iceBeverage_image;
	Image[] imageGetImage, imageGetImage2;
	
	public CoffeeIce() {
		
		setBackground(new Color(230, 230, 230));
		
		//컴포넌트
		iceBeverage_panel = new JPanel[i_strNames.length];
		iceBeverage_labelsNames = new JLabel[i_strNames.length];
		iceBeverage_labelsPrices = new JLabel[i_strNames.length];
		iceBeverage_buttons = new JButton[i_strNames.length];
		
		//이미지
		imageIconChange = new ImageIcon[i_strNames.length];
		imageGetImage = new Image[i_strNames.length];
		imageGetImage2 = new Image[i_strNames.length];
		iceBeverage_image = new ImageIcon[i_strNames.length];
		iceBeverage_imageLabel = new JLabel[i_strNames.length];

		for (int i = 0; i < i_strNames.length; i++) {
			//판넬
			iceBeverage_panel[i] = new JPanel();
			iceBeverage_panel[i].setOpaque(false);
			iceBeverage_panel[i].setLayout(null);
			
			//버튼
//			iceBeverage_buttons[i] = new JButton(i_strNames[i]); //i_strNames[i]를 작성했기 때문에 버튼에 이름(상품명)이 나왔던 것
			iceBeverage_buttons[i] = new JButton();
			iceBeverage_buttons[i].setPreferredSize(new Dimension(200, 200));
			
			//라벨name에 strNames 부착
			iceBeverage_labelsNames[i] = new JLabel(i_strNames[i]);
			iceBeverage_labelsNames[i].setFont(new Font("맑은고딕", Font.BOLD, 15)); //폰트 지정
			iceBeverage_labelsNames[i].setForeground(new Color(51,51,51)); //이름표색
//			iceBeverage_labelsNames[i].setBounds(0, 80, 150, 150);
//			iceBeverage_labelsNames[i].setHorizontalAlignment(JLabel.CENTER);
			
			if(i_strNames[i]==("(ICE)아메리카노")) {
				iceBeverage_labelsNames[i].setBounds(25, 80, 150, 150);
			}else {
				iceBeverage_labelsNames[i].setBounds(15, 80, 150, 150);
			}
			
			//라벨prices에 strPrices 부착
			iceBeverage_labelsPrices[i] = new JLabel(i_strPrices[i]);
			iceBeverage_labelsPrices[i].setFont(new Font("맑은고딕", Font.BOLD, 15));
			iceBeverage_labelsPrices[i].setForeground(new Color(192, 57, 43)); //가격표색
			iceBeverage_labelsPrices[i].setBounds(60, 100, 200, 150);
			
			
			//이미지 부착
			imageIconChange[i] = new ImageIcon(i_strNames[i]+".png");
			imageGetImage[i] = imageIconChange[i].getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			iceBeverage_image[i] = new ImageIcon(imageGetImage[i]);
			iceBeverage_imageLabel[i] = new JLabel(iceBeverage_image[i]);
			iceBeverage_imageLabel[i].setBounds(35,5,100,140);
			
			
			iceBeverage_panel[i].add(iceBeverage_labelsNames[i]);
			iceBeverage_panel[i].add(iceBeverage_labelsPrices[i]);
			iceBeverage_panel[i].add(iceBeverage_imageLabel[i]);
			
			iceBeverage_buttons[i].add(iceBeverage_panel[i]);
			iceBeverage_buttons[i].setBorderPainted(false); //버튼외곽선 제거
			iceBeverage_buttons[i].setBackground(Color.white);
			iceBeverage_buttons[i].setFocusPainted(false); //버튼이 선택되었을 때 생기는 테두리 사용안함
			
			add(iceBeverage_buttons[i]);
		}
		
////		판넬
//		i_americano=new JPanel();
//		i_americano.setLayout(null);
//		i_americano.setOpaque(false);
//		i_hazelnutlatte=new JPanel();
//		i_hazelnutlatte.setLayout(null);
//		i_hazelnutlatte.setOpaque(false);
//		i_coldbrewlatte=new JPanel();
//		i_coldbrewlatte.setLayout(null);
//		i_coldbrewlatte.setOpaque(false);
//		
////		버튼
//		i_americanoBtn=new JButton();
//		i_hazelnutlatteBtn=new JButton();
//		i_coldbrewlatteBtn=new JButton();
//		
////		아이스 아메리카노
//		i_americanoName=new JLabel("(ICE)아메리카노");
//		i_americanoName.setBounds(25,80,150,150);
//		i_americanoName.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		i_americanoName.setForeground(new Color(51,51,51)); //이름표색
//		
//		i_americanoPrice=new JLabel("2000원");
//		i_americanoPrice.setBounds(60, 100, 200, 150);
//		i_americanoPrice.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		i_americanoPrice.setForeground(new Color(192, 57, 43));
//
//		i_americanoBtn.setPreferredSize(new Dimension(200, 200)); //버튼사이즈
//		
//		ImageIcon i_amChange=new ImageIcon("iceamericano.png");
//		Image i_amChange2=i_amChange.getImage();
//		Image i_amChange3=i_amChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon i_americanoImageIcon=new ImageIcon(i_amChange3);
//		JLabel i_americanoLabel=new JLabel(i_americanoImageIcon); //라벨만들어서 위치지정
//		i_americanoLabel.setBounds(35,5,100,140); //이미지
//		
//		i_americano.add(i_americanoName);
//		i_americano.add(i_americanoPrice);
//		i_americano.add(i_americanoLabel);
//		
//		i_americanoBtn.add(i_americano);
//		i_americanoBtn.setBorderPainted(false); //버튼의 외곽선 없애기
//		i_americanoBtn.setBackground(new Color(255,255,255));
//		i_americanoBtn.setFocusPainted(false); //버튼이 선택되었을 때 생기는 테두리 사용안함
//
//		
////		아이스 헤이즐넛라떼
//		i_hazelnutlatteName=new JLabel("(ICE)헤이즐넛라떼");
//		i_hazelnutlatteName.setBounds(15,80,150,150);
//		i_hazelnutlatteName.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		i_hazelnutlatteName.setForeground(new Color(51,51,51)); //이름표색
//		
//		i_hazelnutlattePrice=new JLabel("3200원");
//		i_hazelnutlattePrice.setBounds(60, 100, 200, 150);
//		i_hazelnutlattePrice.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		i_hazelnutlattePrice.setForeground(new Color(192, 57, 43));
//		
//		i_hazelnutlatteBtn.setPreferredSize(new Dimension(200, 200)); //버튼사이즈
//		ImageIcon i_hlChange=new ImageIcon("icehazelnutlatte.png");
//		Image i_hlChange2=i_hlChange.getImage();
//		Image i_hlChange3=i_hlChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon i_hazelnutlatteImageIcon=new ImageIcon(i_hlChange3);
//		JLabel i_hazelnutlatteLabel=new JLabel(i_hazelnutlatteImageIcon); //라벨만들어서 위치지정
//		i_hazelnutlatteLabel.setBounds(35,5,100,140); //이미지
//		
//		i_hazelnutlatte.add(i_hazelnutlatteName);
//		i_hazelnutlatte.add(i_hazelnutlattePrice);
//		i_hazelnutlatte.add(i_hazelnutlatteLabel);
//		
//		i_hazelnutlatteBtn.add(i_hazelnutlatte);
//		i_hazelnutlatteBtn.setBorderPainted(false);
//		i_hazelnutlatteBtn.setBackground(new Color(255,255,255));
//		i_hazelnutlatteBtn.setFocusPainted(false);
//		
//		
////		아이스 콜드브루라떼
//		i_coldbrewlatteName=new JLabel("(ICE)콜드브루라떼");
//		i_coldbrewlatteName.setBounds(15,80,150,150);
//		i_coldbrewlatteName.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		i_coldbrewlatteName.setForeground(new Color(51,51,51)); //이름표색
//		
//		i_coldbrewlattePrice=new JLabel("3800원");
//		i_coldbrewlattePrice.setBounds(60, 100, 200, 150);
//		i_coldbrewlattePrice.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		i_coldbrewlattePrice.setForeground(new Color(192, 57, 43));
//		
//		i_coldbrewlatteBtn.setPreferredSize(new Dimension(200, 200)); //버튼사이즈
//		ImageIcon i_cbChange=new ImageIcon("icecoldbrewlatte.png");
//		Image i_cbChange2=i_cbChange.getImage();
//		Image i_cbChange3=i_cbChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon i_coldbrewlatteImageIcon=new ImageIcon(i_cbChange3);
//		JLabel i_coldbrewlatteLabel=new JLabel(i_coldbrewlatteImageIcon); //라벨만들어서 위치지정
//		i_coldbrewlatteLabel.setBounds(35,5,100,140); //이미지
//		
//		i_coldbrewlatte.add(i_coldbrewlatteName);
//		i_coldbrewlatte.add(i_coldbrewlattePrice);
//		i_coldbrewlatte.add(i_coldbrewlatteLabel);
//		
//		i_coldbrewlatteBtn.add(i_coldbrewlatte);
//		i_coldbrewlatteBtn.setBorderPainted(false);
//		i_coldbrewlatteBtn.setBackground(new Color(255,255,255));
//		i_coldbrewlatteBtn.setFocusPainted(false);
		
		
		
		
//		add(i_americanoBtn);
//		add(i_hazelnutlatteBtn);
//		add(i_coldbrewlatteBtn);
	}
}
