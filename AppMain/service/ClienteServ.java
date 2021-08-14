package AppMain.service;

import javax.swing.JOptionPane;


import AppMain.controllers.Controlador;
import AppMain.dao.ClienteDao;
import AppMain.dto.Cliente;

public class ClienteServ {
	private Controlador controlador;
	public static boolean consultaCliente = false;
	public static boolean modificaCliente = false;
	public void setControlador(Controlador controlador) {
		this.setControlador(controlador);
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cliente cliente) {
		ClienteDao clienteDao;
		if (cliente.getId() > 99) {
			clienteDao = new ClienteDao();
			clienteDao.registrarCliente(cliente);					
		} else {
			JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);

		}

	}

	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cliente validarConsulta(String codigoCliente) {
		ClienteDao clienteDAO;

		try {
			int codigo=Integer.parseInt(codigoCliente);	
			if (codigo > 99) {
				clienteDAO = new ClienteDao();
				consultaCliente=true;
				return clienteDAO.buscarCliente(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaCliente=false;
			}

		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCliente=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaCliente=false;
		}

		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cliente cliente) {
		ClienteDao clienteDao;
		if (cliente.getNombre().length()>5) {
			clienteDao = new ClienteDao();
			clienteDao.modificarCliente("Nombre", "Lucas", cliente.getId());;	
			modificaCliente=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaCliente=false;
		}
	}


	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(int codigo) {
		ClienteDao clienteDao=new ClienteDao();
		clienteDao.eliminarCliente(codigo);
	}

	public Controlador getClienteController() {
		return controlador;
	}

	public void setController(Controlador clienteController) {
		this.controlador = clienteController;
	}


}
