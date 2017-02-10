import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.io.IOException;

public class WikiPhilosophyTest {

	@Test
	public void testMain() throws IOException {
		// Because this lab is more open-ended than others, we can't provide unit
		// tests.  Instead, we just check that you've modified WikiPhilosophy.java
		// so it doesn't throw an exception.
		assertThat(WikiPhilosophy.testConjecture("https://en.wikipedia.org/wiki/Philosophy", "https://en.wikipedia.org/wiki/Java_(programming_language)", 10), is(true));
		assertThat(WikiPhilosophy.testConjecture("https://en.wikipedia.org/wiki/Philosophy", "https://en.wikipedia.org/wiki/Java_(programming_language)", 7), is(false));
	}

}