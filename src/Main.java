import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Block[][] blocks=new Block[4][4];
        for (int i=0;i<4;i++){
            blocks[i][0]= new Block(BlockState.Black,i,0);
            blocks[0][i]= new Block(BlockState.Black,0,i);
            blocks[i][3]= new Block(BlockState.Black,i,3);
            blocks[3][i] = new Block(BlockState.Black,3,i);
        }
        blocks[1][1]= new Block(BlockState.White,1,1);
        blocks[2][2]= new Block(BlockState.White,2,2);
        blocks[1][2]= new Block(BlockState.Empty,1,2);
        blocks[2][1]= new Block(BlockState.Empty,2,1);
        Block[][] level1=new Block[5][5];
        for (int i = 0; i < level1.length; i++) {
            level1[i][0]=new Block(BlockState.Black,i,0);
            level1[0][i]= new Block(BlockState.Black,0,i);
            level1[i][4]= new Block(BlockState.Black,i,4);
            level1[4][i]= new Block(BlockState.Black,4,i);
        }
        level1[2][2]= new Block(BlockState.White,2,2);
        for (int i = 1; i < 4; i++) {
            level1[1][i]= new Block(BlockState.Empty,1,i);
            level1[i][1]=new Block(BlockState.Empty,i,1);
            level1[2][i]=new Block(BlockState.Empty,2,i);
            level1[i][2]=new Block(BlockState.Empty,i,2);
            level1[3][i]= new Block(BlockState.Empty,3,i);
            level1[i][3]= new Block(BlockState.Empty,i,3);
        }
        level1[2][2]=new Block(BlockState.White,2,2);
       State s1= new State(level1);
//        SwingUtilities.invokeLater(()->{
//            StateGUI gui= new StateGUI(s1);
//        });
       s1.printState();
//       System.out.println(s1.checkAllMoves());
//        state s2=s1.getNextState();
//        s2.printState();
       Logic l= new Logic();
//       l.UserPlay(s1);
//       l.BFS(s1);
       l.DFS(s1);
    }
}