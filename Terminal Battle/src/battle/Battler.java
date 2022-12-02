package battle;
//Classe básica para inimigos e jogador
public abstract class Battler {

    private String nome;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;
    public boolean defendendo;

    //Construtor
    public Battler (String nome, int maxHp, int atk, int def) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.hp = maxHp;//começa com HP cheio
        this.atk = atk;
        this.def = def;
    }

    //Gets e sets
    public String getNome () {
        return this.nome;
    }

    public void setNome (String x) {
        this.nome = x;
    }

    public int getMaxHp () {
        return this.maxHp;
    }

    public void setMaxHp (int x) {
        this.maxHp = x;
    }

    public int getHp () {
        return this.hp;
    }

    public void setHp (int x) {
        this.hp = x;
    }

    public int getAtk () {
        return this.atk;
    }

    public void setAtk (int x) {
        this.atk = x;
    }

    public int getDef () {
        return this.def;
    }

    public void setDef (int x) {
        this.def = x;
    }

    //Aumenta ou diminui o HP desta unidade
    public void ajustarHp (int x) {
        if (this.defendendo) x /= 2;
        this.hp += x;
        if (this.hp < 0) {
            this.setHp(0);
        }
    }

    //Aumenta ou diminui o HP de outra unidade
    public void atacar (Battler alvo) {
        int formula = this.getAtk() * 2 - alvo.getDef();
        if (formula < 5) formula = 5;
        alvo.ajustarHp(-formula);
    }

    //Usa o turno para defender-se
    public void defender () {
        this.defendendo = true;
    }

    //Checa se a unidade chegou em zero
    public boolean morto () {
        return (this.getHp() <= 0);
    }

}