import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    private int level = 1;
    private ScoreBoard display;
    private int score = 0;

    private String maze1=

        "000000000000000"+ //1
        "011111111111120"+ //2
        "010001101100010"+ //3
        "010211111111010"+ //4
        "010111111111010"+ //5
        "011101111101110"+ //6
        "011101111101110"+ //7
        "010101131101040"+ //8
        "011101111101110"+ //9
        "011101111101110"+ //10 
        "010111111111010"+ //11
        "010111111112010"+ //12
        "010001101100010"+ //13
        "021111111111110"+ //14
        "000000000000000"; //15
        
        private String maze2=

        "000000000000000"+ //1
        "010111101211010"+ //2
        "010111101111010"+ //3
        "010001000100010"+ //4
        "010211101111010"+ //5
        "011111111111110"+ //6
        "011100111001110"+ //7
        "010001131100010"+ //8
        "010101111101010"+ //9
        "010101111101010"+ //10 
        "011111101111110"+ //11
        "011011000110110"+ //12
        "011011101110110"+ //13
        "011012000110120"+ //14
        "000000000000000"; //15
        
        private String maze3=
        
        "001000001000000"+ //1
        "001000001000000"+ //2
        "001001001000000"+ //3
        "001010101000000"+ //4
        "001000001000000"+ //5
        "000000000000000"+ //6
        "000000010000000"+ //7
        "000000000000000"+ //8
        "000000010000000"+ //9
        "000000010000000"+ //10 
        "000000010000000"+ //11
        "000000001001000"+ //12
        "000000001101000"+ //13
        "000000001011000"+ //14
        "000000001001000"; //15


    /**
     * Constructor for objects of class Maze.
     * 
     */
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        buildMaze(maze1);

        display = new ScoreBoard("Score:" + score);
        addObject(display, 110, 18);

        prepare();
    }

    public void buildMaze(String maze)
    {
        removeObjects (getObjects(Pacman.class));
        removeObjects (getObjects(Enemy.class));
        removeObjects (getObjects(Food.class));
        removeObjects (getObjects(Wall.class));
        int x=20;
        int y=20;
        for(int p=0;p<maze.length();p++){
            if(maze.charAt(p)=='0'){
                addObject(new Wall(),x,y);
            }
            if(maze.charAt(p)=='1'){
                addObject(new Food(),x,y);
            }
            if(maze.charAt(p)=='2'){
                addObject(new Enemy(),x,y);
            }
            if(maze.charAt(p)=='3'){
                addObject(new Pacman(),x,y);
            }
            if(maze.charAt(p)=='4'){
                addObject(new Power(),x,y);
            }

            x+=40;    //move one space to the right
            if(x>getWidth()){    //when at the right edge of the world, move to the next row
                y+=40;
                x=20;
            }
        } 
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(ScoreBoard.class, Pacman.class, Enemy.class, Food.class);
    }

    public void updateScore()
    {
        score++;
        display.setText("Score:" + score);
    }
    public void nextLevel()
    {
        level++;
        switch(level) 
        {
            case 1: buildMaze(maze1); break;
            case 2: buildMaze(maze2); break;
            
        }
        if(level==3)
        {
            Greenfoot.setWorld( new Win() );
        }
    }
}
