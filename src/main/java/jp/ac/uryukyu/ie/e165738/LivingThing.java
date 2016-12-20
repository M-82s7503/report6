package jp.ac.uryukyu.ie.e165738;

/**
 * 生き物（？）クラス。
 *  String name; //名前
 *  int hitPoint; //HP
 *  int attack; //攻撃力
 *  boolean dead; //生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public abstract class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead(){
        return  dead;
    }
    public void setDead(boolean dead){
        this.dead = dead;
    }

    public String getName(){
        return name;
    }

    public int getHP(){
        return hitPoint;
    }

    /**
     * 攻撃対象へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        // 自分が死んでいたら、攻撃しない。（生きているなら攻撃する。）
        if(isDead() == false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃!", name);
            damage = attack_options(damage, opponent);

            opponent.wounded(damage);
        }
    }
    /*
    * attackに自由に機能を追加するためのメソッド。
    *
    */
    public abstract int attack_options(int damage, LivingThing opponent);

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            announce();
        }
    }

    /**
     * 決着がついたことを知らせる言葉がHeroとEnemyで
     * 異なっているので、その違いを吸収するために、
     * オーバーライドを利用。
     */
    public abstract void announce();
}
