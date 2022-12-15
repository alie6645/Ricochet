import java.awt.*;
import java.awt.geom.Line2D;

public class Wall{
    Line2D.Double hitbox;

    public Wall(int x1, int y1, int x2, int y2){
        hitbox = new Line2D.Double(x1, y1, x2, y2);
    }

    public Line2D.Double getNormal(){
        return new Line2D.Double(0, 0, hitbox.y2-hitbox.y1, hitbox.x2-hitbox.x1);
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.pink);
        g2.draw(hitbox);
    }
}
