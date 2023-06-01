package com.tech.semiprjOrigin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OrderConfirmation extends JFrame{
	
	Connection cn;
	
	JButton prevBtn, orderBtn;
	JPanel topP, centerP, downP;
	JLabel checkLabel, imageLabel;
	JTextArea totalAmount;
	
	CoffeeHot ch;
	CoffeeOrder co;
	
	String name;
	
	public OrderConfirmation() { //���γ��� Ȯ���ϱ�
		setTitle("�ֹ�Ȯ��");
		setLayout(new BorderLayout());
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		topP=new JPanel();
		topP.setBackground(new Color(248, 101, 12));
		centerP=new JPanel();
		downP=new JPanel();
		
		checkLabel=new JLabel("�ֹ� ���γ����� �ٽ� �ѹ� Ȯ���Ͽ� �ּ���");
		checkLabel.setFont(new Font("�������", Font.BOLD,18));
		checkLabel.setForeground(new Color(255,255,255));
		topP.add(checkLabel);
		
		
//		�Ѱ����ݾ� ǥ��â
		totalAmount=new JTextArea(15,45);
		totalAmount.setEditable(false);
		centerP.add(totalAmount);
		
//		prevBtn��ư
		prevBtn=new JButton("���ư���");
		prevBtn.setPreferredSize(new Dimension(100,50));
		prevBtn.setFont(new Font("�������", Font.BOLD,15));
		prevBtn.setForeground(new Color(255,255,255));
		prevBtn.setBackground(new Color(0,0,0));
		prevBtn.setBorderPainted(false);
		
		prevBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				co.ordermap.clear();
				new CoffeeOrder(); //�ʱ�ȭ�ϰ� ó��ȭ������ ���ư���
				dispose();
			}
		});
		
//		order��ư
		orderBtn=new JButton("�����ϱ�");
		orderBtn.setPreferredSize(new Dimension(100,50));
		orderBtn.setFont(new Font("�������", Font.BOLD,15));
		orderBtn.setForeground(new Color(255,255,255));
		orderBtn.setBackground(new Color(243, 156, 18));
		orderBtn.setBorderPainted(false);
		
		
		orderBtn.addActionListener(new ActionListener() {
			
//		�����ϱ� ��ư �̺�Ʈó��
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�����ϱ� Ŭ��");
				
				String orderStr="";
				for (Entry<String,Integer> entry : co.ordermap.entrySet()) {
			         System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
			         
			         if(entry.getKey()=="(HOT)�Ƹ޸�ī��") {
			            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 1500��\t    \t�Ѿ� : "+(1500*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="(HOT)ī �� �� ī") {
			            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 3700��\t    \t�Ѿ� : "+(3700*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="(HOT)�ٴҶ��") {
			            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 3700��\t    \t�Ѿ� : "+(3700*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="(HOT)Ƽ��̼���") {
			            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 3900��\t    \t�Ѿ� : "+(3900*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="(ICE)�Ƹ޸�ī��") {
			            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 2000��\t    \t�Ѿ� : "+(2000*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="(ICE)������Ӷ�") {
			            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 3200��\t    \t�Ѿ� : "+(3200*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="(ICE)�ݵ����") {
			            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 3800��\t    \t�Ѿ� : "+(3800*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="��Ϻ극��\t") {
				        orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 4500��\t    \t�Ѿ� : "+(4500*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="���� ����� ��Ű") {
				        orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 2900��\t    \t�Ѿ� : "+(2900*entry.getValue())+"��    "+"\n";
			         }
			         if(entry.getKey()=="���̽�ũ��ũ����") {
				        orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"��\t 3000��\t    \t�Ѿ� : "+(3000*entry.getValue())+"��    "+"\n";
			         }
				}
				cn=makeConnection();
				Statement stmt;
				String receiptSql="insert into coffeereceipt values(order_SEQ.NEXTVAL,'"+orderStr+"')";
				try {
					stmt=cn.createStatement();
					stmt.executeUpdate(receiptSql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				CompletePayment cp=new CompletePayment();
				dispose();
				
				ResultSet rs;
				
				String JFwaitingNumbersql = "select max(order_no) from coffeereceipt";
				try {
					stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//					int no=stmt.executeUpdate("select * from coffeereceipt");
					rs = stmt.executeQuery(JFwaitingNumbersql);
					rs.next();
					cp.JFwaitingNumber.setText("" + rs.getInt("max(order_no)"));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		downP.add(prevBtn);
		downP.add(orderBtn);
		
		add(topP,BorderLayout.NORTH);
		add(centerP,BorderLayout.CENTER);
		add(downP,BorderLayout.SOUTH);
		
		
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
