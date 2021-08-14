package AppMain.views;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppMain.controllers.Controlador;

public class VistaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Controlador controlador;
	private JButton botonRegistrar, botonBuscar;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		contentPane = new JPanel();
		setSize(480, 300);
		setTitle("Administración clientes");
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);
		setVisible(true);
		
		botonRegistrar = new JButton();
		botonRegistrar.setBounds(100, 280, 120, 25);
		botonRegistrar.setText("Registrar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(240, 280, 120, 25);
		botonBuscar.setText("Buscar");


	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonRegistrar) {
			controlador.mostrarVistaRegistro();
		} else if(e.getSource() == botonBuscar) {
			
		}
		
	}

}
