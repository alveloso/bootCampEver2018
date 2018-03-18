package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import modelo.Producto;
import tableModels.TableModelProductos;
import daos.ProductosDAO;
import daos.ProductosDAOImpl;

public class PanelListadoProductos extends JPanel  implements ActionListener{

	private ProductosDAO daoProductos = new ProductosDAOImpl();
	private Producto[] productos;

	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");
	
	public PanelListadoProductos() {
		this.add(new JLabel("Soy el panel del listado productos"));
	}//end PanelListadoClientes
	
	public void refrescarProductos(){
		this.productos = daoProductos.obtenerProductos();
		
		tabla = new JTable(new TableModelProductos(productos));
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabla.setFillsViewportHeight(true);
        //Para solo poder seleccionar una fila
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
      //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabla);

        
		//Para quitar todo lo que tuviera antes el panel
		this.removeAll();
		//Add the scroll pane to this panel.
		this.add(botonBorrar);
		this.add(scrollPane);
		
		//Voy a atender al boton borrar desde esta clase
        botonBorrar.addActionListener(this);
		
	}//end refrescarProductos

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Por si tanto no se selecciona una fila como si pulso borrar repetidas veces
		if(tabla.getSelectedRow() == -1){
			return;
			//Aunque la funcion no devuelva nada se puede llamar
			//a return para decir que finaliza la funcion
		}
		//Si getSelectedRow da -1 es que no se ha seleccionado ninguna fila y daria error al sacar datos
		JOptionPane.showMessageDialog(null, "borrar: " + productos[tabla.getSelectedRow()].toString());
		daoProductos.borrarProducto(productos[tabla.getSelectedRow()].getId());
		refrescarProductos();
		SwingUtilities.updateComponentTreeUI(this);
	}
	
}
