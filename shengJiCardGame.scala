//ANSI Shadow was used for headers
object shengJiCardGame extends ShengJiGui{
/***
Parameters: Number of Decks
Return: Array with one value for each card
Use: Creates an Empty CardBase
***/
  def createCardBase(numberOfDecks:Int) : Array[Array[Int]] = {
    //Create cards
    val placeholderNumberOfDecks=numberOfDecks
    //[Suit][Card]
    var cardList=Array.ofDim[Int](4,27)
      //i is the number of suits
      //j is the number of cards per suit
      //k is the number of decks from 0 to number of Decks
      //Player number is the player that will start with this card
          for(i <- 0 to 3) {
            for(j <-0 to 26) {
                cardList(i)(j)=0
            }
          }
    return cardList
  }
/***
Parameters: Default mapping of Cards, Card Base,Trump suit
Return: Array with one value for each card
***/
  def startGame(cardBase: Array[Array[Int]],trumpCard: Int,trumpSuit: Int) : Array[Array[Int]] = {
    //Start the game by distributing cards
    //One cycle of card distribution
    var distributedCardList = distributeCards(cardBase,trumpCard,trumpSuit)


    return cardBase
  }

/***
Use: To distribute cards randomly at the beginning of each cycle
Parameters: Default mapping of Cards, Card Base,Trump suit, SuitHolder
Return: Array with one value for each card
This function serves as a way of giving each player a randomly preset hand. Iterating through the array will allow you time to do trump suit shows, etc.
***/
  def distributeCards(cardBase: Array[Array[Int]],trumpCard: Int,trumpSuit: Int): Array[Array[Int]]= {
    //Create an array with each person getting a card
    //Shuffle that card base
    val seedNumber = 107
    val randomCards = scala.util.Random.shuffle((0 to seedNumber).toList)
    //Determine which deck, suit, and card each entry of the random card is, and seed with 1-4 to deal to the player
    //Set a player count and give it to a player on each iteration of the random card generator
    var playerCount = -1
    for(i <- 0 to randomCards.length-1) {
      playerCount += 1
      var innerCardIndex=randomCards(i)
      var (suitNumber,cardNumber)=(0,0)
        //Find which suit it's in
        if(innerCardIndex>=27) {
          suitNumber=(innerCardIndex-innerCardIndex%27)/27
          innerCardIndex=innerCardIndex%27
        }
        //Find out what card it is
        cardNumber=innerCardIndex

      //Now you have the random card index, in which you can give to player 1, 2, 3 or 4
      //Redefine which of the 4 players it should go to
      val realPlayerCount=playerCount%4
      cardBase(suitNumber)(cardNumber) = GlobalMappings.cardState(GlobalMappings.playerCardState(realPlayerCount))
      //Set as trump card for player if necessary
      if ((cardNumber==trumpCard || (cardNumber%13)==trumpCard) && cardNumber != 26) {
        cardBase(suitNumber)(cardNumber) = -GlobalMappings.cardState(GlobalMappings.playerCardState(realPlayerCount))
      }

      //After giving the player the card, wait 0.5 seconds, and then decide if it's a trump to show
      showCards(cardBase)
      //Build an array of only trump suit cards
      var trumpBase=Array.ofDim[Int](4,2)
        for(row <- 0 to 3) {
          for(col <- 0 to 1) {
            if(col==0) {
              trumpBase(row)(col)=cardBase(row)(trumpCard)
            }
            else {
              trumpBase(row)(col)=cardBase(row)(trumpCard+13)
            }
          }
        }


    //  actionlistener() //you might have to make some action listener here
      /*
      var trumpSuitDeclarePlayer = -1
      trumpSuitDeclarePlayer = clickPlayer(trumpBase, //return a player that "clicked". Input will be a player number, output will be if successful
      if(trumpSuitDeclarePlayer != -1) {
        var trumpStatus=interruptSuit(trumpBase,trumpCard,trumpSuitDeclarePlayer) //check to see if this player can overturn
        if (trumpStatus) {
          //change those values to onboard instead of trump
        }
      // }
      //Give player an option to overturn current suit

    }
    */
    //we will default declare a trump suit and card
    cardBase(0)(1)=8 //will have p1 start
    }
    return cardBase
}
/***
Use: To interrupt with a show of suits. Determines if there has been a shown trump suit
Parameters: Card Base,Trump suit,Current Player
Return: Array with one value for each card
***/
  def interruptSuit(cardBase: Array[Array[Int]],trumpCard: Int,currentPlayer: Int): Boolean= {
    var trumpStatus = false
    val mappedCurrentPlayer = GlobalMappings.cardState(GlobalMappings.playerCardState(currentPlayer))

    //Check if trump suit is available for current player
    return trumpStatus
  }



/***
Use: Print in console the deck(s)
Parameters: State of Cards
Return: None
***/
def showCards(cardBase: Array[Array[Int]]) {
  for(i <- 0 to 3){
    for(j <- 0 to 26) {
        if(j==26){
          println(cardBase(i)(j)+" ")
        }
        else {
          print(cardBase(i)(j)+" ")
        }
      }
    }
    println()
}


  def main(args: Array[String]){

/*
██████╗  █████╗ ██████╗  █████╗ ███╗   ███╗███████╗████████╗███████╗██████╗ ███████╗
██╔══██╗██╔══██╗██╔══██╗██╔══██╗████╗ ████║██╔════╝╚══██╔══╝██╔════╝██╔══██╗██╔════╝
██████╔╝███████║██████╔╝███████║██╔████╔██║█████╗     ██║   █████╗  ██████╔╝███████╗
██╔═══╝ ██╔══██║██╔══██╗██╔══██║██║╚██╔╝██║██╔══╝     ██║   ██╔══╝  ██╔══██╗╚════██║
██║     ██║  ██║██║  ██║██║  ██║██║ ╚═╝ ██║███████╗   ██║   ███████╗██║  ██║███████║
╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝╚══════╝

*/
    //Type Int
    val numberOfDecks=2
    //Build deck, parameters are number of decks
    //Type Int[][]
    var cardBase = createCardBase(numberOfDecks)

    var gameState= true
    var trumpCard= 0
    var trumpSuit= -1 //No trump suit in initialization

/*
██╗███╗   ██╗██╗████████╗██╗ █████╗ ██╗     ██╗███████╗ █████╗ ████████╗██╗ ██████╗ ███╗   ██╗
██║████╗  ██║██║╚══██╔══╝██║██╔══██╗██║     ██║╚══███╔╝██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║
██║██╔██╗ ██║██║   ██║   ██║███████║██║     ██║  ███╔╝ ███████║   ██║   ██║██║   ██║██╔██╗ ██║
██║██║╚██╗██║██║   ██║   ██║██╔══██║██║     ██║ ███╔╝  ██╔══██║   ██║   ██║██║   ██║██║╚██╗██║
██║██║ ╚████║██║   ██║   ██║██║  ██║███████╗██║███████╗██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║
╚═╝╚═╝  ╚═══╝╚═╝   ╚═╝   ╚═╝╚═╝  ╚═╝╚══════╝╚═╝╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝
*/
    val ui=new ShengJiGui
    ui.visible = true
    while(gameState) {
      //Initialize
      startGame(cardBase,trumpCard,trumpSuit)
      //playGame()
      gameState=false

    }

    }
}
/*
███╗   ███╗ █████╗ ██████╗ ██████╗ ██╗███╗   ██╗ ██████╗
████╗ ████║██╔══██╗██╔══██╗██╔══██╗██║████╗  ██║██╔════╝
██╔████╔██║███████║██████╔╝██████╔╝██║██╔██╗ ██║██║  ███╗
██║╚██╔╝██║██╔══██║██╔═══╝ ██╔═══╝ ██║██║╚██╗██║██║   ██║
██║ ╚═╝ ██║██║  ██║██║     ██║     ██║██║ ╚████║╚██████╔╝
╚═╝     ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝     ╚═╝╚═╝  ╚═══╝ ╚═════╝

*/
  object GlobalMappings{
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
      "P4OnBoard" -> 28,
      "P1TrumpSingle" -> -4,
      "P2TrumpSingle" -> -5,
      "P3TrumpSingle" -> -6,
      "P4TrumpSingle" -> -7,
      "P1TrumpDouble" -> -8,
      "P2TrumpDouble" -> -10,
      "P3TrumpDouble" -> -12,
      "P4TrumpDouble" -> -14
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
      12 -> "A",
      13 -> "Black Joker",
      14 -> "Red Joker"
    )
    //Suit mapping
    val suitToCard=Map (
      0->"Clubs",
      1->"Spades",
      2->"Hearts",
      3->"Diamonds"
    )
    //Player to Hand mapping
    //Given player X we give them a mapping to use for cardState
    def playerCardState(playerState: Int): String = playerState match {
      case 0 => "P1Hand"
      case 1 => "P2Hand"
      case 2 => "P3Hand"
      case 3 => "P4Hand"
    }
  }
