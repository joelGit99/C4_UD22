package AppMain.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import AppMain.conexion.Conexion;
import AppMain.dto.Cliente;

public class ClienteDao {
	
	public void registrarCliente(Cliente cliente) {
		Conexion conexion = new Conexion();
		
		try {
			Statement st = conexion.getConexion().createStatement();
			String sql = "INSERT INTO (nombre, apellido, direccion, dni, fecha) VALUES( " + cliente.getNombre() + ", "
						+ cliente.getApellido() + ", " + cliente.getDireccion() + ", " + cliente.getDni() + 
						", " + cliente.getFecha() + ");";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado el cliente exitosamente");
			st.close();
			conexion.closeConection();
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "No es ha podido registrar el cliente \n" + ex.getMessage());
		}
	}
	
	public Cliente buscarCliente(int codigo) {

		Conexion conex= new Conexion();
		Cliente cliente= new Cliente();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM persona where id = " + codigo;
			PreparedStatement consulta = conex.getConexion().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				cliente.setId(Integer.parseInt(res.getString("id")));
				cliente.setNombre(res.getString("nombre"));
				cliente.setApellido(res.getString("apellido"));
				cliente.setDireccion(res.getString("direccion"));
				cliente.setDni(Integer.parseInt(res.getString("dni")));
				cliente.setFecha(res.getString("fecha"));
			 }
			res.close();
			conex.closeConection();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return cliente;
			}
			else return null;

	}
	
	public void modificarCliente(String campoCambiar, String campoCambiado, int idCambiar) {
		Conexion conexion = new Conexion();
		try {
			Statement st = conexion.getConexion().createStatement();
			String query = "UPDATE clientes SET " + campoCambiar + "=" + campoCambiado + "WHERE id =" + idCambiar + ";";
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se ha actualizado el cliente correctamente");
			st.close();
			conexion.closeConection();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error actualizando el cliente " + e.getMessage());
		}
	}
	
	public void eliminarCliente(int idCambiar) {
		Conexion conexion = new Conexion();
		try {
			Statement st = conexion.getConexion().createStatement();
			String query = "DELETE FROM clientes WHERE id = " + idCambiar + ";";
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente correctamente");
			st.close();
			conexion.closeConection();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error eliminando el cliente " + e.getMessage());
		}
	}
}
