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
//	�ʵ屸��
//	JPanel honeybread, smorecookiesmatcha, icecreamcroiffle;
//	JButton honeybreadBtn, smorecookiesmatchaBtn, icecreamcroiffleBtn;
//	JLabel honeybreadName, smorecookiesmatchaName, icecreamcroiffleName,
//		honeybreadPrice, smorecookiesmatchaPrice, icecreamcroifflePrice;
	
	JPanel[] desert_panel;
	JButton[] desert_buttons;
	JLabel[] desert_labelsNames, desert_labelsPrices, desert_imageLabel;
	String[] d_strNames = {
		"��Ϻ극��", "�����������Ű", "���̽�ũ��ũ����"
	};
	String[] d_strPrices = {
		"4500��", "2900��", "3000��"
	};
	ImageIcon[] imageIconChange, desert_image;
	Image[] imageGetImage;
	
	public Dessert() {
		setBackground(new Color(230, 230, 230));
		
		//������Ʈ
		desert_panel = new JPanel[d_strNames.length];
		desert_labelsNames = new JLabel[d_strNames.length];
		desert_labelsPrices = new JLabel[d_strNames.length];
		desert_buttons = new JButton[d_strNames.length];
		
		//�̹���
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
			desert_labelsNames[i].setFont(new Font("�������", Font.BOLD, 15)); //��Ʈ ����
			desert_labelsNames[i].setForeground(new Color(51,51,51)); //�̸�ǥ��
	
			if (d_strNames[i].length()==5) {
				desert_labelsNames[i].setBounds(45,80,150,150);
			}else if (d_strNames[i].length()==7) {
				desert_labelsNames[i].setBounds(25,80,150,150);
			}else if (d_strNames[i].length()==8) {
				desert_labelsNames[i].setBounds(20,80,150,150);
			}
			
			desert_labelsPrices[i] = new JLabel(d_strPrices[i]);
			desert_labelsPrices[i].setFont(new Font("�������", Font.BOLD, 15));
			desert_labelsPrices[i].setForeground(new Color(192, 57, 43)); //����ǥ��
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
			desert_buttons[i].setBorderPainted(false); //��ư�ܰ��� ����
			desert_buttons[i].setBackground(Color.white);
			desert_buttons[i].setFocusPainted(false); //��ư�� ���õǾ��� �� ����� �׵θ� ������
			
			add(desert_buttons[i]);
		}
		
//		�ǳ�
//		honeybread=new JPanel();
//		honeybread.setLayout(null);
//		honeybread.setOpaque(false);
//		smorecookiesmatcha=new JPanel();
//		smorecookiesmatcha.setLayout(null);
//		smorecookiesmatcha.setOpaque(false);
//		icecreamcroiffle=new JPanel();
//		icecreamcroiffle.setLayout(null);
//		icecreamcroiffle.setOpaque(false);
//		
////		��ư
//		honeybreadBtn=new JButton();
//		smorecookiesmatchaBtn=new JButton();
//		icecreamcroiffleBtn=new JButton();
//	
//		
////		��Ϻ극��
//		honeybreadName=new JLabel("��Ϻ극��");
//		honeybreadName.setBounds(45,80,150,150);
//		honeybreadName.setFont(new Font("�������", Font.BOLD, 15));
//		honeybreadName.setForeground(new Color(51,51,51)); //�̸�ǥ��
//		
//		honeybreadPrice=new JLabel("4500��");
//		honeybreadPrice.setBounds(60, 100, 200, 150);
//		honeybreadPrice.setFont(new Font("�������", Font.BOLD, 15));
//		honeybreadPrice.setForeground(new Color(192, 57, 43));
//
//		honeybreadBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
//		
//		ImageIcon hbChange=new ImageIcon("honeybread.png");
//		Image hbChange2=hbChange.getImage();
//		Image hbChange3=hbChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon hbImageIcon=new ImageIcon(hbChange3);
//		JLabel hbLabel=new JLabel(hbImageIcon); //�󺧸��� ��ġ����
//		hbLabel.setBounds(-20,-25,200,200);
//		
//		honeybread.add(honeybreadName);
//		honeybread.add(honeybreadPrice);
//		honeybread.add(hbLabel);
//		
//		honeybreadBtn.add(honeybread);
//		honeybreadBtn.setBorderPainted(false); //��ư�� �ܰ��� ���ֱ�
//		honeybreadBtn.setBackground(new Color(255,255,255));
//		honeybreadBtn.setFocusPainted(false);
//		
//		
////		�����������Ű
//		smorecookiesmatchaName=new JLabel("�����������Ű");
//		smorecookiesmatchaName.setBounds(25,80,150,150);
//		smorecookiesmatchaName.setFont(new Font("�������", Font.BOLD, 15));
//		smorecookiesmatchaName.setForeground(new Color(51,51,51)); //�̸�ǥ��
//		
//		smorecookiesmatchaPrice=new JLabel("2900��");
//		smorecookiesmatchaPrice.setBounds(60, 100, 200, 150);
//		smorecookiesmatchaPrice.setFont(new Font("�������", Font.BOLD, 15));
//		smorecookiesmatchaPrice.setForeground(new Color(192, 57, 43));
//
//		smorecookiesmatchaBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
//		
//		ImageIcon mcChange=new ImageIcon("smorecookiesmatcha.png");
//		Image mcChange2=mcChange.getImage();
//		Image mcChange3=mcChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon mcImageIcon=new ImageIcon(mcChange3);
//		JLabel mcLabel=new JLabel(mcImageIcon); //�󺧸��� ��ġ����
//		mcLabel.setBounds(-20,-25,200,200);
//		
//		smorecookiesmatcha.add(smorecookiesmatchaName);
//		smorecookiesmatcha.add(smorecookiesmatchaPrice);
//		smorecookiesmatcha.add(mcLabel);
//		
//		smorecookiesmatchaBtn.add(smorecookiesmatcha);
//		smorecookiesmatchaBtn.setBorderPainted(false); //��ư�� �ܰ��� ���ֱ�
//		smorecookiesmatchaBtn.setBackground(new Color(255,255,255));
//		smorecookiesmatchaBtn.setFocusPainted(false);
//		
////		���̽�ũ��ũ����
//		icecreamcroiffleName=new JLabel("���̽�ũ��ũ����");
//		icecreamcroiffleName.setBounds(20,80,150,150);
//		icecreamcroiffleName.setFont(new Font("�������", Font.BOLD, 15));
//		icecreamcroiffleName.setForeground(new Color(51,51,51)); //�̸�ǥ��
//		
//		icecreamcroifflePrice=new JLabel("3000��");
//		icecreamcroifflePrice.setBounds(60, 100, 200, 150);
//		icecreamcroifflePrice.setFont(new Font("�������", Font.BOLD, 15));
//		icecreamcroifflePrice.setForeground(new Color(192, 57, 43));
//
//		icecreamcroiffleBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
//		
//		ImageIcon iccChange=new ImageIcon("icecreamcroiffle.png");
//		Image iccChange2=iccChange.getImage();
//		Image iccChange3=iccChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon iccImageIcon=new ImageIcon(iccChange3);
//		JLabel iccLabel=new JLabel(iccImageIcon); //�󺧸��� ��ġ����
//		iccLabel.setBounds(-20,-25,200,200);
//		
//		icecreamcroiffle.add(icecreamcroiffleName);
//		icecreamcroiffle.add(icecreamcroifflePrice);
//		icecreamcroiffle.add(iccLabel);
//		
//		icecreamcroiffleBtn.add(icecreamcroiffle);
//		icecreamcroiffleBtn.setBorderPainted(false); //��ư�� �ܰ��� ���ֱ�
//		icecreamcroiffleBtn.setBackground(new Color(255,255,255));
//		icecreamcroiffleBtn.setFocusPainted(false);
//		
//		add(honeybreadBtn);
//		add(smorecookiesmatchaBtn);
//		add(icecreamcroiffleBtn);
		
	}
}
