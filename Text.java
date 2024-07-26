public interface Text {
    String getContent();
}

// PlainText.java
public class PlainText implements Text {
    private String content;
    
    public PlainText(String content) {
        this.content = content;
    }
    
    @Override
    public String getContent() {
        return content;
    }
}

// TextDecorator.java
public abstract class TextDecorator implements Text {
    protected Text decoratedText;
    
    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }
    
    public String getContent() {
        return decoratedText.getContent();
    }
}

// BoldDecorator.java
public class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text decoratedText) {
        super(decoratedText);
    }
    
    @Override
    public String getContent() {
        return "<b>" + super.getContent() + "</b>";
    }
}

// ItalicsDecorator.java
public class ItalicsDecorator extends TextDecorator {
    public ItalicsDecorator(Text decoratedText) {
        super(decoratedText);
    }
    
    @Override
    public String getContent() {
        return "<i>" + super.getContent() + "</i>";
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Text text = new PlainText("Hello, World!");
        Text boldText = new BoldDecorator(text);
        Text italicBoldText = new ItalicsDecorator(boldText);
        
        System.out.println(italicBoldText.getContent()); // <i><b>Hello, World!</b></i>
    }
}
