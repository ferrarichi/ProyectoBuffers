package Objetos;

import java.io.Serializable;

public class Libro implements Serializable {

	
	private String identificador;
	private String titulo;
	private String autor;
	private String ano_publicacion;
	private String editor;
	private String paginas;

	public Libro(String identificador, String titulo, String autor, String ano_publicacion, String editor,
			String paginas) {
		super();
		this.identificador = identificador;
		this.titulo = titulo;
		this.autor = autor;
		this.ano_publicacion = ano_publicacion;
		this.editor = editor;
		this.paginas = paginas;
	}
	
	public String mostrarDatos() {
		String datos = "";

		datos += ("Identificador: " + this.identificador + "\n");
		datos += ("Titulo: " + this.titulo + "\n");
		datos += ("Autor: " + this.autor + "\n");
		datos += ("Año publicación: " + this.ano_publicacion + "\n");
		datos += ("Editor: " + this.editor + "\n");
		datos += ("Número Páginas: " + this.paginas + "\n");
		datos += ("------------------------------------"+  "\n");
		
		
		
		return datos;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAno_publicacion() {
		return ano_publicacion;
	}
	public void setAno_publicacion(String ano_publicacion) {
		this.ano_publicacion = ano_publicacion;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	
}
