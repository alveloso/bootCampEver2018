package daos;

import modelo.Cliente;

/*
 * En entorno corporativo lo más normal del mundo
 * es definir las operaciones que se van a poder hacer
 * desde bbdd en un interfaz
 * 
 * En este caso para el interfaz actual cada metodo
 * dira que se puede hacecr en base de datos de cara a clientes
 */

public interface ClientesDAO {

	void registrarCliente(Cliente c);
	void borrarCliente(int id);
	Cliente [] obtenerClientes();
	//Un array es un conjunto de datos del mismo tipo
}

