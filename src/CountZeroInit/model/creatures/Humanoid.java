package CountZeroInit.model.creatures;

public class Humanoid extends LifeForm
        implements Playable {

    public Humanoid(String type) {
        this.type = type;
    }

    public Humanoid(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void keepMonster(Monster monster) {
        monsters.add(monster);
    }

    public Monster getMonster(int i) {
        if (monsters.get(i) != null) {
            return monsters.get(i);
        } else {
            System.out.println("You don't have a monster in slot " + i);
            return null;
        }
    }
}
