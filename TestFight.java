/**
 * <p>Title: TestFight</p>
 * <p>Description: </p>
 * <p>Company: NetEase</p>
 */
package cn.shsxt.Hero;

/**
 * @author Sinwugoo
 * @date 2016年8月3日
 */
public class TestFight {
	public static void main(String[] args) {
		MountainKing mountainKing = new MountainKing();
		System.out.println(mountainKing.toString());
		
		BloodMage bloodMage = new BloodMage();
		System.out.println(bloodMage.toString());
		
		if(bloodMage instanceof Hero){
			Hero h=(Hero)bloodMage;
			mountainKing.play(h);
		}
	}
}
