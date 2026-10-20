interface MovementStrategy {
    String move();
}

class Walking implements MovementStrategy {
    @Override
    public String move() {
        return "Moving at 5 km/h";
    }
}

class Skateboarding implements MovementStrategy {
    @Override
    public String move() {
        return "Moving at 15 km/h";
    }
}

class Jetpack implements MovementStrategy {
    @Override
    public String move() {
        return "Moving at 60 km/h";
    }
}

class Player {
    private MovementStrategy strategy;

    public Player(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public void move() {
        System.out.println(strategy.move());
    }
}

public class Main {
    public static void main(String[] args) {
        Player player = new Player(new Walking());
        player.move();

        player.setStrategy(new Jetpack());
        player.move();
    }
}
