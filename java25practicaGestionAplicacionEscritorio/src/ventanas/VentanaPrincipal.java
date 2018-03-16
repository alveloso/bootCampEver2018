package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelListadoClientes;
import paneles.PanelListadoProductos;
import paneles.PanelRegistroCliente;
import paneles.PanelRegistroProducto;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	//Aqui viene bien poner private porque no nos interesa
	//que se pueda acceder a esta ventana desde otras ventanas
	//Paneles de la ventana
	private PanelRegistroCliente panRegCli = new PanelRegistroCliente();
	private PanelListadoClientes panLisCli = new PanelListadoClientes();
	
	private PanelRegistroProducto panRegPro = new PanelRegistroProducto();
	private PanelListadoProductos panLisPro = new PanelListadoProductos();
	
	//Barra de menu
	private JMenuBar barraMenu = new JMenuBar();
	
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuProductos = new JMenu("Productos");
	private JMenu menuAyuda = new JMenu("Ayuda");
	
	public VentanaPrincipal() {
		
		//Preparar la barra de menu
		JMenuItem clientesInsertar = new JMenuItem("Insertar cliente");
		JMenuItem listarClientes = new JMenuItem("Listar clientes");
		
		JMenuItem productosInsertar = new JMenuItem("Insertar producto");
		JMenuItem listarProductos = new JMenuItem("Listar productos");
		
		menuClientes.add(clientesInsertar);
		menuClientes.add(listarClientes);
		
		menuProductos.add(productosInsertar);
		menuProductos.add(listarProductos);
		
		barraMenu.add(menuClientes);
		barraMenu.add(menuProductos);
		barraMenu.add(menuAyuda);
		this.setJMenuBar(barraMenu);
		
		/*
		 * Voy a decir a las opciones de menu quien las 
		 * va a atender cuando se las haga un click
		 */
		clientesInsertar.addActionListener(this);
		listarClientes.addActionListener(this);
		productosInsertar.addActionListener(this);
		listarProductos.addActionListener(this);
		
		//Preparacion de la ventana principal
		this.setSize(800, 600);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Vamos a decir que cuando arranque esta ventana se muestre
		//el panel de registro cliente
		//this.add(panRegCli);
		this.setContentPane(panRegCli);
		//Con add funciona bien pero mejor llamar a setContentPane
		this.setVisible(true);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("atiendo a: " + e.getActionCommand());
		if(e.getActionCommand().equals("Insertar cliente")){
			setContentPane(panRegCli);
		}else if(e.getActionCommand().equals("Listar clientes")){
			setContentPane(panLisCli);
			panLisCli.refrescarClientes();
		}else if(e.getActionCommand().equals("Insertar producto")){
			setContentPane(panRegPro);
			
		}else if(e.getActionCommand().equals("Listar productos")){
			setContentPane(panLisPro);
			//panLisPro.refrescarProductos();
		}
		
		//Esto es para refrescar cuando paso de un panel a otro
		//Teniamos puesto antes un repaint pero no valia
		SwingUtilities.updateComponentTreeUI(this);
	}
}
