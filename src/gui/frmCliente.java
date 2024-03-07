package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

//import com.formdev.flatlaf.FlatDarculaLaf;

import arreglos.Lista_Cliente;
import clases.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmCliente extends JFrame implements ActionListener {
	Lista_Cliente lc = new Lista_Cliente();

	int codigoConsultado = lc.codigoListaCliente();
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textdni;
	private JTable tblModelo;
	private DefaultTableModel modelo;
	private JButton btnIngresar;
	private JScrollPane scrollPane;
	private JButton btnModificar;
	private Cliente cliente;
	private JButton btnEliminar;
	private JButton btnConsulta;
	private JButton btnListado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCliente frame = new frmCliente();
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

	public frmCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 670);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(24, 11, 86, 22);
		contentPane.add(lblNombres);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(24, 44, 86, 22);
		contentPane.add(lblApellidos);

		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(24, 77, 86, 22);
		contentPane.add(lblDireccin);

		JLabel lblTel = new JLabel("Teléfono:");
		lblTel.setBounds(24, 110, 86, 22);
		contentPane.add(lblTel);

		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(24, 143, 86, 22);
		contentPane.add(lblDni);

		textNombre = new JTextField();
		textNombre.setBounds(120, 12, 182, 29);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setBounds(120, 45, 182, 29);
		contentPane.add(textApellido);
		textApellido.setColumns(10);

		textDireccion = new JTextField();
		textDireccion.setBounds(120, 78, 182, 29);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setBounds(120, 111, 182, 29);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		textdni = new JTextField();
		textdni.setBounds(120, 144, 182, 29);
		contentPane.add(textdni);
		textdni.setColumns(10);

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
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Dirección");
		modelo.addColumn("Teléfono");
		modelo.addColumn("DNI");
		tblModelo.setModel(modelo);
		ajustarColumnas();

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
		listar();
		tblModelo.getSelectionModel().setSelectionInterval(0, 0);

	}

	String nombre, apellido, direccion;
	int codigo, dni, telefono;

	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < lc.tamanio(); i++) {
			Object[] file = { lc.obtener(i).getCodigo(), lc.obtener(i).getNombres(), lc.obtener(i).getApellidos(),
					lc.obtener(i).getDireccion(), lc.obtener(i).getTelefono(), lc.obtener(i).getDni(),

			};
			modelo.addRow(file);
		}
	}

	void obtenerDatos() {
		codigo = lc.codigoListaCliente();
		nombre = textNombre.getText();
		apellido = textApellido.getText();
		direccion = textDireccion.getText();

	}

	int leerDni() {
		return dni = Integer.parseInt(textdni.getText().trim());
	}

	int leerTelefono() {
		return telefono = Integer.parseInt(textTelefono.getText().trim());
	}

	void agregar() {
		obtenerDatos();
		leerDni();
		leerTelefono();
		Cliente cliente = new Cliente(codigo, nombre, apellido, direccion, telefono, dni);
		lc.agregarCliente(cliente);
		listar();

	}

	void limpieza() {
		textNombre.requestFocus();
		textNombre.setText("");
		textApellido.setText("");
		textdni.setText("");
		textTelefono.setText("");
		textDireccion.setText("");

	}

	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
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
		if(lc.tamanio()>0) {
			frmListadoCliente lista = new frmListadoCliente();
			lista.setVisible(true);
			lista.setLocationRelativeTo(this);
			lista.setResizable(false);
		}
		else {
			mensaje("No hay clientes");
		}
		

	}

	void actionPerformedBtnEliminar(ActionEvent e) {
		if (lc.tamanio() > 0) {
			int ok = confirmar("¿Está seguro de eliminar al cliente?");
			if (ok == 0) {
				int posFila = tblModelo.getSelectedRow();
				Cliente x = lc.obtener(posFila);
				lc.eliminarPos(x);
				listar();
				if (lc.tamanio() > 0) {
					codigoConsultado = lc.obtener(0).getCodigo();
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

	void actionPerformedBtnModificar(ActionEvent e) {
		int posFila = tblModelo.getSelectedRow();
		Cliente x = lc.obtener(posFila);
		String s = "CÓDIGO: " + x.getCodigo() + "\n" + "NOMBRE";

		try {
			nombre = adicionarModificar(s, x.getNombres());
			s += (" : " + nombre + "\n" + "APELLIDOS");
			apellido = adicionarModificar(s, x.getApellidos());
			s += (" : " + apellido + "\n" + "DIRECCIÓN");
			direccion = adicionarModificar(s, x.getDireccion());
			s += (" : " + direccion + "\n" + "TELÉFONO");
			telefono = Integer.parseInt(adicionarModificar(s, "" + x.getTelefono()));
			s += (" : " + telefono + "\n" + "DNI");
			dni = Integer.parseInt(adicionarModificar(s, "" + x.getDni()));
			s += (" : " + dni);
			int ok = verificar(s);
			if (ok == 0) {
				x.setNombres(nombre);
				x.setApellidos(apellido);
				x.setDireccion(direccion);
				x.setTelefono(telefono);
				x.setDni(dni);
				lc.actualizarArchivo();
				listar();
				tblModelo.getSelectionModel().setSelectionInterval(posFila, posFila);
			}
		} catch (Exception y) {

		}

	}

	void actionPerformedBtnIngresar(ActionEvent e) {

		obtenerDatos();
		if (nombre.length() > 0) {
			if (apellido.length() > 0) {
				if (direccion.length() > 0) {
					try {
						leerTelefono();
						try {
							leerDni();
							agregar();
							listar();
							limpieza();
						} catch (Exception x) {
							error("Ingrese DNI", textdni);
						}

					} catch (Exception x) {
						error("Ingrese teléfono", textTelefono);
					}

				} else {
					error("Ingrese direccion", textDireccion);
				}

			} else {
				error("Ingrese apellido", textApellido);
			}

		} else {
			error("Ingrese nombre", textNombre);
		}

	}

	void actionPerformedBtnConsulta(ActionEvent e) {

		frmConsultaCliente consulta = new frmConsultaCliente();

		consulta.setVisible(true);
		consulta.setLocationRelativeTo(this);
		consulta.setResizable(false);
		int posFila = tblModelo.getSelectedRow();
		Cliente x = lc.obtener(posFila);
		consulta.mostrarInformacionCliente(x);

	}

	void ajustarColumnas() {
		TableColumnModel tcm = tblModelo.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20)); // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20)); // apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25)); // direccion
		tcm.getColumn(4).setPreferredWidth(anchoColumna(14)); // telefono
		tcm.getColumn(5).setPreferredWidth(anchoColumna(13)); // DNI
	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
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
}
