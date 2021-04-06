package com.example.demo.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

@SuppressWarnings("serial")
public class MyTankGame2 extends JFrame {

    MyPanel p1 = null;

    public MyTankGame2(){
        p1 = new MyPanel();
        Thread t = new Thread(p1);
        t.start();
        add(p1);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(p1);//注册监听

    }

    public static void main(String[] args) {
        new MyTankGame2();
    }
}

class MyPanel extends JPanel implements KeyListener,Runnable{

    Hero hero = null;
    Vector<EnemyTank> ets = new Vector<EnemyTank>();
    int enSize = 3;

    public MyPanel(){
        hero = new Hero(100,100);//设置坦克出现的位置（10，10）
        // 初始化敌人的坦克
        for(int i=0;i<enSize;i++){
            //创建对人的坦克对象
            EnemyTank et =new EnemyTank((i+1)*30,0);
            et.setColor(1);
            et.setDirect(1);
            ets.add(et);
        }
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        g.fillRect(0, 0, 400, 300);//背景填充

        //画出我方坦克
        drawTank(hero.getX(),hero.getY(),g,hero.Direct,0);//一定要传入画笔g

        //画出子弹
        if(hero.s!=null&&hero.s.isLive==true){
//          System.out.format("%d %d  ", hero.s.x,hero.s.y);
            g.setColor(Color.red);
            g.draw3DRect(hero.s.x, hero.s.y, 1, 1, false);
        }
        //画出敌方坦克
        for(int i=0;i<ets.size();i++){
            drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), ets.get(i).getColor());
        }


    }

    /*
     * drawTank (坦克坐标x,y,画笔g,方向，坦克类型)
     * 方法介绍：
     *      可以设置-->坦克的颜色（类型：敌方坦克，我方坦克），方向，出现的坐标
     *
     * 如果type是default 则默认颜色为画出黑色坦克
     *
     * 封装性：将坦克封装到方法中。
     *
     */

    public void drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
            default:
                break;
        }
        switch (direct) {
            case 0:
                //向上
                g.fill3DRect(x   , y    , 5 , 30, false);
                g.fill3DRect(x+15, y    , 5 , 30, false);
                g.fill3DRect(x+5 , y+5  , 10, 20, false);
                g.fillOval(x+4, y+10, 10 , 10);
                g.drawLine(x+9, y+15, x+9, y );
                break;
            case 1:
                //向下w
                g.fill3DRect(x   , y    , 5 , 30, false);
                g.fill3DRect(x+15, y    , 5 , 30, false);
                g.fill3DRect(x+5 , y+5  , 10, 20, false);
                g.fillOval(x+4, y+10, 10 , 10);
                g.drawLine(x+9, y+15, x+9, y+30 );
                break;
            case 2:
                //向左
                g.fill3DRect(x   , y    , 30, 5 , false);
                g.fill3DRect(x   , y+15 , 30, 5 , false);
                g.fill3DRect(x+5 , y+5  , 20, 10, false);
                g.fillOval(x+9 , y+4, 10  , 10 );
                g.drawLine(x+5, y+9, x-4, y+9);
                break;
            case 3:
                //向右
                g.fill3DRect(x   , y    , 30, 5 , false);
                g.fill3DRect(x   , y+15 , 30, 5 , false);
                g.fill3DRect(x+5 , y+5  , 20, 10, false);
                g.fillOval(x+9 , y+4, 10  , 10 );
                g.drawLine(x+15, y+9, x+30, y+9);
                break;
            default:
                break;
        }
        //repaint();  因为监听器里面有repaint()  所以不用在加repaint()了
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {//实现接口 根据按键上下左右移动 可以控制速度和移动
        if(e.getKeyCode()==KeyEvent.VK_W){
            hero.setDirect(0);
            hero.moveUp();
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            hero.setDirect(1);
            hero.moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_A){
            hero.setDirect(2);
            hero.moveLeft();
        }else if(e.getKeyCode()==KeyEvent.VK_D){
            hero.setDirect(3);
            hero.moveRight();
        }
        if(e.getKeyCode()==KeyEvent.VK_J){
            //开火
            hero.shotEnemy();
        }
        //判断玩家是否按下J攻击键
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    //@Override
    public void run() {
        //每隔100毫秒 重新画图
        while(true){
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}