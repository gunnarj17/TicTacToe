package is.ru.hugb;

public class GameService {
	private Status gameStatus;
	private Board board;
	private Player currentPlayer, player1, player2;

	GameService(){
		board = new Board();
		player1 = new Player("Player X", 'X');
		player2 = new Player("Player O", 'O');
		currentPlayer = player1;
		gameStatus = Status.INPLAY;
	}

	public void makeMove(int move){
		if(board.mark(move, currentPlayer.getSymbol())){
			switchPlayer();
			updateGame();
		}
	}

	private void updateGame() {
		if(board.isWin()){
			gameStatus = Status.WIN;
		}else if(board.isFull()){
			gameStatus = Status.DRAW;
		}
		else{
			gameStatus = Status.INPLAY;
		}
	}

	private void switchPlayer() {
		if(currentPlayer == player1){
			currentPlayer = player2;
		}
		else{
			currentPlayer = player1;
		}
	}

	public Status getStatus(){
		return gameStatus;
	}

	public char[] getBoard(){
		return board.getBoard();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
}
