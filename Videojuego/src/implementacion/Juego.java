package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import Clases.Disparo;
import Clases.Fondo;
import Clases.Item;
import Clases.Jugador;
import Clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Juego extends Application {
	private GraphicsContext graficos;
	private Group root;
	private Scene escena;
	private Canvas lienzo;
	private Fondo fondo;
	private Jugador jugador;
	private Item item;
	private Disparo disparo;
	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	public static boolean space;
	public static HashMap<String, Image>imagenes;
	//private static ArrayList<Item> item;
	
	//private int items[][]= {
			//{4  ,6  ,62 ,4  ,21 ,5  ,20 ,6  ,37 ,37 },
	//};
	
	private int pasoLibre[][]= {
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,113,116},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,117,118},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,119,120},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,121,122},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
	};
	
	private ArrayList<Tile> tiles;
	
	private int arboles[][]= {
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,113,116},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,117,118},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,119,120},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,121,122},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
	};
	
	private int tilemap[][]= {
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,6  ,37 ,37 },
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,6  ,37 ,37 },
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,6  ,37 ,37 },
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,6  ,37 ,37 },
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,6  ,37 ,37 },
			{4  ,6  ,115,4  ,5  ,5  ,8  ,9  ,46 ,37 },
			{7  ,9  ,69 ,7  ,91 ,81 ,36 ,36 ,24 ,18 },
			{34 ,37 ,47 ,36 ,91 ,90 ,19 ,6  ,18 ,18 },
			{19 ,35 ,51 ,18 ,87 ,86 ,8  ,9  ,18 ,18 },
			{100,19 ,62 ,36 ,92 ,93 ,36 ,36 ,21 ,23 },
			{103,20 ,62 ,4  ,5  ,5  ,5  ,20 ,17 ,5  },
			{19 ,19 ,62 ,7  ,8  ,8  ,8  ,8  ,8  ,8  },
			{60 ,61 ,62 ,55 ,56 ,115,58 ,59 ,60 ,61 },
			{65 ,64 ,62 ,63 ,62 ,115,62 ,63 ,62 ,63 },
			{63 ,62 ,74 ,114,114,75 ,114,114,77 ,62 },
			{62 ,63 ,70 ,72 ,72 ,115,72 ,72 ,71 ,62 },
			{65 ,63 ,62 ,62 ,62 ,73 ,62 ,64 ,62 ,64 },
			{62 ,63 ,62 ,63 ,62 ,80 ,83 ,81 ,62 ,63 },
			{4  ,6  ,62 ,4  ,21 ,87 ,84 ,86 ,37 ,37 },
			{4  ,6  ,62 ,4  ,21 ,87 ,84 ,86 ,37 ,37 },
			{4  ,6  ,62 ,4  ,21 ,87 ,84 ,86 ,37 ,37 },
			{4  ,6  ,62 ,10 ,21 ,87 ,84 ,86 ,8  ,9  },
			{4  ,6  ,62 ,10 ,38 ,84 ,84 ,84 ,37 ,37 },
			{62 ,62 ,62 ,10 ,38 ,84 ,84 ,84 ,37 ,37 },
			{62 ,62 ,62 ,16 ,38 ,84 ,84 ,84 ,37 ,37 },
			{47 ,47 ,48 ,38 ,38 ,84 ,84 ,84 ,37 ,37 },
			{53 ,53 ,53 ,38 ,38 ,88 ,88 ,88 ,25 ,26 },
			{53 ,53 ,53 ,38 ,5  ,93 ,36 ,36 ,5  ,5  },
			{53 ,53 ,53 ,38 ,5  ,5  ,5  ,20 ,17 ,5  },
			{51 ,51 ,51 ,38 ,8  ,8  ,8  ,8  ,8  ,8  },
			{63 ,62 ,62 ,55 ,56 ,115,58 ,59 ,115,115},
			{65 ,64 ,62 ,63 ,62 ,115,62 ,63 ,115,115},
			{63 ,62 ,62 ,62 ,62 ,62 ,62 ,62 ,115,115},
			{114,114,114,77 ,62 ,62 ,62 ,62 ,115,115},
			{72 ,72 ,72 ,71 ,62 ,62 ,62 ,64 ,4  ,6  },
			{62 ,63 ,62 ,63 ,62 ,62 ,62 ,63 ,4  ,6  },
			{1  ,3  ,62 ,1  ,2  ,2  ,2  ,2  ,5  ,6  },
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,5  ,5  ,6  },
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,5  ,8  ,8  },
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,6  ,37 ,37 },
			{4  ,6  ,62 ,4  ,21 ,5  ,20 ,6  ,37 ,37 },
			{4  ,6  ,115,4  ,5  ,5  ,8  ,9  ,46 ,37 },
			{7  ,9  ,69 ,7  ,80 ,81 ,36 ,36 ,24 ,18 },
			{34 ,37 ,47 ,36 ,91 ,90 ,19 ,6  ,18 ,18 },
			{19 ,35 ,51 ,18 ,87 ,86 ,8  ,9  ,18 ,18 },
			{100,19 ,62 ,36 ,92 ,93 ,36 ,36 ,21 ,23 },
			{103,20 ,62 ,4  ,5  ,5  ,5  ,20 ,17 ,5  },
			{19 ,19 ,62 ,7  ,8  ,8  ,8  ,8  ,8  ,8  },
			{60 ,61 ,62 ,55 ,56 ,115,58 ,59 ,60 ,61 },
			{65 ,64 ,62 ,63 ,62 ,115,62 ,63 ,62 ,63 },
			{63 ,62 ,74 ,114,114,75 ,114,114,77 ,62 },
			{62 ,63 ,70 ,72 ,72 ,115,72 ,72 ,71 ,62 },
			{65 ,63 ,62 ,21 ,24 ,73 ,62 ,64 ,62 ,64 },
			{62 ,63 ,62 ,63 ,62 ,62 ,62 ,63 ,62 ,63 },
			};
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage ventana) throws Exception {
			InicializarComponentes();
			GestionEventos();
			ventana.setScene(escena);
			ventana.setTitle("Sobreviviente");
			ventana.show();
			cicloJuego();
		
	}
	
	public void cicloJuego() {
		long tiempoInicial=System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {

			@Override
			public void handle(long tiempoActual) {
				double t = (tiempoActual-tiempoInicial)/1000000000.0;
				ActualizarEstado(t);
				pintar();
			}
			
		};
		
		animationTimer.start();
	}
	
	public void ActualizarEstado(double t){
		jugador.verificarColisionesItem(item);
		jugador.calcularFrame(t);
		jugador.mover();
		disparo.mover();
		
		for(int i=0;i<tiles.size();i++)
			tiles.get(i).verificarColisionobstaculo(jugador);
		
	}
	
	public void InicializarComponentes() {
		imagenes = new HashMap<String, Image>();
		cargarImagenes();
		jugador = new Jugador(1,385,346,"jugador",0,"reposo");
		disparo= new Disparo(3,50,50,"disparo",0,0);
		fondo = new Fondo(3,0,0,"back","back2");
		inicializarTiles();	
		item = new Item(0,400,500,"coin",2);
		//tile = new Tile(0,0,0,"tilemap",512,832,96,96);
		root = new Group();
		escena = new Scene(root, 770, 693);
		lienzo = new Canvas(770,693);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
	}
	
	//public void inicializarItems() {
		//item= new ArrayList<Item>();
		
		//for (int i=0; i<items.length;i++) {
			//for(int j=0;j<items[i].length;j++) {
			//	if(items[i][j]!=0)
			//		this.item.add(new Item(items[i][j],2, j*77, i*77-693,"ff", 77, 77,3)); 
			//}
		//}
//	}
	
	public void inicializarTiles() {
		tiles= new ArrayList<Tile>();
		for (int i=0; i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if(tilemap[i][j]!=0) 
					this.tiles.add(new Tile(tilemap[i][j],3, j*77, i*77-3465,"tilemap", 77, 77));
			        this.tiles.add(new Tile(arboles[i][j],3, j*77, (i*77)-3465,"tilemap", 77, 77));
			       
			        
			        
			}
		}
		
	}
	
	
	

	
	public void cargarImagenes() {
		imagenes.put("jugador1",new Image("jugador1.png"));
		imagenes.put("paso",new Image("paso libre.png"));
		imagenes.put("back",new Image("back.png"));
		imagenes.put("back2",new Image("back2.png"));
		imagenes.put("tilemap",new Image("tilemapx1.png"));
		imagenes.put("jugador",new Image("sprite3.png"));
		imagenes.put("coin",new Image("Silver_5.png"));
		imagenes.put("disparo",new Image("rasengan.png"));
	}
	
	public void pintar () {	
		
		//fondo.pintar(graficos);
		//tile.pintar(graficos);
		for(int i=0;i< tiles.size();i++)
			tiles.get(i).pintar(graficos);
		
		if(Juego.space==true)
			disparo.pintar(graficos);
		
		jugador.pintar(graficos);
		item.pintar(graficos);
		graficos.fillText("Vidas:" + jugador.getVidas(), 20, 20);
	}
	
	public void GestionEventos(){
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				switch(evento.getCode().toString()) {
			
				case "RIGHT":
						derecha=true;
						jugador.setAnimacionActual("correrDerecha");
					break;
				case "LEFT":
						izquierda=true;
						jugador.setAnimacionActual("correrIzquierda");
					break;
				case "UP":
						arriba=true;
						jugador.setAnimacionActual("correrArriba");
					break;
				case "DOWN":
						abajo=true;
						jugador.setAnimacionActual("correrAbajo");
					break;
				case "SPACE":
						space=true;
						jugador.setAnimacionActual("ataque");
					break;
				}
			}		
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent evento){
				switch(evento.getCode().toString()){
					case "RIGHT":
							derecha=false;
						
							jugador.setAnimacionActual("reposo");
						break;
					case "LEFT":
							izquierda=false;
							jugador.setAnimacionActual("reposo");
						break;
					case "UP":
							arriba=false;
							jugador.setAnimacionActual("reposo");
						break;
					case "DOWN":
							abajo=false;
							jugador.setAnimacionActual("reposo");
						break;
					case "SPACE":
						
							disparo.setX(jugador.obtenerxImagen());
							disparo.setY(jugador.obteneryImagen());
						
						jugador.setAnimacionActual("reposo");
					break;
					
				}
			}
		});
	}


}
