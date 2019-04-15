package logic;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import miscellaneous.Constants;

public class Deck {

	private Card[] deckOfCards = new Card[40];

	private BufferedImage[] imagesOfCardsDown = new BufferedImage[40];

	private BufferedImage[] imagesOfCardsUp = new BufferedImage[40];

	private BufferedImage[] imagesOfCardsLeft = new BufferedImage[40];

	private BufferedImage[] imagesOfCardsRight = new BufferedImage[40];

	private BufferedImage[] cardBackFront = new BufferedImage[2];

	private BufferedImage[] cardBackSide = new BufferedImage[2];

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
				this.deckOfCards[i * 10 + j] = new Card(j, i, valor, imagesOfCardsDown[i * 10 + j],
						imagesOfCardsUp[i * 10 + j], imagesOfCardsLeft[i * 10 + j], imagesOfCardsRight[i * 10 + j]);
			}
		}
	}

	public Card[] dealCards(int p) {
		Card[] temp = new Card[10];
		for (int i = 10; i > 0; i--) {
			temp[10 - i] = deckOfCards[p * 10 + 10 - i];
		}
		return temp;
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

		BufferedImage tempImage;
		AffineTransform affineTransform;
		AffineTransformOp affineTransformOp;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				int k = i * 10 + j;
				switch (j) {
				case 5:
					imagesOfCardsDown[k] = spriteSheet.getSubimage(792, i * height, width, height);
					break;
				case 6:
					imagesOfCardsDown[k] = spriteSheet.getSubimage(720, i * height, width, height);
					break;
				case 7:
					imagesOfCardsDown[k] = spriteSheet.getSubimage(864, i * height, width, height);
					break;
				case 8:
					imagesOfCardsDown[k] = spriteSheet.getSubimage(432, i * height, width, height);
					break;
				case 9:
					imagesOfCardsDown[k] = spriteSheet.getSubimage(0, i * height, width, height);
					break;
				default:
					imagesOfCardsDown[k] = spriteSheet.getSubimage((j + 1) * (width + 1), i * height, width, height);
					break;
				}

				affineTransform = new AffineTransform();
				affineTransform.translate(imagesOfCardsDown[k].getHeight() / 2, imagesOfCardsDown[k].getWidth() / 2);
				affineTransform.rotate(Math.PI / 2);
				affineTransform.translate(-imagesOfCardsDown[k].getWidth() / 2, -imagesOfCardsDown[k].getHeight() / 2);
				affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
				tempImage = new BufferedImage(imagesOfCardsDown[k].getHeight(), imagesOfCardsDown[k].getWidth(),
						imagesOfCardsDown[k].getType());
				affineTransformOp.filter(imagesOfCardsDown[k], tempImage);
				imagesOfCardsRight[k] = tempImage;

				affineTransform = new AffineTransform();
				affineTransform.translate(imagesOfCardsDown[k].getHeight() / 2, imagesOfCardsDown[k].getWidth() / 2);
				affineTransform.rotate(Math.PI);
				affineTransform.translate(-imagesOfCardsDown[k].getWidth() / 2, -imagesOfCardsDown[k].getHeight() / 2);
				affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
				tempImage = new BufferedImage(imagesOfCardsDown[k].getWidth(), imagesOfCardsDown[k].getHeight(),
						imagesOfCardsDown[k].getType());
				affineTransformOp.filter(imagesOfCardsDown[k], tempImage);
				imagesOfCardsUp[k] = tempImage;

				affineTransform = new AffineTransform();
				affineTransform.translate(imagesOfCardsDown[k].getHeight() / 2, imagesOfCardsDown[k].getWidth() / 2);
				affineTransform.rotate(Math.PI * 3 / 2);
				affineTransform.translate(-imagesOfCardsDown[k].getWidth() / 2, -imagesOfCardsDown[k].getHeight() / 2);
				affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
				tempImage = new BufferedImage(imagesOfCardsDown[k].getHeight(), imagesOfCardsDown[k].getWidth(),
						imagesOfCardsDown[k].getType());
				affineTransformOp.filter(imagesOfCardsDown[k], tempImage);
				imagesOfCardsLeft[k] = tempImage;
			}
		}

		cardBackFront[0] = spriteSheet.getSubimage(936, 0, width, height);
		cardBackFront[1] = spriteSheet.getSubimage(936, 96, width, height);

		affineTransform = new AffineTransform();
		affineTransform.translate(cardBackFront[0].getHeight() / 2, cardBackFront[0].getWidth() / 2);
		affineTransform.rotate(Math.PI / 2);
		affineTransform.translate(-cardBackFront[0].getWidth() / 2, -cardBackFront[0].getHeight() / 2);
		affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
		tempImage = new BufferedImage(cardBackFront[0].getHeight(), cardBackFront[0].getWidth(),
				cardBackFront[0].getType());
		affineTransformOp.filter(cardBackFront[0], tempImage);
		cardBackSide[0] = tempImage;

		affineTransform = new AffineTransform();
		affineTransform.translate(cardBackFront[0].getHeight() / 2, cardBackFront[0].getWidth() / 2);
		affineTransform.rotate(Math.PI / 2);
		affineTransform.translate(-cardBackFront[0].getWidth() / 2, -cardBackFront[0].getHeight() / 2);
		affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
		tempImage = new BufferedImage(cardBackFront[1].getHeight(), cardBackFront[1].getWidth(),
				cardBackFront[1].getType());
		affineTransformOp.filter(cardBackFront[1], tempImage);
		cardBackSide[1] = tempImage;
	}

	public BufferedImage[] getCardBackFront() {
		return this.cardBackFront;
	}

	public BufferedImage[] getCardBackSide() {
		return this.cardBackSide;
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
