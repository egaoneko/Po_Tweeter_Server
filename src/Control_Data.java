/*
 * 프로그램 이름 : Po Tweeter
 * 버전 : Version 0.9
 * 파일명 : Control_Data.java
 * 설명 : mySql 입출력
 * 최종 수정 날짜 : 14.02.09
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Control_Data {

	private static final int BUFFER_SIZE = 1024;

	public static void insertData(String c_id, String c_pw, String c_name, String c_email, String c_phone, String path) {
		String sql = "insert into member ( id, pw, name, email, phone, photo) values (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		FileInputStream fis = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			psmt.setString(2, c_pw);
			psmt.setString(3, c_name);
			psmt.setString(4, c_email);
			psmt.setString(5, c_phone);
			fis = new FileInputStream(path);
			psmt.setBinaryStream(6, fis);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/* DB 이미지 출력 */
	public static String outputImage(String c_id) {

		String sql = "select * from member where id=?";
		String path = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			InputStream is = (InputStream) rs.getBinaryStream("photo");
			fos = new FileOutputStream("icon/profile/"+c_id+".jpg");
			if(fos != null)
				path = "icon/profile/"+c_id+".jpg";
			byte[] b = new byte[BUFFER_SIZE];
			int n;
			while ((n = is.read(b)) > 0) {
				fos.write(b, 0, n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return path;
	}

	public static String[] outputID(String c_id) {

		String sql = "select * from member where id=?";
		String path = null;
		String data[]=null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			
			data=new String[4];
			
			data[0]=rs.getString("id");
            data[1]=rs.getString("name");
            data[2]=rs.getString("email"); 
            data[3]=rs.getString("phone"); 
            
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return data;
	}
	
	public static String[] outputID2(String c_id) {

		String sql = "select * from member where id=?";
		String path = null;
		String data[]=null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			
			data=new String[5];
			
			data[0]=rs.getString("id");
            data[1]=rs.getString("name");
            data[2]=rs.getString("email"); 
            data[3]=rs.getString("phone"); 
            data[4]=rs.getString("date"); 
            
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return data;
	}
	
	public static String[] outputID3(String c_id) {

		String sql = "select * from member where id=?";
		String path = null;
		String data[]=null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			
			data=new String[6];
			
			data[0]=rs.getString("id");
            data[1]=rs.getString("name");
            data[2]=rs.getString("email"); 
            data[3]=rs.getString("phone");
            data[4]=rs.getString("pw"); 
            data[5]=rs.getString("pw"); 
          
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return data;
	}
	
	public static boolean isSameID(String c_id) {
		
		Connection conn;
		boolean flag=false;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+Server.DBIP+":3306/po_tweeter","POMA","9353");
			
			String sql="select * from member where id=?"; //물음표에는 동적으로 변화하는 값을 넣기 위함
            java.sql.PreparedStatement pstmt=conn.prepareStatement(sql); //매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
            pstmt.setString(1, c_id); 
            java.sql.ResultSet result=pstmt.executeQuery();
            String logCh = null;
            
            String data;
            
            while (result.next()) {
				data = result.getString("id");
	
				if (data.equals(c_id)){ // ID와 검색한 ID가 동일할때
					flag=true;
					return flag;
				}
			}        
            conn.close(); //연결 끊기
		} catch (SQLException e) {
			System.out.println("DB Access Error!!"+e);
		} catch (ClassNotFoundException e) {
			// TODO 자동 생성된 catch 블록
			System.out.println("Driver Load Error!!"+e);
		}
		return flag;
	}
	
	
	/* DB 삭제 출력 */
	public static boolean delID(String c_id) {

		String sql = "delete from member where id=?";
		boolean flag=false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			int rs = psmt.executeUpdate();
			
			if(rs==1)
				return flag=true;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}  catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	public static String[] outputListName() {

		String sql = "select id from member order by id asc";
		String path = null;
		String data[]=null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			rs.last(); 
			int count = rs.getRow();
			rs.beforeFirst(); 
			
			data=new String[count];
			
			int i=0;
			while(rs.next())
            {
                data[i++]=rs.getString("id");
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return data;
	}
	
	public static String[] outputListDay() {

		String sql = "select id from member order by date desc";
		String path = null;
		String data[]=null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			rs.last(); 
			int count = rs.getRow();
			rs.beforeFirst(); 
			
			data=new String[count];
			
			int i=0;
			while(rs.next())
            {
                data[i++]=rs.getString("id");
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return data;
	}
	
	public static String[] outputListNameOnline() {

		String sql = "select id from member where log='login' order by id asc";
		String path = null;
		String data[]=null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			rs.last(); 
			int count = rs.getRow();
			rs.beforeFirst(); 
			
			data=new String[count];
			
			int i=0;
			while(rs.next())
            {
                data[i++]=rs.getString("id");
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return data;
	}
	
	public static String outputEmail(String c_id) {

		String sql = "select email from member where id=?";
		String data=null;

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			
			data=rs.getString("email"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return data;
	}
	
	public static void insertDataBug(String c_id, String c_email, String c_content) {
		String sql = "insert into bug ( id, email, content) values (?, ?, ?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			psmt.setString(2, c_email);
			psmt.setString(3, c_content);

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void insertDataEmail(String c_id, String c_email, String c_content) {
		String sql = "insert into quest ( id, email, content) values (?, ?, ?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			psmt.setString(2, c_email);
			psmt.setString(3, c_content);

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void changeData(String c_id,String c_pw, String c_name, String c_email, String c_phone, String path)
	{				
		Connection conn = null;
		FileInputStream fis = null;
		PreparedStatement psmt =null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			
			String sql = "update member set pw = ? where id =?";		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,c_pw); 
			psmt.setString(2, c_id); 
			psmt.executeUpdate();
			
			
			sql = "update member set name=? where id=?";
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, c_name); 
			psmt.setString(2, c_id); 
			psmt.executeUpdate();
			
			sql = "update member set email=? where id=?";
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, c_email); 
			psmt.setString(2, c_id); 
			psmt.executeUpdate();
			
			sql = "update member set phone=? where id=?";
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, c_phone); 
			psmt.setString(2, c_id); 
			psmt.executeUpdate();
			
			sql = "update member set photo=? where id=?";
			psmt = conn.prepareStatement(sql); 
			fis = new FileInputStream(path);
			psmt.setBinaryStream(1, fis);
			psmt.setString(2, c_id); 
			psmt.executeUpdate();

						
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/* DB File 입력 */
	public static String inputSFile(String c_id, String c_f_name, String c_file ) {

		String sql = "insert into file ( id, f_name, file) values (?, ?, ?)";
		String path = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileInputStream fis=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			psmt.setString(2, c_f_name);
			fis = new FileInputStream(c_file);
			psmt.setBinaryStream(3, fis);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return path;
	}
	
	/* DB File 출력 */
	public static String outputSFile(String c_id, String c_f_name) {

		String sql = "select * from file where id=? and f_name=?";
		String path = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		FileOutputStream fos = null;
		InputStream is=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + Server.DBIP + ":3306/po_tweeter", "POMA", "9353");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			psmt.setString(2, c_f_name);
			ResultSet rs = psmt.executeQuery();
			rs.last();
			is = (InputStream) rs.getBinaryStream("file");
			fos = new FileOutputStream("icon/data/"+c_f_name);
			if(fos != null)
				path = "icon/data/"+c_f_name;
			byte[] b = new byte[BUFFER_SIZE];
			int n;
			while ((n = is.read(b)) > 0) {
				fos.write(b, 0, n);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return path;
	}
}


