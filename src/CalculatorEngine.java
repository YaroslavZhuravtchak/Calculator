import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
	Calculate calculate = new Calculate();
	Calculator calculator = new Calculator();
	String sign;
	double result;
	public CalculatorEngine(Calculator calculator) {
		this.calculator=calculator;
	}
	public void actionPerformed(ActionEvent e){
	
		JButton clickedButton=(JButton) e.getSource();
		String clickedButtonLabel = clickedButton.getText();
		
		if(clickedButtonLabel.equals("1/x")){
			String fromDisplay = calculator.getDisplayValue();
			if(fromDisplay.equals("ERROR")) calculator.setDisplayValue("ERROR");
			else if(fromDisplay.equals("")){}
			else if(fromDisplay.equals("0")){
				calculator.setDisplayValue("ERROR");
				
			}
			else{
			result=1/Double.valueOf(fromDisplay);
			if(((int)result)==result)
				calculator.setDisplayValue(""+(int)result);
			else calculator.setDisplayValue(""+result);
			}
		}
		else if(clickedButtonLabel.equals("+-")){
			String fromDisplay = calculator.getDisplayValue();
			if(fromDisplay.equals("ERROR")) calculator.setDisplayValue("ERROR");
			else {result=-Double.valueOf(fromDisplay);
			if(((int)result)==result)
				calculator.setDisplayValue(""+(int)result);
			else calculator.setDisplayValue(""+result);
			}
		}
		else if(clickedButtonLabel.charAt(0)>='0'&&clickedButtonLabel.charAt(0)<='9'){
			String fromDisplay = calculator.getDisplayValue();
			if(fromDisplay.equals("ERROR")) 
				calculator.setDisplayValue("ERROR");
			else 
				calculator.setDisplayValue(calculator.getDisplayValue()+clickedButtonLabel);
		}
		else if(clickedButtonLabel.charAt(0)=='.'){
			String fromDisplay = calculator.getDisplayValue();
			if(fromDisplay.equals("ERROR")) calculator.setDisplayValue("ERROR");
			else if(fromDisplay.equals(""))
				calculator.setDisplayValue("0.");
			else if(!fromDisplay.contains("."))
				calculator.setDisplayValue(fromDisplay+".");
			else
				calculator.setDisplayValue(fromDisplay);	
		}
		else if(clickedButtonLabel.equals("CE")){
			calculator.setDisplayValue("");
			result=0;
		}
		else if(clickedButtonLabel.equals("C")){
			calculator.setDisplayValue("");
		}
		else if(clickedButtonLabel.equals("+")||clickedButtonLabel.equals("-")||
				clickedButtonLabel.equals("*")||clickedButtonLabel.equals("/")||
				clickedButtonLabel.equals("^")
				){
			sign = clickedButtonLabel;
			String fromDisplay = calculator.getDisplayValue();
			if(fromDisplay.equals("ERROR")) calculator.setDisplayValue("ERROR");
			else if(fromDisplay.equals("")){}
			else{
				result = Double.valueOf(fromDisplay);
				calculator.setDisplayValue("");
			}
		}
		else if(clickedButtonLabel.equals("sqr")){
			
			String fromDisplay = calculator.getDisplayValue();
			
			if(fromDisplay.equals("ERROR")) calculator.setDisplayValue("ERROR");
			else if(fromDisplay.equals("")){}
			else{
			result=Math.sqrt(Double.valueOf(fromDisplay));
			if(((int)result)==result)
				calculator.setDisplayValue(""+(int)result);
			else calculator.setDisplayValue(""+result);
			}
		}
		else if(clickedButtonLabel.equals("<")){
			String fromDisplay = calculator.getDisplayValue();
			if(fromDisplay.equals("ERROR")) calculator.setDisplayValue("ERROR");
			else{
			fromDisplay=fromDisplay.substring(0, fromDisplay.length()-1);
			calculator.setDisplayValue(fromDisplay);
			}
		}
		else if(clickedButtonLabel.equals("=")){
			String fromDisplay = calculator.getDisplayValue();
			if(fromDisplay.equals("ERROR")) calculator.setDisplayValue("ERROR");
			else{
		    String str =calculate.culc(sign, result, Double.valueOf(calculator.getDisplayValue()));
		    if(str.equals("ERROR")) calculator.setDisplayValue(str);
		    else{
		    	result =Double.valueOf(str);
		    
				if(((int)result)==result)
					calculator.setDisplayValue(""+(int)result);
				else calculator.setDisplayValue(""+result);
		}}
		}
		}}
		