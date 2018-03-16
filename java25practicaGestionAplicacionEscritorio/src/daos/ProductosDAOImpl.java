package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Cliente;
import modelo.Producto;

public class ProductosDAOImpl implements ProductosDAO{

	private Connection miConexion = null;
	
	public ProductosDAOImpl() {
		//Preparo driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/practica_escritorio","root","jeveris");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar driver-libreria de mysql");
			
		} catch (SQLException e) {
			System.out.println("Error en la conexion o la SQL esta mal");
		}
	}
	
	@Override
	public void registrarProducto(Producto c) {

		//Para evitar inyeccion ponemos en los values "?".De esta forma le decimos que esta es la SQL que queremos lanzar
		//Con 5 variables. Cuando le digamos a la base de datos que es cada
		//variable no se podra inyectar SQL porque la base de datos espera
		//variables del tipo indicado
		//La primera interrogacion tiene que ser uun nombre valido
		//correspondiente al tipo de dato de nombre en la bbdd
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionProductos);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDispositivos());
			ps.setString(3, c.getGenero());
			ps.setString(4, c.getFechaSalida());
			ps.setString(5, c.getPrecio());
			ps.setString(6, c.getFormato());
			ps.setString(7, c.getNumJugadores());
			ps.setString(8, c.getCompania());
			ps.setString(9, c.getIdioma());
			ps.setString(10, c.getEditor());
			
			//Ahora lanzamos
			ps.execute();
			ps.close();
			System.out.println("Producto insertado correctamente");
		} catch (SQLException e) {
			System.out.println("Fallo en la SQL");
		}
		
	}

	@Override
	public void borrarProducto(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto[] obtenerProductos() {
		// TODO Auto-generated method stub
		return null;
	}

}
