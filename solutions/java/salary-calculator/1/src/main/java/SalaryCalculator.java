public class SalaryCalculator {

    private final double BASE_SALARY = 1000.00;
    
    // Salary multipler
    private double multiplier = 1.0;
    private final double PENALTY_RATE = 0.15;
    private final int PENALTY_THRESHOLD = 5;

    // Bonus multipler
    private final int BONUS_THRESHOLD = 20;
    private final int STANDARD_BONUS = 10;
    private final int ENHANCED_BONUS = 13;

    
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >=  PENALTY_THRESHOLD 
            ? multiplier - PENALTY_RATE : multiplier;
    }

    public int bonusMultiplier(int productsSold) {
       return productsSold >= BONUS_THRESHOLD ? ENHANCED_BONUS : STANDARD_BONUS;
    }

    public double bonusForProductsSold(int productsSold) {
        return (double)productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        
        double salaryMultiplier = salaryMultiplier(daysSkipped);
        double  bonus =  bonusForProductsSold(productsSold);
        double salary = salaryMultiplier * BASE_SALARY + bonus;
        
        return Math.min(salary, 2000.00);
    } 
}
