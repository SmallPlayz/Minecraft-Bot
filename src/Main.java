import java.awt.*;
import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args) throws AWTException {
        System.out.println("Hello world!");
        Robot robot = new Robot();
        wait(2500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = 0;
        while(true){

            Color color = robot.getPixelColor((1600/2), (900/2));
            System.out.println(robot.getPixelColor((1600/2), (900/2)));
            if(x==0)
                forward();
            else if(x==1){
                System.out.println("EEEE" + x);
                for(int i = 0; i<100; i++){
                    left();
                    wait(10);
                }
                forward();
                if(color.getRed()!=82 && color.getGreen()!=65 && color.getBlue()!=40) {
                    x = 0;
                    System.out.println("tree found");
                }
            }
            if(color.getRed()==82 && color.getGreen()==65 && color.getBlue()==40) {
                x = 1;
                System.out.println("tree found");
            }

        }

    }
    public Color getMouseColor(int x, int y) throws AWTException {
        Robot robot = new Robot();
        return robot.getPixelColor(x, y);
    }
    public static void mouseClick() throws AWTException { // clicks using robot class
        Robot bot = new Robot();
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public static void Mouseclick(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public static void wait(int x){ //sleeps for 'x' amount of ms
        try {
            Thread.sleep(x);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static void forward() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(87);
    }
    public static void backwards() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(83);
    }
    public static void left() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(65);
    }
    public static void right() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(68);
    }
}