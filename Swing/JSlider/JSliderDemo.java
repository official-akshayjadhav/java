// program: Color Chooser with Jslider
// Author: hemant

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
class JSliderDemo extends JFrame implements ChangeListener
{
	JLabel sbar;
	JSlider slider1,slider2,slider3;
	JPanel p;
	Container co;
	JSliderDemo()
	{

		setLayout(null);

		//sbar=new JLabel("value is :");
		//sbar.setBounds(100,300,300,40);
		//add(sbar);

		p=new JPanel();
		p.setBounds(150,20,400,400);
		p.setBackground(Color.black);
		add(p);

		slider1 = new JSlider(0, 255, 0);
		slider1.setBounds(150,500,300,40);
        slider1.setMinorTickSpacing(5);
        slider1.setMajorTickSpacing(10);
        slider1.setPaintTicks(true);
		add(slider1);
		slider1.addChangeListener(this);

		slider2 = new JSlider(0,255, 0);
		slider2.setBounds(150,550,300,40);
        slider2.setMinorTickSpacing(5);
        slider2.setMajorTickSpacing(10);
        slider2.setPaintTicks(true);
		add(slider2);
		slider2.addChangeListener(this);

		slider3 = new JSlider(0, 255, 0);
		slider3.setBounds(150,600,300,40);
        slider3.setMinorTickSpacing(5);
        slider3.setMajorTickSpacing(10);
        slider3.setPaintTicks(true);
		add(slider3);
		slider3.addChangeListener(this);

		setSize(700,700);
		setVisible(true);
	}
	public void stateChanged(ChangeEvent ce)
	{
		p.setBackground(new Color(slider1.getValue(),slider2.getValue(),slider3.getValue()));
		repaint();
	}
	public static void main(String args[])
	{
			new JSliderDemo();
	}
}
