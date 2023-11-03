import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Block{

    private BlockState blockState=BlockState.Empty;
    private int x;
    private int y;
    public Block() {
    }

    public Block(BlockState blockState, int x, int y) {
        this.blockState = blockState;
        this.x = x;
        this.y =y ;
    }



    public BlockState getBlockState() {
        return blockState;
    }

    public void setBlockState(BlockState blockState) {
        this.blockState = blockState;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeStateOfBlock(){
        var state=this.getBlockState();
        if(state==BlockState.White){
            this.setBlockState(BlockState.Empty);
        } else if (state==BlockState.Empty) {
            this.setBlockState(BlockState.White);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return x == block.x && y == block.y && blockState == block.blockState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockState, x, y);
    }

    @Override
    public String toString() {
        return "Block{" +
                "blockState=" + blockState +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
