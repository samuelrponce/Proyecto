package Clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigo3 extends ObjetoJuego {
	

	private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int vidas;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private int idEnemigo;
	private boolean colision=false;
	
	
	public Enemigo3(int idEnemigo,int velocidad, int x, int y, String nombreImagen,	String animacionActual, int vidas) {
		super(velocidad, x, y, nombreImagen);
		animaciones = new HashMap<String, Animacion>();
		this.animacionActual = animacionActual;
		this.vidas = vidas;
	
		this.idEnemigo = idEnemigo;
		inicializarAnimaciones();
	}

	public void inicializarAnimaciones() {
		
	
				
		//reposo
				Rectangle CoordenadasReposo[]= {
						new Rectangle(0,156,37,34),	
						new Rectangle(39,156,37,33),		
						new Rectangle(78,156,37,33),		
						new Rectangle(120,156,35,34),	
						new Rectangle(158,159,34,35),	
						new Rectangle(196,159,34,36),		
						new Rectangle(237,158,35,34),		
				};
				Animacion animacionReposo =new Animacion(0.05, CoordenadasReposo);
				animaciones.put("reposo", animacionReposo);
				
		//correr arriba
				Rectangle coordenadasCorrerArriba[]= {
						new Rectangle(2,236,35,35),
						new Rectangle(41,236,35,34),
						new Rectangle(81,236,35,34),
						new Rectangle(120,236,35,34),
						new Rectangle(159,236,35,35),
						new Rectangle(198,236,35,34),
						
				};
				Animacion animacionCorrerArriba =new Animacion(0.05, coordenadasCorrerArriba);
				animaciones.put("correrArriba", animacionCorrerArriba);
				
	
				
			}
	
	public void calcularFrame(double t) {
		Rectangle coordenadas=animaciones.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		this.altoImagen=(int)coordenadas.getWidth();
		this.anchoImagen=(int)coordenadas.getHeight();
		
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y-5, anchoImagen-5, altoImagen-5);
	}
	
	
	public HashMap<String, Animacion> getAnimaciones() {
		return animaciones;
	}


	public void setAnimaciones(HashMap<String, Animacion> animaciones) {
		this.animaciones = animaciones;
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


	public int getIdEnemigo() {
		return idEnemigo;
	}


	public void setIdEnemigo(int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}


	@Override
	public void pintar(GraphicsContext graficos) {
		
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen, altoImagen, x, y, anchoImagen,anchoImagen);		
		
	}

	@Override
	public void mover( ) {
		if(x>Juego.coordenadaX) {
			x-=1;
			
		}else {
			 x+=1;
			
		}
		if(y>Juego.coordenadaY) {
			y-=1;
			
		}else {
			 y+=1;
			 
		}	
	}
	
	public void verificarColisionJugador(Jugador jugador) {
		if (obtenerRectangulo().getBoundsInLocal().intersects(jugador.obtenerRectangulo().getBoundsInLocal()) ) {
			jugador.setVidas(jugador.getVidas()-1);
			setColision(true);
			this.y=y-900;
			 
		}
		else {
			setColision(false);
		}
	}
	
	
	

	public boolean isColision() {
		return colision;
	}

	public void setColision(boolean colision) {
		this.colision = colision;
	}	
}