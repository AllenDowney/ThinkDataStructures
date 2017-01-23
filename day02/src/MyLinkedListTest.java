import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
	private static final Chicken DELILAH = new Chicken("Delilah", 10, "blue");
	private static final Chicken GEORGY = new Chicken("Georgy", 8, "green");
    private static final Chicken LILY = new Chicken("Lily", 4, "yellow");
    private static final Chicken JIMI = new Chicken("Jimi", 13, "black");
    private static final Chicken JAQUAN = new Chicken("Jaquan", 10, "transparent");
	private static final Chicken LEGOS = new Chicken("Legos", 400, "rainbow");

	// QUESTIONS 1-7. COMMENT THIS LINE FOR GENERICS TESTING
	MyLinkedList chickens;

	// GENERICS TESTING. COMMENT THIS LINE FOR QUESTIONS 1-7
	//MyLinkedList<Chicken> chickens;

	@Before
	public void setUp() throws Exception {
        // QUESTIONS 1-7. COMMENT THIS LINE FOR GENERICS TESTING
        // chickens = new MyLinkedList();

        // GENERICS TESTING. COMMENT THIS LINE FOR QUESTIONS 1-7
		chickens = new MyLinkedList<>();

		chickens.addLast(DELILAH);
		chickens.addLast(GEORGY);
		chickens.addLast(LILY);
		chickens.addLast(JIMI);
	}

	@Test
	public void testSize(){
		assertEquals(4, chickens.size());
	}

	@Test
	public void testGet() {
		assertEquals(GEORGY, chickens.get(1));
		assertEquals(LILY, chickens.get(2));
	}

	@Test
	public void testRemoveFirst() {
		chickens.removeFirst();
		assertEquals(3, chickens.size());
		assertEquals(GEORGY, chickens.get(0));
	}

	@Test
	public void testRemoveLast() {
		chickens.removeLast();
		assertEquals(3, chickens.size());
		assertEquals(LILY, chickens.get(2));
	}

	@Test
	public void testAddFirst() {
		chickens.addFirst(JAQUAN);
		assertEquals(5, chickens.size());

		chickens.addFirst(LEGOS);
		assertEquals(6, chickens.size());

		assertEquals(LEGOS, chickens.get(0));
		assertEquals(JAQUAN, chickens.get(1));
	}
}
