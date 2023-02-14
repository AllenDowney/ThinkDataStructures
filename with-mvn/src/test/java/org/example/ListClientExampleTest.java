package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ListClientExampleTest {
    private  ListClientExample lce;
    @BeforeEach
    public void setUp() throws Exception {
        lce = new ListClientExample();
    }

    @Test
    public void testListClientExample() {
        List list = lce.getList();
        assertThat(list).isInstanceOf(ArrayList.class);
    }

}
