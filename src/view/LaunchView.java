package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class LaunchView extends JFrame {

	private JButton comparar,buscar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	
	private JPanel panel;
	private JButton copiar;
	private JPanel panel_1;
	private JLabel lblIdentificador;
	private JTextField identificador;
	private JLabel lblTitulo;
	private JTextField titulo;
	private JLabel lblAutor;
	private JTextField autor;
	private JLabel lblAnoProduccion;
	private JTextField anoProduccion;
	private JLabel lblEditor;
	private JTextField editor;
	private JLabel lblPaginas;
	private JTextField paginas;
	private JButton btnGuardar;
	private JButton btnRecuperarLibro;
	private JButton btnRecuperarTodo;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		
		primera = new JCheckBox("Primera aparición");

		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		panel.add(comparar);
		panel.add(buscar);
		
		copiar = new JButton("Copiar fichero");
		
		copiar.setPreferredSize(new Dimension(150, 26));
		panel.add(copiar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		
		btnRecuperarLibro = new JButton("Recuperar Libro");
		panel.add(btnRecuperarLibro);
		
		btnRecuperarTodo = new JButton("Recuperar todo");
		panel.add(btnRecuperarTodo);
		panel.add(primera);
		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
        
        panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.SOUTH);
        
        lblIdentificador = new JLabel("Identificador: ");
        lblIdentificador.setHorizontalAlignment(SwingConstants.LEFT);
        panel_1.add(lblIdentificador);
        
        identificador = new JTextField();
        panel_1.add(identificador);
        identificador.setColumns(10);
        
        lblTitulo = new JLabel("Titulo: ");
        panel_1.add(lblTitulo);
        
        titulo = new JTextField();
        panel_1.add(titulo);
        titulo.setColumns(10);
        
        lblAutor = new JLabel("Autor: ");
        panel_1.add(lblAutor);
        
        autor = new JTextField();
        panel_1.add(autor);
        autor.setColumns(10);
        
        lblAnoProduccion = new JLabel("A\u00F1o Produccion: ");
        panel_1.add(lblAnoProduccion);
        
        anoProduccion = new JTextField();
        panel_1.add(anoProduccion);
        anoProduccion.setColumns(10);
        
        lblEditor = new JLabel("Editor: ");
        panel_1.add(lblEditor);
        
        editor = new JTextField();
        panel_1.add(editor);
        editor.setColumns(10);
        
        lblPaginas = new JLabel("Paginas: ");
        panel_1.add(lblPaginas);
        
        paginas = new JTextField();
        panel_1.add(paginas);
        paginas.setColumns(10);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		
        	}
        });
        panel_1.add(btnGuardar);
		
	}	
	
	public JButton getBtnRecuperarLibro() {
		return btnRecuperarLibro;
	}

	public void setBtnRecuperarLibro(JButton btnRecuperarLibro) {
		this.btnRecuperarLibro = btnRecuperarLibro;
	}

	public JButton getBtnRecuperarTodo() {
		return btnRecuperarTodo;
	}

	public void setBtnRecuperarTodo(JButton btnRecuperarTodo) {
		this.btnRecuperarTodo = btnRecuperarTodo;
	}

	public JButton getBtnRecuperarBoton() {
		return btnRecuperarLibro;
	}

	public void setBtnRecuperarBoton(JButton btnRecuperarBoton) {
		this.btnRecuperarLibro = btnRecuperarBoton;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JTextField getIdentificador() {
		return identificador;
	}

	public void setIdentificador(JTextField identificador) {
		this.identificador = identificador;
	}

	public JTextField getTitulo() {
		return titulo;
	}

	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}

	public JTextField getAutor() {
		return autor;
	}

	public void setAutor(JTextField autor) {
		this.autor = autor;
	}

	public JTextField getAnoProduccion() {
		return anoProduccion;
	}

	public void setAnoProduccion(JTextField anoProduccion) {
		this.anoProduccion = anoProduccion;
	}

	public JTextField getEditor() {
		return editor;
	}

	public void setEditor(JTextField editor) {
		this.editor = editor;
	}

	public JTextField getPaginas() {
		return paginas;
	}

	public void setPaginas(JTextField paginas) {
		this.paginas = paginas;
	}

	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(String textArea) {
		this.textArea.setText(textArea);
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JTextField getPalabra() {
		return palabra;
	}

	public JCheckBox getPrimera() {
		return primera;
	}
	
	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton copiar) {
		this.copiar = copiar;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}



}
