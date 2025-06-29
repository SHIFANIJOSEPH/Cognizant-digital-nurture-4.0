package com.junit;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class AAAPatternStringUtilsTest {
	
	    private String sample;

	    @Before
	    public void setUp() {
	        
	        sample = "hello world";
	        System.out.println("Setup: Created sample string");
	    }

	    @After
	    public void tearDown() {
	        
	        sample = null;
	        System.out.println("Teardown: Cleared sample string");
	    }

	    @Test
	    public void testToUpperCase() {
	        //Act
	        String result = sample.toUpperCase();

	        // Assert
	        assertEquals("HELLO WORLD", result);
	    }

	    @Test
	    public void testContains() {
	        // Act
	        boolean containsHello = sample.contains("hello");

	        // Assert
	        assertTrue(containsHello);
	    }

	    @Test
	    public void testLength() {
	        // Act
	        int length = sample.length();

	        // Assert
	        assertEquals(11, length);
	    }

}
