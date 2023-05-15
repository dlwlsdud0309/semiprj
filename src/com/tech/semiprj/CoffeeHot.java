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
//	필드구성
//	JPanel h_americano, h_cafemocha, h_vanillalatte, h_tiramisulatte;
//	JButton h_americanoBtn, h_cafemochaBtn, h_vanillalatteBtn, h_tiramisulatteBtn;
//	JLabel h_americanoName, h_americanoPrice, h_cafemochaName, h_cafemochaPrice,
//			h_vanillalatteName, h_vanillalattePrice, h_tiramisulatteName, h_tiramisulattePrice;
	
	
	public CoffeeHot() {
		setBackground(new Color(230, 230, 230));
		
		
		
		
//		판넬		
//		h_americano=new JPanel();
//		h_americano.setLayout(null);
//		h_americano.setOpaque(false);
//		h_cafemocha=new JPanel();
//		h_cafemocha.setLayout(null);
//		h_cafemocha.setOpaque(false);
//		h_vanillalatte=new JPanel();
//		h_vanillalatte.setLayout(null);
//		h_vanillalatte.setOpaque(false);
//		h_tiramisulatte=new JPanel();
//		h_tiramisulatte.setLayout(null);
//		h_tiramisulatte.setOpaque(false);
//		
////		버튼
//		h_americanoBtn=new JButton();
//		h_cafemochaBtn=new JButton();
//		h_vanillalatteBtn=new JButton();
//		h_tiramisulatteBtn=new JButton();
//
//		
////		아메리카노
//		h_americanoName=new JLabel("(HOT)아메리카노");
//		h_americanoName.setBounds(25,80,150,150);
//		h_americanoName.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		h_americanoName.setForeground(new Color(51,51,51)); //이름표색
//		
//		h_americanoPrice=new JLabel("1500원");
//		h_americanoPrice.setBounds(60, 100, 200, 150);
//		h_americanoPrice.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		h_americanoPrice.setForeground(new Color(192, 57, 43));
//
//		h_americanoBtn.setPreferredSize(new Dimension(200, 200)); //버튼사이즈
//		
//		ImageIcon h_amChange=new ImageIcon("hotamericano.png");
//		Image h_amChange2=h_amChange.getImage();
//		Image h_amChange3=h_amChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon h_americanoImageIcon=new ImageIcon(h_amChange3);
//		JLabel h_americanoLabel=new JLabel(h_americanoImageIcon); //라벨만들어서 위치지정
//		h_americanoLabel.setBounds(35,5,100,140); //이미지
//		
//		h_americano.add(h_americanoName);
//		h_americano.add(h_americanoPrice);
//		h_americano.add(h_americanoLabel);
//		
//		h_americanoBtn.add(h_americano);
//		h_americanoBtn.setBorderPainted(false); //버튼의 외곽선 없애기
//		h_americanoBtn.setBackground(new Color(255,255,255));
//		h_americanoBtn.setFocusPainted(false); //버튼이 선택되었을 때 생기는 테두리 사용안함
//
//		
//		
////		카페모카
//		h_cafemochaName=new JLabel("(HOT)카페모카");
//		h_cafemochaName.setBounds(35,80,150,150);
//		h_cafemochaName.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		h_cafemochaName.setForeground(new Color(51,51,51)); //이름표색
//		
//		h_cafemochaPrice=new JLabel("3700원");
//		h_cafemochaPrice.setBounds(60, 100, 200, 150);
//		h_cafemochaPrice.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		h_cafemochaPrice.setForeground(new Color(192, 57, 43));
//		
//		h_cafemochaBtn.setPreferredSize(new Dimension(200, 200));
//		
//		ImageIcon h_cmChange=new ImageIcon("hotcafemocha.png");
//		Image h_cmChange2=h_cmChange.getImage();
//		Image h_cmChange3=h_cmChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon h_cafemochaImageIcon=new ImageIcon(h_cmChange3);
//		JLabel h_cafemochaLabel=new JLabel(h_cafemochaImageIcon); //라벨만들어서 위치지정
//		h_cafemochaLabel.setBounds(35,5,100,140); //이미지
//		
//		h_cafemocha.add(h_cafemochaName);
//		h_cafemocha.add(h_cafemochaPrice);
//		h_cafemocha.add(h_cafemochaLabel);
//		
//		h_cafemochaBtn.add(h_cafemocha);
//		h_cafemochaBtn.setBorderPainted(false);
//		h_cafemochaBtn.setBackground(new Color(255,255,255));
//		h_cafemochaBtn.setFocusPainted(false);
//		
//		
//		
////		바닐라라떼
//		h_vanillalatteName=new JLabel("(HOT)바닐라라떼");
//		h_vanillalatteName.setBounds(25,80,150,150);
//		h_vanillalatteName.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		h_vanillalatteName.setForeground(new Color(51,51,51)); //이름표색
//		
//		h_vanillalattePrice=new JLabel("3700원");
//		h_vanillalattePrice.setBounds(60, 100, 200, 150);
//		h_vanillalattePrice.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		h_vanillalattePrice.setForeground(new Color(192, 57, 43));
//		
//		h_vanillalatteBtn.setPreferredSize(new Dimension(200, 200)); //버튼사이즈
//		ImageIcon h_vnChange=new ImageIcon("hotvanillalatte.png");
//		Image h_vnChange2=h_vnChange.getImage();
//		Image h_vnChange3=h_vnChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon h_vanillalatteImageIcon=new ImageIcon(h_vnChange3);
//		JLabel h_vanillalatteLabel=new JLabel(h_vanillalatteImageIcon); //라벨만들어서 위치지정
//		h_vanillalatteLabel.setBounds(35,5,100,140); //이미지
//		
//		h_vanillalatte.add(h_vanillalatteName);
//		h_vanillalatte.add(h_vanillalattePrice);
//		h_vanillalatte.add(h_vanillalatteLabel);
//		
//		h_vanillalatteBtn.add(h_vanillalatte);
//		h_vanillalatteBtn.setBorderPainted(false);
//		h_vanillalatteBtn.setBackground(new Color(255,255,255));
//		h_vanillalatteBtn.setFocusPainted(false);
//		
//
//		
////		티라미수라떼
//		h_tiramisulatteName=new JLabel("(HOT)티라미수라떼");
//		h_tiramisulatteName.setBounds(15,80,150,150);
//		h_tiramisulatteName.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		h_tiramisulatteName.setForeground(new Color(51,51,51)); //이름표색
//		
//		h_tiramisulattePrice=new JLabel("3900원");
//		h_tiramisulattePrice.setBounds(60, 100, 200, 150);
//		h_tiramisulattePrice.setFont(new Font("맑은고딕", Font.BOLD, 15));
//		h_tiramisulattePrice.setForeground(new Color(192, 57, 43));
//		
//		h_tiramisulatteBtn.setPreferredSize(new Dimension(200, 200)); //버튼사이즈
//		ImageIcon h_tlChange=new ImageIcon("hottiramisulatte.png");
//		Image h_tlChange2=h_tlChange.getImage();
//		Image h_tlChange3=h_tlChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon h_tiramisulatteImageIcon=new ImageIcon(h_tlChange3);
//		JLabel h_tiramisulatteLabel=new JLabel(h_tiramisulatteImageIcon); //라벨만들어서 위치지정
//		h_tiramisulatteLabel.setBounds(35,5,100,140); //이미지
//		
//		h_tiramisulatte.add(h_tiramisulatteName);
//		h_tiramisulatte.add(h_tiramisulattePrice);
//		h_tiramisulatte.add(h_tiramisulatteLabel);
//		
//		h_tiramisulatteBtn.add(h_tiramisulatte);
//		h_tiramisulatteBtn.setBorderPainted(false);
//		h_tiramisulatteBtn.setBackground(new Color(255,255,255));
//		h_tiramisulatteBtn.setFocusPainted(false);
//		
//		
////		버튼부착
//		add(h_americanoBtn);
//		add(h_cafemochaBtn);
//		add(h_vanillalatteBtn);
//		add(h_tiramisulatteBtn);
		
	}
}
