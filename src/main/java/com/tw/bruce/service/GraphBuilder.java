package com.tw.bruce.service;

import com.tw.bruce.entity.Constants;
import static com.tw.bruce.entity.Constants.INF;
import static com.tw.bruce.entity.Constants.COMMA_SPLITTER;
import com.tw.bruce.entity.DirectedGraph;

import java.util.Arrays;

/**
 * 构建一个张邻接表
 *
 * @author LvSheng
 * @date 2019-09-15
 **/
public class GraphBuilder {
	
	/**
	 * @param input example : AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
	 */
	public static DirectedGraph build(String input) {
		String[]      pairs     = COMMA_SPLITTER.split(input);
		int           vertexNum = calculateVertexNum(pairs);
		DirectedGraph dg        = new DirectedGraph(vertexNum);
		fillMatrix(pairs, vertexNum, dg);
		return dg;
	}
	
	private static void fillMatrix(String[] pairs, int vertexNum, DirectedGraph dg) {
		// 填充最大值
		for (int i = 0; i < vertexNum; i++) {
			Arrays.fill(dg.getAdjacentMatrix()[i], INF);
		}
		
		Arrays.stream(pairs).forEach(pair -> {
			int start    = pair.charAt(0) - Constants.CHAR_A;
			int end      = pair.charAt(1) - Constants.CHAR_A;
			int distance = Integer.valueOf(pair.substring(2));
			
			dg.getAdjacentMatrix()[start][end] = distance;
		});
	}
	
	private static int calculateVertexNum(String[] pairs) {
		int max = 0;
		for (String pair : pairs) {
			if (pair.charAt(0) - Constants.CHAR_A > max) {
				max = pair.charAt(0) - Constants.CHAR_A;
			}
			
			if (pair.charAt(1) - Constants.CHAR_A > max) {
				max = pair.charAt(1) - Constants.CHAR_A;
			}
		}
		
		return max + 1;
	}
}
