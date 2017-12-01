package com.wzh.game.domain;

import java.util.HashMap;
import java.util.Map;
/**
 * @author wzh
 * 倍率配置
 */
public class RatioConfig {
	// 倍率
	public static Map<Integer, Integer> ratio = new HashMap<Integer, Integer>();
	static {
		ratio.put(-1, 1);
		ratio.put(1, 1);
		ratio.put(2, 1);
		ratio.put(3, 1);
		ratio.put(4, 1);
		ratio.put(5, 1);
		ratio.put(6, 1);
		ratio.put(7, 2);
		ratio.put(8, 2);
		ratio.put(9, 3);
		ratio.put(10, 4);
		ratio.put(99, 5);
		ratio.put(100, 6);
	}
}
