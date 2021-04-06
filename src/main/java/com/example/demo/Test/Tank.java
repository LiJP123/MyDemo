package com.example.demo.Test;

class Tank {
    int x = 0;
    int y = 0;
    int speed = 10;
    int Direct = 0;
    int color;
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public int getDirect() {
        return Direct;
    }
    public void setDirect(int direct) {
        Direct = direct;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Tank (int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }


    //视频中是把移动放在hero类中

}
//敌方坦克
class EnemyTank extends Tank{

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
//我的英雄坦克
class Hero extends Tank{

    //子弹
    Shot s = null;

    public Hero(int x,int y){
        super(x, y);
    }
    //开火
    public void shotEnemy(){

        switch (Direct) {
            case 0:
                s = new Shot(x+8,y-4,0);
                break;
            case 1:
                s = new Shot(x+9,y+32,1);
                break;
            case 2:
                s = new Shot(x-8,y+8,2);
                break;
            case 3:
                s = new Shot(x+32,y+9,3);
                break;
            default:
                break;
        }
        Thread t =new Thread(s);
        t.start();
    }
    public void moveUp(){
        y-=speed;
    }
    public void moveDown(){
        y+=speed;
    }
    public void moveLeft(){
        x-=speed;
    }
    public void moveRight(){
        x+=speed;
    }
}
//子弹类
class Shot implements Runnable{
    int x;
    int y;
    int Direct;
    int speed = 5;
    boolean isLive = true;
    public Shot(int x,int y,int Direct){
        this.x=x;
        this.y=y;
        this.Direct = Direct;
    }
    @Override

    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }
            switch(Direct){
                case 0:
                    y-=speed;
                    break;
                case 1:
                    y+=speed;
                    break;
                case 2:
                    x-=speed;
                    break;
                case 3:
                    x+=speed;
                    break;
                default:
                    break;
            }

//          System.out.println(""+x+" "+y);
            //子弹何时死亡
            if(x<0||x>400||y<0||y>300){
                isLive = false;
                break;
            }
        }
    }
}