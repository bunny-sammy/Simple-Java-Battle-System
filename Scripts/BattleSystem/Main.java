import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String CLEAR_CONSOLE = "\033[H\033[2J";
    public static Scanner in = new Scanner(System.in);

    //Método usado em todo o programa para esperar input do jogador
    public static void esperarEnter () {
        try{System.in.read();}
        catch(Exception e){}
    }

    public static void main (String[] args) {
        Jogador jogador = new Jogador("Jogador", 400, 20, 30, 80);
        Random random = new Random();
        int randomMonstro = 0;

        //Cria uma lista de monstros para escolher aleatoriamente como iniumigo
        ArrayList<Inimigo> monstros = new ArrayList<>();
        monstros.add(new Inimigo ("Formiga", 300, 40, 20, 0));
        monstros.add(new Inimigo("Tatataruga", 400, 20, 35, 1));
        monstros.add(new Inimigo ("Minhoquinha", 150, 30, 20, 2));
        monstros.add(new Inimigo("Caracool", 250, 35, 35, 3));
        monstros.add(new Inimigo("Aranha-ranha", 150, 50, 10, 4));
        monstros.add(new Inimigo("Powovo", 400, 20, 50, 5));

        //Cria itens que podem ser comprados pelo jogador
        Loja.addItem(new Item("Restaurar", "Restaura 100% do HP do jogador para a próxima luta.", 0, 0, 120));
        Loja.addItem(new Item("Espada Leve", 15, 0, 50));
        Loja.addItem(new Item("Armadura Leve", 0, 15, 50));
        Loja.addItem(new Item("Espadão", 30, -10, 80));
        Loja.addItem(new Item("Armadura Pesada", -10, 30, 80));
        Loja.addItem(new Item("Escudo", "Um escudo que pode ser usado ofensivamente.", 5, 10, 65));

        //Tela de título
        System.out.print(CLEAR_CONSOLE);
        System.out.println(ANSI_RED + """
            ████████╗███████╗██████╗ ███╗   ███╗██╗███╗   ██╗ █████╗ ██╗     
            ╚══██╔══╝██╔════╝██╔══██╗████╗ ████║██║████╗  ██║██╔══██╗██║     
               ██║   █████╗  ██████╔╝██╔████╔██║██║██╔██╗ ██║███████║██║     
               ██║   ██╔══╝  ██╔══██╗██║╚██╔╝██║██║██║╚██╗██║██╔══██║██║     
               ██║   ███████╗██║  ██║██║ ╚═╝ ██║██║██║ ╚████║██║  ██║███████╗
               ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝
                                                                             
                  ██████╗  █████╗ ████████╗████████╗██╗     ███████╗           
                  ██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝           
                  ██████╔╝███████║   ██║      ██║   ██║     █████╗             
                  ██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝             
                  ██████╔╝██║  ██║   ██║      ██║   ███████╗███████╗           
                  ╚═════╝ ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚══════╝╚══════╝       
                """ + ANSI_RESET);
        System.out.println("");
        System.out.println("Digite seu nome:");
        jogador.setNome(in.nextLine());

        Batalha b = new Batalha(null, null);
        do {
            Loja.loja(jogador);
            randomMonstro = random.nextInt(monstros.size());
            b = new Batalha (jogador, monstros.get(randomMonstro));
            b.iniciarBatalha();
        }
        while (b.querContinuar());
       
    }

}