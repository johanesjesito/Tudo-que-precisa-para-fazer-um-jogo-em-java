package jogo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Sprite{
	
	public static String imagem;
	
	BufferedImage spriteSheet;

	public int width, height;
	public int rows, columns;
	public int posX;

	public int posY;
	public BufferedImage[] sprites;
	public int aparencia;
	
	public ArrayList<Rectangle> collision = new ArrayList<Rectangle>();
	
	public Sprite(String arquivo, int aparencia, int width, int height, int columns, int rows, int posX, int posY) throws IOException {
		spriteSheet = ImageIO.read(getClass().getClassLoader().getResourceAsStream(arquivo));
		this.aparencia=aparencia;
		this.width = width;
		this.height = height;
		this.rows = columns;
		this.columns = rows;
		this.posX=posX;
		this.posY=posY;

		sprites = new BufferedImage[columns * rows];
		for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * width, j * height, width, height);
			}
		}
		
		//usada para inimigo
		//tem que ser modificado dependendo do tamanho do personagem(tamanho inicial X,
		// tamanho inicial Y, tamanho final X, tamanho final Y);
		collision.add(new Rectangle(posX+(width*1/3), posY+(height*4/5), width*1/3, height*1/5));

	}
	
	public boolean collision(ArrayList<Rectangle> tmp, int x,int y) {
		//tem que ser modificado dependendo do tamanho do personagem(tamanho inicial X,
		// tamanho inicial Y, tamanho final X, tamanho final Y);
		Rectangle personagem=new Rectangle(posX+x+(width*1/3), posY+y+(height*4/5), width*1/3, height*1/5);
		for (Rectangle rectangle : tmp) {
			if(rectangle.intersects(personagem)){
				return true;
			}		
		}
		return false;
	}
	
}