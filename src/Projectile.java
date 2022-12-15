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

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setVector(double x, double y){
        xChange = x;
        yChange = y;
    }

    public void draw(Graphics2D g2){
        if (visible) {
            g2.setColor(Color.RED);
            g2.fillOval((int)x - ((diameter + 1) / 2), (int)y - ((diameter + 1) / 2), diameter, diameter);
            g2.draw(ray);
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
        ray.setLine(x,y,x+xChange,y+yChange);
    }

    public double getxChange() {
        return xChange;
    }

    public double getyChange() {
        return yChange;
    }

    public Line2D getRay() {
        return ray;
    }
}