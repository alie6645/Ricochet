public class Map {
    Walls walls = new Walls();
    Projectiles projectiles = new Projectiles();

    public Map(){
        walls.add(50,50,450,50);
        walls.add(70,50,50,450);
        walls.add(450,50,450,450);
        walls.add(50,450,450,450);
        walls.add(300,50,400,450);
    }

    public Walls getWalls() {
        return walls;
    }

    public Projectiles getProjectiles() {
        return projectiles;
    }
}
