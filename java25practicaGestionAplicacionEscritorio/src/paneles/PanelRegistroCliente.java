package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelRegistroCliente extends JPanel implements ActionListener {
	JTextField campoNombre = new JTextField(15);
	JTextField campoDomicilio = new JTextField(15);
	JTextField campoPoblacion = new JTextField(15);
	JTextField campoCodigoPostal = new JTextField(15);
	JTextField campoTelefono = new JTextField(15);

	public PanelRegistroCliente() {

		/*
		 * Arriba una etiqueta con los datos del cliente
		 * 
		 * Luego Nombre del cliente y campo para recogerlo a la derechaLuego
		 * domicilio del cliente y campo para recogerlo a la dcha (text field)
		 * PoblacionCodigo postalTelefono
		 * 
		 * Nos va a pedir componentes que no hayamos dado (desplegables,
		 * calendario...)Por ultimo un boton de registrar (JButton)
		 * 
		 * Lo ideal seria dividirlo todo en filas, van como por coordenadas
		 * 
		 * Fila 0 Introduce los datos (Esto sería coord 0,0)Fila 1 Nombre | |
		 * (El texto seria 1,0) (El campo sería 1,1)Fila 2 Domicilio | |Fila 3
		 * Fila 4Fila 5Fila 6
		 */

		// Esto lo hemos visto en el ejercicio de conversiones
		// this.add(new JLabel("Soy el panel de registro del cliente"));

		/*
		 * Asi asigno un gestor de diseño que me permite colocar las cosas en
		 * forma de filas y celdas
		 */
		setLayout(new GridBagLayout());

		// ahora tenemos que crear un objeto de tipo gridbagconstraints
		GridBagConstraints gbc = new GridBagConstraints();

		// Ahora hay que ir configurando el gbc para ir metiendole cosas
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2; // Esto es para decir que ocupe el doble
		this.add(new JLabel("Introduce los datos del cliente"), gbc);

		// vuelvo a decir que cada componente ocupe solo un elemento
		gbc.gridwidth = 1;

		// Segunda fila
		// Si quiero usar campos de texto tengo que declararlos arriba
		// Ahora agrego el label nombre
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Nombre:"), gbc);

		// Ahora pongo el campoNombre
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoNombre, gbc);

		// Ahora la siguiente fila
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Domicilio:"), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDomicilio, gbc);

		// Siguiente fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Poblacion:"), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoPoblacion, gbc);

		// Siguiente fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Codigo postal:"), gbc);

		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoCodigoPostal, gbc);

		// Siguiente fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Telefono:"), gbc);

		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoTelefono, gbc);

		// Ahora toca el boton
		JButton botonRegistroCliente = new JButton("REGISTRAR");

		// Se ha puesto this porque lo escuchará el mismo panel
		// Al principio me daria error porque tengo que implementar
		// ActionListener
		// y depues añadir los metodos no implementados de la interfaz
		// ActionListener
		botonRegistroCliente.addActionListener(this);
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroCliente, gbc);

	}// end PanelRegistroCliente

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("ActionPerformed del panelRegistroCliente");
		String nombre = campoNombre.getText();
		String domicilio = campoDomicilio.getText();
		String poblacion = campoPoblacion.getText();
		String codigoPostal = campoCodigoPostal.getText();
		String telefono = campoTelefono.getText();

		//Ahora hay que validar estos datos
		//... TODO
		
		/*
		 * Una vez validados todos los datos registramos en la base de datos:
		 */
		Cliente clienteAregistrar = new Cliente(nombre, domicilio, poblacion, codigoPostal, telefono);
		System.out.println("Voy a registrar: " + clienteAregistrar.toString());
		
		//Aqui invoco lo necesario de la capa de datos para registrar el cliente en bbdd
		ClientesDAOImpl clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(clienteAregistrar);
	}
}// End clase
