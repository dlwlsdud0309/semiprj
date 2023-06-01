package com.tech.semiprj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.tech.semiprj.CoffeeOrder;

public class OrderConfirmation extends JFrame {
	
	Connection cn;

	JTextArea totalAmount;

	CoffeeHot ch;
	CoffeeOrder co;

	JButton[] oc_buttons;
	JPanel[] oc_panels;
	
	JLabel checkLabel;
	
	String[] oc_strPanel = {
		"topP","centerP","downP"
	};
	String[] oc_strButton = {
		"���ư���","�����ϱ�"	
	};
	
	
	
	public OrderConfirmation() { //���γ��� Ȯ���ϱ�
		setTitle("�ֹ�Ȯ��");
		setLayout(new BorderLayout());
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		oc_panels = new JPanel[oc_strPanel.length];
		oc_buttons = new JButton[oc_strButton.length];
		
		checkLabel=new JLabel("�ֹ� ���γ����� �ٽ� �ѹ� Ȯ���Ͽ� �ּ���");
		checkLabel.setFont(new Font("�������", Font.BOLD,18));
		checkLabel.setForeground(new Color(255,255,255));
		
		totalAmount=new JTextArea(15,45);
		totalAmount.setEditable(false);

		for (int i = 0; i < oc_strPanel.length; i++) {
			oc_panels[i] = new JPanel();
//			System.out.println(oc_panels.length); //����� 3


			if(oc_strPanel[i]=="topP") {
				setBackground(new Color(248, 101, 12));
				add(checkLabel);
			}else if(oc_strPanel[i]=="centerP") {
				add(totalAmount);
			}
		}
		
		for (int i = 0; i < oc_strButton.length; i++) {
			oc_buttons[i] = new JButton(oc_strButton[i]);
			oc_buttons[i].setPreferredSize(new Dimension(100, 50));
			oc_buttons[i].setFont(new Font("�������",Font.BOLD,15));
			oc_buttons[i].setForeground(Color.white);
			oc_buttons[i].setBorderPainted(false);
//			oc_buttons[i].addActionListener(this);
			
			if(oc_strButton[i]=="�����ϱ�") {
				oc_buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						co.ordermap.clear();
						new CoffeeOrder(); //�ʱ�ȭ�ϰ� ó��ȭ������ ���ư���
						dispose();
					}
				});
			}
		}

		
		setVisible(true);
	}
	

	private Connection makeConnection() {
		Connection con=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="semiprj";
		String pass="123456";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,id,pass);
			System.out.println("���Ἲ��");
			
		} catch (Exception e) {
			System.out.println("�������");
		}
		
		return con;
	}
}
