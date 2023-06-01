package com.tech.semiprj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CompletePayment extends JFrame{
	
//	JPanel cTop, cCenter, cBottom, finalPanel;
//	JLabel completeLabel, receipt, callMsg, thx, waitingNumber;
	
	JTextField JFwaitingNumber;
	
	JPanel[] cPay_panels;
	JLabel[] cPay_labels;
	String[] cPay_strPanels = {
		"cTop","cCenter","cBottom","finalPanel"	
	};
	String[] cPay_strLabels = {
		"completeLabel","receipt","callMsg","thx","waitingNumber"	
	};
	
	Statement stmt;
	
	public CompletePayment() {
		setTitle("�����Ϸ�");
		setSize(400,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(255,255,255));
		

		JFwaitingNumber=new JTextField(1000);
		JFwaitingNumber.setHorizontalAlignment(JTextField.CENTER);
		JFwaitingNumber.setEditable(false);
		JFwaitingNumber.setBackground(new Color(255,255,255));
		JFwaitingNumber.setFont(new Font("�������", Font.BOLD,70));
		JFwaitingNumber.setBorder(null);
		
		
		cPay_panels = new JPanel[cPay_strPanels.length];
		cPay_labels = new JLabel[cPay_strLabels.length];
		
		for (int i = 0; i < cPay_strPanels.length; i++) {
			cPay_panels[i] = new JPanel();
			cPay_panels[i].setOpaque(false);
			cPay_panels[i].setLayout(new GridLayout(0, 1));
			
						
			for (int j = 0; j < cPay_strLabels.length; j++) {
				cPay_labels[j] = new JLabel(cPay_strLabels[i]);
				if(cPay_strLabels[j]=="completeLabel") {
					cPay_labels[j] = new JLabel("������ �Ϸ�Ǿ����ϴ�.",JLabel.CENTER);
					cPay_labels[j].setFont(new Font("�������", Font.BOLD,18));
					cPay_labels[j].setForeground(new Color(0,0,0));
				}else if(cPay_strLabels[j]=="receipt") {
					cPay_labels[j] = new JLabel("������ ����� �Ϸ�� ������ ��ƴ���� ������.",JLabel.CENTER);
				}else if(cPay_strLabels[j]=="waitingNumber") {
					cPay_labels[j] = new JLabel("����ȣ",JLabel.CENTER);
					cPay_labels[j].setFont(new Font("�������", Font.BOLD,25));
				}else if(cPay_strLabels[j]=="callMsg") {
					cPay_labels[j] = new JLabel("�޴��� �غ�Ǹ� �ֹ���ȣ ȣ�����ͷ� �˷��帳�ϴ�.",JLabel.CENTER);
					cPay_labels[j].setFont(new Font("�������", Font.BOLD,14));
					cPay_labels[j].setForeground(new Color(248, 101, 12));
				}else if(cPay_strLabels[j]=="thx") {
					cPay_labels[j]=new JLabel("�����մϴ�.",JLabel.CENTER);
					cPay_labels[j].setFont(new Font("�������", Font.BOLD,14));
				}
				
				if(cPay_strPanels[i]=="cTop" && cPay_strLabels[j]=="completeLabel") {
					cPay_panels[i].add(cPay_labels[j]);
				}else if(cPay_strPanels[i]=="cCenter" && cPay_strLabels[j]=="waitingNumber" || cPay_strLabels[j]=="JFwaitingNumber") {
					cPay_panels[i].add(cPay_labels[j]);
				}else if(cPay_strPanels[i]=="cBottom" && cPay_strLabels[j]=="callMsg" || cPay_strLabels[j]=="thx") {
					cPay_panels[i].add(cPay_labels[j]);
				}else if(cPay_strPanels[i]=="finalPanel") {
					cPay_panels[i].setBackground(Color.white);
					cPay_panels[i].setLayout(new BorderLayout());
					add(cPay_panels[i]);
				}
			}

		}
		
		setVisible(true);
//		cTop=new JPanel();
//		cTop.setOpaque(false);
//		cTop.setLayout(new GridLayout(0,1));
//		cCenter=new JPanel();
//		cCenter.setLayout(new GridLayout(0,1));
//		cCenter.setOpaque(false);
//		cBottom=new JPanel();
//		cBottom.setOpaque(false);
//		cBottom.setLayout(new GridLayout(0,1));
//		finalPanel=new JPanel();
//		finalPanel.setBackground(new Color(255,255,255));
//		finalPanel.setLayout(new BorderLayout());
//		
//		completeLabel=new JLabel("������ �Ϸ�Ǿ����ϴ�.",JLabel.CENTER);
//		completeLabel.setFont(new Font("�������", Font.BOLD,18));
//		completeLabel.setForeground(new Color(0,0,0));
//		receipt=new JLabel("������ ����� �Ϸ�� ������ ��ƴ���� ������.",JLabel.CENTER);
//		
//		
//		waitingNumber=new JLabel("����ȣ",JLabel.CENTER);
//		waitingNumber.setFont(new Font("�������", Font.BOLD,25));
//		
//		
//		JFwaitingNumber=new JTextField(1000);
//		JFwaitingNumber.setHorizontalAlignment(JTextField.CENTER);
//		JFwaitingNumber.setEditable(false);
//		JFwaitingNumber.setBackground(new Color(255,255,255));
//		JFwaitingNumber.setFont(new Font("�������", Font.BOLD,70));
//		JFwaitingNumber.setBorder(null);
//		
//
//		
//		
//		callMsg=new JLabel("�޴��� �غ�Ǹ� �ֹ���ȣ ȣ�����ͷ� �˷��帳�ϴ�.",JLabel.CENTER);
//		callMsg.setFont(new Font("�������", Font.BOLD,14));
//		callMsg.setForeground(new Color(248, 101, 12));
//		
//		thx=new JLabel("�����մϴ�.",JLabel.CENTER);
//		thx.setFont(new Font("�������", Font.BOLD,14));
//
//		
//		cTop.add(completeLabel);
//		cTop.add(receipt);
//		
//		cCenter.add(waitingNumber);
//		cCenter.add(JFwaitingNumber);
//		
//		cBottom.add(callMsg);
//		cBottom.add(thx);
//		
//		finalPanel.add(cTop,BorderLayout.NORTH);
//		finalPanel.add(cCenter,BorderLayout.CENTER);
//		finalPanel.add(cBottom,BorderLayout.SOUTH);
//		add(finalPanel);
	}
}
