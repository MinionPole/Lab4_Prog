import java.awt.geom.AffineTransform;


public class Lab3 {

    public static void main(String[] args){



        Horz_Tunnel[][] map = new Horz_Tunnel[3][3];
        Traveller MinionPole = new Traveller();
        MinionPole.change_name("Roman");



        System.out.print(MinionPole.toString());
        System.out.println(MinionPole.us);


        map[0][1] = new Horz_Tunnel(10, new Atmoshpere.Air());
        map[1][2] = new Horz_Tunnel(10, new Atmoshpere.CO2());
        map[2][0] = new Horz_Tunnel(10, new Atmoshpere.Air()){
            double height = Math.random() * 1000;
            public boolean death_comes(){
                return (given.death_comes()) || (length > 100) || (height > 100);
            }
        };

        for(int i = 0;i < 20;i++){
            map[0][1].explore(MinionPole);
            System.out.printf(" %f", MinionPole.get_gold());
            System.out.println("");
        }

        /*System.out.println(MinionPole.get_XP());
        System.out.println(MinionPole.get_gold());
        */

        map[1][2].explore(MinionPole);
        System.out.println(MinionPole.us);
        map[0][1].explore(MinionPole);
        System.out.println(MinionPole.get_XP());

    }
}





