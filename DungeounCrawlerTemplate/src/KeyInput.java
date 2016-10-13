import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyInput extends KeyAdapter implements MouseListener {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	//constructor
	public KeyInput(Handler handler){
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
			for(int i = 0; i < handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				
					if(key == KeyEvent.VK_W){tempObject.setVelY(-2); keyDown[0] = true;}
					if(key == KeyEvent.VK_S){tempObject.setVelY(2); keyDown[1] = true;}
					if(key == KeyEvent.VK_A){tempObject.setVelX(-2); keyDown[2] = true;}
					if(key == KeyEvent.VK_D){tempObject.setVelX(2); keyDown[3] = true;}
				
			}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//key events for player 
				
				if(key == KeyEvent.VK_W)keyDown[0] = false;
				if(key == KeyEvent.VK_S)keyDown[1] = false;
				if(key == KeyEvent.VK_A)keyDown[2] = false;
				if(key == KeyEvent.VK_D)keyDown[3] = false;
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal movement
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){

				
				
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}
