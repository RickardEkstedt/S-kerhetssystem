package Alarm;


public class DoorDetector extends AlarmComponent {
    private boolean isActivated; // Privat instansvariabel för att spåra aktivering
    private final Siren siren;

    public DoorDetector(String name, Siren siren) {
        super(name);
        this.siren = siren;
        isActivated = false; // Initialisera som inaktiverad när dörrdetektorn skapas

    }

    @Override
    public void deactivate() {
        isActivated = false; // Stäng av detektorn
    }

    // En "setter" metod för att ändra värdet på isActivated
    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    @Override
    public void handleAlarm(String roomName) {
        setActivated(true); // Anropa setActivated-metoden för att markera detektorn som aktiverad
        System.out.println(getName() + " har aktiverats");

        // Aktivera sirenen när dörrdetektorn utlöses
        siren.handleAlarm(roomName);
    }
}