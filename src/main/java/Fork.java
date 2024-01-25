public class Fork {
    private int id;
    private  volatile boolean isAvailable;

    public Fork(int id) {
        this.id = id;
        setAvailable(true);
    }

    public boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvilable) {
        this.isAvailable = isAvilable;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
