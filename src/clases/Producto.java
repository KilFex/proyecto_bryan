package clases;

public class Producto {
	private int codigo, stockActual, stockMinimo, stockMaximo;
	String nombre;
	double precio;
	
	
	public Producto(int codigo, int stockActual, int stockMinimo, int stockMaximo, String nombre, double precio) {
		this.codigo = codigo;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.nombre = nombre;
		this.precio = precio;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getStockActual() {
		return stockActual;
	}


	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}


	public int getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}


	public int getStockMaximo() {
		return stockMaximo;
	}


	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
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


