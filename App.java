package codingProjectWar;
  
import java.util.List;

public class App {
  
  public static void main(String[] args) {
    
      Deck deck = new Deck();
      deck.shuffle();

      Player player1 = new Player("Player 1");
      Player player2 = new Player("Player 2");

      // Deal cards to players
      while (!deck.isEmpty()) {
          player1.addCard(deck.dealCard());
          player2.addCard(deck.dealCard());
      }

      // Play the game and keep score
      int rounds = 0;
      while (player1.hasCards() && player2.hasCards()&& rounds < 26) {
          Card card1 = player1.playCard();
          Card card2 = player2.playCard();

          System.out.println(player1.getName() + " plays: " + card1);
          System.out.println(player2.getName() + " plays: " + card2);

          int comparison = compareCards(card1, card2);
          if (comparison > 0) {
              player1.collectCards(List.of(card1, card2));
              player1.incrementScore(); // Player 1 wins the round
          } else if (comparison < 0) {
              player2.collectCards(List.of(card1, card2));
              player2.incrementScore(); // Player 2 wins the round
          }
          rounds++;
      }

      // Determine the winner and display scores
      int player1Score = player1.getScore();
      int player2Score = player2.getScore();
      System.out.println("Player 1's score: " + player1Score);
      System.out.println("Player 2's score: " + player2Score);
      if (player1Score > player2Score) {
          System.out.println(player1.getName() + " wins!");
      } else if (player1Score < player2Score) {
          System.out.println(player2.getName() + " wins!");
      } else {
          System.out.println("It's a tie!");
      }
  }

  private static int compareCards(Card card1, Card card2) {
      int rank1 = getCardRank(card1);
      int rank2 = getCardRank(card2);
      return Integer.compare(rank1, rank2);
  }

  private static int getCardRank(Card card) {
      String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
      String rank = card.toString().split(" ")[0];
      for (int i = 0; i < ranks.length; i++) {
          if (rank.equals(ranks[i])) {
              return i + 2; // Add 2 to convert from index to rank value
          }
      }
      return -1; // Error case
  }
}