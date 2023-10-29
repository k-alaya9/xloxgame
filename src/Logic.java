import java.util.Scanner;



public class Logic {

    public void UserPlay(State state){

        Scanner input=new Scanner(System.in);
        do {
            System.out.print("Enter the X and the Y to move your block:");
            int x=input.nextInt();
            int y=input.nextInt();
            state.move(x,y);
        }while(!state.isFinal());
    }
}
