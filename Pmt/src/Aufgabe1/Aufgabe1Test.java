package Aufgabe1;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class Aufgabe1Test {

	@Test
	public void testFoobar() {
		assertEquals("Rückgabe nicht erfolgreich", Optional.ofNullable(null), Aufgabe1.foobar(null));
	}

}
