import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements ActionListener {

	static final int SCREEN_WIDTH = 300;
	static final int SCREEN_HEIGHT = 1000;
	static final int UNIT_SIZE = 10;
	static final int GAME_UNITS = ((SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE);
	static int DELAY = 100;
	int x = SCREEN_WIDTH / 2; // x coordinates of the Drop
	int y = UNIT_SIZE * 5; // y coordinates of the Drop

	int birdX;
	int birdY;
	int birdWidth = 3;
	int planeX;
	int planeY;
	int planeWidth = 8;
	int planeHeight = 2;
	int ufoX;
	int ufoY;
	int ufoWidth = 6;
	int ufoHeight = 4;
	int[] mineX = new int[5];
	int[] mineY = new int[5];
	int finalTargetX;
	int finalTargetY;
	int finalTargetWidth = 0; // width of the final target
	int counter = 0;

	int rewind = 1;
	int lives = 3;
	int lvl = 0;
	int newLifeX = 0;
	int newLifeY = 0;
	int speed = 1;
	boolean left = false;
	boolean intro = true;
	boolean lifeTaken = false;
	boolean again = false;
	char direction = 'D';
	boolean falling = false;
	boolean fallingHit = false;
	boolean immortality = false;
	int immoNumber = 5;
	BufferedImage image = null;
	BufferedImage image2 = null;
	BufferedImage image3 = null;
	BufferedImage image4 = null;
	BufferedImage image5 = null;
	BufferedImage image6 = null;
	BufferedImage image7 = null;
	BufferedImage image8 = null;
	BufferedImage image9 = null;
	BufferedImage image10 = null;
	BufferedImage image11 = null;
	BufferedImage image12 = null;
	BufferedImage image13 = null;
	BufferedImage image14 = null;
	BufferedImage image15 = null;
	BufferedImage image16 = null;
	BufferedImage image17 = null;
	BufferedImage image18 = null;
	BufferedImage image19 = null;
	BufferedImage image20 = null;
	BufferedImage image21 = null;
	BufferedImage image22 = null;
	BufferedImage image23 = null;
	BufferedImage image24 = null;
	BufferedImage image25 = null;
	BufferedImage image26 = null;
	BufferedImage image27 = null;
	BufferedImage image28 = null;
	BufferedImage image29 = null;
	BufferedImage image30 = null;
	BufferedImage image31 = null;
	BufferedImage image32 = null;
	BufferedImage image33 = null;
	BufferedImage image34 = null;
	BufferedImage image35 = null;
	BufferedImage image36 = null;

	Timer timer;
	Random random;

	GamePanel() {

		try {
			File bg = new File("res/bg.png");
			image = new BufferedImage(300, 1000, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(bg);
			File bg2 = new File("res/bg2.png");
			image2 = new BufferedImage(300, 1000, BufferedImage.TYPE_INT_ARGB);
			image2 = ImageIO.read(bg2);
			File drop = new File("res/drop.png");
			image3 = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
			image3 = ImageIO.read(drop);
			File drop2 = new File("res/drop2.png");
			image4 = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
			image4 = ImageIO.read(drop2);
			File life = new File("res/life.png");
			image5 = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
			image5 = ImageIO.read(life);
			File mine = new File("res/mine.png");
			image6 = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
			image6 = ImageIO.read(mine);
			File cloud = new File("res/cloud.png");
			image7 = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
			image7 = ImageIO.read(cloud);
			File fire1px120 = new File("res/fire1px120.png");
			image8 = new BufferedImage(120, 50, BufferedImage.TYPE_INT_ARGB);
			image8 = ImageIO.read(fire1px120);
			File fire2px120 = new File("res/fire2px120.png");
			image9 = new BufferedImage(120, 50, BufferedImage.TYPE_INT_ARGB);
			image9 = ImageIO.read(fire2px120);
			File fire1px110 = new File("res/fire1px110.png");
			image10 = new BufferedImage(110, 50, BufferedImage.TYPE_INT_ARGB);
			image10 = ImageIO.read(fire1px110);
			File fire2px110 = new File("res/fire2px110.png");
			image11 = new BufferedImage(110, 50, BufferedImage.TYPE_INT_ARGB);
			image11 = ImageIO.read(fire2px110);
			File fire1px100 = new File("res/fire1px100.png");
			image12 = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
			image12 = ImageIO.read(fire1px100);
			File fire2px100 = new File("res/fire2px100.png");
			image13 = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
			image13 = ImageIO.read(fire2px100);
			File fire1px90 = new File("res/fire1px90.png");
			image14 = new BufferedImage(90, 50, BufferedImage.TYPE_INT_ARGB);
			image14 = ImageIO.read(fire1px90);
			File fire2px90 = new File("res/fire2px90.png");
			image15 = new BufferedImage(90, 50, BufferedImage.TYPE_INT_ARGB);
			image15 = ImageIO.read(fire2px90);
			File fire1px80 = new File("res/fire1px80.png");
			image16 = new BufferedImage(80, 50, BufferedImage.TYPE_INT_ARGB);
			image16 = ImageIO.read(fire1px80);
			File fire2px80 = new File("res/fire2px80.png");
			image17 = new BufferedImage(80, 50, BufferedImage.TYPE_INT_ARGB);
			image17 = ImageIO.read(fire2px80);
			File fire1px70 = new File("res/fire1px70.png");
			image18 = new BufferedImage(70, 50, BufferedImage.TYPE_INT_ARGB);
			image18 = ImageIO.read(fire1px70);
			File fire2px70 = new File("res/fire2px70.png");
			image19 = new BufferedImage(70, 50, BufferedImage.TYPE_INT_ARGB);
			image19 = ImageIO.read(fire2px70);
			File fire1px60 = new File("res/fire1px60.png");
			image20 = new BufferedImage(60, 50, BufferedImage.TYPE_INT_ARGB);
			image20 = ImageIO.read(fire1px60);
			File fire2px60 = new File("res/fire2px60.png");
			image21 = new BufferedImage(60, 50, BufferedImage.TYPE_INT_ARGB);
			image21 = ImageIO.read(fire2px60);
			File fire1px50 = new File("res/fire1px50.png");
			image22 = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
			image22 = ImageIO.read(fire1px50);
			File fire2px50 = new File("res/fire2px50.png");
			image23 = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
			image23 = ImageIO.read(fire2px50);
			File fire1px40 = new File("res/fire1px40.png");
			image24 = new BufferedImage(40, 50, BufferedImage.TYPE_INT_ARGB);
			image24 = ImageIO.read(fire1px40);
			File fire2px40 = new File("res/fire2px40.png");
			image25 = new BufferedImage(40, 50, BufferedImage.TYPE_INT_ARGB);
			image25 = ImageIO.read(fire2px40);
			File fire1px30 = new File("res/fire1px30.png");
			image26 = new BufferedImage(30, 50, BufferedImage.TYPE_INT_ARGB);
			image26 = ImageIO.read(fire1px30);
			File fire2px30 = new File("res/fire2px30.png");
			image27 = new BufferedImage(30, 50, BufferedImage.TYPE_INT_ARGB);
			image27 = ImageIO.read(fire2px30);
			File fire1px20 = new File("res/fire1px20.png");
			image28 = new BufferedImage(20, 50, BufferedImage.TYPE_INT_ARGB);
			image28 = ImageIO.read(fire1px20);
			File fire2px20 = new File("res/fire2px20.png");
			image29 = new BufferedImage(20, 50, BufferedImage.TYPE_INT_ARGB);
			image29 = ImageIO.read(fire2px20);
			File fire1px10 = new File("res/fire1px10.png");
			image30 = new BufferedImage(10, 50, BufferedImage.TYPE_INT_ARGB);
			image30 = ImageIO.read(fire1px10);
			File fire2px10 = new File("res/fire2px10.png");
			image31 = new BufferedImage(10, 50, BufferedImage.TYPE_INT_ARGB);
			image31 = ImageIO.read(fire2px10);
			File plane = new File("res/plane.png");
			image32 = new BufferedImage(80, 20, BufferedImage.TYPE_INT_ARGB);
			image32 = ImageIO.read(plane);
			File bird1 = new File("res/bird1.png");
			image33 = new BufferedImage(30, 10, BufferedImage.TYPE_INT_ARGB);
			image33 = ImageIO.read(bird1);
			File bird2 = new File("res/bird2.png");
			image34 = new BufferedImage(30, 10, BufferedImage.TYPE_INT_ARGB);
			image34 = ImageIO.read(bird2);
			File ufo1 = new File("res/ufo1.png");
			image35 = new BufferedImage(60, 40, BufferedImage.TYPE_INT_ARGB);
			image35 = ImageIO.read(ufo1);
			File ufo2 = new File("res/ufo2.png");
			image36 = new BufferedImage(60, 40, BufferedImage.TYPE_INT_ARGB);
			image36 = ImageIO.read(ufo2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		// this.setBackground(Color.white);

		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());

		startGame();

	}

	// what happens when the game starts
	public void startGame() {

		newFinalTarget();
		newBird();
		newPlane();
		newUfo();
		if (lvl > 0) {
			newAirMines();
		}
		if (!lifeTaken) {
			newLife();
		}
		falling = true;
		timer = new Timer(DELAY, this);
		timer.start();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		draw(g);
	}

	public void draw(Graphics g) {

		// if (falling) {
		// pomocná møížka
//			for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
//				g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//				g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
//
//			}

		if (lvl > 0 && lvl % 3 == 0) {
			if (y % 20 == 0)
				// this.setBackground(Color.black);
				g.drawImage(image2, 0, 0, null);
			else
				// this.setBackground(Color.white);
				g.drawImage(image, 0, 0, null);
		} else
			// this.setBackground(Color.white);
			g.drawImage(image, 0, 0, null);

		if (fallingHit == true && lvl >= 11) {
			forestSaved(g);
			if (again) {
				lvl = 0;
				restart();
				g.drawImage(image, 0, 0, null);
				lifeTaken = false;
				fallingHit = false;
			}

		}

		else if (fallingHit == true) { // after finishing level

			victory(g);

			if (again) {
				fallingHit = false;

				nextLevel();
				if (y > (UNIT_SIZE + UNIT_SIZE))

					lifeTaken = false;
				newLife();
				if (lvl > 0) {
					newAirMines();
				}
			}

		} else {

			if (falling == false && lives > 1) {

				lives--;
				newFinalTarget();
				newBird();
				newPlane();
				if (lifeTaken == false) {
					newLife();
				}
				if (lvl > 0) {
					newAirMines();
				}

				x = SCREEN_WIDTH / 2;
				y = UNIT_SIZE * 5;

				try {

					Thread.sleep(2200);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				falling = true;
				rewind = 1;
			}
			if (falling == false && lives < 2) {
				gameOver(g);
				if (again) {
					lvl = 0;
					restart();
					g.drawImage(image, 0, 0, null);
					lifeTaken = false;
				}
			} else {
				g.setColor(Color.red);
				g.setFont(new Font("Int Free", Font.ITALIC, 15));
				g.drawString("Lives (" + lives + ")", (SCREEN_WIDTH / 2 - 7 * UNIT_SIZE), // lives
						SCREEN_HEIGHT / 2 - UNIT_SIZE * 2);

				g.setColor(Color.blue);
				g.setFont(new Font("Int Free", Font.ITALIC, 15));
				g.drawString("Press UP to rewind (" + rewind + ")", (SCREEN_WIDTH / 2 - 7 * UNIT_SIZE), // rewind skill
						SCREEN_HEIGHT / 2);

				g.setColor(Color.blue);
				g.setFont(new Font("Int Free", Font.ITALIC, 15));
				g.drawString("LvL (" + (int) (lvl + 1) + ")", (SCREEN_WIDTH / 2 - 7 * UNIT_SIZE), // lvl
						SCREEN_HEIGHT / 2 - UNIT_SIZE * 4);

//				g.setColor(Color.blue);
//				g.fillOval(115, 55, UNIT_SIZE * 3, UNIT_SIZE * 3); // cloud
//				g.fillOval(140, 60, UNIT_SIZE * 3, UNIT_SIZE * 3); // cloud
//				g.fillOval(165, 55, UNIT_SIZE * 3, UNIT_SIZE * 3); // cloud
//				g.fillOval(127, 40, UNIT_SIZE * 3, UNIT_SIZE * 3); // cloud
//				g.fillOval(153, 40, UNIT_SIZE * 3, UNIT_SIZE * 3); // cloud

				finalTargetWidth = 12 - lvl;
				if (finalTargetWidth < 1)
					finalTargetWidth = 1;

				// g.setColor(Color.pink); // draw finalTarget color
				// g.fillRect(finalTargetX, finalTargetY, UNIT_SIZE * finalTargetWidth,
				// UNIT_SIZE); // location of

				switch (finalTargetWidth) {
				case 12:
					if (y % 20 == 0)
						g.drawImage(image8, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image9, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 11:
					if (y % 20 == 0)
						g.drawImage(image10, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image11, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 10:
					if (y % 20 == 0)
						g.drawImage(image12, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image13, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 9:
					if (y % 20 == 0)
						g.drawImage(image14, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image15, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 8:
					if (y % 20 == 0)
						g.drawImage(image16, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image17, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 7:
					if (y % 20 == 0)
						g.drawImage(image18, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image19, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 6:
					if (y % 20 == 0)
						g.drawImage(image20, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image21, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 5:
					if (y % 20 == 0)
						g.drawImage(image22, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image23, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 4:
					if (y % 20 == 0)
						g.drawImage(image24, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image25, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 3:
					if (y % 20 == 0)
						g.drawImage(image26, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image27, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 2:
					if (y % 20 == 0)
						g.drawImage(image28, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image29, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				case 1:
					if (y % 20 == 0)
						g.drawImage(image30, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					else
						g.drawImage(image31, finalTargetX, finalTargetY - UNIT_SIZE * 4, null);
					break;
				}

				if (y < SCREEN_HEIGHT / immoNumber) {
					// g.setColor(Color.red); // Immortality color
					// g.drawOval(x, y, UNIT_SIZE, UNIT_SIZE);

					g.drawImage(image4, x, y, null);
				} else
					g.drawImage(image3, x, y, null);

				// g.setColor(Color.blue); // draw wadrop color
				// g.fillOval(x, y, UNIT_SIZE, UNIT_SIZE); // position + color of wadrop
				g.drawImage(image7, 5, -40, null);

				if (lifeTaken == false) {
					// g.setColor(Color.blue); // draw newLIFE
					g.drawImage(image5, newLifeX, newLifeY, null);
//					g.fillOval(newLifeX, newLifeY, UNIT_SIZE, UNIT_SIZE); // position + color of newLIFE
//					g.setColor(Color.red);
//					g.drawOval(newLifeX, newLifeY, UNIT_SIZE, UNIT_SIZE);
				}
				// g.setColor(Color.red); // draw bird color
				// g.fillOval(birdX, birdY, UNIT_SIZE * birdWidth, UNIT_SIZE); // location of
				// bird

				if (y % 20 == 0) // bird
					g.drawImage(image33, birdX, birdY, null);
				else
					g.drawImage(image34, birdX, birdY, null);

				if (lvl > 6) { // Ufo
					if (y % 20 == 0)
						g.drawImage(image35, ufoX, ufoY, null);
					else
						g.drawImage(image36, ufoX, ufoY, null);
				}

				g.drawImage(image32, planeX, planeY, null); // plane

				if (lvl > 0) { // mines
					for (int i = 0; i < mineX.length; i++) {
						g.drawImage(image6, mineX[i], mineY[i], null);
					}
				}
			}
		}
	}

	// appearing of final target
	public void newFinalTarget() {

		finalTargetWidth = 12 - lvl;
		if (finalTargetWidth < 1)
			finalTargetWidth = 1;

		finalTargetX = random.nextInt((int) ((SCREEN_WIDTH) / UNIT_SIZE) - finalTargetWidth) * (UNIT_SIZE); // the
																											// middle
		finalTargetY = (int) (SCREEN_HEIGHT - UNIT_SIZE * 2 + UNIT_SIZE); // the bottom
	}

	// appearing of birds
	public void newBird() {
		birdX = SCREEN_WIDTH;
		birdY = (int) Math.floor(Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - y) + y) / UNIT_SIZE * UNIT_SIZE;
	}

	public void newPlane() {
		planeX = SCREEN_WIDTH - SCREEN_WIDTH;
		planeY = (int) Math.floor(Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - y) + y) / UNIT_SIZE * UNIT_SIZE; // plane
		// below raindrop area
	}

	public void newUfo() {
		if (lvl > 6) {
			ufoX = SCREEN_WIDTH - SCREEN_WIDTH;
			ufoY = (int) Math.floor(Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - y) + y) / UNIT_SIZE * UNIT_SIZE;
		}
	}

	public void newAirMines() {

		if (lvl > 0) {
			mineX = new int[(1 + lvl) * 2];
			mineY = new int[(1 + lvl) * 2];
			for (int i = 0; i < mineX.length; i++) {
				mineX[i] = random.nextInt((int) (SCREEN_WIDTH) / UNIT_SIZE) * UNIT_SIZE;
				mineY[i] = (int) Math.floor(
						Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - (SCREEN_HEIGHT / 9)) + (SCREEN_HEIGHT / 9))
						/ UNIT_SIZE * UNIT_SIZE;
			}
		}
	}

	public void newLife() {
		newLifeX = random.nextInt((int) (SCREEN_WIDTH) / UNIT_SIZE) * UNIT_SIZE;
		newLifeY = (int) Math
				.floor(Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - (SCREEN_HEIGHT / 6)) + (SCREEN_HEIGHT / 6))
				/ UNIT_SIZE * UNIT_SIZE;
	}

	public void moveLeftRight() {
		switch (direction) {

		case 'L':
			if (x > 0) { // Left border checker
				if (counter == 0) { // condition for prventing the drop to keep slidint to the side LEFT
					x = x - UNIT_SIZE;
					counter = 1;
				}
			}
			break;
		case 'R':
			if ((x < SCREEN_WIDTH - UNIT_SIZE)) // Right border checker

				if (counter == 0) { // condition for prventing the drop to keep slidint to the side RIGHT
					x = x + UNIT_SIZE;
					counter = 1;
				}
			break;
		case 'U':
			if (falling == true) {
				if (rewind == 1) {
					y = y - UNIT_SIZE * 10;
					rewind = 0;
				}
			}
		}
	}

	public void moveBird() {

		birdX = birdX - UNIT_SIZE * (speed);

		if (birdX < SCREEN_WIDTH - SCREEN_WIDTH - UNIT_SIZE * 4) {
			birdX = SCREEN_WIDTH + UNIT_SIZE * 3;
			birdY = (int) Math.floor(Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - y) + y) / UNIT_SIZE * UNIT_SIZE;
		}
	}

	public void movePlane() {

		planeX = planeX + UNIT_SIZE * (speed);

		if (planeX > SCREEN_WIDTH) {
			planeX = SCREEN_WIDTH - SCREEN_WIDTH - UNIT_SIZE * 7;
			planeY = (int) Math.floor(Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - y) + y) / UNIT_SIZE
					* UNIT_SIZE;
		}
	}

	public void moveUfo() {

		if (lvl > 6) {

			if (!left)
				ufoX = ufoX + UNIT_SIZE * (speed / 2);
			else
				ufoX = ufoX - UNIT_SIZE * (speed / 2);

			if (ufoX < 0 - UNIT_SIZE * 7) {
				ufoY = (int) Math.floor(Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - y) + y) / UNIT_SIZE
						* UNIT_SIZE;
				left = false;
			}
			if (ufoX > SCREEN_WIDTH) {
				ufoY = (int) Math.floor(Math.random() * ((SCREEN_HEIGHT - UNIT_SIZE * 2) - y) + y) / UNIT_SIZE
						* UNIT_SIZE;
				left = true;
			}
		}
	}

	public void moveDown() {
		y = y + UNIT_SIZE;
	}

	// FIRE check
	public void checkFinalTarget() {
		if (((x >= finalTargetX) && (x <= finalTargetX + finalTargetWidth * UNIT_SIZE - UNIT_SIZE))
				&& y == finalTargetY) {
			fallingHit = true;
		}
	}

	// collision with the ground
	public void checkCollisions() {

		if (y > SCREEN_HEIGHT - UNIT_SIZE) {// check if raindrop touches ground
			falling = false;
		}
		if (y > SCREEN_HEIGHT / immoNumber) { // Immortality at the start
			if (((x >= birdX) && (x <= birdX + birdWidth * UNIT_SIZE - UNIT_SIZE)) && y == birdY) { // check birds
				falling = false;
			}
			if (((x >= planeX) && (x <= planeX + planeWidth * UNIT_SIZE - UNIT_SIZE))
					&& ((y >= planeY) && (y <= planeY + planeHeight * UNIT_SIZE - UNIT_SIZE))) { // check planes
				falling = false;
			}

			if (((x >= ufoX) && (x <= ufoX + ufoWidth * UNIT_SIZE - UNIT_SIZE))
					&& ((y >= ufoY) && (y <= ufoY + ufoHeight * UNIT_SIZE - UNIT_SIZE))) { // check Ufo
				falling = false;
			}

			for (int i = 0; i < mineX.length; i++) { // check mines
				if (x == mineX[i] && y == mineY[i])
					falling = false;
			}
		}
		if (x == newLifeX && y == newLifeY) {
			lives++;
			lifeTaken = true;
		}

		if (!falling) {
			x = SCREEN_WIDTH / 2;
			y = UNIT_SIZE * 5;
		}
	}

	public void gameOver(Graphics g) {

		g.setColor(Color.red);
		g.setFont(new Font("Int Free", Font.BOLD, 20));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

		// g.setColor(Color.red);
		g.setFont(new Font("Int Free", Font.ITALIC, 15));
		g.drawString("'Enter' to retry ", (SCREEN_WIDTH - metrics.stringWidth("Game Ove")) / 2,
				SCREEN_HEIGHT / 2 + UNIT_SIZE * 3);
		lvl = 0;
		for (int i = 0; i < mineX.length; i++) { // destroying mines after game over
			mineX[i] = 0;
			mineY[i] = 0;
		}

	}

	public void victory(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Int Free", Font.BOLD, 20));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Victory", (SCREEN_WIDTH - metrics.stringWidth("Victory")) / 2, SCREEN_HEIGHT / 2);

		g.setFont(new Font("Int Free", Font.ITALIC, 15));
		g.drawString("'Enter' for next level ", (SCREEN_WIDTH - metrics.stringWidth("Enter' for next")) / 2,
				SCREEN_HEIGHT / 2 + UNIT_SIZE * 3);

	}

	public void forestSaved(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Int Free", Font.BOLD, 20));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("The forest has been saved!",
				(SCREEN_WIDTH - metrics.stringWidth("The forest has been saved")) / 2, SCREEN_HEIGHT / 2);

		g.setFont(new Font("Int Free", Font.ITALIC, 15));
		g.drawString("'Enter' for restart ", (SCREEN_WIDTH - metrics.stringWidth("Enter' for next")) / 2,
				SCREEN_HEIGHT / 2 + UNIT_SIZE * 3);

		for (int i = 0; i < mineX.length; i++) { // destroying mines after finishing game
			mineX[i] = 0;
			mineY[i] = 0;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (falling) {
			moveDown();
			moveLeftRight();
			checkFinalTarget();
			checkCollisions();
			movePlane();
			moveBird();
			moveUfo();
		}
		repaint();
	}

	public void restart() {
		rewind = 1;
		lives = 3;
		speed = 1;
		x = SCREEN_WIDTH / 2;
		y = UNIT_SIZE * 5;
		newFinalTarget();
		newBird();
		newPlane();
		newUfo();
		falling = true;
		again = false;
	}

	public void nextLevel() {
		rewind = 1;
		x = SCREEN_WIDTH / 2;
		y = UNIT_SIZE * 5;
		newFinalTarget();
		newBird();
		newPlane();
		newUfo();
		newAirMines();
		falling = true;
		again = false;
		lvl++;
		if (lvl < 7) {
			if (lvl % 2 == 0) {
				speed++;
			}
		}

	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			counter = 0; // counter for prventing the drop to keep sliding to the side

			switch (e.getKeyCode()) {

			case KeyEvent.VK_LEFT:
				direction = 'L';
				break;
			case KeyEvent.VK_RIGHT:
				direction = 'R';
				break;
			case KeyEvent.VK_UP:
				if (y > UNIT_SIZE * 6 && falling || y > UNIT_SIZE * 6 && !fallingHit) {

					direction = 'U';
					break;
				}
			case KeyEvent.VK_DOWN:
				direction = 'D';
				break;
			case KeyEvent.VK_ENTER:
				if (fallingHit || !falling)
					again = true;
				break;

			case KeyEvent.VK_I:

				if (!immortality) {
					immortality = true;
					immoNumber = 1;
				} else {
					immortality = false;
					immoNumber = 5;
				}

				direction = 'D';
				break;

			case KeyEvent.VK_NUMPAD1:
				DELAY = 50;
				timer.setDelay(DELAY);
				direction = 'D';
				break;
			case KeyEvent.VK_NUMPAD0:
				DELAY = 100;
				timer.setDelay(DELAY);
				direction = 'D';
				break;
			}

		}
	}

}
