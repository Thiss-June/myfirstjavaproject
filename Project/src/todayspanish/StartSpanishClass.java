package todayspanish;

public class StartSpanishClass {

	public static void main(String[] args) {
		MySpanish myspanish = new MySpanish();
		
		myspanish.setMySpanish("오늘의 스페인어");
		myspanish.getClass();
		myspanish.setExstingUsers("김동진", "정이리", "조승주", myspanish.existingUsers);
		myspanish.initAlarm();
	
		do {
			myspanish.selectCategory();
		}while(myspanish.ExitClass());
	}
}
