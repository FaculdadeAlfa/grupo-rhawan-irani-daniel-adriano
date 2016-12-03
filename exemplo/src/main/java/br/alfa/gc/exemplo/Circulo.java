package br.alfa.gc.exemplo;

public class Circulo {
	
	private double raio;
	
	private static final double PI = 3.14d;
	
	public Circulo(Double raio) {
		this.raio = raio;
	}
	
	public Double getArea() {
		return this.raio * this.raio * PI;
	}
	
	public Double getPerimetro() {
		return this.raio * 2 * PI;
	}

}
