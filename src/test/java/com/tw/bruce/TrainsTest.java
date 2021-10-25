package com.tw.bruce;

import static com.tw.bruce.entity.Constants.INF;
import com.tw.bruce.service.RequestDispatcher;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author LvSheng
 * @date 2019-09-15
 **/
public class TrainsTest {
	
	private static RequestDispatcher requestDispatcher;
	
	@BeforeClass
	public static void init() {
		requestDispatcher = new RequestDispatcher();
		requestDispatcher.init("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
	}
	
	@Test
	public void test1() {
		int distance = requestDispatcher.onDispatch("The distance of the route A-B-C.");
		Assert.assertEquals(distance, 9);
	}
	
	@Test
	public void test2() {
		int distance = requestDispatcher.onDispatch("The distance of the route A-D.");
		Assert.assertEquals(distance, 5);
	}
	
	@Test
	public void test3() {
		int distance = requestDispatcher.onDispatch("The distance of the route A-D-C.");
		Assert.assertEquals(distance, 13);
	}
	
	@Test
	public void test4() {
		int distance = requestDispatcher.onDispatch("The distance of the route A-E-B-C-D.");
		Assert.assertEquals(distance, 22);
	}
	
	@Test
	public void test5() {
		int distance = requestDispatcher.onDispatch("The distance of the route A-E-D.");
		Assert.assertEquals(distance, INF);
	}
	
	@Test
	public void test6() {
		int result = requestDispatcher.onDispatch("The number of trips starting at C and ending at C with a maximum of 3 stops.");
		Assert.assertEquals(result, 2);
	}
	
	@Test
	public void test7() {
		int result = requestDispatcher.onDispatch("The number of trips starting at A and ending at C with exactly 4 stops.");
		Assert.assertEquals(result, 3);
	}
	
	@Test
	public void test8() {
		int result = requestDispatcher.onDispatch("The length of the shortest route (in terms of distance to travel) from A to C.");
		Assert.assertEquals(result, 9);
	}
	
	@Test
	public void test9() {
		int result = requestDispatcher.onDispatch("The length of the shortest route (in terms of distance to travel) from B to B.");
		Assert.assertEquals(result, 9);
	}
	
	@Test
	public void test10() {
		int result = requestDispatcher.onDispatch("The number of different routes from C to C with a distance of less than 30.");
		Assert.assertEquals(result, 7);
	}
}
