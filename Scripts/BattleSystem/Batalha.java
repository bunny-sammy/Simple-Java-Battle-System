import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

//Classe que controla o fluxo da batalha
public class Batalha {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String CLEAR_CONSOLE = "\033[H\033[2J";

    private Jogador jogador;
    private Inimigo inimigo;
    private boolean continuar;
    //String logTexto;
    ArrayList<String> logTexto = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);
    Random random = new Random();
    int acaoJ = 0;
    int acaoI = 0;

    //Construtor
    public Batalha (Jogador jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    //Limpa o console e desenha a batalha novamente
    public void desenharTela () {
        System.out.println("");
        System.out.println(ANSI_RED + this.inimigo.getSprite() + ANSI_RESET);
        System.out.println(this.inimigo.getNome()
                         + "            "
                         + this.jogador.getNome());
        System.out.println("Vida: " + ANSI_RED + this.inimigo.getHp() + "/" + this.inimigo.getMaxHp()
                          + ANSI_RESET + "        "
                          + "Vida: " + ANSI_GREEN + this.jogador.getHp() + "/" + this.jogador.getMaxHp() + ANSI_RESET);
        System.out.println("ATK: " + this.inimigo.getAtk() + " DEF: " + this.inimigo.getDef()
                        + "    "
                        + "ATK: " + this.jogador.getAtk() + " DEF: " + this.jogador.getDef());
    }

    //Escreve algo no log
    public void mostrarLog() {
        System.out.println("");
        for (String text : logTexto) {
            System.out.println(text);
        }
        logTexto.clear();
    }

    public void iniciarBatalha () {
        logTexto.add(this.inimigo.getNome() + " se aproxima!");
        iniciarTurno();
    }
    
    //Inicializa o turno
    public void iniciarTurno () {
        System.out.print(CLEAR_CONSOLE);
        mostrarLog();
        desenharTela();
        jogadorAcao();
        inimigoAcao();
        executarAcoes();
        fimTurno();
    }

    //Escreve
    public void jogadorAcao () {
        System.out.println("");
        System.out.println("O que " + this.jogador.getNome() + " vai fazer?");
        System.out.println("[1] Atacar");
        System.out.println("[2] Defender");
        System.out.println("[3] Equipar");
        acaoJ = entrada.nextInt();

        //Equipar
        if (acaoJ == 3) {
            menuEquipar(this.jogador.listarItens());
        }
    }

    //Função chamada para decidir a ação da unidade
    public void inimigoAcao () {
        acaoI = random.nextInt(5);
    }

    //Executa as ações ao mesmo tempo
    public void executarAcoes() {
        //Defender
        if (acaoJ == 2) {
            this.jogador.defender();
            logTexto.add(this.jogador.getNome() + " se defendeu!");
        }
        if (acaoI > 3) {
            this.inimigo.defender();
            logTexto.add(this.inimigo.getNome() + " se defendeu!");
        }
        //Atacar
        if (acaoJ == 1) {
            this.jogador.atacar(this.inimigo);
            logTexto.add(this.jogador.getNome() + " ataca " + this.inimigo.getNome() + "!");
        }
        if (acaoI <= 3) {
            this.inimigo.atacar(this.jogador);
            logTexto.add(this.inimigo.getNome() + " ataca " + this.jogador.getNome() + "!");
        }
    }

    //Cria um menu para equipar itens
    public void menuEquipar(ArrayList<Item> itens) {
        System.out.print(CLEAR_CONSOLE);
        System.out.println("");
        System.out.println("INVENTÁRIO:");
        System.out.println("");
        
        int itemIndice = 0;
        for (Item item : itens) {
            itemIndice++;
            System.out.println("[" + itemIndice + "] " + item.getNome());
            if (item.getDesc() != null) {
                System.out.println("    " + item.getDesc());
            }
            System.out.println("    ATK+: " + item.getAtk() + " DEF+: " + item.getDef());
        }
        
        System.out.println("");
        System.out.println("Selecione um item para equipar:");

        int equipar = entrada.nextInt();
        this.jogador.setItem(itens.get(equipar - 1));

        logTexto.add(this.jogador.getNome() + " equipou " + this.jogador.getItem().getNome());
    }

    //Ao fim do turno checa se alguma unidade morreu
    public void fimTurno() {
        this.jogador.defendendo = false;
        this.inimigo.defendendo = false;
        if (this.inimigo.morto()) {
            //Vencer se o inimigo morreu
            fimBatalha(true);
        } else if (this.jogador.morto()) {
            //Perder se o jogador morreu
            fimBatalha(false);
        } else {
            //Iniciar o próximo turno se não
            iniciarTurno ();
        }
    }

    //Termina a batalha e checa se quer continuar
    public void fimBatalha (boolean vitoria) {
        System.out.print(CLEAR_CONSOLE);
        if (vitoria) {
            System.out.println(ANSI_GREEN + "Você venceu!!" + ANSI_RESET);
            System.out.println("");
            System.out.println("Continuar?");
            System.out.println("[S]im, estou confiante");
            System.out.println("[N]ão, quero ir pra casa");
            entrada.nextLine();
            String simOuNao = entrada.nextLine();
            if (simOuNao.equals("S") || simOuNao.equals("s")) {
                this.continuar = true;
            } else {
                this.continuar = false;
                System.out.println("");
                System.out.println("Tchau :(");
            }
        } else {
            System.out.println(ANSI_RED + "Você perdeu..." + ANSI_RESET);
        }
    }

    public boolean querContinuar() {
        return this.continuar;
    }
    
}
