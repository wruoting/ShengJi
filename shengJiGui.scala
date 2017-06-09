//package simpleslickgame;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

class ShengJiGui extends BasicGame("Sheng Ji") {

	@throws(classOf[SlickException])
	override def init(gc: GameContainer) {
		var windowHeight = gc.getHeight()
		var windowWidth = gc.getWidth()
	}

	@throws(classOf[SlickException])
	override def update(gc: GameContainer, i: Int) {

	}

	@throws(classOf[SlickException])
	override def render(gc: GameContainer, g: Graphics) {
		var testImage = new Image("E:/Programming/Java/ShengJi/ShengJi/image/2_of_clubs.png")
		var newImage=testImage.getScaledCopy(100,200)
		newImage.draw(100,100)

	}

	def loadGameGui {
		    try {
					val appgc = new AppGameContainer(new ShengJiGui())
					appgc.setDisplayMode(700, 700, false)
					appgc.setTargetFrameRate(70)
					appgc.start()
				}
				catch {
					case ex: SlickException => Logger.getLogger(this.getClass.getName()).log(Level.SEVERE, null, ex);
				}
	}
}
