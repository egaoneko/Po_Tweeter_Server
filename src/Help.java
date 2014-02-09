/*
 * 프로그램 이름 : Po Tweeter
 * 버전 : Version 0.9
 * 파일명 : Help.java
 * 설명 : 도움말
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JTextPane;



public class Help extends JFrame {

	/* UI */
	private JTabbedPane pane;
	private JPanel tabPane1;
	private JPanel tabPane2;
	private JPanel tabPane3;
	private JPanel tabPane4;

	private JTextPane txtArea1;
	private JTextPane txtArea2;
	private JTextPane txtArea3;
	private JTextPane txtArea4;
	
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;
	private JScrollPane scrollPane4;
	
	
	/* 생성자 */
	public Help() {
		setTitle("Help");
		setResizable(false);
		init();
		start();
	}

	/* 화면구성 메소드 */
	private void init() {
		
		/* UI */
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 332);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		this.setLocation(windowX+400, windowY);
		
		tabPane1 = new JPanel();
		tabPane2 = new JPanel();
		tabPane3 = new JPanel();
		tabPane4 = new JPanel();
		
		
		pane = new JTabbedPane();
		pane.setTabPlacement(JTabbedPane.BOTTOM);
		setContentPane(pane);
		pane.addTab("P1", tabPane1);
		
		scrollPane1 = new JScrollPane();
		txtArea1 = new JTextPane();
		txtArea1.setEditable(false);
		scrollPane1.setViewportView(txtArea1);
		appendI2("icon/help/SH_1.JPG",txtArea1);
		
		GroupLayout gl_tabPane1 = new GroupLayout(tabPane1);
		gl_tabPane1.setHorizontalGroup(
			gl_tabPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabPane1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_tabPane1.setVerticalGroup(
			gl_tabPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabPane1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addContainerGap())
		);
		tabPane1.setLayout(gl_tabPane1);
		
		pane.addTab("P2", tabPane2);
			
		scrollPane2 = new JScrollPane();
		txtArea2 = new JTextPane();
		txtArea2.setEditable(false);
		scrollPane2.setViewportView(txtArea2);
		appendI2("icon/help/SH_2.JPG",txtArea2);
		
		GroupLayout gl_tabPane2 = new GroupLayout(tabPane2);
		gl_tabPane2.setHorizontalGroup(
			gl_tabPane2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabPane2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_tabPane2.setVerticalGroup(
			gl_tabPane2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabPane2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		tabPane2.setLayout(gl_tabPane2);


		/* Tab 3 */
		pane.addTab("P3", tabPane3);
		
		scrollPane3 = new JScrollPane();
		txtArea3 = new JTextPane();
		txtArea3.setEditable(false);
		scrollPane3.setViewportView(txtArea3);
		appendI2("icon/help/SH_3.JPG",txtArea3);

		
		GroupLayout gl_tabPane3 = new GroupLayout(tabPane3);
		gl_tabPane3.setHorizontalGroup(
			gl_tabPane3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabPane3.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_tabPane3.setVerticalGroup(
			gl_tabPane3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabPane3.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		tabPane3.setLayout(gl_tabPane3);
		
		
		pane.addTab("P4", tabPane4);
		
		scrollPane4 = new JScrollPane();
		txtArea4 = new JTextPane();
		txtArea4.setEditable(false);
		scrollPane4.setViewportView(txtArea4);
		appendI2("icon/help/SH_4.JPG",txtArea4);
		
		GroupLayout gl_tabPane4 = new GroupLayout(tabPane4);
		gl_tabPane4.setHorizontalGroup(
			gl_tabPane4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabPane4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_tabPane4.setVerticalGroup(
			gl_tabPane4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabPane4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		tabPane4.setLayout(gl_tabPane4);
		
		
		setVisible(true);
	}
	
	/* 이벤트 지정 메소드 */
	public void start() {
	}
	
	/* 이미지 크기 조절 입력 함수 */
	public void appendI2(String filePath,JTextPane txtArea) {
		File file = new File(filePath);
		Image img=null;
		int weight,height;
		double dis;
		
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("Image File Open Error!!\n");
			return;
		}
		
		weight=img.getWidth(null);
		height=img.getHeight(null);
		
		while(true){
			if(weight<=330 && height<=450)
				break;
			if(weight>330){
				dis=(weight-330)/(double)weight;
				weight=330;
				height-=height*dis;
			}
			if(height>450){
				dis=(height-450)/(double)height;
				height=450;
				weight-=weight*dis;
			}
			
		}
		
		Image resizedImage = img.getScaledInstance(weight, height,  Image.SCALE_SMOOTH );
		txtArea.insertComponent(new JLabel(new ImageIcon(resizedImage)));
		setEndIcon(txtArea);
		append("\n",txtArea);
	}
	
	/* 입력 함수 */
	public void append(String s, JTextPane txtArea) {
		try {
			Document doc = txtArea.getDocument();
			doc.insertString(doc.getLength(), s, null);
			setEndline(txtArea);
		} catch (BadLocationException exc) {
			exc.printStackTrace();
		}
	}
	
	/* 이미지 입력 부가 함수 */
	private void setEndline(JTextPane txtArea) {
		txtArea.selectAll();
		//문장의 끝에 무조건 커서 이동하게 설정
		txtArea.setSelectionStart(txtArea.getSelectionEnd());
	}
	
	/* 이미지 입력 부가 함수 */
	private void setEndIcon(JTextPane txtArea) {
		setEndline(txtArea);
		txtArea.replaceSelection("\n");
		setEndline(txtArea);
	}
	
}

