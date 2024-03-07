package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.Lista_Productos;
import clases.Cliente;
import clases.Producto;
import java.awt.Color;

public class frmProducto extends JFrame implements ActionListener{
	Lista_Productos lp = new Lista_Productos();
	private JPanel contentPane;
	int codigoConsultado = lp.codigoListaProducto();
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textStockActual;
	private JTextField textStockMinimo;
	private JTextField textStockMaximo;
	private JTable tblModelo;
	private DefaultTableModel modelo;
	private JButton btnIngresar;
	private JScrollPane scrollPane;
	private JButton btnModificar;
	private Producto producto;
	private JButton btnEliminar;
	private JButton btnConsulta;
	private JButton btnListado;
	private DefaultTableCellRenderer color;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProducto frame = new frmProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmProducto() {
		setTitle("Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 670);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblNombres = new JLabel("Nombre:");
		lblNombres.setBounds(24, 11, 86, 22);
		contentPane.add(lblNombres);

		JLabel lblApellidos = new JLabel("Precio:");
		lblApellidos.setBounds(24, 44, 86, 22);
		contentPane.add(lblApellidos);

		JLabel lblDireccin = new JLabel("Stock Actual:");
		lblDireccin.setBounds(24, 77, 86, 22);
		contentPane.add(lblDireccin);

		JLabel lblTel = new JLabel("Stock Minimo:");
		lblTel.setBounds(24, 110, 86, 22);
		contentPane.add(lblTel);

		JLabel lblDni = new JLabel("Stock Maximo:");
		lblDni.setBounds(24, 143, 97, 22);
		contentPane.add(lblDni);

		textNombre = new JTextField();
		textNombre.setBounds(120, 12, 182, 29);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setBounds(120, 45, 182, 29);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		textStockActual = new JTextField();
		textStockActual.setBounds(120, 78, 182, 29);
		contentPane.add(textStockActual);
		textStockActual.setColumns(10);

		textStockMinimo = new JTextField();
		textStockMinimo.setBounds(120, 111, 182, 29);
		contentPane.add(textStockMinimo);
		textStockMinimo.setColumns(10);

		textStockMaximo = new JTextField();
		textStockMaximo.setBounds(120, 144, 182, 29);
		contentPane.add(textStockMaximo);
		textStockMaximo.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(151, 184, 108, 33);
		contentPane.add(btnIngresar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(361, 142, 108, 33);
		contentPane.add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 231, 945, 389);
		contentPane.add(scrollPane);

		tblModelo = new JTable();
		tblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tblModelo);
		
		
		
		modelo = new DefaultTableModel();
		
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock Actual");
		modelo.addColumn("Stock Minimo");
		modelo.addColumn("Stock Maximo");
		tblModelo.setModel(modelo);
		ajustarColumnas();
		
		color = new DefaultTableCellRenderer();
		int posColumna = 3;
		tblModelo.getColumnModel().getColumn(5).setCellRenderer(color);
		color.setBackground(Color.red);


		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(361, 11, 108, 33);
		contentPane.add(btnModificar);

		btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(361, 55, 108, 33);
		contentPane.add(btnConsulta);

		btnListado = new JButton("Listado");
		btnListado.addActionListener(this);
		btnListado.setBounds(361, 99, 108, 33);
		contentPane.add(btnListado);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 78, 182, 29);
		contentPane.add(textField);
		listar();
		tblModelo.getSelectionModel().setSelectionInterval(0, 0);

	}
	String nombre;
	int codigo, stockActual, stockMinimo, stockMaximo;
	double precio;
	private JTextField textField;
	
	void obtenerDatos() {
		nombre = textNombre.getText();
		codigo = lp.codigoListaProducto();
	}

	double leerPrecio() {
		return precio = Double.parseDouble(textPrecio.getText().trim());
	}

	int leerStockActual() {
		return stockActual = Integer.parseInt(textStockActual.getText().trim());
	}
	
	int leerStockMinimo() {
		return stockMinimo = Integer.parseInt(textStockMinimo.getText().trim());
	}
	
	int leerStocMaximo() {
		return stockMaximo = Integer.parseInt(textStockMaximo.getText().trim());
	}
	
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < lp.tamanio(); i++) {
			Object[] file = { lp.obtener(i).getCodigo(), lp.obtener(i).getNombre(), lp.obtener(i).getPrecio(),
					lp.obtener(i).getStockActual(), lp.obtener(i).getStockMinimo(), lp.obtener(i).getStockMaximo(),

			};
			modelo.addRow(file);
		}
	}
	
	void ajustarColumnas() {
		TableColumnModel tcm = tblModelo.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(52)); // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10)); // apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); // direccion
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); // telefono
		tcm.getColumn(5).setPreferredWidth(anchoColumna(10)); // DNI
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void agregar() {
		obtenerDatos();
		leerPrecio();
		leerStockActual();
		leerStockMinimo();
		leerStocMaximo();

		Producto producto = new Producto(codigo, stockActual, stockMinimo, stockMaximo,nombre,precio);
		lp.adicionar(producto);
		listar();

	}
	
	void limpieza() {
		textNombre.requestFocus();
		textNombre.setText("");
		textPrecio.setText("");
		textStockActual.setText("");
		textStockMinimo.setText("");
		textStockMaximo.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
		if (e.getSource() == btnListado) {
			actionPerformedBtnListado(e);
		}
		
	}
	
	void actionPerformedBtnListado(ActionEvent e) {
		if(lp.tamanio()>0) {
			frmListadoProducto lista = new frmListadoProducto();
			lista.setVisible(true);
			lista.setLocationRelativeTo(this);
			lista.setResizable(false);
		}
		else {
			mensaje("No hay clientes");
		}
		

	}
	
	void actionPerformedBtnConsulta(ActionEvent e) {
		frmConsultaProducto consulta = new frmConsultaProducto();

		consulta.setVisible(true);
		consulta.setLocationRelativeTo(this);
		consulta.setResizable(false);
		int posFila = tblModelo.getSelectedRow();
		Producto x = lp.obtener(posFila);
		consulta.mostrarInformacionCliente(x);

	}
	
	void actionPerformedBtnEliminar(ActionEvent e) {
		if (lp.tamanio() > 0) {
			int ok = confirmar("¿Está seguro de eliminar el producto?");
			if (ok == 0) {
				int posFila = tblModelo.getSelectedRow();
				Producto x = lp.obtener(posFila);
				lp.eliminarPos(x);
				listar();
				if (lp.tamanio() > 0) {
					codigoConsultado = lp.obtener(0).getCodigo();
					if (posFila == tblModelo.getRowCount()) {
						posFila--;
						tblModelo.getSelectionModel().setSelectionInterval(posFila, posFila);
					}

				}
			}
		} else {
			mensaje("No hay clientes");
		}

	}
	
	void actionPerformedBtnIngresar(ActionEvent e) {
		obtenerDatos();
		if (nombre.length() > 0) {
			try  {
				leerPrecio();
				try {
					leerStockActual();
					try {
						leerStockMinimo();
						try {
							leerStocMaximo();
							agregar();
							listar();
							limpieza();
							
						} catch (Exception x) {
							error("Ingrese Stock Maximo", textStockMaximo);
						}

					} catch (Exception x) {
						error("Ingrese Stock Minimo", textStockMinimo);
					}

				} catch (Exception x)  {
					error("Ingrese Stock Actual", textStockActual);
				}

			} catch (Exception x) {
				error("Ingrese Precio", textPrecio);
			}

		} else {
			error("Ingrese nombre", textNombre);
		}
	}
	
	void actionPerformedBtnModificar(ActionEvent e) {
		int posFila = tblModelo.getSelectedRow();
		Producto x = lp.obtener(posFila);
		String s = "CÓDIGO: " + x.getCodigo() + "\n" + "NOMBRE";

		try {
			nombre = adicionarModificar(s, x.getNombre());
			s += (" : " + nombre + "\n" + "PRECIO");
			precio = Double.parseDouble(adicionarModificar(s,""+ x.getPrecio())) ;
			s += (" : " + precio + "\n" + "Stock Actual");
			stockActual = Integer.parseInt(adicionarModificar(s,""+ x.getStockActual()));
			s += (" : " + stockActual + "\n" + "Stock Minimo");
			stockMinimo = Integer.parseInt(adicionarModificar(s, "" + x.getStockMinimo()));
			s += (" : " + stockMinimo + "\n" + "Stock Maximo");
			stockMaximo = Integer.parseInt(adicionarModificar(s, "" + x.getStockMaximo()));
			s += (" : " + stockMaximo);
			int ok = verificar(s);
			if (ok == 0) {
				x.setNombre(nombre);
				x.setPrecio(precio);
				x.setStockActual(stockActual);
				x.setStockMinimo(stockMinimo);
				x.setStockMaximo(stockMaximo);
				lp.actualizarArchivo();
				listar();
				tblModelo.getSelectionModel().setSelectionInterval(posFila, posFila);
			}
		} catch (Exception y) {

		}

	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Persona", 1);
	}

	String adicionarModificar(String s, String texto) {
		return JOptionPane.showInputDialog(this, s, "Persona", -1, null, null, texto).toString();
	}

	int verificar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Persona", 0, 3, null);
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Persona", 0, 0, null);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}

}
