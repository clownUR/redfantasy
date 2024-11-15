public class Battle extends Object{
  public Battle(){
    super();
  }

  public void battleResult(Integer playerPoint, Integer cpuPoint, Agent player, Agent cpu){
    if(playerPoint > cpuPoint){
      System.out.println("Player Win!");
      cpu.updateAgentHp(playerPoint - cpuPoint);
    }else if(cpuPoint > playerPoint){
      System.out.println("CPU Win!");
      player.updateAgentHp(cpuPoint - playerPoint);
    }else if(playerPoint == cpuPoint){
      System.out.println("Draw!");
    }
    
    return;
  }
}