import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Actor
{
    /**
     * Act - do whatever the scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ScoreBoard(String text) 
    {
        GreenfootImage  img = new GreenfootImage(150, 50);
        
        img.drawString(text,8,45);
        setImage(img);
    }    
    
    public void setText(String text)
    {
        GreenfootImage img = getImage();
        img.clear();
        
        img.drawString(text,8,45);
    }
    
}
