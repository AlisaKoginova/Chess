
public class Game {
	private Player white; // ыапролд
    private Player black;
    private Board board = new Board(); // îáúÿâëÿåì äîñêó
     
    // èíèöèàëèçèðóåì îáúåêòû êëàññà Game 
    public void setBoard(Board board) { 
        this.board = board;
    }
    public void setColorWhite(Player player) {
        this.white = player;
    }
    
    public void setColorBlack(Player player) {
        this.black = player;
    }
    
    // â ñëåäóþùèõ ôóíêöèÿõ "ñâÿçûâàåì" öâåò ñ èãðîêàìè 
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
    
    // ôóíêöèÿ äëÿ èíèöèàëèçàöèè èãðîêîâ ñ ðàçíûõ ñòîðîí äîñêè è äîáàâëåíèÿ ôèãóð íà äîñêó - íà÷àëî èãðû
    public boolean initBoardPlayers() {
        if(this.black == null || this.white == null) // åñëè èãðîê èëè èãðîêè íå èíèöèàëèçèðîâàíû, âîçâðàùàåì false 
            return false;
        this.board = new Board(); // èíèöèàëèçèðóåì äîñêó 
        for(int i=0; i<black.getPieces().size(); i++){ // ïðèñâàèâàåì èãðîêàì ôèãóðû 
            board.getSquare(black.getPieces().get(i).getX(), black.getPieces().get(i).getY()).occupySquare(black.getPieces().get(i));
        }
        return true;
    }
}
