import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeveL {
    private Block blocks[][];

    public LeveL(int numberOflevel) {
        switch (numberOflevel){
            case 1:
              blocks=new Block[5][5];
                for (int i = 0 ; i < blocks.length; i++) {
                    blocks[i][0]=new Block(BlockState.Black,i,0);
                    blocks[0][i]= new Block(BlockState.Black,0,i);
                    blocks[i][4]= new Block(BlockState.Black,i,4);
                    blocks[4][i]= new Block(BlockState.Black,4,i);
                }
                for (int i = 1 ; i < 4; i++) {
                    blocks[1][i]=new Block(BlockState.Empty,1,i) ;
                    blocks[2][i]=new Block(BlockState.Empty,2,i);
                    blocks[i][2]=new Block(BlockState.Empty,i,2);
                    blocks[3][i]= new Block(BlockState.Empty,3,i);
                    blocks[i][3]= new Block(BlockState.Empty,i,3);
                }
                blocks[2][2]=new Block(BlockState.White,2,2);
                break;
            case 4:
                blocks= new Block[5][5];
                for (int i = 0 ; i < blocks.length; i++) {
                    blocks[i][0]=new Block(BlockState.Black,i,0);
                    blocks[i][4]= new Block(BlockState.Black,i,4);
                    blocks[0][i]= new Block(BlockState.Black,0,i);
                    blocks[4][i]=new Block(BlockState.Black,4,i);
                }
                for (int i = 1; i <= 3; i++) {
                    blocks[1][i]=new Block(BlockState.Empty,1,i);
                    blocks[2][i]=new Block(BlockState.Empty,2,i);
                    blocks[3][i]=new Block(BlockState.Empty,3,i);
                }
                blocks[2][2]= new Block(BlockState.Black,2,2);
                blocks[3][1]= new Block(BlockState.White,3,1);
                blocks[3][3]= new Block(BlockState.White,3,3);
                blocks[3][2]= new Block(BlockState.Black,3,2);
                break;
            case 6:
                blocks = new Block[5][7];
                // Row 1
                blocks[0][0] = new Block(BlockState.Black, 0, 0);
                blocks[0][1] = new Block(BlockState.Black, 0, 1);
                blocks[0][2] = new Block(BlockState.Black, 0, 2);
                blocks[0][3] = new Block(BlockState.Black, 0, 3);
                blocks[0][4] = new Block(BlockState.Black, 0, 4);
                blocks[0][5] = new Block(BlockState.Black, 0, 5);
                blocks[0][6] = new Block(BlockState.Black, 0, 6);

// Row 2
                blocks[1][0] = new Block(BlockState.Black, 1, 0);
                blocks[1][1] = new Block(BlockState.Empty, 1, 1);
                blocks[1][2] = new Block(BlockState.Empty, 1, 2);
                blocks[1][3] = new Block(BlockState.Empty, 1, 3);
                blocks[1][4] = new Block(BlockState.Empty, 1, 4);
                blocks[1][5] = new Block(BlockState.Empty, 1, 5);
                blocks[1][6] = new Block(BlockState.Black, 1, 6);

// Row 3
                blocks[2][0] = new Block(BlockState.Black, 2, 0);
                blocks[2][1] = new Block(BlockState.White, 2, 1);
                blocks[2][2] = new Block(BlockState.Black, 2, 2);
                blocks[2][3] = new Block(BlockState.White, 2, 3);
                blocks[2][4] = new Block(BlockState.Black, 2, 4);
                blocks[2][5] = new Block(BlockState.White, 2, 5);
                blocks[2][6] = new Block(BlockState.Black, 2, 6);

// Row 4
                blocks[3][0] = new Block(BlockState.Black, 3, 0);
                blocks[3][1] = new Block(BlockState.Empty, 3, 1);
                blocks[3][2] = new Block(BlockState.Empty, 3, 2);
                blocks[3][3] = new Block(BlockState.Empty, 3, 3);
                blocks[3][4] = new Block(BlockState.Empty, 3, 4);
                blocks[3][5] = new Block(BlockState.Empty, 3, 5);
                blocks[3][6] = new Block(BlockState.Black, 3, 6);

// Row 5
                blocks[4][0] = new Block(BlockState.Black, 4, 0);
                blocks[4][1] = new Block(BlockState.Black, 4, 1);
                blocks[4][2] = new Block(BlockState.Black, 4, 2);
                blocks[4][3] = new Block(BlockState.Black, 4, 3);
                blocks[4][4] = new Block(BlockState.Black, 4, 4);
                blocks[4][5] = new Block(BlockState.Black, 4, 5);
                blocks[4][6] = new Block(BlockState.Black, 4, 6);
                break;
            case 7:
                 blocks = new Block[7][5];
// Row 1
                blocks[0][0] = new Block(BlockState.Black, 0, 0);
                blocks[0][1] = new Block(BlockState.Black, 0, 1);
                blocks[0][2] = new Block(BlockState.Black, 0, 2);
                blocks[0][3] = new Block(BlockState.Black, 0, 3);
                blocks[0][4] = new Block(BlockState.Black, 0, 4);

// Row 2
                blocks[1][0] = new Block(BlockState.Black, 1, 0);
                blocks[1][1] = new Block(BlockState.Empty, 1, 1);
                blocks[1][2] = new Block(BlockState.Empty, 1, 2);
                blocks[1][3] = new Block(BlockState.Empty, 1, 3);
                blocks[1][4] = new Block(BlockState.Black, 1, 4);

// Row 3
                blocks[2][0] = new Block(BlockState.Black, 2, 0);
                blocks[2][1] = new Block(BlockState.Black, 2, 1);
                blocks[2][2] = new Block(BlockState.Black, 2, 2);
                blocks[2][3] = new Block(BlockState.White, 2, 3);
                blocks[2][4] = new Block(BlockState.Black, 2, 4);

// Row 4
                blocks[3][0] = new Block(BlockState.Black, 3, 0);
                blocks[3][1] = new Block(BlockState.Empty, 3, 1);
                blocks[3][2] = new Block(BlockState.Empty, 3, 2);
                blocks[3][3] = new Block(BlockState.Empty, 3, 3);
                blocks[3][4] = new Block(BlockState.Black, 3, 4);

// Row 5
                blocks[4][0] = new Block(BlockState.Black, 4, 0);
                blocks[4][1] = new Block(BlockState.White, 4, 1);
                blocks[4][2] = new Block(BlockState.Black, 4, 2);
                blocks[4][3] = new Block(BlockState.Black, 4, 3);
                blocks[4][4] = new Block(BlockState.Black, 4, 4);

// Row 6
                blocks[5][0] = new Block(BlockState.Black, 5, 0);
                blocks[5][1] = new Block(BlockState.Empty, 5, 1);
                blocks[5][2] = new Block(BlockState.Empty, 5, 2);
                blocks[5][3] = new Block(BlockState.Empty, 5, 3);
                blocks[5][4] = new Block(BlockState.Black, 5, 4);

// Row 7
                blocks[6][0] = new Block(BlockState.Black, 6, 0);
                blocks[6][1] = new Block(BlockState.Black, 6, 1);
                blocks[6][2] = new Block(BlockState.Black, 6, 2);
                blocks[6][3] = new Block(BlockState.Black, 6, 3);
                blocks[6][4] = new Block(BlockState.Black, 6, 4);
                break;

            default:
                blocks=new Block[4][4];
                for (int i=0 ;i<4;i++){
                    blocks[i][0]= new Block(BlockState.Black,i,0);
                    blocks[0][i]= new Block(BlockState.Black,0,i);
                    blocks[i][3]= new Block(BlockState.Black,i,3);
                    blocks[3][i] = new Block(BlockState.Black,3,i);
                }
                blocks[1][1]= new Block(BlockState.White,1,1);
                blocks[2][2]= new Block(BlockState.White,2,2);
                blocks[1][2]= new Block(BlockState.Empty,1,2);
                blocks[2][1]= new Block(BlockState.Empty,2,1);
                break;
        }
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }
}
