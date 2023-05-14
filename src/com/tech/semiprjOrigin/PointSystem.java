package com.tech.semiprjOrigin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PointSystem extends JFrame{
	JPanel topPanel, pointLabelPanel, btnPanel, Panel1;
	JLabel pointCheckLabel, dywPoint;
	JButton noBtn, yesBtn;
	
	
	public PointSystem() {
		setTitle("����Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,250);
		setVisible(true);
		
		topPanel=new JPanel();
		topPanel.setBackground(new Color(248, 101, 12));
		pointLabelPanel=new JPanel();
		pointLabelPanel.setOpaque(false);
		btnPanel=new JPanel();
		btnPanel.setOpaque(false);
		Panel1=new JPanel(new BorderLayout());
		Panel1.setBackground(new Color(255,255,255));
		
//		pointCheck=new JLabel("����Ʈ ������ ���Ͻø� \"����\" ������ �����ø� \"��������\"��ư�� ��������");
		pointCheckLabel=new JLabel("����Ʈ ����");
		pointCheckLabel.setFont(new Font("�������", Font.BOLD,18));
		pointCheckLabel.setForeground(new Color(255,255,255));

		dywPoint=new JLabel("����Ʈ ������ �����Ͻðڽ��ϱ�?");
		dywPoint.setHorizontalAlignment(JLabel.CENTER); //�� ����
		dywPoint.setFont(new Font("�������", Font.BOLD,15));
		dywPoint.setForeground(new Color(51,51,51));
		
		yesBtn=new JButton("��");
		yesBtn.setPreferredSize(new Dimension(80,50));
		yesBtn.setForeground(new Color(255,255,255));
		yesBtn.setBackground(new Color(0,0,0));
		noBtn=new JButton("�ƴϿ�");
		noBtn.setPreferredSize(new Dimension(80,50));
		noBtn.setForeground(new Color(255,255,255));
		noBtn.setBackground(new Color(243, 156, 18));

		
//		��ư Ŭ�� �� �̺�Ʈ ó��
		noBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CompletePayment();
				dispose();
			}
		});
		
		
		
		
		topPanel.add(pointCheckLabel);
		pointLabelPanel.add(dywPoint);
		btnPanel.add(yesBtn);
		btnPanel.add(noBtn);
		
		Panel1.add(topPanel,BorderLayout.NORTH);
		Panel1.add(pointLabelPanel,BorderLayout.CENTER);
		Panel1.add(btnPanel,BorderLayout.SOUTH);
		add(Panel1);
		
	}
}
