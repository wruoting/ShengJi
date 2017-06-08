//package simpleslickgame;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

class ShengJiGui extends BasicGame("Sheng Ji") {
	@throws(classOf[SlickException])
	override def init(gc: GameContainer) {
	}

	@throws(classOf[SlickException])
	override def update(gc:GameContainer, i: Int) {
	}

	@throws(classOf[SlickException])
	override def render(gc: GameContainer, g: Graphics) {
		g.drawString("Howdy!", 100, 100)
	}

	def loadGameGui {
		    try {
					val appgc = new AppGameContainer(new ShengJiGui())
					appgc.setDisplayMode(640, 480, false)
					appgc.start()
				}
				catch {
					case ex: SlickException => Logger.getLogger(this.getClass.getName()).log(Level.SEVERE, null, ex);
				}
	}
}
