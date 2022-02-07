import java.util.ArrayList;
import java.util.Random;

public class WaveManager {

    //region [Variables]
    private ArrayList<Enemy> wave = new ArrayList<>();
    Random r = new Random();
    //endregion

    //region [Constructor]
    public WaveManager (int amountOfEnemys, Player player, boolean spawnLeft, boolean spawnRight, boolean spawnTop,boolean spawnBottom){

        for (int i = 0; amountOfEnemys>wave.size(); i++){

            int x=0;
            int y=0;
            String enemyType="";

            int spawn=0;
            boolean spawned=false;

            while (spawned==false){
                spawn=r.nextInt(0,4);
                if (spawnLeft && spawn==0){
                    x= 0-64;
                    y=r.nextInt(0,GameEngine.settings.getScreenHeight());
                    spawned=true;
                } else if (spawnRight && spawn==1){
                    x= GameEngine.settings.getScreenWidth()+64;
                    y=r.nextInt(0,GameEngine.settings.getScreenHeight());
                    spawned=true;
                } else if (spawnTop && spawn==2){
                    x= r.nextInt(0,GameEngine.settings.getScreenWidth());
                    y=0-64;
                    spawned=true;
                } else if (spawnBottom && spawn==3){
                    x=r.nextInt(0,GameEngine.settings.getScreenWidth());
                    y=GameEngine.settings.getScreenHeight();
                    spawned=true;
                }
            }

            //Type of enemy
            int type = r.nextInt(0,2);

            if (type==0){
                enemyType = "Zombiev1";
            }
            if (type==1){
                enemyType = "Zombiev2";
            }

            wave.add(new Enemy(enemyType,96,96,6,1,1.5,100,1,x,y, GameEngine.settings.getTileSize(),GameEngine.settings.getTileSize()));
        }
    }
    //endregion

    //region [Getters & Setters]
    public ArrayList<Enemy> getWave() {
        return wave;
    }

    public void setWave(ArrayList<Enemy> wave) {
        this.wave = wave;
    }
    //endregion

}
