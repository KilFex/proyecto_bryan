package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

//import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frmMantenimiento extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem btnClientes;
	private JMenuItem btnProductos;
	private JMenu mntmNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenuItem btnVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMantenimiento frame = new frmMantenimiento();
					frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 * 
	 */
	
	public frmMantenimiento() {
		/*FlatDarculaLaf.setup();
		UIManager.put("Button.arc", 20);
		UIManager.put("Component.arc", 20);
		UIManager.put("ProgressBar.arc", 20);
		UIManager.put("TextComponent.arc", 20);
		
		setFont(new Font("Franklin Gothic Book", Font.PLAIN, 12));
		setTitle("Sistema de ventas V0.1");*/
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 422);
		setLocationRelativeTo(null);
		setResizable(false);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu);
		
		btnClientes = new JMenuItem("Clientes");
		btnClientes.addActionListener(this);
		mnNewMenu.add(btnClientes);
		
		btnProductos = new JMenuItem("Productos");
		btnProductos.addActionListener(this);
		mnNewMenu.add(btnProductos);
		
		mntmNewMenu_1 = new JMenu("Ventas");
		menuBar.add(mntmNewMenu_1);
		
		btnVentas = new JMenuItem("Ventas");
		btnVentas.addActionListener(this);
		mntmNewMenu_1.add(btnVentas);
		
		mnNewMenu_2 = new JMenu("Almacen");
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_3 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClientes) {
			actionPerformedBtnClientes(e);
		}
		if(e.getSource() == btnProductos) {
			actionPerformedBtnProductos(e);
		}
		
		if(e.getSource() == btnVentas) {
			actionPerformedBtnVentas(e);
		}
		
	}
	
	void actionPerformedBtnVentas(ActionEvent e) {
		frmVentas ventas = new frmVentas();
		ventas.setVisible(true);
		ventas.setLocationRelativeTo(this);
		ventas.setResizable(false);
	}
	
	void actionPerformedBtnProductos(ActionEvent e) {
		frmProducto producto = new frmProducto();
		producto.setVisible(true);
		producto.setLocationRelativeTo(this);
		producto.setResizable(false);
	}
	
	void actionPerformedBtnClientes(ActionEvent e) {
		frmCliente cliente = new frmCliente();
		cliente.setVisible(true);
		cliente.setLocationRelativeTo(this);
		cliente.setResizable(false);
	}

}
