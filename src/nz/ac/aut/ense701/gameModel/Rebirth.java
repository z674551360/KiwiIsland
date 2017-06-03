package nz.ac.aut.ense701.gameModel;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Rebirth {
	private ArrayList<Question> questions;
	private int failCount;
	private int successCount;
	
	public Rebirth(){
		questions = new ArrayList<Question>();
		String fileName = "questions.txt";
		File file = new File(fileName);
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input.useLocale(Locale.US);
		input.useDelimiter("\n");
		while(input.hasNext()){
			String question = input.next();
			String selectionOne = input.next();
			String selectionTwo = input.next();
			String selectionThree = input.next();
			String answer = input.next();
			
			Question newQuestion = new Question(question,selectionOne,selectionTwo,selectionThree,answer);
			questions.add(newQuestion);
		}
	}
	
	public boolean RandomQuestion(){
		failCount=0;
		successCount=0;
		while(failCount<4 && (failCount+successCount)<10){
			int randomNum = new Random().nextInt(questions.size()-1);
			Question question = questions.get(randomNum);
			questions.remove(randomNum);
			JOptionPane answering = new JOptionPane();
			answering.setMessage(null);
			JLabel questionTxt = new JLabel(question.getQuestion());;
			JRadioButton sectionOneButton = new JRadioButton("A: "+question.getSectionOne());
			JRadioButton sectionTwoButton = new JRadioButton("B: "+question.getSectionTwo());
			JRadioButton sectionThreeButton = new JRadioButton("C: "+question.getSectionThree());
			answering.setLayout(new GridLayout(10,1,1,1));
			answering.add(questionTxt);
			answering.add(sectionOneButton);
			answering.add(sectionTwoButton);
			answering.add(sectionThreeButton);
			JDialog localJDialog = answering.createDialog(answering, "Answer the questions for rebirth");
			localJDialog.setVisible(true);
			if(sectionOneButton.isSelected()){
				if(question.getSectionOne().equals(question.getAnswer())){
					successCount++;
				}else{
					failCount++;
				}
			}else if(sectionTwoButton.isSelected()){
				if(question.getSectionTwo().equals(question.getAnswer())){
					successCount++;
				}else{
					failCount++;
				}
			}else if(sectionThreeButton.isSelected()){
				if(question.getSectionThree().equals(question.getAnswer())){
					successCount++;
				}else{
					failCount++;
				}
			}else{
				failCount++;
			}
		}
		if(successCount>=7){
			return true;
		}else{
			return false;
		}
	}
}
