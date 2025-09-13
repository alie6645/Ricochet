package peggle;

import ricochet.DetectorSurface;
import ricochet.Vector2;

import java.awt.*;

public class RectanglePeg extends Peg{

    public RectanglePeg(Vector2 pos, Vector2 dir, Vector2 dir2){
        setSides(buildShape(pos, dir, dir2));
        for (DetectorSurface side:getSides())
            side.bounce = 1.05;
    }

    private DetectorSurface[] buildShape(Vector2 pos, Vector2 dir, Vector2 dir2){
        DetectorSurface[] sides = new DetectorSurface[4];
        sides[0] = new DetectorSurface(pos, pos.add(dir));
        sides[1] = new DetectorSurface(pos.add(dir), pos.add(dir2).add(dir));
        sides[2] = new DetectorSurface(pos.add(dir).add(dir2), pos.add(dir2));
        sides[3] = new DetectorSurface(pos.add(dir2), pos);
        return sides;
    }

    public void draw(Graphics g){
        int[] x = new int[4];
        int[] y = new int[4];
        for (int i = 0; i < getSides().length; i++) {
            x[i] = (int) getSides()[i].p1.x;
            y[i] = (int) getSides()[i].p1.y;
        }
        if (isHit())
            g.setColor(Color.YELLOW);
        else
            g.setColor(Color.BLUE);
        g.fillPolygon(x, y, 4);
    }
}
