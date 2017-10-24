package model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.SingleSelectionModel;

import Objetos.Libro;
import view.*;

public class GestionDatos {

	public GestionDatos() {

	}

	private LaunchView view;

	// TODO: Implementa una función para abrir ficheros
	int numBytes;

	public BufferedReader abrirFichero(String fichero) {
		try {
			FileReader fileR = new FileReader(fichero);
			
			//Leemos el fichero
			BufferedReader fileBR = new BufferedReader(fileR);
			
			//Lo devolvemos
			return fileBR;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al abrir " + fichero);
			return null;
		}
		
		
	}

	// TODO: Implementa una funcion para cerrar ficheros
	public void cerrarFichero(BufferedReader fichero) {
		try {
			//Cerramos el fichero
			fichero.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se ha podido cerrar "+fichero);
		}
	}

	public boolean compararContenido(String fichero1, String fichero2) throws IOException {
		// TODO: Implementa la función
		
		BufferedReader file1 = abrirFichero(fichero1);
		BufferedReader file2 = abrirFichero(fichero2);
		
		String cadena1, cadena2;
		
		//Mientras haya alguna palabra dentro del fichero...
		while ((cadena1 = file1.readLine()) != null && (cadena2 = file2.readLine()) != null){
			
			//Si no encuentra la misma palabra en los dos ficheros
			if(!cadena1.equals(cadena2)){
				cerrarFichero(file1);
				cerrarFichero(file2);
				
				return false;
			}
			
		}

		return true;
	}

	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la funcion
		
		BufferedReader archivo1 = abrirFichero(fichero1);
		String cadena1;
		
				
		if (primera_aparicion){
			//Primera aparicion
			int i=0;
			while ((cadena1 = archivo1.readLine()) != null){
				i++;
				if (cadena1.equals(palabra)){
					cerrarFichero(archivo1);
					return i;
				}
			}
		} else {
			//Ultima palabra encontrada
			int i=0, line = -1;
			while ((cadena1 = archivo1.readLine()) != null){
				i++;
				if (cadena1.equals(palabra)){
					line = i;
				}
			}
			
			//Si no ha encontrado ninguna linea, dejalo, sino dale la ultima escrita
			if (line != -1){
				return line;
			} else {
				return -1;
			}
		}
		
		return -1;
		
	}
		
	
	
	public static void intentarCerrar(Closeable c){
		
		try {
			c.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public int copiarArchivo(String fichero1, String fichero2)throws IOException,FileNotFoundException{
		//TODO: Implementa la funcion
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try{
			 fis = new FileInputStream(fichero1); // -> Archivo a copiar
			 fos = new FileOutputStream(fichero2); // -> Copia del archivo
			byte [] buffer = new byte [1024];
			int len=0;
			
			fis.read(buffer);
			fos.write(buffer);
			while ((len = fis.read(buffer)) > 0) {
				  fos.write(buffer, 0, len);
				  numBytes=numBytes+1024;
				}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			intentarCerrar(fis);
			intentarCerrar(fos);
		
			
		
		}
		return numBytes;
		}
	
	public int guardar_libro(Libro libro) throws IOException{
		
		//Creamos el fichero
		File f = new File("libro-"+ libro.getIdentificador() + ".txt");
		
		//Si el fichero ya existe...
		if(f.exists()){
			
			System.out.println("Este libro ya esta creado");
			
			view.setTextArea("Este libro ya esta creado");
			view.setTextArea("---------------------------------------------------");
		}else{
			

			f.createNewFile();
			
			ObjectOutputStream objFile = new ObjectOutputStream(new FileOutputStream(f));
			
			//Escribimos los datos en el fichero
			objFile.writeObject(libro);
			
		}
		return 1;
	}
	
	public Libro recuperar_libro(String identificador) throws FileNotFoundException, IOException{
		
		//Creamos el fichero con el identificador que ha introducido el usuario
		File file_recuperado = new File("libro-"+ identificador + ".txt");
		
		//Comprobamos si existe el libro
		if(!file_recuperado.exists()){
			 
			return null;
		
		}
		//Creamos el lector
		ObjectInputStream lector = new ObjectInputStream(new FileInputStream(file_recuperado));
		
		
		Libro lb_recuperado;
		
		try {
			//Leemos el fichero
			lb_recuperado = (Libro) lector.readObject();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		lector.close();
		return lb_recuperado;

	}
	
	public ArrayList<Libro> recuperar_todos() throws FileNotFoundException, IOException{
		
		//Creamos el ArrayList del objeto libro
		ArrayList<Libro> biblioteca = new ArrayList<Libro>();
		
		File carpeta = new File(".");
		
		String [] archivos = carpeta.list();
		
		for (int i = 0; i < archivos.length; i++) {
			
			//Si el fichero empieza por libro-...
			if(archivos[i].startsWith("libro-")){
				String identidad = archivos[i].substring(6, archivos[i].length()-4);
				
				System.out.println(identidad);
				
				//Lo introducimos en el arrayList
				biblioteca.add(recuperar_libro(identidad));
				
				
			}
			
		}
		return biblioteca;
		
	}
}

