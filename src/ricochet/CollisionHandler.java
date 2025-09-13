package ricochet;

import ricochet.*;

import java.util.List;

public class CollisionHandler {
    private List<Node> nodes;
    private List<Surface> surfaces;

    public CollisionHandler(List<Node> nodes, List<Surface> surfaces) {
        this.nodes = nodes;
        this.surfaces = surfaces;
    }

    public void runCollisions(){
        for (Node node:nodes){
            Vector2 hitPosition = null;
            Surface hitSurface = null;
            for (Surface surface:surfaces){
                Vector2 intersection = Raycast.intersection(node, surface);
                if (intersection != null)
                    if (hitPosition != null){
                        double dist = hitPosition.add(node.position.scale(-1)).magnitude();
                        double newDist = intersection.add(node.position.scale(-1)).magnitude();
                        hitPosition = (dist > newDist) ? intersection : hitPosition;
                        hitSurface = (dist > newDist) ? surface : hitSurface;
                    } else {
                        hitPosition = intersection;
                        hitSurface = surface;
                    }
            }
            if (hitPosition != null){
                collide(node, hitSurface, hitPosition);
            }
        }
    }

    private void collide(Node node, Surface surface, Vector2 position){
        Vector2 normal = surface.normal().normalize();
        Vector2 rebound = normal.scale(normal.dot(node.velocity));
        rebound = rebound.scale(surface.bounce);
        node.position = position.add(node.velocity.scale(-1));
        node.velocity = node.velocity.add(rebound.scale(-1));
        if (surface instanceof DetectorSurface)
            ((DetectorSurface) surface).onHit(node);
    }
}
