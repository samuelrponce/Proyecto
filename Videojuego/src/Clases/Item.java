package Clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends ObjetoJuego{
	private int cantidadVidas;
	private boolean capturado=false;
	private int tipoItem;

	public boolean isCapturado() {
		return capturado;
	}


	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}


	public Item(int velocidad, int x, int y, String nombreImagen, int cantidadVidas) {
		super(velocidad, x, y, nombreImagen);
		this.cantidadVidas= cantidadVidas;
		this.ancho=(int)Juego.imagenes.get(nombreImagen).getWidth();
		this.alto=(int)Juego.imagenes.get(nombreImagen).getHeight();
	//	switch(tipoTile) {
		//case 1:
			//this.xImagen=183;
		//	this.yImagen=0;
			//break;
	}

	
	public int getCantidadVidas() {
		return cantidadVidas;
	}


	public void setCantidadVidas(int cantidadVidas) {
		this.cantidadVidas = cantidadVidas;
	}

	public void obtenerTamaño() {
		
	}

	public void pintar(GraphicsContext graficos) {
		if (this.capturado)
			return;
		else {
		graficos.drawImage(Juego.imagenes.get(nombreImagen), x, y);
		
		}
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, ancho, alto);
	}

	
	public void mover() {
		
	}
}
