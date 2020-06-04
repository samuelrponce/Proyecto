package Clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigo1 extends ObjetoJuego {
	

	private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int vidas;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private int idEnemigo;
	private boolean colision=false;
	
	
	public Enemigo1(int idEnemigo,int velocidad, int x, int y, String nombreImagen,	String animacionActual, int vidas) {
		super(velocidad, x, y, nombreImagen);
		animaciones = new HashMap<String, Animacion>();
		this.animacionActual = animacionActual;
		this.vidas = vidas;
	
		this.idEnemigo = idEnemigo;
		inicializarAnimaciones();
	}

	public void inicializarAnimaciones() {
		
		//correrDerecha
						Rectangle coordenadasCorrerIzquierda[]= {
								new Rectangle(26,893,68,57),
								new Rectangle(106,892,68,57),
								new Rectangle(187,892,68,57),
								new Rectangle(267,891,69,56),
								new Rectangle(347,894,66,56),
								new Rectangle(427,893,67,57),
								new Rectangle(507,893,68,57),
								new Rectangle(587,892,68,57),
								new Rectangle(667,894,66,57),
						};
						Animacion animacionCorrerIzquierda =new Animacion(0.05, coordenadasCorrerIzquierda);
						animaciones.put("correrIzquierda", animacionCorrerIzquierda);
						
		//correrDerecha
				Rectangle coordenadasCorrerDerecha[]= {
						new Rectangle(12,7,66,57),
						new Rectangle(92,5,68,57),
						new Rectangle(172,6,68,57),
						new Rectangle(252,6,67,57),
						new Rectangle(332,7,66,57),
						new Rectangle(412,4,69,57),
						new Rectangle(492,5,68,57),
						new Rectangle(573,5,68,57),
						new Rectangle(653,6,68,57),			
				};
				Animacion animacionCorrerDerecha =new Animacion(0.05, coordenadasCorrerDerecha);
				animaciones.put("correrDerecha", animacionCorrerDerecha);
				
		//reposo
				Rectangle CoordenadasReposo[]= {
						new Rectangle(12,7,66,57)				
				};
				Animacion animacionReposo =new Animacion(1.5, CoordenadasReposo);
				animaciones.put("reposo", animacionReposo);
				
		//correr arriba
				Rectangle coordenadasCorrerArriba[]= {
						new Rectangle(14,487,66,53),
						new Rectangle(94,487,67,52),
						new Rectangle(173,486,68,53),
						new Rectangle(254,487,66,53),
						new Rectangle(334,487,67,52),
						new Rectangle(414,486,68,53),		
				};
				Animacion animacionCorrerArriba =new Animacion(0.05, coordenadasCorrerArriba);
				animaciones.put("correrArriba", animacionCorrerArriba);
				
		//correr abajo
				Rectangle coordenadasCorrerAbajo[]= {
						new Rectangle(491,407,67,58),
						new Rectangle(571,407,67,58),
						new Rectangle(651,406,68,58),
						new Rectangle(731,407,68,58),
						new Rectangle(811,407,67,58),
						new Rectangle(892,406,68,58),				
				};
				Animacion animacionCorrerAbajo =new Animacion(0.03, coordenadasCorrerAbajo);
				animaciones.put("correrAbajo", animacionCorrerAbajo);
				
		//ataque
				Rectangle coordenadasAtaque[]= {
						new Rectangle(8,323,70,55),
						new Rectangle(89,323,68,52),
						new Rectangle(164,337,68,53),
						new Rectangle(244,337,65,57),
						new Rectangle(324,337,66,57),
						new Rectangle(403,337,66,58),			
				};
			
				Animacion animacionAtaque =new Animacion(0.03, coordenadasAtaque);
				animaciones.put("ataque", animacionAtaque);
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
			setAnimacionActual("correrArriba");
		}else {
			 y+=1;
			 setAnimacionActual("correrAbajo");
		}	
		
		
	}
	
	public void verificarColisionJugador(Jugador jugador) {
		if (obtenerRectangulo().getBoundsInLocal().intersects(jugador.obtenerRectangulo().getBoundsInLocal()) ) {
			jugador.setVidas(jugador.getVidas()-3);
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
