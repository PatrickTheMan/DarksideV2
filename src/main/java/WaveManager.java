import java.util.ArrayList;
import java.util.Random;

public class WaveManager {

    //region [Variables]
    private ArrayList<Enemy> wave = new ArrayList<>();
    Random r = new Random();
    //endregion

    //region [Constructor]
    public WaveManager (int amountOfEnemys){

        for (int i = 0; amountOfEnemys>wave.size(); i++){

            String enemyType="";
            int type = r.nextInt(0,2);

            if (type==0){
                enemyType = "Zombiev1";
            }
            if (type==1){
                enemyType = "Zombiev2";
            }

            wave.add(new Enemy(enemyType,96,96,6,1,1.5,100,10, GameEngine.settings.getTileSize(),GameEngine.settings.getTileSize()));
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
