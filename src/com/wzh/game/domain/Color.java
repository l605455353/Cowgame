package com.wzh.game.domain;
/**
 * 
 * @author wzh
 * @date 2016-12-31 下午2:44:46
 * @QQ 154710510
 * @describe
 */
public enum Color {
	HEITAO(4),
	HONGTAO(3),
	MEIHAU(2),
	FANGKUAI(1)
	;
	
	
	private int color;

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	Color(int i){
		this.color=i;
	}
	
}
