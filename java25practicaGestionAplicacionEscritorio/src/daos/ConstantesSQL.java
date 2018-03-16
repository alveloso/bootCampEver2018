package daos;

public class ConstantesSQL {
	final static String sqlInsercionCliente = "insert into tabla_clientes (nombre,domicilio,poblacion,codigo_postal,telefono) values (?,?,?,?,?)";
	final static String sqlSeleccionClientes = "select * from tabla_clientes";
	
	final static String sqlInsercionProductos = "insert into tabla_productos (nombre,dispositivos,genero,fecha_salida,precio,formato,numero_jugadores,compania,idioma,editor) values (?,?,?,?,?,?,?,?,?,?)";
	final static String sqlSeleccionProductos = "select * from tabla_productos";
}
