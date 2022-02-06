import java.util.ArrayList;

public class Update {

    //region [All]
    public static void all(long timer,KeyHandler kH, Player p,ArrayList<Enemy> e){
        player(timer,kH,p);
        enemyWave(e);
    }
    //endregion

    //region [prSec]
    public static void prSec(long timer, int drawCount, Player player){

        System.out.println("FPS: "+drawCount);

        System.out.println("x: "+player.getX()+" / y: "+player.getY());

        System.out.println("Player -> "+player.facing);

    }
    //endregion

    //region [Player]
    public static void player(long timer,KeyHandler keyHandler, Player player){

        if (keyHandler.upPressed){
            player.setY(player.getY()-player.getSpeed());
            player.setPlayerMoving(true);
        }

        if (keyHandler.downPressed){
            player.setY(player.getY()+player.getSpeed());
            player.setPlayerMoving(true);
        }

        if (keyHandler.leftPressed){

            if (player.facing == Player.Facing.right){
                player.facing= Player.Facing.left;
            }

            player.setX(player.getX()-player.getSpeed());
            player.setPlayerMoving(true);
        }

        if (keyHandler.rightPressed){
            player.facing= Player.Facing.right;

            if (player.facing == Player.Facing.left){
                player.facing= Player.Facing.right;
            }

            player.setX(player.getX()+player.getSpeed());
            player.setPlayerMoving(true);
        }

    }
    //endregion

    //region [enemyWave]
    public static void enemyWave(ArrayList<Enemy> wave){

        for (Enemy e : wave){
            if (e.isDead()){
                wave.remove(e);
            }
        }
        //System.out.println("alive: "+wave.size());

    }
    //endregion

}
