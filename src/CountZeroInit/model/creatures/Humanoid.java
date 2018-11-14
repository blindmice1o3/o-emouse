package CountZeroInit.model.creatures;

import CountZeroInit.model.Observable;
import CountZeroInit.model.Observer;
import CountZeroInit.model.items.Item;

import java.util.List;

public class Humanoid extends LifeForm
        implements Playable, Observable {

    public Humanoid(String type) {
        this.type = type;
        setImageAddress("src/CountZeroInit/model/creatures/gameboy.png");
    }

    public Humanoid(String name, String type) {
        this.name = name;
        this.type = type;
        setImageAddress("src/CountZeroInit/model/creatures/gameboy.png");
    }

    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update();

            // The following println() statement is to identify when notifyObservers() is being called.
            System.out.println("Humanoid.notifyObservers..." );
        }
    }

    @Override
    public void setCol(int col) {
        this.col = col;
        notifyObservers();
    }

    @Override
    public void setRow(int row) {
        this.row = row;
        notifyObservers();
    }

    public void keepMonster(Monster monster) {
        myMonsterList.add(monster);
    }

    public Monster getMonster(int i) {
        if (myMonsterList.get(i) != null) {
            return myMonsterList.get(i);
        } else {
            System.out.println("You don't have a monster in slot " + i);
            return null;
        }
    }

    public void setInventory(List<Item> fromSource) {
        for (Item item: fromSource) {
            myInventory.add(item);
        }
    }
    public List<Item> getInventory() {
        return myInventory;
    }
    public void setMyMonsterList(List<Monster> fromSource) {
        for (Monster monster: fromSource) {
            myMonsterList.add(monster);
        }
    }
    public List<Monster> getMyMonsterList() {
        return myMonsterList;
    }
}
