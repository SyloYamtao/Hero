/**
 * <p>Title: Wizard</p>
 * <p>Description: </p>
 * <p>Company: NetEase</p>
 */
package cn.shsxt.Hero;

/**
 * @author Sinwugoo 
 * @date   2016年8月3日
 */
public class BloodMage extends Hero {
	//英雄被创建的次数
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
	//英雄在战斗中造成的伤害值
//	static int damage=0;

	// 山丘之王是近战力量型英雄，血量中等，魔法值很高
	// 战斗力很低，防御力中等，法术伤害非常高。

	public BloodMage() {
		super();
		count++;
		setProperty();
	}
/*	public static void main(String[] args) {
		BloodMage bloodMage = new BloodMage();
		System.out.println(bloodMage.toString());
	}*/
	public void setProperty() {
		String[] nameArr = { "兰霞-破日者", "廖静-鹰翼", "王帅帅-嗜血者", "肖扬-火之星", 
				"熊家财-德拉克森","徐增强-巫火", "杨阳-雷马", "姚聪-逐日者", "张建林-疾风者",
				"Anky-闇血"};
		this.name = nameArr[(int) (Math.random() * nameArr.length)];
		// 血量中等
		this.Hp = (int) (Math.random() * 380) + 110;
		// 魔法值很高
		this.Mp = (int) (Math.random() * 10) + 15;
		// 战斗力很高
		this.attack = (int)(Math.random()*10) + 15;
		// 防御力很低
		this.defend = (int)(Math.random()*2) + 1;

	}
	@Override
	public String toString() {
		
		return "英雄名:" + name + "\r\n" + "生命值:" + Hp + "\r\n" + "魔法值:" + Mp + "\r\n" + "战斗力:" + attack
				+ "\r\n" + "防御力:" + defend + "\r\n";
	}
	@Override
	public void attackMode() {
		System.out.println(name+"普通攻击，这是有"+attack+"点威力的攻击啊~~~");
		damage=attack;
	}
	@Override
	public void skillMode() {
		Mp++;
		if(Mp>=0){
			int ackPer=(int)(Math.random()*100+1);
			if(ackPer>=1&&ackPer<=25){
				if(Mp>=5){
					System.out.println(name+"使用技能：烈焰风暴，有"+(attack+10)+"点威力的魔法攻击！");	
					damage=attack+10;
					Mp-=4;					
				}else{
					ackPer+=25;
				}
			}else if(ackPer>=26&&ackPer<=51){
				if(Mp>=3){
					System.out.println(name+"使用技能：放逐！有"+(attack+7)+"点威力的魔法攻击！");
					damage=attack+7;
					Mp-=2;				
				}else{
					System.out.println(name+"真可惜，没有魔法，只能使用普通攻击了！");
					attackMode();
				}				
			}else if(ackPer>=52&&ackPer<=95){
				System.out.println(name+"使用技能：急速冷却！有"+(attack+4)+"点威力的魔法攻击！");
				damage=attack+4;
				Mp-=2;
			}else {
				System.out.println(name+"使用究极技能：火之凤凰，对敌方照成极大的伤害！");
				damage=attack+40;
			}			
		}else{
			System.out.println(name+"没有魔法了，使用普通攻击~");
			attackMode();
		}
	}
	public void play(Hero h){
		
		int round=0;
		
		while(this.Hp>0&&h.Hp>0){
			round++;
			if(round==1){
				System.out.println("===============第1回合开始啦！！！=================");
				System.out.println("血魔法师="+this.name+":All right！Who wants some?");
				System.out.println("山丘之王="+h.name+":Burning，to reveage！");
				System.out.println("===============================================");
			}else{
				System.out.println("===============第"+round+"回合开始啦！！！=================");
			}
			//血魔法师的进攻
			this.skillMode();
			h.Hp-=this.damage-h.defend;
			System.out.println("=="+h.name+"==受到了"+(this.damage-h.defend)+"点伤害！他还剩"
								+h.Hp+"点Hp！");
//			//一回合秒杀
//			if(h.Hp<=0){
//				round++;
//				break;
//			}
			
			//山丘之王的进攻
			h.skillMode();
			this.Hp-=h.damage-this.defend;
			System.out.println("=="+this.name+"==受到了"+(h.damage-this.defend)+"点伤害！他还剩"
								+this.Hp+"点Hp");
			
		}
		
		if(this.Hp<=0){
			System.out.println("经过了"+round+"轮较量,血魔法师："+this.name+"战胜了:山丘之王:"+h.name+"!真是一场精彩的较量！");
		}else{
			System.out.println("经过了"+round+"轮较量，山丘之王："+h.name+"战胜了:血魔法师:"+this.name+"!真是一场精彩的较量！");
		}
	}

}