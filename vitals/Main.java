package vitals;

public class Main {
		
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {  
		String	isTempOk = BMS.chargeTemparatureInRange(temperature);
		String	issocOk = BMS.socInRange(soc);
	    String	ischargeRateOk = BMS.chargeRateInRange(chargeRate);
	    printMessage(BMS.TEMP,isTempOk);
	    printMessage(BMS.SOC,issocOk);
	    printMessage(BMS.CHARGE_RATE,ischargeRateOk);
    	return (isOk(isTempOk) && isOk(issocOk) && isOk(ischargeRateOk));        
    }
    
    public static void printMessage(String name, String msg) {
    	System.out.println(name+" "+msg);
    }

    public static void main(String[] args) {      
			assert(batteryIsOk(25, 70, 0.7f) == true);
			assert(batteryIsOk(50, 85, 0.0f) == false);
	        assert(batteryIsOk(40, 60, 0.9f) == false);  
	        assert(BMS.chargeTemparatureInRange(30).equals(BMS.NORMAL));  
	        assert(BMS.chargeTemparatureInRange(60).equals(BMS.IS_HIGH));  
    }

	public static boolean isOk(String condition) {
    	return condition.equals(BMS.NORMAL)? Boolean.TRUE : Boolean.FALSE;
    }
}
