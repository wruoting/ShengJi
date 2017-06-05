import scala.swing._

class ShengJiGui extends MainFrame {
  title = "ShengJi"
  preferredSize= new Dimension (320, 240)
  contents = new Label ("Game")
  defaultButton = new Button("Player 1") {println("test")}
}
