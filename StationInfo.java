package comp50172023v2;

public class StationInfo implements IStationInfo{
    String Name;
    int x;
    int y;
    public StationInfo(String name, int x, int y) {
        Name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getxPos() {
        return x;
    }

    @Override
    public int getyPos() {
        return y;
    }
}
