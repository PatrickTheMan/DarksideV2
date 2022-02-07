import javax.swing.*;

public class Main {

    //region [Main]
    public static void main (String[] args){

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(true);

        frame.setTitle("Darkside");


        GameEngine ge = new GameEngine();
        frame.add(ge);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);


        ge.startGameThread();
    }
    //endregion

}
