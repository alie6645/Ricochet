package ricochet;

import java.awt.*;

public class Surface {
    public Vector2 p1;
    public Vector2 p2;
    public double bounce = 2;
    public double friction = 0.5;

    public Surface(Vector2 p1, Vector2 p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public Vector2 normal(){
        return direction().perpendicular();
    }

    public Vector2 direction(){
        return p2.add(p1.scale(-1));
    }

    public void draw(Graphics g){
        g.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
    }
}
