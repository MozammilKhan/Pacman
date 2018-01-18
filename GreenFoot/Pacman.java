import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private int score = 0;
    private int counter = 0;
    private GreenfootImage image1 = new GreenfootImage ("pacman1.png");
    private GreenfootImage image2 = new GreenfootImage ("pacman2.png");
    private GreenfootImage image3 = new GreenfootImage ("pacman3.png");
    private SimpleTimer timer = new SimpleTimer();
    private boolean power = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().scale(25,25);
        animate();
        if (canMove())
        {
            tryMove();
        }
        getFood();
        
        nextLevel();
        
        eatEnemy();
        if (isTouching(Power.class))
        {
            timer.mark();
            power=true;
            removeTouching(Power.class);
        }
        if (timer.millisElapsed() > 5000 && power==true)
        {
           power=false;
           timer.mark();
        }

    }

    public Pacman()
    {

        setRotation(Greenfoot.getRandomNumber(4)*90);
    }

    /**  
     * Returns true if the Bug is within the World's borders
     */

    public boolean canMove()

    {

        if (getX() > 0)
        {
            return true; 
        }

        else if (getY() > 0)
        {
            return true; 
        }

        else if (getX() < 500)
        {
            return true; 
        }

        else if (getY() < 500)
        {
            return true; 
        }

        else

            return false;

    }

    /**
     * Move, after verifying that we are not moving outside the world boundary and a 
     * directional key was pressed
     */
    public void tryMove()
    {
        if (Greenfoot.isKeyDown("up")) //Move UP one "square"
        {
            setLocation(getX(), getY() - 5);
            setRotation(270);
            Actor aWallCell = getOneIntersectingObject(Wall.class) ;
            if (aWallCell != null)
                setLocation (getX() , getY() + 5 ) ;
        }
        else if (Greenfoot.isKeyDown("down")) //Move DOWN one "square"
        {
            setLocation(getX(), getY() + 5);
            setRotation(90);
            Actor aWallCell = getOneIntersectingObject(Wall.class) ;
            if (aWallCell != null)
                setLocation (getX() , getY() - 5 ) ;
        }
        if (Greenfoot.isKeyDown("right")) //Move UP one "square"
        {
            setLocation(getX() + 5, getY());
            setRotation(360);
            Actor aWallCell = getOneIntersectingObject(Wall.class) ;
            if (aWallCell != null)
                setLocation (getX()  - 5  , getY()) ;
        }
        else if (Greenfoot.isKeyDown("left")) //Move DOWN one "square"
        {
            setLocation(getX() - 5, getY());
            setRotation(180);
            Actor aWallCell = getOneIntersectingObject(Wall.class) ;
            if (aWallCell != null)
                setLocation (getX()  + 5 , getY()) ;
        }

    }

    public void animate()
    {
        counter++;
        switch(counter) {
            case 0 :setImage(image1);
            break;
            case 10 :setImage(image2);
            break;
            case 20 :setImage(image3);
            break;
            case 30 :setImage(image1);
            break;
            case 40 :setImage(image2);
            break;
            case 50 :setImage(image3);
            counter=0;
            break;
        }
    }

    public void getFood()
    {
        Actor eatFood = getOneIntersectingObject(Food.class) ;
        if (eatFood != null)
        {
            Level level = (Level)getWorld();
            score++;
            level.updateScore();
            getWorld().removeObject(eatFood);
        }
    }

    public void nextLevel()
    {
        if ( score == 129 )
        {
            Level level = (Level)getWorld();
            level.nextLevel();
        }
        if ( score == 242 )
        {
            Level level = (Level)getWorld();
            level.nextLevel();
        }
    }

    

    public void eatEnemy()
    {
        if (isTouching(Enemy.class) && power==true)
        {
            removeTouching(Enemy.class);
        }
        
        if (isTouching(Enemy.class) && power==false)
        {
            Greenfoot.stop();
        }
        

    }

    
}
