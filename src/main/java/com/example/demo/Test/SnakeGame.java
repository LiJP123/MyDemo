package com.example.demo.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends KeyAdapter implements Runnable {
    private boolean start=false;
    private JFrame frame;
    private Thread timerThread;
    //-------------变量定义Start-------------
    int[] SnakeXs=new int[900];
    int[] SnakeYs=new int[900];
    //定义初始蛇的长度
    int len=6;
    //定义初始方向
    int diraction=4;
    //定义食物的X，Y坐标
    int a;
    int b;
    //定义一个分数
    int score;
    //定义一个变量记录吃了多少个
    int count;
    //是否Game Over
    boolean IsGameOver = false;
    //是否加速
    int time;
    boolean BiteWall ;
    //-------------变量定义End-------------


    /**
     * 构造方法，用于构造及初始化所需要的其它对象
     */
    public SnakeGame(){
        //-------------构造&初始对象Start-------------
        for(int i=0;i<len;i++){
            SnakeXs[i]=(len-1-i)*20;SnakeYs[i]=0;
        }
        //初始化食物坐标
        a=100;
        b=100;
        //初始化分数
        score=0;
        //初始化时间
        time=400;
        //-------------构造&初始对象End-------------
        frame = new JFrame();
        frame.getContentPane().add(new Screen());
        frame.addKeyListener(this);

        //-------------窗口大小设置  frame.setSize(宽, 高);
        frame.setSize(600+5*2+200, 600+25+5*2);

        frame.setVisible(true);
        frame.repaint();
    }


    /**
     * 键盘事件响应
     * @param evt
     *             按键事件
     */
    public void keyPressed(KeyEvent evt){
        switch(evt.getKeyCode()){
            case KeyEvent.VK_ENTER:
                if(!start){
                    timerThread = new Thread(this);
                    timerThread.start();
                    start = true;
                }
                break;
            case KeyEvent.VK_ESCAPE:
                start = false;
                System.exit(1);
                break;
            case KeyEvent.VK_LEFT:
                //-------------按左方向键的事件响应Start-------------
                if(diraction==1||diraction==2)
                {
                    diraction=3;
                }
                //-------------按左方向键的事件响应End-------------
                break;
            case KeyEvent.VK_RIGHT:
                //-------------按右方向键的事件响应Start-------------
                if(diraction==1||diraction==2)
                {
                    diraction=4;
                }
                //-------------按右方向键的事件响应End-------------
                break;
            case KeyEvent.VK_DOWN:
                //-------------按下方向键的事件响应Start-------------
                if(diraction==3||diraction==4)
                {
                    diraction=2;
                }
                //-------------按下方向键的事件响应End-------------
                break;
            case KeyEvent.VK_UP:
                //-------------按上方向键的事件响应Start-------------
                if(diraction==3||diraction==4)
                {
                    diraction=1;
                }
                //-------------按上方向键的事件响应End-------------
                break;
            case KeyEvent.VK_R:
                BiteWall=!BiteWall;
                break;
        }

        frame.repaint();
    }

    /**
     * 线程方法主体，主要用于在主线程展示窗体的同时在窗体中同时做其它任务
     */
    public void run(){
        while(true){
            try{
                //-------定时时间间隔  Thread.sleep(毫秒);-------
                Thread.sleep(time);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            if(start==false)
                return;
            //-------------定时时间间隔事件任务Start-------------


            //-------------定时时间间隔事件任务End-------------
            frame.repaint();
        }
    }

    class Screen extends JComponent{
        private static final long serialVersionUID = 1155019838145337862L;

        public void paint(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            //-------------画图处理Start-------------
//            g2d.drawOval(0, 0, 100, 100);
//            g2d.fillOval(100, 100, 200, 100);
//            g2d.setColor(Color.BLUE);

            //        g2d.drawString("今天是2018年1月4号", 0, 10);

            //画出背景板
            g2d.setColor(Color.orange);
            g2d.fillRect(0, 0, 800, 600);
            g2d.setColor(Color.black);
            g2d.fillRect(0, 0, 600, 600);

            //画出背景方格

            for(int i=0;i<30;i++){
                for(int j=0;j<30;j++){

                    g2d.setColor(Color.white);
                    g2d.drawRect(i*20,j*20 , 20,20);

                }
            }
            //画出初始位置的蛇身体

            for(int i=0;i<len;i++){
                g2d.setColor(Color.green);
                g2d.fillRect(SnakeXs[i]+1,SnakeYs[i]+1,20-2,20-2);
            }

            //画出第一个食物的点

            g2d.setColor(Color.green);
            g2d.fillRect(a+1,b+1, 20-2, 20-2);
            if(SnakeXs[0]==a&&SnakeYs[0]==b){
                count++;
                len++;    //吃到食物身体变长一节
                score+=10;    //吃到食物分数增加10分

                //创造一个新的食物
                a=(int)(Math.random()*30)*20; b=(int)(Math.random()*30)*20;
                g2d.setColor(Color.green);
                g2d.fillRect(a+1,b+1, 20-2, 20-2);

            }
            //判断是否撞墙停止游戏
            if(BiteWall==true){
                if(SnakeXs[0]<0){
                    SnakeXs[0] = 580;
                }else if(SnakeXs[0]>580){
                    SnakeXs[0] = 0;
                }
                if(SnakeYs[0]<0){
                    SnakeYs[0] = 580;
                }else if(SnakeYs[0]>580){
                    SnakeYs[0] = 0;
                }
            }else{
                //如果撞墙了则显示GameOver
                if(SnakeXs[0]<0 || SnakeXs[0]>580
                        ||SnakeYs[0]<0 || SnakeYs[0]>580){
                    IsGameOver = true;
                }
            }
            for(int i=1;i<len;i++){
                if(SnakeXs[0]==SnakeXs[i]&&SnakeYs[0]==SnakeYs[i]){
                    IsGameOver=true;
                    break;
                }
            }
            if(IsGameOver){
                g2d.setFont(new Font("宋体",Font.BOLD,80));
                g2d.setColor(Color.orange);
                g2d.drawString("Game Over!!", 80, 250);
                start=false;
            }

            //显示出分数
            g2d.setFont(new Font("宋体",Font.BOLD,20));
            g2d.setColor(Color.red);
            g2d.drawString("分数："+score, 650, 200);
            g2d.drawString("吃了："+count+"个", 650, 300);
            g2d.setColor(Color.blue);
            g2d.drawString("巨无霸恐怖贪吃蛇", 620, 100);
            //判断分数超过一定值之后加速
            switch(score/100){
                case 1:
                    time=300;
                    break;
                case 2:
                    time=200;
                    break;
                case 3:
                    time=100;
                    break;
                case 4:
                    time=50;
                    break;
            }

            //蛇身的移动
            for(int i=len-1;i>0;i--){
                SnakeXs[i]=SnakeXs[i-1];SnakeYs[i]=SnakeYs[i-1];
            }

            //蛇头的移动
            switch(diraction){
                case 1:
                    SnakeYs[0]=SnakeYs[0]-20;
                    break;
                case 2:
                    SnakeYs[0]=SnakeYs[0]+20;
                    break;
                case 3:
                    SnakeXs[0]=SnakeXs[0]-20;
                    break;
                case 4:
                    SnakeXs[0]=SnakeXs[0]+20;
                    break;

            }

            //-------------画图处理End-------------
        }
    }

    /**
     * 主方法用于启动窗体
     * @param args
     */
    public static void main(String[] args){
        //构造窗体对象用于展示
        new SnakeGame();
    }
}