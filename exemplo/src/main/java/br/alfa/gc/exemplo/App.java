package br.alfa.gc.exemplo;

public class App {
	
	public static void main(String[] args) {
		Circulo circulo = new Circulo(3.0);
		System.out.println(String.format("�rea do C�rculo: %s", circulo.getArea()));
		System.out.println(String.format("Per�metro do C�rculo: %s", circulo.getPerimetro()));
	}

}
