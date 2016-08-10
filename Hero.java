/**
 /**
 * <p>Title: Hero</p>
 * <p>Description: </p>
 * <p>Company: NetEase</p>
 */
package cn.shsxt.Hero;

/**
 * @author Sinwugoo 
 * @date   2016年8月3日
 */
public abstract class Hero {
	static int count = 0;
	// 英雄的名称
	String name;
	// 英雄模型的4维
	int Hp;

	int Mp;

	int attack;

	int defend;

	public Hero() {
		super();
	}

	public Hero(String name, int hp, int mp, int attack, int defend) {
		super();
		this.name = name;
		Hp = hp;
		Mp = mp;
		this.attack = attack;
		this.defend = defend;
	}

	//英雄在战斗中造成的威力
	int damage;
	
	//所有英雄的进攻
	abstract public void attackMode();
	
	abstract public void skillMode();
}