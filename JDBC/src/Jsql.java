
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.Statement;
import java.util.Scanner;

class Jsql 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		String url="jdbc:oracle:thin:@//localhost:1521/XE";
		String un="system";
		String pwd="system";
		ResultSet res=null;
		String a=null;
		String b=null;
		int c=0;
		int d=0;
		int f=0;
		float g=0.0f;
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded successfully");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("unable to load the dreiver");
		}

		
		try
		{
			con=DriverManager.getConnection(url,un,pwd);
			System.out.println("connection established successfully");
		}
		catch(Exception e)
		{
			System.out.println("unable to establish connection");
		}
		
		
		/*try				//Create the statement
		{
			stmt=con.createStatement();
			res=stmt.executeQuery("Select * from Feb_Batch");
			System.out.println("executed");
		}
		catch(Exception e) 
		{
			System.out.println("unable to execute query");
		}*/
		
		
		try				//prepareStatement
		{
			pstmt=con.prepareStatement("SELECT * FROM FEB_BATCH WHERE USN=?");
			Scanner s=new Scanner(System.in);
			String str=s.nextLine();
			pstmt.setString(1,str);
			res=pstmt.executeQuery();
			System.out.println("Query executed successfuly");
		}
		catch(Exception e) 
		{
			System.out.println("unable to execute query");
		}
		
		
		/*try
		{
			pstmt=con.prepareStatement("Insert into Feb_Batch values(?,?,?,?,?,?)");
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the USN;");
			a=s.nextLine();
			System.out.println("Enter the NAME;");
			b=s.nextLine();
			System.out.println("Enter the MARKS_1:");
			c=s.nextInt();
			System.out.println("Enter the MARKS_2;");
			d=s.nextInt();
			System.out.println("Enter the MARKS_3;");
			f=s.nextInt();
			System.out.println("Enter the AVG;");
			g=s.nextFloat();
			pstmt.setString(1,a);
			pstmt.setString(2,b);
			pstmt.setInt(3,c);
			pstmt.setInt(4,d);
			pstmt.setInt(5,f);
			pstmt.setFloat(6,g);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Unable to execute");
		}*/
		
		try
		{		
			while(res.next()==true)
			{
				a=res.getString("USN");
				b=res.getString("NAME");
				c=res.getInt("MARKS_1");
				d=res.getInt("MARKS_2");
				f=res.getInt("MARKS_3");
				g=res.getFloat("AVG");
				System.out.println(a+" "+b+" "+c+" "+d+" "+f+" "+g);
			}
		}
		catch(Exception e)
		{
			System.out.println("unable to print result set");
		}
	}
}
