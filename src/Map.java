public class Map {
    Walls walls = new Walls();
    Projectiles projectiles = new Projectiles();

    public Map(){
        walls.add(50,50,450,50);
        walls.add(50,50,50,450);
        walls.add(450,50,450,450);
        walls.add(50,450,450,450);
        walls.add(300,50,250,300);
    }

    public Walls getWalls() {
        return walls;
    }

    public Projectiles getProjectiles() {
        return projectiles;
    }
}
