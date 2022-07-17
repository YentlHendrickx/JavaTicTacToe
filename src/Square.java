public class Square {

    private int id;
    private boolean state;
    private boolean locked;
    private MoveType mType;

    // User type, 1 = player 1, 2 = player 2, 3 = computer
    public String userType;

    public Square() {
        this.id = -1;
        this.locked = false;
        this.state = false;
        this.userType = null;
    }

    public void resetSquare(int id) {
        this.id = id;
        this.state = false;
        this.locked = false;
        this.userType = null;
    }

    public MoveType getMType() {
        return this.mType;
    }

    public void setMType(MoveType mType) {
        this.mType = mType;
    }

    public void setState(boolean state) {
        if (!this.locked) this.state = state;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void toggleState() {
        if (!this.locked) this.state = !this.state;
    }

    public void toggleLocked() {
        this.locked = !this.locked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return this.userType;
    }

    public int getId() {
        return this.id;
    }

    public boolean getState() {
        return this.state;
    }

    public boolean getLocked() {
        return this.locked;
    }

    public int getColumn() {
        return ((this.id / 3) + 1);
    }

    public int getRow() {

        return ((this.id % 3) + 1);
    }
}
