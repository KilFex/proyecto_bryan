package clases;

public class Producto extends Almacen {
	private int codigo;
	String nombre;
	double precio;
	
	
	public Producto(int codigo, int stockActual, int stockMinimo, int stockMaximo, String nombre, double precio) {
		super(stockActual, stockMinimo, stockMaximo);
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}



 
		// TODO Auto-generated constructor stub
	


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}


