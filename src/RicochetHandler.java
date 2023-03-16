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
                if (intersect != null) {
                    Vector2 change = new Vector2(proj.getxChange(), proj.getyChange());
                    double speed = change.magnitude();
                    change = change.norm();
                    Line2D.Double normal = wall.getNormal();
                    Vector2 normalVector = new Vector2(normal.x2 - normal.x1, normal.y2 - normal.y1).norm();
                    double dot = normalVector.dot(change);
                    Vector2 reflect = new Vector2(change.x - 2 * dot * normalVector.x, change.y - 2 * dot * normalVector.y);
                    int xAdjust = (change.x < 0) ? 1 : -1;
                    int yAdjust = (change.y < 0) ? 1 : -1;
                    proj.setPosition(intersect.x + xAdjust, intersect.y + yAdjust);
                    proj.setVector(reflect.x * speed,reflect.y * speed);
                }
            }
        }

    }
}
