import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdate{
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/mb";
		String username ="root";
		String password ="root";
		String sql = "UPDATE student SET name ='JayS', mail='jays@mail.com' WHERE id=1";
		Connection connection=null;
		
		//STEP1: LOAD/REGISTER THE DRIVER
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//STEP2: ESTABLISH CONNECTION
			connection = DriverManager.getConnection(url, username, password);
			
			//STEP3: ESTABLISH STATEMENT
			Statement statement = connection.createStatement();
			
			//STEP4: EXECUTE STATEMENT 
			int a =statement.executeUpdate(sql);
			if(a>0) {
				System.out.println("Updated");
			}else {
				System.out.println("Not Updated");
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				}
		
		finally {
			//STEP5: CLOSE CONNECTION
			try {
				connection.close();
				System.out.println("All Good");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}	
}

