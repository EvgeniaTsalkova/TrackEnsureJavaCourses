package flowershop;

public class MainFlowerShop {
    public static void main(String[] args) {
        Component f1 = new Rose(30, 5, 60);
        Component f2 = new Gypsophila(40, 10, 70);
        Component f3 = new Chamomile( 10, 8, 80);
        Component f4 = new Alstroemeria(30, 6, 80);
        Component f5 = new Rose(60, 9, 90);

        Bouquet bouquet = new Bouquet();
        Bouquet bouquet1 = new Bouquet();
        bouquet.addComponent(f1, f2, f3);
        bouquet1.addComponent(f4, f5);
        bouquet.addComponent(bouquet1);

        System.out.println("Bouquet costs " + bouquet.getPrice() + " hryvnas");
        System.out.println("Flowers from diapason:");
        bouquet.getByLength(60, 70);
        System.out.println("Sorted by freshness:");
        bouquet.sortByFreshness();
        bouquet.designation();
        //System.out.println(bouquet.getLength());
    }
}
