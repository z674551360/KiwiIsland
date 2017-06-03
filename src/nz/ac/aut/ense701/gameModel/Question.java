package nz.ac.aut.ense701.gameModel;

public class Question {
	private String question;
	private String sectionOne;
	private String sectionTwo;
	private String sectionThree;
	private String answer;
	
	public Question(String question, String sectionOne, String sectionTwo, String sectionThree, String answer){
		this.question=question;
		this.sectionOne=sectionOne;
		this.sectionTwo=sectionTwo;
		this.sectionThree=sectionThree;
		this.answer=answer;
	}
	
	public String getQuestion() {
		return question;
	}

	public String getSectionOne() {
		return sectionOne;
	}

	public String getSectionTwo() {
		return sectionTwo;
	}

	public String getSectionThree() {
		return sectionThree;
	}

	public String getAnswer() {
		return answer;
	}

}
