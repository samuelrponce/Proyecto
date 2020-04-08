package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

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
	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	public static HashMap<String, Image>imagenes;
	
	
	//private Tile tile;
	private ArrayList<Tile> tiles;
	
	private int tilemap[][]= {
			{1,2,3,2,2,2,2,2,2,3},
			{6,5,4,5,5,5,5,5,5,4},
			{7,8,9,11,5,5,5,5,5,4},
			{6,5,5,5,12,5,5,5,5,4},
			{6,5,5,5,5,13,5,5,5,4},
			{6,5,5,5,5,5,14,5,5,4},
			{6,5,5,5,5,5,5,15,17,4},
			{6,5,5,5,5,5,5,5,16,4},
			{7,8,8,8,8,8,8,8,8,9},
			};
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage ventana) throws Exception {
			InicializarComponentes();
			GestionEventos();
			ventana.setScene(escena);
			ventana.setTitle("Super juego ");
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
		fondo.mover();
	}
	
	public void InicializarComponentes() {
		imagenes = new HashMap<String, Image>();
		cargarImagenes();
		jugador = new Jugador(3,400,350,"jugador",0,"reposo");
		fondo = new Fondo(3,0,0,"back","back2");
		inicializarTiles();
		item = new Item(0,300,500,"coin",2);
		//tile = new Tile(0,0,0,"tilemap",512,832,96,96);
		root = new Group();
		escena = new Scene(root, 800, 700);
		lienzo = new Canvas(800,700);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
	}
	
	public void inicializarTiles() {
		tiles= new ArrayList<Tile>();
		for (int i=0; i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if(tilemap[i][j]!=0)
					this.tiles.add(new Tile(tilemap[i][j],0, j*80, i*80,"tilemap", 80, 80)); 
			}
		}
	}
	
	public void cargarImagenes() {
		imagenes.put("jugador1",new Image("jugador1.png"));
		imagenes.put("back",new Image("back.png"));
		imagenes.put("back2",new Image("back2.png"));
		imagenes.put("tilemap",new Image("tilemapx.png"));
		imagenes.put("jugador",new Image("jugador principal.png"));
		imagenes.put("coin",new Image("Silver_5.png"));
	}
	
	public void pintar () {	
		
		fondo.pintar(graficos);
		//tile.pintar(graficos);
		for(int i=0;i< tiles.size();i++)
			tiles.get(i).pintar(graficos);
		
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
					jugador.setDireccion(1);
					
					jugador.setAnimacionActual("correr");
				break;
				case "LEFT":
					izquierda=true;
					jugador.setDireccion(-1);
					
					jugador.setAnimacionActual("correr");
				break;
				case "UP":
					arriba=true;
					
					jugador.setAnimacionActual("correrArriba");
				break;
				case "DOWN":
					abajo=true;
					jugador.setAnimacionActual("correrAbajo");
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
				}
			}
		});
	}


}
