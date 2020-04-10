package Clases;

import java.util.ArrayList;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class ObstaculosTiles extends ObjetoJuego {
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	
		
	 public ObstaculosTiles(int velocidad, int x, int y, String nombreImagen, int xImagen, int yImagen, int tipoTile) {
		super(velocidad, x, y, nombreImagen);
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.tipoTile = tipoTile;	
		switch(tipoTile){
			case 1:
				this.xImagen=183;
				this.yImagen=0;
			break;
			case 2:
				this.xImagen=265;
				this.yImagen=0;
			break;
		}
	}
		
		//public Rectangle obtenerRectangulo() {
		
		
		//public boolean verificarColisionobstaculo(Jugador jugador) {
			//if(obtenerRectangulo().intersects(jugador.obtenerRectangulo().getBoundsInLocal()))
				// jugador.setColision(true);		
			 //
				
			//	return false;
		//}
		
	//	public boolean verificarColisionPaso(Jugador jugador) {
		//	if(obtenerRectangulo().intersects(jugador.obtenerRectangulo().getBoundsInLocal()))
		//	{
				
		//	}
			
		//	return true;
	//	}
		
	public int getxImagen() {
			return xImagen;
		}
		public void setxImagen(int xImagen) {
			this.xImagen = xImagen;
		}
		public int getyImagen() {
			return yImagen;
		}
		public void setyImagen(int yImagen) {
			this.yImagen = yImagen;
		}
		@Override
		public void pintar(GraphicsContext graficos) {
			graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,ancho,alto,x,y,ancho,alto);
			mover();
			
		}
		@Override
		public void mover() {

			
			if(Juego.arriba)
				y+=velocidad;
					
		}
		
		
		 
		
	}

