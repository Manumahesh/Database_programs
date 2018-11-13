package p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class Model 
{
	private int marks1=0;
	private int marks2=0;
	private int marks3=0;
	private float avg=0.0f;
	private String Usn=null;
	private String Name=null;
	private Connection con=null;
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	private	String un="System";
	private String pwd="System";
	private PreparedStatement pstmt=null;
	private ResultSet res=null;
	
	
	
	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getMarks3() {
		return marks3;
	}

	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public String getUsn() {
		return Usn;
	}

	public void setUsn(String usn) {
		Usn = usn;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}



	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}



	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}



	public ResultSet getRes() {
		return res;
	}

	public void setRes(ResultSet res) {
		this.res = res;
	}
	
	
	public Model()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url, un, pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	boolean login()
	{
		try {
			pstmt=con.prepareStatement("Select * from Feb_Batch where USN=? and NAME=?");
			pstmt.setString(1, Usn);
			pstmt.setString(2, Name);
			res=pstmt.executeQuery();
			
			while(res.next())
			{
				Usn=res.getString(1);
				Name=res.getString(2);
				marks1=res.getInt(3);
				marks2=res.getInt(4);
				marks3=res.getInt(5);
				avg=res.getFloat(6);
				
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}
