import Interfaces.Drawable;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Walls implements Drawable {
    ArrayList<Wall> walls = new ArrayList<>();

    @Override
    public void draw(Graphics2D g2) {
        for (Wall wall:walls){
            wall.draw(g2);
        }
    }

    public Wall get(int index){
        return walls.get(index);
    }
    public int getSize() {
        return walls.size();
    }

    public void add(int x1, int y1, int x2, int y2){
        walls.add(new Wall(x1, y1, x2, y2));
    }
}
