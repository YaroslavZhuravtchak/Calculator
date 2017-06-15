
public class Calculate {
    public double add(double first, double second){
        return first+second;
    }
    public double sub(double first, double second){
        return first-second;
    }
    public double mul(double first, double second){
        return first*second;
    }
    public double div(double first, double second){
        return first/second;
    }
    public double extend(double first, double second){
        double sum= first;
        for(int i=1;i<second;i++)
            sum *=first;
        return sum;
    }
    public String culc(String sign, double first, double second){
        if(sign.equals("+")) {
            return ""+add(first,second);
        }
        else if(sign.equals("-")) {
            return ""+sub(first,second);
        }
        else if(sign.equals("*")) {
            return ""+mul(first,second);
        }
        else if(sign.equals("/")) {
        	if(second==0) return "ERROR";
        	else return ""+div(first,second);
        }
        else if(sign.equals("^")) {
            return ""+extend(first,second);
        }
        
        else throw new RuntimeException("Bad operator");
    }
}