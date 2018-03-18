package tableModels;

import javax.swing.table.AbstractTableModel;
import modelo.Producto;

public class TableModelProductos extends AbstractTableModel{

	private String[] columnas= {"nombre","dispositivos","genero","fecha_salida","precio","formato","numero_jugadores","compania","idioma","editor"};
	
	private String[][] datos = null;
	
	public TableModelProductos(Producto[] productos) {
		
		//datos va a ser tantos arrays de strings como clientes tenga que listar
		/*
		 * Cada uno de esos arrays debera tener tantos elementos como
		 * queramos mostrar por cada columna
		 */
		datos = new String[productos.length][columnas.length];
		for (int i = 0; i < productos.length; i++) {
			Producto c = productos[i];
			
			datos[i][0] = c.getNombre();
			datos[i][1] = c.getDispositivos();
			datos[i][2] = c.getGenero();
			datos[i][3] = c.getFechaSalida();
			datos[i][4] = c.getPrecio();
			datos[i][5] = c.getFormato();
			datos[i][6] = c.getNumJugadores();
			datos[i][7] = c.getCompania();
			datos[i][8] = c.getIdioma();
			datos[i][9] = c.getEditor();
		}//end for
	}//end TableModelClientes
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {

		return datos[indiceFila][indiceColumna];
	}

}
