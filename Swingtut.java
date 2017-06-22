import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Swingtut extends Canvas implements ActionListener
{ JFrame f;JButton t[]=new JButton[9];JButton b[]=new JButton[2];String str="";
JButton n[][]=new JButton[3][3];   int h=0; JButton reset=new JButton("Reset");

Swingtut()
    {
        f=new JFrame("tic tac toe");
        f.setVisible(true);
        f.setSize(500,500);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.GREEN);
        f.add(this);
        reset.setBounds(150,400,100,50);
        reset.addActionListener(this);
        f.add(reset);
        
        for(int y=0;y<3;y++)
        {
            for(int x=0;x<3;x++)
            { n[x][y]=new JButton("");
              n[x][y].setBounds(150+50*x,100+y*50,50,50);
              n[x][y].addActionListener(this);
              f.add(n[x][y]);
                
            }
        }
        /*for(int i=0;i<9;i++)
        { t[i]=new JButton();
          t[i].setBounds(150+50*(i%3),100+50*(i/3),50,50);
          t[i].addActionListener(this);
          t[i].setText("");
          f.add(t[i]);
        }*/
        for(int i=0;i<2;i++)
        {
            b[i]=new JButton("");
            b[i].addActionListener(this);
            f.add(b[i]);
            
        }
            b[0].setBounds(20,50,50,50);
            b[0].setText("0");
            b[1].setText("X");
            b[1].setBounds(320,50,50,50);
            
       
        

   }
    @Override
    public void actionPerformed(ActionEvent e)
    {int k=0;
    if(e.getSource()==reset)
    { h=-1;
        for(int y=0;y<3;y++)
        {
            for(int x=0;x<3;x++)
            {
                n[x][y].setEnabled(true);
                n[x][y].setText("");
            }
    }}
        for(int i=0;i<2;i++)
    { if(e.getSource()==b[i])
    { k=i;
        str=b[i].getText();      
    }}
   
        if(h%2==0)
        {
            str="0";
        }
        if(h%2==1)
        {
            str="X";
        }
        
        for(int j=0;j<3;j++)
        { for(int i=0;i<3;i++)
        {
            if(e.getSource()==n[i][j])
            {
               n[i][j].setText(str);
               n[i][j].setEnabled(false);
               if(getdata()!=0)
               { JOptionPane.showMessageDialog(f,"Player "+getdata()+" is the Winner");
                   break;
               }
            }
        }
        if(getdata()!=0)
        {break;
        }
        }   h++;}
   /* public void paint(Graphics g) {  
        g.drawLine(10, 10, 10, 200);
    }*/
    public int getdata()
    { //checking for row wise pattern
        for (int i=0;i<3;i++)
        {
        
            if(n[0][i].getText()=="0"&&n[1][i].getText()=="0"&&n[2][i].getText()=="0"||n[i][0].getText()=="0"&&n[i][1].getText()=="0"&&n[i][2].getText()=="0"||n[0][0].getText()=="0"&&n[1][1].getText()=="0"&&n[2][2].getText()=="0"||n[0][2].getText()=="0"&&n[1][1].getText()=="0"&&n[2][0].getText()=="0")
            {
                return 1;
            }
            if(n[0][i].getText()=="X"&&n[1][i].getText()=="X"&&n[2][i].getText()=="X"||n[i][0].getText()=="X"&&n[i][1].getText()=="X"&&n[i][2].getText()=="X"||n[0][0].getText()=="X"&&n[1][1].getText()=="X"&&n[2][2].getText()=="X"||n[0][2].getText()=="X"&&n[1][1].getText()=="X"&&n[2][0].getText()=="X")
            {
                return 2;
            }
            
            
        }
        return 0;
    }
public static void main(String[] args)
{
    Swingtut o=new Swingtut();
    //o.setVisible(true);
    /*JFrame b=new JFrame();
            b.add(o);
            b.setSize(500,500);
            b.setVisible(true);*/
            
}}
