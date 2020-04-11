package Clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Jugador extends ObjetoJuego{
	
	private int vidas;
	private Juego juego;
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
		Animacion animacionCorrer =new Animacion(0.05, coordenadasCorrer);
		animaciones.put("correr", animacionCorrer);
		
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
		Animacion animacionCorrerAbajo =new Animacion(0.05, coordenadasCorrerAbajo);
		animaciones.put("correrAbajo", animacionCorrerAbajo);
		
//ataque
		Rectangle coordenadasAtaque[]= {
				new Rectangle(11,326,68,55),
				new Rectangle(93,326,68,52),
				new Rectangle(169,326,68,53),
				new Rectangle(253,329,65,57),
				new Rectangle(332,328,66,57),
				new Rectangle(411,328,66,58),
				
		};
		Animacion animacionAtaque =new Animacion(0.05, coordenadasAtaque);
		animaciones.put("ataque", animacionAtaque);
		
//muerte
		Rectangle coordenadasMuerte[]= {
				new Rectangle(491,407,67,58),
				new Rectangle(571,407,67,58),
				new Rectangle(651,406,68,58),
				new Rectangle(731,407,68,58),
				new Rectangle(811,407,67,58),
				new Rectangle(892,406,68,58),
				
		};
		Animacion animacionMuerte =new Animacion(0.05, coordenadasMuerte);
		animaciones.put("auerte", animacionMuerte);
		
	}
	
	public void calcularFrame(double t) {
		Rectangle coordenadas=animaciones.get(animacionActual).calcularFrameActual(t);
		this.xImagen=(int)coordenadas.getX();
		this.yImagen=(int)coordenadas.getY();
		this.altoImagen=(int)coordenadas.getWidth();
		this.anchoImagen=(int)coordenadas.getHeight();

	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y-5, (direccion*anchoImagen)-5, altoImagen-5);
	}

	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen, yImagen, anchoImagen, altoImagen, x + (direccion==-1?anchoImagen:0), y, direccion*anchoImagen,anchoImagen);
		
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
			System.out.println("colision");
			item.setCapturado(true);
		}
	}
	

	
	}

