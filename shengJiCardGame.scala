object shengJiCardGame{
/***
Parameters: Number of Decks
Return: Array with one value for each card
Use: Creates an Empty CardBase
***/
  def createCardBase(numberOfDecks:Int) : Array[Array[Array[Int]]] = {
    //Create cards
    val placeholderNumberOfDecks=numberOfDecks
    //[Suit][Card]
    var cardList=Array.ofDim[Int](4,13,numberOfDecks)
      //i is the number of suits
      //j is the number of cards per suit
      //k is the number of decks from 0 to number of Decks
      //Player number is the player that will start with this card
        for(k <- 0 to numberOfDecks-1){
          for(i <- 0 to 3) {
            for(j <-0 to 12)  {
                cardList(i)(j)(k)=0
            }
          }
        }
    return cardList
  }

/***
Parameters: Default mapping of Cards, Card Base,Trump suit
Return: Array with one value for each card
***/
  def startGame(cardState: Map[String,Int],cardBase: Array[Array[Array[Int]]],trumpCard: Int) : Array[Array[Array[Int]]] = {
    //Start the game by distributing cards
    //One cycle of card distribution
    distributeCards(cardState,cardBase,trumpCard)
    //Give an opportunity for the trump suit to show

    return cardBase
  }

/***
Use: To distribute cards randomly at the beginning of each cycle
Parameters: Default mapping of Cards, Card Base,Trump suit, SuitHolder
Return: Array with one value for each card
***/
  def distributeCards(cardState: Map[String,Int],cardBase: Array[Array[Array[Int]]],trumpCard: Int): Array[Array[Array[Int]]]= {
    //Create an array with each person getting a card
    //Shuffle that card base
    val seedNumber=4*13*cardBase(0)(0).length-1
    val randomCards=scala.util.Random.shuffle((0 to seedNumber).toList)
      println(randomCards)
    //Determine which deck, suit, and card each entry of the random card is, and seed with 1-4 to deal to the player
    //Set a player count and give it to a player on each iteration of the random card generator
    var playerCount=0
    for(i <- 0 to randomCards.length-1) {
      playerCount+=1
      var innerCardIndex=randomCards(i)
      var (deckNumber,suitNumber,cardNumber)=(0,0,0)

      //Find which deck it's in
      if(innerCardIndex>=52) {
        deckNumber=(innerCardIndex-innerCardIndex%52)/52
        innerCardIndex=innerCardIndex%52
      }
      //Find what suit it is
      if(innerCardIndex>=13) {
        suitNumber=(innerCardIndex-innerCardIndex%13)/13
        innerCardIndex=innerCardIndex%13
      }
      //Find out what card it is
        cardNumber=innerCardIndex
      //Now you have the random card index, in which you can give to player 1, 2, 3 or 4
      //Redefine which of the 4 players it should go to (Tested to have functioned correctly)
      val realPlayerCount=playerCount%4
      def playerCardState(playerState: Int): String = playerState match {
        case 0 => "P1Hand"
        case 1 => "P2Hand"
        case 2 => "P3Hand"
        case 3 => "P4Hand"
      }
      cardBase(suitNumber)(cardNumber)(deckNumber)=cardState(playerCardState(realPlayerCount))
      //Give an opportunity for the player to
      //  interruptSuit(cardState,cardBase,trumpCard)
    }


    return cardBase
  }
/***
Use: To interrupt with a show of
Parameters: Default mapping of Cards, Card Base,Trump suit
Return: Array with one value for each card
***/
  def interruptSuit(cardState: Map[String,Int],cardBase: Array[Array[Array[Int]]],trumpCard: Int): Array[Array[Array[Int]]]= {

    return cardBase
  }

/***
Parameters: Number of Decks, State of Cards
Return: Array with one value for each card
***/

  def main(args: Array[String]){

/*
██████╗  █████╗ ██████╗  █████╗ ███╗   ███╗███████╗████████╗███████╗██████╗ ███████╗
██╔══██╗██╔══██╗██╔══██╗██╔══██╗████╗ ████║██╔════╝╚══██╔══╝██╔════╝██╔══██╗██╔════╝
██████╔╝███████║██████╔╝███████║██╔████╔██║█████╗     ██║   █████╗  ██████╔╝███████╗
██╔═══╝ ██╔══██║██╔══██╗██╔══██║██║╚██╔╝██║██╔══╝     ██║   ██╔══╝  ██╔══██╗╚════██║
██║     ██║  ██║██║  ██║██║  ██║██║ ╚═╝ ██║███████╗   ██║   ███████╗██║  ██║███████║
╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝╚══════╝

*/
    //Create mapping
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
    //Subject to change, and based off user input
    //Type Int
    val numberOfDecks=2
    //Build deck, parameters are number of decks
    //Type Int[][]
    var cardBase = createCardBase(numberOfDecks)

    var gameState= true
    var trumpCard= 0

/*
██╗███╗   ██╗██╗████████╗██╗ █████╗ ██╗     ██╗███████╗ █████╗ ████████╗██╗ ██████╗ ███╗   ██╗
██║████╗  ██║██║╚══██╔══╝██║██╔══██╗██║     ██║╚══███╔╝██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║
██║██╔██╗ ██║██║   ██║   ██║███████║██║     ██║  ███╔╝ ███████║   ██║   ██║██║   ██║██╔██╗ ██║
██║██║╚██╗██║██║   ██║   ██║██╔══██║██║     ██║ ███╔╝  ██╔══██║   ██║   ██║██║   ██║██║╚██╗██║
██║██║ ╚████║██║   ██║   ██║██║  ██║███████╗██║███████╗██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║
╚═╝╚═╝  ╚═══╝╚═╝   ╚═╝   ╚═╝╚═╝  ╚═╝╚══════╝╚═╝╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝
*/

    while(gameState) {
      //Initialize
      startGame(cardState,cardBase,trumpCard)
      //playGame()
      gameState=false

    }

    }
}



  object Mappings{
    //Create mapping

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
