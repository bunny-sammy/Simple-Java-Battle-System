import java.util.ArrayList;

public class Jogador extends Unidade {
    
    private Item equip;
    private ArrayList<Item> itens = new ArrayList<>();
    private int atkBoost;
    private int defBoost;

    //Construtor
    public Jogador (String nome, int maxHp, int atk, int def) {
        super(nome, maxHp, atk, def);
        this.atkBoost = 0;
        this.defBoost = 0;
    }

     //Get e set item
    public Item getItem () {
        return this.equip;
    }

    public void setItem (Item x) {
        this.setAtk(this.getAtk() - this.atkBoost);
        this.setDef(this.getDef() - this.defBoost);
        
        this.equip = x;
        this.atkBoost = x.getAtk();
        this.defBoost = x.getDef();

        this.setAtk(this.getAtk() + this.atkBoost);
        this.setDef(this.getDef() + this.defBoost);
    }
    
    //Inventário
    public ArrayList<Item> listarItens () {
        return this.itens;
    }

    public void addItem (Item x) {
        itens.add(x);
    }

}