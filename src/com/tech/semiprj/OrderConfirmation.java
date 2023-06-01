package com.tech.semiprj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OrderConfirmation extends JFrame {
	
	Connection cn;
	JTextArea totalAmount;
	CoffeeOrder co;

	JButton[] oc_buttons;
	JPanel[] oc_panels;
	JLabel checkLabel;
	String[] oc_strPanel = { "topP","centerP","downP" };
	String[] oc_strButton = { "���ư���","�����ϱ�" };
	
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

			if(oc_strPanel[i]=="topP") {
				oc_panels[i].setBackground(new Color(248, 101, 12));
				oc_panels[i].add(checkLabel);
				add(oc_panels[i],BorderLayout.NORTH);
			}else if(oc_strPanel[i]=="centerP") {
				oc_panels[i].add(totalAmount);
				add(oc_panels[i],BorderLayout.CENTER);
			}else if(oc_strPanel[i]=="downP") {
				add(oc_panels[i],BorderLayout.SOUTH);
				for (int j = 0; j < oc_strButton.length; j++) {
					oc_buttons[j] = new JButton(oc_strButton[j]);
					oc_buttons[j].setPreferredSize(new Dimension(100, 50));
					oc_buttons[j].setFont(new Font("�������",Font.BOLD,15));
					oc_buttons[j].setForeground(Color.white);
					oc_buttons[j].setBorderPainted(false);
					
					if(oc_strButton[j]=="���ư���") {
						oc_buttons[j].setBackground(Color.black);
						oc_buttons[j].addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								co.ordermap.clear();
								new CoffeeOrder(); //�ʱ�ȭ�ϰ� ó��ȭ������ ���ư���
								dispose();
							}
						});
					}else { //�����ϱ�
						oc_buttons[j].setBackground(new Color(243,156,18));
						oc_buttons[j].addActionListener(new ActionListener() {
							
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
								
								CompletePayment cp = new CompletePayment();
								dispose();
								
								ResultSet rs;
								
								String JFwaitingNumbersql = "select max(order_no) from coffeereceipt";
								try {
									stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//									int no=stmt.executeUpdate("select * from coffeereceipt");
									rs = stmt.executeQuery(JFwaitingNumbersql);
									rs.next();
									cp.JFwaitingNumber.setText("" + rs.getInt("max(order_no)"));
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							}
						});
					}
					oc_panels[i].add(oc_buttons[j]);
				}
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
