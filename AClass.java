
public class AClass {

	private String ClassTitle;
	private int StartTimeH, StartTimeM, EndTimeH, EndTimeM;
	
	AClass(){
		this("",0,0,0,0);
	}
	
	AClass(String p_title){
		this(p_title,0,0,0,0);
	}
	
	AClass(String p_title, int p_startH, int p_endH){
		this(p_title,p_startH,0,p_endH,0);
	}
	
	AClass(int p_startH, int p_endH){
		this("",p_startH,0,p_endH,0);
	}
	
	AClass(int p_startH, int p_startM, int p_endH, int p_endM){
		this("",p_startH,p_startM,p_endH,p_endM);
	}
	
	AClass(String p_title, int p_startH, int p_startM, int p_endH, int p_endM){
		setClassTitle(p_title);
		setStartTimeH(p_startH);
		setStartTimeM(p_startM);
		setEndTimeH(p_endH);
		setEndTimeM(p_endM);
	}

	public String getClassTitle() {
		return ClassTitle;
	}

	public void setClassTitle(String classTitle) {
		ClassTitle = classTitle;
	}

	public int getStartTimeH() {
		return StartTimeH;
	}

	public void setStartTimeH(int startTimeH) {
		StartTimeH = startTimeH;
	}

	public int getStartTimeM() {
		return StartTimeM;
	}

	public void setStartTimeM(int startTimeM) {
		StartTimeM = startTimeM;
	}

	public int getEndTimeH() {
		return EndTimeH;
	}

	public void setEndTimeH(int endTimeH) {
		EndTimeH = endTimeH;
	}

	public int getEndTimeM() {
		return EndTimeM;
	}

	public void setEndTimeM(int endTimeM) {
		EndTimeM = endTimeM;
	}
	
	
	
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
		
		return true;
	}
	
}
