import java.util.Scanner;

public class Main {

    public static final String CLEAR_CONSOLE = "\033[H\033[2J";

    public static void main (String[] args) {
        Jogador j1 = new Jogador("Jogador", 250, 20, 30);
        Inimigo i1 = new Inimigo ("Monstrinho", 300, 30, 20, 2);
        Scanner in = new Scanner(System.in);

        j1.addItem(new Item("Espada Leve", 15, 0));
        j1.addItem(new Item("Armadura Leve", 0, 15));
        j1.addItem(new Item("Espadão", 30, -10));
        j1.addItem(new Item("Armadura Pesada", -10, 30));
        j1.addItem(new Item("Escudo", "Um escudo que pode ser usado ofensivamente.", 5, 10));

        System.out.print(CLEAR_CONSOLE);
        System.out.println("Escolha o nome do jogador:");
        j1.setNome(in.nextLine());

        Batalha b = new Batalha (j1, i1);
        b.iniciarBatalha();

        if (b.querContinuar()) {
            Inimigo i2 = new Inimigo ("Monstrão", 500, 50, 40, 5);
            Batalha b2 = new Batalha (j1, i2);
            b2.iniciarBatalha();
        }
    }

}