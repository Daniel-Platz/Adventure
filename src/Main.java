public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Adventure adventure = new Adventure(map);
        UserInterface ui = new UserInterface(adventure);
        ui.startGame();

    }
}