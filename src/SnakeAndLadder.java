import java.util.Scanner;

class SnakeAndLadder{

    int dice;
    int xOfPlayer = 0;
    int yOfPlayer = 7;
    String[][] str = new String[8][8];

    public void boardDisplay(){
        

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                str[i][j] = "[]";
            }
        }

        str[0][1] = "[Sn]";
        str[5][2] = "[L]";
        str[3][5] = "[Sn]";
        str[4][7] = "[L]";
        str[0][4] = "[L]";
        str[2][3] = "[L]";
        str[7][2] = "[Sn]";
        str[5][6] = "[Sn]";

        str[yOfPlayer][xOfPlayer] = "[P]";

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                System.out.print(str[i][j]);
            }
            System.out.println();
        }
        if(str[0][0] == "[P]"){
            System.out.println("You Won");
            return;
        }    
        dice();
    }

    public void dice(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Roll the dice?(y/n)");
        char choice = sc.next().charAt(0);
        if(choice == 'y'){
        dice = (int) (Math.random()*6)+1;
        System.out.println("You rolled a: "+dice);
        playerCalc();
        
        }
        else
            System.out.println("Thanks for playing");

    }

    public void playerCalc(){
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                if(str[i][j] == "[P]"){
                    yOfPlayer = i;
                    xOfPlayer = j;
                    str[i][j] = "[]";
                    
                    break;
                }

            }
            
        }
        
        if(dice+xOfPlayer<=7 && yOfPlayer%2 == 1){
            xOfPlayer+=dice;
        }
        else if(dice+xOfPlayer > 7 && yOfPlayer %2 == 1){
            int temp = 7 - xOfPlayer;
            xOfPlayer += temp ;
            yOfPlayer--;
            xOfPlayer -= dice-temp-1;
        }

        else if(dice + xOfPlayer <= 13 && yOfPlayer%2 == 0 && xOfPlayer-dice>=0){
            xOfPlayer -= dice;
        }
        else if(xOfPlayer-dice < 0 && yOfPlayer%2 == 0){
            int temp = 0 - xOfPlayer;
            xOfPlayer += temp ;
            yOfPlayer--;
            xOfPlayer += (dice+temp)-1;
        }
        
        

        if(str[yOfPlayer][xOfPlayer] == "[Sn]" && yOfPlayer == 0 && xOfPlayer == 1){
            yOfPlayer = 7;
            xOfPlayer = 2;
            System.out.println("You encountered a snake");
        }
        else if(str[yOfPlayer][xOfPlayer] == "[Sn]" && yOfPlayer == 3 && xOfPlayer == 5){
            yOfPlayer = 5;
            xOfPlayer = 6;
            System.out.println("You encountered a snake");
        }
        else if(str[yOfPlayer][xOfPlayer] == "[L]" && yOfPlayer == 5 && xOfPlayer == 2){
            yOfPlayer = 2;
            xOfPlayer = 3;
            System.out.println("You encountered a ladder");
        }
        else if(str[yOfPlayer][xOfPlayer] == "[L]" && yOfPlayer == 4 && xOfPlayer == 7){
            yOfPlayer = 0;
            xOfPlayer = 4;

        }


        boardDisplay();

        
    }

    public static void main(String[] args) {
        SnakeAndLadder s = new SnakeAndLadder();
        s.boardDisplay();
        
        
    }
}