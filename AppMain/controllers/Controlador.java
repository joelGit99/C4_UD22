package AppMain.controllers;

import AppMain.views.VistaPrincipal;
import AppMain.views.VistaRegistro;
import AppMain.service.ClienteServ;
import AppMain.dto.Cliente;

public class Controlador {
	private ClienteServ clienteServ;
	private VistaPrincipal vistaPrincipal;
	private VistaRegistro vistaRegistro;

	public VistaPrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}

	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public VistaRegistro getVistaRegistro() {
		return vistaRegistro;
	}

	public void setVistaRegistro(VistaRegistro vistaRegistro) {
		this.vistaRegistro = vistaRegistro;
	}

	public ClienteServ getClienteServ() {
		return clienteServ;
	}

	public void setClienteServ(ClienteServ clienteServ) {
		this.clienteServ = clienteServ;
	}
	
	public void mostrarVistaRegistro() {
		vistaRegistro.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarCliente(Cliente cliente) {
		clienteServ.validarRegistro(cliente);;
	}
	
	public Cliente buscarCliente(String codigoCliente) {
		return clienteServ.validarConsulta(codigoCliente);
	}
	
	public void modificarCliente(Cliente cliente) {
		clienteServ.validarModificacion(cliente);
	}
	
	public void eliminarCliente(int codigo) {
		clienteServ.validarEliminacion(codigo);
	}

}
