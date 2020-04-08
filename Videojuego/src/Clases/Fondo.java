package Clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo extends ObjetoJuego{
	private String nombreImagen2;
	private int y2;

	public Fondo(int velocidad, int x, int y, String nombreImagen, String nombreImagen2) {
		super(velocidad, x, y, nombreImagen);
		this.nombreImagen2=nombreImagen2;
		this.ancho=(int)Juego.imagenes.get("back").getWidth();
		this.alto=(int)Juego.imagenes.get("back").getHeight();
		this.y2=this.alto+this.y;
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen), x, y);
		graficos.drawImage(Juego.imagenes.get(nombreImagen2), x, y-alto);
	}

	@Override
	public void mover() {
		
			if (Juego.abajo)
				y-=velocidad;
				y2-=velocidad;
			
			
			if(Juego.arriba)
				y+=velocidad;
				y2+=velocidad;
	}
	
}
