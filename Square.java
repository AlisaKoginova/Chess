
public class Square {
    int x; // объявляем координаты центра квадрата доски
    int y;
    Piece piece; // объявляем фигуру класса Piece

    public Square(int x, int y) { // инициализация переменных класса Square
        this.x = x;
        this.y = y;
        piece = null;
    }

    public void occupySquare(Piece piece) { // функция, которая помещает фигуру, совершающую ход, на опр. квадрат доки 
        // Если на данном квадрате уже есть фигура - изменим ее статус на dead
        if(this.piece != null)
            this.piece.setAccessible(false);
        // ставим фигуру, которой ходим на данный квадрат доски  
        this.piece = piece;
    }

    public boolean isOccupied() { // функция, проверяющая занят ли определенный квадрат доски
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
