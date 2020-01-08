import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
public class TimerFrame extends JFrame{
    private Container cp;
    private JPanel jpns=new JPanel(new GridLayout(1,3,2,2));
    private JPanel jpnc=new JPanel(new GridLayout(1,8,20,20));
    private JButton btstart=new JButton("start");
    private JButton pause=new JButton("pause");
    private JButton exit=new JButton("exit");
    private JLabel sec1=new JLabel();
    private JLabel sec2=new JLabel();
    private JLabel min1=new JLabel();
    private JLabel min2=new JLabel();
    private JLabel hr1=new JLabel();
    private JLabel hr2=new JLabel();
    int s=0;
    int tmps=0;
    int tmpss=0;
    int m=0;
    int tmpm=0;
    int tmpmm=0;
    int h=0;
    int tmph=0;
    int tmphh=0;
    private JLabel spl1=new JLabel(":");
    private JLabel spl2=new JLabel(":");
    private ImageIcon icon[]=new ImageIcon[10];

    private Timer t1;


    public TimerFrame(){
        init();
    }
    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout()); 
        this.setBounds(100,100,500,200);
        


        
        // image
        for(int i=0;i<10;i++){
            icon[i]=new ImageIcon(Integer.toString(i)+".gif");
        }
        sec1.setIcon(icon[0]);
        sec2.setIcon(icon[0]);
        min1.setIcon(icon[0]);
        min2.setIcon(icon[0]);
        hr1.setIcon(icon[0]);
        hr2.setIcon(icon[0]);



        // south
        jpns.add(btstart);
        jpns.add(pause);
        jpns.add(exit);
        cp.add(jpns,BorderLayout.SOUTH);
        
        
        // center
        jpnc.add(hr2);
        jpnc.add(hr1);
        jpnc.add(spl1);
        jpnc.add(min2);
        jpnc.add(min1);
        jpnc.add(spl2);
        jpnc.add(sec2);
        jpnc.add(sec1);
        cp.add(jpnc,BorderLayout.CENTER);



        t1 = new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                s++;
                tmpss=s/10;
                tmps=s%10;
                sec1.setIcon(icon[tmps]);
                sec2.setIcon(icon[tmpss]);

                // sec.setText(Integer.toString(s));
                // if(s<10){
                //     sec.setText(0+Integer.toString(s));
                // }
                if(s==60){
                    m++;
                    tmpmm=m/10;
                    tmpm=m%10;
                    min1.setIcon(icon[tmpm]);
                    min2.setIcon(icon[tmpmm]);
                    // if(m<10){
                    //     min.setText(0+Integer.toString(m));
                    // }
                    s=0;
                    // sec.setText(Integer.toString(s));
                    tmpss=s/10;
                    tmps=s%10;
                    sec1.setIcon(icon[tmps]);
                    sec2.setIcon(icon[tmpss]);
                    if(m==60){
                        h++;
                        tmphh=h/10;
                        tmph=h%10;
                        hr1.setIcon(icon[tmph]);
                        hr2.setIcon(icon[tmphh]);
                        // hr.setText(Integer.toString(h));
                        // if(h<10){
                        //     hr.setText(0+Integer.toString(h));
                        // }
                        m=0;
                        tmpmm=m/10;
                        tmpm=m%10;
                        min1.setIcon(icon[tmpm]);
                        min2.setIcon(icon[tmpmm]);
                        // min.setText(Integer.toString(m));
                    }
                }
                 
            }
        });


        exit.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
         });


         pause.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               t1.stop();
           }
        });


         btstart.addActionListener(new ActionListener(){
            
             public void actionPerformed(ActionEvent e){
                 t1.start();
                 System.out.println(t1);
                 System.out.println("TEST");
            }
         });
         
        
        


    }
}