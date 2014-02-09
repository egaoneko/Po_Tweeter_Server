/*
 * 프로그램 이름 : Po Tweeter
 * 버전 : Version 0.9
 * 파일명 : Save.java
 * 설명 : TXT 저장
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
import java.util.StringTokenizer;

import javax.swing.JTextPane;

public class Save extends JFrame {

	/* UI */
	private JPanel contentPane;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTextArea txtArea;
	
	/* 생성자 */
	public Save(String str) {
		setTitle("Save");
		setResizable(false);
		init();
		start();
		txtArea.append(str);
	}

	/* 화면구성 메소드 */
	private void init() {
		
		/* UI */
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 471);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		this.setLocation(windowX-700, windowY);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 12));
		
		JScrollPane txtAreaScroll = new JScrollPane();
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtAreaScroll.setViewportView(txtArea);
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(txtAreaScroll, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSearch)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtAreaScroll, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(groupLayout);
		setVisible(true);
	}
	
	/* 이벤트 지정 메소드 */
	public void start() {
		btnSearch.addActionListener(new btnSearchAction());
	}
	
	/* 취소 버튼 액션 이벤트 */
	class btnSearchAction implements ActionListener
	{
		JFileChooser chooser;
		
		btnSearchAction() {
			chooser = new JFileChooser();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSearch) 
			{
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT","txt");
				chooser.setFileFilter(filter);
				
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "You don't select a File!","Warning",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String filePath = chooser.getSelectedFile().getPath();
				
				if(!filePath.contains(".txt"))
					filePath=filePath+".txt";
				
				txtSearch.setText(filePath);
				
				File file = new File(filePath);
				
				try {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);// 필터 스트림
					String s = txtArea.getText();

					bw.write(s);
					bw.newLine();// 줄바꿈

					JOptionPane.showMessageDialog(null, "Success!","Message",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Fail!","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
