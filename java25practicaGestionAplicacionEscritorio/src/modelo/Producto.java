package modelo;

public class Producto {

	private int id;//Se utiliza para borrar datos

	private String nombre;
	private String dispositivos;
	private String genero;
	private String fechaSalida;
	private String precio;
	private String formato;
	private String numJugadores;
	private String compania;
	private String idioma;
	private String editor;
	
	public Producto(){
		
	}
	


	public Producto(String nombre, String dispositivos, String genero,
			String fechaSalida, String precio, String formato,
			String numJugadores, String compania, String idioma, String editor) {
		super();
		this.nombre = nombre;
		this.dispositivos = dispositivos;
		this.genero = genero;
		this.fechaSalida = fechaSalida;
		this.precio = precio;
		this.formato = formato;
		this.numJugadores = numJugadores;
		this.compania = compania;
		this.idioma = idioma;
		this.editor = editor;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(String dispositivos) {
		this.dispositivos = dispositivos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(String numJugadores) {
		this.numJugadores = numJugadores;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", dispositivos=" + dispositivos
				+ ", genero=" + genero + ", fechaSalida=" + fechaSalida
				+ ", precio=" + precio + ", formato=" + formato
				+ ", numJugadores=" + numJugadores + ", compania=" + compania
				+ ", idioma=" + idioma + ", editor=" + editor + "]";
	}
	
	

}