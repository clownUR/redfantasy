import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Status extends Object{
  private List<Integer> monstersPoint;
  private List<Integer> agentMonstersPoint;
  public Integer agentHp;
  private Integer agentBonusPoint;

  public Status(List<Integer> tempMonstersPoint){
    this.monstersPoint= tempMonstersPoint;
    this.agentMonstersPoint = new ArrayList<Integer>(5);
    this.agentHp = 50;
    this.agentBonusPoint = 0;
  }

  public void initMonstersPoint(Integer index, Integer point){
    this.agentMonstersPoint.add(index, point);
    return;
  }

  public Integer getAgentMonsterPoint(Integer index){
    return this.agentMonstersPoint.get(index);
  }

  public Integer getMonstersPoint(Integer index){
    return this.monstersPoint.get(index);
  }

  public void updateMonsterPoint(Integer index, Integer point){
    try{
      this.agentMonstersPoint.set(index, point);
    }catch(IndexOutOfBoundsException error){
      this.initMonstersPoint(index, point);
    }

    return;
  }

  public void changeBonusPoint(Integer diceNum){
    this.agentBonusPoint = diceNum;
    return;
  }

  public Integer sumMonsterPoint(List<Integer> agentMonsters){
    Integer p = this.agentBonusPoint;
       
    p = p + IntStream.range(0, agentMonsters.size())
                      .filter(index -> agentMonsters.get(index) != -1)
                      .map(filterIndex -> this.agentMonstersPoint.get(filterIndex))
                      .sum();

    return p;
  }

}