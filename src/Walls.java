import Interfaces.Drawable;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Walls implements Drawable {
    ArrayList<Wall> walls = new ArrayList<>();

    @Override
    public void draw(Graphics2D g2) {

    }

    public Wall get(int index){
        return walls.get(index);
    }
    public int getSize() {
        return walls.size();
    }
}
