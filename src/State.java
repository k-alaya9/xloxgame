import java.util.ArrayList;
import java.util.List;

public class State {
    private Block[][] arrayOfBlocks;
    private int numberOfWhiteBlocks = 0;

    public State() {
    }

    public State(Block[][] arrayOfBlocks) {
        this.arrayOfBlocks = arrayOfBlocks;
        countNumberOfWhiteBlocks();
    }

    public Block[][] getArrayOfBlocks() {
        return arrayOfBlocks;
    }

    public void setArrayOfBlocks(Block[][] arrayOfBlocks) {
        this.arrayOfBlocks = arrayOfBlocks;
    }

    public void printState() {
        for (int i = 0; i < arrayOfBlocks.length; i++) {
            for (int j = 0; j < arrayOfBlocks.length; j++) {
                Block currentBlock = arrayOfBlocks[i][j];
                if (currentBlock.getBlockState() == BlockState.Black) {
                    System.out.print("[B]");
                } else if (currentBlock.getBlockState() == BlockState.White) {
                    System.out.print("[W]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public void move(int x, int y) {
        this.numberOfWhiteBlocks = 0;
        Block block = arrayOfBlocks[x][y];
        if (block.getBlockState() == BlockState.White) {
            block.changeStateOfBlock();
            arrayOfBlocks[x + 1][y].changeStateOfBlock();
            arrayOfBlocks[x - 1][y].changeStateOfBlock();
            arrayOfBlocks[x][y + 1].changeStateOfBlock();
            arrayOfBlocks[x][y - 1].changeStateOfBlock();
            printState();
            countNumberOfWhiteBlocks();
            isFinal();
        } else {
            printState();
            countNumberOfWhiteBlocks();
            isFinal();
            return;
        }
    }

    public boolean isFinal() {
        if (numberOfWhiteBlocks == 0) {
            System.out.println("Congrats, you win!");
            return true;
        } else {
            return false;
        }
    }

    public int countNumberOfWhiteBlocks() {
        this.numberOfWhiteBlocks = 0;
        for (int i = 0; i < arrayOfBlocks.length; i++) {
            for (int j = 0; j < arrayOfBlocks.length; j++) {
                if (arrayOfBlocks[i][j].getBlockState() == BlockState.White) {
                    this.numberOfWhiteBlocks++;
                }
            }
        }
        System.out.println("Number of white blocks: " + this.numberOfWhiteBlocks);
        return this.numberOfWhiteBlocks;
    }

    public State getNextState(Graph graph) {
        Block[][] blocks = deepCopyArrayOfBlocks(arrayOfBlocks);
        State nextState = new State(blocks);
        List<Block> moves = nextState.checkAllMoves();
        for (Block move : moves) {
            nextState.move(move.getX(), move.getY());
        }
        graph.addNode(nextState);
        graph.addEdges(this,nextState);
        return nextState;
    }

    private Block[][] deepCopyArrayOfBlocks(Block[][] array) {
        Block[][] copy = new Block[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                copy[i][j] = new Block(array[i][j].getBlockState(),array[i][j].getX(),array[i][j].getY());
            }
        }
        return copy;
    }

    public List<Block> checkAllMoves() {
        List<Block> moves = new ArrayList<>();
        for (int i = 0; i < arrayOfBlocks.length; i++) {
            for (int j = 0; j < arrayOfBlocks.length; j++) {
                if (arrayOfBlocks[i][j].getBlockState() == BlockState.White) {
                    moves.add(arrayOfBlocks[i][j]);
                }
            }
        }
        return moves;
    }
}