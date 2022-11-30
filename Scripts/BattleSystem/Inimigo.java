import java.util.ArrayList;

public class Inimigo extends Battler {
    
    private int tipo;
    private String sprite;
    private int recompensa;

    //Construtor completo
    public Inimigo (String nome, int maxHp, int atk, int def, int tipo, int recompensa) {
        super(nome, maxHp, atk, def);
        this.tipo = tipo;
        criarSprite();
        this.recompensa = recompensa;
    }

    //Construtor sem tipo de sprite
    public Inimigo (String nome, int maxHp, int atk, int def, int tipo) {
        super(nome, maxHp, atk, def);
        this.tipo = tipo;
        criarSprite();
        this.recompensa = 50;
    }

    //Get e set
    public int getRecompensa () {
        return this.recompensa;
    }

    public void setRecompensa (int x) {
        this.recompensa = x;
    }

    //Cria uma sprite ASCII a ser impressa no console
    //Créditos das sprites: https://github.com/ZacharyPatten/dotnet-console-games/issues/48
    public void criarSprite() {
        switch (tipo) {
            case 0:
                sprite = """
                                          ─┐ ┌─
                                          ╭┴─┴╮
                                    ╭──╭──│⁰_⁰│
                                    ╰┬┬╰┬┬╰┬─┬╯
                                     └└ └└ └ └ 
                        """;
                break;
            case 1:
                sprite = """
                                         ╭─────╮
                                   ╭───╮_│⁰ ˄˄˄┤
                                   ╰U─U╯‾╰─────╯
                        """;
                break;
            case 2:
                sprite = """
                                           ╭────╮
                                           │ ⁰_⁰│
                                ╭───╮ ╭───╮╰─╮╭─╯
                                ││‾││_││‾││__││  
                                ╰╯ ╰───╯ ╰────╯  
                        """;
                break;
            case 3:
                sprite = """
                                        ╭─┬──┬─╮
                                    ◦╮╭◦├ ╭─┴╮ ┤
                                    ╭┴┴─┼ ╰┬ ├ │
                                    │⁰_⁰╰┬┼─┬╯ ┤
                                    ╰┬┬┬┬┴─┴─┴─╯
                        """;
            case 4:
                sprite = """
                                    ╔═╭─────╮═╗
                                    ╔═│╭───╮│═╗
                                    ╔═╰│⁰_⁰│╯═╗
                                       ╰╥═╥╯
                                        ╰ ╯
                        """;
                break;
            default:
                sprite = """
                                      ╭───╮
                                      │⁰_⁰│
                                     ╭╰───╯─╮
                                     │╭╮╭╮╭╮│
                                     ││││││││
                                     ╰╰╰╯╰╯╯╯
                        """;

        }
    }

    public String getSprite () {
        return sprite;
    }

}