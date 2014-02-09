/*
 * 프로그램 이름 : Po Tweeter
 * 버전 : Version 0.9
 * 파일명 : User.java
 * 설명 : 유저 관리
 * 최종 수정 날짜 : 14.02.09
 */

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JRadioButton;

public class User extends JFrame {

	/* UI */
	private JPanel contentPane;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblPhoto;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtSearch;

	private JButton btnSearch;
	private JList list;
	private JScrollPane listscrollPane;
	private ButtonGroup g;
	private JTextField txtDay;
	
	private ButtonGroup group;
	private JRadioButton rdbtnDay;
	private JRadioButton rdbtnName;
	private JButton btnLogout;
	private JButton btnDelete;
	
	
	/* 생성자 */
	public User() {
		setTitle("Edit");
		setResizable(false);
		
		File file = new File("icon/profile");
		if(!file.exists())
			file.mkdir();
		
		init();
		start();
		txtSearch.requestFocus();
	}

	/* 화면구성 메소드 */
	private void init() {
		/* UI */
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 391);	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		this.setLocation(windowX-750, windowY);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("굴림", Font.BOLD, 12));
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setFont(new Font("굴림", Font.BOLD, 12));
		txtID.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("굴림", Font.BOLD, 12));
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("굴림", Font.BOLD, 12));
		txtName.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("굴림", Font.BOLD, 12));
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("굴림", Font.BOLD, 12));
		txtEmail.setColumns(10);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("굴림", Font.BOLD, 12));
		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setFont(new Font("굴림", Font.BOLD, 12));
		txtPhone.setColumns(10);
		
		lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("굴림", Font.BOLD, 14));
		lblPhoto.setBackground(new Color(255, 250, 250));
		lblPhoto.setOpaque(true);
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("굴림", Font.BOLD, 12));
		txtSearch.setColumns(10);
		
		txtDay = new JTextField();
		txtDay.setEditable(false);
		txtDay.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 12));
		
		String data[];
		data=Control_Data.outputListDay();
		list = new JList(data);
		listscrollPane = new JScrollPane(list);
		
		rdbtnDay = new JRadioButton("Day");
		rdbtnDay.setFont(new Font("굴림", Font.BOLD, 12));
		rdbtnDay.setSelected(true);
		rdbtnName = new JRadioButton("Name");
		rdbtnName.setFont(new Font("굴림", Font.BOLD, 12));
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("굴림", Font.BOLD, 12));
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("굴림", Font.BOLD, 12));
		
		group= new ButtonGroup();
		
		group.add(rdbtnDay);
		group.add(rdbtnName);
		
		
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(listscrollPane, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblPhone)
											.addComponent(lblEmail)
											.addComponent(lblName))
										.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
									.addGap(15)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtPhone, 152, 152, Short.MAX_VALUE)
										.addComponent(txtID, 152, 152, 152)
										.addComponent(txtName, 152, 152, 152)
										.addComponent(txtEmail, 152, 152, 152)))
								.addComponent(txtDay, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(1)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtnDay)
												.addComponent(rdbtnName)))
										.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
									.addComponent(lblPhoto, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
					.addGap(100))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblID))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhone))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(18)
					.addComponent(txtDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblPhoto, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogout)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)
							.addGap(9)
							.addComponent(rdbtnDay)
							.addGap(13)))
					.addGap(10))
				.addComponent(listscrollPane, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnName))
		);
		contentPane.setLayout(groupLayout);
		setVisible(true);
	}
	
	/* 이벤트 지정 메소드 */
	public void start() {
		btnSearch.addActionListener(new btnSearchAction());
		txtSearch.addActionListener(new txtSearchAction()); 
		rdbtnDay.addItemListener(new rdbtnDayItem());
		rdbtnName.addItemListener(new rdbtnNameItem());
		btnLogout.addActionListener(new btnLogoutAction());
		btnDelete.addActionListener(new btnDeleteAction());
		list.addListSelectionListener(new listListSelection());
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
				searchDate();
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
				searchDate();
			}
		}
	}
	
	/* 날짜 정렬 액션 이벤트 */
	class rdbtnDayItem implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == rdbtnDay) 
			{
				String data[];
				data=Control_Data.outputListDay();
				list.setListData(data);
			}
		}
	}
	
	/* 이름 정렬 액션 이벤트 */
	class rdbtnNameItem implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == rdbtnName) 
			{
				String data[];
				data=Control_Data.outputListName();
				list.setListData(data);
			}
		}
	}
	
	class btnLogoutAction implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnLogout) 
			{
				if(txtSearch.getText() == null || txtSearch.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Search blank is empty.","Warning",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				boolean bool = Logout.logoutCheck(txtSearch.getText());
				if(bool){
					JOptionPane.showMessageDialog(null, "Success!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "Fail!","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	class btnDeleteAction implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnDelete) 
			{
				if(txtSearch.getText() == null || txtSearch.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Search blank is empty.","Warning",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int result = JOptionPane.showConfirmDialog(null, "If you press \"Yes\", this user apply to cancel your membership and exit.","Member Leave",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION ){
					return;
				} else if(result == JOptionPane.YES_OPTION){
					boolean flag=Control_Data.delID(txtSearch.getText());
					if(flag)
						JOptionPane.showMessageDialog(null, "Removing user( "+txtSearch.getText()+" ) success!","Message",JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Removing user( "+txtSearch.getText()+" ) fail!","Warning",JOptionPane.ERROR_MESSAGE);
					txtID.setText(""); txtName.setText(""); txtEmail.setText(""); txtPhone.setText(""); txtDay.setText("");txtSearch.setText("");
				}
			}
		}
	}
	
	class listListSelection implements ListSelectionListener
	{	
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == list ) 
			{
				searchDateList(list.getSelectedValue().toString());
			}
		}
	}
	
	public void searchDate(){
		txtID.setText(""); txtName.setText(""); txtEmail.setText(""); txtPhone.setText(""); txtDay.setText("");
		lblPhoto.setText("Photo");lblPhoto.setIcon(null);
		
		String data[];
		if(!Control_Data.isSameID(txtSearch.getText())){
			JOptionPane.showMessageDialog(null, "There is't same ID.","Warning",JOptionPane.ERROR_MESSAGE);
			return;
		}
		data=Control_Data.outputID2(txtSearch.getText());
		txtID.setText(data[0]);
		txtName.setText(data[1]);
		txtEmail.setText(data[2]);
		txtPhone.setText(data[3]);
		txtDay.setText(data[4]);
		
		String path;
		path=Control_Data.outputImage(txtSearch.getText());
		lblPhoto.setText("");
		lblPhoto.setIcon(new ImageIcon(path));	
	}
	
	public void searchDateList(String str){
		txtID.setText(""); txtName.setText(""); txtEmail.setText(""); txtPhone.setText(""); txtDay.setText("");
		lblPhoto.setText("Photo");lblPhoto.setIcon(null);
		
		String data[];
		if(!Control_Data.isSameID(str)){
			JOptionPane.showMessageDialog(null, "There is't same ID.","Warning",JOptionPane.ERROR_MESSAGE);
			return;
		}
		txtSearch.setText(str);
		
		data=Control_Data.outputID2(str);
		txtID.setText(data[0]);
		txtName.setText(data[1]);
		txtEmail.setText(data[2]);
		txtPhone.setText(data[3]);
		txtDay.setText(data[4]);
		
		String path;
		path=Control_Data.outputImage(str);
		lblPhoto.setText("");
		lblPhoto.setIcon(new ImageIcon(path));
	}
}
