import java.util.ArrayList;

public class Update {

    public static void all(KeyHandler kH, Player p,ArrayList<Enemy> e){
        player(kH,p);
        enemyWave(e);
    }

    public static void prSec(long timer, int drawCount){

        System.out.println("FPS: "+drawCount);

    }

    public static void player(KeyHandler keyHandler, Player player){

        if (keyHandler.upPressed){
            player.setY(player.getY()-player.getSpeed());
            System.out.println("x: "+player.getX()+" / y: "+player.getY());
        }
        if (keyHandler.downPressed){
            player.setY(player.getY()+player.getSpeed());
            System.out.println("x: "+player.getX()+" / y: "+player.getY());
        }
        if (keyHandler.leftPressed){
            player.setX(player.getX()-player.getSpeed());
            System.out.println("x: "+player.getX()+" / y: "+player.getY());
        }
        if (keyHandler.rightPressed){
            player.setX(player.getX()+player.getSpeed());
            System.out.println("x: "+player.getX()+" / y: "+player.getY());
        }


    }

    public static void enemyWave(ArrayList<Enemy> wave){

        for (Enemy e : wave){
            if (e.isDead()){
                wave.remove(e);
            }
        }
        //System.out.println("alive: "+wave.size());

    }

}
