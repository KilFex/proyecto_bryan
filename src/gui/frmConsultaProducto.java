package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Producto;

public class frmConsultaProducto extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaProducto frame = new frmConsultaProducto();
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
	public frmConsultaProducto() {
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 312, 211);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Sitka Text", Font.ITALIC, 22));
	}
	
	void mostrarInformacionCliente(Producto x) {
		textArea.append("CODIGO : "+x.getCodigo()+"\n");
		textArea.append("NOMBRE : "+x.getNombre()+"\n");
		textArea.append("PRECIO : "+x.getPrecio()+"\n");
		textArea.append("STOCK ACTUAL : "+x.getStockActual()+"\n");
		textArea.append("STOCK MINIMO : "+x.getStockMinimo()+"\n");
		textArea.append("STOCK MAXIMO : "+x.getStockMaximo()+"\n");
		textArea.setCaretPosition(0);
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

}
