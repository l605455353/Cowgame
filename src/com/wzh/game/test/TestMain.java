package com.wzh.game.test;

import com.wzh.game.domain.Color;
import com.wzh.game.domain.Num;
import com.wzh.game.domain.Packer;
import com.wzh.game.domain.PackerCompare;
import com.wzh.game.domain.UserPacket;
/**
 * 
 * @author wzh
 * @date 2016-12-31 下午2:45:22
 * @QQ 154710510
 * @describe
 */
public class TestMain {

	public static void main(String[] args) {
		
		Packer[] p1=new Packer[5];
		p1[0]=new Packer(Num.P_9,Color.HEITAO);
		p1[1]=new Packer("P_J");
		p1[2]=new Packer("P_J");
		p1[3]=new Packer("P_J");
		p1[4]=new Packer("P_3");
		
		Packer[] p2=new Packer[5];
		p2[0]=new Packer("P_Q");
		p2[1]=new Packer("P_Q");
		p2[2]=new Packer("P_Q");
		p2[3]=new Packer("P_K");
		p2[4]=new Packer("P_K");
		
		UserPacket up1=new UserPacket(p1);
		UserPacket up2=new UserPacket(p2,true);
		UserPacket p=PackerCompare.geWin(up1, up2);
		System.out.println(p.type);
		System.out.println(p.getRatio());
	}
}
