public class Item {
    
    private String nome;
    private String descricao;
    private int atk;
    private int def;

    //Construtor completo
    public Item (String nome, String descricao, int atk, int def) {
        this.nome = nome;
        this.descricao = descricao;
        this.atk = atk;
        this.def = def;
    }

    //Construtor simples
    public Item (String nome, int atk, int def) {
        this.nome = nome;
        this.descricao = null;
        this.atk = atk;
        this.def = def;
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

}
