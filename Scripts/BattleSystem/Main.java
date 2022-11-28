import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Jogador j1 = new Jogador("Jogador", 250, 20, 30);
        Inimigo i1 = new Inimigo ("Monstrinho", 300, 30, 20, 0);
        Scanner in = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.println("Escolha o nome do jogador:");
        j1.setNome(in.nextLine());

        Batalha b = new Batalha (j1, i1);

        b.iniciarBatalha();
    }

}