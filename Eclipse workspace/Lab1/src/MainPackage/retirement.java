package MainPackage;
import java.util.Scanner;

public class retirement {
	static Scanner userInput = new Scanner(System.in);
	static double yearsToWorkDouble;
	static double eARDouble;
	static double eSSIDouble;
	static double eYearsRetiredDouble;
	static double eRetiredARDouble;
	static double eMonthDrawDouble;
	
	static double eRetirementNumeber;
	static double eSavePerMonth;
	
	public static void main(String[] args) {
		
		yearsToWork();
		
	}
	
	public static void yearsToWork() {
		try { 
			
			
			System.out.println("Enter the number of years you plan to work:");
			String yearsToWork = userInput.next();
			yearsToWorkDouble = Double.parseDouble(yearsToWork);
			System.out.println("Years to Work = "+ yearsToWorkDouble);
			expectedAnualReturn();
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			yearsToWork();
		}
	}
	public static void expectedAnualReturn(){
		try { 
			System.out.println("Enter your percent expected anual return on investment:");
			String eAR = userInput.next();
			eARDouble = Double.parseDouble(eAR);
			System.out.println("Expected Anual Return = "+ eARDouble+"%");
			if (eARDouble  > 20) {
				System.out.println("Error. Print a pecent between 0% and 20%");
				expectedAnualReturn();
			}
			expectedSSI();
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			expectedAnualReturn();
		}
	}
	public static void expectedSSI(){
		try { 
			System.out.println("Enter your expected monthly SSI income:");
			String eSSI = userInput.next();
			eSSIDouble = Double.parseDouble(eSSI);
			System.out.println("Expected SSI income = $"+ eSSIDouble);
			expectedYearsRetired();
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			expectedSSI();
		}
	}
	public static void expectedYearsRetired(){
		try { 
			System.out.println("Enter your expected years retired:");
			String eYR = userInput.next();
			eYearsRetiredDouble = Double.parseDouble(eYR);
			System.out.println("Expected years retired = "+ eYearsRetiredDouble+" years");
			retiredAnualReturn();
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			expectedYearsRetired();
		}
	}
	public static void retiredAnualReturn(){
		try { 
			System.out.println("Enter your percent expected retirement anual return:");
			String eRAN = userInput.next();
			eRetiredARDouble = Double.parseDouble(eRAN);
			if (eRetiredARDouble  > 3) {
				System.out.println("Error. Print a pecent between 0% and 3%");
				retiredAnualReturn();
			}
			System.out.println("Expected retirement annual return = "+ eRetiredARDouble+ "%");
			expectedMonthlyDraw();
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			retiredAnualReturn();
		}
	}	
	public static void expectedMonthlyDraw(){
		try { 
			System.out.println("Enter your expected retired monthly draw:");
			String eMD = userInput.next();
			eMonthDrawDouble = Double.parseDouble(eMD);
			System.out.println("Expected retirement monthly draw = "+ eMonthDrawDouble);
			calculateRetirementNumber();
		} catch(NumberFormatException e) {
			System.out.println("Error. Please enter a number");
			expectedMonthlyDraw();
		}
	
	
}

	public static void calculateRetirementNumber() {
		//Calculates how much total money you need for your retirement
		eRetirementNumeber = (eMonthDrawDouble-eSSIDouble)*((1-(1/(Math.pow(1+(eRetiredARDouble/100)/12,eYearsRetiredDouble*12 )))))/((eRetiredARDouble/100)/12);	
		eRetirementNumeber = Math.round(eRetirementNumeber * 100.0) / 100.0;
		System.out.println("Your retirement number should be $"+ eRetirementNumeber);
		calculateMontlySave();
	}

	
	public static void calculateMontlySave() {
		//Calculates how much you need to save each month
		eSavePerMonth = eRetirementNumeber*(((eARDouble/100)/12)/((Math.pow(1+(eARDouble/100)/12, yearsToWorkDouble*12))-1));
		eSavePerMonth = Math.round(eSavePerMonth * 100.0) / 100.0;
		System.out.println("You have to save, $"+ eSavePerMonth + " per month");
		
	}
	


}









