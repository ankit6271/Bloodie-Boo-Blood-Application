package Project1;
import java.sql.*;

//LOGIN USAGE CLASS

class Data {
    public String realpassword="";
    public String loginid="";
    public Data(String text) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsignin", "root", "anny");
        PreparedStatement st = con.prepareStatement("select emailid,pass from loginid where emailid=?");
        st.setString(1, text);
        ResultSet s=st.executeQuery();
        while(s.next()){
        	loginid=s.getString(1);
            realpassword=s.getString(2);
            System.out.println(realpassword);
        }
    }
    public String getPassword(){
        return realpassword;
    }
    public String getLoginid(){
        return loginid;
    }
}
//SIGNUP DATA ADDITION
class DataForSignup{
	int n;
	public DataForSignup(String userid,String emailid,String pass)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsignin", "root", "anny");
			PreparedStatement st=con.prepareStatement("insert into loginid(userid,emailid,pass) Values(?,?,?)");
			st.setString(1,userid);
			st.setString(2, emailid);
			st.setString(3, pass);
			n=st.executeUpdate();
			if(n==1) {
				System.out.println("Values inserted");
			}
			else {
				System.out.println("value not inserted");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	public int getN() {
		return n;
	}
}
//DONOR DATA UPLOADED CLASS
class Data2{
	int n;
	public Data2(String city,String contactnumber ,String name,String bloodgroup)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsignin", "root", "anny");
			PreparedStatement st=con.prepareStatement("insert into donor(name,bloodgroup,contactnumber,city) Values(?,?,?,?)");
			st.setString(1,name);
			st.setString(2, bloodgroup);
			st.setString(3,contactnumber);
			st.setString(4,city);
			n=st.executeUpdate();
			if(n==1) {
				System.out.println("Values inserted");
			}
			else {
				System.out.println("value not inserted");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public int getN() {
		return n;
	}
}
class DataToGetDatabaseEntry {
    String x[][]=new String[1000][4];
    public DataToGetDatabaseEntry(String bloodgroup) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsignin", "root", "anny");
        PreparedStatement st = con.prepareStatement("select id,name,contactnumber,city from donor where bloodgroup=?");
        st.setString(1, bloodgroup);
//        ResultSet s=st.executeQuery();
        ResultSet s=st.executeQuery();
        int p=0;
        while(s.next()){
    		x[p][0]=s.getString(1);
    		x[p][1]=s.getString(2);
            x[p][2]=s.getString(3);
            x[p][3]=s.getString(4);
            p++;

        }
    }
    
	public String[][] getArray(){
	    return x;
	}
}
class DataToGetIpAdd {
	String ip=null;
    public DataToGetIpAdd(String id) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsignin", "root", "anny");
        PreparedStatement st = con.prepareStatement("select ip from donor where id=?");
        st.setString(1, id);
        ResultSet s=st.executeQuery();
        while(s.next()){
    		ip=s.getString(1);
        }
    }
	public String getIp(){
	    return ip;
	}
}