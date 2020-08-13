package todayspanish;

import java.util.ArrayList;
import java.util.Scanner;

public class MySpanish {
	//스페인어 공부 도우미 이름
	String title;
	ArrayList<String> todaylessons = new ArrayList();
	ArrayList<String> Quote = new ArrayList();
	boolean runing;
	
	//기존 계정 셋팅(메인함수에서 변경)
	String[] existingUsers = new String[3];
	String newUser;
	
	AprenderSpanish[] FraseHoy=new AprenderSpanish[2];
	AprenderSpanish[] QuizSpanish=new AprenderSpanish[2];
	// 입력이 중복막기 위함
	Scanner scan = new Scanner(System.in);
	//생성자
	public MySpanish() {
		setTodayLessons(); //오늘의 한마디 초기화
		setQuote();
	}

	 
	//스페인어 공부 도우미 이름 설정(메인함수에서 설정)
	
	public void setMySpanish(String title) {
		this.title = title;
	}
	//기존에 존재하던 계정 회원 등록
	public void setExstingUsers(String firstUser, 
			String secondUser, String thirdUser, String[] existingUsers) {
		
		UserList userList=new UserList();
		
		userList.setFirstUser(firstUser);
		userList.setSecondUser(secondUser);
		userList.setThirdUser(thirdUser);
		
		existingUsers[0]=userList.getFirstUser();
		existingUsers[1]=userList.getSecondUser();
		existingUsers[2]=userList.getThirdUser();
	}
	
	//앱 시작할 때 콘솔에 기본으로 찍히는 알림
	
	public void initAlarm() {
		System.out.println("=================================================================");
		System.out.println("# ¡Hola Tod@s!"+title+" ¡¡¡Bienvenido a Aprender Spanish Class!!! #");
		System.out.println("# 스페인어 수업에 오신 걸 환영합니다!!! #");
		System.out.println("# 저희 클래스에 방문하신 적이 있으신가요? [y/n] # ");
		System.out.println("# 방문여부: ");
		
		String isVisted = scan.next();
		
		switch (isVisted) {
			case "y":
				choiceAccount(); break;
			case "n":
				registerAccount(); break;
			default: 
				System.out.println("# 에러가 발생하였습니다. 프로그램을 종료합니다.#");
				System.exit(0); break;
		}
	}
	//기존 방문여부가 있을 경우, 존재하는 계정을 고르는 메소드
	
	public void choiceAccount() {
		System.out.println("==========================================");
		System.out.println("# 회원 조회 결과, 세 개 계정이 존재합니다. 어떤 계정이신가요? #");
		System.out.println("# 회원[1]: "+existingUsers[0]);
		System.out.println("# 회원[2]: "+existingUsers[1]);
		System.out.println("# 회원[3]: "+existingUsers[2]);
		System.out.println("# 선택 ↓↓↓ ##");
		
		int userNo=scan.nextInt();
		
		switch (userNo) {
			case 1: 
				firstUser(existingUsers[0]); break;
			case 2: 
				secondUser(existingUsers[1]); break;
			case 3: 
				thirdUser(existingUsers[2]); break;
			default:
				System.out.println("# 에러가 발생하였습니다. 프로그램을 종료합니다.");
				System.exit(0); break;
				
		}
	}
	//신규회원 등록 메소드
	public void registerAccount() {
		System.out.println("========================================");
		System.out.println("# 회원가입을 진행합니다.");
		System.out.println("# 이름을 입력해주세요.");
		
		newUser=scan.next();
		
		UserList userList=new UserList();
		userList.setNewUser(newUser);
		
		System.out.println("========================================");
		System.out.println("# "+userList.getNewUser()+" 님 환영해요!! ¡Bienvenid@! 원하시는 카테고리를 선택해주세요!");
		
		selectCategory();
		
	}
	public void firstUser(String firstUser) {
		System.out.println("=======================================");
		System.out.println("# "+ firstUser +" 님 환영해요! 원하시는 카테고리를 선택해주세요!");
		//selectCategory();
	}
	public void secondUser(String secondUser) {
		System.out.println("=======================================");
		System.out.println("# "+secondUser+" 님 환영해요! 원하시는 카테고리를 선택해주세요!");
//		selectCategory();
	}
	public void thirdUser(String thirdUser) {
		System.out.println("=======================================");
		System.out.println("# "+thirdUser+" 님 환영해요! 원하시는 카테고리를 선택해주세요!");
//		selectCategory();
	}
	//카테고리 목록 출력하기
	public void selectCategory() {
		System.out.println("## 카테고리 목록 ##");
		System.out.println("## 1.오늘의 한마디 ##");
		System.out.println("## 2.스페인어 Quiz ##");
		System.out.println("## 3.나가기 Salida ##");
		
		System.out.println("## 선택 ↓↓↓ ##");
		
		int categoryNo = scan.nextInt();
		
		printCategoryList(categoryNo);
	}
	
	//카테고리 해당 번호에 맞는 목록 출력
	public void printCategoryList(int categoryNo) {
		switch(categoryNo) {
			case 1:
				genAprenderSpanish();
				runing = true;
				break;
			case 2:
				QuizSpanish(); 
				runing = true;
				break;
			case 3:	
				runing = false;
				break;		
			default:
				System.out.println("# 에러가 발생하였습니다. 프로그램을 종료합니다.");
				System.exit(0); break;
		}
	}



	public void setTodayLessons() {
		todaylessons.add("¡Mucho ánimo! = 화이팅! 힘내!");
		todaylessons.add("¡Es pan comido! = 너무 쉽구만!");
		todaylessons.add("¡Se pone de mala leche! = 유치해!");
		todaylessons.add("¡Es un bombón! = 너무 매력적이야!");
		todaylessons.add("¡No pega ojo! = 한숨도 못잤어~");
		todaylessons.add("¡Se Pone morado! = 과식했어~!");
		todaylessons.add("¡Encuentra la media naranja! = 너의 이상형을 찾아봐!");
	}

	// 컨텐츠 생성. 1.오늘의 한마디
	public void genAprenderSpanish() {
		int random = (int) (Math.random()*7);
		System.out.println("오늘의 한마디! -> "+todaylessons.get(random)); 
		System.out.println("===================================");
		System.out.println("");
	}
	// 컨텐츠 생성. 2. Quiz
	public void QuizSpanish() {
		System.out.println("===================================");
		System.out.println("레벨을 선택해주세요!");
		System.out.println("레벨 -> 1(쉬움), 2(보통), 3(어려움) ");
		System.out.println("숫자를 적어주세요!");
		System.out.println("## 선택 ↓↓↓ ##");
		
		String selectLevel = scan.next();
		
		switch(selectLevel) {
		case "1":
			choiceLevel1(); break;
		case "2":
			choiceLevel2(); break;
		case "3":
			choiceLevel3(); break;
		
		default: 
			System.out.println("# 에러가 발생하였습니다. 프로그램을 종료합니다.#");
			System.exit(0); break;
		}
	}
	public void choiceLevel1() {
		System.out.println("==============================");
		System.out.println("문제를 풀어보세요!");
		System.out.println("아침 인사는 어떤 것인가요?");
		System.out.println("1."+ "¡Buenos días! ");
		System.out.println("2."+ "¡Adios! ");
		System.out.println("3."+ "¡Hasta luego!");
		System.out.println("정답을 적어주세요.");
		System.out.println("## 선택 ↓↓↓ ##");
		
		int myAnswer = scan.nextInt();
		//System.out.println("정답은"+myAnswer);
		scan.nextLine();
		
		
		if(myAnswer == 1) {
			System.out.println("정답입니다! 처음으로 돌아갑니다!");
			System.out.println("=============================");
			System.out.println("");
		}
		
		else {
			System.out.println("아니라구요 ㅠㅠ");
			System.out.println("처음으로 돌아갑니다.");
			System.out.println("==============================");
			System.out.println("");
		}
		return;
	}


	public void choiceLevel2() {
		System.out.println("=================================");
		System.out.println("문제를 풀어보세요!");
		System.out.println("빈칸에 들어갈 말은???");
		System.out.println("La semana pasada ______" + 
				"haciendo un curso de formación de dos días en Buenos Aires");
		System.out.println("1. estaba ");
		System.out.println("2. estuve");
		System.out.println("3. tuvo");
		System.out.println("정답을 적어주세요.");
		System.out.println("## 선택 ↓↓↓ ##");
		
		int myAnswer = scan.nextInt();
		scan.nextLine();
		
		
		if(myAnswer == 2) {
			System.out.println("정답입니다! 처음으로 돌아갑니다!");
			System.out.println("=============================");
			System.out.println("");
		}
		else {
			System.out.println("아니라구요 ㅠㅠ");
			System.out.println("처음으로 돌아갑니다.");
			System.out.println("==============================");
			System.out.println("");
		}
		return;
	}

	public void choiceLevel3() {
		System.out.println("=================================");
		System.out.println("문제를 풀어보세요!");
		System.out.println("속담의 뜻은 무엇일까요???");
		System.out.println("Dime con quién andas y te diré quién eres.");
		System.out.println("1. 발 없는 말이 천리간다 ");
		System.out.println("2. 친구를 보면 네가 누구인지 알 수 있다");
		System.out.println("3. 한마디 말로 천냥 빚을 갚는다");
		System.out.println("정답을 적어주세요.");
		System.out.println("## 선택 ↓↓↓ ##");
		
		int myAnswer = scan.nextInt();
		scan.nextLine();
		
		
		if(myAnswer == 2) {
			System.out.println("정답입니다! 처음으로 돌아갑니다!");
			System.out.println("==============================");
			System.out.println("");
		}
		else {
			System.out.println("아니라구요 ㅠㅠ");
			System.out.println("처음으로 돌아갑니다.");
			System.out.println("==============================");
			System.out.println("");
		}
		return;
	}
	
	//3번 나가기
	public void setQuote() {
		Quote.add("Si nada nos salva de la muerte, "+
			"al menos que el amor nos salva de la vida."
				+"(죽음으로부터 그 무엇도 우리를 구원해주지 않지만, 적어도 사랑은 우리 인생을 구원해준다.)"
			+", Pablo Neruda(네루다)"	);
		Quote.add("No hay ningún viaje malo, excepto el que conduce a la horca."
			+" (나쁜 여행이란 건 없다. 교수대로 가는 거 말고는)"+",  Cervantes(세르반테스)");
		Quote.add("El miedo es el comienzo de la sabiduría"+"(두려움이란 앎의 시작이다.)"+", Unamuno(우나무노)");
	}
	
	public boolean ExitClass() {
		int random = (int) (Math.random()*3);
		System.out.println("================================");
		System.out.println("## 수고 많으셨습니다! ##");
		System.out.println("## 다음에 다시 만나요~! ##");
		
		System.out.println(Quote.get(random));
		System.out.println("");
		System.out.println("## 프로그램이 종료되었습니다. ##");
		
		return runing;
	} 
}
