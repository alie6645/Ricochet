package ricochet;

import java.util.ArrayList;
import java.util.List;

public class CurveBuilder {
    private static List<Surface> surfaces = new ArrayList<>();

    public static List<Surface> buildSurface(Vector2 start, Vector2 end, double depth){
        return buildSurface(start, end, depth, 5);
    }


    public static List<Surface> buildSurface(Vector2 start, Vector2 end, double depth, int complexity){
        if (depth < 0) {
            depth = -depth;
            Vector2 temp = start;
            start = end;
            end = temp;
        }
        surfaces.clear();
        Vector2 direction = end.add(start.scale(-1));
        Vector2 midpoint = start.add(direction.scale(0.5));
        Vector2 center = midpoint.add(direction.perpendicular().normalize().scale(direction.magnitude()/-depth));
        subdivide(start, end, center, complexity);
        return surfaces;
    }

    public static void subdivide(Vector2 start, Vector2 end, Vector2 center, int complexity){
        if (complexity == 0){
            surfaces.add(new Surface(start, end));
            return;
        }
        Vector2 direction = end.add(start.scale(-1));
        Vector2 perpen = direction.perpendicular().normalize();
        double radius = center.add(start.scale(-1)).magnitude();
        Vector2 curvePoint = center.add(perpen.scale(radius));

        subdivide(start, curvePoint, center, complexity-1);
        subdivide(curvePoint, end, center, complexity-1);

    }
}
