package br.alfa.gc.exemplo;

import org.junit.Test;
import static org.junit.Assert.*;

public class CirculoTest {
	
	@Test
	public void testGetPerimetro() {
		Circulo circulo = new Circulo(3.0);
		assertEquals(Double.valueOf(18.84), circulo.getPerimetro());
	}
	
	@Test
	public void testGetArea() {
		Circulo circulo = new Circulo(3.0);
		assertEquals(Double.valueOf(28.26), circulo.getArea());
	}

}