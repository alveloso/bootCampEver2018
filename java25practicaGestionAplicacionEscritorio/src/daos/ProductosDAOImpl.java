package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void registrarProducto(Producto p) {

		//Para evitar inyeccion ponemos en los values "?".De esta forma le decimos que esta es la SQL que queremos lanzar
		//Con 5 variables. Cuando le digamos a la base de datos que es cada
		//variable no se podra inyectar SQL porque la base de datos espera
		//variables del tipo indicado
		//La primera interrogacion tiene que ser uun nombre valido
		//correspondiente al tipo de dato de nombre en la bbdd
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionProducto);
			System.out.println(p.toString());
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getDispositivos());
			ps.setString(3, p.getGenero());
			ps.setString(4, p.getFechaSalida());
			ps.setString(5, p.getPrecio());
			ps.setString(6, p.getFormato());
			ps.setString(7, p.getNumJugadores());
			ps.setString(8, p.getCompania());
			ps.setString(9, p.getIdioma());
			ps.setString(10, p.getEditor());
			
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
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorrarProducto);
			
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error en la SQL de borrado");
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Producto[] obtenerProductos() {

		Producto[] productos = null;
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlSeleccionProductos);
			
			//Para sql tipo select debo usar el metodo executeQuery
			ResultSet resultado = ps.executeQuery();
			List<Producto> listProductos = new ArrayList<Producto>();
			
			//enxt pasa al siguiente resultado de a base de datos
			/*
			 * que aun no hemos procesado, si no hay ningun resultado mas
			 * devuelve false
			 */
			while(resultado.next()){
				Producto p = new Producto();
				
				//Nombre de la columna de la tabla en el get String
				p.setNombre(resultado.getString("nombre"));
				p.setDispositivos(resultado.getString("dispositivos"));
				p.setGenero(resultado.getString("genero"));
				p.setFechaSalida(resultado.getString("fecha_salida"));
				p.setPrecio(resultado.getString("precio"));
				p.setFormato(resultado.getString("formato"));
				p.setNumJugadores(resultado.getString("numero_jugadores"));
				p.setCompania(resultado.getString("compania"));
				p.setIdioma(resultado.getString("idioma"));
				p.setEditor(resultado.getString("editor"));
				p.setId(resultado.getInt("id"));
				
				listProductos.add(p);
			}
			//Transformar de list a array
			productos = listProductos.toArray(new Producto[listProductos.size()]);
			
		} catch (SQLException e) {
			System.out.println("Fallo en la SQL de seleccion productos");
		}
		
		return productos;
	}

}
