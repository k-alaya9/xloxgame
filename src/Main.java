import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LeveL leveL= new LeveL(7);
       State s1= new State(leveL.getBlocks());
       Logic l= new Logic();
       l.UserPlay(s1);
       l.BFS(s1);
       l.DFS(s1);
    }
}