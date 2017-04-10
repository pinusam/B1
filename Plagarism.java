import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Plagarism extends JFrame
{
JFrame frame;
JLabel lbl1,lbl2,lblresult;
JTextField txt1,txt2;
JButton btn1;
Container container;
public Plagarism()
	{
		frame=new JFrame("Plagarism Detection");
		container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		JPanel p1=new JPanel();
		lbl1=new JLabel("Enter Text in textfield1");
		p1.add(lbl1);
		txt1=new JTextField(20);
		p1.add(txt1);
		JPanel p2=new JPanel();
		lbl2=new JLabel("Enter Text in textfield2");
		p2.add(lbl2);
		txt2=new JTextField(20);
		p2.add(txt2);
		JPanel p3=new JPanel();
		btn1=new JButton("Check Plagarism ");
		p3.add(btn1);
		JPanel p4=new JPanel();
		lblresult=new JLabel("Plagarism Detection");
		p4.add(lblresult);
		btn1.addActionListener(new ActionListener()
  		 {
			public void actionPerformed(ActionEvent ae)
			{
				String str1=txt1.getText();
				System.out.println(str1.length());
				String str2=txt2.getText();
				if (compareStrings(str1, str2))
    				 {
    				  lblresult.setText("Plagiarism detected.");
    				 }
     				  else
     				{
           			  lblresult.setText("No plagiarism detected");
        			}
   			}

		});
container.add(p1);
container.add(p2);
container.add(p3);
container.add(p4);                         
frame.setSize(500, 325);
frame.setVisible(true);
}

public static boolean compareStrings (String a, String b)
     {
       boolean checkForPlagiarism = true;
       String[] piecesA = a.split("\\s");
       String[] piecesB = b.split("\\s");
//print the content
for(String w:piecesA){  
    System.out.println(w);  
    }  

for(String w:piecesB){  
    System.out.println(w);  
    }  

       int count1 = 0;
       int count2 = 0;
       for (int counter = 0; counter <= piecesA.length - 1; counter++)
        {
          for(int counter2 = 0; counter<= piecesB.length - 1; counter++)
          {
              if(piecesA[counter].equals(piecesB[counter2]))
              {
              count1++;
              }
          }
        }
       for (int counter = 0; counter <= piecesB.length - 1; counter++)
        {
          for(int counter2 = 0; counter <= piecesA.length - 1; counter++)
          {
              if(piecesA[counter].equals(piecesB[counter]))
              {
              count2++;
              }
          }
        }
int a1= piecesA.length;
float a3=(float)count1*100/a1;
int b1= piecesB.length;
float b3= (float)count2*100/b1;
System.out.println("% of similarity is"+b3);   
        return checkForPlagiarism;
      
    }
public static void main(String args[])
{
Plagarism p=new Plagarism();
}
}
