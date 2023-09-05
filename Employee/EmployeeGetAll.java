package com.jsp.employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeGetAll {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/mb";
		String username ="root";
		String password ="root";
		String sql = "SELECT * FROM employee";
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, username, password);
			
			Statement statement = connection.createStatement();

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
			try {
				connection.close();
				System.out.println("All Good");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}	
}




