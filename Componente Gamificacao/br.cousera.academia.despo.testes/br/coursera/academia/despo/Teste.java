package br.coursera.academia.despo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class Teste {

	Map<Integer, String> CANDY_BARS;

	@Before
	public void setUp () {

	    CANDY_BARS = new HashMap<Integer, String>();
	    CANDY_BARS.put(233, "REESE'S P-BUTTER CUPS");
	    CANDY_BARS.put(222, "REESE'S P-BUTTER CUPS");
	    CANDY_BARS.put(284, "TWIX, CARAMEL");
	    CANDY_BARS.put(232, "ALMOND JOY");
	    CANDY_BARS.put(149, "YORK PEPPERMINT PATTIE");
	}
	
	@Test
	public void sort_map_by_values_java () {

	    Comparator<Map.Entry<Integer, String>> byMapValues = new Comparator<Map.Entry<Integer, String>>() {
	        @Override
	        public int compare(Map.Entry<Integer, String> left, Map.Entry<Integer, String> right) {
	            return left.getValue().compareTo(right.getValue());
	        }
	    };

	    // create a list of map entries
	    List<Map.Entry<Integer, String>> candyBars = new ArrayList<Map.Entry<Integer, String>>();

	    // add all candy bars
	    candyBars.addAll(CANDY_BARS.entrySet());

	    // sort the collection
	    Collections.sort(candyBars, byMapValues);

	   System.out.println(candyBars);

	    assertEquals("ALMOND JOY", candyBars.get(0).getValue());
	}
}
