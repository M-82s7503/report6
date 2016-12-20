package jp.ac.uryukyu.ie.e165738;

import java.util.Random;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public int attack_options(int damage, LivingThing opponent) {
        //Randomクラスのインスタンス化
        Random rnd = new Random();
        int feeling = rnd.nextInt(10);

        if (damage == 0){
            System.out.printf(",,,だが、%sは攻撃を回避した！\n", opponent.getName());
        }else{
            if(feeling > 7){    // 乱数（0~9の整数）のうち、8か9が出たら2倍
                damage = damage*2;
                System.out.printf("痛恨の一撃！！");
            }
            System.out.printf("%sに%dのダメージを与えた！！\n", opponent.getName(), damage);
        }
        return damage;
    }

    /**
     * 決着がついたことを知らせる言葉がHeroとEnemyで
     * 異なっているので、その違いを吸収するために、
     * オーバーライドを利用。
     */
    public void announce(){
        System.out.printf("モンスター%sは倒れた。\n", getName());
    }
}
