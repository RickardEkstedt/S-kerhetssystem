
package Alarm;

// Enheten som representerar en rörelsedetektor.
public class MotionDetector extends AlarmComponent {
    private boolean isActivated; // Lägg till en boolean för att spåra aktivering
    private final Siren siren;

    public MotionDetector(String name, Siren siren) {
        super(name);
        this.siren = siren;
        isActivated = false;
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