import java.util.ArrayList;
import java.util.List;

public class Player {
    public boolean white; // ����������, ������������ ���� ������: 1 - �����, 0 - ������

    private List<Piece> pieces = new ArrayList<>(); // ������� ��������� �����

    public Player(boolean white) { // ������������� ���� ������
        this.white = white;
    }

    public List<Piece> getPieces() { // ������� ��� �������� ����� ��������� 
        return pieces;
    }
    
    // ������� ������������� �����
    public void initPieces(){ 
        if(this.white == true) // ���� ����� ������ �����
        {
            for(int i=0; i<8; i++) // ��������� ��� �����
                pieces.add(new Pawn(true,i,2)); 
            
            // ��������� �� ������� ��������� ������
            pieces.add(new Rook(true, 0, 0));
            pieces.add(new Rook(true, 7, 0));
            pieces.add(new Bishop(true, 2, 0));
            pieces.add(new Bishop(true, 5, 0));
            pieces.add(new Knight(true, 1, 0));
            pieces.add(new Knight(true, 6, 0));
            pieces.add(new Queen(true, 3, 0));
            pieces.add(new King(true, 4, 0));
        }
        else // ���� ����� ������ ����� (������ ������ � ��������������� ������� �����) 
        {
            for(int i=0; i<8; i++) // ��������� ��� �����
                pieces.add(new Pawn(true,i,6));
            
            // ��������� �� ������� ��������� ������
            pieces.add(new Rook(true, 0, 7));
            pieces.add(new Knight(true, 1, 7));
            pieces.add(new Bishop(true, 2, 7));
            pieces.add(new Queen(true, 3, 7));
            pieces.add(new King(true, 4, 7));
            pieces.add(new Bishop(true, 5, 7));
            pieces.add(new Knight(true, 6, 7));
            pieces.add(new Rook(true, 7, 7));
        }

    }
}
