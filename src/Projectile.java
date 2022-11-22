import Interfaces.Drawable;
import Interfaces.Updatable;

import java.awt.*;
import java.awt.geom.Line2D;

public class Projectile implements Drawable, Updatable {
    private double xChange;
    private double yChange;
    private double x;
    private double y;
    private int lifetime;
    private int diameter = 5;
    private boolean visible = true;
    private Line2D.Double ray;


    public Projectile(int x, int y, double xChange, double yChange, int lifetime){
        this.x = x;
        this.y = y;
        this.xChange = xChange;
        this.yChange = yChange;
        this.lifetime = lifetime;
        this.ray = new Line2D.Double(x,y,x+xChange,y+yChange);
    }



    public void draw(Graphics2D g2){
        if (visible) {
            g2.setColor(Color.RED);
            g2.fillOval((int)x - ((diameter + 1) / 2), (int)y - ((diameter + 1) / 2), diameter, diameter);
        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public void update() {
        x += xChange;
        y += yChange;
    }
}