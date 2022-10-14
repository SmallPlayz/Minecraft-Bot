import java.awt.*;
import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        wait(2500);
        int x = 0;
        while(true){

            Color color = robot.getPixelColor((1600/2), (900/2));
            Color colorBottom = robot.getPixelColor(500, 840);
            if(x==0) {
                forward();
                wait(10);
                if ((color.getRed() == 82 && color.getGreen() == 65 && color.getBlue() == 40) ||
                    (color.getRed() == 61 && color.getGreen() == 49 && color.getBlue() == 30) ||
                    (color.getRed() == 65 && color.getGreen() == 52 && color.getBlue() == 32) ||

                    (color.getRed() == 124 && color.getGreen() == 124 && color.getBlue() == 121) ||
                    (color.getRed() == 166 && color.getGreen() == 165 && color.getBlue() == 161)) {
                    x = 1;
                    System.out.println("tree found");
                }
                if((colorBottom.getBlue() <= 238 && colorBottom.getBlue() >=140)){
                    System.out.println("water??");
                    jumpRun();
                }

            }else if(x==1){
                left();
                wait(10);
                forward();
                wait(10);
                right();
                wait(10);
                forward();
                x=0;
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
        wait(500);
        bot.keyRelease(87);
    }
    public static void backwards() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(83);
        wait(500);
        bot.keyRelease(83);
    }
    public static void left() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(65);
        wait(500);
        bot.keyRelease(65);
    }
    public static void right() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(68);
        wait(500);
        bot.keyRelease(68);
    }
    public static void jumpRun() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(32);
        bot.keyPress(87);
        wait(500);
        bot.keyRelease(32);
        bot.keyRelease(87);
    }
    public static void breakBlock() throws AWTException {
        Robot bot = new Robot();
        bot.mousePress(InputEvent.BUTTON1_MASK);
        wait(5000);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}