import java.util.stream.IntStream;
import java.util.List;

public class Dice extends Object{
  private Status status;
  private Monsters monster;

  public Dice(Status myStatus, Monsters monsters){
    this.status = myStatus;
    this.monster = monsters;
  }

  public void diceEffect(Integer diceNum){
    List<Integer> agentMonster = this.monster.getAgentMonsters();

    if(diceNum == 1){
      //updateMonsterPoint間違っている
      System.out.println("失敗！すべてのモンスターポイントが半分になる");
     
      IntStream.range(0, agentMonster.size())
      .filter(index -> agentMonster.get(index) != -1)
      .forEach(filterIndex ->this.status.updateMonsterPoint(filterIndex, this.status.getAgentMonsterPoint(filterIndex) / 2));
    
    }else if(diceNum == 6){
      System.out.println("Critical！すべてのモンスターポイントが倍になる");
     
      IntStream.range(0, agentMonster.size())
      .filter(index -> agentMonster.get(index) != -1)
      .forEach(filterIndex -> this.status.updateMonsterPoint(filterIndex, this.status.getAgentMonsterPoint(filterIndex) * 2));
    }else{
      this.status.changeBonusPoint(diceNum);
    }
  }

}