package JavaAssignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Math;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Stream;
public class Assignment {
	public static void main(String Args[])  throws ClassNotFoundException, SQLException, IOException {
		
		FileOutputStream fout = new FileOutputStream("Random.txt");
		FileInputStream fin = new FileInputStream("Random.txt");
		
		int randomValue = 0;
		while(true){
			randomValue = (int)(Math.random()*100);
			System.out.println(randomValue);
			
			fout.write(randomValue);
			
			if(randomValue % 5 == 0)
				break;
			
		}

		fout.close();
		

		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		
		int c;
		while ((c = fin.read()) != -1) {
			arr.add(c);
		}
		System.out.println(arr);
		
		
		
		
		Integer num = arr.stream().filter(e -> e%5 == 0).map(e->e*2).reduce( 1 , (a,b) -> {return a*b;} );
		
		System.out.println(num);
		
		int id = num;
		
		String name ="Nikhil";
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";
		
		String username = "sMkXvyYxZM";
		String	passowrd = "8h9tWhCKws";
		
		Connection connection = DriverManager.getConnection(url, username, passowrd);
		
		String sql = "insert into test values (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);		
		preparedStatement.execute();
		
		ResultSet result = preparedStatement.executeQuery("select * from test");
		while(result.next()) {
		    String id1 = result.getString("id");
		    String name1 = result.getString("name");
		    System.out.println("Name,id - " + name1 + "," + id1); 
		}
		
		connection.close();
	}
}
