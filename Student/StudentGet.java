import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentGet {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/mb";
		String username ="root";
		String password ="root";
		String sql = "SELECT * FROM student WHERE id = 1";
		Connection connection=null;
		
		//STEP1: LOAD/REGISTER THE DRIVE 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//STEP2: ESTABLISH CONNECTION
			connection = DriverManager.getConnection(url, username, password);
			
			//STEP3: ESTABLISH STATEMENT
			Statement statement = connection.createStatement();
			
			//STEP4: EXECUTE STATEMENT 
			ResultSet resultSet= statement.executeQuery(sql);
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1)+" "+"| ");
				System.out.print(resultSet.getString(2)+" "+"| ");
				System.out.println(resultSet.getString(3)+" "+"| ");
				System.out.println("===========================");
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
