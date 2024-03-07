package gui;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.Lista_Cliente;
import clases.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class frmListadoCliente extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmListadoCliente frame = new frmListadoCliente();
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
	public frmListadoCliente() {
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
	
	Lista_Cliente ap = new Lista_Cliente();	
	
	
	
	
	void cargarDatos() {
		
		for(int i=0; i<ap.tamanio(); i++) {
			
			textArea.append("\t CODIGO : "+ap.obtener(i).getCodigo()+"\n");
			textArea.append("\t NOMBRE : "+ap.obtener(i).getNombres()+"\n");
			textArea.append("\t APELLIDO : "+ap.obtener(i).getApellidos()+"\n");
			textArea.append("\t DNI : "+ap.obtener(i).getDni()+"\n");
			textArea.append("\t DIRECCIÓN : "+ap.obtener(i).getDireccion()+"\n");
			textArea.append("\t TELÉFONO : "+ap.obtener(i).getTelefono()+"\n");
			textArea.append("\n");
			textArea.append("-----------------------------------------------------------\n");
			textArea.setCaretPosition(0);
		}
		
	}
	
	
	
	
	
}
