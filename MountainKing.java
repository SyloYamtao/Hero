/**
 * <p>Title: Fighter</p>
 * <p>Description: </p>
 * <p>Company: NetEase</p>
 */
package cn.shsxt.Hero;
/**
 * @author Sinwugoo 
 * @date   2016年8月3日
 */
class MountainKing extends Hero {
	
	static int count = 0;
//	// 英雄的名称
//	String name;
//
//	// 英雄模型的4维
//	int Hp;
//
//	int Mp;
//
//	int attack;
//
//	int defend;
//	
//	//英雄在战斗中造成的伤害值
//	int damage=0;

// 	山丘之王是近战力量型英雄，血量高，魔法值低
// 	战斗力一般，防御力很高，有25%几率普通攻击造成2倍的威力

	public MountainKing() {
		super();
		count++;
		setProperty();
	}

	public void setProperty() {
		String[] nameArr = { "穆拉丁", "蔡锡生-碎石者", "陈坤-铁壁", "戴叶超-阔斧", 
				"顾骁伟-酷铁锤","黄乒乒-雷鸣", "贾博宁-冰胡", "李建火-铁壁", "刘志鹏-岩胡",
				"罗文星-炉火", "倪天龙-末日熔炉", "沈勇-棍石", "王杰-石匠", "张五飞-大石碎胸口者" };
		this.name = nameArr[(int) (Math.random() * nameArr.length)];
		// 血量高Hp
		this.Hp = (int) (Math.random() * 550) + 200;
		// 魔法值低
		this.Mp = (int) (Math.random() * 4) + 2;
		// 战斗力一般
		this.attack = (int) (Math.random() * 5) + 6;
		// 防御力很高
		this.defend = (int) (Math.random() * 4) + 7;

	}
	public void showHero(Hero h){
		System.out.println(this.toString());
	}
	@Override
	public String toString() {
		
		return "英雄名:" + name + "\r\n" + 
				"生命值:" + Hp + "\r\n" + "魔法值:" + 
				Mp + "\r\n" + "战斗力:" + attack+ "\r\n" + "防御力:" + defend + "\r\n";
	}
	@Override
	public void attackMode() {
		int criticalStrikePercent=(int)Math.random()*100+1;
		if(criticalStrikePercent>0&&criticalStrikePercent<=15){
			System.out.println(name+"这次的普通攻击有"+attack+"点的威力！");
			damage=attack;
		}else{
			System.out.println(name+"致命一击！Holy shit！这次暴击有"+(attack*6)+"点的威力！");
			damage=attack*6;
		}
	}
	@Override
	public void skillMode() {
		Hp++;//每回合固定增加生命1点
		if(Mp>=0){
			int ackPer=(int)(Math.random()*100+1);
			if(ackPer>=0&&ackPer<=25){
				if(Mp>=3){
					System.out.println(name+"使用技能：风暴之锤，有"+(attack+2)+"点威力的魔法攻击！");		
					damage=attack+2;
					Mp-=2;
				}else{
					ackPer+=25;
				}
			}else if(ackPer>=26&&ackPer<=75){
				if(Mp>=3){
					System.out.println(name+"使用技能：雷霆一击，有"+(attack+1)+"点威力的魔法攻击！");
					damage=attack+1;
					Mp-=1;
				}else{
					System.out.println(name+"没魔力了，没办法了，和你真刀真枪拼啦~~");
					attackMode();
				}
			}else if(ackPer>=76&&ackPer<=95){
				System.out.println(name+"使用技能：重击，有"+(attack+1)+"点威力的魔法攻击！");
			}else {
				Hp+=300;
				attack+=10;
				System.out.println(name+"使用究极技能：天神下凡，Hp增加300点，自身攻击增加10点！");
			}			
		}else{
			System.out.println(name+"没魔力了，没办法了，和你真刀真枪拼啦~~");
			attackMode();
		}		
	}
	public void play(Hero h){
		
		int round=0;
		
		while(this.Hp>0&&h.Hp>0){
			round++;
			if(round==1){
				System.out.println("===============第1回合开始啦！！！=================");
				System.out.println("山丘之王="+this.name+":All right！Who wants some?");
				System.out.println("血魔法师="+h.name+":Burning，to reveage！");
				System.out.println("===============================================");
			}else{
				System.out.println("===============第"+round+"回合开始啦！！！=================");
			}
			//山丘之王的进攻
			this.skillMode();
			h.Hp-=this.damage-h.defend;
			System.out.println("=="+h.name+"==受到了"+(this.damage-h.defend)+"点伤害！他还剩"
								+h.Hp+"点Hp！");
//			//一回合秒杀
//			if(h.Hp<=0){
//				round++;
//				break;
//			}
			
			//血魔法师的进攻
			h.skillMode();
			this.Hp-=h.damage-this.defend;
			System.out.println("=="+this.name+"==受到了"+(h.damage-this.defend)+"点伤害！他还剩"
								+this.Hp+"点Hp");
		}
		
		if(this.Hp<=0){
			System.out.println("经过了"+round+"轮较量，血魔法师:"+h.name+"战胜了:山丘之王:"+this.name+"!真是一场精彩的较量！");
		}else{
			System.out.println("经过了"+round+"轮较量，山丘之王:"+this.name+"战胜了:血魔法师:"+h.name+"!真是一场精彩的较量！");
		}
	}
}


