/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package environmental.stewardship.assignment;

/**
 *
 * @author SyphiN
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

class Quiz{
  public List<Question> questionList = new ArrayList<Question>();
  private boolean answerResults[];
  Quiz(Question q[]){
    questionList = Arrays.asList(q);
    answerResults = new boolean[questionList.size()];
    Arrays.fill(answerResults, false);
  }

  Quiz(){
    questionList = new ArrayList<Question>(10);
    answerResults = new boolean[10];
    Arrays.fill(answerResults, false);
    //System.out.println(questionList.size());
  }

  Quiz(int length){
    answerResults = new boolean[length];
    Arrays.fill(answerResults, false);
  }
  
  public void setQuestion(int index,Question question){
    questionList.add(index, question);
  }
  
  public boolean askQuestion(int qNum){
    boolean answerResult;
    Scanner input = new Scanner(System.in);
    do{
      try{
        System.out.println(questionList.get(qNum).FormatQuestion());
        System.out.print("Your Answer: ");
        String answer = input.nextLine();
        if (questionList.get(qNum).getAnswer().equals(answer)){
          answerResult = true;
          answerResults[qNum] = true;
        }else{
          answerResult = false;
          answerResults[qNum] = false;
        }
        break;
      }catch(Exception e){
        System.out.println("There is an issue with this Question or there exists no question at this index");
        return false;
      }
    }while(true);
    return answerResult;
  }

  public void StartQuiz(){
    for(int i=0;i<questionList.size();i++){
      System.out.printf("%d)",i+1);
      if (askQuestion(i)){
        System.out.println("CORRECT!\n");
      }else{
        System.out.println("Answer is WRONG.\n");
      }
    }
    System.out.println("Your final score was "+getResults());
  }
  
  public boolean answer(int qNum,String answer){
      answerResults[qNum] = questionList.get(qNum).getAnswer().equals(answer); //answerResult = true;
      return answerResults[qNum];
      //answerResult = false;
  }

  public void askQuestion(int i,javax.swing.JLabel qLabel, javax.swing.JRadioButton a, javax.swing.JRadioButton b, javax.swing.JRadioButton c, javax.swing.JRadioButton d){
    
    //System.out.printf("%d)",i+1);
    try{
        qLabel.setText(String.format("%d) %s",i+1,questionList.get(i).getQuestion()));
        a.setText(questionList.get(i).getOptionA());
        b.setText(questionList.get(i).getOptionB());
        c.setText(questionList.get(i).getOptionC());
        d.setText(questionList.get(i).getOptionD());
    }catch(Exception NullpointerException){
        System.out.println("No Question Found");
    }
  }
  public double getPercentage(){
    return ((double)getScore()/answerResults.length)*100.0;
  }

  public int getScore(){
    int score = 0;
    for(int i = 0; i<answerResults.length; i++){
      if(answerResults[i]){
        score++;
      }
    }
    return score;
  }

  public String getResults(){
    return (getScore()+" out of "+answerResults.length);
  }

  public void setAnswerResults(int index, boolean newResult){
    answerResults[index] = newResult;
  }

  public boolean getIndividualAnswerResults(int index){
    return answerResults[index];
  }

  public boolean[] getAnswerResults(){
    return answerResults;
  }
  public int getQuizLength(){
    return questionList.size();
  }
}
