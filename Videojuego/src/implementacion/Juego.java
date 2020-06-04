package implementacion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import javax.swing.JOptionPane;

import Clases.Disparo;
import Clases.Enemigo1;
import Clases.Enemigo2;
import Clases.Enemigo3;
import Clases.Items;
import Clases.Jugador;
import Clases.Puntuaciones;
import Clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Juego extends Application {
	private GraphicsContext graficos;
	private Group root;
	private Scene escena;
	private Canvas lienzo;
	//private Fondo fondo;
	private Jugador jugador;
	private Disparo disparo;
	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	public static boolean space;
	public static int coordenadaX;
	public static int coordenadaY;
	private String nombre="";
	private Enemigo1 enemigo1;
	private Enemigo2 enemigo2;
	private Enemigo3 enemigo3;
	private ObservableList<Puntuaciones> puntuaciones;
	private ArrayList<Puntuaciones> lstPuntuaciones;
	private final String NOMBRE_ARCHIVO="puntos.data";
	public static HashMap<String, Image>imagenes;
	private ArrayList<Items> item;
	private int items[][]= {
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,1  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,3  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  },
			{0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,1  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,3  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{113,116,113,116,113,116,0  ,0  ,5  ,5  },
			{117,118,117,118,117,118,0  ,0  ,0  ,0  },
			{119,120,119,120,119,120,0  ,0  ,0  ,0  },
			{121,122,121,122,121,122,0  ,0  ,0  ,0  },
			{113,116,113,116,113,116,0  ,0  ,0  ,0  },
			{117,118,117,118,117,118,0  ,0  ,0  ,0  },
			{119,120,119,120,119,120,0  ,0  ,0  ,0  },
			{121,122,121,122,121,122,0  ,3  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,113,116},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,117,118},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,119,120},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,121,122},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,5  ,0  ,0  },
			{0  ,113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,117,118,0  ,0  ,0  ,0  ,0  ,3  ,0  },
			{0  ,119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  },
			{0  ,5  ,5  ,0  ,0  ,1  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,3  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,3  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,5  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,5  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,4  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,4  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,1  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,5  ,5  ,0  ,0  ,0  ,1  ,2  ,0  },//
			{0  ,0  ,5  ,5  ,0  ,0  ,0  ,1  ,2  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  },
			{0  ,0  ,3  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,113,116,113,116},
			{0  ,0  ,0  ,0  ,0  ,2  ,117,118,117,118},
			{0  ,0  ,0  ,0  ,0  ,0  ,119,120,119,120},
			{0  ,0  ,0  ,0  ,0  ,0  ,121,122,121,122},
			{0  ,0  ,113,116,113,116,113,116,113,116},
			{1  ,0  ,117,118,117,118,117,118,117,118},
			{0  ,0  ,119,120,119,120,119,120,119,120},
			{0  ,0  ,121,122,121,122,121,122,121,122},
			{0  ,0  ,0  ,0  ,5  ,5  ,5  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{1  ,1  ,1  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
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
			{1  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
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
	};
	
	private ArrayList<Tile> tiles;
	private int arboles[][]= {
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  },
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
			{113,116,113,116,113,116,0  ,0  ,0  ,0  },
			{117,118,117,118,117,118,0  ,0  ,0  ,0  },
			{119,120,119,120,119,120,0  ,0  ,0  ,0  },
			{121,122,121,122,121,122,0  ,0  ,0  ,0  },
			{113,116,113,116,113,116,0  ,0  ,0  ,0  },
			{117,118,117,118,117,118,0  ,0  ,0  ,0  },
			{119,120,119,120,119,120,0  ,0  ,0  ,0  },
			{121,122,121,122,121,122,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,113,116},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,3  ,117,118},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,119,120},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,121,122},
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,113,116,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,117,118,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,119,120,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,121,122,0  ,0  ,0  ,0  ,0  ,0  ,0  },
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
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
			{0  ,0  ,0  ,0  ,0  ,0  ,113,116,113,116},
			{0  ,0  ,0  ,0  ,0  ,0  ,117,118,117,118},
			{0  ,0  ,0  ,0  ,0  ,0  ,119,120,119,120},
			{0  ,0  ,0  ,0  ,0  ,0  ,121,122,121,122},
			{0  ,0  ,113,116,113,116,113,116,113,116},
			{0  ,0  ,117,118,117,118,117,118,117,118},
			{0  ,0  ,119,120,119,120,119,120,119,120},
			{0  ,0  ,121,122,121,122,121,122,121,122},
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
	};
	
	private int tilemap[][]= {
			{39 ,46 ,33 ,37 ,37 ,37 ,37 ,37 ,37 ,37 },
			{4  ,6  ,33 ,37 ,37 ,37 ,37 ,37 ,37 ,37 },//
			{4  ,6  ,34 ,35 ,35 ,35 ,35 ,35 ,35 ,35 },
			{4  ,6  ,24 ,1  ,2  ,2  ,2  ,2  ,3  ,24 },//
			{4  ,6  ,24 ,4  ,5  ,8  ,8  ,5  ,6  ,24 },
			{4  ,5  ,2  ,5  ,6  ,60 ,60 ,4  ,6  ,24 },
			{7  ,8  ,8  ,5  ,6  ,62 ,62 ,4  ,6  ,24 },//
			{21 ,21 ,21 ,4  ,6  ,62 ,62 ,4  ,6  ,24 },//
			{18 ,18 ,18 ,4  ,6  ,62 ,62 ,4  ,6  ,24 },
			{18 ,18 ,18 ,4  ,6  ,62 ,62 ,4  ,6  ,24 },
			{18 ,18 ,18 ,4  ,6  ,62 ,62 ,4  ,6  ,24 },
			{18 ,18 ,18 ,4  ,5  ,2  ,2  ,5  ,6  ,24 },
			{18 ,18 ,18 ,7  ,8  ,8  ,8  ,5  ,6  ,24 },
			{105,106,106,106,106,106,107,4  ,6  ,24 },
			{108,19 ,17 ,19 ,17 ,19 ,108,4  ,6  ,24 },
			{112,111,111,111,111,111,110,4  ,6  ,24 },
			{60 ,1  ,2  ,2  ,2  ,2  ,2  ,5  ,6  ,24 },//
			{62 ,4  ,5  ,8  ,8  ,8  ,8  ,8  ,9  ,24 },
			{62 ,4  ,6  ,21 ,21 ,21 ,21 ,21 ,21 ,21 },
			{62 ,4  ,6  ,60 ,60 ,60 ,60 ,60 ,60 ,60 },//
			{62 ,4  ,6  ,62 ,62 ,62 ,62 ,62 ,62 ,62 },
			{62 ,4  ,6  ,62 ,62 ,62 ,62 ,62 ,62 ,62 },
			{24 ,4  ,5  ,2  ,2  ,2  ,2  ,2  ,2  ,3  },//
			{24 ,7  ,8  ,8  ,8  ,8  ,8  ,8  ,5  ,6  },
			{18 ,18 ,18 ,18 ,18 ,18 ,21 ,21 ,4  ,6  },//
			{18 ,18 ,18 ,18 ,18 ,18 ,21 ,21 ,4  ,6  },
			{18 ,18 ,18 ,18 ,18 ,18 ,21 ,21 ,4  ,6  },
			{18 ,18 ,18 ,18 ,18 ,18 ,1  ,2  ,5  ,6  },
			{18 ,18 ,18 ,18 ,18 ,18 ,4  ,5  ,8  ,9  },
			{18 ,18 ,18 ,18 ,18 ,18 ,4  ,6  ,60 ,60 },
			{18 ,18 ,18 ,18 ,18 ,18 ,4  ,6  ,62 ,62 },
			{18 ,18 ,18 ,18 ,18 ,18 ,4  ,6  ,62 ,62 },//
			{60 ,60 ,60 ,1  ,2  ,2  ,5  ,6  ,62 ,62 },
			{62 ,62 ,62 ,4  ,5  ,8  ,8  ,9  ,18 ,18 },
			{62 ,62 ,62 ,4  ,6  ,24 ,24 ,24 ,18 ,18 },
			{62 ,62 ,62 ,4  ,6  ,24 ,24 ,24 ,18 ,18 },
			{62 ,62 ,62 ,4  ,6  ,24 ,24 ,24 ,18 ,18 },
			{62 ,62 ,62 ,4  ,5  ,2  ,2  ,2  ,2  ,3  },//
			{62 ,18 ,18 ,7  ,8  ,8  ,8  ,8  ,5  ,6  },
			{62 ,18 ,18 ,17 ,20 ,20 ,20 ,20 ,4  ,6  },//
			{62 ,18 ,18 ,17 ,20 ,20 ,20 ,20 ,4  ,6  },
			{62 ,18 ,18 ,17 ,20 ,20 ,20 ,20 ,4  ,6  },
			{62 ,1  ,2  ,2  ,2  ,2  ,2  ,2  ,5  ,6  },
			{62 ,4  ,5  ,8  ,8  ,5  ,5  ,8  ,8  ,9  },//
			{62 ,4  ,6  ,60 ,60 ,115,115,60 ,60 ,60 },//
			{62 ,4  ,6  ,62 ,62 ,115,115,62 ,62 ,62 },
			{62 ,4  ,5  ,2  ,2  ,5  ,5  ,2  ,3  ,62 },
			{62 ,7  ,8  ,8  ,8  ,8  ,8  ,5  ,6  ,62 },//
			{62 ,60 ,60 ,60 ,60 ,60 ,60 ,4  ,6  ,62 },
			{62 ,62 ,62 ,62 ,62 ,62 ,62 ,4  ,6  ,62 },
			{62 ,62 ,62 ,20 ,1  ,2  ,2  ,5  ,5  ,3  },//
			{62 ,62 ,62 ,20 ,4  ,5  ,8  ,8  ,8  ,9  },
			{65 ,65 ,65 ,20 ,4  ,6  ,20 ,20 ,20 ,20 },
			{65 ,11 ,65 ,20 ,4  ,6  ,20 ,17 ,19 ,17 },
			{65 ,4  ,12 ,12 ,5  ,6  ,20 ,17 ,19 ,17 },
			{65 ,16 ,60 ,20 ,4  ,6  ,20 ,17 ,19 ,17 },
			{65 ,60 ,62 ,20 ,4  ,6  ,20 ,20 ,20 ,20 },
			{65 ,62 ,62 ,20 ,4  ,5  ,2  ,2  ,3  ,20 },//
			{65 ,62 ,62 ,20 ,7  ,8  ,8  ,5  ,6  ,20 },
			{62 ,62 ,62 ,57 ,57 ,57 ,57 ,4  ,6  ,20 },
			{62 ,62 ,75 ,75 ,115,115,115,5  ,6  ,20 },
			{62 ,62 ,75 ,75 ,115,115,115,5  ,6  ,20 },
			{62 ,62 ,115,115,72 ,72 ,72 ,4  ,6  ,20 },//
			{62 ,62 ,115,115,62 ,62 ,62 ,4  ,6  ,20 },
			{62 ,62 ,115,115,62 ,62 ,62 ,4  ,6  ,20 },
			{62 ,62 ,75 ,75 ,114,114,114,5  ,6  ,20 },
			{62 ,62 ,75 ,75 ,114,114,114,5  ,6  ,20 },
			{62 ,62 ,72 ,72 ,72 ,72 ,72 ,4  ,6  ,20 },
			{62 ,62 ,62 ,62 ,62 ,62 ,62 ,4  ,6  ,20 },
			{65 ,1  ,2  ,2  ,2  ,2  ,2  ,5  ,6  ,20 },
			{63 ,4  ,5  ,8  ,8  ,8  ,8  ,8  ,9  ,20 },//
			{62 ,4  ,6  ,24 ,24 ,24 ,24 ,24 ,24 ,20 },//
			{65 ,4  ,6  ,24 ,24 ,24 ,24 ,24 ,24 ,20 },
			{62 ,4  ,5  ,2  ,2  ,3  ,20 ,24 ,24 ,20 },
			{65 ,7  ,8  ,8  ,5  ,6  ,20 ,24 ,24 ,20 },
			{65 ,60 ,60 ,60 ,4  ,6  ,18 ,18 ,18 ,18 },
			{65 ,62 ,62 ,65 ,4  ,6  ,18 ,18 ,18 ,18 },
			{1  ,2  ,2  ,2  ,5  ,6  ,18 ,18 ,18 ,18 },
			{4  ,5  ,8  ,8  ,8  ,9  ,18 ,18 ,18 ,18 },
			{4  ,6  ,18 ,18 ,18 ,18 ,18 ,18 ,18 ,18 },
			{4  ,6  ,18 ,18 ,18 ,18 ,18 ,18 ,18 ,18 },
			{4  ,6  ,18 ,18 ,18 ,18 ,18 ,18 ,18 ,18 },
			{4  ,6  ,18 ,18 ,18 ,18 ,18 ,18 ,18 ,18 },
			{5  ,5  ,5  ,5  ,5  ,5  ,5  ,5  ,5  ,5  },
			{5  ,5  ,5  ,5  ,5  ,5  ,5  ,20 ,17 ,5  },
			{8  ,8  ,8  ,8  ,8  ,8  ,8  ,8  ,8  ,8  },
			{55 ,55 ,55 ,55 ,56 ,115,58 ,59 ,115,115},//
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
			{65 ,63 ,62 ,62 ,62 ,73 ,62 ,64 ,62 ,64 },
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
		
		if(jugador.getVidas()<=0) {
			guardar();
			
			System.exit(0);
		}
			
		jugador.calcularFrame(t);
		
		jugador.mover();
		
		enemigo1.calcularFrame(t);
		enemigo1.mover();
		enemigo1.verificarColisionJugador(jugador);
		
		enemigo2.calcularFrame(t);
		enemigo2.mover();
		enemigo2.verificarColisionJugador(jugador);
		
		enemigo3.calcularFrame(t);
		enemigo3.mover();
		enemigo3.verificarColisionJugador(jugador);
		
		disparo.verificarColision(enemigo1, enemigo2, enemigo3, jugador);
	
		disparo.mover();
		
		for(int i=0;i<tiles.size();i++)
			tiles.get(i).verificarColisionobstaculo(jugador);
		
		for(int i=0;i<item.size();i++)
			item.get(i).verificarColisionesItem(jugador);
		
		
		
		 coordenadaX=jugador.getX();
		 coordenadaY=jugador.getY();
		 
		 
	}
	
	public String stringPuntos() {
		String a="";
			for(int i=0;i<puntuaciones.size();i++)
				a+=puntuaciones.get(i)+"\n";
			System.out.println(a);
			return a;
		
		
	}

	public void InicializarComponentes() {
		puntuaciones=FXCollections.observableArrayList();
		imagenes = new HashMap<String, Image>();
		cargarImagenes();
		jugador = new Jugador(2,385,346,"jugador",1,"reposo",0);
		enemigo1=new Enemigo1(1,1, 456, -800,"enemigo1", "reposo", 6);
		enemigo2=new Enemigo2(1,1, 870, -900,"enemigo2", "reposo", 3);
		enemigo3=new Enemigo3(1,1, 100, -100,"enemigo3", "reposo", 1);
		disparo= new Disparo(6,50,50,"disparo",800000,0);
		//fondo = new Fondo(3,0,0,"back","back2");
		inicializarTiles();	
		inicializarItems();
		TextInputDialog tid = new TextInputDialog();
		tid.setHeaderText(null);
		tid.setTitle("Insertar");
		tid.setContentText("Introducir Nombre:");
		Optional<String> texto = tid.showAndWait();
		this.nombre=texto.get();
		
		try {
			ObjectInputStream flujoEntrada=new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO));
			while(true) {
				puntuaciones.add((Puntuaciones)flujoEntrada.readObject());
			}
		} catch (EOFException e) {
			System.out.println("fin de archivo");
			
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//item = new Item(0,400,500,"coin",2);
		//tile = new Tile(0,0,0,"tilemap",512,832,96,96);
		root = new Group();
		escena = new Scene(root, 770, 693);
		lienzo = new Canvas(770,693);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
	
	
	}
	
	public void guardar(){
		
		Puntuaciones puntuacion=new Puntuaciones(nombre,jugador.getPuntuacion());
		puntuaciones.add(puntuacion);
		guardarEnArchivo();
		JOptionPane.showMessageDialog(null, stringPuntos());
	}
	
	public void inicializarItems() {
		item= new ArrayList<Items>();
		for (int i=0; i<items.length;i++) {
			for(int j=0;j<items[i].length;j++) {
				if(items[i][j]!=0)
					this.item.add(new Items(items[i][j],3, j*77, i*77-7777,"objetos", 30, 30)); 
			}
		}
	}
	
	public void guardarEnArchivo() {
		try {
			ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO));
			for(int i=0;i<puntuaciones.size();i++) 
				flujoSalida.writeObject(puntuaciones.get(i));
			
			flujoSalida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void inicializarTiles() {
		tiles= new ArrayList<Tile>();
		for (int i=0; i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if(tilemap[i][j]!=0) 
					this.tiles.add(new Tile(tilemap[i][j],3, j*77, i*77-7777,"tilemap", 77, 77));
			        this.tiles.add(new Tile(arboles[i][j],3, j*77, i*77-7777,"tilemap", 77, 77));
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
		imagenes.put("objetos",new Image("items.png"));
		imagenes.put("enemigo1",new Image("sprite enemigo.png"));
		imagenes.put("enemigo2",new Image("sprite enemigo2.png"));
		imagenes.put("enemigo3",new Image("sprite enemigo5.png"));
		
	}
	
	public void pintar () {	
		//fondo.pintar(graficos);
		//tile.pintar(graficos);
		for(int i=0;i< tiles.size();i++)
			tiles.get(i).pintar(graficos);
		
		if(Juego.space==true||disparo.limiteDisparo()==true||disparo.isColision()==false)
			disparo.pintar(graficos);
		
		for(int i=0;i< item.size();i++)
			item.get(i).pintar(graficos);
		
		
		enemigo1.pintar(graficos);
		enemigo2.pintar(graficos);
		enemigo3.pintar(graficos);
		jugador.pintar(graficos);
		graficos.fillText("Vidas:" + jugador.getVidas(), 20, 20);
		graficos.fillText("Score:" + jugador.getPuntuacion(), 20, 40);
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
						space=false;
							disparo.setX(jugador.obtenerxImagen());
							disparo.setY(jugador.obteneryImagen());
						jugador.setAnimacionActual("reposo");
					break;
				}
			}
		});
	}


}
