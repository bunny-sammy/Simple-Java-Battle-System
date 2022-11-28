import java.util.Scanner;

//Classe que controla o fluxo da batalha
public class Batalha {
    
    private Jogador jogador;
    private Inimigo inimigo;
    String logTexto;
    Scanner entrada = new Scanner(System.in);
    int acao = 0;

    //Construtor
    public Batalha (Jogador jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    //Limpa o console e desenha a batalha novamente
    public void desenharTela () {
        System.out.println("");
        System.out.println(this.inimigo.getSprite());
        System.out.println(this.inimigo.getNome()
                         + "            "
                         + this.jogador.getNome());
        System.out.println("Vida: " + this.inimigo.getHp() + "/" + this.inimigo.getMaxHp()
                          + "        "
                          + "Vida: " + this.jogador.getHp() + "/" + this.jogador.getMaxHp());
        System.out.println("ATK: " + this.inimigo.getAtk() + " DEF: " + this.inimigo.getDef()
                        + "    "
                        + "ATK: " + this.jogador.getAtk() + " DEF: " + this.jogador.getDef());
    }

    //Escreve algo no log
    public void mostrarLog(String x) {
        System.out.println("");
        System.out.println(x);
    }

    public void iniciarBatalha () {
        logTexto = this.inimigo.getNome() + " se aproxima!";
        iniciarTurno();
    }
    
    //Inicializa o turno
    public void iniciarTurno () {
        System.out.print("\033[H\033[2J");//comando ASCII para limpar o console
        mostrarLog(logTexto);
        desenharTela();
        menuAcoes();
    }

    //Escreve
    public void menuAcoes () {
        System.out.println("");
        System.out.println("O que " + this.jogador.getNome() + " vai fazer?");
        System.out.println("[1] Atacar");
        System.out.println("[2] Defender");
        System.out.println("[3] Equipar");
        acao = entrada.nextInt();
    }

    //Ao fim do turno checa se alguma unidade morreu
    public void fimTurno() {
        if (!this.inimigo.estado()) {
            //Vencer se o inimigo morreu
            fimBatalha(true);
        } else if (!this.inimigo.estado()) {
            //Perder se o jogador morreu
            fimBatalha(false);
        } else {
            //Iniciar o próximo turno se não
            iniciarTurno ();
        }
    }

    public void fimBatalha (boolean vitoria) {
        System.out.print("\033[H\033[2J");//comando ASCII para limpar o console
        if (vitoria) {
            System.out.println("Você venceu!!");
        } else {
            System.out.println("Você perdeu...");
        }
    }
    
}
