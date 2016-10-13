import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -1442798787354930462L;
	
	public static final int WIDTH = 1080, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Random r;
	private Handler handler;
	private BufferedImage imageMap;
	private Camera cam;
	private Map map;
	private BufferedImageLoader loader;

	
	public Game(){
		new Window(WIDTH, HEIGHT, "shooter game", this);
		
		handler = new Handler();
		cam = new Camera(0, 0);
		map = new Map(handler, imageMap);

		loader = new BufferedImageLoader();
		imageMap = loader.loadImage("textures/DungeounCrawlerMap1.png");	//loading map

		map.LoadImageMap(imageMap);
		
		handler.addObject(new Player(25, 25, ID.Player, handler));
		
		
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new KeyInput(handler));
	}

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running){
				render();
			}
			frames++;
				
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getID() == ID.Player){
				cam.tick(handler.object.get(i));
			}
		}
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.black);	//background
		g.fillRect(0,  0, WIDTH, HEIGHT);
		
		g2d.translate(cam.getX(), cam.getY());	//begin of cam
		
		handler.render(g);

		g2d.translate(-cam.getX(), -cam.getY());	//end of cam
	
		g.dispose();
		bs.show();
		
	}
	
	public static int clamp(int var, int min, int max){
		if(var >= max){
			return var = max;
		}else if(var <= min){
			return var = min;
		}else{
			return var;
		}
	}
	
	
	public static Color getObjectAt(int x, int y, BufferedImage image){
		
		
		int pixel = image.getRGB(x, y);
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
		
		if(red == 255 && blue == 255 && green == 255){
			return Color.WHITE;
		}else if(red == 0 && blue == 255 && green == 0){
			return Color.BLUE;
		}else if(red == 255 && blue == 0 && green == 0){
			return Color.RED;
		}else if(red == 0 && blue == 0 && green == 255){
			return Color.GREEN;
		}return null;
		
		
	}
	
	
	public static void main(String[] args){
		new Game();
	}
}