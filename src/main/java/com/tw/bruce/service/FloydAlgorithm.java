package com.tw.bruce.service;

import static com.tw.bruce.entity.Constants.INF;
import com.tw.bruce.entity.DirectedGraph;

/**
 * 弗洛伊德算法，求多源最短路径
 *
 * @author LvSheng
 * @date 2019-09-14
 **/
public class FloydAlgorithm {
	
	private DirectedGraph directedGraph;
	
	public FloydAlgorithm(DirectedGraph dg) {
		try {
			this.directedGraph = (DirectedGraph) dg.clone();
			this.calculate();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	public void calculate() {
		for (int k = 0; k < directedGraph.getVertexNum(); k++) {
			for (int i = 0; i < directedGraph.getVertexNum(); i++) {
				for (int j = 0; j < directedGraph.getVertexNum(); j++) {
					int distance = directedGraph.getAdjacentMatrix()[i][k] != INF && directedGraph.getAdjacentMatrix()[k][j] != INF
							? directedGraph.getAdjacentMatrix()[i][k] + directedGraph.getAdjacentMatrix()[k][j] : INF;
					if (distance != INF && directedGraph.getAdjacentMatrix()[i][j] > distance) {
						directedGraph.getAdjacentMatrix()[i][j] = distance;
					}
				}
			}
		}
	}
	
	public int getShortestDistance(int start, int end) {
		return directedGraph.getAdjacentMatrix()[start][end];
	}
}
