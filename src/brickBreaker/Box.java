package brickBreaker;

import ricochet.CollisionListener;
import ricochet.DetectorSurface;
import ricochet.Surface;
import ricochet.Vector2;

import java.awt.*;

public class Box {
    Vector2 pos;
    double length;
    int hits = 10;

    DetectorSurface[] sides = new DetectorSurface[4];

    public Box(Vector2 pos, double length){
        this.pos = pos;
        this.length = length;
        sides[0] = new DetectorSurface(pos, pos.add(new Vector2(0, length)));
        sides[1] = new DetectorSurface(pos, pos.add(new Vector2(length, 0)));
        sides[2] = new DetectorSurface(pos.add(new Vector2(0, length)),pos.add(new Vector2(length, length)));
        sides[3] = new DetectorSurface(pos.add(new Vector2(length, 0)),pos.add(new Vector2(length, length)));
    }

    public Surface[] getSides(){
        return sides;
    }

    public void setBounce(double bounce){
        for (DetectorSurface side:sides)
            side.bounce = bounce;
    }

    public void register(CollisionListener command){
        for (DetectorSurface side:sides)
            side.register(command);
    }

    public void draw(Graphics g) {
        g.drawString(String.valueOf(hits), (int) (pos.x + length/2) - 5, (int) (pos.y + length/2) + 5);
    }
}
