public class Logger {
    // Private static instance of the same class that is the only instance of the
    // class
    private static Logger instance;

    // Private constructor to restrict instantiation from other classes
    private Logger() {
        // Initialize logging resources here if necessary
    }

    // Public static method that returns the instance of the class, with lazy
    // initialization
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
