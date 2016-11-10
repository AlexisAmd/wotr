
/**
 * Décrivez votre classe Magician ici.
 * A magician can restore powers of an other NPC
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Magician extends NPC
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private NPC npc;

    /**
     * Constructeur d'objets de classe Magician
     */
    public Magician(String name, String description, int corruptionPower, int hpPower, Player currentPlayer, NPC npc)
    {
        super(name, description, corruptionPower, hpPower,  currentPlayer);
        this.alreadyUsed=false;
        this.hpPower = 0;
        this.corruptionPower = -10;
        this.description = "Can restore the power of an other NPC,  decrease corruption";
        this.npc = npc;
    }

    public void use(NPC npc){
        super.use();
        restorePower(npc);
    }

    /**
    *Restore
    */
    private void restorePower(NPC npc){
        npc.alreadyUsed=false;
    }
}
