public class Player {
    String name;
    Piece piece1;
    Piece piece2;
    boolean isFinished;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
