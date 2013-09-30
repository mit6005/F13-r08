package lists;


import static org.junit.Assert.*;

import org.junit.Test;

public class SListTest {

	@Test
	public void test() {
		// nil := empty()
		ImList<Integer> nil = new SList();
		
		// x := cons(0, cons(1, nil))
		ImList<Integer> x = nil.cons(1).cons(0);
		
		// y := cons(4, rest(x))
		ImList<Integer> y = x.rest().cons(4);
		
		assertEquals((int)x.first(), 0);
		assertEquals((int)x.rest().first(), 1);
		assertEquals((int)y.first(), 4);
		assertEquals((int)y.rest().first(), 1);
	}

}
