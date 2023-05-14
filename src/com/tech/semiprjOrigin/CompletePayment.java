package com.tech.semiprjOrigin;

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
	
	JPanel cTop, cCenter, cBottom, finalPanel;
	JLabel completeLabel, receipt, callMsg, thx, waitingNumber;
	JTextField JFwaitingNumber;
	
	
	Statement stmt;
	
	public CompletePayment() {
		setTitle("�����Ϸ�");
		setSize(400,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(255,255,255));
		
		cTop=new JPanel();
		cTop.setOpaque(false);
		cTop.setLayout(new GridLayout(0,1));
		cCenter=new JPanel();
		cCenter.setLayout(new GridLayout(0,1));
		cCenter.setOpaque(false);
		cBottom=new JPanel();
		cBottom.setOpaque(false);
		cBottom.setLayout(new GridLayout(0,1));
		finalPanel=new JPanel();
		finalPanel.setBackground(new Color(255,255,255));
		finalPanel.setLayout(new BorderLayout());
		
		completeLabel=new JLabel("������ �Ϸ�Ǿ����ϴ�.",JLabel.CENTER);
		completeLabel.setFont(new Font("�������", Font.BOLD,18));
		completeLabel.setForeground(new Color(0,0,0));
		receipt=new JLabel("������ ����� �Ϸ�� ������ ��ƴ���� ������.",JLabel.CENTER);
		
		
		waitingNumber=new JLabel("����ȣ",JLabel.CENTER);
		waitingNumber.setFont(new Font("�������", Font.BOLD,25));
		
		
		JFwaitingNumber=new JTextField(1000);
		JFwaitingNumber.setHorizontalAlignment(JTextField.CENTER);
		JFwaitingNumber.setEditable(false);
		JFwaitingNumber.setBackground(new Color(255,255,255));
		JFwaitingNumber.setFont(new Font("�������", Font.BOLD,70));
		JFwaitingNumber.setBorder(null);
		

		
		
		callMsg=new JLabel("�޴��� �غ�Ǹ� �ֹ���ȣ ȣ�����ͷ� �˷��帳�ϴ�.",JLabel.CENTER);
		callMsg.setFont(new Font("�������", Font.BOLD,14));
		callMsg.setForeground(new Color(248, 101, 12));
		
		thx=new JLabel("�����մϴ�.",JLabel.CENTER);
		thx.setFont(new Font("�������", Font.BOLD,14));

		
		cTop.add(completeLabel);
		cTop.add(receipt);
		
		cCenter.add(waitingNumber);
		cCenter.add(JFwaitingNumber);
		
		cBottom.add(callMsg);
		cBottom.add(thx);
		
		finalPanel.add(cTop,BorderLayout.NORTH);
		finalPanel.add(cCenter,BorderLayout.CENTER);
		finalPanel.add(cBottom,BorderLayout.SOUTH);
		add(finalPanel);
	}
	
	
}
