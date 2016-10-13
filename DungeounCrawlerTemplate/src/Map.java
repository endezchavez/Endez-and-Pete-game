import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Map {
	
	BufferedImageLoader loader;
	BufferedImage map;
	Handler handler;
	
	
	public Map(Handler handler, BufferedImage image){
		this.handler = handler;	
	}
		
	public void LoadImageMap(BufferedImage image){
		int width = image.getWidth();
		int height = image.getHeight();
		int[][] mapArray = new int[image.getWidth()/16][image.getHeight()/16];

		
		for(int xx = 0; xx < width; xx += 16){
			for(int yy = 0; yy < height; yy += 16){

				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				//checking map for colours
				if(red == 255 && green == 255 && blue == 255){
					mapArray[xx/16][yy/16] = 1;		//walls
				}
				else if(red == 0 && green == 255 && blue== 0){
					mapArray[xx/16][yy/16] = 2;		//door
				}else if(red == 0 && green == 0 && blue== 255){
					mapArray[xx/16][yy/16] = 3;		//floor
				}
			}
		}
		
		for(int j = 0; j < mapArray[0].length; j++){
			String str = "";

			for(int i = 0; i < mapArray.length;i++){
				str += mapArray[i][j];
				int id = mapArray[i][j];
				switch(id){
					case 1: id = 1;
						handler.addObject(new Block(i*16, j*16, ID.Block));
						break;
					case 2: id = 2;
					if(mapArray[i - 1][j] == 3 && mapArray[i + 1][j + 1] == 1){
						handler.addObject(new Floor(i*16, j*16, ID.Floor));
						handler.addObject(new Door(i*16, j*16, ID.Door, 90));
					}else if(mapArray[i + 1][j] == 3 && mapArray[i - 1][j - 1] == 1){
						handler.addObject(new Floor(i*16, j*16, ID.Floor));
						handler.addObject(new Door(i*16, j*16, ID.Door, 270));
					}else if(mapArray[i][j - 1] == 3 && mapArray[i + 1][j + 1] == 1){
						handler.addObject(new Floor(i*16, j*16, ID.Floor));
						handler.addObject(new Door(i*16, j*16, ID.Door, 180));
					}else{
						handler.addObject(new Floor(i*16, j*16, ID.Floor));
						handler.addObject(new Door(i*16, j*16, ID.Door, 0));
					}
						break;
					case 3: id = 3;
						handler.addObject(new Floor(i*16, j*16, ID.Floor));
						break;
					default: 

				}
			}//System.out.println(str);
		}		
	}
}
