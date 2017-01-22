import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {

	// QUESTIONS 1-7. COMMENT THIS LINE FOR GENERICS TESTING
	MyLinkedList chickens;

	// GENERICS TESTING. COMMENT THIS LINE FOR QUESTIONS 1-7
	//MyLinkedList<Chicken> chickens;

	@Before
	public void setUp() throws Exception{

        // QUESTIONS 1-7. COMMENT THIS LINE FOR GENERICS TESTING
        chickens = new MyLinkedList();

        // GENERICS TESTING. COMMENT THIS LINE FOR QUESTIONS 1-7
		//chickens = new MyLinkedList<>();

		chickens.add(new Chicken("Delilah", 10, "blue"));
		chickens.add(new Chicken("Georgy", 8, "green"));
		chickens.add(new Chicken("Lily", 4, "yellow"));
		chickens.add(new Chicken("Jimi", 13, "black"));

	}

	@Test
	public void testSize(){
		assertEquals(4,chickens.size());
	}

	@Test
	public void testGet(){

		assertEquals(new Chicken("Georgy",8,"green"),chickens.get(1));
		assertEquals(new Chicken("Lily",4,"yellow"),chickens.get(2));

	}

	@Test
	public void testRemove(){

		chickens.remove(1);
		chickens.remove(1);
		assertEquals(2,chickens.size());
		assertEquals(new Chicken("Jimi", 13, "black"),chickens.get(1));

	}

	@Test
	public void testAddIndex(){

		chickens.add(1,new Chicken("Jaquan", 10, "transparent"));
		chickens.add(1,new Chicken("Legos", 400, "rainbow"));
		assertEquals(6,chickens.size());
		assertEquals(new Chicken("Jaquan", 10, "transparent"),chickens.get(2));

	}

}
