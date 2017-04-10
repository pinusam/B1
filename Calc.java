import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Calc extends JFrame 
{
JFrame frame;
JLabel lbl1,lbl2,lblresult;
JTextField txt1,txt2,txtresult;
JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
Container container;
public Calc()
{
frame=new JFrame("Calculator App");
container = getContentPane();
container.setLayout(new FlowLayout());
JPanel p1=new JPanel();
lbl1=new JLabel("No1");
txt1=new JTextField(20);
p1.add(lbl1);
p1.add(txt1);

JPanel p2=new JPanel();
lbl2=new JLabel("No2");
txt2=new JTextField(20);
p2.add(lbl2);
p2.add(txt2);

JPanel p3=new JPanel();
lblresult=new JLabel("Result");
txtresult=new JTextField(20);
p3.add(lblresult);
p3.add(txtresult);

JPanel p4=new JPanel();
btn1=new JButton("SIN");
btn1.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	double n1=Double.parseDouble(txt1.getText());
	double radians=Math.toRadians(n1);
	double s=Math.sin(radians);
	txtresult.setText(" "+s);
	}
});
btn2=new JButton("COS");
btn2.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	double n2=Double.parseDouble(txt1.getText());
	double radian=Math.toRadians(n2);
	double c=Math.cos(radian);
	txtresult.setText(" "+Math.round(c));
	}
});
btn3=new JButton("TAN");
btn3.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	double n3=Double.parseDouble(txt1.getText());
	double radian1=Math.toRadians(n3);
	double t=Math.tan(radian1);
	txtresult.setText(" "+t);
	}
});

btn4=new JButton("+");
btn4.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	double no1=Double.parseDouble(txt1.getText());
	double no2=Double.parseDouble(txt2.getText());
	double t=no1+no2;
	txtresult.setText(" "+t);
	}
});

btn5=new JButton("-");
btn5.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	double no1=Double.parseDouble(txt1.getText());
	double no2=Double.parseDouble(txt2.getText());
	double t=no1-no2;
	txtresult.setText(" "+t);
	}
});

btn6=new JButton("*");
btn6.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	double no1=Double.parseDouble(txt1.getText());
	double no2=Double.parseDouble(txt2.getText());
	double t=no1*no2;
	txtresult.setText(" "+t);
	}
});

btn7=new JButton("/");
btn7.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	double no1=Double.parseDouble(txt1.getText());
	double no2=Double.parseDouble(txt2.getText());
	double t=no1/no2;
	txtresult.setText(" "+t);
	}
});

p4.add(btn1);
p4.add(btn2);
p4.add(btn3);
p4.add(btn4);
p4.add(btn5);
p4.add(btn6);
p4.add(btn7);
container.add(p1);
container.add(p2);
container.add(p3);
container.add(p4);
setSize(500, 325);
setVisible(true);
}
public static void main(String args[])
{
Calc c=new Calc();
}
} 
