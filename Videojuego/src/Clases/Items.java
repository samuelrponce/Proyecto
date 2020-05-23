package Clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Items extends ObjetoJuego {
private int cantidadVidas;
private int cantidadPuntos;
private int tipoItem;
private int xImagen;
private int yImagen;
private boolean capturado=false;
 
	public Items( int tipoItem,int velocidad,int x, int y, String nombreImagen,int ancho, int alto ) { 
	super(velocidad, x, y, nombreImagen);
	this.alto=alto;
	this.ancho=ancho;
	this.setTipoItem( tipoItem);
	
	switch(this.getTipoItem()) {
	case 1:
			this.xImagen=257 ;
			this.yImagen=385;
		break;
	case 2:
		this.xImagen=289;
		this.yImagen=385;
	break;
	case 3:
		this.xImagen=321;
		this.yImagen=385;
	break;
	case 4:
		this.xImagen=353;
		this.yImagen=385;
	break;
	case 5:
		this.xImagen=257;
		this.yImagen=289;
	break;
	default:
		this.xImagen=406;
		this.yImagen=38;
			break;
	}
}
	
	public Rectangle obtenerRectangulo() {
		if(getTipoItem()==1 || getTipoItem()==2||getTipoItem()==3||getTipoItem()==4||getTipoItem()==5) {
			return new Rectangle(this.x,this.y, 30, 30);
			}
	
		
		else {
			return new Rectangle(0, 0, 0, 0);
		}
	}

public void verificarColisionesItem(Jugador jugador) {
		
		if ( !isCapturado() && jugador.obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal())&& tipoItem==1){
			jugador.setPuntuacion(jugador.getPuntuacion()+5) ;
			System.out.println("colision");
			setCapturado(true);
		}
		else if ( !isCapturado() && jugador.obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal())&& tipoItem==2){
			jugador.setPuntuacion(jugador.getPuntuacion()+10) ;
			System.out.println("colision");
			setCapturado(true);
		}
		else if ( !isCapturado() && jugador.obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal())&& tipoItem==3){
			jugador.setPuntuacion(jugador.getPuntuacion()+25) ;
			System.out.println("colision");
			setCapturado(true);
		}
		else if ( !isCapturado() && jugador.obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal())&& tipoItem==4){
			jugador.setPuntuacion(jugador.getPuntuacion()+50) ;
			System.out.println("colision");
			setCapturado(true);
		}
		else if ( !isCapturado() && jugador.obtenerRectangulo().getBoundsInLocal().intersects(this.obtenerRectangulo().getBoundsInLocal())&& tipoItem==5){
			jugador.setVidas(jugador.getVidas()+1);
			System.out.println("colision");
			setCapturado(true);
		}
	}
	
	public int getCantidadVidas() {
		return cantidadVidas;
	}

	public void setCantidadVidas(int cantidadVidas) {
		this.cantidadVidas = cantidadVidas;
	}

	public int getCantidadPuntos() {
		return cantidadPuntos;
	}

	public void setCantidadPuntos(int cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}

	public int getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(int tipoItem) {
		this.tipoItem = tipoItem;
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

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	@Override
	public void pintar(GraphicsContext graficos) {
		if (this.capturado)
			return;
		else {
			graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,ancho,alto,x,y,ancho,alto);
		}
		mover();
	}

	@Override
	public void mover() {

		if(Juego.arriba)
			y+=velocidad;
				
	}

}
