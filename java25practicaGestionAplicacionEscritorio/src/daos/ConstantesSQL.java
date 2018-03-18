package daos;

public class ConstantesSQL {
	
	//SQL clientes
	final static String sqlInsercionCliente = "insert into tabla_clientes (nombre,domicilio,poblacion,codigo_postal,telefono) values (?,?,?,?,?)";
	final static String sqlSeleccionClientes = "select * from tabla_clientes";
	final static String sqlBorrarCliente = "delete from tabla_clientes where id = ?";
	
	//SQL productos
	final static String sqlInsercionProducto = "insert into tabla_productos (nombre,dispositivos,genero,fecha_salida,precio,formato,numero_jugadores,compania,idioma,editor) values (?,?,?,?,?,?,?,?,?,?)";
	final static String sqlSeleccionProductos = "select * from tabla_productos";
	final static String sqlBorrarProducto = "delete from tabla_productos where id = ?";
}
