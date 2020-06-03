package Clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Disparo  {
	
	private int anchoImagen;
	private int altoImagen;
	private String nombreImagen;
	private int velocidad;
	private int x;
	private int y;
	private boolean colision=false;


	public boolean isColision() {
		return colision;
	}


	public void setColision(boolean colision) {
		this.colision = colision;
	}


	public Disparo(int velocidad, int anchoImagen, int altoImagen, String nombreImagen, int x, int y) {
		super();
		this.velocidad=velocidad;
		this.anchoImagen = anchoImagen;
		this.altoImagen = altoImagen;
		this.nombreImagen = nombreImagen;
		this.x = x;
		this.y = y;
		
	}


	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y-5, anchoImagen-5, altoImagen-5);
	}
	
	
	public void pintar(GraphicsContext graficos) {
		
				graficos.drawImage(Juego.imagenes.get(nombreImagen), x,y, anchoImagen,anchoImagen);	
				
	}
	
	public boolean limiteDisparo() {
		if (y<0) {
			return false;
		}
		return true;
	}

	public void mover() {
		y-=velocidad;
	}

	public int getAnchoImagen() {
		return anchoImagen;
	}


	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}


	public int getAltoImagen() {
		return altoImagen;
	}


	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}


	public String getNombreImagen() {
		return nombreImagen;
	}


	public void setNombreImagen(String nombreImagen) {
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

	public void verificarColision(Enemigo1 enemigo1, Enemigo2 enemigo2, Enemigo3 enemigo3, Jugador jugador){
		if (obtenerRectangulo().getBoundsInLocal().intersects(enemigo1.obtenerRectangulo().getBoundsInLocal()) ) {
			jugador.setPuntuacion(jugador.getPuntuacion()+20);
			enemigo1.setY(enemigo1.getY()-500);
			enemigo1.setX(enemigo1.getX()-500);
			setColision(true);
		} 
		
		if (obtenerRectangulo().getBoundsInLocal().intersects(enemigo2.obtenerRectangulo().getBoundsInLocal()) ) {
			jugador.setPuntuacion(jugador.getPuntuacion()+20);
			enemigo2.setY(enemigo2.getY()-1000);
			enemigo2.setX(enemigo2.getX()+ 500);
			setColision(true);
		} 
		if (obtenerRectangulo().getBoundsInLocal().intersects(enemigo3.obtenerRectangulo().getBoundsInLocal()) ) {
			jugador.setPuntuacion(jugador.getPuntuacion()+20);
			enemigo3.setY(enemigo3.getY()-2000);
			enemigo3.setX(enemigo3.getX()-10500);
			setColision(true);
		} 
		
	}

}
