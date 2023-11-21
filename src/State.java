import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class State {
    private Block[][] arrayOfBlocks;

    private int coast=0;

    public State() {
    }

    public State(Block[][] arrayOfBlocks) {
        this.arrayOfBlocks = arrayOfBlocks;
    }

    public State(Block[][] arrayOfBlocks, int coast) {
        this.arrayOfBlocks = arrayOfBlocks;
        this.coast = coast;
    }

    public Block[][] getArrayOfBlocks() {
        return arrayOfBlocks;
    }

    public void setArrayOfBlocks(Block[][] arrayOfBlocks) {
        this.arrayOfBlocks = arrayOfBlocks;
    }

    public void printState() {
        for (Block[] arrayOfBlock : arrayOfBlocks) {
            for (int j = 0; j < arrayOfBlock.length; j++) {
                BlockState currentBlock = arrayOfBlock[j].getBlockState();
                if (currentBlock == BlockState.Black) {
                    System.out.print("[B]");
                } else if (currentBlock == BlockState.White) {
                    System.out.print("[W]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
        System.out.println("======================");
    }

    public void move(int x, int y) {
        Block currentBlock=arrayOfBlocks[x][y];
        if(currentBlock.getBlockState()!=BlockState.White){
            return;
        }
        currentBlock.changeStateOfBlock();
        arrayOfBlocks[x+1][y].changeStateOfBlock();
        arrayOfBlocks[x-1][y].changeStateOfBlock();
        arrayOfBlocks[x][y+1].changeStateOfBlock();
        arrayOfBlocks[x][y-1].changeStateOfBlock();

//        printState();
    }

    public  boolean isFinal() {
        int count=0;
        for (Block[] arrayOfBlock : arrayOfBlocks) {
            for (Block block : arrayOfBlock) {
                if (block.getBlockState() == BlockState.White) {
                    count++;
                }
            }
        }
        return count==0;
    }
    public void getNextState(Graph graph) {
        List<Block> moves =checkAllMoves();
        for (Block move : moves) {
            Block[][] blocks =  deepCopy(arrayOfBlocks);
            State nextState = new State(blocks,coast+1);
            nextState.move(move.getX(), move.getY());
                graph.addNode(nextState);
                graph.addEdges(this,nextState);
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        State other = (State) obj;
        return  Arrays.deepEquals(arrayOfBlocks, other.arrayOfBlocks);
    }


    @Override
    public int hashCode() {
        return  Arrays.deepHashCode(arrayOfBlocks);
    }

    Block[][] deepCopy(Block[][] array) {
        Block[][]copy=new Block[array.length][array[0].length];
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            copy[i][j]=new Block(array[i][j].getBlockState(),array[i][j].getX(),array[i][j].getY());
        }
    }
    return copy;
    }

    public List<Block> checkAllMoves() {
        List<Block> moves = new ArrayList<>();
        for (Block[] arrayOfBlock : arrayOfBlocks) {
            for (int j = 0; j < arrayOfBlock.length; j++) {
                if (arrayOfBlock[j].getBlockState() == BlockState.White) {
                    moves.add(arrayOfBlock[j]);
                }
            }
        }
        return moves;
    }
    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    private int calculateTotalDistance(State state) {
        int totalDistance = 0;
        Block[][] arrayOfBlocks = state.getArrayOfBlocks();
        List<Point> twos = new ArrayList<>();

        for (int i = 0; i < arrayOfBlocks.length; i++) {
            for (int j = 0; j < arrayOfBlocks[i].length; j++) {
                if (arrayOfBlocks[i][j].getBlockState() == BlockState.White) {
                    twos.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < twos.size(); i++) {
            for (int j = i + 1; j < twos.size(); j++) {
                Point firstTwo = twos.get(i);
                Point secondTwo = twos.get(j);
                int distance = Math.abs(firstTwo.x - secondTwo.x) + Math.abs(firstTwo.y - secondTwo.y);
                totalDistance += distance;
            }
        }

        return totalDistance;
    }
    public int calculateHeuristic() {
        int NumberOfWhite = this.checkAllMoves().size();
        int totalDistance = calculateTotalDistance(this);
        int heuristicValue = NumberOfWhite + totalDistance;

        return heuristicValue;
    }
    public int totalCost(){
        return coast+calculateHeuristic();
    }
}