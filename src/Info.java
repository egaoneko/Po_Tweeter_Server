/*
 * 프로그램 이름 : Po Tweeter
 * 버전 : Version 0.9
 * 파일명 : Info.java
 * 설명 : 프로그램 정보
 * 최종 수정 날짜 : 14.02.09
 */

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JTextPane;

public class Info extends JFrame {

	/* UI */
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblInfo;
	private JTextArea textArea;
	private JLabel lblhidden;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn10;
	
	private boolean flag=false;
	private String text="\n  Po Tweeter. \n\n  Version: Beta Service Release 0.9 \n  Build id: 20140209\n  (c) Copyright Po Project Team and others\n  , 2014. All rights reserved.\n  Visit https://github.com/egaoneko";
	
	/* 생성자 */
	public Info() {
		setTitle("Info");
		setResizable(false);
		init();
		start();
	}

	/* 화면구성 메소드 */
	private void init() {
		
		/* UI */
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 376);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		this.setLocation(windowX-400, windowY);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblInfo = new JLabel("");
		lblInfo.setIcon(new ImageIcon("icon/info/po (1).JPG"));
		
		textArea = new JTextArea(text);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setEditable(false);
		
		btn1 = new JButton("");
		btn1.setIcon(new ImageIcon("icon/info/po (2).JPG"));
		btn1.setPressedIcon(new ImageIcon("icon/info/po (12).JPG"));
		
		btn2 = new JButton("");
		btn2.setIcon(new ImageIcon("icon/info/po (3).JPG"));
		btn2.setPressedIcon(new ImageIcon("icon/info/po (13).JPG"));
		
		btn3 = new JButton("");
		btn3.setIcon(new ImageIcon("icon/info/po (4).JPG"));
		btn3.setPressedIcon(new ImageIcon("icon/info/po (14).JPG"));
		
		btn4 = new JButton("");
		btn4.setIcon(new ImageIcon("icon/info/po (5).JPG"));
		btn4.setPressedIcon(new ImageIcon("icon/info/po (15).JPG"));
		
		btn5 = new JButton("");
		btn5.setIcon(new ImageIcon("icon/info/po (6).JPG"));
		btn5.setPressedIcon(new ImageIcon("icon/info/po (16).JPG"));
		
		btn6 = new JButton("");
		btn6.setIcon(new ImageIcon("icon/info/po (7).PNG"));
		
		btn7 = new JButton("");
		btn7.setIcon(new ImageIcon("icon/info/po (8).JPG"));
		
		btn8 = new JButton("");
		btn8.setIcon(new ImageIcon("icon/info/po (9).JPG"));
		
		btn9 = new JButton("");
		btn9.setIcon(new ImageIcon("icon/info/po (10).JPG"));
		
		btn10 = new JButton("");
		btn10.setIcon(new ImageIcon("icon/info/po (11).JPG"));
		
		lblhidden = new JLabel("");
		
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn10, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblhidden, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn10, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(17))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblhidden, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
							.addContainerGap())))
		);
		contentPane.setLayout(groupLayout);
		setVisible(true);
	}
	
	/* 이벤트 지정 메소드 */
	public void start() {
		lblInfo.addMouseListener(new lblInfoAction());
	}
	class lblInfoAction implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == lblInfo) 
			{
				if(flag){
					lblInfo.setIcon(new ImageIcon("icon/info/po (1).JPG"));
					lblhidden.setIcon(null);
					btn1.setIcon(new ImageIcon("icon/info/po (2).JPG"));
					btn2.setIcon(new ImageIcon("icon/info/po (3).JPG"));
					btn3.setIcon(new ImageIcon("icon/info/po (4).JPG"));
					btn4.setIcon(new ImageIcon("icon/info/po (5).JPG"));
					btn5.setIcon(new ImageIcon("icon/info/po (6).JPG"));
					btn6.setIcon(new ImageIcon("icon/info/po (7).PNG"));
					btn7.setIcon(new ImageIcon("icon/info/po (8).JPG"));
					btn8.setIcon(new ImageIcon("icon/info/po (9).JPG"));
					btn9.setIcon(new ImageIcon("icon/info/po (10).JPG"));
					btn10.setIcon(new ImageIcon("icon/info/po (11).JPG"));
					flag=false;
				}
				else{
					lblInfo.setIcon(new ImageIcon("icon/info/po (18).JPG"));
					lblhidden.setIcon(new ImageIcon("icon/info/po (23).PNG"));
					btn1.setIcon(new ImageIcon("icon/info/po (19).JPG"));
					btn2.setIcon(new ImageIcon("icon/info/po (20).JPG"));
					btn3.setIcon(new ImageIcon("icon/info/po (21).JPG"));
					btn4.setIcon(new ImageIcon("icon/info/po (22).JPG"));
					btn5.setIcon(new ImageIcon("icon/info/po (24).JPG"));
					btn6.setIcon(new ImageIcon("icon/info/po (25).PNG"));
					btn7.setIcon(new ImageIcon("icon/info/po (26).JPG"));
					btn8.setIcon(new ImageIcon("icon/info/po (27).JPG"));
					btn9.setIcon(new ImageIcon("icon/info/po (28).JPG"));
					btn10.setIcon(new ImageIcon("icon/info/po (29).JPG"));
					flag=true;
				}
			}	
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

	}
}
