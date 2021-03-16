package vitals;

public class BMS {
	
	static final String IS_LOW = "is low";
	static final String IS_HIGH = "is high";
	static final String NORMAL = "Ok";
	static final String TEMP = "Charge Temperature";
	static final String DISCHARGE_TEMP = "Discharge Temperature";
	static final String SOC = "State of Charge";
	static final String CHARGE_RATE = "Charge Rate";
	static final float TEMP_LOWER_LIMIT =  0;
	static final float TEMP_UPPER_LIMIT =  45;
	static final float DISCHARGE_TEMP_LOWER_LIMIT =  -20;
	static final float DISCHARGE_TEMP_UPPER_LIMIT =  60;
	static final float SOC_LOWER_LIMIT =  20;
	static final float SOC_UPPER_LIMIT =  80;
	static final float CHARGE_RATE_UPPER_LIMIT =  0.8f;
	
	static String chargeTemparatureInRange(float tempVal) { 
    	return check(chargeTemparatureHigh(tempVal),chargeTemparatureLow(tempVal));
    }
	
	static String dischargeTemparatureInRange(float tempVal)  {  
	    	return check(dischargeTemparatureHigh(tempVal),dischargeTemparatureLow(tempVal));
	    }
	
	static String socInRange(float socVal) {
    	return check(socHigh(socVal),socLow(socVal));
    }
	 
    static String chargeRateInRange(float chargeRateVal) {
    	return check(chargeRateHigh(chargeRateVal),NORMAL);
    }

	static String chargeTemparatureHigh(float tempVal) {
		return valueInRange(tempVal, TEMP_UPPER_LIMIT, tempVal);
    }
	
	static String chargeTemparatureLow(float tempVal) { 
    	return valueInRange(TEMP_LOWER_LIMIT, tempVal, tempVal);
    }
	
    static String dischargeTemparatureHigh(float tempVal) {
		return valueInRange(tempVal, DISCHARGE_TEMP_UPPER_LIMIT, tempVal);
    }
	
	static String dischargeTemparatureLow(float tempVal) { 
    	return valueInRange(DISCHARGE_TEMP_LOWER_LIMIT, tempVal, tempVal);
    }
	
    static String socLow(float socVal) {
    	return valueInRange(SOC_LOWER_LIMIT, socVal, socVal);
    }
    
    static String socHigh(float socVal) {
    	return valueInRange(socVal, SOC_UPPER_LIMIT, socVal);
    }
       
    static String chargeRateHigh(float chargeRateVal) {
    	return valueInRange(chargeRateVal, CHARGE_RATE_UPPER_LIMIT, chargeRateVal);
    }
       
    static String valueInRange(float min,float max,float value) {
    	if(value < min) {
            return IS_LOW;
        }
    	else if(value > max) {
            return IS_HIGH;
        }
    	return NORMAL;
    } 
    
    static String check(String chargeTemparatureHigh, String chargeTemparatureLow) {
		if(chargeTemparatureHigh.equals(IS_HIGH)) {
		return IS_HIGH;
		}
		else if(chargeTemparatureLow.equals(IS_LOW)) {
			return IS_LOW;
		}
		return NORMAL;
	}
}
