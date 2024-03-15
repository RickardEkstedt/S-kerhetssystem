package Alarm;

// Enheten som hanterar sirenljudet.
public class Siren extends AlarmComponent {
    private boolean isActivated;

    public Siren(String name) {
        super(name);
        isActivated = false;
    }

    @Override
    public void deactivate() {
        isActivated = false; // Stäng av detektorn
    }

    public void MakesSound() {
        isActivated = true;
        System.out.println("Ljuder högt");
    }

    @Override
    public void handleAlarm(String roomName) {
        isActivated = true;
        System.out.println("Sirenerna är aktiverade");
        MakesSound(); // Anropa MakesSound-metoden
    }
}