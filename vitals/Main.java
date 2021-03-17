package vitals;

import java.util.HashMap;
import java.util.Map;

public class Main {
		
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {  
		String	isTempOk = BMS.chargeTemparatureInRange(temperature);
		String	issocOk = BMS.socInRange(soc);
	    String	ischargeRateOk = BMS.chargeRateInRange(chargeRate);
	    consolidateAndReport(isTempOk,issocOk,ischargeRateOk);
	    printMessage(BMS.TEMP,isTempOk);
	    printMessage(BMS.SOC,issocOk);
	    printMessage(BMS.CHARGE_RATE,ischargeRateOk);
    	return (isOk(isTempOk) && isOk(issocOk) && isOk(ischargeRateOk));        
    }
    
    private static void consolidateAndReport(String isTempOk, String issocOk, String ischargeRateOk) {
    	Map<String, String> hmap = new HashMap<>(); 
        hmap.put(BMS.TEMP, isTempOk); 
        hmap.put(BMS.SOC, issocOk); 
        hmap.put(BMS.CHARGE_RATE, ischargeRateOk);
        Reporter report=new ReportConsole();
        BreachedBMSParamConsolidator bmsConsolidator = new BreachedBMSParamConsolidator(hmap,report);
        bmsConsolidator.consolidateBreachedParamForReporting();
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
