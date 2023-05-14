package com.tech.semiprj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoffeeIce extends JPanel{
	JPanel[] iceBeverage_panel;
	JButton[] iceBeverage_buttons;
	JLabel[] iceBeverage_labelsNames, iceBeverage_labelsPrices, iceBeverage_imageLabel;
	String[] i_strNames = {
			"(ICE)�Ƹ޸�ī��", "(ICE)������� ��", "(ICE)�ݵ��� ��","(ICE)������Ű������" //,"(ICE)��������������
		};
	String[] i_strPrices = {
			"2000��", "3200��", "3800��","3900��" //,"3900��"
		};
	ImageIcon[] imageIconChange, iceBeverage_image;
	Image[] imageGetImage;
	
	public CoffeeIce() {
		setBackground(new Color(230, 230, 230));
//		setLayout(new GridLayout(0, 4, 10, 10));
		
		//������Ʈ
		iceBeverage_panel = new JPanel[i_strNames.length];
		iceBeverage_labelsNames = new JLabel[i_strNames.length];
		iceBeverage_labelsPrices = new JLabel[i_strNames.length];
		iceBeverage_buttons = new JButton[i_strNames.length];
		
		//�̹���
		imageIconChange = new ImageIcon[i_strNames.length];
		imageGetImage = new Image[i_strNames.length];
		iceBeverage_image = new ImageIcon[i_strNames.length];
		iceBeverage_imageLabel = new JLabel[i_strNames.length];

		for (int i = 0; i < i_strNames.length; i++) {
			//�ǳ�
			iceBeverage_panel[i] = new JPanel();
			iceBeverage_panel[i].setOpaque(false);
			iceBeverage_panel[i].setLayout(null);
			
			//��ư
//			iceBeverage_buttons[i] = new JButton(i_strNames[i]); //i_strNames[i]�� �ۼ��߱� ������ ��ư�� �̸�(��ǰ��)�� ���Դ� ��
			iceBeverage_buttons[i] = new JButton();
			iceBeverage_buttons[i].setPreferredSize(new Dimension(200, 200));
			
			//��name�� strNames ����
			iceBeverage_labelsNames[i] = new JLabel(i_strNames[i]);
			iceBeverage_labelsNames[i].setFont(new Font("�������", Font.BOLD, 15)); //��Ʈ ����
			iceBeverage_labelsNames[i].setForeground(new Color(51,51,51)); //�̸�ǥ��
//			iceBeverage_labelsNames[i].setBounds(0, 80, 150, 150);
//			iceBeverage_labelsNames[i].setHorizontalAlignment(JLabel.CENTER);
			
			if(i_strNames[i]==("(ICE)�Ƹ޸�ī��")) {
				iceBeverage_labelsNames[i].setBounds(25, 80, 150, 150);
			}else {
				iceBeverage_labelsNames[i].setBounds(15, 80, 150, 150);
			}
			
			//��prices�� strPrices ����
			iceBeverage_labelsPrices[i] = new JLabel(i_strPrices[i]);
			iceBeverage_labelsPrices[i].setFont(new Font("�������", Font.BOLD, 15));
			iceBeverage_labelsPrices[i].setForeground(new Color(192, 57, 43)); //����ǥ��
			iceBeverage_labelsPrices[i].setBounds(60, 100, 200, 150);
			
			//�̹��� ����
			imageIconChange[i] = new ImageIcon(i_strNames[i]+".png");
			imageGetImage[i] = imageIconChange[i].getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			iceBeverage_image[i] = new ImageIcon(imageGetImage[i]);
			iceBeverage_imageLabel[i] = new JLabel(iceBeverage_image[i]);
			iceBeverage_imageLabel[i].setBounds(35,5,100,140);
			
			
			iceBeverage_panel[i].add(iceBeverage_labelsNames[i]);
			iceBeverage_panel[i].add(iceBeverage_labelsPrices[i]);
			iceBeverage_panel[i].add(iceBeverage_imageLabel[i]);
			
			
			iceBeverage_buttons[i].add(iceBeverage_panel[i]);
			iceBeverage_buttons[i].setBorderPainted(false); //��ư�ܰ��� ����
			iceBeverage_buttons[i].setBackground(Color.white);
			iceBeverage_buttons[i].setFocusPainted(false); //��ư�� ���õǾ��� �� ����� �׵θ� ������
			
			add(iceBeverage_buttons[i]);
		}
	}
}
