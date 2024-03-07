package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.Lista_Cliente;
import arreglos.Lista_Productos;
import clases.Cliente;
import clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frmVentas extends JFrame implements ActionListener{

	Lista_Cliente lc = new Lista_Cliente();
	Lista_Productos lp = new Lista_Productos();
	private JPanel contentPane;
	private JTextField textCodigoCliente;
	private JTextField textCodigoProducto;
	private JTextField textNombreProducto;
	private JTextField textPrecio;
	private JTextField textStockActual;
	private JTextField textStockMinimo;
	private JTextField textStockMaximo;
	private JTextField textNombreCliente;
	private JTextField textApellido;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textDni;
	private JButton btnBuscar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmVentas frame = new frmVentas();
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
	public frmVentas() {
		setTitle("Ventas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoCliente = new JLabel("Codigo cliente:");
		lblCodigoCliente.setBounds(10, 31, 97, 22);
		contentPane.add(lblCodigoCliente);
		
		textCodigoCliente = new JTextField();
		textCodigoCliente.setBounds(117, 24, 182, 29);
		textCodigoCliente.setColumns(10);
		contentPane.add(textCodigoCliente);
		
		JLabel lblCodigoProducto = new JLabel("Codigo Producto:");
		lblCodigoProducto.setBounds(325, 31, 118, 22);
		contentPane.add(lblCodigoProducto);
		
		textCodigoProducto = new JTextField();
		textCodigoProducto.setBounds(467, 24, 182, 29);
		textCodigoProducto.setColumns(10);
		contentPane.add(textCodigoProducto);
		
		JLabel lblNombres = new JLabel("Nombre:");
		lblNombres.setBounds(327, 83, 86, 22);
		contentPane.add(lblNombres);
		
		textNombreProducto = new JTextField();
		textNombreProducto.setBounds(467, 76, 182, 29);
		textNombreProducto.setEditable(false);
		textNombreProducto.setColumns(10);
		contentPane.add(textNombreProducto);
		
		JLabel lblApellidos = new JLabel("Precio:");
		lblApellidos.setBounds(327, 116, 86, 22);
		contentPane.add(lblApellidos);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(467, 109, 182, 29);
		textPrecio.setEditable(false);
		textPrecio.setColumns(10);
		contentPane.add(textPrecio);
		
		JLabel lblDireccin = new JLabel("Stock Actual:");
		lblDireccin.setBounds(327, 149, 86, 22);
		contentPane.add(lblDireccin);
		
		textStockActual = new JTextField();
		textStockActual.setBounds(467, 142, 182, 29);
		textStockActual.setEditable(false);
		textStockActual.setColumns(10);
		contentPane.add(textStockActual);
		
		JLabel lblTel = new JLabel("Stock Minimo:");
		lblTel.setBounds(327, 182, 86, 22);
		contentPane.add(lblTel);
		
		textStockMinimo = new JTextField();
		textStockMinimo.setBounds(467, 175, 182, 29);
		textStockMinimo.setEditable(false);
		textStockMinimo.setColumns(10);
		contentPane.add(textStockMinimo);
		
		JLabel lblDni = new JLabel("Stock Maximo:");
		lblDni.setBounds(327, 215, 97, 22);
		contentPane.add(lblDni);
		
		textStockMaximo = new JTextField();
		textStockMaximo.setBounds(467, 208, 182, 29);
		textStockMaximo.setEditable(false);
		textStockMaximo.setColumns(10);
		contentPane.add(textStockMaximo);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setBounds(117, 76, 182, 29);
		textNombreCliente.setEditable(false);
		textNombreCliente.setColumns(10);
		contentPane.add(textNombreCliente);
		
		JLabel lblNombres_1 = new JLabel("Nombres:");
		lblNombres_1.setBounds(21, 83, 86, 22);
		contentPane.add(lblNombres_1);
		
		JLabel lblApellidos_1 = new JLabel("Apellidos:");
		lblApellidos_1.setBounds(21, 116, 86, 22);
		contentPane.add(lblApellidos_1);
		
		textApellido = new JTextField();
		textApellido.setBounds(117, 109, 182, 29);
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		contentPane.add(textApellido);
		
		JLabel lblDireccin_1 = new JLabel("Dirección:");
		lblDireccin_1.setBounds(21, 149, 86, 22);
		contentPane.add(lblDireccin_1);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(117, 142, 182, 29);
		textDireccion.setEditable(false);
		textDireccion.setColumns(10);
		contentPane.add(textDireccion);
		
		JLabel lblTel_1 = new JLabel("Teléfono:");
		lblTel_1.setBounds(21, 182, 86, 22);
		contentPane.add(lblTel_1);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(117, 175, 182, 29);
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		contentPane.add(textTelefono);
		
		JLabel lblDni_1 = new JLabel("Dni:");
		lblDni_1.setBounds(21, 215, 86, 22);
		contentPane.add(lblDni_1);
		
		textDni = new JTextField();
		textDni.setBounds(117, 208, 182, 29);
		textDni.setEditable(false);
		textDni.setColumns(10);
		contentPane.add(textDni);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(191, 268, 108, 33);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
		
		btnFacturar = new JButton("Facturar");
		btnFacturar.setBounds(335, 268, 108, 33);
		contentPane.add(btnFacturar);
	}
	
	String nombreCliente, nombreProducto, apellido, direccion;
	int telefono,dni,stockActual,stockMinimo,stockMaximo;
	double precio;
	private JButton btnFacturar;
	
	void obtener() {
		nombreCliente = textNombreCliente.getText();
		nombreProducto = textNombreProducto.getText();
		apellido = textApellido.getText();
		direccion = textDireccion.getText();
	}
	
	int leerTelefono() {
		return telefono = Integer.parseInt(textTelefono.getText());
	}
	
	int leerDni() {
		return dni = Integer.parseInt(textDni.getText());
	}
	
	int leerStockActual() {
		return stockActual = Integer.parseInt(textStockActual.getText());
	}
	
	int leerStockMinimo() {
		return stockMinimo = Integer.parseInt(textStockMinimo.getText());
	}
	
	int leerStockMaximo() {
		return stockMaximo = Integer.parseInt(textStockMaximo.getText());
	}
	
	double obtenerDatosAdicionales() {
		return precio = Double.parseDouble(textPrecio.getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if(e.getSource() == btnFacturar) {
			actionPerformedBtnFacturar(e);
		}
		
	}
	
	void actionPerformedBtnFacturar(ActionEvent e) {
		
	}
	
	void actionPerformedBtnBuscar(ActionEvent e) {
		String codigoCliente = String.valueOf(leerCodigoCliente());
		String codigoProducto =  String.valueOf(leerCodigoProducto());
		
		if(codigoCliente.length()>0) {
			Cliente x = lc.buscarCliente(leerCodigoCliente());
			if (x != null) {
				textNombreCliente.setText(x.getNombres());
				textApellido.setText(x.getApellidos());
				textDireccion.setText(x.getDireccion());
				textTelefono.setText("" + x.getTelefono());
				textDni.setText("" + x.getDni());
				if (codigoProducto.length()>0) {
					Producto y = lp.buscarCliente(leerCodigoProducto());
					if (y != null) {
						textNombreProducto.setText(y.getNombre());
						textPrecio.setText("" + y.getPrecio());
						textStockActual.setText("" + y.getStockActual());
						textStockMaximo.setText("" + y.getStockMaximo());
						textStockMinimo.setText("" + y.getStockMinimo());
					} else {
						mensaje("Ingrese un codigo de producto valido");
					}
				} else {
					mensaje("El codigo no existe");
				}
			}
			else {
				mensaje("Ingrese un codigo de cliente valido");
			}
				}else {
					mensaje("El codigo no existe");
				}
	
	}
	
	int leerCodigoCliente() {
		return Integer.parseInt(textCodigoCliente.getText().trim());
	}
	
	int leerCodigoProducto() {
		return Integer.parseInt(textCodigoProducto.getText().trim());
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Persona", 1);
	}
}
