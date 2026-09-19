public class EnemyFactory {

    static Enemy getRandom(){
        Enemy[] enemies = {
            new Enemy("Goblin",40,6,30,3,10),
            new Enemy("Wolf",35,9,25,0,5),
            new Enemy("Orc",80,12,60,8,20),
            new Enemy("Skeleton",50,8,40,5,15),
            new Enemy("Cave Troll",120,15,100,15,35)
        };

        int randomIndex = (int)(Math.random()*enemies.length);
        return enemies[randomIndex];
    }

}
