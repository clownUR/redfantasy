import java.util.List;
import java.util.ArrayList;

public class Agent extends Object{
  public Monsters monsters;
  public History history;
  public Dice dice;
  private Status status;

  public Agent(List<String> tempMonsters, List<Integer> tempMonstersPoint, String name){
    this.status = new Status(tempMonstersPoint);
    this.monsters = new Monsters(tempMonsters, this.status, name);
    this.history = new History(this.status);
    this.dice = new Dice(this.status, this.monsters);
  }

  public Integer getAgentHp(){
    return this.status.agentHp;
  }

  public void updateAgentHp(Integer damage){
    this.status.agentHp = this.status.agentHp - damage;
    return;
  }

  public Integer getSumMonsterPoint(){
    Integer p = this.status.sumMonsterPoint(this.monsters.getAgentMonsters());
    return p;
  }

}