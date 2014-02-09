/*
 * 프로그램 이름 : Po Tweeter
 * 버전 : Version 0.9
 * 파일명 : UserOutC.java
 * 설명 : 유저 로그아웃 관리
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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JTextPane;

public class UserOutC extends JFrame {

	/* UI */
	private JPanel contentPane;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JLabel lblCheck;
	
	/* 생성자 */
	public UserOutC() {
		setTitle("UserOut");
		setResizable(false);
		init();
		start();
		txtSearch.requestFocus();
	}

	/* 화면구성 메소드 */
	private void init() {
		
		/* UI */
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 221, 133);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		this.setLocation(windowX-750, windowY);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 12));
		
		lblCheck = new JLabel();
		lblCheck.setBackground(new Color(255, 250, 240));
		lblCheck.setFont(new Font("굴림", Font.BOLD, 25));
		lblCheck.setOpaque(true);
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCheck, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
							.addComponent(btnSearch)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCheck, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(groupLayout);
		setVisible(true);
	}
	
	/* 이벤트 지정 메소드 */
	public void start() {
		btnSearch.addActionListener(new btnSearchAction());
		txtSearch.addActionListener(new txtSearchAction()); 
	}
	
	/* 검색 버튼 액션 이벤트 */
	class btnSearchAction implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSearch) 
			{
				if(txtSearch.getText() == null || txtSearch.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Search blank is empty.","Warning",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				boolean bool = Logout.logoutCheck(txtSearch.getText());
				if(bool){
					lblCheck.setForeground(new Color(135, 206, 250));
					lblCheck.setText("Success");
				}
				else{
					lblCheck.setForeground(new Color(255, 165, 0));
					lblCheck.setText("Fail");
				}
			}
		}
	}
	
	/* 검색 입력창 액션 이벤트 */
	class txtSearchAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == txtSearch) 
			{
				if(txtSearch.getText() == null || txtSearch.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Search blank is empty.","Warning",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				boolean bool = Logout.logoutCheck(txtSearch.getText());
				if(bool){
					lblCheck.setForeground(new Color(135, 206, 250));
					lblCheck.setText("Success");
				}
				else{
					lblCheck.setForeground(new Color(255, 165, 0));
					lblCheck.setText("Fail");
				}
			}
		}
	}
}
