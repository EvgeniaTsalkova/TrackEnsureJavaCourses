package flowershop;

import java.util.*;
import java.util.concurrent.Callable;

public class Bouquet implements Component {
    List<Component> components = new ArrayList<>();

    public void addComponent(Component... comp){
        components.addAll(Arrays.asList(comp));
    }

    public void removeComponent(Component comp){
        components.remove(comp);
    }

    public int getPrice(){
        int worth = 0;
        for (Component c: components) {
            worth += c.getPrice();
        }
        return worth;
    }

     public void sortByFreshness(){
         components.sort((o1, o2) -> o2.getFreshness() - o1.getFreshness());
    }

    public void getByLength(int from, int to){
        for(Component c : components){
            if ((c.getLength() >= from)&&(c.getLength() <= to)){
                c.designation();
            }
        }
    }

    public void designation(){
        for(Component c : components){
            c.designation();
        }
    }

    @Override
    public int getLength() {
        int generalLength = 0;
        for(Component c : components){
            generalLength += c.getLength();
        }
        return generalLength/components.size();
    }

    @Override
    public int getFreshness() {
        int generalFreshness = 0;
        for(Component c : components){
            generalFreshness += c.getFreshness();
        }
        return generalFreshness/components.size();
    }

}
