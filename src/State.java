import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {
    private Block[][] arrayOfBlocks;

    public State() {
    }

    public State(Block[][] arrayOfBlocks) {
        this.arrayOfBlocks = arrayOfBlocks;
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
            State nextState = new State(blocks);
            nextState.move(move.getX(), move.getY());
                graph.addNode(nextState);
                graph.addEdges(this,nextState);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Arrays.deepEquals(arrayOfBlocks, state.arrayOfBlocks);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(arrayOfBlocks);
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
}