package com.tw.bruce.service;

import static com.tw.bruce.entity.Constants.CHAR_A;
import static com.tw.bruce.entity.Constants.INF;
import com.tw.bruce.entity.DirectedGraph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LvSheng
 * @date 2019-09-15
 **/
public class RoutesNumber {
	
	private DirectedGraph directedGraph;
	
	public RoutesNumber(DirectedGraph directedGraph) {
		this.directedGraph = directedGraph;
	}
	
	public int getRouteNumber(int start, int end, int maxDistance) {
		Set<String> pathSet = new HashSet<>();
		dfs(start, end, 0, maxDistance, Character.valueOf((char)(start + CHAR_A)).toString(),  pathSet);
		return pathSet.size();
	}
	
	private void dfs(int currentCity, int end, int currentDistance, int maxDistance, String path, Set<String> pathSet ) {
		if (currentDistance >= maxDistance) {
			return ;
		}
		
		int[][] matrix = this.directedGraph.getAdjacentMatrix();
		
		// 边界条件 C -> C
		if (currentCity == end && currentDistance != 0) {
			pathSet.add(path);
		}
		
		int sum = 0;
		for (int i = 0; i < matrix[currentCity].length; i++) {
			if (matrix[currentCity][i] != INF) {
				dfs(i, end, matrix[currentCity][i] + currentDistance, maxDistance, path + Character.valueOf((char)(i + CHAR_A)), pathSet);
			}
		}
	}
}
