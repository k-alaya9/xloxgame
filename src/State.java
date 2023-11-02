import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {
    private int[][] arrayOfBlocks;
    private int numberOfWhiteBlocks = 0;

    public State() {
    }

    public State(int[][] arrayOfBlocks) {
        this.arrayOfBlocks = arrayOfBlocks;
//        countNumberOfWhiteBlocks();
    }

    public int[][] getArrayOfBlocks() {
        return arrayOfBlocks;
    }

    public void setArrayOfBlocks(int[][] arrayOfBlocks) {
        this.arrayOfBlocks = arrayOfBlocks;
    }

    public void printState() {
        for (int i = 0; i < arrayOfBlocks.length; i++) {
            for (int j = 0; j < arrayOfBlocks.length; j++) {
                int currentBlock = arrayOfBlocks[i][j];
                if (currentBlock==1) {
                    System.out.print("[B]");
                } else if (currentBlock== 2) {
                    System.out.print("[W]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public void move(int x, int y) {
            changeStateOfBlock(x,y);
            changeStateOfBlock(x+1,y);
            changeStateOfBlock(x-1,y);
            changeStateOfBlock(x,y+1);
            changeStateOfBlock(x,y-1);
            printState();
//            countNumberOfWhiteBlocks();
    }

    public static boolean isFinal(int[][]arrayOfBlocks) {
        int count = 0;
        for (int i = 0; i < arrayOfBlocks.length; i++) {
            for (int j = 0; j < arrayOfBlocks[0].length; j++) {
                if (arrayOfBlocks[i][j] != 2) {
                    count++;
                }
            }
        }

        return count == arrayOfBlocks.length*arrayOfBlocks[0].length;
    }

//    public int countNumberOfWhiteBlocks() {
//        this.numberOfWhiteBlocks=0;
//        for (int i = 0; i < arrayOfBlocks.length; i++) {
//            for (int j = 0; j < arrayOfBlocks.length; j++) {
//                if (arrayOfBlocks[i][j].getBlockState() == BlockState.White) {
//                    this.numberOfWhiteBlocks++;
//                }
//            }
//        }
//        System.out.println("Number of white blocks: " + this.numberOfWhiteBlocks);
//        return this.numberOfWhiteBlocks;
//    }

    public void getNextState(Graph graph) {
        graph.addNode(this);
        List<Point> moves =checkAllMoves();
        for (Point move : moves) {
            int[][] blocks =  deepCopy(arrayOfBlocks);
            State nextState = new State(blocks);
            nextState.move(move.x, move.y);
                graph.addNode(nextState);
                graph.addEdges(this,nextState);
        }

    }
    <T> int[][] deepCopy(int[][] array) {
        return Arrays.stream(array).map(e -> e.clone()).toArray($ -> array.clone());
    }

    public List<Point> checkAllMoves() {
        List<Point> moves = new ArrayList<>();
        for (int i = 0; i < arrayOfBlocks.length; i++) {
            for (int j = 0; j < arrayOfBlocks.length; j++) {
                if (arrayOfBlocks[i][j] == 2) {
                    moves.add(new Point(i,j));
                }
            }
        }
        return moves;
    }
    public void changeStateOfBlock(int x, int y){
        if(arrayOfBlocks[x][y]!=1){
            arrayOfBlocks[x][y]=(arrayOfBlocks[x][y]==2)?0:2;
        }
    }

}