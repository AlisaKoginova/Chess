
public class Square {
    int x; // объ€вл€ем координаты центра квадрата доски
    int y;
    Piece piece; // объ€вл€ем фигуру класса Piece

    public Square(int x, int y) { // инициализаци€ переменных класса Square
        this.x = x;
        this.y = y;
        piece = null;
    }

    public void occupySquare(Piece piece) { // функци€, котора€ помещает фигуру, совершающую ход, на опр. квадрат доки 
        // ≈сли на данном квадрате уже есть фигура - изменим ее статус на dead
        if(this.piece != null)
            this.piece.setAccessible(false);
        // ставим фигуру, которой ходим на данный квадрат доски 
        this.piece = piece;
    }

    public boolean isOccupied() { // функци€, провер€юща€ зан€т ли определенный квадрат доски 
        if(piece != null)
            return true;
        return false;
    }

    public Piece releaseSquare() { // освобождение квадрата доски от фигуры
        Piece releasedPiece = this.piece;
        this.piece = null;
        return releasedPiece;
    }

}