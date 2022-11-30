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

    //Lojina :)
    public static void loja(Jogador jogador, ArrayList<Item> itens) {
        System.out.print(CLEAR_CONSOLE);
        System.out.print(CLEAR_CONSOLE);
        System.out.println("");
        System.out.println("LOJA:");
        System.out.println("Dinheiro: " + ANSI_YELLOW + jogador.getDinheiro() + ANSI_RESET + " Coin");
        System.out.println("");
        
        int itemIndice = 0;
        System.out.println("[0] Não comprar nada");
        for (Item item : itens) {
            itemIndice++;
            System.out.println("[" + itemIndice + "] " + item.getNome());
            if (item.getDesc() != null) {
                System.out.println("    " + item.getDesc());
            }
            System.out.println("    ATK+: " + item.getAtk() + " DEF+: " + item.getDef());
            if (!jogador.listarItens().contains(item)) {
                System.out.println("Preço: " + ANSI_YELLOW + item.getPreco() + ANSI_RESET + " Coin");
            } else {
                System.out.println("Adquirido");
            }
        }
    
        System.out.println("");
        System.out.println("Selecione um item para comprar:");
        
        int comprar = in.nextInt();
        System.out.println("comprar");
        if (comprar > 0) {
            Item comprado = itens.get(comprar - 1);
            if (jogador.getDinheiro() >= comprado.getPreco()) {
                if (!jogador.listarItens().contains(comprado)) {
                    jogador.addDinheiro(-comprado.getPreco());
                    jogador.addItem(comprado);
                } else {
                    System.out.println("Você já tem este item.");
                    in.nextLine();
                    String vazio = in.nextLine();
                    loja(jogador, itens);
                }
            } else {
                System.out.println("Você é " + ANSI_RED + "POBRE." + ANSI_RESET);
                in.nextLine();
                String vazio = in.nextLine();
                loja(jogador, itens);
            }
        }
    }

    public static void main (String[] args) {
        Jogador jogador = new Jogador("Jogador", 400, 20, 30);
        Random random = new Random();
        int randomMonstro = 0;

        ArrayList<Inimigo> monstros = new ArrayList<>();
        monstros.add(new Inimigo ("Formiga", 300, 40, 20, 0));
        monstros.add(new Inimigo("Tatataruga", 400, 20, 35, 1));
        monstros.add(new Inimigo ("Minhoquinha", 150, 30, 20, 2));
        monstros.add(new Inimigo("Caracool", 250, 35, 35, 3));
        monstros.add(new Inimigo("Aranha-ranha", 150, 50, 10, 4));
        monstros.add(new Inimigo("Powovo", 400, 20, 50, 5));

        ArrayList<Item> lojaItens = new ArrayList<>();
        lojaItens.add(new Item("Resturar", "Restaura 100% do HP do jogador para a próxima luta.", 0, 0, 120));
        lojaItens.add(new Item("Espada Leve", 15, 0, 50));
        lojaItens.add(new Item("Armadura Leve", 0, 15, 50));
        lojaItens.add(new Item("Espadão", 30, -10, 80));
        lojaItens.add(new Item("Armadura Pesada", -10, 30, 80));
        lojaItens.add(new Item("Escudo", "Um escudo que pode ser usado ofensivamente.", 5, 10, 65));

        System.out.print(CLEAR_CONSOLE);
        System.out.println("Escolha o nome do jogador:");
        jogador.setNome(in.nextLine());

        Batalha b = new Batalha(null, null);
        do {
            loja(jogador, lojaItens);
            randomMonstro = random.nextInt(monstros.size());
            b = new Batalha (jogador, monstros.get(randomMonstro));
            b.iniciarBatalha();
        }
        while (b.querContinuar());
       
    }

}