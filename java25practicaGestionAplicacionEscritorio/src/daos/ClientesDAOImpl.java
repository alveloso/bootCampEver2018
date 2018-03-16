package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO{

	private Connection miConexion = null;
	
	public ClientesDAOImpl() {
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
	public void registrarCliente(Cliente c) {

		//Para evitar inyeccion ponemos en los values "?".De esta forma le decimos que esta es la SQL que queremos lanzar
		//Con 5 variables. Cuando le digamos a la base de datos que es cada
		//variable no se podra inyectar SQL porque la base de datos espera
		//variables del tipo indicado
		//La primera interrogacion tiene que ser uun nombre valido
		//correspondiente al tipo de dato de nombre en la bbdd
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionCliente);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigoPostal());
			ps.setString(5, c.getTelefono());
			
			//Ahora lanzamos
			//Execute vale para inserciones y modificaciones
			ps.execute();
			ps.close();
			System.out.println("Cliente insetrado correctamente");
		} catch (SQLException e) {
			System.out.println("Fallo en la SQL");
		}
		
	}

	@Override
	public void borrarCliente(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente[] obtenerClientes() {
		
		Cliente[] clientes = null;
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlSeleccionClientes);
			
			//Para sql tipo select debo usar el metodo executeQuery
			ResultSet resultado = ps.executeQuery();
			List<Cliente> listClientes = new ArrayList<Cliente>();
			
			//enxt pasa al siguiente resultado de a base de datos
			/*
			 * que aun no hemos procesado, si no hay ningun resultado mas
			 * devuelve false
			 */
			while(resultado.next()){
				Cliente c = new Cliente();
				
				//Nombre de la columna de la tabla en el get String
				c.setNombre(resultado.getString("nombre"));
				c.setDomicilio(resultado.getString("domicilio"));
				c.setCodigoPostal(resultado.getString("codigo_postal"));
				c.setPoblacion(resultado.getString("poblacion"));
				c.setTelefono(resultado.getString("telefono"));
				
				listClientes.add(c);
			}
			//Transformar de list a array
			clientes = listClientes.toArray(new Cliente[listClientes.size()]);
			
		} catch (SQLException e) {
			System.out.println("Fallo en la SQL de seleccion clientes");
		}
		
		return clientes;
	}

//	public static void main(String[] args) {
//
//		ClientesDAOImpl dao = new ClientesDAOImpl();
//		Cliente[] clientes = dao.obtenerClientes();
//
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente.toString());
//		}
//	}

}
