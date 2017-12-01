package com.wzh.game.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzh
 * @date 2016-12-31 下午2:45:14
 * @QQ 154710510
 * @describe
 */
public class UserPacket {

    private Packer[] ps = new Packer[5];//手里的5张牌

    public int type;//牌的类型  -1:无牛，1~9:牛一~牛9，10:牛牛，99:五花牛，100:四炸；

    private boolean win = false;//是否赢了

    private boolean isBanker = false;//是否是庄家


    // 判断是否是四炸
    public boolean isSiZha() {
        Packer[] newPs = Packer.sort(this.ps);
        //数组第二个值
        int max2 = newPs[1].getNum().getNum();
        //数组倒数第二个
        int min3 = newPs[3].getNum().getNum();
        //如果数组第二个值和数组最后一个值一样，或者数组倒数第二个值个第一个一样那么是4炸
        if (max2 == newPs[4].getNum().getNum() || min3 == newPs[0].getNum().getNum()) {
            return true;
        } else {
            return false;
        }
    }

    //判断是否是五花牛
    public boolean isWuHuaNiu() {
        Packer[] newPs = Packer.sort(this.ps);
        //如果数组最小值是大于10，那么就是五花
        int min = newPs[0].getNum().getNum();
        if (min > 10) {
            return true;
        } else {
            return false;
        }
    }

    //判断是牛几
    public int isNiuNum() {
        int[] n = new int[5];
        for (int i = 0; i < 5; i++) {
            if (ps[i].getNum().getNum() > 10) {
                n[i] = 10;
            } else {
                n[i] = ps[i].getNum().getNum();
            }
        }
        Map<String, Boolean> map = NiuNiu(n);
        if (map.get("isNiuNiu")) {
            return 10;
        }
        if (map.get("isNiuNum")) {
            int num = 0;
            for (int i : n) {
                num += i;
            }
            return num % 10;
        } else {
            return -1;
        }
    }

    private Map<String, Boolean> NiuNiu(int[] i) {
        boolean isNiuNum = false;
        boolean isNiuNiu = false;
        for (int m = 0; m <= 2; m++) {
            for (int n = m + 1; n <= 3; n++) {
                for (int z = n + 1; z <= 4; z++) {
                    if ((i[m] + i[n] + i[z]) % 10 == 0) {
                        isNiuNum = true;
                        int num = 0;
                        for (int x = 0; x <= 4; x++) {
                            if (x != m && x != n && x != z) {
                                num += i[x];
                            }
                        }
                        if (num % 10 == 0) {
                            isNiuNiu = true;
                        }
                    }
                }
            }
        }
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        result.put("isNiuNum", isNiuNum);
        result.put("isNiuNiu", isNiuNiu);
        return result;
    }

    public UserPacket(Packer[] ps) {
        this(ps, false);
    }

    public UserPacket(Packer[] ps, boolean isBanker) {
        this.ps = ps;
        this.isBanker = isBanker;
        if (isSiZha()) {
            this.type = 100;
            return;
        }
        if (isWuHuaNiu()) {
            this.type = 99;
            return;
        }
        this.type = isNiuNum();
    }


    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isBanker() {
        return isBanker;
    }

    public void setBanker(boolean isBanker) {
        this.isBanker = isBanker;
    }

    public Packer[] getPs() {
        return ps;
    }

    public void setPs(Packer[] ps) {
        this.ps = ps;
    }

    //倍率计算
    public int getRatio() {
        return RatioConfig.ratio.get(this.type);
    }

}
