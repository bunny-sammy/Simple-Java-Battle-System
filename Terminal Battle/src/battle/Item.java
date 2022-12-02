package battle;
public class Item {
    
    private String nome;
    private String descricao;
    private int atk;
    private int def;
    private int preco;

    //Construtor completo
    public Item (String nome, String descricao, int atk, int def, int preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.atk = atk;
        this.def = def;
        this.preco = preco;
    }

    //Construtor simples com preço
    public Item (String nome, int atk, int def, int preco) {
        this.nome = nome;
        this.descricao = null;
        this.atk = atk;
        this.def = def;
        this.preco = preco;
    }
    
    //Construtor simples sem preço
    public Item (String nome, int atk, int def) {
        this.nome = nome;
        this.descricao = null;
        this.atk = atk;
        this.def = def;
        this.preco = 50;
    }

    //Gets e sets
    public String getNome() {
        return this.nome;
    }

    public void setNome(String x) {
        this.nome = x;
    }

    public String getDesc() {
        return this.descricao;
    }

    public void setDesc(String x) {
        this.descricao = x;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int x) {
        this.atk = x;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int x) {
        this.def = x;
    }

    public int getPreco() {
        return this.preco;
    }

}
