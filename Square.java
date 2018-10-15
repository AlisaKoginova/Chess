
public class Square {
    int x; // ��������� ���������� ������ �������� �����
    int y;
    Piece piece; // ��������� ������ ������ Piece

    public Square(int x, int y) { // ������������� ���������� ������ Square
        this.x = x;
        this.y = y;
        piece = null;
    }

    public void occupySquare(Piece piece) { // �������, ������� �������� ������, ����������� ���, �� ���. ������� ���� 
        // ���� �� ������ �������� ��� ���� ������ - ������� �� ������ �� dead
        if(this.piece != null)
            this.piece.setAccessible(false);
        // ������ ������, ������� ����� �� ������ ������� ����� 
        this.piece = piece;
    }

    public boolean isOccupied() { // �������, ����������� ����� �� ������������ ������� ����� 
        if(piece != null)
            return true;
        return false;
    }

    public Piece releaseSquare() { // ������������ �������� ����� �� ������
        Piece releasedPiece = this.piece;
        this.piece = null;
        return releasedPiece;
    }

}