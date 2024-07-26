public interface Observer
 {
        void update(String message);
 }
    
    // Subject.java
    import java.util.ArrayList;
    import java.util.List;
    
    public class Subject {
        private List<Observer> observers = new ArrayList<>();
        
        public void addObserver(Observer observer) {
            observers.add(observer);
        }
        
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }
        
        public void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }
    }
    
    // ChatRoom.java
    public class ChatRoom extends Subject {
        private String name;
        
        public ChatRoom(String name) {
            this.name = name;
        }
        
        public void sendMessage(String message) {
            System.out.println(name + " sends: " + message);
            notifyObservers(message);
        }
    }
    
    // User.java
    public class User implements Observer {
        private String name;
        
        public User(String name) {
            this.name = name;
        }
        
        @Override
        public void update(String message) {
            System.out.println(name + " received message: " + message);
        }
    }
    
    // Main.java
    public class Main {
        public static void main(String[] args) {
            ChatRoom chatRoom = new ChatRoom("General");
            User user1 = new User("Alice");
            User user2 = new User("Bob");
            
            chatRoom.addObserver(user1);
            chatRoom.addObserver(user2);
            
            chatRoom.sendMessage("Hello, everyone!");
        }
    }
    
}

import java.util.Observer;