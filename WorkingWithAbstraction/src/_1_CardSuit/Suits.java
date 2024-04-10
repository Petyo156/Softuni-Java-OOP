package _1_CardSuit;

public enum Suits {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    public static void print(){
        System.out.println("Card Suits:");
        for (Suits suit:Suits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}
