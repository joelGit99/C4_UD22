package AppMain.views;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import AppMain.controllers.Controlador;
import AppMain.dto.Cliente;

public class VistaRegistro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Controlador controlador;
	private JLabel titulo;
	private JTextField textid, textnombre, textapellido, textdireccion, textdni, textfecha;
	private JLabel id, nombre, apellido, direccion, dni, fecha;
	private JButton btnRegistrar;

	/**
	 * Create the frame.
	 */
	public VistaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnRegistrar = new JButton();
		btnRegistrar.setBounds(110, 220, 120, 25);
		btnRegistrar.setText("Registrar");
		
		titulo = new JLabel();
		titulo.setText("REGISTRO DE PERSONAS");
		titulo.setBounds(120, 20, 380, 30);
		titulo.setFont(new java.awt.Font("Verdana", 1, 18));
		

		id=new JLabel();
		id.setText("Codigo");
		id.setBounds(20, 80, 80, 25);
		add(id);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);

		apellido=new JLabel();
		apellido.setText("Apellido");
		apellido.setBounds(290, 160, 80, 25);
		add(apellido);
		
		direccion=new JLabel();
		direccion.setText("Dirección");
		direccion.setBounds(290, 120, 80, 25);
		add(direccion);
		
		dni=new JLabel();
		dni.setText("DNI");
		dni.setBounds(20, 160, 80, 25);
		add(dni);
		
		fecha=new JLabel();
		fecha.setText("Fecha");
		fecha.setBounds(290, 120, 80, 25);
		add(fecha);
		
		textid=new JTextField();
		textid.setBounds(80, 80, 80, 25);
		add(textid);
		
		textnombre=new JTextField();
		textnombre.setBounds(80, 120, 190, 25);
		add(textnombre);

		textapellido=new JTextField();
		textapellido.setBounds(340, 160, 80, 25);
		add(textapellido);
		
		textdireccion=new JTextField();
		textdireccion.setBounds(340, 120, 80, 25);
		add(textdireccion);
		
		textdni=new JTextField();
		textdni.setBounds(80, 160, 190, 25);
		add(textdni);
		
		textfecha=new JTextField();
		textfecha.setBounds(80, 160, 190, 25);
		add(textfecha);
		
		btnRegistrar.addActionListener(this);
		add(btnRegistrar);
		add(titulo);
		setSize(480, 300);
		setTitle("REGISTRO DE PERSONAS");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);



	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegistrar) {
			try {
				Cliente cliente=new Cliente();
				cliente.setId(Integer.parseInt(textid.getText()));
				cliente.setNombre(textnombre.getText());
				cliente.setApellido(textapellido.getText());
				cliente.setDireccion(textdireccion.getText());
				cliente.setDni(Integer.parseInt(textdni.getText()));
				cliente.setFecha(textfecha.getText());
				
				controlador.registrarCliente(cliente);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}

		}
	}

}
