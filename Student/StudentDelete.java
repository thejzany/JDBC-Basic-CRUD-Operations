import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDelete {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/mb";
		String username ="root";
		String password ="root";
		String sql = "DELETE FROM student WHERE ID=5";
		Connection connection=null;
		
		//STEP1: LOAD/REGISTER THE DRIVE 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//STEP2: ESTABLISH CONNECTION
			connection = DriverManager.getConnection(url, username, password);
			
			//STEP3: ESTABLISH STATEMENT
			Statement statement = connection.createStatement();
			
			//STEP4: EXECUTE STATEMENT 
			statement.execute(sql);
			
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

