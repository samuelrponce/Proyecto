package Clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends ObjetoJuego {
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	public Tile(int tipoTile, int velocidad, int x, int y, String nombreImagen, int ancho, int alto) {
		super(velocidad, x, y, nombreImagen);
		this.alto=alto;
		this.ancho=ancho;
		
		switch(tipoTile) {
		case 1:
			this.xImagen=234;
			this.yImagen=0;
			break;
		case 2:
			this.xImagen=340;
			this.yImagen=0;
			break;
		case 3:
			this.xImagen=445;
			this.yImagen=0;
			break;
		case 4:
			this.xImagen=444;
			this.yImagen=107;
			break;
		case 5:
			this.xImagen=340;
			this.yImagen=106;
			break;
		case 6:
			this.xImagen=234;
			this.yImagen=107;
			break;
		case 7:
			this.xImagen=234;
			this.yImagen=209;
			break;
		case 8:
			this.xImagen=340;
			this.yImagen=209;
			break;
		case 9:
			this.xImagen=444;
			this.yImagen=209;
			break;
		case 10:
			this.xImagen=234;
			this.yImagen=522;
			break;
		case 11:
			this.xImagen=444;
			this.yImagen=522;
			break;
		case 12:
			this.xImagen=340;
			this.yImagen=628;
			break;
		case 13:
			this.xImagen=445;
			this.yImagen=628;
			break;
		case 14:
			this.xImagen=234;
			this.yImagen=628;
			break;
		case 15:
			this.xImagen=444;
			this.yImagen=731;
			break;
		case 16:
			this.xImagen=340;
			this.yImagen=731;
			break;
		case 17:
			this.xImagen=234;
			this.yImagen=731;
			break;
		}
	}
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
		
	}
	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
	 
	
}
