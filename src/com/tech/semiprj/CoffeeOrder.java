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
//	필드구성
	Connection cn=null;
	
//	JFrame f;
	CoffeeHot ch;
	CoffeeIce ci;
	Dessert ds;
	OrderConfirmation oc;
	
	
	JTextArea checkOrder;
	JTextField totalCheckOrder;
	JPanel textPanel, cardPaymentPanel, leftPanel, rightPanel, bottomPanel;
	JButton cardPaymentBtn, resetBtn;
	JLabel creditCardLabel, cardPaymentLabel;


	static JTabbedPane pane;
	
	public CoffeeOrder() {
		
		setTitle("주문하기");
		setLayout(new BorderLayout());
		ch=new CoffeeHot();
		ci=new CoffeeIce();
		ds=new Dessert();
		
		pane=new JTabbedPane();
		pane.add("커피(HOT)",ch);
		pane.add("커피(ICE)",ci);
		pane.add("디저트",ds);
		
		textPanel=new JPanel();
		rightPanel=new JPanel(new BorderLayout());
		leftPanel=new JPanel();
		bottomPanel=new JPanel();
		
		
		cardPaymentLabel=new JLabel("주문하기");
		cardPaymentLabel.setFont(new Font("맑은고딕", Font.BOLD,22));
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
		cardPaymentBtn.setLayout(new GridLayout(0,2)); //카드이미지라벨, 주문하기 라벨 부착
		cardPaymentBtn.add(creditCardLabel);
		cardPaymentBtn.add(cardPaymentLabel);
		cardPaymentBtn.setPreferredSize(new Dimension(230,150));
		cardPaymentBtn.setBorderPainted(false);
		cardPaymentBtn.setBackground(new Color(248, 101, 12));
		
		resetBtn=new JButton("다시 담기");
		resetBtn.setPreferredSize(new Dimension(50,100)); //왜 위에 있는 버튼 가로길이를 따라갈까
		resetBtn.setForeground(new Color(255,255,255));
		resetBtn.setFont(new Font("맑은고딕", Font.BOLD,22));
		resetBtn.setBorderPainted(false);
		resetBtn.setBackground(new Color(0,0,0));
		
//		다시 담기 버튼 이벤트처리
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ordermap.clear();
				new MainCoffee();
				dispose();
			}
		});
		
		
//		주문하기 이벤트처리
		cardPaymentBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("주문하기 클릭");

				if (ordertotal==0) {
					JOptionPane.showMessageDialog(null, "제품을 선택하세요", "오류 메세지", JOptionPane.WARNING_MESSAGE);
				}else {
					String a=checkOrder.getText();
					System.out.println(a);
					
					OrderConfirmation oc=new OrderConfirmation();
					oc.totalAmount.setText(a);
					
//		insert처리
					String orderStr="";
					for (Entry<String,Integer> entry : ordermap.entrySet()) {
				         System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
				         
				         
				         if(entry.getKey()=="(HOT)아메리카노") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 1500원\t    \t총액 : "+(1500*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="(HOT)카페모카\t") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3700원\t    \t총액 : "+(3700*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="(HOT)바닐라라떼") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3700원\t    \t총액 : "+(3700*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="(HOT)티라미수라떼") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3900원\t    \t총액 : "+(3900*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="(ICE)아메리카노") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 2000원\t    \t총액 : "+(2000*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="(ICE)헤이즐넛라떼") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3200원\t    \t총액 : "+(3200*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="(ICE)콜드브루라떼") {
				            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3800원\t    \t총액 : "+(3800*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="(ICE)딸기쿠키프라페") {
				        	orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3900원\t    \t총액 : "+(3900*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="허니브레드\t") {
					        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 4500원\t    \t총액 : "+(4500*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="말차 스모어 쿠키") {
					        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 2900원\t    \t총액 : "+(2900*entry.getValue())+"원    "+"\n";
				         }
				         if(entry.getKey()=="아이스크림크로플") {
					        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3000원\t    \t총액 : "+(3000*entry.getValue())+"원    "+"\n";
				         }
				}
				
				dispose();
			}
			}
		});
		
		leftPanel.add(textPanel); //BorderLayout.EAST,WEST 상관없이 순서에 영향
		rightPanel.add(cardPaymentBtn,BorderLayout.NORTH);
		rightPanel.add(resetBtn,BorderLayout.SOUTH);
		bottomPanel.add(leftPanel);
		bottomPanel.add(rightPanel); //주문하기, 다시담기 버튼 부착
		add(pane,BorderLayout.NORTH);
		add(bottomPanel,BorderLayout.SOUTH);
//		add(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,550);
		setVisible(true);
		
		
		
//		actionlistener 부착
		for (int i = 0; i < ch.h_strNames.length; i++) {
			ch.hotBeverage_buttons[i].addActionListener(this);
		}

		for (int i = 0; i < ci.i_strNames.length; i++) {
			ci.iceBeverage_buttons[i].addActionListener(this);
		}
		
		for (int i = 0; i < ds.d_strNames.length; i++) {
			ds.desert_buttons[i].addActionListener(this);
		}		
	}

	
//	출력문
	static HashMap<String, Integer> ordermap=new HashMap<String, Integer>();
	int cnt1,cnt2,cnt3,cnt4,cnt5,cnt6,cnt7,cnt8,cnt9,cnt10,cnt11;
	int ordertotal; //필드니까 선언만하면 0으로 초기화
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < ch.h_strNames.length; i++) {
			if (e.getSource()==(ch.hotBeverage_buttons[i])) {
				if (ch.h_strNames[i]=="(HOT)아메리카노") {
					ordertotal+=1500;
			        ordermap.put("(HOT)아메리카노",++cnt1);
				}else if(ch.h_strNames[i]=="(HOT)카페모카") {
					ordertotal+=3700;
					ordermap.put("(HOT)카 페 모 카",++cnt2);
				}else if(ch.h_strNames[i]=="(HOT)바닐라라떼") {
					ordertotal+=3700;
			        ordermap.put("(HOT)바닐라라떼",++cnt3);
				}else if(ch.h_strNames[i]=="(HOT)티라미수라떼") {
					ordertotal+=3900;
			        ordermap.put("(HOT)티라미수라떼",++cnt4);
				}
			}
		}
		
		for (int i = 0; i < ci.i_strNames.length; i++) {
			if (e.getSource()==(ci.iceBeverage_buttons[i])) {
				if (ci.i_strNames[i]=="(ICE)아메리카노") {
//					System.out.println("(ICE)아메리카노입니다");
					ordertotal+=2000;
			        ordermap.put("(ICE)아메리카노",++cnt5);
				}else if(ci.i_strNames[i]=="(ICE)헤이즐넛라떼") {
					ordertotal+=3200;
					ordermap.put("(ICE)헤이즐넛라떼",++cnt6);
				}else if(ci.i_strNames[i]=="(ICE)콜드브루라떼") {
					ordertotal+=3800;
			        ordermap.put("(ICE)콜드브루라떼",++cnt7);
				}else if(ci.i_strNames[i]=="(ICE)딸기쿠키프라페") {
					ordertotal+=3900;
			        ordermap.put("(ICE)딸기쿠키프라페",++cnt11);
				}
			}
		}
		
		for (int i = 0; i < ds.d_strNames.length; i++) {
			if (e.getSource()==(ds.desert_buttons[i])) {
				if (ds.d_strNames[i]=="허니브레드") {
					ordertotal+=4500;
			        ordermap.put("허니브레드\t",++cnt8);
				}else if(ds.d_strNames[i]=="말차스모어쿠키") {
					ordertotal+=2900;
					ordermap.put("말차 스모어 쿠키",++cnt9);
				}else if(ds.d_strNames[i]=="아이스크림크로플") {
					ordertotal+=3000;
			        ordermap.put("아이스크림크로플",++cnt10);
				}
			}
		}

		String orderStr="";
	      
	      
	      for (Entry<String,Integer> entry : ordermap.entrySet()) {
	         System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
	         if(entry.getKey()=="(HOT)아메리카노")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 1500원\t\t총액 : "+(1500*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="(HOT)카 페 모 카")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3700원\t\t총액 : "+(3700*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="(HOT)바닐라라떼")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3700원\t\t총액 : "+(3700*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="(HOT)티라미수라떼")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3900원\t\t총액 : "+(3900*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="(ICE)아메리카노")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 2000원\t\t총액 : "+(2000*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="(ICE)헤이즐넛라떼")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3200원\t\t총액 : "+(3200*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="(ICE)콜드브루라떼")
	            orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3800원\t\t총액 : "+(3800*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="(ICE)딸기쿠키프라페")
	        	orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3900원\t\t총액 : "+(3900*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="허니브레드\t")
		        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 4500원\t\t총액 : "+(4500*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="말차 스모어 쿠키")
		        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 2900원\t\t총액 : "+(2900*entry.getValue())+"원"+"\n";
	         if(entry.getKey()=="아이스크림크로플")
		        orderStr=orderStr+entry.getKey()+"\t"+entry.getValue()+"개\t 3000원\t\t총액 : "+(3000*entry.getValue())+"원"+"\n";
	      }
	      checkOrder.setText(orderStr+"총액 : "+ordertotal);
	      
	
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
