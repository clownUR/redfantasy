import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static RedFantasy rf;

	public static void main(String[] args) {
		setMonsters();

		while (true) {
			try {
				if (rf.player.getAgentHp() > 0 && rf.cpu.getAgentHp() > 0) {
					Thread.sleep(2000);
					rf.startPhase();
				} else if (rf.player.getAgentHp() <= 0) {
					System.out.println("Playerは死んでしまった");
					break;
				} else if (rf.cpu.getAgentHp() <= 0) {
					System.out.println("CPUは死んでしまった");
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Player History:");
		rf.player.history.printHistory();

		System.out.println("\nCPU History:");
		rf.cpu.history.printHistory();
	}
	
	public static void setMonsters() {
		List<String> tempMonsters = new ArrayList<String>(22);
		List<Integer> tempMonstersPoint = new ArrayList<Integer>(22);

		tempMonsters.add("イガキン"); tempMonstersPoint.add(9);
		tempMonsters.add("ナマチュウ"); tempMonstersPoint.add(3);
		tempMonsters.add("イノウエン"); tempMonstersPoint.add(1);
		tempMonsters.add("リョージィ"); tempMonstersPoint.add(2);
		tempMonsters.add("アキモトン"); tempMonstersPoint.add(5);
		tempMonsters.add("ゴージマ"); tempMonstersPoint.add(4);
		tempMonsters.add("チュウデン"); tempMonstersPoint.add(6);
		tempMonsters.add("ヅカホン"); tempMonstersPoint.add(8);
		tempMonsters.add("ニシムラー"); tempMonstersPoint.add(7);
		tempMonsters.add("サコーデン"); tempMonstersPoint.add(2);
		tempMonsters.add("ウッチー"); tempMonstersPoint.add(5);
		tempMonsters.add("ハヤッシー"); tempMonstersPoint.add(4);
		tempMonsters.add("キーチー"); tempMonstersPoint.add(3);
		tempMonsters.add("リョクン"); tempMonstersPoint.add(1);
		tempMonsters.add("デコポン"); tempMonstersPoint.add(6);
		tempMonsters.add("カミサン"); tempMonstersPoint.add(5);
		tempMonsters.add("シスイ"); tempMonstersPoint.add(1);
		tempMonsters.add("ジョナ"); tempMonstersPoint.add(7);
		tempMonsters.add("ギダギダ"); tempMonstersPoint.add(2);
		tempMonsters.add("ミッツー"); tempMonstersPoint.add(8);
		tempMonsters.add("ゾエサン"); tempMonstersPoint.add(5);
		tempMonsters.add("キタバー"); tempMonstersPoint.add(5);

		rf = new RedFantasy(tempMonsters, tempMonstersPoint);
   
  }
}