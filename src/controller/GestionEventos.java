package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;

import Objetos.Libro;
import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private Libro Objetos;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_copiar, actionListener_libro,
	actionListener_recuperarLibro, actionListener_recuperarTodo;
	
	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				try {
					call_compararContenido();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				
				try {
					call_buscarPalabra();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		
		actionListener_copiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_copiarContenido
				try {
					call_copiarContenido();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.getCopiar().addActionListener(actionListener_copiar);

		
		actionListener_libro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_Libro
				try {
					call_guardarLibro();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();
				}
			}
		};
		view.getBtnGuardar().addActionListener(actionListener_libro);
		
		actionListener_recuperarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_Libro
				try {
					call_recuperarLibro();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();
				}
			}
		};
		view.getBtnRecuperarBoton().addActionListener(actionListener_recuperarLibro);
		
		actionListener_recuperarTodo = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				try {
					call_recuperarTodo();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.getBtnRecuperarTodo().addActionListener(actionListener_recuperarTodo);
	}

	private int call_compararContenido() throws IOException {

		// TODO: Llamar a la función compararContenido de GestionDatos
		
		//Llama al metodo de la clase model y le pasa los datos introducidos por el uuario
		boolean coinciden = model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
		
		if(view.getFichero1().getText().isEmpty() || view.getFichero2().getText().isEmpty()){
			
			view.setTextArea("Introduce los datos que te faltan");
			view.setTextArea("---------------------------------------------------");
		}
		//Se comprueba si coincicen los ficheros
		if(coinciden){
			
			System.out.println("El fichero 1 = "+view.getFichero1().getText() + " es igual que el fichero 2 = "+ view.getFichero2().getText());
			
			view.setTextArea("El fichero 1 = "+view.getFichero1().getText() + " es igual que el fichero 2 = "+ view.getFichero2().getText());
			view.setTextArea("---------------------------------------------------");

		} else {
			System.out.println("El fichero 1 = "+view.getFichero1().getText() + " no coincide con el fichero 2 = "+ view.getFichero2().getText());

			view.setTextArea("El fichero 1 = "+view.getFichero1().getText() + " no coincide con el fichero 2 = "+ view.getFichero2().getText());
			view.setTextArea("---------------------------------------------------");

		}
		// TODO: Gestionar excepciones
		return 1;
	}

	private int call_buscarPalabra() throws IOException {

		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		
		//Llamamos al metodo de la clase model y le pasamos lo introducido por el usuario
		int linea = model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected());
			
		String TextFichero1 = view.getFichero1().getText();
		
		//Si esta vacio...
		if(!TextFichero1.isEmpty()){
			
		if(view.getPalabra().getText().isEmpty()){
			view.setTextArea("Introduce una palabra");
			view.setTextArea("---------------------------------------------------");
		}
		if(linea == -1){
			
			System.out.println("La palabra '"+ view.getPalabra().getText() + "' no se encuentra en el texto");
			
			view.setTextArea("La palabra '"+ view.getPalabra().getText() + "' no se encuentra en el texto");
		}else{
			
			if(view.getPrimera().isSelected()){
				
			System.out.println("La palabra '"+ view.getPalabra().getText() + "' se encuentra en la linea "+ linea + " y es la primera que se ha encontrado");
			view.setTextArea("La palabra '"+ view.getPalabra().getText() + "' se encuentra en la linea "+ linea + " y es la primera que se ha encontrado");

			}else{
				
				System.out.println("La palabra '"+ view.getPalabra().getText() + "' se encuentra en la linea "+ linea + " y es la ultima que se ha encontrado");
				view.setTextArea("La palabra '"+ view.getPalabra().getText() + "' se encuentra en la linea "+ linea + " y es la ultima que se ha encontrado");

			}
		}
		
		return 1;
		
		}else{
			
			view.setTextArea("Introduce un nombre de fichero");
			view.setTextArea("---------------------------------------------------");

		return 1;
		}
	}
	public void copiar() {

		
	}
	
	private int call_copiarContenido() throws IOException {
		
		
		//Llamamos al metodo de la clase model y le pasamos lo introducido por el usuario

		int copia = model.copiarArchivo(view.getFichero1().getText(), view.getFichero2().getText());
		
		if(view.getFichero1().getText().isEmpty() || view.getFichero2().getText().isEmpty()){
			
			view.setTextArea("Introduce los datos que te faltan");
			view.setTextArea("---------------------------------------------------");
			
		}
		//Comprobamos si se ha copiado correctamente
		if(copia != -1){
			
			System.out.println("Se ha copiado correctamente");
			
			view.setTextArea("Se ha copiado correctamente");
		}else{
			System.out.println("Error al copiarse");
			view.setTextArea("Error al copiarse");
		}
		

		return 1;
		
			
	}
	
	private int call_guardarLibro() throws IOException{
		
		//Llamamos al metodo de la clase model y le pasamos lo introducido por el usuario

		Libro lb = new Libro(view.getIdentificador().getText(), view.getTitulo().getText(), view.getAutor().getText(), view.getAnoProduccion().getText(),
				view.getEditor().getText(), view.getPaginas().getText());
		
		//Comprobamos si se han introducido los datos
		if(view.getIdentificador().getText().isEmpty() || view.getTitulo().getText().isEmpty() || view.getAutor().getText().isEmpty() || view.getAnoProduccion().getText().isEmpty() ||
				view.getEditor().getText().isEmpty() || view.getPaginas().getText().isEmpty()){
			
			view.setTextArea("Introduce los datos que te faltan");
			view.setTextArea("---------------------------------------------------");


		}
		
		int estado = model.guardar_libro(lb);
		
		view.setTextArea("El libro "+ lb.getTitulo() + " se ha guardado correctamente "+ "\n");
		view.setTextArea("---------------------------------------------------");

		
		return 1;
	}

	private int call_recuperarLibro() throws IOException{
		
		
		Libro libro_rec = model.recuperar_libro(view.getIdentificador().getText());
		
		if(libro_rec!=null){
			
			view.setTextArea(libro_rec.mostrarDatos());
			
		}
		return 1;

	}

	private int call_recuperarTodo() throws IOException{
	
		ArrayList <Libro> biblioteca = model.recuperar_todos();
		
		if(biblioteca.size() != 0){
			
			String pantalla = "Se han encontrado "+ biblioteca.size() + " libros" +  "\n";
			pantalla += ("---------------------------------------" + "\n");

			for (int i = 0; i < biblioteca.size(); i++) {
				
				pantalla += biblioteca.get(i).mostrarDatos();
				
			}
			
			view.setTextArea(pantalla);
		}
		return 1;
	}


}
