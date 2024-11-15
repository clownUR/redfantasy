import java.util.Random;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * RedFantasy
 */
public class RedFantasy {
    Random rnd = new Random();
    Agent player;
    Agent cpu;
    Battle battle = new Battle();
        
    public RedFantasy(List<String> tempMonsters, List<Integer> tempMonstersPoint) {
        this.player = new Agent(tempMonsters, tempMonstersPoint, "Player");
        this.cpu = new Agent(tempMonsters, tempMonstersPoint, "CPU");
    }

    public void startPhase() {

        this.player.monsters.drawMonsters();

        this.cpu.monsters.drawMonsters();

        System.out.println("--------------------");
        System.out.print("Player Monsters List:");
        this.player.monsters.printMonsters();

        System.out.print("\nCPU Monsters List:");
        this.cpu.monsters.printMonsters();

        System.out.println("\n--------------------");
        System.out.println("Battle!");
        Integer d1 = this.rnd.nextInt(6)+1;
        System.out.println("Player's Dice'：" + d1);
        this.player.dice.diceEffect(d1);
       
        Integer d2 = this.rnd.nextInt(6)+1;
        System.out.println("CPU's Dice'：" + d2);
        this.cpu.dice.diceEffect(d2);

        System.out.println("--------------------");
        System.out.print("Player Monster Pointの合計:");

        Integer p3 = this.player.getSumMonsterPoint();
        System.out.println(p3);

        System.out.print("CPU Monster Pointの合計:");

        Integer p4 = this.cpu.getSumMonsterPoint();
        System.out.println(p4);
        System.out.println("--------------------");

        this.battle.battleResult(p3, p4, this.player, this.cpu);

        System.out.println("Player HP is " + this.player.getAgentHp());
        System.out.println("CPU HP is " + this.cpu.getAgentHp());

        System.out.println("--------------------");
        // 対戦結果の記録
   
        this.player.history.updateHistory();
        this.cpu.history.updateHistory();
    }

}