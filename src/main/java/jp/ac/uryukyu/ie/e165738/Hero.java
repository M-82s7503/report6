package jp.ac.uryukyu.ie.e165738;

import java.util.Random;

/**
 * ヒーロークラス。
 *  String name; //ヒーローの名前
 *  int hitPoint; //ヒーローのHP
 *  int attack; //ヒーローの攻撃力
 *  boolean dead; //ヒーローの生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
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
            if(feeling > 6){    // 乱数（0~9の整数）のうち、7か8か9が出たら2倍（30%）
                damage = damage*2;
                System.out.printf("会心の一撃！！");
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
        System.out.printf("%sは道半ばで力尽きてしまった。\n", getName());
    }
}