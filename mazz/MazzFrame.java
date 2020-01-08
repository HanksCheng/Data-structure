import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
public class MazzFrame extends JFrame implements KeyListener{
    private Container cp;
    private JLabel jlbs[][]=new JLabel[15][15];
    private byte map[][]={
        {0,1,0,1,1,1,1,0,1,0,1,1,0,1,1},
        {0,0,0,1,0,1,0,0,1,0,1,0,0,1,1},
        {1,0,1,1,0,1,1,0,0,0,0,0,1,1,1},
        {1,0,0,0,0,1,0,0,1,1,0,0,0,1,1},
        {1,1,0,1,0,0,1,0,1,1,0,1,1,1,1},
        {1,0,1,1,1,0,0,0,1,1,1,0,0,1,1},
        {0,0,1,1,0,1,1,0,0,1,1,1,0,0,0},
        {1,0,0,1,0,0,0,0,1,1,1,1,0,1,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,0,1,1},
        {1,0,1,0,0,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,1,1,1,1,1,0,0,0,0,1,1},
        {1,0,1,1,1,0,0,1,0,0,1,1,0,1,1},
        {1,1,1,0,1,1,0,0,0,1,1,1,0,0,1},
        {1,1,1,0,1,1,1,1,0,1,1,1,1,0,1},
        {0,0,0,0,1,1,1,1,0,1,1,1,1,0,0}
    };
    private ImageIcon icons[]=new ImageIcon[3];
    int x=0,y=0,count=0;


    public MazzFrame(){
        init();
    }


    public void init(){
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(15,15,0,0));

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        this.setTitle("THE MAZZ");
        this.setBounds(160,90,1024,768);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        icons[0]=new ImageIcon("GRASS.png");
        icons[1]=new ImageIcon("STONE.jpg");
        icons[2]=new ImageIcon("MICE.jpeg");

        Image img=icons[1].getImage();
        Image newimg=img.getScaledInstance(80,50,java.awt.Image.SCALE_SMOOTH);
        icons[1]=new ImageIcon(newimg);

        img=icons[2].getImage();
        Image newimg1=img.getScaledInstance(70,60,java.awt.Image.SCALE_SMOOTH);
        icons[2]=new ImageIcon(newimg1);

        // int i=0,j=0;
        
        // 加圖片 GRASS STONE MICE
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                jlbs[i][j]=new JLabel();
                if (map[i][j]==0){
                    jlbs[i][j].setIcon(icons[0]);
                }
                else {
                    jlbs[i][j].setIcon(icons[1]);
                }
                
                cp.add(jlbs[i][j]);
            }
        }
        jlbs[0][0].setIcon(icons[2]);

        


    }
    // 上下左右
    // 變數為x,y,count
    public void keyPressed(KeyEvent ke){
        System.out.println(ke.getKeyCode());
        switch (ke.getKeyCode()) {
            //Left
            case 37:
                if (x-1>=0){
                    if(map[y][x-1]==0){
                         jlbs[y][x].setIcon(icons[0]);
                         x--;
                         jlbs[y][x].setIcon(icons[2]);
                         count++;
                         System.out.println(count);
                    }
                }
                break;
            //Up
            case 38:
                if (y-1>=0){
                    if(map[y-1][x]==0){
                        jlbs[y][x].setIcon(icons[0]);
                        y--;
                        jlbs[y][x].setIcon(icons[2]);
                        count++;
                    }
                }
                break;
            //Right
            case 39:
                if (x+1<=15){
                    if(map[y][x+1]==0){
                        jlbs[y][x].setIcon(icons[0]);
                        x++;
                        jlbs[y][x].setIcon(icons[2]);
                        count++;
                    }
                }
                break;
            //Down
            case 40:
                if (y+1<15){
                    if(map[y+1][x]==0){
                        jlbs[y][x].setIcon(icons[0]);
                        y++;
                        jlbs[y][x].setIcon(icons[2]);
                        count++;
                    }
                }
                break;
        }
        if(y==14&&x==14){
            jlbs[y][x].setText("");
            jlbs[y][x].setBackground(new Color(120,240,70));
            JOptionPane.showMessageDialog(MazzFrame.this,"TOTAL STEP:"+count,"Message",JOptionPane.DEFAULT_OPTION);
        }
    }
    public void keyReleased(KeyEvent ke){
        System.out.println(ke.getKeyCode());
    }
    public void keyTyped(KeyEvent ke){
        System.out.println(ke.getKeyCode());
    }
}