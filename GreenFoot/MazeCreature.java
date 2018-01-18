import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeCreature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeCreature extends Actor
{
    protected static final int EAST = 0;
    protected static final int SOUTH = 90;
    protected static final int WEST = 180;
    protected static final int NORTH = 270;
    private int counter = 0;
    /**
     * Act - do whatever the MazeCreature wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void moveForward()
    {
        counter++;
        if(counter==20)
        {
            move(10);
            counter = 0;
        }
    }
    
    public boolean facingEdge()
    {
        switch(getRotation())
        {
            case EAST: return getX() == getWorld().getWidth()-1;
            case WEST: return getX() == 0;
            case NORTH: return getY() == 0;
            case SOUTH: return getY() == getWorld().getHeight()-1;
        }
        return false;
    }
    
    public boolean facingWall()
    {
        int xOff=0, yOff=0;
        switch(getRotation())
        {
            case EAST: xOff=1; break;
            case SOUTH: yOff=1; break;
            case WEST: xOff=-1; break;
            case NORTH: yOff=-1; break;
        }
        return getOneObjectAtOffset(xOff,yOff,Wall.class)!=null;
    }
    
    public boolean canMove()
    {
        return !facingWall() && !facingEdge();
    }
    
}
