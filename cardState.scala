
  object cardState{
    //Create mapping
    def
    val cardState=Map(
      "InDeck" -> 0,
      "FaceDown" -> 1,
      "PlayedCards" -> 2,
      "P1Hand" -> 4,
      "P2Hand" -> 5,
      "P3Hand" -> 6,
      "P4Hand" -> 7,
      "P1Start" -> 8,
      "P2Start" -> 10,
      "P3Start" -> 12,
      "P4Start" -> 14,
      "P1OnBoard" -> 16,
      "P2OnBoard" -> 20,
      "P3OnBoard" -> 24,
      "P4OnBoard" -> 28
    )
    //Card mapping
    val valToCard=Map (
      0 -> 2,
      1 -> 3,
      2 -> 4,
      3 -> 5,
      4 -> 6,
      5 -> 7,
      6 -> 8,
      7 -> 9,
      8 -> 10,
      9 -> "J",
      10 -> "Q",
      11 -> "K",
      12 -> "A"
    )
    //S
  }
