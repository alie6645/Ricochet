public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public Vector2 norm(){
        return new Vector2(x/magnitude(), y/magnitude());
    }

    public double dot(Vector2 a){
        return x * a.x + y * a.y;
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
