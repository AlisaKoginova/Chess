
public class Piece {
	private boolean accessible; // перемнная, определяющая доступна ли фигура
	private int x; // переменные для определения координат фигуры
	private int y;

	public Piece(boolean accessible, int x, int y) { // инициализация переменных класса Piece
	     this.accessible = accessible;
	     this.x = x;
	     this.y = y;
	}

	    public boolean isAccessible() { // проверка доступности фигуры
	        return accessible;
	    }
	    public void setAccessible(boolean accessible) { // установление статуса доступности фигуры
	        this.accessible = accessible;
	    }
	    
	    // функции, возвращающие текущие координаты фигуры
	    public int getX() { 
	        return x;
	    }
	    public int getY() {
	        return y;
	    }
	    
	    // функции для установки текущих координат фигуры
	    public void setX(int x) {
	        this.x = x;
	    }
	    public void setY(int y) {
	        this.y = y;
	    }
	    
	    // функция, для проверки возможности определенного хода 
	    // fromX, fromY - начальные координаты фигуры
	    // toX, toY - конечные координаты фигуры
	    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){
	        if(toX == fromX && toY == fromY) // если ходим переместится с одного места в это же место
	            return false; // ход не возможен, возвращаем false
	        
	        // если ход совершается за границы поля 
	        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7) 
	            return false; // ход не возможен, возвращаем false
	        
	        return true; // в остальных случаях ход возможен 
	    }

}
