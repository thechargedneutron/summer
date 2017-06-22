/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtut;

/**
 *
 * @author Sanidhya Garg
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class comp implements ActionListener
 {
    JFrame f=new JFrame("TIC TAC TOE WITH COMPUTER");
    JButton b[][]=new JButton[3][3];
    String c[][]=new String[3][3];
    JButton reset=new JButton("RESET");
    int cnt=0;//to keep track of no of turns palyed
    //constructor to initialise
    comp()
    {//setting up frame
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adding buttons
        reset.setBounds(150,400,100,50);
        f.add(reset);
        reset.addActionListener(this);
        
        for(int j=0;j<3;j++)
        {
            for(int i=0;i<3;i++)
            {
                b[i][j]=new JButton();
                b[i][j].setBounds(150+50*i,100+50*j,50,50);
                b[i][j].addActionListener(this);
                
                c[i][j]="_";
                f.add(b[i][j]);
            }
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
      {//for player one giving him first chance
        
          
         if(e.getSource()==reset)
    { for(int j=0;j<3;j++)
        {
            for(int i=0;i<3;i++)
            {
        b[i][j].setEnabled(true);
        b[i][j].setText("");
        c[i][j]="_";
        cnt=0;
    }}}
          if(cnt%2==0&&isfull(c)>0)
        {
            for(int x=0;x<3;x++)
            {
                for (int y=0;y<3;y++)
                {
                    if (e.getSource()==b[y][x])
                    {
                        b[y][x].setText("0");
                        b[y][x].setEnabled(false);
                        c[y][x]="0";
                        cnt++;
                        if(score(c)==-10)
                        {
                            JOptionPane.showMessageDialog(f,"Player1 is the Winner");
                            reset.doClick();
                            cnt=-1;
                        }
                        break;
                    }
                }
            }
        }
        //computers turn
       if(cnt%2==1&&isfull(c)>0)
        {
            computersturn(c,true);
            if(score(c)==10)
            {
                JOptionPane.showMessageDialog(f,"Computer is the Winner");
                
                reset.doClick();
                cnt=-1;
                //f.dispose();
            }
            cnt++;
            
        }
       else if(cnt>=9&&isfull(c)==0)
       {
           JOptionPane.showMessageDialog(f,"Match Draw");
                cnt=0;
                
                reset.doClick();
       }
       System.out.print(cnt);
    }
    public void computersturn(String[][] s,boolean cturn)
    { 
        
        
        
        
        
        int row=0,col=0;
        if(cnt<=8)
    {   
        int bestval=-1000;
      
      for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {if(s[j][i]=="_")
            {
                s[j][i]="X";
               
                int v=(minimax(s,!cturn,0));
                
               // System.out.println(v);
                s[j][i]="_";
                if(v>bestval)
                {
                     row=j;
                     col=i;
                     bestval=v;
                }
            }
                                  
            }}
b[row][col].setText("X");
b[row][col].setEnabled(false);
s[row][col]="X";

    }  
    }
    public int isfull(String[][] s)
    {
        int c=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
    {if(s[i][j]=="_")
        c++;
    }
    }return c;
    }
    public int minimax(String s[][],boolean cturn,int depth)
    { int z=score(s);
    for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
    {
    
        }}
    
    if(z==10)
    { 
        return 10-depth;
    }
    if(z==-10)
    {
        return -10+depth;
    }
    if(isfull(s)>0){
       if(cturn)
       {
           int v=-1000;
           for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {if(s[j][i]=="_")
            {
                s[j][i]="X";
                v=Math.max(v,minimax(s,!cturn,depth+1));
                s[j][i]="_";
            }
                                
            }
        }return v;
       }
       if(!cturn)
       {
           int v=1000;
           for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {if(s[j][i]=="_")
            {
                s[j][i]="0";
                v=Math.min(v,minimax(s,!cturn,depth +1));
                s[j][i]="_";
            }
                               
            }
        }return v; 
          
       }
    }
     
     return 0;   
    }
    public int  score(String[][] s)
    {for (int i=0;i<3;i++)
        {
        
        if(s[0][i]=="0"&&s[1][i]=="0"&&s[2][i]=="0"||s[i][0]=="0"&&s[i][1]=="0"&&s[i][2]=="0"||s[0][0]=="0"&&s[1][1]=="0"&&s[2][2]=="0"||s[0][2]=="0"&&s[1][1]=="0"&&s[2][0]=="0")
            {
                return -10;
            }
            if(s[0][i]=="X"&&s[1][i]=="X"&&s[2][i]=="X"||s[i][0]=="X"&&s[i][1]=="X"&&s[i][2]=="X"||s[0][0]=="X"&&s[1][1]=="X"&&s[2][2]=="X"||s[0][2]=="X"&&s[1][1]=="X"&&s[2][0]=="X")
            {
                return 10;
            }
    
    }return 0;}
    public static void main(String[] args)
    {
        comp obj=new comp();
        
    }
    
}
