import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;


//Alice Yang, 9 May 2019, CS210
//Bill Iverson
//Coding Assignment 3G

public class DayGrid2 {

	public static void main(String[] args) {
		showGrid(5 , 2019);
	}
	
	/* public static void showGrid (int month, int year) { //Iverson req. 2--prints month as a grid
		
		GregorianCalendar day =	new GregorianCalendar(year, month - 1, 0); //calendar stuff
		int firstDay = day.get(Calendar.DAY_OF_WEEK);
		int weekDay = firstDay;
		YearMonth DIM = YearMonth.of(year, month);
		gridTop();
		for (int i = 0; i < (firstDay); i++) { //Blank spaces at beginning of month
			System.out.print("       ");
		}
		
		for (int currentDate = 1; currentDate <= daysInMonth(month, year); currentDate++) { //prints the dates
			if (weekDay == 7) { //if you're at the last day of the week
				//find a way to end this line
				weekDay = 0;//restarts week
			}
			//System.out.printf("|  %2d  ", currentDate); replace with g.drawLine
			weekDay++;
		}
		
		for (int z = 0; z < (7-weekDay); z++) {
			System.out.print("|      ");
		}
		
	} */
	
	public static void showGrid (int month, int year) {
	
		GregorianCalendar day =	new GregorianCalendar(year, month - 1, 0); //calendar logic
		int firstDay = day.get(Calendar.DAY_OF_WEEK);
		int weekDay = firstDay;
		YearMonth DIM = YearMonth.of(year, month);
		
		DrawingPanel panel = new DrawingPanel (450, 250); //graphics stuff
		Graphics g = panel.getGraphics();
		g.drawRect(10, 10, 400, 200);
		
		int rows = 5; //5 weeks in month
		int column = 7; // 7 days of week
		int width = 410; 
		int height = 210;
		
		//header
		for (int i = 0; i <= 6; i++) {
			g.drawString(getDay(i) , 20 + (i*55), 10);
		}
		
		//draw the rows
		int rowHeight = height/rows;
		for (int i = 1; i < rows; i++) {
			g.drawLine(10, i * rowHeight, width, i * rowHeight);
		}		
		
		//write the days
		int y2 = 30; //controls the rows
		int x2 = firstDay;
			
		for (int currentDate = firstDay - 1; currentDate <= daysInMonth(month, year); currentDate++) { //prints the dates
			
			String date = String.format("    %2d  ", currentDate-firstDay+2);
			g.drawString(date, x2 * 58, y2); 
			
		
			if (weekDay == 7) { //if you're at the last day of the week
				y2 = y2 + 30;
				x2 = 1;
				weekDay = 0;//restarts week
			}
			
			weekDay++;
			x2++;
		}		
		
		//draw the columns
		int rowWidth = width / column; 
		for (int i = 1; i < column; i++) {
			g.drawLine(i * rowWidth, 10, i * rowWidth, height);
		}
	}
	
	public static void drawGrid () {
		
		
	}
	
	private static String getDay (int i) { //to draw header
		String day = "";
		
		if (i == 0) {
			day = "Sun";
		} else if (i == 1) {
			 day = "Mon";
		} else if (i == 2) {
			 day = "Tues";
		} else if (i == 3) {
			 day = " Wed";
		} else if (i == 4) {
			 day = "  Thurs";
		} else if (i == 5) {
			 day = "      Fri";
		} else {
			 day = "      Sat";
		}
		
		return day;
	}
	
	public static int daysInMonth(int month, int year) {
		int ret = 0;
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		boolean isLeapYear = cal.isLeapYear(cal.get(GregorianCalendar.YEAR));
		isLeapYear = cal.isLeapYear(year);
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 
				|| month == 10 || month == 12) {
			ret = 31;
		} else if (month == 2 && isLeapYear == true ) { //fixed to include leap years!
			ret = 29;
		} else if (month == 2 && isLeapYear == false) {
			ret = 28;
		} else {
			ret = 30;
		}
		return ret;
	}
	
}
