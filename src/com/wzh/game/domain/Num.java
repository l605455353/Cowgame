package com.wzh.game.domain;
/**
 * 
 * @author wzh
 * @date 2016-12-31 下午2:44:53
 * @QQ 154710510
 * @describe
 */
public enum Num {
	P_A(1),
	P_2(2),
	P_3(3),
	P_4(4),
	P_5(5),
	P_6(6),
	P_7(7),
	P_8(8),
	P_9(9),
	P_10(10),
	P_J(11),
	P_Q(12),
	P_K(13)
	;
	private int num;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	Num(int i){
		this.num=i;
	}
}
