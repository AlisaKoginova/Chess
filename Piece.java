
public class Piece {
	private boolean accessible; // ���������, ������������ �������� �� ������
	private int x; // ���������� ��� ����������� ��������� ������
	private int y;

	public Piece(boolean accessible, int x, int y) { // ������������� ���������� ������ Piece
	     this.accessible = accessible;
	     this.x = x;
	     this.y = y;
	}

	    public boolean isAccessible() { // �������� ����������� ������
	        return accessible;
	    }
	    public void setAccessible(boolean accessible) { // ������������ ������� ����������� ������
	        this.accessible = accessible;
	    }
	    
	    // �������, ������������ ������� ���������� ������
	    public int getX() { 
	        return x;
	    }
	    public int getY() {
	        return y;
	    }
	    
	    // ������� ��� ��������� ������� ��������� ������
	    public void setX(int x) {
	        this.x = x;
	    }
	    public void setY(int y) {
	        this.y = y;
	    }
	    
	    // �������, ��� �������� ����������� ������������� ���� 
	    // fromX, fromY - ��������� ���������� ������
	    // toX, toY - �������� ���������� ������
	    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){
	        if(toX == fromX && toY == fromY) // ���� ����� ������������ � ������ ����� � ��� �� �����
	            return false; // ��� �� ��������, ���������� false
	        
	        // ���� ��� ����������� �� ������� ���� 
	        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7) 
	            return false; // ��� �� ��������, ���������� false
	        
	        return true; // � ��������� ������� ��� �������� 
	    }

}
