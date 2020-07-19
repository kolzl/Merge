package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<List<Integer>> startingList = new ArrayList<>();
		fillStartingList(startingList);

		List<List<Integer>> mergedList = new ArrayList<>();
		mergeList(mergedList, startingList);

	}

	/**
	 * Funktion liest Textdatei mit dem Namen "Tuples.txt" im ResourceOrdner
	 * (src/main/resources) des Projektes ein. Dabei werden zwei Werte voneinander
	 * separiert und als Liste abgespeichert (Tuple Implementierung). Diese werden
	 * dann in einer Liste (startingList) gespeichert.
	 * 
	 * @param startingList enthält nach Abschluss der Funktion alle Tuple die
	 *                     gemerged werden sollen
	 */
	private static void fillStartingList(List<List<Integer>> startingList) {
		try {
//			File tupleFile = new File("src/main/resources/Tuples.txt");
			File tupleFile = new File("Tuples.txt");
			Scanner scanner = new Scanner(tupleFile);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] tuple = data.split(",");
				List<Integer> tupleInt = new ArrayList<>();
				for (String value : tuple) {
					tupleInt.add(Integer.parseInt(value));
				}
				startingList.add(tupleInt);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("Starting List: " + startingList);
	}

	/**
	 * Funktion merged die einzelnen Tupel und speichert sie in einer Liste
	 * (mergedList) ab.
	 * 
	 * @param mergedList   nach Abschluss der Methode die gesuchte gemergte Liste
	 * @param startingList die Ursprungsliste mit allen Tuplen
	 */
	public static void mergeList(List<List<Integer>> mergedList, List<List<Integer>> startingList) {
		List<Integer> lastTuple = null;
		boolean firstRun = true;

		for (List<Integer> tuple : startingList) {

			if (firstRun) {
				mergedList.add(tuple);
				lastTuple = tuple;
				firstRun = false;
			} else {
				List<Integer> newTuple = null;
				for (List<Integer> mergedTuple : mergedList) {
					newTuple = mergeTuple(mergedTuple, tuple, mergedList);
				}
				if (newTuple != null && lastTuple != newTuple) {
					mergedList.add(newTuple);
					lastTuple = newTuple;
				}
			}
		}

		System.out.println("MergedList: " + mergedList);
	}

	/**
	 * Funktion zum vergleichen von Tuplen. Merged einzelne Tuple aus übergebenen
	 * Listen zusammen.
	 * 
	 * @param mergedTuple Gemergter Tuple einer Liste
	 * @param tuple       Neue Tupler der mit mergedTuple verglichen wird
	 * @param mergedList  Fertige Liste gemergter Tuple
	 * @return
	 */
	private static List<Integer> mergeTuple(List<Integer> mergedTuple, List<Integer> tuple,
			List<List<Integer>> mergedList) {
		int _11 = mergedTuple.get(0);
		int _12 = mergedTuple.get(1);
		int _21 = tuple.get(0);
		int _22 = tuple.get(1);

		if (_21 >= _11) {
			if (_21 >= _12) {
				System.out.println("New Tuple is bigger than merged one. No Merge required!");
				return tuple;
			} else if (_22 >= _12) {
				mergedTuple.set(1, tuple.get(1));
				return mergedTuple;
			}
		} else if (_22 >= _11) {
			if (_22 >= _12) {
				mergedTuple.set(0, tuple.get(0));
				mergedTuple.set(1, tuple.get(1));
				return mergedTuple;
			} else {
				mergedTuple.set(0, tuple.get(0));
				return mergedTuple;
			}
		} else {
			System.out.println("New Tuple is smaller than merged one. No Merge required!");
			return tuple;
		}
		return null;
	}

}
