import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class JFCalendar extends Frame implements ItemListener,ActionListener,FocusListener
{
	JPanel jp1,jp2,jp3,j1,jday;
	Choice cm,cy;JTextField cd;
	JLabel js,jm,jt,jw,jth,jfr,jsat;
	JButton jb[]=new JButton[42];
	Calendar c;
	
	
	JFCalendar()
	{
//		super("Calender");
		
		
		
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(0,3,0,0));
		cm=new Choice();
		cm.add("Jan");
		cm.add("Feb");
		cm.add("Mar");	
		cm.add("Apr");
		cm.add("May");
		cm.add("Jun");
		cm.add("Jul");
		cm.add("Aug");
		cm.add("Sep");
		cm.add("Oct");
		cm.add("Nov");
		cm.add("Dec");
		jp1.add(cm);	
		
		cy=new Choice();
		for(int i=1900;i<2099;i++)
			cy.add(""+i);
		//cy.add("2016");
		
		cd=new JTextField(10);
		//cd.addFocusListener(this);
		
		jp1.add(cd);
		jp1.add(cm);
		jp1.add(cy);
		
	
		
		
		
		jday=new JPanel();
		jday.setLayout(new GridLayout(0,7));
		js=new JLabel("Sun");
		jm=new JLabel("Mon");
		jt=new JLabel("Tue");
		jw=new JLabel("Wed");
		jth=new JLabel("Thu");
		jfr=new JLabel("Fri");
		jsat=new JLabel("Sat");
		
		jday.add(js);
		jday.add(jm);
		jday.add(jt);
		jday.add(jw);
		jday.add(jth);
		jday.add(jfr);
		jday.add(jsat);
			
		jp2=new JPanel();
		jp2.setLayout(new GridLayout(6,7,0,0));

		
		
		for(int i=0;i<42;i++)
		{
			jb[i]=new JButton();
			jp2.add(jb[i]);
			jb[i].addActionListener(this);
			jb[i].addFocusListener(this);
			jb[i].setBackground(Color.white);
		}
	
	
		jp3=new JPanel();
	

		j1=new JPanel();
		j1.setLayout(new GridLayout(3,1,0,0));
		j1.add(jp1,"North");
		j1.add(jp2,"Center");
		j1.add(jday,"South");
	
		add(j1,"North");
		add(jp2,"Center");
		
		c=Calendar.getInstance();
		
		
		
		setSize(500,500);
		setVisible(true);
		
		
		//cd.addItemListener(this);
		cm.addItemListener(this);
		cy.addItemListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton jb1=(JButton)e.getSource();
		cd.setText(jb1.getActionCommand());
		
		new JF();
		
	}
	
	public void focusLost(FocusEvent e)
	{
		JButton jb1=(JButton)e.getSource();
		jb1.setBackground(Color.white);	
	}
	
	public void focusGained(FocusEvent e)
	{
		JButton jb1=(JButton)e.getSource();
		jb1.setBackground(Color.cyan);	
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		int m=0,y=0;
		String sm=cm.getSelectedItem();
		String sy=cy.getSelectedItem();
	
		if(sm.equals("Jan"))
			m=1;
		if(sm.equals("Feb"))
			m=2;
		if(sm.equals("Mar"))
			m=3;
		if(sm.equals("Apr"))
			m=4;
		if(sm.equals("May"))
			m=5;
		if(sm.equals("Jun"))
			m=6;
		if(sm.equals("Jul"))
			m=7;
		if(sm.equals("Aug"))
			m=8;
		if(sm.equals("Sep"))
			m=9;
		if(sm.equals("Oct"))
			m=10;
		if(sm.equals("Nov"))
			m=11;
		if(sm.equals("Dec"))
			m=12;
		
		y=Integer.parseInt(sy);
		
		m=m-1;
		c.set(y,m,1);
		
		String dt=""+c.getTime();
		String ss=dt.substring(0,3);
		
		int n=0;
		if(ss.equals("Sun"))
			n=0;
		if(ss.equals("Mon"))
			n=1;
		if(ss.equals("Tue"))
			n=2;
		if(ss.equals("Wed"))
			n=3;
		if(ss.equals("Thu"))
			n=4;
		if(ss.equals("Fri"))
			n=5;
		if(ss.equals("Sat"))
			n=6;
		
		int no=0;
		if(m%2==0&&m!=1||m==7)
			no=31;
		else if(m!=1)
			no=30;
		
		if(m==1)
		{
			if(m%4==0)
				no=29;
			else
				no=28;
		}
		
		for(int i=0;i<42;i++)
		{
			jb[i].setLabel("");
		}
		
		for(int i=n,a=1;i<n+no;i++,a++)
		{
			jb[i].setLabel(""+a);
		}
		
		
		
		
		//System.out.println("\n\nyear"+y+"month:"+m+"\n\n\n\n"+c.getTime());
	}

	public static void main(String []args)
	{
		new JFCalendar();
	}
}