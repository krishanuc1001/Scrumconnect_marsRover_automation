package marsrover;

public class Rover {
    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    public Integer x = 0;
    public Integer y = 0;
    public Integer facing = N;

    public Rover() {
    }

    public Rover(int upperRightX, int upperRightY) {
    }

    public void setPosition(Integer x, Integer y, Integer facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public void printPosition() {
        char dir = 'N';
        if (facing == 1) {
            dir = 'N';
        } else if (facing == 2) {
            dir = 'E';
        } else if (facing == 3) {
            dir = 'S';
        } else if (facing == 4) {
            dir = 'W';
        }
        System.out.println(x + " " + y + " " + dir);
    }

    public void process(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            process(commands.charAt(i));
        }
    }

    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException("Speak in Mars language, please!");
        }
    }

    public void move() {
        if (facing.equals(N)) {
            this.y++;
        } else if (facing.equals(E)) {
            this.x++;
        } else if (facing.equals(S)) {
            this.y--;
        } else if (facing.equals(W)) {
            this.x--;
        }
    }

    public void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }

    private void turnRight() {
        facing = (facing + 1) > W ? N : facing + 1;
    }

    public static void main(String args[]) {
        Rover rover = new Rover();
        rover.setPosition(1, 2, N);
        rover.process("LMLMLMLMM");
        rover.printPosition(); // prints 1 3 N
        rover.setPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        rover.printPosition(); // prints 5 1 E
    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }

    public String getDirection() {
        if (getX() > 0) {
            return "N";
        } else {
            return "S";
        }
    }
}