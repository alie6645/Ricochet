public class RicochetHandler {
    Projectiles projectiles;
    Walls walls;
    public void checkCollisions(){
        for (int p=0; p<projectiles.getSize(); p++){
            for (int w=0; w<walls.getSize(); w++){
                Projectile proj = projectiles.get(p);
                Wall wall = walls.get(w);
                if (Raycast.check()){

                }
            }
        }

    }
}
