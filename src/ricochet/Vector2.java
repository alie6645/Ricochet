package ricochet;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double dot(Vector2 other){
        return x * other.x + y * other.y;
    }

    public Vector2 scale(double factor){
        return new Vector2(factor * x, factor * y);
    }

    public Vector2 normalize(){
        return scale(1/magnitude());
    }

    public double magnitude(){
        return Math.sqrt(x*x + y*y);
    }

    public Vector2 add(Vector2 other){
        return new Vector2(x + other.x, y + other.y);
    }
    public Vector2 perpendicular(){
        return new Vector2(y, -x);
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof Vector2){
            Vector2 vector = (Vector2) other;
            return vector.x == x && vector.y == y;
        }
        return false;
    }
}
