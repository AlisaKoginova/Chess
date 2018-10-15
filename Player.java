import java.util.ArrayList;
import java.util.List;

public class Player {
    public boolean white; // переменная, определяющая цвет игрока: 1 - белый, 0 - черный

    private List<Piece> pieces = new ArrayList<>(); // создаем коллекцию фигур

    public Player(boolean white) { // устанавливаем цвет игрока
        this.white = white;
    }

    public List<Piece> getPieces() { // функция для возврата фигур коллекции 
        return pieces;
    }
    
    // функция инициализации фигур
    public void initPieces(){ 
        if(this.white == true) // если игрок белого цвета
        {
            for(int i=0; i<8; i++) // добавляем ряд пешек
                pieces.add(new Pawn(true,i,2)); 
            
            // добавляем по очереди остальные фигуры
            pieces.add(new Rook(true, 0, 0));
            pieces.add(new Rook(true, 7, 0));
            pieces.add(new Bishop(true, 2, 0));
            pieces.add(new Bishop(true, 5, 0));
            pieces.add(new Knight(true, 1, 0));
            pieces.add(new Knight(true, 6, 0));
            pieces.add(new Queen(true, 3, 0));
            pieces.add(new King(true, 4, 0));
        }
        else // если игрок белого цвета (ставим фигуры в противоположной стороне доски) 
        {
            for(int i=0; i<8; i++) // добавляем ряд пешек
                pieces.add(new Pawn(true,i,6));
            
            // добавляем по очереди остальные фигуры
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
