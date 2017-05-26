object shengJiCardGame {
/***
Parameters: Number of Decks
Return: Array with one value for each card
***/
  def createCardBase(numberOfDecks:Int) : Array[Array[Int]] = {
    //Create cards
    var placeholderNumberOfDecks=numberOfDecks
    //[Suit][Card]
    var cardList=Array.ofDim[Int](4*numberOfDecks,13*numberOfDecks)
    while(placeholderNumberOfDecks>0) {
      for(i <- 0 to 3) {
        for(j <-0 to 12)  {
            cardList(i)(j)=0
        }
      }
      placeholderNumberOfDecks-=1
    }
    return cardList
  }

/***
Parameters: Default mapping of Cards, Number of Decks, Card Base,Trump suit
Return: Array with one value for each card
***/
  def startGame(cardState: Map[String,Int],numberOfDecks: Int,cardBase: Array[Array[Int]],trumpSuit: Int) : Array[Array[Int]] = {
    //Start the game by distributing cards
    return cardBase
  }

/***
Parameters: Default mapping of Cards, Number of Decks, Card Base,Trump suit
Return: Array with one value for each card
***/
  def distributeCards(cardState: Map[String,Int],numberOfDecks: Int,cardBase: Array[Array[Int]],trumpSuit: Int): Array[Array[Int]] = {
    
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
      "P4Hand" -> 7
    )
    //Subject to change, and based off user input
    //Type Int
    var numberOfDecks=2
    //Build deck, parameters are number of decks
    //Type Int[][]
    var cardBase = createCardBase(numberOfDecks)

    var gameState= true
    var trumpSuit= 2

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
      startGame(cardState,numberOfDecks,cardBase,trumpSuit)
      //playGame()
      gameState=false

    }

    }
}
