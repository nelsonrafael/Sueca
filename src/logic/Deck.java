package logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import miscellaneous.Constants;

public class Deck {

	private Card[] deckOfCards = new Card[40];

	private BufferedImage[] imagesOfCards = new BufferedImage[40];

	private BufferedImage[] cardBacks = new BufferedImage[2];

	public Deck() {
		loadImages();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				int valor = 0;
				switch (j) {
				case 5:
					valor = 2;
					break;
				case 6:
					valor = 3;
					break;
				case 7:
					valor = 4;
					break;
				case 8:
					valor = 10;
					break;
				case 9:
					valor = 11;
					break;
				default:
					break;
				}
				this.deckOfCards[i * 10 + j] = new Card(j, i, valor, imagesOfCards[i * 10 + j]);
			}
		}
	}

	private void loadImages() {
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = ImageIO.read(new File(Constants.spriteSheetLocationString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int width = 71;
		int height = 96;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				switch (j) {
				case 5:
					imagesOfCards[i * 10 + j] = spriteSheet.getSubimage(792, i * height, width, height);
					break;
				case 6:
					imagesOfCards[i * 10 + j] = spriteSheet.getSubimage(720, i * height, width, height);
					break;
				case 7:
					imagesOfCards[i * 10 + j] = spriteSheet.getSubimage(864, i * height, width, height);
					break;
				case 8:
					imagesOfCards[i * 10 + j] = spriteSheet.getSubimage(432, i * height, width, height);
					break;
				case 9:
					imagesOfCards[i * 10 + j] = spriteSheet.getSubimage(0, i * height, width, height);
					break;
				default:
					imagesOfCards[i * 10 + j] = spriteSheet.getSubimage((j + 1) * (width + 1), i * height, width,
							height);
					break;
				}
			}
		}

		cardBacks[0] = spriteSheet.getSubimage(936, 0, width, height);
		cardBacks[1] = spriteSheet.getSubimage(936, 96, width, height);
	}

	public BufferedImage[] getCardBacks() {
		return this.cardBacks;
	}

	public Card[] getDeckOfCards() {
		return this.deckOfCards;
	}

	public void Shuffle() {
		Random rnd = ThreadLocalRandom.current();
		for (int i = deckOfCards.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Card tempcard = this.deckOfCards[index];
			deckOfCards[index] = deckOfCards[i];
			deckOfCards[i] = tempcard;
		}
	}

}
