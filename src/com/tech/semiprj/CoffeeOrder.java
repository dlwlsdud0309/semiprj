package com.tech.semiprj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import java.util.List;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class CoffeeOrder extends JFrame implements ActionListener{
//	�ʵ屸��
	Connection cn=null;
	
//	JFrame f;
	CoffeeHot ch;
	CoffeeIce ci;
	Dessert ds;
	PointSystem ps;
	OrderConfirmation oc;
	
	
	JTextArea checkOrder;
	JTextField totalCheckOrder;
	JPanel textPanel, cardPaymentPanel, leftPanel, rightPanel, bottomPanel;
	JButton cardPaymentBtn, resetBtn;
	JLabel creditCardLabel, cardPaymentLabel;

	
	
	
	static JTabbedPane pane;
	
	public CoffeeOrder() {
		
		
		setTitle("�ֹ��ϱ�");
		setLayout(new BorderLayout());
		ch=new CoffeeHot();
		ci=new CoffeeIce();
		ds=new Dessert();
		
		pane=new JTabbedPane();
		pane.add("Ŀ��(HOT)",ch);
		pane.add("Ŀ��(ICE)",ci);
		pane.add("����Ʈ",ds);
		
		textPanel=new JPanel();
		rightPanel=new JPanel(new BorderLayout());
		leftPanel=new JPanel();
		bottomPanel=new JPanel();
		
		
		cardPaymentLabel=new JLabel("�ֹ��ϱ�");
		cardPaymentLabel.setFont(new Font("�������", Font.BOLD,22));
		cardPaymentLabel.setForeground(new Color(255,255,255));
		
		ImageIcon h_ccChange=new ImageIcon("creditcardimage.png");
		Image h_ccChange2=h_ccChange.getImage();
		Image h_ccChange3=h_ccChange2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon creditCardImageIcon=new ImageIcon(h_ccChange3);
		JLabel creditCardLabel=new JLabel(creditCardImageIcon);
		
		
		checkOrder=new JTextArea(14,65);
		checkOrder.setEditable(false);
		JScrollPane scrollcheckOrder=new JScrollPane(checkOrder);
		textPanel.add(scrollcheckOrder);
		
		cardPaymentBtn=new JButton();
		cardPaymentBtn.setLayout(new GridLayout(0,2)); //ī���̹�����, �ֹ��ϱ� �� ����
		cardPaymentBtn.add(creditCardLabel);
		cardPaymentBtn.add(cardPaymentLabel);
		cardPaymentBtn.setPreferredSize(new Dimension(230,150));
		cardPaymentBtn.setBorderPainted(false);
		cardPaymentBtn.setBackground(new Color(248, 101, 12));
		
		resetBtn=new JButton("�ٽ� ���");
		resetBtn.setPreferredSize(new Dimension(50,100)); //�� ���� �ִ� ��ư ���α��̸� ���󰥱�
		resetBtn.setForeground(new Color(255,255,255));
		resetBtn.setFont(new Font("�������", Font.BOLD,22));
		resetBtn.setBorderPainted(false);
		resetBtn.setBackground(new Color(0,0,0));
		
//		�ٽ� ��� ��ư �̺�Ʈó��
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ordermap.clear();
				new MainCoffee();
				dispose();
			}
		});
		
		
//		�ֹ��ϱ� �̺�Ʈó��
		cardPaymentBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�ֹ��ϱ� Ŭ��");

				if (ordertotal==0) {
					JOptionPane.showMessageDialog(null, "��ǰ�� �����ϼ���", "���� �޼���", JOptionPane.WARNING_MESSAGE);
				}else {
					String a=checkOrder.getText();
					System.out.println(a);
					
					OrderConfirmation oc=new OrderConfirmation();
					oc.totalAmount.setText(a);
					
//		insertó��
					String orderStr="";
					for (Entry<String,Integer> entry : ordermap.entrySet()) {
				         System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
				         
				         
				         if(entry.getKey()=="(HOT)�Ƹ޸�ī��") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 1500��\t    \t�Ѿ� : "+(1500*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="(HOT)ī���ī\t") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3700��\t    \t�Ѿ� : "+(3700*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="(HOT)�ٴҶ��") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3700��\t    \t�Ѿ� : "+(3700*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="(HOT)Ƽ��̼���") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3900��\t    \t�Ѿ� : "+(3900*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="(ICE)�Ƹ޸�ī��") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 2000��\t    \t�Ѿ� : "+(2000*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="(ICE)������Ӷ�") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3200��\t    \t�Ѿ� : "+(3200*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="(ICE)�ݵ����") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3800��\t    \t�Ѿ� : "+(3800*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="��Ϻ극��\t") {
					        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 4500��\t    \t�Ѿ� : "+(4500*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="���� ����� ��Ű") {
					        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 2900��\t    \t�Ѿ� : "+(2900*entry.getValue())+"��    "+"\n";
				         }
				         if(entry.getKey()=="���̽�ũ��ũ����") {
					        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3000��\t    \t�Ѿ� : "+(3000*entry.getValue())+"��    "+"\n";
				         }
				}
				
				dispose();
			}
			}
		});
		
		leftPanel.add(textPanel); //BorderLayout.EAST,WEST ������� ������ ����
		rightPanel.add(cardPaymentBtn,BorderLayout.NORTH);
		rightPanel.add(resetBtn,BorderLayout.SOUTH);
		bottomPanel.add(leftPanel);
		bottomPanel.add(rightPanel); //�ֹ��ϱ�, �ٽô�� ��ư ����
		add(pane,BorderLayout.NORTH);
		add(bottomPanel,BorderLayout.SOUTH);
//		add(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,550);
		setVisible(true);
		
		
		
//		actionlistener ����
		ch.h_americanoBtn.addActionListener(this);
		ch.h_cafemochaBtn.addActionListener(this);
		ch.h_vanillalatteBtn.addActionListener(this);
		ch.h_tiramisulatteBtn.addActionListener(this);
//		ci.i_americanoBtn.addActionListener(this);
//		ci.i_hazelnutlatteBtn.addActionListener(this);
//		ci.i_coldbrewlatteBtn.addActionListener(this);
		ds.honeybreadBtn.addActionListener(this);
		ds.smorecookiesmatchaBtn.addActionListener(this);
		ds.icecreamcroiffleBtn.addActionListener(this);
		
	}

	
//	��¹�
	static HashMap<String, Integer> ordermap=new HashMap<String, Integer>();
	int cnt1,cnt2,cnt3,cnt4,cnt5,cnt6,cnt7,cnt8,cnt9,cnt10;
	int ordertotal; //�ʵ�ϱ� �����ϸ� 0���� �ʱ�ȭ
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource()==(ch.h_americanoBtn)) {
	         System.out.println("��ȣa");
	         ordertotal+=1500;
	         ordermap.put("(HOT)�Ƹ޸�ī��", ++cnt1);
	      }else if (e.getSource()==(ch.h_cafemochaBtn)) {
	         System.out.println("��ȣb");
	         ordertotal+=3700;
	         ordermap.put("(HOT)ī �� �� ī", ++cnt2);
	      }else if (e.getSource()==(ch.h_vanillalatteBtn)) {
	         System.out.println("��ȣc");
	         ordertotal+=3700;
	         ordermap.put("(HOT)�ٴҶ��", ++cnt3);
	      }else if(e.getSource()==(ch.h_tiramisulatteBtn)) {
	         ordertotal+=3900;
	         ordermap.put("(HOT)Ƽ��̼���",++cnt4);
//	      ���̽�
//	      }else if(e.getSource()==(ci.i_americanoBtn)) {
//	         ordertotal+=2000;
//	         ordermap.put("(ICE)�Ƹ޸�ī��",++cnt5);
//	      }else if(e.getSource()==(ci.i_hazelnutlatteBtn)) {
//	         ordertotal+=3200;
//	         ordermap.put("(ICE)������Ӷ�",++cnt6);
//	      }else if(e.getSource()==(ci.i_coldbrewlatteBtn)) {
//	         ordertotal+=3800;
//	         ordermap.put("(ICE)�ݵ����",++cnt7);
//	      ����Ʈ
	      } else if(e.getSource()==(ds.honeybreadBtn)) {
		     ordertotal+=4500;
		     ordermap.put("��Ϻ극��\t",++cnt8);
	      } else if(e.getSource()==(ds.smorecookiesmatchaBtn)) {
	    	 ordertotal+=2900;
		     ordermap.put("���� ����� ��Ű",++cnt9);
		  }	else if(e.getSource()==(ds.icecreamcroiffleBtn)) {
			 ordertotal+=3000;
			 ordermap.put("���̽�ũ��ũ����",++cnt10);
		  }
		
	      String orderStr="";
	      
	      
	      for (Entry<String,Integer> entry : ordermap.entrySet()) {
	         System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
	         if(entry.getKey()=="(HOT)�Ƹ޸�ī��")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 1500��\t\t�Ѿ� : "+(1500*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="(HOT)ī �� �� ī")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3700��\t\t�Ѿ� : "+(3700*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="(HOT)�ٴҶ��")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3700��\t\t�Ѿ� : "+(3700*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="(HOT)Ƽ��̼���")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3900��\t\t�Ѿ� : "+(3900*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="(ICE)�Ƹ޸�ī��")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 2000��\t\t�Ѿ� : "+(2000*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="(ICE)������Ӷ�")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3200��\t\t�Ѿ� : "+(3200*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="(ICE)�ݵ����")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3800��\t\t�Ѿ� : "+(3800*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="��Ϻ극��\t")
		        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 4500��\t\t�Ѿ� : "+(4500*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="���� ����� ��Ű")
		        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 2900��\t\t�Ѿ� : "+(2900*entry.getValue())+"��"+"\n";
	         if(entry.getKey()=="���̽�ũ��ũ����")
		        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"��\t 3000��\t\t�Ѿ� : "+(3000*entry.getValue())+"��"+"\n";
	      }
	      checkOrder.setText(orderStr+"�Ѿ� : "+ordertotal);
	      
	
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
