package com.allendowney.thinkdast;

import java.util.HashMap;
import java.util.Map;

import org.jfree.data.xy.XYSeries;

import com.allendowney.thinkdast.Profiler.Timeable;

public class ProfileMapPut {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//profileHashMapPut();
		//profileMyHashMapPut();
		profileMyFixedHashMapPut();
	}

	/**
	 * Characterize the run time of putting a key in java.util.HashMap
	 */
	public static void profileHashMapPut() {
		Timeable timeable = new Timeable() {
			Map<String, Integer> map;

			public void setup(int n) {
				map = new HashMap<String, Integer>();
			}

			public void timeMe(int n) {
				for (int i=0; i<n; i++) {
					map.put(String.format("%10d", i), i);
				}
			}
		};
		int startN = 8000;
		int endMillis = 1000;
		runProfiler("HashMap put", timeable, startN, endMillis);
	}
	
	/**
	 * Characterize the run time of putting a key in MyHashMap
	 */
	public static void profileMyHashMapPut() {
		Timeable timeable = new Timeable() {
			Map<String, Integer> map;

			public void setup(int n) {
				map = new MyHashMap<String, Integer>();
			}

			public void timeMe(int n) {
				for (int i=0; i<n; i++) {
					map.put(String.format("%10d", i), i);
				}
			}
		};
		int startN = 1000;
		int endMillis = 5000;
		runProfiler("MyHashMap put", timeable, startN, endMillis);
	}
	

	/**
	 * Characterize the run time of putting a key in MyFixedHashMap
	 */
	public static void profileMyFixedHashMapPut() {
		Timeable timeable = new Timeable() {
			Map<String, Integer> map;

			public void setup(int n) {
				map = new MyFixedHashMap<String, Integer>();
			}

			public void timeMe(int n) {
				for (int i=0; i<n; i++) {
					map.put(String.format("%10d", i), i);
				}
			}
		};
		int startN = 8000;
		int endMillis = 1000;
		runProfiler("MyFixedHashMap put", timeable, startN, endMillis);
	}
	
	/**
	 * Runs the profiles and displays results.
	 * 
	 * @param timeable
	 * @param startN
	 * @param endMillis
	 */
	private static void runProfiler(String title, Timeable timeable, int startN, int endMillis) {
		Profiler profiler = new Profiler(title, timeable);
		XYSeries series = profiler.timingLoop(startN, endMillis);
		profiler.plotResults(series);
	}
}