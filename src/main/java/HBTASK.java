import analysis.*;

public class HBTASK {
    public static void main(String[] args) throws InterruptedException {
        // Create a new preAnalysis
        PreAnalysis preAnalysis = new PreAnalysis();
        // Create a new Analysis
        Analysis analysis = new Analysis(preAnalysis.driver, preAnalysis.products);

    }
}
