package com.tw.bruce.service;

import com.tw.bruce.entity.DirectedGraph;

/**
 * 所有服务的门面
 *
 * @author LvSheng
 * @date 2019-09-15
 **/
public class TrainFacade {
	
	private DirectedGraph directedGraph;
	
	private TripsNumber    tripsNumber;
	private RouteDistance  routeDistance;
	private FloydAlgorithm floydAlgorithm;
	private RoutesNumber   routesNumber;
	
	public TrainFacade(DirectedGraph directedGraph) {
		this.directedGraph = directedGraph;
		this.floydAlgorithm = new FloydAlgorithm(directedGraph);
		this.tripsNumber = new TripsNumber(directedGraph);
		this.routeDistance = new RouteDistance(directedGraph);
		this.routesNumber = new RoutesNumber(directedGraph);
	}
	
	public int getShortestDistance(int start, int end) {
		return floydAlgorithm.getShortestDistance(start, end);
	}
	
	public int getNumberOfTrips(int start, int end, int maxStops) {
		return tripsNumber.search(start, end, maxStops, false);
	}
	
	public int getNumberofTripsWithExactStops(int start, int end, int maxStops) {
		return tripsNumber.search(start, end, maxStops, true);
	}
	
	public int getRouteDistance(int[] cities) {
		return routeDistance.calculateDistance(cities);
	}
	
	public int getNumberOfRoutes(int start, int end, int maxDistance) {
		return routesNumber.getRouteNumber(start, end, maxDistance);
	}
}
