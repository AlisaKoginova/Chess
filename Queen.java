
public class Queen extends Game {
	
	public static String posible(int i) {
        String list="", oldPiece;
        int r=i/8, c=i%8;
        int temp=1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                if (j!=0 || k!=0) {
                    try {
                        while(" ".equals(chessBoard[r+temp*j][c+temp*k]))
                        {
                            oldPiece=chessBoard[r+temp*j][c+temp*k];
                            chessBoard[r][c]=" ";
                            chessBoard[r+temp*j][c+temp*k]="Q";
                            if (kingSafe()) {
                                list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            }
                            chessBoard[r][c]="Q";
                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
                            temp++;
                        }
                        if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                            oldPiece=chessBoard[r+temp*j][c+temp*k];
                            chessBoard[r][c]=" ";
                            chessBoard[r+temp*j][c+temp*k]="Q";
                            if (kingSafe()) {
                                list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            }
                            chessBoard[r][c]="Q";
                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        }
                    } catch (Exception e) {}
                    temp=1;
                }
            }
        }
        return list;
    }
}

