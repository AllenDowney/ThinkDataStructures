import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BoomerangTest {

    protected Map<String, Integer> map;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        map = new MyHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put(null, 0);
    }

    /**
     * Test method for {@link MyLinearMap#clear()}.
     */
    @Test
    public void testNumberOfBoomerangs() {
        map.clear();
        assertThat(map.size(), is(0));
    }
}