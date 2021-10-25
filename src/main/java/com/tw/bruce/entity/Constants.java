package com.tw.bruce.entity;

import java.util.regex.Pattern;

/**
 * @author LvSheng
 * @date 2019-09-13
 **/
public class Constants {
	
	public static final int    INF           = Integer.MAX_VALUE;
	public static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";
	public static final char   CHAR_A        = 'A';
	
	// to match input
	public static Pattern ROUTE_DISTANCE     = Pattern.compile("The distance of the route (([A-Z]|\\-)+)\\.");
	public static Pattern TRIPS_NUMBER       = Pattern.compile("The number of trips starting at ([A-Z]) and ending at ([A-Z]) with a maximum of (\\d+) stops.");
	public static Pattern TRIPS_NUMBER_EXACT = Pattern.compile("The number of trips starting at ([A-Z]) and ending at ([A-Z]) with exactly (\\d+) stops\\.");
	public static Pattern SHORTEST_ROUTE     = Pattern.compile("The length of the shortest route \\(in terms of distance to travel\\) from ([A-Z]) to ([A-Z])\\.");
	public static Pattern ROUTES_NUMBER      = Pattern.compile("The number of different routes from ([A-Z]) to ([A-Z]) with a distance of less than (\\d+).");
	
	//
	public static Pattern COMMA_SPLITTER = Pattern.compile("\\s*(,|，)\\s*");
	public static Pattern SPLITTER       = Pattern.compile("\\-");
	
	
}
