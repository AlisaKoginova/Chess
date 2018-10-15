
public class Board {
    private Square[][] squares = new Square[8][8]; // обЪявляем двувмерный массив квадратов 8х8 для создания доски

    public Board() {
        super();
        for(int i=0; i<squares.length; i++){ // цикл для прохода всего массива квадратов, составля.щих доску
            for(int j=0; j<squares.length; j++){
                this.squares[i][j] = new Square(i, j);  // выделяем память для квадратов доски 
            }
        }
    }

    public Square getSquare(int x, int y) { // функция для получения квадрата доски по заданным координатам 
        return squares[x][y];
    }

}