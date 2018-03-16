package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Cliente;
import modelo.Producto;
import daos.ClientesDAOImpl;
import daos.ProductosDAOImpl;

public class PanelRegistroProducto extends JPanel implements ActionListener {
	JTextField campoNombre = new JTextField(15); //Texto
	JTextField campoDispositivos = new JTextField(15); //CheckBox
	JTextField campoGenero = new JTextField(15); //Desplegable
	JTextField campoFechaSalida = new JTextField(15);//Fecha pero de momento texto
	JTextField campoPrecio = new JTextField(15); //Texto
	JTextField campoFormato = new JTextField(15); //Radial -> Fisico o digital
	JTextField campoNumJugadores = new JTextField(15); //Texto
	JTextField campoCompania = new JTextField(15); //Texto
	JTextField campoIdioma = new JTextField(15); //Texto
	JTextField campoEditor = new JTextField(15); //Texto
	
//	JCheckBox dispositivoPC = new JCheckBox("PC");
//	JCheckBox dispositivoPS4 = new JCheckBox("PS4");
//	JCheckBox dispositivoXboxONE = new JCheckBox("XBoxOne");
	
	//private String[] listaGeneros = { "Accion", "Disparos", "Estrategia", "Simulacion", "Deportes", "Carreras", "Aventura", "Rol" };
	
	//JComboBox desplegable = new JComboBox(listaGeneros);
	
	public PanelRegistroProducto() {
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
		this.add(new JLabel("Introduce los datos del producto"), gbc);

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
		this.add(new JLabel("Dispositivos:"), gbc);

		//Temporal
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDispositivos,gbc);
		
//		gbc.gridy = 2;
//		gbc.gridx = 1;
//		this.add(dispositivoPC, gbc);
//		
//		gbc.gridy = 2;
//		gbc.gridx = 2;
//		this.add(dispositivoPS4, gbc);
//		
//		gbc.gridy = 2;
//		gbc.gridx = 3;
//		this.add(dispositivoXboxONE, gbc);

		// Siguiente fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("genero:"), gbc);

		//temporal
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoGenero,gbc);
		
//		gbc.gridy = 3;
//		gbc.gridx = 1;
//		this.add(desplegable, gbc);
		

		// Siguiente fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Fecha salida:"), gbc);

		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoFechaSalida, gbc);

		// Siguiente fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Precio:"), gbc);

		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoPrecio, gbc);
		
		// Siguiente fila
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("Formato:"), gbc);

		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoFormato, gbc);
		
		// Siguiente fila
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("Numero de jugadores:"), gbc);

		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoNumJugadores, gbc);
		
		// Siguiente fila
		gbc.gridy = 8;
		gbc.gridx = 0;
		this.add(new JLabel("Compañia:"), gbc);

		gbc.gridy = 8;
		gbc.gridx = 1;
		this.add(campoCompania, gbc);
		
		// Siguiente fila
		gbc.gridy = 9;
		gbc.gridx = 0;
		this.add(new JLabel("Idioma:"), gbc);

		gbc.gridy = 9;
		gbc.gridx = 1;
		this.add(campoIdioma, gbc);
		
		// Siguiente fila
		gbc.gridy = 10;
		gbc.gridx = 0;
		this.add(new JLabel("Editor:"), gbc);

		gbc.gridy = 10;
		gbc.gridx = 1;
		this.add(campoEditor, gbc);

		// Ahora toca el boton
		JButton botonRegistroProducto = new JButton("REGISTRAR PRODUCTO");

		// Se ha puesto this porque lo escuchará el mismo panel
		// Al principio me daria error porque tengo que implementar
		// ActionListener
		// y depues añadir los metodos no implementados de la interfaz
		// ActionListener
		botonRegistroProducto.addActionListener(this);
		gbc.gridy = 11;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroProducto, gbc);

	}// end PanelRegistroProducto

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionPerformed del panelRegistroProducto");
		String nombre = campoNombre.getText();
		String dispositivos = campoDispositivos.getText();
		String genero = campoGenero.getText();
		String fechaSalida = campoFechaSalida.getText();
		String precio  = campoPrecio.getText();
		String formato = campoFormato.getText();
		String numJugadores = campoNumJugadores.getText();
		String compania = campoCompania.getText();
		String idioma = campoIdioma.getText();
		String editor  = campoEditor.getText();
		//Ahora hay que validar estos datos
		//... TODO
		
		/*
		 * Una vez validados todos los datos registramos en la base de datos:
		 */
		Producto productoAregistrar = new Producto(nombre, dispositivos,genero,fechaSalida,precio,formato,numJugadores,compania,idioma,editor);
		System.out.println("Voy a registrar: " + productoAregistrar.toString());
		
		//Aqui invoco lo necesario de la capa de datos para registrar el cliente en bbdd
		ProductosDAOImpl productosDAO = new ProductosDAOImpl();
		productosDAO.registrarProducto(productoAregistrar);
	}
}
