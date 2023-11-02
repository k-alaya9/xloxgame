import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeveL {
    private int blocks[][];

    public LeveL(int numberOflevel) {
        switch (numberOflevel){
            case 0:
                blocks=new int[4][4];
                for (int i=0;i<4;i++){
                    blocks[i][0]= 1;
                    blocks[0][i]= 1;
                    blocks[i][3]= 1;
                    blocks[3][i] = 1;
                }
                blocks[1][1]= 2;
                blocks[2][2]= 2;
                blocks[1][2]= 0;
                blocks[2][1]= 0;
                break;
            case 1:
              blocks=new int[5][5];
                for (int i = 0; i < blocks.length; i++) {
                    blocks[i][0]=1;
                    blocks[0][i]= 1;
                    blocks[i][4]= 1;
                    blocks[4][i]= 1;
                }
                for (int i = 1; i < 4; i++) {
                    blocks[1][i]=0 ;
                    blocks[2][i]=0;
                    blocks[i][2]=0;
                    blocks[3][i]= 0;
                    blocks[i][3]= 0;
                }
                blocks[2][2]=2;
                break;
            case 4:
                blocks= new int[5][5];
                for (int i = 0; i < blocks.length; i++) {
                    blocks[i][0]=1;
                    blocks[i][4]= 1;
                    blocks[0][i]= 1;
                    blocks[4][i]=1;
                }
                for (int i = 1; i <= 3; i++) {
                    blocks[1][i]=0;
                    blocks[2][i]=0;
                    blocks[3][i]=0;
                }
                blocks[2][2]= 1;
                blocks[3][1]= 2;
                blocks[3][3]= 2;
                blocks[3][2]= 1;
                break;
//            case 7:
//                blocks= new Block[5][7];
//                try (BufferedReader reader = new BufferedReader(new FileReader("src/levl7.txt"))) {
//                    String line;
//                    int y = 0;
//
//                    while ((line = reader.readLine()) != null) {
//                        for (int x = 0; x < line.length(); x++) {
//                            char character = line.charAt(x);
//
//                            if (character == 'w') {
//                             blocks[y][x]=  1;
//                            } else if (character == 'b') {
//                                blocks[y][x]= 1;
//                            } else if (character == 'e') {
//                                blocks[y][x]=1;
//                            }
//                        }
//
//                        y++;
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
        }
    }

    public int[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(int[][] blocks) {
        this.blocks = blocks;
    }
}
