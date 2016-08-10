/**
 /**
 * <p>Title: TestHero</p>
 * <p>Description: </p>
 * <p>Company: NetEase</p>
 */
package cn.shsxt.Hero;

import java.util.Scanner;

/**
 * @author Sinwugoo
 * @date 2016年8月3日
 */
public class TestHero {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("请输入您需要创建的英雄种类：1.战士类型-山丘之王 2.法师类型-血魔法师");
			int choose=scanner.nextInt();
			switch(choose){
				case 1:MountainKing mountainKing = new MountainKing();
					System.out.println(mountainKing.toString());
					System.out.println("该英雄已经被创建了："+MountainKing.count+"次");
				break;
				case 2:BloodMage bloodMage = new BloodMage();
					System.out.println(bloodMage.toString());	
					System.out.println("该英雄已经被创建了："+BloodMage.count+"次");
				break;
				default:
					System.out.println("您的输入有问题啊~请重新输入");
			}
		}
	}
}
