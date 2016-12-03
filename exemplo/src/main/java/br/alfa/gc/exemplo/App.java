package br.alfa.gc.exemplo;

public class App {
	
	public static void main(String[] args) {
		Circulo circulo = new Circulo(3.0);
		System.out.println(String.format("Área do Círculo: %s", circulo.getArea()));
		System.out.println(String.format("Perímetro do Círculo: %s", circulo.getPerimetro()));
	}

}
