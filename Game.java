
public class Game {
	private Player white; // ��������� ���� ������� 
    private Player black;
    private Board board = new Board(); // ��������� �����
     
    // �������������� ������� ������ Game 
    public void setBoard(Board board) { 
        this.board = board;
    }
    public void setColorWhite(Player player) {
        this.white = player;
    }
    
    public void setColorBlack(Player player) {
        this.black = player;
    }
    
    // � ��������� �������� "���������" ���� � �������� 
    public Player getWhite() {
        return white;
    }
    public Player getBlack() {
        return black;
    }
    
    public void setWhite(Player white) {
        this.white = white;
    }

    public void setBlack(Player black) {
        this.black = black;
    }
    
    // ������� ��� ������������� ������� � ������ ������ ����� � ���������� ����� �� ����� - ������ ����
    public boolean initBoardPlayers() {
        if(this.black == null || this.white == null) // ���� ����� ��� ������ �� ����������������, ���������� false 
            return false;
        this.board = new Board(); // �������������� ����� 
        for(int i=0; i<black.getPieces().size(); i++){ // ����������� ������� ������ 
            board.getSquare(black.getPieces().get(i).getX(), black.getPieces().get(i).getY()).occupySquare(black.getPieces().get(i));
        }
        return true;
    }
}
