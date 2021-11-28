class Tunnel implements travel, Hurt{
    Hurt given;

    Tunnel(Hurt x){
        given = x;
    }

    public boolean death_comes(){
        return given.death_comes();
    }

    public void explore(Traveller a){
        if(a.get_status() == status.dead){
            throw new WeDead("You aren't Zombie");
        }

        if(!given.death_comes()){
            try {
                a.random_gold();
            }
            catch (BelowZeroException e){
                a.set_gold(2147483647);
            } finally{
                System.out.print("теперь твой кошель точно в порядке путник");
            }
            a.random_XP();
        }
        else{
            a.swap_suc();
//            System.out.print("AAAAA");
        }
    }
}


class Horz_Tunnel extends Tunnel{
    public int length;

    Horz_Tunnel(int x, Atmoshpere y){
        super(y);
        length = x;
    }

    public boolean death_comes(){
        return (given.death_comes()) || (length > 100);
    }
}
