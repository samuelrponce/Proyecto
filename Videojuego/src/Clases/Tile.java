package Clases;



import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Tile extends ObjetoJuego {
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	
	public Tile( int tipoTile, int velocidad, int x, int y, String nombreImagen, int ancho, int alto) {
		super(velocidad, x, y, nombreImagen);
		this.alto=alto;
		this.ancho=ancho;
		this.setTipoTile(tipoTile);
		
		switch(this.getTipoTile()) {
		case 1:
			this.xImagen=183;
			this.yImagen=0;
			
			break;
		case 2:
			this.xImagen=265;
			this.yImagen=0;
			
			break;
		case 3:
			this.xImagen=347;
			this.yImagen=0;
			
			break;
		case 4:
			this.xImagen=183;
			this.yImagen=83;
			
			break;
		case 5:
			this.xImagen=265;
			this.yImagen=83;
			
			break;
		case 6:
			this.xImagen=346;
			this.yImagen=83;
			
			break;
		case 7:
			this.xImagen=183;
			this.yImagen=163;
			
			break;
		case 8:
			this.xImagen=265;
			this.yImagen=163;
			
			break;
		case 9:
			this.xImagen=346;
			this.yImagen=163;
			
			break;
		case 10:
			this.xImagen=183;
			this.yImagen=244;
			
			break;
		case 11:
			this.xImagen=265;
			this.yImagen=244;
			
			break;
		case 12:
			this.xImagen=346;
			this.yImagen=244;
			
			break;
		case 13:
			this.xImagen=183;
			this.yImagen=324;
			
			break;
		case 14:
			this.xImagen=265;
			this.yImagen=324;
			
			break;
		case 15:
			this.xImagen=346;
			this.yImagen=324;
			
			break;
		case 16:
			this.xImagen=265;
			this.yImagen=406;
			
			break;
		case 17:
			this.xImagen=183;
			this.yImagen=406;
			
			break;
		case 18:
			this.xImagen=183;
			this.yImagen=569;
			
			break;
		case 19:
			this.xImagen=265;
			this.yImagen=569;
			
			break;
		case 20:
			this.xImagen=346;
			this.yImagen=569;
			
			break;
		case 21:
			this.xImagen=183;
			this.yImagen=489;
			
			break;
		case 22:
			this.xImagen=265;
			this.yImagen=489;
			
			break;
		case 23:
			this.xImagen=347;
			this.yImagen=489;
			
			break;
		case 24:
			this.xImagen=346;
			this.yImagen=406;
			
			break;
		case 25:
			this.xImagen=183;
			this.yImagen=651;
			
			break;
		case 26:
			this.xImagen=265;
			this.yImagen=651;
			
			break;
		case 27:
			this.xImagen=346;
			this.yImagen=651;
			
			break;
		case 28:
			this.xImagen=183;
			this.yImagen=732;
			
			break;
		case 29:
			this.xImagen=265;
			this.yImagen=732;
			
			break;
		case 30:
			this.xImagen=347;
			this.yImagen=732;
			
			break;
		case 31:
			this.xImagen=429;
			this.yImagen=0;
			
			break;
		case 32:
			this.xImagen=427;
			this.yImagen=83;
			
			break;
		case 33:
			this.xImagen=426;
			this.yImagen=163;
			
			break;
		case 34:
			this.xImagen=426;
			this.yImagen=244;
			
			break;
		case 35:
			this.xImagen=508;
			this.yImagen=244;
			
			break;
		case 36:
			this.xImagen=590;
			this.yImagen=244;
			
			break;
		case 37:
			this.xImagen=508;
			this.yImagen=163;
			
			break;
		case 38:
			this.xImagen=590;
			this.yImagen=163;
			
			break;
		case 39:
			this.xImagen=509;
			this.yImagen=83;
			
			break;
		case 40:
			this.xImagen=590;
			this.yImagen=83;
			
			break;
		case 41:
			this.xImagen=509;
			this.yImagen=0;
		
			break;
		case 42:
			this.xImagen=590;
			this.yImagen=0;
		
			break;
		case 43:
			this.xImagen=671;
			this.yImagen=0;
			
			break;
		case 44:
			this.xImagen=672;
			this.yImagen=83;
		
			break;
		case 45:
			this.xImagen=671;
			this.yImagen=163;
		
			break;
		case 46:
			this.xImagen=671;
			this.yImagen=244;
			
			break;
		case 47:
			this.xImagen=426;
			this.yImagen=324;
			
			break;
		case 48:
			this.xImagen=507;
			this.yImagen=324;
			
			break;
		case 49:
			this.xImagen=426;
			this.yImagen=406;
			
			break;
		case 50:
			this.xImagen=508;
			this.yImagen=406;
			
			break;
		case 51:
			this.xImagen=428;
			this.yImagen=489;
			
			break;
		case 52:
			this.xImagen=509;
			this.yImagen=489;
		
			break;
		case 53:
			this.xImagen=426;
			this.yImagen=569;
			
			break;
		case 54:
			this.xImagen=590;
			this.yImagen=569;
			
			break;
		case 55:
			this.xImagen=671;
			this.yImagen=569;
		
			break;
		case 56:
			this.xImagen=590;
			this.yImagen=489;
			
			break;
		case 57:
			this.xImagen=671;
			this.yImagen=489;
			
			break;
		case 58:
			this.xImagen=590;
			this.yImagen=406;
			
			break;
		case 59:
			this.xImagen=671;
			this.yImagen=406;
			
			break;
		case 60:
			this.xImagen=590;
			this.yImagen=324;
			
			break;
		case 61:
			this.xImagen=671;
			this.yImagen=324;
			
			break;
		case 62:
			this.xImagen=916;
			this.yImagen=569;
			
			break;
		case 63:
			this.xImagen=997;
			this.yImagen=569;
			
			break;
		case 64:
			this.xImagen=753;
			this.yImagen=651;
			
			break;
		case 65:
			this.xImagen=915;
			this.yImagen=651;
			
			break;
		case 66:
			this.xImagen=753;
			this.yImagen=732;
		
			break;
		case 67:
			this.xImagen=915;
			this.yImagen=732;
			
			break;
		case 68:
			this.xImagen=997;
			this.yImagen=489;
			
			break;
		case 69:
			this.xImagen=996;
			this.yImagen=406;
			
			break;
		case 70:
			this.xImagen=834;
			this.yImagen=569;
			
			break;
		case 71:
			this.xImagen=834;
			this.yImagen=489;
			
			break;
		case 72:
			this.xImagen=834;
			this.yImagen=406;
			
			break;
		case 73:
			this.xImagen=834;
			this.yImagen=324;
			
			break;
		case 74:
			this.xImagen=834;
			this.yImagen=244;
			
			break;
		case 75:
			this.xImagen=834;
			this.yImagen=163;
			
			break;
		case 76:
			this.xImagen=835;
			this.yImagen=83;
			
			break;
		case 77:
			this.xImagen=914;
			this.yImagen=244;
			
			break;
		case 78:
			this.xImagen=915;
			this.yImagen=324;
			
			
			break;
		case 79:
			this.xImagen=997;
			this.yImagen=163;
			
			break;
		case 80:
			this.xImagen=1079;
			this.yImagen=0;
			
			break;
		case 81:
			this.xImagen=1160;
			this.yImagen=0;
			
			break;
		case 82:
			this.xImagen=1241;
			this.yImagen=0;
			
			break;
		case 83:
			this.xImagen=1322;
			this.yImagen=0;
			
			break;
		case 84:
			this.xImagen=1322;
			this.yImagen=83;
			
			break;
		case 85:
			this.xImagen=1241;
			this.yImagen=83;
			
			break;
		case 86:
			this.xImagen=1160;
			this.yImagen=83;
			
			break;
		case 87:
			this.xImagen=1079;
			this.yImagen=83;
			
			break;
		case 88:
			this.xImagen=1322;
			this.yImagen=163;
			
			break;
		case 89:
			this.xImagen=1241;
			this.yImagen=324;
			
			break;
		case 90:
			this.xImagen=1159;
			this.yImagen=324;
			
			break;
		case 91:
			this.xImagen=1079;
			this.yImagen=324;
			
			break;
		case 92:
			this.xImagen=1079;
			this.yImagen=489;
			
			break;
		case 93:
			this.xImagen=1160;
			this.yImagen=489;
			
			break;
		case 94:
			this.xImagen=1241;
			this.yImagen=489;
			
			break;
		case 95:
			this.xImagen=1322;
			this.yImagen=489;
			
			break;
		case 96:
			this.xImagen=1322;
			this.yImagen=569;
			
			break;
		case 97:
			this.xImagen=1322;
			this.yImagen=651;
			
			break;
		case 98:
			this.xImagen=1241;
			this.yImagen=651;
			
			break;
		case 99:
			this.xImagen=1160;
			this.yImagen=651;
			
			break;
		case 100:
			this.xImagen=1079;
			this.yImagen=651;
			
			break;
		case 101:
			this.xImagen=1079;
			this.yImagen=732;
			
			break;
		case 102:
			this.xImagen=1160;
			this.yImagen=732;
			
			break;
		case 103:
			this.xImagen=1241;
			this.yImagen=732;
			
			break;
		case 104:
			this.xImagen=1322;
			this.yImagen=732;
			
			break;
		case 105:
			this.xImagen=426;
			this.yImagen=651;
			break;
		case 106:
			this.xImagen=508;
			this.yImagen=651;
			
			break;
		case 107:
			this.xImagen=590;
			this.yImagen=651;
			
			break;
		case 108:
			this.xImagen=671;
			this.yImagen=651;
			
			break;
		case 109:
			this.xImagen=672;
			this.yImagen=732;
			
			break;
		case 110:
			this.xImagen=590;
			this.yImagen=732;
			
			break;
		case 111:
			this.xImagen=509;
			this.yImagen=732;
			
			break;
		case 112:
			this.xImagen=428;
			this.yImagen=732;
			
			break;
		case 113:
			this.xImagen=0;
			this.yImagen=255;
			
			break;
		case 114:
			this.xImagen=997;
			this.yImagen=83;
			
			break;
		case 115:
			this.xImagen=996;
			this.yImagen=0;
		
			break;
		case 116:
			this.xImagen=79;
			this.yImagen=255;
			
			break;
		case 117:
			this.xImagen=0;
			this.yImagen=325;
			
			break;
		case 118:
			this.xImagen=79;
			this.yImagen=325;
			
			break;
		case 119:
			this.xImagen=0;
			this.yImagen=395;
			
			break;
		case 120:
			this.xImagen=79;
			this.yImagen=395;
			
			break;
		case 121:
			this.xImagen=0;
			this.yImagen=467;
			
			break;
		case 122:
			this.xImagen=79;
			this.yImagen=467;
			
			break;
		
		
		}
	}
	
	public Rectangle obtenerRectangulo() {
		if(getTipoTile()==21 || getTipoTile()==24||getTipoTile()==22||getTipoTile()==20||getTipoTile()==25||getTipoTile()==26||getTipoTile()==27||getTipoTile()==28
				||getTipoTile()==29||getTipoTile()==30||getTipoTile()==31||getTipoTile()==32||getTipoTile()==33||getTipoTile()==34||getTipoTile()==35||getTipoTile()==36
				||getTipoTile()==37||getTipoTile()==38||getTipoTile()==39||getTipoTile()==40||getTipoTile()==41||getTipoTile()==42||getTipoTile()==43
				||getTipoTile()==44||getTipoTile()==45||getTipoTile()==46||getTipoTile()==47||getTipoTile()==48||getTipoTile()==49||getTipoTile()==50
				||getTipoTile()==51||getTipoTile()==52||getTipoTile()==53||getTipoTile()==54||getTipoTile()==55||getTipoTile()==56||getTipoTile()==57
				||getTipoTile()==58||getTipoTile()==59||getTipoTile()==60||getTipoTile()==61||getTipoTile()==105||getTipoTile()==106||getTipoTile()==107
				||getTipoTile()==108||getTipoTile()==112||getTipoTile()==111||getTipoTile()==110||getTipoTile()==109||getTipoTile()==64||getTipoTile()==66
				||getTipoTile()==67||getTipoTile()==65||getTipoTile()==70||getTipoTile()==62||getTipoTile()==63||getTipoTile()==71||getTipoTile()==68
				||getTipoTile()==72||getTipoTile()==69||getTipoTile()==95||getTipoTile()==96||getTipoTile()==97||getTipoTile()==98||getTipoTile()==99
				||getTipoTile()==100||getTipoTile()==101||getTipoTile()==102||getTipoTile()==103||getTipoTile()==104
				||getTipoTile()==113||getTipoTile()==116||getTipoTile()==117||getTipoTile()==118||getTipoTile()==119||getTipoTile()==120||getTipoTile()==121
				||getTipoTile()==122) {
			return new Rectangle(this.x,this.y, 70, 70);
			}
	
		
		else {
			return new Rectangle(0, 0, 0, 0);
		}	
	}
	
	
	public int getTipoTile() {
		return tipoTile;
	}

	public void setTipoTile(int tipoTile) {
		this.tipoTile = tipoTile;
	}

	public void verificarColisionobstaculo(Jugador jugador) {
		if(this.obtenerRectangulo().intersects(jugador.obtenerRectangulo().getBoundsInLocal())&&(tipoTile==21||tipoTile==24||tipoTile==22||tipoTile==20
				||tipoTile==25||tipoTile==26||tipoTile==27||tipoTile==28||tipoTile==29||tipoTile==30
				||tipoTile==31||tipoTile==37||tipoTile==43||tipoTile==49||tipoTile==55||tipoTile==61
				||tipoTile==32||tipoTile==38||tipoTile==44||tipoTile==50||tipoTile==56||tipoTile==62
				||tipoTile==33||tipoTile==39||tipoTile==45||tipoTile==51||tipoTile==57||tipoTile==63
				||tipoTile==34||tipoTile==40||tipoTile==46||tipoTile==52||tipoTile==58||tipoTile==64
				||tipoTile==35||tipoTile==41||tipoTile==47||tipoTile==53||tipoTile==59||tipoTile==65
				||tipoTile==36||tipoTile==42||tipoTile==48||tipoTile==54||tipoTile==60||tipoTile==66
				||tipoTile==67||tipoTile==95||tipoTile==101||tipoTile==107||tipoTile==113||tipoTile==120
				||tipoTile==68||tipoTile==96||tipoTile==102||tipoTile==108||tipoTile==116||tipoTile==121
				||tipoTile==69||tipoTile==97||tipoTile==103||tipoTile==109||tipoTile==117||tipoTile==122
				||tipoTile==70||tipoTile==98||tipoTile==104||tipoTile==110||tipoTile==118||tipoTile==112
				||tipoTile==71||tipoTile==99||tipoTile==105||tipoTile==111||tipoTile==119||tipoTile==106
				||tipoTile==72||tipoTile==100)) {
			
				if(obtenerRectangulo().getBoundsInLocal().intersects(jugador.obtenerRectangulo().getBoundsInLocal())) {
					if (jugador.obtenerRectangulo().getX()>obtenerRectangulo().getX() && jugador.obtenerRectangulo().getY()>obtenerRectangulo().getY()) {
						jugador.setX((int)jugador.obtenerRectangulo().getX()+3);
						jugador.setY((int)jugador.obtenerRectangulo().getY()+12);
					}
					if (jugador.obtenerRectangulo().getX()>obtenerRectangulo().getX() && jugador.obtenerRectangulo().getY()<obtenerRectangulo().getY()) {
						jugador.setX((int)jugador.obtenerRectangulo().getX()+3);
						jugador.setY((int)jugador.obtenerRectangulo().getY());
					}
					if (jugador.obtenerRectangulo().getX()<obtenerRectangulo().getX() && jugador.obtenerRectangulo().getY()>obtenerRectangulo().getY()) {
						jugador.setX((int)jugador.obtenerRectangulo().getX()-3);
						jugador.setY((int)jugador.obtenerRectangulo().getY()+12);
					}
					if (jugador.obtenerRectangulo().getX()<obtenerRectangulo().getX() && jugador.obtenerRectangulo().getY()<obtenerRectangulo().getY()) {
						jugador.setX((int)jugador.obtenerRectangulo().getX()-3);
						jugador.setY((int)jugador.obtenerRectangulo().getY());
					}
					if (jugador.obtenerRectangulo().getX()>=obtenerRectangulo().getX()) {
						jugador.setX((int)jugador.obtenerRectangulo().getX()+3);
					}
					if (jugador.obtenerRectangulo().getX()<=obtenerRectangulo().getX()) {
						jugador.setX((int)jugador.obtenerRectangulo().getX()-3);
					}
					if (jugador.obtenerRectangulo().getY()>=obtenerRectangulo().getY()) {
						jugador.setY((int)jugador.obtenerRectangulo().getY()+12);
					}
					if (jugador.obtenerRectangulo().getY()<=obtenerRectangulo().getY()) {
						jugador.setY((int)jugador.obtenerRectangulo().getY());
					}
				}
			
			System.out.print("si");
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
		
		mover();
		
	}
	@Override
	public void mover() {

		
		if(Juego.arriba)
			y+=velocidad;
				
	}
	
	
	 
	
}
