import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 /** Class Booth with swing**/
public class BoothNew extends JFrame
{
JFrame frame;
JLabel lbl1,lbl2,lblResult;
JTextField txt1,txt2;
JTextArea txtOutput;
JButton b;
Container container;
public BoothNew()
{
frame=new JFrame("Booth's Multiplication ");
container = getContentPane();
container.setLayout(new FlowLayout());
JPanel p1=new JPanel();
lbl1=new JLabel("Enter First number");
p1.add(lbl1);
txt1=new JTextField(20);
p1.add(txt1);
JPanel p2=new JPanel();
lbl2=new JLabel("Enter second number");
p2.add(lbl2);
txt2=new JTextField(20);
p2.add(txt2);
JPanel p3=new JPanel();
b=new JButton("Multiply");
b.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	int n1=Integer.parseInt(txt1.getText());
	int n2=Integer.parseInt(txt2.getText());
	int result = multiply(n1, n2);
	txtOutput.append("Result: "+n1+" * "+n2+" = "+result);
	}
});

p3.add(b);
JPanel p4=new JPanel();
lblResult=new JLabel("Result ");
p4.add(lblResult);
txtOutput=new JTextArea(5,20);
p4.add(txtOutput);
container.add(p1);
container.add(p2);
container.add(p3);
container.add(p4);
setSize(500, 325);
setVisible(true);
}

       public int multiply(int n1, int n2)
    {
        int[] m = binary(n1);     //original number
        int[] m1 = binary(-n1);   //2's complement of m(multiplicand)
        int[] r = binary(n2);        //1's complement of m (multiplier)
        int[] A = new int[9];           //it contain leftmost bits as m and remaining (y+1)bits with zeros
        int[] S = new int[9];		//it contain leftmost bits as 2's complement of m (-m) and remaining bits as zeros
        int[] P = new int[9];        //it contain leftmost bits as zeros and remaining bits as value of r
        for (int i = 0; i < 4; i++)
        {
            A[i] = m[i];
            S[i] = m1[i];
            P[i + 4] = r[i];
        }
        display(A, "A");
        display(S, "S");
        display(P, "P");
        System.out.println();
        for (int i = 0; i < 4; i++)
        {
            if (P[7] == 0 && P[8] == 0);
                // do nothing and perform arithmetic shift
            else if (P[7] == 1 && P[8] == 0)
                add(P, S);
            else if (P[7] == 0 && P[8] == 1)
                add(P, A);
            else if (P[7] == 1 && P[8] == 1);
                // do nothing and perform arithmetic shift
            rightShift(P);
            display(P, "P");
        }
        return getDecimal(P);
    }

  public int getDecimal(int[] B)
    {
        int p = 0;
        int t = 1;
        for (int i = 7; i >= 0; i--, t *= 2)
            p += (B[i] * t);
        if (p > 64)
            p = -(256 - p);
        return p;
    }

    public void rightShift(int[] A)
    {
        for (int i = 8; i >= 1; i--)
            A[i] = A[i - 1];
    }

    public void add(int[] A, int[] B)
    {
        int carry = 0;
        for (int i = 8; i >= 0; i--)
        {
            int temp = A[i] + B[i] + carry;
            A[i] = temp % 2;
            carry = temp / 2;
        }
    }

    public int[] binary(int n)
    {
        int[] bin = new int[4];
        int ctr = 3;
        int num = n;

        if (n < 0)
            num = 16 + n;
        while (num != 0)
        {
            bin[ctr--] = num % 2;
            num /= 2;
        }
        return bin;
    }

    public void display(int[] P, String ch)
    {
      System.out.print("\n"+ ch +" : ");
	  //txtOutput.setText("\n"+ch+":");
      for (int i = 0; i < P.length; i++)
        {
            if (i == 4)
                txtOutput.setText(" ");
            if (i == 8)
                txtOutput.setText(" ");
         System.out.print(P[i]);
	  //txtOutput.append(""+P[i]);
       }
    }


    public static void main (String[] args)
    {

                BoothNew n=new BoothNew();
    }
}

