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
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel  implements ActionListener{
	
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;

	JTable tabla;// si no declaro la tabla fuera no puedo cogerla en el event
	JButton botonBorrar = new JButton("BORRAR");

	public PanelListadoClientes() {
		this.add(new JLabel("Soy el panel del listado clientes"));
	}//end PanelListadoClientes
	
	public void refrescarClientes(){
		this.clientes = daoClientes.obtenerClientes();
		
		
		tabla = new JTable(new TableModelClientes(clientes));
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabla.setFillsViewportHeight(true);
        //Para solo poder seleccionar una fila
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabla);

        
		//Para quitar todo lo que tuviera antes el panel
		this.removeAll();
		
		this.add(botonBorrar);
		this.add(scrollPane);
		//Add the scroll pane to this panel.
        
		//Voy a atender al boton borrar desde esta clase
        botonBorrar.addActionListener(this);
		
	}//end refrescarClientes

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Por si tanto no se selecciona una fila como si pulso borrar repetidas veces
		if(tabla.getSelectedRow() == -1){
			return;
			//Aunque la funcion no devuelva nada se puede llamar
			//a return para decir que finaliza la funcion
		}
		//Si getSelectedRow da -1 es que no se ha seleccionado ninguna fila y daria error al sacar datos
		JOptionPane.showMessageDialog(null, "borrar: " + clientes[tabla.getSelectedRow()].toString());
		daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
		refrescarClientes();
		SwingUtilities.updateComponentTreeUI(this);
	}
}//end class
