package Alarm;

// Enheten som hanterar sprinklersystemet och dess aktivering från rökdetektor.
public class SprinklerSystem extends AlarmComponent {
    private boolean isActivated = false;
    private boolean smokeDetectorActivated = false;

    // Konstruktör för SprinklerSystem
    public SprinklerSystem(String name) {
        super(name);

    }

    @Override
    public void deactivate() {
        isActivated = false; // Stäng av detektorn
    }

    // Metod för att starta sprinklersystemet och släcka branden i ett rum
    public void sprinklerStarts(String roomName) {
        System.out.println("Sprinkler släcker branden i " + roomName);
    }

    // Överlagrad handleAlarm-metod för att hantera larm
    @Override
    public void handleAlarm(String roomName) {
        isActivated = true; // Markera sprinklersystemet som aktiverat
        sprinklerStarts(roomName);
        resetSmokeDetector();
    }

    // Metod för att aktivera sprinklersystemet från en rökdetektor
    public void activateFromSmokeDetector(String roomName) {
        smokeDetectorActivated = true;
        System.out.println("Sprinklersystemet är aktiverat");
        handleAlarm(roomName);
    }

    // Metod för att återställa statusen för rökdetektorn och sprinklersystemet
    public void resetSmokeDetector() {
        smokeDetectorActivated = false;
        isActivated = false;
    }
}