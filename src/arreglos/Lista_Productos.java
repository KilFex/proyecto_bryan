package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JTextField;

import clases.Cliente;
import clases.Producto;

public class Lista_Productos {
	private ArrayList<Producto> producto;

	public Lista_Productos() {
		producto = new ArrayList<Producto>();
		cargarProducto();
	}
	
	public Producto obtener(int i) {
		return producto.get(i);
	}
	
	public int tamanio() {
		return producto.size();
	}
	
	public void adicionar(Producto x) {
		producto.add(x);
		grabarProducto();
	}
	
	public Producto buscarCliente(int codigo) {
		for(int i=0; i<tamanio();i++) {
			if(obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	
	private void grabarProducto() {
		try {
			PrintWriter pw;
			String linea;
			Producto x;
			pw = new PrintWriter(new FileWriter("productos.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" +
					    x.getNombre() + ";" +
						x.getPrecio() + ";" +
						x.getStockActual() + ";" +
						x.getStockMaximo() + ";" +
						x.getStockMinimo();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarProducto() {
		try {
			BufferedReader br;
			String linea, nombre;
			String[] s;
			int codigo,stockActual,stockMinimo,stockMaximo;
			double precio;
			br = new BufferedReader(new FileReader("productos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				precio = Double.parseDouble(s[2].trim());
				stockActual = Integer.parseInt(s[3].trim());
				stockMinimo = Integer.parseInt(s[4].trim());
				stockMaximo = Integer.parseInt(s[5].trim());
				adicionar(new Producto(codigo, stockActual, stockMinimo, stockMaximo,nombre,precio));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public void eliminarPos(Producto x) {
		producto.remove(x);
		grabarProducto();
	}
	
	public void actualizarArchivo() {
		grabarProducto();
	}

	public int codigoListaProducto() {
		if(tamanio()== 0) {
			return  2000;
		}
		else {
			return obtener(tamanio()-1).getCodigo()+1;
		}
	}
}


