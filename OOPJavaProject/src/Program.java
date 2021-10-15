
public class Program {

	//컴파일 -> Exam.class
	//압축 -> Exam.zip
	//파일명 바꾸기 (java를 위한 압축파일 jar, 배포됨) -> Exam.jar
	
	public static void main(String[] args) {
		NewlecExam exam = new NewlecExam();
//		exam.setKor(10);
//		exam.setEng(10);
//		exam.setMath(10);
//		exam.setCom(10);
		System.out.println(exam.total());
		System.out.println(exam.avg());
		
	}

}
