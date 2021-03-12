package vitals;

public class Main {
		
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {    	
    	boolean isTempOk = false;
    	boolean issocOk = false;
    	boolean ischargeRateOk = false;
			isTempOk = chargeTemparatureInRange(temperature);
			issocOk = socInRange(soc);
	    	ischargeRateOk = chargeRateInRange(chargeRate);    	
    	return (isTempOk && issocOk && ischargeRateOk);        
    }
    
    static boolean chargeTemparatureInRange(float tempVal) { 
    	return printMessage("Charge Temperature",valueInRange(0, 45, tempVal));
    }
    
    static boolean dischargeTemparatureInRange(float tempVal)  {  
    	return printMessage("Discharge Temperature",valueInRange(-20, 60, tempVal));
    }
    
    static boolean socInRange(float socVal) {
    	return printMessage("State of Charge",valueInRange(20, 80, socVal));
    }
    
    static boolean chargeRateInRange(float chargeRateVal) {
    	return printMessage("Charge Rate",valueInRange(0, 0.8f, chargeRateVal));
    }
       
    static String valueInRange(float min,float max,float value) {
    	if(value < min) {
            return " is low!";
        }
    	else if(value > max) {
            return " is high";
        }
    	return "";
    } 
    
    public static boolean printMessage(String name, String msg) {
    	if(!msg.isEmpty()) {   	
    	System.out.println(name+msg);
    	return false;
    	}
    	return true;
    }

    public static void main(String[] args) {      
			assert(batteryIsOk(25, 70, 0.7f) == true);
			assert(batteryIsOk(50, 85, 0.0f) == false);
	        assert(batteryIsOk(40, 60, 0.9f) == false);  		     
    }
}
