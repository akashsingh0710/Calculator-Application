package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
public class MainController {

	@FXML
	private Label result;
	@FXML
	private Label input_char;
	private float number1= 0;
	private String operator = "";
	private String transform="";
	private boolean start = true;
	private Model model = new Model();
	@FXML
	public void processNumbers(ActionEvent  event){
		if (start){
			result.setText("");
			//input_char.setText("");
			start = false;
			
		}
		
		String value = ((Button)event.getSource()).getText(); 
		//System.out.println('a'+value+'a');
		
		
		
		if(value.equals("DEL") ){
		    //System.out.println("I m in sir");
			if(transform.length() > 0){
				//result.setText( result.getText().substring(0, result.getText().length() - 1) );
				transform = transform.substring(0, transform.length() - 1);
				input_char.setText(input_char.getText().substring(0, input_char.getText().length() - 1));
				//System.out.println('b'+result.getText()+'b');
				//result.setText(result.getText());
				
				input_char.setText(input_char.getText());
				}
		}else {
			//System.out.println("I m out sir");
			//result.setText(result.getText()+value);
			transform = transform +value;
			System.out.println("number1 transform: " + transform);
			input_char.setText(input_char.getText() +value  );
		}
		
	}
	
	@FXML
	public void processOperators(ActionEvent  event ){
		String value = ((Button)event.getSource()).getText(); 
		input_char.setText(input_char.getText() +value  );
		if(!value.equals("=")){
			if(!operator.isEmpty())
				return;
			
			operator = value;
			
			//number1 =  Float.parseFloat(result.getText());
			
			number1 = Float.parseFloat(transform);
			transform="";
			//result.setText("");
			}else{
				if(operator.isEmpty())
					return;
				//float number2 =  Float.parseFloat(result.getText());
				float number2 =  Float.parseFloat(transform);
				
				System.out.println("number1: " + number1);
				System.out.println("number2: " + number2);
				System.out.println("operator: " + operator);
				float output = model.calculate(number1, number2, operator);
				System.out.println("output: " + output);
				System.out.println("Lalallalala");
				
				result.setText(String.valueOf(output));
				transform = String.valueOf(output);
				input_char.setText(String.valueOf(output)  );
				operator = "";
				start = true;
				
			}
		
	}
	
}
