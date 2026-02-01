abstract class UIElement {
    protected String text;

    public UIElement(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public abstract void display();
}
abstract class Button extends UIElement {
    public Button(String text) { super(text); }
}

abstract class TextField extends UIElement {
    public TextField(String text) { super(text); }
}

abstract class Checkbox extends UIElement {
    public Checkbox(String text) { super(text); }
}
class ButtonA extends Button {
    public ButtonA(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("+-" + "-".repeat(text.length()) + "-+");
        System.out.println("| " + text + " |");
        System.out.println("+-" + "-".repeat(text.length()) + "-+");
    }
}

class TextFieldA extends TextField {
    public TextFieldA(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("Input: [ " + text + " ]");
    }
}

class CheckboxA extends Checkbox {
    public CheckboxA(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("[x] " + text);
    }
}

class ButtonB extends Button {
    public ButtonB(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("<< " + text.toUpperCase() + " >>");
    }
}

class TextFieldB extends TextField {
    public TextFieldB(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("____ " + text + " ____");
    }
}

class CheckboxB extends Checkbox {
    public CheckboxB(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("(\u2713) " + text);
    }
}

abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}

class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}

class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}

public class assignment_2 {
    public static void renderUI(UIFactory factory) {
        Button btn = factory.createButton("Submit");
        TextField txt = factory.createTextField("User Name");
        Checkbox chk = factory.createCheckbox("Accept Terms");

        System.out.println("Rendering");
        btn.display();
        txt.display();
        chk.display();

        System.out.println("\nContact is being updated dynamically.");
        btn.setText("Register Now");
        txt.setText("superuser");

        btn.display();
        txt.display();
    }

    public static void main(String[] args) {
        System.out.println("--- STYLE A (Box Style) ---");
        UIFactory factoryA = new AFactory();
        renderUI(factoryA);

        System.out.println("\n\n--- STYLE B (Arrow Style) ---");
        UIFactory factoryB = new BFactory();
        renderUI(factoryB);
    }
}
