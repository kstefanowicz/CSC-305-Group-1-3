
/**
 * @author Kevin Stefanowicz
 * Class class to represent an academic class.
 * Created for David Brown's CSC 305 class, Spring 2017 semester.
 */
public class AClass {

	/**
	 * Title of the class
	 */
	private String ClassTitle;
	
	/**
	 * Start and end times, hour and minute
	 */
	private int StartTimeH, StartTimeM, EndTimeH, EndTimeM;
	
	/**
	 * Array of booleans representing days M-F the class takes place.
	 */
	private boolean[] Days = new boolean[5];

	/**
	 * Default constructor with no parameters.
	 */
	AClass(){
		this("",0,0,0,0, (new boolean[] {false, false, false, false, false}));
	}

	/**
	 * Constructor with title and days.
	 * @param p_title Class title
	 * @param p_days Class days
	 */
	AClass(String p_title, boolean[] p_days){
		this(p_title,0,0,0,0, p_days);
	}

	/**
	 * Constructor with title, days, and start/end hours.
	 * @param p_title Class title
	 * @param p_startH Start time (hour)
	 * @param p_endH End time (hour)
	 * @param p_days Class days
	 */
	AClass(String p_title, int p_startH, int p_endH, boolean[] p_days){
		this(p_title,p_startH,0,p_endH,0, p_days);
	}

	/**
	 * Constructor with days and start/end hours.
	 * @param p_startH Start time (hour)
	 * @param p_endH Start time (hour)
	 * @param p_days Class days
	 */
	AClass(int p_startH, int p_endH, boolean[] p_days){
		this("",p_startH,0,p_endH,0, p_days);
	}

	/**
	 * Constructor with days and start/end hours and minutes.
	 * @param p_startH Start time (hour)
	 * @param p_startM Start time (minute)
	 * @param p_endH End time (hour)
	 * @param p_endM End time (minute)
	 * @param p_days Class days
	 */
	AClass(int p_startH, int p_startM, int p_endH, int p_endM, boolean[] p_days){
		this("",p_startH,p_startM,p_endH,p_endM, p_days);
	}

	/**
	 * Constructor with class title, days, and start/end hours and minutes.
	 * @param p_title Class title
	 * @param p_startH Start time (hour)
	 * @param p_startM Start time (minute)
	 * @param p_endH End time (hour)
	 * @param p_endM End time (minute)
	 * @param p_days Class days
	 */
	AClass(String p_title, int p_startH, int p_startM, int p_endH, int p_endM, boolean[] p_days){
		setClassTitle(p_title);
		setStartTimeH(p_startH);
		setStartTimeM(p_startM);
		setEndTimeH(p_endH);
		setEndTimeM(p_endM);
		setDays(p_days);
	}

	/**
	 * @return Class title
	 */
	public String getClassTitle() {
		return ClassTitle;
	}

	/**
	 * @param classTitle Class title
	 */
	public void setClassTitle(String classTitle) {
		ClassTitle = classTitle;
	}

	/**
	 * @return Class days
	 */
	public boolean[] getDays() {
		return Days;
	}

	/**
	 * @param days Class days.
	 */
	public void setDays(boolean[] days) {
		Days = days;
	}

	/**
	 * @return Start time (hour)
	 */
	public int getStartTimeH() {
		return StartTimeH;
	}

	/**
	 * @param startTimeH Start time (hour)
	 */
	public void setStartTimeH(int startTimeH) {
		StartTimeH = startTimeH;
	}

	/**
	 * @return Start time (minute)
	 */
	public int getStartTimeM() {
		return StartTimeM;
	}

	/**
	 * @param startTimeM Start time (minute)
	 */
	public void setStartTimeM(int startTimeM) {
		StartTimeM = startTimeM;
	}

	/**
	 * @return End time (hour)
	 */
	public int getEndTimeH() {
		return EndTimeH;
	}

	/**
	 * @param endTimeH End time (hour)
	 */
	public void setEndTimeH(int endTimeH) {
		EndTimeH = endTimeH;
	}

	/**
	 * @return End time (minute)
	 */
	public int getEndTimeM() {
		return EndTimeM;
	}

	/**
	 * @param endTimeM End time (minute)
	 */
	public void setEndTimeM(int endTimeM) {
		EndTimeM = endTimeM;
	}

	/**
	 * Calculates if a given array of days collides with the class's days.
	 * @param a Class days
	 * @return If days collide
	 */
	private boolean dayCollide(boolean[] a){
		for (int i = 0; i < a.length; i++){
			if (a[i] == Days[i]){
				return true;
			}
		}

		return false;
	}

	/**
	 * Calculates if a given class collides with the class.
	 * @param other Class
	 * @return If classes collide
	 */
	public boolean isCollision(AClass other){
		
		if (getEndTimeH() < other.getStartTimeH()){
			return false;
		}
		else if (other.getEndTimeH() < getStartTimeH()){
			return false;
		}
		else if (other.getEndTimeH() == getStartTimeH()){
			if (other.getEndTimeM() < getStartTimeM()){
				return false;
			}
		}
		else if (getEndTimeH() == other.getStartTimeH()){
			if (getEndTimeM() < other.getStartTimeM()){
				return false;
			}
		}

		if (dayCollide(other.getDays())){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Calculates if a given class collides with the class on a specific day.
	 * @param other Class
	 * @param day Day (0 = Monday, 4 = Friday)
	 * @return
	 */
	public boolean isCollisionDay(AClass other, int day){
		if (getEndTimeH() < other.getStartTimeH()){
			
			return false;
		}
		else if (other.getEndTimeH() < getStartTimeH()){
			return false;
		}
		else if (other.getEndTimeH() == getStartTimeH()){
			if (other.getEndTimeM() < getStartTimeM()){
				return false;
			}
		}
		else if (getEndTimeH() == other.getStartTimeH()){
			if (getEndTimeM() < other.getStartTimeM()){
				return false;
			}
		}
		
		if (other.getDays()[day] == getDays()[day]){
			return true;
		}
		
		return false;
	}

}
