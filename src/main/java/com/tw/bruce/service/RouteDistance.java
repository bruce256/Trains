package com.tw.bruce.service;

import static com.tw.bruce.entity.Constants.INF;
import static com.tw.bruce.entity.Constants.NO_SUCH_ROUTE;
import com.tw.bruce.entity.DirectedGraph;

/**
 * 路线距离计算
 *
 * @author LvSheng
 * @date 2019-09-13
 **/
public class RouteDistance {
	
	private DirectedGraph directedGraph;
	
	public RouteDistance(DirectedGraph directedGraph) {
		this.directedGraph = directedGraph;
	}
	
	public int calculateDistance(int[] cities) {
		if (cities == null || cities.length < 2) {
			throw new IllegalArgumentException("city num is less than 2");
		}
		
		int sum = 0;
		for (int i = 0; i < cities.length - 1; i++) {
			int distance = directedGraph.getAdjacentMatrix()[cities[i]][cities[i + 1]];
			if (distance != INF) {
				sum += distance;
			} else {
				return INF;
			}
		}
		return sum;
	}
}
