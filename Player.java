public class Player {
    String name;
    Piece piece1;
    Piece piece2;
    boolean isFinished;

    public Player(){
        this.piece1 = new Piece(null);
        this.piece2 = new Piece(null);
    }
}
