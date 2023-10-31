import javax.swing.*;
import java.awt.*;

public class Block extends JPanel {

    private BlockState blockState=BlockState.Empty;
    private int x;
    private int y;
    private boolean highlighted;
    public Block() {
    }

    public Block(BlockState blockState, int x, int y) {
        this.blockState = blockState;
        this.x = x;
        this.y = y;
        setPreferredSize(new Dimension(100, 100)); // Set the preferred size of each block
        if(blockState==BlockState.White){
            setBackground(Color.white); // Set the background color of each block
        }
        else if(blockState==BlockState.Black)
        {
            setBackground(Color.black);
        }
        else{
            setBackground(Color.darkGray);
        }
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add a border for visual separation
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
        repaint(); // Repaint the block to update its appearance
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (highlighted) {
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
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
        else{
            return;
        }
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
