public class LegacySystem {
    public void oldRequest() {
        System.out.println("Handling old request.");
    }
}

// NewSystemInterface.java
public interface NewSystemInterface {
    void newRequest();
}

// Adapter.java
public class Adapter implements NewSystemInterface {
    private LegacySystem legacySystem;
    
    public Adapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }
    
    @Override
    public void newRequest() {
        legacySystem.oldRequest();
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        LegacySystem legacySystem = new LegacySystem();
        NewSystemInterface adapter = new Adapter(legacySystem);
        adapter.newRequest();
    }
}