/*
 * 프로그램 이름 : Po Tweeter
 * 버전 : Version 0.9
 * 파일명 : Logout.java
 * 설명 : 로그아웃 (mySql)
 * 최종 수정 날짜 : 14.02.09
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
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql); //매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
				// 로그아웃시 로그인체크를 업데이트 시킴.
				pstmt = conn.prepareStatement(sql); // 매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
				pstmt.setString(1, c_id); // 동적으로 변화하는 값을 전달 만약 전달하는 값이 정수이면 setInt(index,정수) 이런 식으로 하면됨.
				int rs = pstmt.executeUpdate();
				
				if(rs==1)
					return check=true;
				
				String date=Date.getdateS();
				sql = "update member set date=? where id=?;";
				pstmt = conn.prepareStatement(sql); // 매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
				pstmt.setString(1, date); // 동적으로 변화하는 값을 전달 만약 전달하는 값이 정수이면 setInt(index,정수) 이런 식으로 하면됨.
				pstmt.setString(2, c_id); // 동적으로 변화하는 값을 전달 만약 전달하는 값이 정수이면 setInt(index,정수) 이런 식으로 하면됨.
				pstmt.executeUpdate();
				
				
				conn.close(); // 연결 끊기
	      }
	      catch(Exception e )
	      {
	          System.out.println("DB접속 오류 "+e);
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
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql); //매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
				// 로그아웃시 로그인체크를 업데이트 시킴.
				pstmt = conn.prepareStatement(sql); // 매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
				pstmt.setString(1, c_id); // 동적으로 변화하는 값을 전달 만약 전달하는 값이 정수이면 setInt(index,정수) 이런 식으로 하면됨.
				int rs = pstmt.executeUpdate();
				
				if(rs==1)
					return check=true;
				
				conn.close(); // 연결 끊기
	      }
	      catch(Exception e )
	      {
	          System.out.println("DB접속 오류 "+e);
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
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql); //매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
				// 로그아웃시 로그인체크를 업데이트 시킴.
				pstmt = conn.prepareStatement(sql); // 매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
				pstmt.setString(1, c_id); // 동적으로 변화하는 값을 전달 만약 전달하는 값이 정수이면 setInt(index,정수) 이런 식으로 하면됨.
				int rs = pstmt.executeUpdate();
				
				if(rs==1)
					return check=true;
				
				conn.close(); // 연결 끊기
	      }
	      catch(Exception e )
	      {
	          System.out.println("DB접속 오류 "+e);
	      }
	      return check;
	}
}

