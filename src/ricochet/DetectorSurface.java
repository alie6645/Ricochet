package ricochet;

public class DetectorSurface extends Surface{
    CollisionListener collisionListener;
    public DetectorSurface(Vector2 p1, Vector2 p2) {
        super(p1, p2);
    }

    public void register(CollisionListener command){
        this.collisionListener = command;
    }

    public void onHit(Node node){
        collisionListener.run(node);
    }
}
