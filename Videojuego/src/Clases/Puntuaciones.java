package Clases;

import java.io.Serializable;

public class Puntuaciones implements Serializable{
	private String nombre;
	private int puntos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", puntos=" + puntos ;
	}
	public Puntuaciones(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
	}

}
