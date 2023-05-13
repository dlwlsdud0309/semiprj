package com.tech.semiprj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoffeeIce extends JPanel{
//	�ʵ屸��
//	JPanel i_americano, i_hazelnutlatte, i_coldbrewlatte;
//	JButton i_americanoBtn, i_hazelnutlatteBtn, i_coldbrewlatteBtn;
//	JLabel i_americanoName, i_hazelnutlatteName, i_coldbrewlatteName,
//			i_americanoPrice, i_hazelnutlattePrice, i_coldbrewlattePrice;
//	String iceStr="";
	
	//�ʵ� �迭 ���
	JPanel[] iceBeverage_panel;
	JButton[] iceBeverage_buttons;
	JLabel[] iceBeverage_labelsNames;
	JLabel[] iceBeverage_labelsPrices;
	String[] i_strNames = {
		"iceamericano","icehazelnutlatte","icecoldbrewlatte"
	};
	String[] i_strPrices = {
		"2000��","3200��","3800��"
	};
//	JLabel[] iceBeverage_prices;
	
	public CoffeeIce() {
		setLayout(null);
		setBackground(new Color(230, 230, 230));
		
		iceBeverage_buttons = new JButton[i_strNames.length];
		for (int i = 0; i < i_strNames.length; i++) {
			//�ǳ�
			iceBeverage_panel[i] = new JPanel();
			iceBeverage_panel[i].setOpaque(false);
			
			//��ư
			iceBeverage_buttons[i] = new JButton(i_strNames[i]);
			iceBeverage_buttons[i].setPreferredSize(new Dimension(200, 200));
			
			//��name�� strNames ����
			iceBeverage_labelsNames[i] = new JLabel(i_strNames[i]);
			//.setBounds(25,80,150,150);
			iceBeverage_labelsNames[i].setFont(new Font("�������", Font.BOLD, 15)); //��Ʈ ����
			iceBeverage_labelsNames[i].setForeground(new Color(51,51,51)); //�̸�ǥ��
			
			//��prices�� strPrices ����
			iceBeverage_labelsPrices[i] = new JLabel(i_strPrices[i]);
			//.setBounds(60, 100, 200, 150);
			iceBeverage_labelsPrices[i].setFont(new Font("�������", Font.BOLD, 15));
			iceBeverage_labelsPrices[i].setForeground(new Color(192, 57, 43));
			
			
			//��ư ��ġ �����ϰ�
			//�̹��� ����
			
			
			iceBeverage_buttons[i].add(iceBeverage_panel[i]);
			add(iceBeverage_panel[i]);
		}
		
////		�ǳ�
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
////		��ư
//		i_americanoBtn=new JButton();
//		i_hazelnutlatteBtn=new JButton();
//		i_coldbrewlatteBtn=new JButton();
//		
////		���̽� �Ƹ޸�ī��
//		i_americanoName=new JLabel("(ICE)�Ƹ޸�ī��");
//		i_americanoName.setBounds(25,80,150,150);
//		i_americanoName.setFont(new Font("�������", Font.BOLD, 15));
//		i_americanoName.setForeground(new Color(51,51,51)); //�̸�ǥ��
//		
//		i_americanoPrice=new JLabel("2000��");
//		i_americanoPrice.setBounds(60, 100, 200, 150);
//		i_americanoPrice.setFont(new Font("�������", Font.BOLD, 15));
//		i_americanoPrice.setForeground(new Color(192, 57, 43));
//
//		i_americanoBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
//		
//		ImageIcon i_amChange=new ImageIcon("iceamericano.png");
//		Image i_amChange2=i_amChange.getImage();
//		Image i_amChange3=i_amChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon i_americanoImageIcon=new ImageIcon(i_amChange3);
//		JLabel i_americanoLabel=new JLabel(i_americanoImageIcon); //�󺧸��� ��ġ����
//		i_americanoLabel.setBounds(35,5,100,140); //�̹���
//		
//		i_americano.add(i_americanoName);
//		i_americano.add(i_americanoPrice);
//		i_americano.add(i_americanoLabel);
//		
//		i_americanoBtn.add(i_americano);
//		i_americanoBtn.setBorderPainted(false); //��ư�� �ܰ��� ���ֱ�
//		i_americanoBtn.setBackground(new Color(255,255,255));
//		i_americanoBtn.setFocusPainted(false); //��ư�� ���õǾ��� �� ����� �׵θ� ������
//
//		
////		���̽� ������Ӷ�
//		i_hazelnutlatteName=new JLabel("(ICE)������Ӷ�");
//		i_hazelnutlatteName.setBounds(15,80,150,150);
//		i_hazelnutlatteName.setFont(new Font("�������", Font.BOLD, 15));
//		i_hazelnutlatteName.setForeground(new Color(51,51,51)); //�̸�ǥ��
//		
//		i_hazelnutlattePrice=new JLabel("3200��");
//		i_hazelnutlattePrice.setBounds(60, 100, 200, 150);
//		i_hazelnutlattePrice.setFont(new Font("�������", Font.BOLD, 15));
//		i_hazelnutlattePrice.setForeground(new Color(192, 57, 43));
//		
//		i_hazelnutlatteBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
//		ImageIcon i_hlChange=new ImageIcon("icehazelnutlatte.png");
//		Image i_hlChange2=i_hlChange.getImage();
//		Image i_hlChange3=i_hlChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon i_hazelnutlatteImageIcon=new ImageIcon(i_hlChange3);
//		JLabel i_hazelnutlatteLabel=new JLabel(i_hazelnutlatteImageIcon); //�󺧸��� ��ġ����
//		i_hazelnutlatteLabel.setBounds(35,5,100,140); //�̹���
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
////		���̽� �ݵ����
//		i_coldbrewlatteName=new JLabel("(ICE)�ݵ����");
//		i_coldbrewlatteName.setBounds(15,80,150,150);
//		i_coldbrewlatteName.setFont(new Font("�������", Font.BOLD, 15));
//		i_coldbrewlatteName.setForeground(new Color(51,51,51)); //�̸�ǥ��
//		
//		i_coldbrewlattePrice=new JLabel("3800��");
//		i_coldbrewlattePrice.setBounds(60, 100, 200, 150);
//		i_coldbrewlattePrice.setFont(new Font("�������", Font.BOLD, 15));
//		i_coldbrewlattePrice.setForeground(new Color(192, 57, 43));
//		
//		i_coldbrewlatteBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
//		ImageIcon i_cbChange=new ImageIcon("icecoldbrewlatte.png");
//		Image i_cbChange2=i_cbChange.getImage();
//		Image i_cbChange3=i_cbChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon i_coldbrewlatteImageIcon=new ImageIcon(i_cbChange3);
//		JLabel i_coldbrewlatteLabel=new JLabel(i_coldbrewlatteImageIcon); //�󺧸��� ��ġ����
//		i_coldbrewlatteLabel.setBounds(35,5,100,140); //�̹���
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
