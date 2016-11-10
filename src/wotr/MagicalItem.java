package wotr;
/**
 * Décrivez votre classe abstraite MagicalItem ici.
 *
 *saluuuuuuuuuuuuuuuuut
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */
public  class MagicalItem extends Item
{
    protected int corruptionPower;

    public MagicalItem(String name, String description, int weight, int corruptionPower,Player currentPlayer) {
        super(name, description, weight, currentPlayer);
        this.corruptionPower=corruptionPower;
    }
    
    public String toString() {
        return 
        "Name : "+getName() + "\n"+
        "Description : "+getDescription() + "\n"+
        "Weight : "+getWeight() + "\n" + 
        "Corruption power :"+ corruptionPower+"\n";

    }
    

    public void use(){

//SPECIFIC POWER ?
    }

    
}
