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
	String[] oc_strButton = { "돌아가기","결제하기" };
	
	public OrderConfirmation() { //세부내역 확인하기
		setTitle("주문확인");
		setLayout(new BorderLayout());
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		oc_panels = new JPanel[oc_strPanel.length];
		oc_buttons = new JButton[oc_strButton.length];
		
		checkLabel=new JLabel("주문 세부내역을 다시 한번 확인하여 주세요");
		checkLabel.setFont(new Font("맑은고딕", Font.BOLD,18));
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
					oc_buttons[j].setFont(new Font("맑은고딕",Font.BOLD,15));
					oc_buttons[j].setForeground(Color.white);
					oc_buttons[j].setBorderPainted(false);
					
					if(oc_strButton[j]=="돌아가기") {
						oc_buttons[j].setBackground(Color.black);
						oc_buttons[j].addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								co.ordermap.clear();
								new CoffeeOrder(); //초기화하고 처음화면으로 돌아가기
								dispose();
							}
						});
					}else { //결제하기
						oc_buttons[j].setBackground(new Color(243,156,18));
						oc_buttons[j].addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								System.out.println("결제하기 클릭");
								
								String orderStr="";
								for (Entry<String,Integer> entry : co.ordermap.entrySet()) {
							         System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
							         
							         if(entry.getKey()=="(HOT)아메리카노") {
							            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 1500원\t    \t총액 : "+(1500*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="(HOT)카 페 모 카") {
							            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 3700원\t    \t총액 : "+(3700*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="(HOT)바닐라라떼") {
							            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 3700원\t    \t총액 : "+(3700*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="(HOT)티라미수라떼") {
							            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 3900원\t    \t총액 : "+(3900*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="(ICE)아메리카노") {
							            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 2000원\t    \t총액 : "+(2000*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="(ICE)헤이즐넛라떼") {
							            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 3200원\t    \t총액 : "+(3200*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="(ICE)콜드브루라떼") {
							            orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 3800원\t    \t총액 : "+(3800*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="허니브레드\t") {
								        orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 4500원\t    \t총액 : "+(4500*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="말차 스모어 쿠키") {
								        orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 2900원\t    \t총액 : "+(2900*entry.getValue())+"원    "+"\n";
							         }
							         if(entry.getKey()=="아이스크림크로플") {
								        orderStr=orderStr+entry.getKey()+"  "+entry.getValue()+"개\t 3000원\t    \t총액 : "+(3000*entry.getValue())+"원    "+"\n";
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
			System.out.println("연결성공");
			
		} catch (Exception e) {
			System.out.println("연결실패");
		}
		
		return con;
	}
}
