
package Entity;
import gfx.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import Enemy.Enemy;
import Enemy.Monty;
import Input.Key;
import Input.KeyLuigi;
import Item.Item;
import Main.Game;
import Main.Handler;
import Main.Id;
import Tile.Tile;
public class Mario extends Entity {
    private int frame, framedelay, framedelayklein, frameklein,y2, y3;
    public static int moving = -1;
    private Sprite[] mario = new Sprite[15],mario2 = new Sprite[14];
    private Sprite leer, tot3, tot2, stunned1, stunned2;
    public boolean stunned = false;
    public Mario(int x, int y, int breite, int höhe, Handler handler, Id id) {
        super(x, y, breite, höhe, handler, id);
    }
    public void render(Graphics g) {
        for (int i = 0; i < mario.length; i++) {
            mario[i] = new Sprite(Game.sheet, i + 1, 1, 1, 1);
        }
        for (int i = 0; i < mario2.length; i++) {
            mario2[i] = new Sprite(Game.sheet, i + 15, 2, 1, 1);
        }
        stunned2 = new Sprite(Game.sheet, 27, 3, 1, 1);
        stunned1 = new Sprite(Game.sheet, 28, 3, 1, 1);
        leer = new Sprite(Game.sheet, 26, 3, 1, 1);
        tot2 = new Sprite(Game.sheet, 18, 1, 1, 1);
        tot3 = new Sprite(Game.sheet, 19, 1, 1, 1);
        if (tot == false) {
            if (hit == false) {
                if (stunned == false) {
                    if (klein == false) {
                        //Normaler State
                            Zeichnung(g);
//                            g.setColor(Color.white);
//                            g.drawRect(x + 33, y + 13, 38, 5);
//                            g.setColor(Color.red);
//                            g.drawRect(getX() + 33, getY() + 96, 34, 5);
//                            g.setColor(Color.green);
//                            g.drawRect(getX() + 70, getY() + 25, 5, 62);
//                            g.setColor(Color.CYAN);
//                            g.drawRect(getX() + 26, getY() + 25, 5, 62);
//                            g.setColor(Color.MAGENTA);
//                            g.drawRect(getX() + 26, getY() + 10, 49, höhe - 10);
//                            g.setColor(Color.YELLOW);
//                            g.drawRect(x + 33, y + 13, 38, 25);
    
                    } else {
                        //Kleiner State
                            Zeichnung2(g);
//                            g.setColor(Color.white);
//                            g.drawRect(x + 33, y + 33, 38, 5);
//                            g.setColor(Color.red);
//                            g.drawRect(getX() + 33, getY() + 96, 34, 5);
//                            g.setColor(Color.green);
//                            g.drawRect(getX() + 70, getY() + 45, 5, 42);
//                            g.setColor(Color.CYAN);
//                            g.drawRect(getX() + 26, getY() + 45, 5, 42);
//                            g.setColor(Color.MAGENTA);
//                            g.drawRect(getX() + 26, getY() + 30, 49, höhe - 30);
                        
                        }
                    } else {
                        //Stunned State
                        if (moving == 2 || moving == -2) {g.drawImage(stunned1.getBufferedImage(), x, y, breite, höhe+8, null);}
                        if (moving == 1 || moving == -1) {g.drawImage(stunned2.getBufferedImage(), x, y, breite, höhe+8, null);}
                    }
            }
                if (hit == true) {
                    //Invincible State
                    if (timer2 < 30) {
                        g.drawImage(leer.getBufferedImage(), x, y, breite, höhe+8, null);
                    } else if (timer2 < 60) {
                        Zeichnung2(g);
                    } else if (timer2 < 90) {
                        g.drawImage(leer.getBufferedImage(), x, y, breite, höhe+8, null);
                    } else if (timer2 < 120) {
                        Zeichnung2(g);
                    } else if (timer2 < 150) {
                        g.drawImage(leer.getBufferedImage(), x, y, breite, höhe+8, null);
                    } else if (timer2 < 180) {
                        Zeichnung2(g);
                    } else if (timer2 < 210) {
                        g.drawImage(leer.getBufferedImage(), x, y, breite, höhe+8, null);
                    } else if (timer2 < 240) {
                        Zeichnung2(g);
                    } else if (timer2 < 270) {
                        g.drawImage(leer.getBufferedImage(), x, y, breite, höhe+8, null);
                    } else if (timer2 < 300) {
                        Zeichnung2(g);
                    } else if (timer2 < 330) {
                        g.drawImage(leer.getBufferedImage(), x, y, breite, höhe+8, null);
                    } else if (timer2 < 350) {
                        Zeichnung2(g);
                    }
                }
        } else {
            //Tot State
            if (timertot < 20) {
                g.drawImage(tot2.getBufferedImage(), x, y, breite, höhe+8, null);
            } else if (timertot < 40) {
                g.drawImage(tot3.getBufferedImage(), x, y, breite, höhe+8, null);
            }
        }
    }
    public void tick() {
        x += velX;
        y += velY;
        
        if(y<0){
            setVelY(0);
            y = 0;
            jumping = false;
            falling = true;
            gravity = 0;
        }
        
        if (tot == false) {
            if (stunned == true) {
                klein2 = true;
                if (getTimerstunned() < 35) {
                    timerstunned++;
                } else if (timerstunned >= 35) {
                    stunned = false;
                }
            } else {
                klein2 = false;
            }
            for (Enemy ene : handler.enemy) {
                if (hit == false) {
                    if (this.klein == false) {
                        if (getLeft().intersects(ene.getRight())) {
                            setVelX(0);
                            klein = true;
                            hit = true;
                            Game.handler.ChangeMusic(6, 1, false);
                        }
                        if (getRight().intersects(ene.getLeft())) {
                            setVelX(0);
                            klein = true;
                            hit = true;
                            Game.handler.ChangeMusic(6, 1, false);
                        }
                        if (getBottom().intersects(ene.getTop()) && ene.getId() != Id.Monty) {
                            setVelY(0);
                            y = y - 40;
                            jumping(0.5f);
                            falling = false;
                            gravity = 5.0f;
                            ene.setAsRemoved();
                            Game.handler.ChangeMusic(5, 1, false);
                        } else if (ene.getId() == Id.Monty && getBottom().intersects(ene.getTop())) {
                            hit = true;
                            klein = true;
                            Game.handler.ChangeMusic(6, 1, false);
                        }
                        if(getTopEn().intersects(ene.getBottom())){
                            System.out.println("test");
                            setVelX(0);
                            klein = true;
                            hit = true;
                            Game.handler.ChangeMusic(6, 1, false);
                        }
                    } else {
                        if (getLeft().intersects(ene.getRight())) {
                            setVelX(0);
                            tot = true;
                        }
                        if (getRight().intersects(ene.getLeft())) {
                            setVelX(0);
                            tot = true;
                        }
                        if (getBottom().intersects(ene.getTop()) && ene.getId() != Id.Monty) {
                            setVelY(0);
                            y = y - 40;
                            jumping(0.5f);
                            falling = false;
                            gravity = 5.0f;
                            ene.setAsRemoved();
                            Game.handler.ChangeMusic(5, 1, false);
                        } else if (ene.getId() == Id.Monty && getBottom().intersects(ene.getTop())) {
                            tot = true;
                        }
                        if(getTop().intersects(ene.getBounds())){
                            setVelX(0);
                            tot = true;
                        }
                    }
                } else {
                    if (timer3 < 400) {
                        timer3 ++;
                        timer2++;
                    } else {
                        hit = false;
                        timer2=0;
                        timer3=0;
                    }
                }
            }
            for (Entity en : handler.entity) {
                if (en.getId() == Id.Luigi) {
                    if (getLeft().intersects(en.getRight())) {
                        setVelX(0);
                        x = en.getX() + 60;
                        x = en.getX() + 50;
                    }
                    if (getRight().intersects(en.getLeft())) {
                        setVelX(0);
                        x = en.getX() - 60;
                        x = en.getX() - 50;
                    }
                    if (getBottom().intersects(en.getBounds())) {
                        en.setTimerstunned(0);
                        Game.handler.ChangeMusic(7, 1, false);
                        Game.luigi.setStunned(true);
                        
                        if(en.isJumping()){
                            en.setJumping(false);
                            en.setFalling(true);
                        }
                        en.setGravity(0);
                        setVelY(0);
                        y = y - 40;
                        jumping(0.5f);
                        falling = false;
                        gravity = 5.0f;
                    }
                }
            }
            for (Item it : handler.item) {
                if (it.getId() == Id.pilz) {
                    if (getBounds().intersects(it.getBounds())) {
                        Game.handler.ChangeMusic(8, 1, false);
                        it.setAsRemoved();
                        if(klein==true){
                        klein=false;
                        }
                    }}
                
                
            }
            for (Tile t : handler.tile) {
                if (t.getId() == Id.wall) {
                    if (getTop().intersects(t.getBottom())) {
                        setVelY(0);
                        y = t.getY() + 50;
                        jumping = false;
                        falling = true;
                        gravity = 0;
                    }
                    if (getBottom().intersects(t.getBounds())) {
                        setVelY(0);
                        y = t.getY() - 100;
                        if (falling) {
                            falling = false;
                        }
                    } else if (!jumping) {
                        falling = true;
                    }
                    if (getLeft().intersects(t.getRight())) {
                        setVelX(0);
                        x = t.getX() + 40;
                    }
                    if (getRight().intersects(t.getLeft())) {
                        setVelX(0);
                        x = t.getX() - 75;
                    }
                }
                if (t.getId() == Id.pipe) {
                    if (getTop().intersects(t.getBottom())) {
                        setVelY(0);
                        y = t.getY() + 80;
                        jumping = false;
                        falling = true;
                        gravity = 0;
                    }
                    
                    if (getLeft().intersects(t.getBounds())) {
                        setVelX(0);
                        x = t.getX() +t.getBreite()-30;
                    }
                    if (getRight().intersects(t.getBounds())) {
                        setVelX(0);
                        x = t.getX() - 75;
                    }
                }
            }
            
            if(jumping){
                jumping(0.5f);
            }
            if(falling){
                falling();
            }
            framedelay++;
            framedelayklein++;
            if (klein == false) {
                if (KeyLuigi.d && KeyLuigi.shift || KeyLuigi.a && KeyLuigi.shift) {
                    if (framedelay >= 5) {
                        frame++;
                        if (frame >= 5) {
                            frame = 0;
                        }
                        framedelay = 0;
                    }
                } else if (framedelay >= 6) {
                    frame++;
                    if (frame >= 5) {
                        frame = 0;
                    }
                    framedelay = 0;
                }
            } else {
                if (KeyLuigi.d && KeyLuigi.shift || KeyLuigi.a && KeyLuigi.shift) {
                    if (framedelayklein >= 4) {
                        frameklein++;
                        if (frameklein >= 4) {
                            frameklein = 0;
                        }
                        framedelay = 0;
                    }
                } else if (framedelayklein >= 5) {
                    frameklein++;
                    if (frameklein >= 4) {
                        frameklein = 0;
                    }
                    framedelayklein = 0;
                }
            }
            if (Key.d && Key.shift) {
                setVelX(8);
                Mario.moving = 1;
            } else if (Key.d && !Key.shift) {
                setVelX(5);
                Mario.moving = 1;
            }
            if (Key.a && Key.shift) {
                setVelX(-8);
                Mario.moving = 2;
            } else if (Key.a && !Key.shift) {
                setVelX(-5);
                Mario.moving = 2;
            }
            if (x < Game.getFrameBreite() + 70 && x > Game.getFrameBreite() + 60) {
                y2 = y;
            }
            if (x > Game.getFrameBreite() + 130) {
                x = -3;
                y = y2;
            }
            if (x < 10 && x > 0) {
                y3 = y;
            }
            if (x + breite < 2) {
                x = Game.getFrameBreite() + 120;
                y = y3;
            }
            if (y > 500 || Monty.montywirdlosgeschicktluigi) {
                Monty.montylosschicken++;
                if (Monty.montylosschicken == 500) {
                    if (x < 1262 / 2) {
                        Monty.montyfacing = 1;
                    } else {
                        Monty.montyfacing = 2;
                    }
                    Monty.montywirdlosgeschickt = true;
                }
            } else {
                Monty.montylosschicken = 0;
            }
        } else {
            setVelX(0);
            timertot++;
            if (timertot >= 40) {
                timertot = 0;
            }
            if (tot1 == false) {
                Game.handler.ChangeMusic(3, 1, false);
                falling = false;
                jumping=true;
                gravity = 10.0f;
                tot1 = true;
            }
            if(jumping){
                jumping(0.5f);
            }
            if (falling) {
                gravity += 0.3f;
                setVelY((int) gravity);
            }
        }
    }
    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }
    public boolean getStunned() {
        return stunned;
    }
    public void Zeichnung(Graphics g){
        if (moving == -1 && !jumping && !falling) {g.drawImage(mario[0].getBufferedImage(), x, y-3, breite, höhe+4, null);}
        if (moving == 1 && !jumping && !falling) {g.drawImage(mario[frame].getBufferedImage(), x, y-3, breite, höhe+4, null);}
        if (moving == 1 && jumping && !falling || moving == -1 && jumping && !falling) {g.drawImage(mario[11].getBufferedImage(), x, y-3, breite, höhe+4, null);}
        if (moving == 1 && !jumping && falling || moving == -1 && !jumping && falling) {g.drawImage(mario[13].getBufferedImage(), x, y-3, breite, höhe+4, null);}
        if (moving == -2 && !jumping && !falling) {g.drawImage(mario[5].getBufferedImage(), x, y, breite, höhe+8, null);}
        if (moving == 2 && !jumping && !falling) {g.drawImage(mario[frame + 6].getBufferedImage(), x, y, breite, höhe+8, null);}
        if (moving == 2 && jumping && !falling || moving == -2 && jumping && !falling) {g.drawImage(mario[12].getBufferedImage(), x, y, breite, höhe+8, null);}
        if (moving == 2 && !jumping && falling || moving == -2 && !jumping && falling) {g.drawImage(mario[14].getBufferedImage(), x, y, breite, höhe+8, null);}
    }
        
    public void Zeichnung2(Graphics g){
        if (moving == -1 && !jumping && !falling) {g.drawImage(mario2[0].getBufferedImage(), x, y-3, breite, höhe+8, null);}
        if (moving == 1 && !jumping && !falling) {g.drawImage(mario2[frameklein].getBufferedImage(), x, y-3, breite, höhe+8, null);}
        if (moving == 1 && jumping && !falling || moving == -1 && jumping && !falling) {g.drawImage(mario2[10].getBufferedImage(), x, y-3, breite, höhe+8, null);}
        if (moving == 1 && !jumping && falling || moving == -1 && !jumping && falling) {g.drawImage(mario2[12].getBufferedImage(), x, y-3, breite, höhe+8, null);}
        if (moving == -2 && !jumping && !falling) {g.drawImage(mario2[5].getBufferedImage(), x, y, breite, höhe+8, null);}
        if (moving == 2 && !jumping && !falling) {g.drawImage(mario2[frameklein + 5].getBufferedImage(), x, y, breite, höhe+8, null);}
        if (moving == 2 && jumping && !falling || moving == -2 && jumping && !falling) {g.drawImage(mario2[11].getBufferedImage(), x, y, breite, höhe+8, null);}
        if (moving == 2 && !jumping && falling || moving == -2 && !jumping && falling) {g.drawImage(mario2[13].getBufferedImage(), x, y, breite, höhe+8 , null);}
    }
}
