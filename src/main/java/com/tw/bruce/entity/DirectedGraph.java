package com.tw.bruce.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

/**
 * 用邻接矩阵表示的有向图
 *
 * @author LvSheng
 * @date 2019-09-13
 **/
@NoArgsConstructor
public class DirectedGraph implements Cloneable {
	
	@Getter
	@Setter
	private int vertexNum;
	@Getter
	@Setter
	private int adjacentMatrix[][];
	
	public DirectedGraph(int vertexNum) {
		this.vertexNum = vertexNum;
		this.adjacentMatrix = new int[vertexNum][vertexNum];
	}
	
	/**
	 * deep clone
	 *
	 * @return
	 * @throws CloneNotSupportedException
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		DirectedGraph clone  = (DirectedGraph) super.clone();
		int[][]       am     = new int[clone.vertexNum][clone.vertexNum];
		int[][]       matrix = clone.getAdjacentMatrix();
		
		for (int i = 0; i < matrix.length; i++) {
			am[i] = Arrays.copyOf(matrix[i], matrix[i].length);
		}
		clone.setAdjacentMatrix(am);
		return clone;
	}
}
