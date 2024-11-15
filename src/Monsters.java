import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Random;

public class Monsters extends Object{
  private List<String> monsters;
  private List<Integer> agentMonsters;
  private Status status;
  private Random rnd;
  private String name;

  public Monsters(List<String> tempMonsters, Status myStatus, String name){
    this.monsters = tempMonsters;
    this.status = myStatus;
    this.rnd = new Random();
    this.agentMonsters = new ArrayList<Integer>(Collections.nCopies(5, -1));
    this.name = name;
  }

  private void initMonsters(List<Integer> agentMonster){
    IntStream.range(0, agentMonster.size())
    .forEach(index -> agentMonster.set(index, -1));

    return;
  }

  public List<Integer> getAgentMonsters(){
    return this.agentMonsters;
  }

  public void drawMonsters(){
    this.initMonsters(this.agentMonsters);

    Integer p = this.rnd.nextInt(this.agentMonsters.size() - 2) + 3;
    System.out.println(this.name + " Draw " + p + " monsters");
    
    IntStream.range(0, p).forEach(index -> {
      Integer m = this.rnd.nextInt(this.monsters.size());
      this.agentMonsters.set(index, m);
      this.status.updateMonsterPoint(index, this.status.getMonstersPoint(m));
    });

    return;
  }

  public void printMonsters(){
    IntStream.range(0, this.agentMonsters.size())
    .filter(index -> this.agentMonsters.get(index) != -1)
    .forEach(filterIndex -> System.out.print(this.monsters.get(this.agentMonsters.get(filterIndex)) + " "));

    return;
  }

}