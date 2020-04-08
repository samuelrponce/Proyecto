package Clases;

import javafx.scene.canvas.GraphicsContext;

public abstract class ObjetoJuego {
	protected  int velocidad=10;
	protected  int x;
	protected  int y;
	protected  String nombreImagen;
	protected int ancho;
	protected int alto;
	
	public ObjetoJuego(int velocidad, int x, int y, String nombreImagen) {
		super();
		this.velocidad = velocidad;
		this.x = x;
		this.y = y;
		this.nombreImagen = nombreImagen;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public abstract void pintar(GraphicsContext graficos);
	
	public abstract void mover();
}
