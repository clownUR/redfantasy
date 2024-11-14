import java.util.Random;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * RedFantasy
 */
public class RedFantasy {
    // String[] monsters = new String[22];
    // int[] monstersPoint = new int[22];

    // int[] playerMonsters = new int[5];
    // int[] playerMonstersPoint = new int[5];

    // int[] cpuMonsters = new int[5];
    // int[] cpuMonstersPoint = new int[5];
    final Integer capacityOfPlayersAndCpu = 5;

    List<String> monsters = new ArrayList<>(22);
    List<Integer> monstersPoint = new ArrayList<>(22);

    List<Integer> playerMonsters = new ArrayList<>(capacityOfPlayersAndCpu);
    List<Integer> playerMonstersPoint = new ArrayList<>(capacityOfPlayersAndCpu);

    List<Integer> cpuMonsters = new ArrayList<>(capacityOfPlayersAndCpu);
    List<Integer> cpuMonstersPoint = new ArrayList<>(capacityOfPlayersAndCpu);

    int playerHp = 50;
    int cpuHp = 50;
    int playerBonusPoint = 0;        
    int cpuBonusPoint = 0;

    Random rnd = new Random();

    // battle history
    // int[] playerHistory = new int[100];
    // int[] cpuHistory = new int[100];
    final Integer capacityOfHistory = 100;
    List<Integer> playerHistory = new ArrayList<>(capacityOfHistory);
    List<Integer> cpuHistory = new ArrayList<>(capacityOfHistory);
        
    public RedFantasy() {
        //init player/cpu monster array
        // for (int i = 0; i < this.playerMonsters.length; i++) {
        //     this.playerMonsters[i] = -1;
        //     this.cpuMonsters[i] = -1;
        // }

        IntStream.range(0, capacityOfPlayersAndCpu)
        .forEach(index -> {
            // this.playerMonsters[index] = -1;
            // this.cpuMonsters[index] = -1;
            this.playerMonsters.add(index, -1);
            this.cpuMonsters.add(index, -1);
        });

        // this.playerHistory[0] = this.playerHp;
        // this.cpuHistory[0] = this.cpuHp;
        this.playerHistory.add(0, this.playerHp);
        this.cpuHistory.add(0, this.cpuHp);
        // for (int i = 0; i < this.playerHistory.length; i++) {
        //     this.playerHistory[i] = -9999;
        //     this.cpuHistory[i] = -9999;
        // }
        IntStream.range(0, capacityOfHistory)
        .forEach(index -> {
            // this.playerHistory[index] = -9999;
            // this.cpuHistory[index] = -9999;
            this.playerHistory.add(index, -9999);
            this.cpuHistory.add(index, -9999);
        });
    }

    public void startPhase() {

        //Draw player's monster card
        // playerMonsters.length -3 ~ playerMonsters.length までのランダムなint型の数値をp1に代入する
        //int p1 = this.rnd.nextInt(this.playerMonsters.length - 2) + 3;
        int p1 = this.rnd.nextInt(this.playerMonsters.size() - 2) + 3;
        System.out.println("Player Draw " + p1 + " monsters");
        // for (int i = 0; i < p1; i++) {
        //     int m = this.rnd.nextInt(this.monsters.length);
        //     this.playerMonsters[i] = m;
        //     this.playerMonstersPoint[i] = this.monstersPoint[m];
        // }
        IntStream.range(0, p1)
        .forEach(index -> {
            int m = this.rnd.nextInt(this.monsters.size());
            // this.playerMonsters[index] = m;
            // this.playerMonstersPoint[index] = this.monstersPoint[m];
            this.playerMonsters.set(index, m);
            this.playerMonstersPoint.add(index, this.monstersPoint.get(m));

        });

        //Draw cpu's monster card
        //int p2 = this.rnd.nextInt(this.cpuMonsters.length -2 ) + 3;
        int p2 = this.rnd.nextInt(this.cpuMonsters.size() -2 ) + 3;
        System.out.println("CPU Draw " + p2 + " monsters");
        // for (int i = 0; i < p2; i++) {
        //     int m = this.rnd.nextInt(this.monsters.length);
        //     this.cpuMonsters[i] = m;
        //     this.cpuMonstersPoint[i] = this.monstersPoint[m];
        // }
        IntStream.range(0, p2)
        .forEach(index -> {
            int m = this.rnd.nextInt(this.monsters.size());
            // this.cpuMonsters[index] = m;
            // this.cpuMonstersPoint[index] = this.monstersPoint[m];
            this.cpuMonsters.set(index, m);
            this.cpuMonstersPoint.add(index, this.monstersPoint.get(m));
        });


        System.out.println("--------------------");
        System.out.print("Player Monsters List:");
        // for(int i = 0; i < this.playerMonsters.length; i++){
        //     if(this.playerMonsters[i] != -1){
        //         System.out.print(this.monsters[this.playerMonsters[i]] + " ");
        //     }
        // }
        // IntStream.range(0, this.playerMonsters.length)
        // .filter(index -> this.playerMonsters[index] != -1)
        // .forEach(filterIndex -> System.out.print(this.monsters[this.playerMonsters[filterIndex]] + " "));
        IntStream.range(0, this.playerMonsters.size())
        .filter(index -> this.playerMonsters.get(index) != -1)
        .forEach(filterIndex -> System.out.print(this.monsters.get(this.playerMonsters.get(filterIndex)) + " "));


        System.out.print("\nCPU Monsters List:");
        // for(int i = 0; i < this.cpuMonsters.length; i++){
        //     if(this.cpuMonsters[i] != -1){
        //         System.out.print(this.monsters[this.cpuMonsters[i]] + " ");
        //     }
        // }
        // IntStream.range(0, this.cpuMonsters.length)
        // .filter(index -> this.cpuMonsters[index] != -1)
        // .forEach(filterIndex -> System.out.print(this.monsters[this.cpuMonsters[filterIndex]] + " "));
        IntStream.range(0, this.cpuMonsters.size())
        .filter(index -> this.cpuMonsters.get(index) != -1)
        .forEach(filterIndex -> System.out.print(this.monsters.get(this.cpuMonsters.get(filterIndex)) + " "));


        System.out.println("\n--------------------");
        System.out.println("Battle!");
        int d1 = this.rnd.nextInt(6)+1; //1~6のサイコロを振る
        System.out.println("Player's Dice'：" + d1);
        if(d1 == 1){
            System.out.println("失敗！すべてのモンスターポイントが半分になる");
            // for(int i = 0; i < this.playerMonsters.length; i++){
            //     if(this.playerMonsters[i] != -1){
            //         this.playerMonstersPoint[i] = this.playerMonstersPoint[i] / 2;
            //     }
            // }
            // IntStream.range(0, this.playerMonsters.length)
            // .filter(index -> this.playerMonsters[index] != -1)
            // .forEach(filterIndex -> this.playerMonstersPoint[filterIndex] = this.playerMonstersPoint[filterIndex] / 2);
            IntStream.range(0, this.playerMonsters.size())
            .filter(index -> this.playerMonsters.get(index) != -1)
            .forEach(filterIndex -> this.playerMonstersPoint.set(filterIndex, this.playerMonstersPoint.get(filterIndex) / 2));

        }else if(d1 == 6){
            System.out.println("Critical！すべてのモンスターポイントが倍になる");
            // for(int i = 0; i < this.playerMonsters.length; i++){
            //     if(this.playerMonsters[i] != -1){
            //         this.playerMonstersPoint[i] = this.playerMonstersPoint[i] * 2;
            //     }
            // }
            // IntStream.range(0, this.playerMonsters.length)
            // .filter(index -> this.playerMonsters[index] != -1)
            // .forEach(filterIndex -> this.playerMonstersPoint[filterIndex] = this.playerMonstersPoint[filterIndex] * 2);
            IntStream.range(0, this.playerMonsters.size())
            .filter(index -> this.playerMonsters.get(index) != -1)
            .forEach(filterIndex -> this.playerMonstersPoint.set(filterIndex, this.playerMonstersPoint.get(filterIndex) * 2));


        }else{
            this.playerBonusPoint = d1;
        }
        int d2 = this.rnd.nextInt(6)+1; //1~6のサイコロを振る
        System.out.println("CPU's Dice'：" + d2);
        if(d2 == 1){
            System.out.println("失敗！すべてのモンスターポイントが半分になる");
            // for(int i = 0; i < this.cpuMonsters.length; i++){
            //     if(this.cpuMonsters[i] != -1){
            //         this.cpuMonstersPoint[i] = this.cpuMonstersPoint[i] / 2;
            //     }
            // }
            // IntStream.range(0, this.cpuMonsters.length)
            // .filter(index -> this.cpuMonsters[index] != -1)
            // .forEach(filterIndex -> this.cpuMonstersPoint[filterIndex] = this.cpuMonstersPoint[filterIndex] / 2);
            IntStream.range(0, this.cpuMonsters.size())
            .filter(index -> this.cpuMonsters.get(index) != -1)
            .forEach(filterIndex -> this.cpuMonstersPoint.set(filterIndex, this.cpuMonstersPoint.get(filterIndex) / 2));

        }else if(d2 == 6){
            System.out.println("Critical！すべてのモンスターポイントが倍になる");
            // for(int i = 0; i < this.cpuMonsters.length; i++){
            //     if(this.cpuMonsters[i] != -1){
            //         this.cpuMonstersPoint[i] = this.cpuMonstersPoint[i] * 2;
            //     }
            // }
            // IntStream.range(0, this.cpuMonsters.length)
            // .filter(index -> this.cpuMonsters[index] != -1)
            // .forEach(filterIndex -> this.cpuMonstersPoint[filterIndex] = this.cpuMonstersPoint[filterIndex] * 2);

            IntStream.range(0, this.cpuMonsters.size())
            .filter(index -> this.cpuMonsters.get(index) != -1)
            .forEach(filterIndex -> this.cpuMonstersPoint.set(filterIndex, this.cpuMonstersPoint.get(filterIndex) * 2));
        }else{
            this.cpuBonusPoint = d2;
        }

        System.out.println("--------------------");
        System.out.print("Player Monster Pointの合計:");
        int p3 = this.playerBonusPoint;
        // for(int i = 0; i < this.playerMonsters.length; i++){
        //     if(this.playerMonsters[i] != -1){
        //         p3 = p3 + this.playerMonstersPoint[i];
        //     }
        // }
        
        // p3 = p3 + IntStream.range(0, this.playerMonsters.length)
        //                    .filter(index -> this.playerMonsters[index] != -1)
        //                    .map(filterIndex -> this.playerMonstersPoint[filterIndex])
        //                    .sum();
        p3 = p3 + IntStream.range(0, this.playerMonsters.size())
                           .filter(index -> this.playerMonsters.get(index) != -1)
                           .map(filterIndex -> this.playerMonstersPoint.get(filterIndex))
                           .sum();

        System.out.println(p3);

        System.out.print("CPU Monster Pointの合計:");
        int p4 = this.cpuBonusPoint;
        // for(int i = 0; i < this.cpuMonsters.length; i++){
        //     if(this.cpuMonsters[i] != -1){
        //         p4 = p4 + this.cpuMonstersPoint[i];
        //     }
        // }
        // p4 = p4 + IntStream.range(0, this.cpuMonsters.length)
        //                    .filter(index -> this.cpuMonsters[index] != -1)
        //                    .map(filterIndex -> this.cpuMonstersPoint[filterIndex])
        //                    .sum();
        p4 = p4 + IntStream.range(0, this.cpuMonsters.size())
                           .filter(index -> this.cpuMonsters.get(index) != -1)
                           .map(filterIndex -> this.cpuMonstersPoint.get(filterIndex))
                           .sum();

        System.out.println(p4);
        System.out.println("--------------------");

        if(p3 > p4){
            System.out.println("Player Win!");
            this.cpuHp = this.cpuHp - (p3 - p4);
        }else if(p4 > p3){
            System.out.println("CPU Win!");
            this.playerHp = this.playerHp - (p4 - p3);
        }else if(p3 == p4){
            System.out.println("Draw!");
        }

        System.out.println("Player HP is " + this.playerHp);
        System.out.println("CPU HP is " + this.cpuHp);
        
        System.out.println("--------------------");
        // 対戦結果の記録
        // for(int i = 0;i < this.playerHistory.length; i++){
        //     if(this.playerHistory[i] == -9999){
        //         this.playerHistory[i] = this.playerHp;
        //         break;
        //     }
        // }
        // IntStream.range(0, this.playerHistory.length)
        // .filter(index -> this.playerHistory[index] == -9999)
        // .findFirst()
        // .ifPresent(findIndex -> this.playerHistory[findIndex] = this.playerHp);
        IntStream.range(0, this.playerHistory.size())
        .filter(index -> this.playerHistory.get(index) == -9999)
        .findFirst()
        .ifPresent(findIndex -> this.playerHistory.add(findIndex, this.playerHp));

        // for(int i = 0;i < this.cpuHistory.length; i++){
        //     if(this.cpuHistory[i] == -9999){
        //         this.cpuHistory[i] = this.cpuHp;
        //         break;
        //     }
        // }

        // IntStream.range(0, this.cpuHistory.length)
        // .filter(index -> this.cpuHistory[index] == -9999)
        // .findFirst()
        // .ifPresent(findIndex -> this.cpuHistory[findIndex] = this.cpuHp);
        IntStream.range(0, this.cpuHistory.size())
        .filter(index -> this.cpuHistory.get(index) == -9999)
        .findFirst()
        .ifPresent(findIndex -> this.cpuHistory.add(findIndex, this.cpuHp));
    }
    // public int[] getPlayerHistory(){
    //     return this.playerHistory;
    // }
    // public int[] getCpuHistory(){
    //     return this.cpuHistory;
    // }

    public List<Integer> getPlayerHistory(){
        return this.playerHistory;
    }
    public List<Integer> getCpuHistory(){
        return this.cpuHistory;
    }

    public int getPlayerHp(){
        return this.playerHp; 
    }

    public int getCpuHp(){
        return this.cpuHp;
    }

    // public void setMonstersPoint(int[] tempMonstersPoint) {
    //     this.monstersPoint = tempMonstersPoint;
    // }
    
    public void setMonstersPoint(List<Integer> tempMonstersPoint) {
        this.monstersPoint = tempMonstersPoint;
    }

    // public void setMonsterZukan(String[] tempMonsters) {
    //     this.monsters = tempMonsters;
    // }
    
    public void setMonsterZukan(List<String> tempMonsters) {
        this.monsters = tempMonsters;
    }

}