//still have an error with i dont understand

package RobotCwkSimu;

import java.util.Scanner;

public class RobotInterface {
    private Scanner s;
    private RobotArena myArena;

    public RobotInterface() {
        s = new Scanner(System.in);
        myArena = new RobotArena(20, 6);

        char ch = ' ';
        do {
            System.out.print("Enter (A)dd Robot, get (I)nformation, (M)ove Robots, (D)isplay Arena, a(N)imation, (C)reate new Arena, or e(X)it > ");
            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A':
                case 'a':
                    myArena.addRobot(Direction.randomDirection());
                    break;
                case 'I':
                case 'i':
                    System.out.print(myArena.toString());
                    break;
                case 'M':
                case 'm':
                    myArena.moveAllRobots();
                    doDisplay();
                    System.out.print(myArena.toString());
                    break;
                case 'D':
                case 'd':
                    doDisplay();
                    break;
                case 'N':
                case 'n':
                    animateRobots(10); // Add this option to move all robots 10 times with animation
                    break;
                case 'C':
                case 'c':
                    createNewArena();                           
                	break;
                case 'X':
                case 'x':
                    ch = 'X';
                    break;
            }
        } while (ch != 'X');

        s.close();
    }

    void createNewArena() {
        System.out.print("Enter the new x size of the arena: ");
        int newXSize = s.nextInt();
        System.out.print("Enter the new y size of the arena: ");
        int newYSize = s.nextInt();
        myArena = new RobotArena(newXSize, newYSize);
    }

    void animateRobots(int moves) {
        for (int i = 0; i < moves; i++) {
            myArena.moveAllRobots();
            doDisplay();
            System.out.print(myArena.toString());

          
            }
        }

    void doDisplay() {
        ConsoloCanvas c = new ConsoloCanvas(myArena.getWidth(), myArena.getHeight(), "30810845");
        myArena.showRobots(c);
        System.out.println(c.toString());
    }
    

    public static void main(String[] args) {
       RobotInterface r = new RobotInterface(); 	   
       
       
    }
}
