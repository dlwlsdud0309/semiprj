package com.tech.semiprjOrigin;

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
	JPanel honeybread, smorecookiesmatcha, icecreamcroiffle;
	JButton honeybreadBtn, smorecookiesmatchaBtn, icecreamcroiffleBtn;
	JLabel honeybreadName, smorecookiesmatchaName, icecreamcroiffleName,
		honeybreadPrice, smorecookiesmatchaPrice, icecreamcroifflePrice;
	String dstStr="";
	
	public Dessert() {
		setBackground(new Color(230, 230, 230));
		
		
//		�ǳ�
		honeybread=new JPanel();
		honeybread.setLayout(null);
		honeybread.setOpaque(false);
		smorecookiesmatcha=new JPanel();
		smorecookiesmatcha.setLayout(null);
		smorecookiesmatcha.setOpaque(false);
		icecreamcroiffle=new JPanel();
		icecreamcroiffle.setLayout(null);
		icecreamcroiffle.setOpaque(false);
		
//		��ư
		honeybreadBtn=new JButton();
		smorecookiesmatchaBtn=new JButton();
		icecreamcroiffleBtn=new JButton();
	
		
//		��Ϻ극��
		honeybreadName=new JLabel("��Ϻ극��");
		honeybreadName.setBounds(45,80,150,150);
		honeybreadName.setFont(new Font("�������", Font.BOLD, 15));
		honeybreadName.setForeground(new Color(51,51,51)); //�̸�ǥ��
		
		honeybreadPrice=new JLabel("4500��");
		honeybreadPrice.setBounds(60, 100, 200, 150);
		honeybreadPrice.setFont(new Font("�������", Font.BOLD, 15));
		honeybreadPrice.setForeground(new Color(192, 57, 43));

		honeybreadBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
		
		ImageIcon hbChange=new ImageIcon("honeybread.png");
		Image hbChange2=hbChange.getImage();
		Image hbChange3=hbChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon hbImageIcon=new ImageIcon(hbChange3);
		JLabel hbLabel=new JLabel(hbImageIcon); //�󺧸��� ��ġ����
		hbLabel.setBounds(-20,-25,200,200);
		
		honeybread.add(honeybreadName);
		honeybread.add(honeybreadPrice);
		honeybread.add(hbLabel);
		
		honeybreadBtn.add(honeybread);
		honeybreadBtn.setBorderPainted(false); //��ư�� �ܰ��� ���ֱ�
		honeybreadBtn.setBackground(new Color(255,255,255));
		honeybreadBtn.setFocusPainted(false);
		
		
//		�����������Ű
		smorecookiesmatchaName=new JLabel("�����������Ű");
		smorecookiesmatchaName.setBounds(25,80,150,150);
		smorecookiesmatchaName.setFont(new Font("�������", Font.BOLD, 15));
		smorecookiesmatchaName.setForeground(new Color(51,51,51)); //�̸�ǥ��
		
		smorecookiesmatchaPrice=new JLabel("2900��");
		smorecookiesmatchaPrice.setBounds(60, 100, 200, 150);
		smorecookiesmatchaPrice.setFont(new Font("�������", Font.BOLD, 15));
		smorecookiesmatchaPrice.setForeground(new Color(192, 57, 43));

		smorecookiesmatchaBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
		
		ImageIcon mcChange=new ImageIcon("smorecookiesmatcha.png");
		Image mcChange2=mcChange.getImage();
		Image mcChange3=mcChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon mcImageIcon=new ImageIcon(mcChange3);
		JLabel mcLabel=new JLabel(mcImageIcon); //�󺧸��� ��ġ����
		mcLabel.setBounds(-20,-25,200,200);
		
		smorecookiesmatcha.add(smorecookiesmatchaName);
		smorecookiesmatcha.add(smorecookiesmatchaPrice);
		smorecookiesmatcha.add(mcLabel);
		
		smorecookiesmatchaBtn.add(smorecookiesmatcha);
		smorecookiesmatchaBtn.setBorderPainted(false); //��ư�� �ܰ��� ���ֱ�
		smorecookiesmatchaBtn.setBackground(new Color(255,255,255));
		smorecookiesmatchaBtn.setFocusPainted(false);
		
//		���̽�ũ��ũ����
		icecreamcroiffleName=new JLabel("���̽�ũ��ũ����");
		icecreamcroiffleName.setBounds(20,80,150,150);
		icecreamcroiffleName.setFont(new Font("�������", Font.BOLD, 15));
		icecreamcroiffleName.setForeground(new Color(51,51,51)); //�̸�ǥ��
		
		icecreamcroifflePrice=new JLabel("3000��");
		icecreamcroifflePrice.setBounds(60, 100, 200, 150);
		icecreamcroifflePrice.setFont(new Font("�������", Font.BOLD, 15));
		icecreamcroifflePrice.setForeground(new Color(192, 57, 43));

		icecreamcroiffleBtn.setPreferredSize(new Dimension(200, 200)); //��ư������
		
		ImageIcon iccChange=new ImageIcon("icecreamcroiffle.png");
		Image iccChange2=iccChange.getImage();
		Image iccChange3=iccChange2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon iccImageIcon=new ImageIcon(iccChange3);
		JLabel iccLabel=new JLabel(iccImageIcon); //�󺧸��� ��ġ����
		iccLabel.setBounds(-20,-25,200,200);
		
		icecreamcroiffle.add(icecreamcroiffleName);
		icecreamcroiffle.add(icecreamcroifflePrice);
		icecreamcroiffle.add(iccLabel);
		
		icecreamcroiffleBtn.add(icecreamcroiffle);
		icecreamcroiffleBtn.setBorderPainted(false); //��ư�� �ܰ��� ���ֱ�
		icecreamcroiffleBtn.setBackground(new Color(255,255,255));
		icecreamcroiffleBtn.setFocusPainted(false);
		
		add(honeybreadBtn);
		add(smorecookiesmatchaBtn);
		add(icecreamcroiffleBtn);
		
	}
}
