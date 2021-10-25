package com.tw.bruce.service;

import static com.tw.bruce.entity.Constants.INF;
import com.tw.bruce.entity.DirectedGraph;

/**
 * 给定起点和终点，线路条数的计算
 *
 * @author LvSheng
 * @date 2019-09-15
 **/
public class TripsNumber {
	
	private DirectedGraph directedGraph;
	
	public TripsNumber(DirectedGraph directedGraph) {
		this.directedGraph = directedGraph;
	}
	
	public int search(int start, int end, int maxStops, boolean isExact) {
		return dfs(start, end, maxStops, 0, isExact);
	}
	
	private int dfs(int currentCity, int end, int maxStops, int level, boolean isExact) {
		if (level > maxStops) {
			return 0;
		}
		
		int[][] matrix = this.directedGraph.getAdjacentMatrix();
		
		if (isExact) {
			if (currentCity == end && level == maxStops) {
				return 1;
			}
		} else {
			// 边界条件 C -> C
			if (currentCity == end && level != 0) {
				return 1;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < matrix[currentCity].length; i++) {
			if (matrix[currentCity][i] != INF) {
				sum += dfs(i, end, maxStops, level + 1, isExact);
			}
		}
		
		return sum;
	}
}
