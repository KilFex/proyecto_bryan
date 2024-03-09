package gui;

import java.awt.EventQueue;
import clases.Almacen;
import clases.Producto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class frmAlmacen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNuevoStock;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox cboCodigoProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAlmacen frame = new frmAlmacen();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//Almacen agregarStock = new Almacen();
	public frmAlmacen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("ALMANCEN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(242, 11, 86, 28);
		contentPane.add(lblNewLabel);
		
		txtNuevoStock = new JTextField();
		txtNuevoStock.addActionListener(this);
		txtNuevoStock.setBounds(266, 112, 86, 20);
		contentPane.add(txtNuevoStock);
		txtNuevoStock.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Agregar nuevo stock");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(88, 111, 142, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ingrese codigo producto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(88, 65, 168, 20);
		contentPane.add(lblNewLabel_2);
		
		cboCodigoProducto = new JComboBox();
		cboCodigoProducto.addActionListener(this);
		cboCodigoProducto.setBounds(266, 65, 86, 22);
		contentPane.add(cboCodigoProducto);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCodigoProducto) {
			actionPerformedCboCodigoProducto(e);
		}
		if (e.getSource() == txtNuevoStock) {
			actionPerformedTxtNuevoStock(e);
		}
	}
	protected void actionPerformedTxtNuevoStock(ActionEvent e) {
		
		
	}
	protected void actionPerformedCboCodigoProducto(ActionEvent e) {
	}
}
