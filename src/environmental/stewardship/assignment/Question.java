/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package environmental.stewardship.assignment;

/**
 *
 * @author SyphiN
 */
class Question{
  public String question;
  public String optionA;
  public String optionB;
  public String optionC;
  public String optionD;
  public String answer;
  
  public Question(String questionText, String a, String b, String c, String d, String ans){
    question  = questionText;
    optionA = a;
    optionB = b;
    optionC = c;
    optionD = d;
    answer = ans;
  }

  //Get Methods:
  public String getOptionA(){
    return optionA;
  }

  public String getOptionB(){
    return optionB;
  }

  public String getOptionC(){
    return optionC;
  }

  public String getOptionD(){
    return optionD;
  }

  public String getQuestion(){
    return question;
  }

  public String getAnswer(){
    return answer;
  }

  //Set Methods:
  public void setOptionA(String newA){
    optionA = newA;
  }

  public void setOptionB(String newB){
    optionB = newB;
  }

  public void setOptionC(String newC){
    optionC = newC;
  }

  public void setOptionD(String newD){
    optionD = newD;
  }

  public void setQuestion(String newQuestion){
    question = newQuestion;
  }
  
  public void setAnswer(String newAnswer){
    answer = newAnswer;
  }

  //Other Methods
  public boolean Answer(String choice){
    if(choice.equals(answer)) return true;
    else return false;
  }

  public String FormatQuestion(){
    return String.format("%s\n\n\na. %s\n\nb. %s\n\nc. %s\n\nd. %s\n\n",question,optionA,optionB,optionC,optionD);
  }
}
