public class Item {

    String name;

    public Item(String name){
        this.name = name;
    }


    // TODO: make Item abstract or move all effects into subclasses
    /**
     * Uses this item on the given player.
     * Subclasses should override this method to provide real behavior,
     * The base implementation does nothing so calling use() is always safe.
     *
     * @param p the player who is using the item
     */


    public void use(Player p) {
        // empty on purpose
    }



}
