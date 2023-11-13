import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int lvl;
//        Scanner in= new Scanner(System.in);
//        System.out.println("Enter the level number (1,4,6,7) if you enter any other number it will give a simple level :");
//        lvl=in.nextInt();
        LeveL leveL= new LeveL(6);
       State s1= new State(leveL.getBlocks());
       s1.printState();
       Logic l= new Logic();
//       l.UserPlay(s1);
//       l.BFS(s1);
//       l.DFS(s1);
//       l.UCS(s1);
        l.hillClimbing(s1);
    }
}