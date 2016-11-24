package Screens;

import Menu.GamGame1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class ScrSongOne extends InputAdapter implements Screen {

    GamGame1 game;
    private SpriteBatch batch;
    private Texture img1, img2, img3, img4;
    private Sprite sprite1, sprite2, sprite3, sprite4, spriteTL, spriteTR, spriteBL, spriteBR;
    private boolean S, p = true, isExit, k, t, pause = false, isKeyChange, isClick, isDone, bCount = true, jUp;
    private BitmapFont font;
    private Circle circ;       //p is are done? boolean
    private Color TL, TR, BL, BR;
    ShapeRenderer shapeRenderer;
    private Rectangle recTL, recTR, recBL, recBR;
    float XMid, YMid, good = 0, eff = 0, _good, _eff;
    int j = 0, count = 0, max = 90, nWhere = 0, nCount = 0, x;
    ArrayList<Rectangle> randRec = new ArrayList();
    int ars[] = null; //0 = TL, 1 = TR, 2 = BL, 3 = BR. 

    public ScrSongOne(GamGame1 _game) {
        this.game = _game;
    }

    @Override
    public void show() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        XMid = Gdx.graphics.getWidth() / 2;
        YMid = Gdx.graphics.getHeight() / 2;
        font = new BitmapFont();
        batch = new SpriteBatch();
        sprite1 = new Sprite(new Texture("Red.png"));//TL
        sprite2 = new Sprite(new Texture("Blue.png"));//TR
        sprite3 = new Sprite(new Texture("green.jpg"));//BL
        sprite4 = new Sprite(new Texture("black.jpg"));//BR
        shapeRenderer = new ShapeRenderer();
        circ = new Circle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 150);
        sprite1.setSize(w / 2, h / 2);
        sprite2.setSize(w / 2, h / 2);
        sprite3.setSize(w / 2, h / 2);
        sprite4.setSize(w / 2, h / 2);
        recTL = new Rectangle(0, 0, w / 2, h / 2);
        recTR = new Rectangle(w / 2, 0, w / 2, h / 2);
        recBL = new Rectangle(0, h / 2, w / 2, h / 2);
        recBR = new Rectangle(w / 2, h / 2, w / 2, h / 2);
        randRec.add(recTL);
        randRec.add(recTR);
        randRec.add(recBL);
        randRec.add(recBR);
        sprite1.setPosition(recTL.x, recTL.y);
        sprite2.setPosition(recTR.x, recTR.y);
        sprite3.setPosition(recBL.x, recBL.y);
        sprite4.setPosition(recBR.x, recBR.y);
        x = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (!isDone) {
            if (isKeyChange) {
                Collections.shuffle(randRec);
                sprite1.setPosition(randRec.get(0).x, randRec.get(0).y); //S1 = 0
                sprite2.setPosition(randRec.get(1).x, randRec.get(1).y); //S2 = 1
                sprite3.setPosition(randRec.get(2).x, randRec.get(2).y); //S3 = 2
                sprite4.setPosition(randRec.get(3).x, randRec.get(3).y); //S4 == 3
            }
            shapeRenderer.begin(ShapeType.Filled);
            batch.begin();
            sprite1.draw(batch);
            sprite2.draw(batch);
            sprite3.draw(batch);
            sprite4.draw(batch);
            if (isExit) {
                Gdx.app.exit();
            }
            if (randRec.get(x) == recTL) {
                if (x == 0) {
                    shapeRenderer.setColor(Color.RED);
                } else if (x == 1) {
                    shapeRenderer.setColor(Color.BLUE);
                } else if (x == 2) {
                    shapeRenderer.setColor(Color.GREEN);
                } else if (x == 3) {
                    shapeRenderer.setColor(Color.BLACK);
                }
            } else if (randRec.get(x) == recTR) {
                if (x == 0) {
                    shapeRenderer.setColor(Color.RED);
                } else if (x == 1) {
                    shapeRenderer.setColor(Color.BLUE);
                } else if (x == 2) {
                    shapeRenderer.setColor(Color.GREEN);
                } else if (x == 3) {
                    shapeRenderer.setColor(Color.BLACK);
                }
            } else if (randRec.get(x) == recBL) {
                if (x == 0) {
                    shapeRenderer.setColor(Color.RED);
                } else if (x == 1) {
                    shapeRenderer.setColor(Color.BLUE);
                } else if (x == 2) {
                    shapeRenderer.setColor(Color.GREEN);
                } else if (x == 3) {
                    shapeRenderer.setColor(Color.BLACK);
                }
            } else if (randRec.get(x) == recBR) {
                if (x == 0) {
                    shapeRenderer.setColor(Color.RED);
                } else if (x == 1) {
                    shapeRenderer.setColor(Color.BLUE);
                } else if (x == 2) {
                    shapeRenderer.setColor(Color.GREEN);
                } else if (x == 3) {
                    shapeRenderer.setColor(Color.BLACK);
                }
            }
            if (isClick && count != max) {
                nCount++;
                shapeRenderer.setColor(Color.WHITE);
                if (nCount == 4) {
                    nCount = 0;
                    isClick = false;
                }
            }
            font.draw(batch, String.valueOf(j), 200, YMid * 2);
            font.draw(batch, String.valueOf(good), 250, YMid * 2);
            font.draw(batch, String.valueOf(eff) + "%", 300, YMid * 2);
            font.draw(batch, String.valueOf(count) + " / " + String.valueOf(max), 425, YMid * 2);
            font.draw(batch, "Escape to exit", XMid - 50, 30);
            font.draw(batch, "Press Enter to show end screen!", XMid - 50, 85);
            font.draw(batch, "Space to randomize colour location", XMid - 50, 55);
            batch.end();
            if (bCount) {
                count++;
            }
            if (count == max && !isClick) {
                if (!jUp) {
                    j++;
                    jUp = true;
                }
                bCount = false;
                nCount++;
                shapeRenderer.setColor(Color.WHITE);
                if (nCount == 4) {
                    count = 0;
                    nCount = 0;
                    jUp = false;
                    bCount = true;
                }
            }
            shapeRenderer.circle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 150);
            shapeRenderer.end();
            isKeyChange = false;
        } else {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            p = false;
            batch.begin();
            font.draw(batch, "You clicked correctly " + String.valueOf(good) + " times out of " + String.valueOf(j), 250, YMid + 100);
            font.draw(batch, "Your efficiency was " + String.valueOf(eff) + "%", 250, YMid);
            font.draw(batch, "Press Escape to Exit", 250, YMid - 200);
            font.draw(batch, "Left Click to Continue", 250, YMid - 150);
            font.draw(batch, "Right Click to Restart", 250, YMid - 100);
            batch.end();
            if (isExit) {
                Gdx.app.exit();
            }
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        S = false;
        k = false;
        if (isDone && button == Buttons.RIGHT) {
            good = 0;
            eff = 0;
            j = 0;
            count = 0;
            isDone = !isDone;
            p = true;
        } else if (isDone && button == Buttons.LEFT) {
            count = 0;
            isDone = !isDone;
            p = true;
        }
        if (p) {
            if (button == Buttons.LEFT && recTL.contains(screenX, screenY)
                    && randRec.get(x) == recBL && !circ.contains(screenX, screenY)) {
                S = true;
            } else if (button == Buttons.LEFT && recTR.contains(screenX, screenY)
                    && randRec.get(x) == recBR && !circ.contains(screenX, screenY)) {
                S = true;
            } else if (button == Buttons.LEFT && recBL.contains(screenX, screenY)
                    && randRec.get(x) == recTL && !circ.contains(screenX, screenY)) {
                S = true;
            } else if (button == Buttons.LEFT && recBR.contains(screenX, screenY)
                    && randRec.get(x) == recTR && !circ.contains(screenX, screenY)) {
                S = true;
            }
            if (!circ.contains(screenX, screenY)) {
                k = true;
            }
            if (k) {
                bCount = true;
                x = ThreadLocalRandom.current().nextInt(0, 3 + 1);
                isClick = true;
                count = 0;
                j++;
                eff = (good / j) * 100;
                if (S) {
                    good++;
                }
            }
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            isExit = true;
        } else if (keycode == Input.Keys.SPACE) {
            isKeyChange = true;
        } else if (keycode == Input.Keys.ENTER) {
            isDone = true;
        }
        return false;
    }
}