package battle;
import java.util.ArrayList;

public class Loja {
    public static ArrayList<Item> itens = new ArrayList<>();

    public static void addItem(Item x) {
        itens.add(x);
    }

    //Lojina :)
    public static void loja(Jogador jogador) {
        System.out.print(Main.CLEAR_CONSOLE);
        System.out.print(Main.CLEAR_CONSOLE);
        System.out.println("");
        System.out.println("LOJA:");
        System.out.println("Dinheiro: " + Main.ANSI_YELLOW + jogador.getDinheiro() + Main.ANSI_RESET + " Coin");
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
                System.out.println("    Preço: " + Main.ANSI_YELLOW + item.getPreco() + Main.ANSI_RESET + " Coin");
            } else {
                System.out.println(Main.ANSI_GREEN + "    (Adquirido)" + Main.ANSI_RESET);
            }
        }
    
        System.out.println("");
        System.out.println("Selecione um item para comprar:");
        
        int comprar = 0;
        try {
            comprar = Main.in.nextInt();
        } catch (java.util.InputMismatchException e) {
            //Exceção: Entrada não é int
            System.out.println("Entrada inválida.");
            Main.esperarEnter();
            loja(jogador);
        }

        if (comprar > 0 && comprar <= itens.size()) {
            Item comprado = itens.get(comprar - 1);
            if (jogador.getDinheiro() >= comprado.getPreco()) {
                if (!jogador.listarItens().contains(comprado)) {
                    jogador.addDinheiro(-comprado.getPreco());
                    //Checar se é cura
                    if (comprado.getNome().equals("Restaurar")) {
                        jogador.setHp(jogador.getMaxHp());
                    } else {
                        jogador.addItem(comprado);
                    }
                } else {
                    System.out.println("Você já tem este item.");
                    Main.esperarEnter();
                    comprar = 0;
                    loja(jogador);
                }
            } else {
                System.out.println(Main.ANSI_RED + "Sem dinheiro suficiente." + Main.ANSI_RESET);
                Main.esperarEnter();
                comprar = 0;
                loja(jogador);
            }
        } else {
            if (comprar != 0) {
                //Exceção: Entrada fora do range esperado
                System.out.println("Item inválido.");
                Main.esperarEnter();
                comprar = 0;
                loja(jogador);
            }
        }
    }
}
