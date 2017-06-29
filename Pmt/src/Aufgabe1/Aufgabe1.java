package Aufgabe1;

import java.util.*;
import turban.utils.*;
public class Aufgabe1 {

	
	
	public static Optional <Object> foobar(@Nullable Object obj) {
		Optional<Object> objct = Optional.ofNullable(obj);
		return Optional.ofNullable(obj);
		
		
		// if obj == null; return Optional.empty();
		// else return Optional.of(obj);
		
		/*
		 * assertEquals("Rückgabe nicht erfolgreich", Optional.OfNullable(null), First.footbar(null));
		 * assertTrue("rückgabefehler", First.footbar(3).isPresent());
		 * assertEquals("rückgabefehler", First.footbar(3).get());
		 * */
		
		
	}
}
