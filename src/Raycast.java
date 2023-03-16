import javax.sound.sampled.Line;
import java.awt.*;
import java.awt.geom.Line2D;

public class Raycast {
    public static double slope(Point A, Point B){
        return (B.getY()-A.getY())/(B.getX()-A.getX());
    }

    public static double intercept(Point A, Point B){
        return A.getY() - (A.getX() * slope(A,B));
    }

    public static Point check(Point A, Point B, Point C, Point D){
        double a = slope(A,B);
        double c = slope(C,D);
        double b = intercept(A,B);
        double d = intercept(C,D);

        if (a==c && b!=d){
            return null;
        }
        if (Double.isInfinite(a)||Double.isInfinite(c)){
            return infinite(A,B,C,D);
        }
        if (a==0||c==0){
            if (a!=0||c!=0) {
                return cross(A, B, C, D);
            }
        }



        double hor = ((b - d) / (c - a));
        double ver = (a*hor + b);
        int x = (int) Math.round(hor);
        int y = (int) Math.round(ver);
        if (x >= Math.min(A.x,B.x) && x >= Math.min(C.x,D.x)){
            if (x <= Math.max(A.x,B.x) && x <= Math.max(C.x,D.x)){
                return new Point(x,y);
            }
        }
        return null;
    }

    public static Point check(Line2D line, Line2D line2){
        Point P1 = new Point((int) line.getX1(), (int) line.getY1());
        Point P2 = new Point((int) line.getX2(), (int) line.getY2());
        Point P3 = new Point((int) line2.getX1(), (int) line2.getY1());
        Point P4 = new Point((int) line2.getX2(), (int) line2.getY2());
        return check(P1, P2, P3, P4);
    }


    private static Point cross(Point A, Point B, Point C, Point D){
        int x;
        int y;
        if (slope(A,B) == 0){
            y = A.y;
            x = (int) ((y - intercept(C,D))/slope(C,D));
            if (Math.min(A.x,B.x)<=x && Math.max(A.x,B.x)>=x){
                if (Math.min(C.y,D.y)<=y && Math.max(C.y,D.y)>=y) {
                    return new Point(x, (A.y + B.y) / 2);
                }
            } else {
                return null;
            }
        } else {
            y = C.y;
            x = (int) ((y - intercept(A,B))/slope(A,B));
            if (Math.min(C.x,D.x)<=x && Math.max(C.x,D.x)>=x){
                if (Math.min(A.y,B.y)<=y && Math.max(A.y,B.y)>=y) {
                    return new Point(x, (C.y + D.y) / 2);
                }
            } else {
                return null;
            }
        }
        return null;
    }


    private static Point infinite(Point A, Point B, Point C, Point D){
        int x;
        int y;
        if (Double.isInfinite(slope(A,B))){
            x = A.x;
            y = (int) (slope(C,D)*x + intercept(C,D));
        } else {
            x = C.x;
            y = (int) (slope(A,B)*x + intercept(A,B));
        }
        if (Math.min(C.x,D.x)<=x&&Math.max(C.x,D.x)>=x){
            if (Math.min(C.y,D.y)<=y&&Math.max(C.y,D.y)>=y){
                if (Math.min(A.y,B.y)<=y&&Math.max(A.y,B.y)>=y) {
                    if (Math.min(A.x,B.x)<=x&&Math.max(A.x,B.x)>=x)
                    return new Point(x, y);
                }
            }
        }
        return null;
    }

}