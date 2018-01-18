import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    public int speed = 3;
    public String direction = "down";
    
    public Enemy()
    {
        getImage().scale(30,30);
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().scale(30,30);
        setLocation(getX(), getY() + speed);
        atWall();
        
        
    }
    
    

    public void changeDirection()
    {
        int angle = Greenfoot.getRandomNumber(4)*90;
        setRotation(angle);
    }

    public void atWall()
    {
        Actor wall = getOneIntersectingObject(Wall.class);
        if (wall != null)
        {
            speed = -speed;
            changeDirection();
        }

    }
    

    
}
