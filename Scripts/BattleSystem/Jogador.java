import java.util.ArrayList;

public class Jogador extends Unidade {
    
    private Item equip;
    private ArrayList<Item> itens = new ArrayList<>();
    private int atkBoost;
    private int defBoost;

    //Construtor
    public Jogador (String nome, int maxHp, int atk, int def) {
        super(nome, maxHp, atk, def);
        //this.atkBoost = item.getAtk();
        //this.defBoost = item.getDef();
    }

    //Get e set item
    public Item getItem () {
        return this.equip;
    }

    public void setItem (Item x) {
        this.equip = x;
    }

}