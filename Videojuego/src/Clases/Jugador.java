package Clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Jugador extends ObjetoJuego{
	
	private int vidas;
	private HashMap<String, Animacion> animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int direccion=1;
	private int multiplicador=1;
	
	public int getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}

	public Jugador(int velocidad, int x, int y, String nombreImagen, int vidas,String animacionActual) {
		super(velocidad, x, y, nombreImagen);
		this.vidas = vidas;
		this.animacionActual=animacionActual;
		animaciones = new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}

	
	
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public void inicializarAnimaciones() {
	
//correr
		Rectangle coordenadasCorrer[]= {
				new Rectangle(26,147,47,37),
				new Rectangle(64,147,47,37),
				new Rectangle(109,147,47,37),
				new Rectangle(157,147,47,37),
			
		};
		Animacion animacionCorrer =new Animacion(0.05, coordenadasCorrer);
		animaciones.put("correr", animacionCorrer);
		
//reposo
		Rectangle CoordenadasReposo[]= {
				new Rectangle(27,671,47,66)
		};
		Animacion animacionReposo =new Animacion(0.05, CoordenadasReposo);
		animaciones.put("reposo", animacionReposo);
		
//correr arriba
		Rectangle coordenadasCorrerArriba[]= {
				new Rectangle(28,399,56,53),
				new Rectangle(84,399,56,53),
				new Rectangle(140,399,56,53),
				new Rectangle(195,399,56,53),
		};
		Animacion animacionCorrerArriba =new Animacion(0.05, coordenadasCorrerArriba);
		animaciones.put("correrArriba", animacionCorrerArriba);
		
//correr abajo
		Rectangle coordenadasCorrerAbajo[]= {
				new Rectangle(27,671,47,66),
				new Rectangle(93,671,47,66),
				new Rectangle(159,671,47,66),
				new Rectangle(223,671,47,66),
		};
		Animacion animacionCorrerAbajo =new Animacion(0.05, coordenadasCorrerAbajo);
		animaciones.put("correrAbajo", animacionCorrerAbajo);
		
	}
	
	public void calcularFrame(double t) {
		Rectangle coordenadas=animaciones.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		this.altoImagen=(int)coordenadas.getWidth();
		this.anchoImagen=(int)coordenadas.getHeight();

	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, (direccion*anchoImagen)-5, altoImagen);
	}

	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen, altoImagen, x, y, multiplicador*direccion*anchoImagen, multiplicador*anchoImagen);
		graficos.setStroke(Color.RED);
		graficos.strokeRect(x, y, anchoImagen-8, altoImagen);
	}
	
	public void mover() {
		if (Juego.derecha)
			x+=velocidad;
		
		if (Juego.izquierda)
			x-=velocidad;

		if (Juego.abajo)
			y+=velocidad;

		if (Juego.arriba)
			y-=velocidad;
	}
	
	public void verificarColisionesItem(Item item) {
		if (!item.isCapturado() && this.obtenerRectangulo().getBoundsInLocal().intersects(item.obtenerRectangulo().getBoundsInLocal())){
			this.vidas += item.getCantidadVidas();
			item.setCapturado(true);
		}
	}
}
