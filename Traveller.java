import javafx.scene.paint.Material;

enum status {live, dead};

class Traveller{
    enum material {leather, steel, gold, diamond};
    // non-static
    public class Armour{

        private material Mat;
        private int endurance;
        private Armour(material s, int x){
            Mat = s;
            endurance = x;
        }
    }

    Armour bronik = new Armour(material.leather, 100);
    status us;
    String name;
    int level;
    private int XP;
    private int gold;

    Traveller(){
        us = status.live;
        name = "bro";
        XP = 0;
        gold = 0;
    }

    public boolean equals(Traveller trav){
        if(trav == null)
            return false;
        if(this == trav)
            return true;
        return (trav.name == this.name && trav.level == this.level);
    }

    public int hashCode(){
        return name.hashCode() >> level;
    }

    public String toString(){
        return "my name is " + name;
    }

    public void swap_suc(){
        if(us == status.live)
            us = status.dead;
        else
            us = status.live;
    }

    private void update_level(){
        level += XP / 1000;
        XP %= 1000;
    }

    public double get_XP(){
        return XP;
    }

    public status get_status(){
        return us;
    }

    public double get_gold(){
        return gold;
    }

    public void change_name(String s){
        name = s;
    }

    public void random_XP (){
        XP += (int)(Math.random() * Math.random()*1000);
        update_level();
    }

    public void random_gold() throws BelowZeroException{
        gold += (int)(Math.random() * Math.random() * 1000000000);
        if(gold<0){
            throw new BelowZeroException("ваш кошель переполнен милорд");
        }
    }

    public void set_gold(int x){
        gold = x;
    }


}