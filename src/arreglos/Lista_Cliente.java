package arreglos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;


public class Lista_Cliente {
	
	private ArrayList<Cliente> listaClientes;
	
	public Lista_Cliente() {
		listaClientes = new ArrayList<Cliente>();
		cargarCliente();
	}
	
	public Cliente obtener(int i) {
		return listaClientes.get(i);
	}
	
	public int tamanio() {
		return listaClientes.size();
	}
	
	public void agregarCliente(Cliente x) {
		listaClientes.add(x);
		grabarCliente();
	}
	
	public Cliente buscarCliente(int codigo) {
		for(int i=0; i<tamanio();i++) {
			if(obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	
	private void grabarCliente() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter("personas.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" +
					    x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDireccion() + ";" +
						x.getTelefono() + ";" +
						x.getDni();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	private void cargarCliente() {
		try {
			BufferedReader br;
			String linea, nombre, apellido, direccion;
			String[] s;
			int codigo,dni,telefono;
			br = new BufferedReader(new FileReader("personas.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				apellido = s[2].trim();
				direccion = s[3].trim();
				telefono = Integer.parseInt(s[4].trim());
				dni = Integer.parseInt(s[5].trim());
				agregarCliente(new Cliente(codigo, nombre, apellido, direccion,telefono,dni));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public void actualizarArchivo() {
		grabarCliente();
	}
	
	public void eliminarPos(Cliente x) {
		listaClientes.remove(x);
		grabarCliente();
	}
	

	public int codigoListaCliente() {
		if(tamanio()== 0) {
			return  1000;
		}
		else {
			return obtener(tamanio()-1).getCodigo()+1;
		}
	}
}

	
