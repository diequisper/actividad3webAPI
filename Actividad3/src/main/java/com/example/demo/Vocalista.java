package com.example.demo;

public class Vocalista {
	
	private long id;
	private String nickname;
	private int edad;
	private String nacionalidad;
	private String generoMusical;
	
	public Vocalista(long id, String nickname, int edad, String nacionalidad, String generoMusical) {
		this.id = id;
		this.nickname = nickname;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.generoMusical = generoMusical;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}
	
}
