package patrickschreiner.CS602.Week5;

import java.awt.*;
import java.util.Calendar;

public class DigitalClock extends java.applet.Applet implements Runnable 
{
	protected Thread clockThread = null;
	protected Font font = new Font("Calibri", Font.BOLD, 48);
	protected Color color = Color.BLACK;
	protected Dimension d;
	
	public void init()
	{
		d = getSize();
	}
	
	public void start() 
	{
		if (clockThread == null) 
		{
			clockThread = new Thread(this);
			clockThread.start();
			}
	}
	
	public void stop()
	{
		clockThread = null;
	}
	
	public void run()
	{
		while (Thread.currentThread() == clockThread)
		{
			repaint();
			try
			{
				Thread.currentThread().sleep(1000);
			}
			catch (InterruptedException e)
			{
			
			}
		}
	}
	
	public void paint(Graphics g)
	{
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String month = MonthStr(calendar.get(Calendar.MONTH));
		String day = DayStr(calendar.get(Calendar.DAY_OF_WEEK));
		String amorpm = AMPMStr(calendar.get(Calendar.AM_PM));
		int dayofmonth = calendar.get(Calendar.DAY_OF_MONTH);
		int year = calendar.get(Calendar.YEAR);
		String romanHour = getRomanNum(calendar.get(Calendar.HOUR));
		String romanMinute = getRomanNum(calendar.get(Calendar.MINUTE));
		String romanSecond = getRomanNum(calendar.get(Calendar.SECOND));
		
		
		
		g.setFont(font);
		g.setColor(color);
		g.drawString(((hour + 11) % 12 + 1) + ":" + minute / 10 + minute % 10 +
							":" + second / 10 + second % 10 + " " + amorpm,
							10, 60);
		g.drawString(day + ", " + month + " " + dayofmonth + ", " + year, 10, 180);
		g.drawString(romanHour + ":" + romanMinute + ":" + romanSecond + " " + amorpm, 10, 120);
		
		if ((minute == 0 || minute == 15 || minute == 30 || minute == 45) && second == 0)
		{
			PeriodicEvent();
		}
	 
		
	}
	
	public static String DayStr (int dayofweek)
	{
		String daynames[] = {"Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat",};
		
			if (dayofweek <= daynames.length)
			{
				return daynames[dayofweek-1];
			}
			else
				return "Error";
	}
	
	public static String MonthStr (int month)
	{
		String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
			if (month < months.length)
			{
				return months[month];
			}
			else
			{
				return "Error";
			}
			
	}
	
	public static String AMPMStr (int daynight)
	{
		String ampm[] = {"AM", "PM"};
		
			if (daynight < ampm.length)
			{
				return ampm[daynight];
			}
			else
			{
				return "Error";
			}
		
		
	}
	public void PeriodicEvent()
	{
		Toolkit.getDefaultToolkit().beep();
	}
	
	public String getRomanNum (int num)
	{
		String rom = "";
		while (num >= 100)
		{
			rom += "C";
			num = num - 100;
		}
		while (num >= 90)
		{
			rom += "XC";
			num = num - 90;
		}
		while (num >= 50)
		{
			rom += "L";
			num = num - 50;
		}
		while (num >= 40)
		{
			rom += "XL";
			num = num - 40;
		}
		while (num >= 10)
		{
			rom += "X";
			num = num - 10;
		}
		while (num >= 9)
		{
			rom += "IX";
			num = num - 9;
		}
		while (num >= 5)
		{
			rom += "V";
			num = num - 5;
		}
		while (num >= 4)
		{
			rom += "IV";
			num = num - 4;
		}
		while (num >= 1)
		{
			rom += "I";
			num = num - 1;
		}
		return rom;
		
	}

}
