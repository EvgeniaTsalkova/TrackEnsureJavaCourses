package flowershop;

public abstract class Flower implements Component {
    private int price;
    private int freshness;
    private int length;

    public Flower(int price, int freshness, int length){
        this.price = price;
        this.freshness = freshness;
        this.length = length;
    }


    public int getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getLength() {
        return length;
    }

    @Override
    public abstract void designation();


}
