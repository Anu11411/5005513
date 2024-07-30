public class FinancialForecast {

    // Method to calculate future value recursively
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: If no years left, return the present value
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: Calculate the future value for one year less
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // Annual growth rate (5%)
        int years = 10; // Number of years into the future

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f\n", years, futureValue);
    }
}
