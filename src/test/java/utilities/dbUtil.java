package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class dbUtil {


	public static void main(String args[]){  
		try{  
			List<HashMap<String, Object>> personsData = getdbrecordasList();
			
			System.out.println(personsData);
						
		}catch(Exception e){ System.out.println(e);}  

	}
	
	public static List<HashMap<String, Object>> getdbrecordasList() {
		List<HashMap<String, Object>> lhm = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			//DriverManager.registerDriver("com.mysql.jdbc.Driver");			
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/shridb","root","root$123");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Persons");  
			
			lhm = convertResultSetToList(rs);
			/*while(rs.next()) { 
				//System.out.println(rs.getInt(1)+",\t"+rs.getString(2)+",\t"+rs.getString(3)+",\t"+rs.getString(4)+",\t"+rs.getString(5));  
				System.out.println(rs.getString("LastName"));  
			}*/
			con.close();  
		}catch(Exception e){ System.out.println(e);} 
		
		return lhm;
	}
	
	
	public static List<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException {
	    
		ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
	    int columns = md.getColumnCount();
	    List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
	    
	    while (rs.next()) {
	        HashMap<String,Object> row = new HashMap<String, Object>(columns);
	        for(int i=1; i<=columns; ++i) {
	            row.put(md.getColumnName(i),rs.getObject(i));
	        }
	        list.add(row);
	    }

	    return list;
	}
	
}
