//Classe básica para inimigos e jogador
public abstract class Unidade {

    private String nome;
    private int maxHp;
    private int hp;
    private int atk;
    private int def;

    //Construtor
    public Unidade (String nome, int maxHp, int atk, int def) {
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
        this.hp += x;
    }

    //Aumenta ou diminui o HP de outra unidade
    public void atacar (Unidade alvo) {
        int formula = this.getAtk() * 2 - alvo.getDef();
        alvo.ajustarHp(formula);
    }

    //Usa o turno para defender-se
    public void defender () {
        //A implementar
    }

    //Checa se a unidade chegou em zero
    public boolean estado () {
        return (this.getHp() == 0);
    }

}