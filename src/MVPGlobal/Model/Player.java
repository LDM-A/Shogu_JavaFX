package MVPGlobal.Model;

public class Player {
    private String name;
    private StoneColour stoneColour;

    public Player(String name, StoneColour stoneColour) {
        this.name = name;
        this.stoneColour = stoneColour;
    }

    public String getName() {
        return name;
    }

    public StoneColour getStoneColour() {
        return stoneColour;
    }

    // And any other methods or attributes relevant to a player
}
