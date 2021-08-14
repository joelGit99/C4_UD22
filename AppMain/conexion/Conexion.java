package AppMain.conexion;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	static String bd = "c4_Ej1.";
	static String login = "remote";
	static String password = "Bootcamp2980.";
	static String url = "jdbc:mysql://localhost:3306/"+bd+"?useTimezone=true&serverTimezone=UTC";

	Connection conexion = null;

	public Conexion() {
		try{
			//obtenemos el driver de para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//obtenemos la conexion
			conexion = DriverManager.getConnection(url,login,password);

			if (conexion!=null){
				System.out.print("Conexión a base de datos "+bd+"_SUCCESS at");
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public Connection getConexion() {
		return conexion;
	}
	
	public void closeConection() {
		conexion = null;
	}
	
}
