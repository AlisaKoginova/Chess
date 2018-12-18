import java.util.*;
import javax.swing.*;
public class Game {
	
    public static String chessBoard[][]={
        {"r","k","b","q","a","b","k","r"},
        {"p","p","p","p","p","p","p","p"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"P","P","P","P","P","P","P","P"},
        {"R","K","B","Q","A","B","K","R"}};
    public static int kingPositionC, kingPositionL;
    public static int humanAsWhite=-1;//1=human as white, 0=human as black
    public static int globalDepth=4;
    
    
    public static void main(String[] args) {
        while (!"A".equals(chessBoard[kingPositionC/8][kingPositionC%8])) {kingPositionC++;}//get King's location
        while (!"a".equals(chessBoard[kingPositionL/8][kingPositionL%8])) {kingPositionL++;}//get king's location
        
        JFrame f=new JFrame("Chess Alisa");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserInterface ui=new UserInterface();
        f.add(ui);
        f.setSize(463, 483);
        f.setVisible(true);
        System.out.println(Sort.sortMoves(Move.posibleMoves()));
        Object[] option={"Computer","Human"};
        humanAsWhite=JOptionPane.showOptionDialog(null, "Who should play as white?", "ABC Options", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
        if (humanAsWhite==0) {
            long startTime=System.currentTimeMillis();
            Move.makeMove(alphaBeta(globalDepth, 1000000, -1000000, "", 0));
            long endTime=System.currentTimeMillis();
            System.out.println("That took "+(endTime-startTime)+" milliseconds");
            flipBoard();
            f.repaint();
        }
        Move.makeMove("7655 ");
        Move.undoMove("7655 ");
        for (int i=0;i<8;i++) {
            System.out.println(Arrays.toString(chessBoard[i]));
        }
    }
	
    
    public static String alphaBeta(int depth, int beta, int alpha, String move, int player) {
        
        String list=Move.posibleMoves();
        if (depth==0 || list.length()==0) {return move+(Rating.rating(list.length(), depth)*(player*2-1));}
        list=Sort.sortMoves(list);
        player=1-player;//either 1 or 0
        for (int i=0;i<list.length();i+=5) {
            Move.makeMove(list.substring(i,i+5));
            flipBoard();
            String returnString=alphaBeta(depth-1, beta, alpha, list.substring(i,i+5), player);
            int value=Integer.valueOf(returnString.substring(5));
            flipBoard();
            Move.undoMove(list.substring(i,i+5));
            if (player==0) {
                if (value<=beta) {beta=value; if (depth==globalDepth) {move=returnString.substring(0,5);}}
            } else {
                if (value>alpha) {alpha=value; if (depth==globalDepth) {move=returnString.substring(0,5);}}
            }
            if (alpha>=beta) {
                if (player==0) {return move+beta;} else {return move+alpha;}
            }
        }
        if (player==0) {return move+beta;} else {return move+alpha;}
    }
    
    
    public static void flipBoard() {
        String temp;
        for (int i=0;i<32;i++) {
            int r=i/8, c=i%8;
            if (Character.isUpperCase(chessBoard[r][c].charAt(0))) {
                temp=chessBoard[r][c].toLowerCase();
            } else {
                temp=chessBoard[r][c].toUpperCase();
            }
            if (Character.isUpperCase(chessBoard[7-r][7-c].charAt(0))) {
                chessBoard[r][c]=chessBoard[7-r][7-c].toLowerCase();
            } else {
                chessBoard[r][c]=chessBoard[7-r][7-c].toUpperCase();
            }
            chessBoard[7-r][7-c]=temp;
        }
        int kingTemp=kingPositionC;
        kingPositionC=63-kingPositionL;
        kingPositionL=63-kingTemp;
    }
    
    
    public static boolean kingSafe() {
        //офицер/королева
        int temp=1;
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    while(" ".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j])) {temp++;}
                    if ("b".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j]) ||
                            "q".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j])) {
                        return false;
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }
        //ладья/королева
        for (int i=-1; i<=1; i+=2) {
            try {
                while(" ".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i])) {temp++;}
                if ("r".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i]) ||
                        "q".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(" ".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8])) {temp++;}
                if ("r".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8]) ||
                        "q".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
        }
        // для коня
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    if ("k".equals(chessBoard[kingPositionC/8+i][kingPositionC%8+j*2])) {
                        return false;
                    }
                } catch (Exception e) {}
                try {
                    if ("k".equals(chessBoard[kingPositionC/8+i*2][kingPositionC%8+j])) {
                        return false;
                    }
                } catch (Exception e) {}
            }
        }
        // для пешки
        if (kingPositionC>=16) {
            try {
                if ("p".equals(chessBoard[kingPositionC/8-1][kingPositionC%8-1])) {
                    return false;
                }
            } catch (Exception e) {}
            try {
                if ("p".equals(chessBoard[kingPositionC/8-1][kingPositionC%8+1])) {
                    return false;
                }
            } catch (Exception e) {}
            // для короля
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    if (i!=0 || j!=0) {
                        try {
                            if ("a".equals(chessBoard[kingPositionC/8+i][kingPositionC%8+j])) {
                                return false;
                            }
                        } catch (Exception e) {}
                    }
                }
            }
        }
        return true;
    }
}
