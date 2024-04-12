package codingProjectWar;

import java.util.ArrayList;
import java.util.List;

public class Player {
  
  private String name;
  private List<Card> hand;
  private int score;

  public Player(String name) {
      this.name = name;
      hand = new ArrayList<>();
      score = 0;
  }

  public void addCard(Card card) {
      hand.add(card);
  }

  public Card playCard() {
      if (hand.isEmpty()) {
          return null; // Player has no cards
      }
      return hand.remove(0);
  }

  public void collectCards(List<Card> cards) {
      hand.addAll(cards);
  }

  public boolean hasCards() {
      return !hand.isEmpty();
  }

  public int getHandSize() {
      return hand.size();
  }

  public String getName() {
      return name;
  }

  public int getScore() {
      return score;
  }

  public void incrementScore() {
      score++;
  }
}