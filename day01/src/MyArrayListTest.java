import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {

	// QUESTIONS 1-7. COMMENT THIS LINE FOR QUESTION 8
	MyArrayList cows;

	// QUESTION 8. COMMENT THIS LINE FOR QUESTIONS 1-7
	//MyArrayList<Cow> cows;

	@Before
	public void setUp() throws Exception{

		// QUESTIONS 1-7. COMMENT THIS LINE FOR QUESTION 8
		cows = new MyArrayList();

		// QUESTION 8. COMMENT THIS LINE FOR QUESTIONS 1-7
		// cows = new MyArrayList<Cow>();

		cows.add(new Cow("Delilah", 10, "blue"));
		cows.add(new Cow("Georgy", 8, "green"));
		cows.add(new Cow("Lily", 4, "yellow"));
		cows.add(new Cow("Jimi", 13, "black"));

	}

	@Test
	public void testSize(){

		assertEquals(4,cows.size());

	}

	@Test
	public void testGet(){

		assertEquals(new Cow("Georgy",8,"green"),cows.get(1));
		assertEquals(new Cow("Lily",4,"yellow"),cows.get(2));

	}

	@Test
	public void testRemove(){

		cows.remove(1);
		cows.remove(1);
		assertEquals(2,cows.size());
		assertEquals(new Cow("Jimi", 13, "black"),cows.get(1));

	}

	@Test
	public void testAddIndex(){

		cows.add(1,new Cow("Jaquan", 10, "transparent"));
		cows.add(1,new Cow("Legos", 400, "rainbow"));
		assertEquals(6,cows.size());
		assertEquals(new Cow("Jaquan", 10, "transparent"),cows.get(2));

	}

	@Test
	public void testResize(){

		for(int i = 0; i < 1000; i++){
			String name = "Cow" + i;
			int age = i;
			String color = "Color" + i;
			cows.add(new Cow(name,age,color));
		}

		assertEquals(1004,cows.size());
		assertEquals(new Cow("Cow996", 996, "Color996"),cows.get(1000));

	}

}
