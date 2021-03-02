package vitals;

public class Main {
		
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
    	boolean isTempOk = chargeTemparatureInRange(temperature);
    	boolean issocOk = socInRange(soc);
    	boolean ischargeRateOk = chargeRateInRange(chargeRate);
    	return (isTempOk && issocOk && ischargeRateOk);        
    }
    
    static boolean chargeTemparatureInRange(float tempVal) {  
    	Condition temperature = new Condition("Charge Temperature",0,45);
    	return valueInRange(tempVal,temperature);
    }
    
    static boolean dischargeTemparatureInRange(float tempVal) {  
    	Condition temperature = new Condition("Discharge Temperature",-20,60);
    	return valueInRange(tempVal,temperature);
    }
    
    static boolean socInRange(float socVal) {
    	Condition soc = new Condition("State of Charge",20,80);
    	return valueInRange(socVal,soc);
    }
    
    static boolean chargeRateInRange(float chargeRateVal) {
    	Condition chargeRate = new Condition("Charge Rate",0,0.8f);
    	return valueInRange(chargeRateVal,chargeRate);
    }
       
    static boolean valueInRange(float value,Condition cond) {
    	if(value < cond.getMin()) {
    		System.out.println(cond.getName()+" is low!");
            return false;
        }
    	else if(value > cond.getMax()) {
    		System.out.println(cond.getName()+" is high!");
            return false;
        }
    	return true;
    }    

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        assert(batteryIsOk(40, 60, 0.9f) == false);
        assert(chargeTemparatureInRange(60) == false);
        assert(dischargeTemparatureInRange(60) == true);
        assert(socInRange(10) == false);
        assert(chargeRateInRange(1.2f) == false);
    }
}
