import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.IntStream;

public class History extends Object{
  private List<Integer> agentHistory;
  private Status status;
  
  public History(Status myStatus){
    this.status = myStatus;
    this.agentHistory = new ArrayList<Integer>(Collections.nCopies(100, -9999));
    this.agentHistory.add(0, this.status.agentHp);
  }

  public void updateHistory(){
    IntStream.range(0, this.agentHistory.size())
    .filter(index -> this.agentHistory.get(index) == -9999)
    .findFirst()
    .ifPresent(findIndex -> this.agentHistory.add(findIndex, this.status.agentHp));

    return;
  }

  public void printHistory(){
    agentHistory.stream()
		.filter(value -> value != -9999)
		.forEach(value -> System.out.print(value + "\t"));

    return;
  }
}