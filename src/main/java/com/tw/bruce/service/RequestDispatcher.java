package com.tw.bruce.service;

import static com.tw.bruce.entity.Constants.CHAR_A;
import static com.tw.bruce.entity.Constants.INF;
import static com.tw.bruce.entity.Constants.NO_SUCH_ROUTE;
import static com.tw.bruce.entity.Constants.ROUTES_NUMBER;
import static com.tw.bruce.entity.Constants.ROUTE_DISTANCE;
import static com.tw.bruce.entity.Constants.SHORTEST_ROUTE;
import static com.tw.bruce.entity.Constants.SPLITTER;
import static com.tw.bruce.entity.Constants.TRIPS_NUMBER;
import static com.tw.bruce.entity.Constants.TRIPS_NUMBER_EXACT;
import com.tw.bruce.entity.DirectedGraph;

import java.util.regex.Matcher;

/**
 * @author LvSheng
 * @date 2019-09-15
 **/
public class RequestDispatcher {
	
	private DirectedGraph directedGraph;
	private TrainFacade   trainFacade;
	
	public void init(String input) {
		this.directedGraph = GraphBuilder.build(input);
		this.trainFacade = new TrainFacade(this.directedGraph);
	}
	
	public int onDispatch(String input) {
		Matcher routeDistanceMatcher = ROUTE_DISTANCE.matcher(input);
		if (routeDistanceMatcher.find()) {
			String   group      = routeDistanceMatcher.group(1);
			String[] citiesChar = SPLITTER.split(group);
			int[]    cities     = new int[citiesChar.length];
			for (int i = 0; i < citiesChar.length; i++) {
				cities[i] = citiesChar[i].charAt(0) - CHAR_A;
			}
			
			int routeDistance = trainFacade.getRouteDistance(cities);
			if (routeDistance == INF) {
				System.out.println(NO_SUCH_ROUTE);
			} else {
				System.out.println(routeDistance);
			}
			
			return routeDistance;
		}
		
		Matcher tripsNumberMatcher = TRIPS_NUMBER.matcher(input);
		if (tripsNumberMatcher.find()) {
			int start    = tripsNumberMatcher.group(1).charAt(0) - CHAR_A;
			int end      = tripsNumberMatcher.group(2).charAt(0) - CHAR_A;
			int maxStops = Integer.parseInt(tripsNumberMatcher.group(3));
			
			int numberOfTrips = trainFacade.getNumberOfTrips(start, end, maxStops);
			System.out.println(numberOfTrips);
			return numberOfTrips;
		}
		
		Matcher tripsNumberExactMatcher = TRIPS_NUMBER_EXACT.matcher(input);
		if (tripsNumberExactMatcher.find()) {
			int start    = tripsNumberExactMatcher.group(1).charAt(0) - CHAR_A;
			int end      = tripsNumberExactMatcher.group(2).charAt(0) - CHAR_A;
			int maxStops = Integer.parseInt(tripsNumberExactMatcher.group(3));
			
			int numberOfTrips = trainFacade.getNumberofTripsWithExactStops(start, end, maxStops);
			System.out.println(numberOfTrips);
			return numberOfTrips;
		}
		
		Matcher shortestMatcher = SHORTEST_ROUTE.matcher(input);
		if (shortestMatcher.find()) {
			int start = shortestMatcher.group(1).charAt(0) - CHAR_A;
			int end   = shortestMatcher.group(2).charAt(0) - CHAR_A;
			
			int distance = trainFacade.getShortestDistance(start, end);
			
			if (distance == INF) {
				System.out.println(NO_SUCH_ROUTE);
			} else {
				System.out.println(distance);
			}
			
			return distance;
		}
		
		Matcher routesNumberMatcher = ROUTES_NUMBER.matcher(input);
		if (routesNumberMatcher.find()) {
			int start    = routesNumberMatcher.group(1).charAt(0) - CHAR_A;
			int end      = routesNumberMatcher.group(2).charAt(0) - CHAR_A;
			int distance = Integer.parseInt(routesNumberMatcher.group(3));
			
			int numberOfRoutes = trainFacade.getNumberOfRoutes(start, end, distance);
			System.out.println(numberOfRoutes);
			return numberOfRoutes;
		}
		
		return -1;
	}
}
