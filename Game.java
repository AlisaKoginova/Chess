
public class Game {
    private Player white; // объявляем двух игроков 
    private Player black;
    private Board board = new Board(); // объявляем доску
     
    // инициализируем объекты класса Game 
    public void setBoard(Board board) { 
        this.board = board;
    }
    public void setColorWhite(Player player) {
        this.white = player;
    }
    
    public void setColorBlack(Player player) {
        this.black = player;
    }
    
    // в следующих функциях "связываем" цвет с игроками 
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
    
    // функция для инициализации игроков с разных сторон доски и добавления фигур на доску - начало игры
    public boolean initBoardPlayers() {
        if(this.black == null || this.white == null) // если игрок или игроки не инициализированы, возвращаем false
            return false;
        this.board = new Board(); // инициализируем доску 
        for(int i=0; i<black.getPieces().size(); i++){ // присваиваем игрокам фигуры 
            board.getSquare(black.getPieces().get(i).getX(), black.getPieces().get(i).getY()).occupySquare(black.getPieces().get(i));
        }
        return true;
    }
}
