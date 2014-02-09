/*
 * 프로그램 이름 : Po Tweeter
 * 버전 : Version 0.9
 * 파일명 : Server.java
 * 설명 : 서버 본문
 * 최종 수정 날짜 : 14.02.09
 */


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Color;

public class Server extends JFrame {

	/* 설정 */
	private final static int PORT_NO=9353;
	public static  final String DBIP="localhost";
	
	/* UI */
	private JPanel contentPane;
	private JTextPane txtArea; // 클라이언트 및 서버 메시지 출력
	private JScrollPane txtAreaScroll;

	/* 소켓 */
	private ServerSocket socket; //서버소켓
	private Socket soc; // 연결소켓 

	/* 정보 */
	private Vector vc = new Vector(); // 연결된 사용자를 저장할 벡터
	
	/* 메뉴바 */
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenu mnStatus;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmUser;
	private JMenuItem mntmHelp;
	private JMenuItem mntmInfo;
	private JMenuItem mntmExit;
	private JMenuItem mntmUserOut;
	private JMenuItem mntmTodayLog;
	private JLabel lblCUser;
	private JMenu mnDeleteLog;
	private JMenuItem mntmAllLog;
	private JMenuItem mntmDatabase;
	
	public static void main(String[] args)
	{
		Server frame = new Server();
		frame.setVisible(true);
	}

	/* 생성자 */
	public Server() {
		setResizable(false);
		setTitle("Po Tweeter Server");
		
		try {
			File file = new File("log");
			if(!file.exists())
				file.mkdir();
			FileWriter fw = new FileWriter("log/log"+Date.getdateD()+".txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Date.getdateS());
			bw.newLine();			
			bw.close();
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		init(); // UI
		start();		
	}

	/* 화면구성 메소드 */
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 349);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
		int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
		this.setLocation(windowX-400, windowY);
		
		/* 메뉴바 */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		/* File */
		mnFile = new JMenu("File");
		mnFile.setIcon(new ImageIcon("icon/ui24/file3.png"));
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon("icon/ui24/folder-open.png"));
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon("icon/ui24/disk.png"));
		mnFile.add(mntmSave);
		
		mnDeleteLog = new JMenu("Delete Log");
		mnDeleteLog.setIcon(new ImageIcon("icon/ui24/remove.png"));
		mnFile.add(mnDeleteLog);
		
		mntmTodayLog = new JMenuItem("Today Log");
		mntmTodayLog.setIcon(new ImageIcon("icon/ui24/copy2.png"));
		mnDeleteLog.add(mntmTodayLog);
		
		
		mntmAllLog = new JMenuItem("All Log");
		mntmAllLog.setIcon(new ImageIcon("icon/ui24/drawer3.png"));
		mnDeleteLog.add(mntmAllLog);
		
		mnFile.addSeparator();
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon("icon/ui24/switch.png"));
		mnFile.add(mntmExit);
		
		/* Status */
		mnStatus = new JMenu("Status");
		mnStatus.setIcon(new ImageIcon("icon/ui24/stats.png"));
		menuBar.add(mnStatus);
		
		mntmUser = new JMenuItem("User");
		mntmUser.setIcon(new ImageIcon("icon/ui24/users.png"));
		mnStatus.add(mntmUser);
		
		mntmUserOut = new JMenuItem("User Out");
		mntmUserOut.setIcon(new ImageIcon("icon/ui24/hammer.png"));
		mnStatus.add(mntmUserOut);
		
		mntmDatabase = new JMenuItem("Database");
		mntmDatabase.setIcon(new ImageIcon("icon/ui24/table2.png"));
		mnStatus.add(mntmDatabase);
		
		/* Help */
		mnHelp = new JMenu("Help");
		mnHelp.setIcon(new ImageIcon("icon/ui24/book.png"));
		menuBar.add(mnHelp);
		
		mntmHelp = new JMenuItem("Help");
		mntmHelp.setIcon(new ImageIcon("icon/ui24/question.png"));
		mnHelp.add(mntmHelp);
		
		mntmInfo = new JMenuItem("Info");
		mntmInfo.setIcon(new ImageIcon("icon/ui24/info.png"));
		mnHelp.add(mntmInfo);
		
		/* UI */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtAreaScroll = new JScrollPane();		
		txtArea = new JTextPane();
		txtAreaScroll.setViewportView(txtArea);
		
		txtArea.setEditable(false);
		
		lblCUser = new JLabel();
		lblCUser.setBackground(new Color(255, 245, 238));
		lblCUser.setForeground(new Color(255, 0, 0));
		lblCUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCUser.setOpaque(true);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(txtAreaScroll, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
				.addComponent(lblCUser, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtAreaScroll, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCUser, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		server_start();
	}

	private void server_start() {
		try {
			socket = new ServerSocket(PORT_NO); // 서버가 포트 여는부분
						
			if(socket!=null) // socket 이 정상적으로 열렸을때
			{
			Connection();
			}
		} catch (IOException e) {
			txtArea.setText("Socket is used!!\n");
		}
	}

	/* 클라이언트 접속 메소드 */
	private void Connection() {

		Thread th = new Thread(new Runnable() { // 사용자 접속을 받을 스레드

			@Override
			public void run() {
				append("Wait user...\n");
				while (true) { // 사용자 접속을 계속해서 받기 위해 while문
					try {
						soc = socket.accept(); // accept가 일어나기 전까지는 무한 대기중
						append("User Access!!\n");

						UserInfo user = new UserInfo(soc, vc); // 연결된 소켓 정보는 금방 사라지므로, user 클래스 형태로 객체 생성
						                                      // 매개변수로 현재 연결된 소켓과, 벡터를 담아둔다
						vc.add(user); // 해당 벡터에 사용자 객체를 추가

						user.start(); // 만든 객체의 스레드 실행
						lblCUser.setText("Current User : "+vc.size());
					} catch (IOException e) {
						append("Accept Errer... !!\n");
					} 
				}
			}
		});
		th.start();
	}
	
	
	/* 유저 정보 클래스 */
	class UserInfo extends Thread {

		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;

		private Socket user_socket;
		private Vector user_vc;

		private String Nickname = null;
		private String IP=null;

		/* 생성자 */
		public UserInfo(Socket soc, Vector vc)
		{
			// 매개변수로 넘어온 자료 저장
			this.user_socket = soc;
			this.user_vc = vc;
			IP = soc.getInetAddress().getHostAddress();

			User_network();
		}

		/* 접속 알림 메소드 */
		public void User_network() {
			try {
				is = user_socket.getInputStream();
				dis = new DataInputStream(is);
				os = user_socket.getOutputStream();
				dos = new DataOutputStream(os);

				Nickname = dis.readUTF(); // 사용자의 닉네임 받는부분
				append("User ID : " +"[ " +Nickname+" ]"+"\n");
				
				send_Message("=Access Complete!!="); // 연결된 사용자에게 정상접속을 알림
				String str="===== Access!! =====";
				broad_cast(str); 

			} catch (Exception e) {
				append("Stream Setting Error\n");
			}

		}

		/* 메세지 처리 메소드 */
		public void InMessage(String str) {
			append("Message from "+"[ "+Nickname+" ]"+" : " + str+"\n");
			broad_cast(str);
		}

		/* 메세지 브로드캐스트 메소드 */
		public void broad_cast(String str) {
			for (int i = 0; i < user_vc.size(); i++) {
				UserInfo imsi = (UserInfo) user_vc.elementAt(i);
				imsi.send_Message("[ "+Nickname+" ]"+" : "+str);
			}
		}

		/* 메세지 전송 메소드 */
		public void send_Message(String str) {
			try {
				dos.writeUTF(str);
			} 
			catch (IOException e) {
				append("Message Send Error\n");	
			}
		}

		/* 스레드 정의 */
		public void run()
		{
			while (true) {
				try {	
					// 사용자에게 받는 메세지
					String msg = dis.readUTF();
					InMessage(msg);
				} 
				catch (IOException e) 
				{
					try {
						dos.close(); dis.close();
						user_socket.close();
						vc.removeElement( this ); // 에러가난 현재 객체를 벡터에서 지운다
						append(vc.size() +" : Current User\n");
						append("Return Resource from Out User\n");
						lblCUser.setText("Current User : "+vc.size());
						break;			
					} catch (Exception ee) {			
					}
				}
			}	
		}
	}
	
	/* 이벤트 지정 메소드 */
	public void start() {
		/* 메뉴바 이벤트 처리 */
		
		/* mnFile 이벤트 처리 */
		mntmOpen.addActionListener(new mntmOpenAction());
		mntmSave.addActionListener(new mntmSaveAction());
		mntmTodayLog.addActionListener(new mntmTodayLogAction());
		mntmAllLog.addActionListener(new mntmAllLogAction());
		mntmExit.addActionListener(new mntmExitAction(this));

		/* mnStatus 이벤트 처리 */
		mntmUser.addActionListener(new mntmUserAction());
		mntmUserOut.addActionListener(new mntmUserOutAction());
		mntmDatabase.addActionListener(new mntmDatabaseAction());


		/* mnHelp 이벤트 처리 */
		mntmHelp.addActionListener(new mntmHelpAction());
		mntmInfo.addActionListener(new mntmInfoAction());
	}
	
	/*
	 * 
	 * 메뉴바 이벤트 처리
	 * 
	 */
		
	/* 
	 * mnFile 이벤트 처리
	 */
	class mntmOpenAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmOpen ) 
			{
				Open open = new Open();
			}
		}
	}
	class mntmSaveAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmSave ) 
			{
				Save save = new Save(txtArea.getText());
			}
		}
	}
	class mntmTodayLogAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmTodayLog ) 
			{				
				int result = JOptionPane.showConfirmDialog(null, "If you press \"Yes\", you apply to cancel your membership and exit.","Member Leave",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION ){
					return;
				} else if(result == JOptionPane.YES_OPTION){
					File file = new File("log/log"+Date.getdateD()+".txt");
					
					if(file.exists())
						file.delete();
				}	
			}
		}
	}
	class mntmAllLogAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmAllLog ) 
			{
				int result = JOptionPane.showConfirmDialog(null, "If you press \"Yes\", you apply to cancel your membership and exit.","Member Leave",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION ){
					return;
				} else if(result == JOptionPane.YES_OPTION){
					File file = new File("log");
					File[] list = file.listFiles();
					
					for(int i=0; i<list.length;i++)
						list[i].delete();
				}		
			}
		}
	}
	class mntmExitAction implements ActionListener
	{
		JFrame frm;

		mntmExitAction(JFrame frm){
			this.frm=frm;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmExit ) 
			{
				int result = JOptionPane.showConfirmDialog(null, "If you press \"Yes\", you exit.","Member Leave",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION ){
					return;
				} else if(result == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		}
	}


	/*
	 * mnStatus 이벤트 처리
	 */
	class mntmUserAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmUser ) 
			{
				User user=new User();
			}
		}
	}
	
	class mntmUserOutAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmUserOut ) 
			{
				UserOutC UOC = new UserOutC();
			}
		}
	}
	
	class mntmDatabaseAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmDatabase ) 
			{
				OpenBrowser.openURL("http://"+DBIP+"/phpmyadmin");
			}
		}
	}

	/*
	 * mnHelp 이벤트 처리
	 */
	class mntmHelpAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmHelp ) 
			{
				Help hlp = new Help();
			}
		}
	}
	class mntmInfoAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mntmInfo ) 
			{
				Info info = new Info();
			}
		}
	}
	
	/* 입력 함수 */
	public void append(String s) {
		/* 저장 */
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter("log/log"+Date.getdateD()+".txt",true);
			bw = new BufferedWriter(fw);
			Document doc = txtArea.getDocument();
			doc.insertString(doc.getLength(), s, null);
			txtArea.setAutoscrolls(true);
			setEndline();
			bw.write(s);
			bw.newLine();
			bw.close();
		} catch (BadLocationException exc) {
			exc.printStackTrace();
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
	
	/* 이미지 입력 함수 */
	public void appendI(String filePath) {
		txtArea.insertComponent(new JLabel(new ImageIcon(filePath)));
		setEndIcon();
		append("\n");
	}
	
	/* 이미지 크기 조절 입력 함수 */
	public void appendI2(String filePath) {
		File file = new File(filePath);
		Image img=null;
		int weight,height;
		double dis;
		
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			append("Image File Open Error!!\n");
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
		setEndIcon();
		append("\n");
	}
	
	/* 이미지 입력 부가 함수 */
	private void setEndline() {
		txtArea.selectAll();
		//문장의 끝에 무조건 커서 이동하게 설정
		txtArea.setSelectionStart(txtArea.getSelectionEnd());
	}
	
	/* 이미지 입력 부가 함수 */
	private void setEndIcon() {
		setEndline();
		txtArea.replaceSelection("\n");
		setEndline();
	}
}
