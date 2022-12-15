import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class RicochetHandler {
    Projectiles projectiles;
    Walls walls;
    public void checkCollisions(){
        for (int p=0; p<projectiles.getSize(); p++){
            for (int w=0; w<walls.getSize(); w++){
                Projectile proj = projectiles.get(p);
                Wall wall = walls.get(w);
                Line2D ray = proj.getRay();
                Point intersect = Raycast.check(ray,wall.hitbox);
                if (intersect != null){
                    AffineTransform transform = new AffineTransform();
                    double xChange = intersect.getX() - (ray.getX2()+proj.getxChange());
                    double yChange = intersect.getY() - (ray.getY2()+proj.getyChange());
                    double magnitude = Math.sqrt(Math.pow(xChange,2)+Math.pow(yChange,2));
                    Line2D.Double normal = wall.getNormal();
                    double xNorm = normal.x2 - normal.x1;
                    double yNorm = normal.y2 - normal.y1;
                    double magNorm = Math.sqrt(Math.pow(yNorm,2)+Math.pow(xNorm,2));
                    double dot = xNorm*xChange+yNorm*yChange;
                    double vectorProduct = xChange*yNorm - yChange*xNorm;
                    int sign = 1;
                    if (vectorProduct > 0){
                        sign = 1;
                    } else if (vectorProduct < 0){
                        sign = -1;
                    } else {
                        System.out.println("AHHHHH!!!!");
                    }
                    double rotation = sign*2*Math.acos((dot)/Math.abs(magNorm*magnitude));
                    transform.setToRotation(rotation);
                    Point vector = new Point((int)xChange,(int)yChange);
                    transform.transform(vector,vector);
                    proj.setPosition(intersect.x, intersect.y);
                    double divisor = Math.sqrt(Math.pow(vector.getY(),2) + Math.pow(vector.getX(),2))/Math.sqrt(Math.pow(proj.getxChange(),2) + Math.pow(proj.getyChange(),2));
                    proj.setVector(vector.x/divisor,vector.y/divisor);
                    return;
                }
            }
        }

    }
}
