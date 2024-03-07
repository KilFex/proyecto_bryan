package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import arreglos.Lista_Cliente;
import arreglos.Lista_Productos;

public class frmListadoProducto extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmListadoProducto frame = new frmListadoProducto();
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
	public frmListadoProducto() {
		setTitle("Lista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 419, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 383, 477);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		scrollPane.setViewportView(textArea);
		cargarDatos();

	}

	Lista_Productos lp = new Lista_Productos();

	void cargarDatos() {

		for (int i = 0; i < lp.tamanio(); i++) {

			textArea.append("\t CODIGO : " + lp.obtener(i).getCodigo() + "\n");
			textArea.append("\t NOMBRE : " + lp.obtener(i).getNombre() + "\n");
			textArea.append("\t PRECIO : " + lp.obtener(i).getPrecio() + "\n");
			textArea.append("\t STOCK ACTUAL : " + lp.obtener(i).getStockActual() + "\n");
			textArea.append("\t STOCK MINIMO : " + lp.obtener(i).getStockMinimo() + "\n");
			textArea.append("\t STOCK MAXIMO : " + lp.obtener(i).getStockMaximo() + "\n");
			textArea.append("\n");
			textArea.append("-----------------------------------------------------------\n");
			textArea.setCaretPosition(0);
		}

	}
}
