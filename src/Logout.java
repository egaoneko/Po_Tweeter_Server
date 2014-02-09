/*
 * ���α׷� �̸� : Po Tweeter
 * ���� : Version 0.9
 * ���ϸ� : Logout.java
 * ���� : �α׾ƿ� (mySql)
 * ���� ���� ��¥ : 14.02.09
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Logout {
	
	public static boolean logoutCheck(String c_id) {
		 Connection conn;
		 boolean check=false;
	      try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
	
				String sql;
				sql = "update member set log='logout' where id=?;";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql); //�� �˻��� ��ȭ�ϴ� ���� �˻��ϱ� ���� PreparedStatement Ŭ����
				// �α׾ƿ��� �α���üũ�� ������Ʈ ��Ŵ.
				pstmt = conn.prepareStatement(sql); // �� �˻��� ��ȭ�ϴ� ���� �˻��ϱ� ���� PreparedStatement Ŭ����
				pstmt.setString(1, c_id); // �������� ��ȭ�ϴ� ���� ���� ���� �����ϴ� ���� �����̸� setInt(index,����) �̷� ������ �ϸ��.
				int rs = pstmt.executeUpdate();
				
				if(rs==1)
					return check=true;
				
				String date=Date.getdateS();
				sql = "update member set date=? where id=?;";
				pstmt = conn.prepareStatement(sql); // �� �˻��� ��ȭ�ϴ� ���� �˻��ϱ� ���� PreparedStatement Ŭ����
				pstmt.setString(1, date); // �������� ��ȭ�ϴ� ���� ���� ���� �����ϴ� ���� �����̸� setInt(index,����) �̷� ������ �ϸ��.
				pstmt.setString(2, c_id); // �������� ��ȭ�ϴ� ���� ���� ���� �����ϴ� ���� �����̸� setInt(index,����) �̷� ������ �ϸ��.
				pstmt.executeUpdate();
				
				
				conn.close(); // ���� ����
	      }
	      catch(Exception e )
	      {
	          System.out.println("DB���� ���� "+e);
	      }
	      return check;
	}
	
	public static boolean offline(String c_id) {
		 Connection conn;
		 boolean check=false;
	      try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
	
				String sql;
				sql = "update member set log='logoff' where id=?;";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql); //�� �˻��� ��ȭ�ϴ� ���� �˻��ϱ� ���� PreparedStatement Ŭ����
				// �α׾ƿ��� �α���üũ�� ������Ʈ ��Ŵ.
				pstmt = conn.prepareStatement(sql); // �� �˻��� ��ȭ�ϴ� ���� �˻��ϱ� ���� PreparedStatement Ŭ����
				pstmt.setString(1, c_id); // �������� ��ȭ�ϴ� ���� ���� ���� �����ϴ� ���� �����̸� setInt(index,����) �̷� ������ �ϸ��.
				int rs = pstmt.executeUpdate();
				
				if(rs==1)
					return check=true;
				
				conn.close(); // ���� ����
	      }
	      catch(Exception e )
	      {
	          System.out.println("DB���� ���� "+e);
	      }
	      return check;
	}
	
	public static boolean online(String c_id) {
		 Connection conn;
		 boolean check=false;
	      try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
	
				String sql;
				sql = "update member set log='login' where id=?;";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql); //�� �˻��� ��ȭ�ϴ� ���� �˻��ϱ� ���� PreparedStatement Ŭ����
				// �α׾ƿ��� �α���üũ�� ������Ʈ ��Ŵ.
				pstmt = conn.prepareStatement(sql); // �� �˻��� ��ȭ�ϴ� ���� �˻��ϱ� ���� PreparedStatement Ŭ����
				pstmt.setString(1, c_id); // �������� ��ȭ�ϴ� ���� ���� ���� �����ϴ� ���� �����̸� setInt(index,����) �̷� ������ �ϸ��.
				int rs = pstmt.executeUpdate();
				
				if(rs==1)
					return check=true;
				
				conn.close(); // ���� ����
	      }
	      catch(Exception e )
	      {
	          System.out.println("DB���� ���� "+e);
	      }
	      return check;
	}
}

