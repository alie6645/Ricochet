package ricochet;

public class Raycast{
    public static Vector2 intersection(Node a, Surface b){
        if (a.velocity.normalize() == b.direction().normalize()){
            return null;
        }
        return check(a.position, a.position.add(a.velocity), b.p1, b.p2);
    }

    private static double slope(Vector2 A, Vector2 B){
        return (B.y-A.y) / (B.x-A.x);
    }

    private static double intercept(Vector2 A, Vector2 B){
        return A.y - (A.x * slope(A,B));
    }
    
    public static Vector2 check(Vector2 A, Vector2 B, Vector2 C, Vector2 D){
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
        double x = hor;
        double y = ver;
        if (x >= Math.min(A.x,B.x) && x >= Math.min(C.x,D.x)){
            if (x <= Math.max(A.x,B.x) && x <= Math.max(C.x,D.x)){
                return new Vector2(x,y);
            }
        }
        return null;
    }


    private static Vector2 cross(Vector2 A, Vector2 B, Vector2 C, Vector2 D){
        double x;
        double y;
        if (slope(A,B) == 0){
            y = A.y;
            x = (y - intercept(C,D))/slope(C,D);
            if (Math.min(A.x,B.x)<=x && Math.max(A.x,B.x)>=x){
                if (Math.min(C.y,D.y)<=y && Math.max(C.y,D.y)>=y) {
                    return new Vector2(x, (A.y + B.y) / 2);
                }
            } else {
                return null;
            }
        } else {
            y = C.y;
            x = (y - intercept(A,B))/slope(A,B);
            if (Math.min(C.x,D.x)<=x && Math.max(C.x,D.x)>=x){
                if (Math.min(A.y,B.y)<=y && Math.max(A.y,B.y)>=y) {
                    return new Vector2(x, (C.y + D.y) / 2);
                }
            } else {
                return null;
            }
        }
        return null;
    }


    private static Vector2 infinite(Vector2 A, Vector2 B, Vector2 C, Vector2 D){
        double x;
        double y;
        if (Double.isInfinite(slope(A,B))){
            x = A.x;
            y = slope(C,D)*x + intercept(C,D);
        } else {
            x = C.x;
            y = slope(A,B)*x + intercept(A,B);
        }
        if (Math.min(C.x,D.x)<=x&&Math.max(C.x,D.x)>=x){
            if (Math.min(C.y,D.y)<=y&&Math.max(C.y,D.y)>=y){
                if (Math.min(A.y,B.y)<=y&&Math.max(A.y,B.y)>=y) {
                    if (Math.min(A.x,B.x)<=x&&Math.max(A.x,B.x)>=x)
                        return new Vector2(x, y);
                }
            }
        }
        return null;
    }
}