package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Maintest {

	@Test
	public void mergeListTest() {

		List<List<Integer>> startingList = new ArrayList<>();
		List<Integer> tuple1 = Arrays.asList(1, 10);
		startingList.add(tuple1);
		List<Integer> tuple2 = Arrays.asList(2, 4);
		startingList.add(tuple2);
		List<Integer> tuple3 = Arrays.asList(5, 12);
		startingList.add(tuple3);
		List<Integer> tuple4 = Arrays.asList(17, 22);
		startingList.add(tuple4);
		List<Integer> tuple5 = Arrays.asList(15, 18);
		startingList.add(tuple5);

		List<List<Integer>> mergedList = new ArrayList<>();
		Main.mergeList(mergedList, startingList);

		List<List<Integer>> expectedList = new ArrayList<>();
		expectedList.add(Arrays.asList(1, 12));
		expectedList.add(Arrays.asList(15, 22));
		System.out.println("Expected List: " + expectedList);
		Assert.assertEquals(expectedList, mergedList);
	}

	@Test
	public void mergeListTestWithSameValues() {

		List<List<Integer>> startingList = new ArrayList<>();
		List<Integer> tuple1 = Arrays.asList(8, 10);
		startingList.add(tuple1);
		List<Integer> tuple2 = Arrays.asList(7, 10);
		startingList.add(tuple2);
		List<Integer> tuple3 = Arrays.asList(8, 10);
		startingList.add(tuple3);
		List<Integer> tuple4 = Arrays.asList(8, 11);
		startingList.add(tuple4);

		List<List<Integer>> mergedList = new ArrayList<>();
		Main.mergeList(mergedList, startingList);

		List<List<Integer>> expectedList = new ArrayList<>();
		expectedList.add(Arrays.asList(7, 11));
		System.out.println("Expected List: " + expectedList);
		Assert.assertEquals(expectedList, mergedList);
	}
}
