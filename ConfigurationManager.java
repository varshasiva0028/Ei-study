public class ConfigurationManager {
    private static ConfigurationManager instance;
    
    private ConfigurationManager() {
        // Load configuration
    }
    
    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
    
    public void showConfig() {
        System.out.println("Showing configuration.");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();
        
        System.out.println(config1 == config2); // True
        
        config1.showConfig();
    }
}