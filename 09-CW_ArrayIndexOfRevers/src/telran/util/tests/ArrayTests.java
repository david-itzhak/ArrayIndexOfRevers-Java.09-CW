package telran.util.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Array;

class ArrayTests {
	int[] arrayInt = { 10, -7, 20, 9, 13, 18 };
	String[] arrayStr = { "abd", "lm", "hello" };
	Array<Integer> arInt;
	Array<String> arStr;

	@BeforeEach
	void setUp() {
		arInt = new Array<>(3);
		arStr = new Array<>(2);
		for (int i = 0; i < arrayInt.length; i++) {
			arInt.add(arrayInt[i]);
		}
		for (int i = 0; i < arrayStr.length; i++) {
			arStr.add(arrayStr[i]);
		}

	}

	@Test
	void testNewArray() {
		Array<Integer> arIntTest = new Array<>();
		assertEquals(0, arIntTest.size());
	}

	@Test
	void testAddGet() {
		assertEquals(arrayInt.length, arInt.size());
		assertEquals(arrayStr.length, arStr.size());
		for (int i = 0; i < arrayInt.length; i++) {
			assertEquals(arrayInt[i], arInt.get(i));
		}
		for (int i = 0; i < arrayStr.length; i++) {
			assertEquals(arrayStr[i], arStr.get(i));
		}
	}

	@Test
	void testGetWrongIdex() {
		assertEquals(null, arInt.get(-1));
		assertEquals(null, arInt.get(500));
	}

	@Test
	void testAddIndex() {
		int[] expected = { 10, -7, 20, 9, 22, 13, 18 };
		assertTrue(arInt.add(4, 22));
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], arInt.get(i));
		}
		assertFalse(arInt.add(-4, 22));
		assertFalse(arInt.add(400, 22));
	}

	@Test
	void testAddAndRelocate() {
		int[] expected = { 10, -7, 20, 9, 13, 9, 8, 7, 18 };
		arInt.add(5, 7);
		arInt.add(5, 8);
		arInt.add(5, 9);
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], arInt.get(i));
		}
	}

	@Test
	void testRemoveIndex() {
		int[] expected = { 10, -7, 9, 13, 18 };
		assertEquals(20, arInt.remove(2));
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], arInt.get(i));
		}
		assertNull(arInt.remove(-4));
		assertNull(arInt.remove(400));
	}

	@Test
	void testIndexOf() {
		int[] expected = { 10, -7, 20, 9, 13, 18 };
		for (int i = 0; i < expected.length; i++) {
			int pattern = expected[i];
			assertEquals(i, arInt.indexOf(pattern));
		}
		assertEquals(-1, arInt.indexOf(-100));
		assertEquals(-1, arInt.indexOf(100));
	}

	@Test
	void testLastIndexOf() {
		arInt.add(5, 20);
		assertEquals(5, arInt.lastIndexOf(20));
		assertEquals(-1, arInt.lastIndexOf(-100));
		assertEquals(-1, arInt.lastIndexOf(100));
	}

	@Test
	void testRevers() {
		int[] expected = { 18, 13, 9, 20, -7, 10 };
		arInt.reverse();
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], arInt.get(i));
		}
		arInt.add(5, 20);
		arInt.reverse();
		int[] expected2 = { 10, 20, -7, 20, 9, 13, 18 };
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected2[i], arInt.get(i));
		}

	}

}
