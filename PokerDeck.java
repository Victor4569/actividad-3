import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerDeck {
    public static class Card {
        private String palo;
        private String color;
        private String valor;

        public Card(String palo, String color, String valor) {
            this.palo = palo;
            this.color = color;
            this.valor = valor;
        }

        public String getPalo() {
            return palo;
        }

        public String getColor() {
            return color;
        }

        public String getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return palo + "," + color + "," + valor;
        }
    }

    public static class Deck {
        private List<Card> cartas = new ArrayList<>();

        public Deck() {
            String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
            String[] colores = {"Negro", "Rojo"};
            String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

            for (String palo : palos) {
                String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? "Rojo" : "Negro";
                for (String valor : valores) {
                    cartas.add(new Card(palo, color, valor));
                }
            }
        }

        public void shuffle() {
            Collections.shuffle(cartas);
            System.out.println("Se mezcló el Deck.");
        }

        public void head() {
            if (cartas.isEmpty()) {
                System.out.println("El Deck está vacío.");
                return;
            }
            Card card = cartas.remove(0);
            System.out.println(card);
            System.out.println("Quedan " + cartas.size() + " cartas en el Deck.");
        }

        public void pick() {
            if (cartas.isEmpty()) {
                System.out.println("El Deck está vacío.");
                return;
            }
            int index = (int) (Math.random() * cartas.size());
            Card card = cartas.remove(index);
            System.out.println(card);
            System.out.println("Quedan " + cartas.size() + " cartas en el Deck.");
        }

        public void hand() {
            if (cartas.size() < 5) {
                System.out.println("No hay suficientes cartas en el Deck para obtener una mano.");
                return;
            }
            System.out.println("Mano de 5 cartas:");
            for (int i = 0; i < 5; i++) {
                Card card = cartas.remove(0);
                System.out.println(card);
            }
            System.out.println("Quedan " + cartas.size() + " cartas en el Deck.");
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}
