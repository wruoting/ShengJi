object shengJiCardGame {
/***
Parameters: Number of Decks
Return: Array with one value for each card
***/
  def createCardBase(numberOfDecks:Int) : Array[Array[Array[Int]]] = {
    //Create cards
    var placeholderNumberOfDecks=numberOfDecks
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
    val seedNumber=4*13*cardBase(0)(0).length
    val randomCards=scala.util.Random.shuffle((1 to seedNumber).toList)
      println(randomCards)

    for(i <- 0 to randomCards.length-1) {
      
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
      "OnBoard" -> 1,
      "FaceDown" -> 2,
      "PlayedCards" -> 3,
      "P1Hand" -> 4,
      "P2Hand" -> 5,
      "P3Hand" -> 6,
      "P4Hand" -> 7,
      "P1Start" -> 8,
      "P2Start" -> 10,
      "P3Start" -> 12,
      "P4Start" -> 14
    )
    //Subject to change, and based off user input
    //Type Int
    var numberOfDecks=2
    //Build deck, parameters are number of decks
    //Type Int[][]
    var cardBase = createCardBase(numberOfDecks)

    var gameState= true
    var trumpCard= 2

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
