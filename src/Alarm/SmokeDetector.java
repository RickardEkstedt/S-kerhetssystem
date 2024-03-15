
package Alarm;

public class SmokeDetector extends AlarmComponent {
    private boolean isActivated; // En boolean för att spåra aktiveringsstatusen av rökdetektorn
    private final SprinklerSystem sprinklerSystem; // En referens till sprinklersystemet
    private final Siren siren; // En referens till sirenen

    // Konstruktör för SmokeDetector
    public SmokeDetector(String name, SprinklerSystem sprinklerSystem, Siren siren) {
        super(name);
        this.sprinklerSystem = sprinklerSystem;
        this.siren = siren;
        isActivated = false; // Initialt är rökdetektorn inaktiv
    }

    // Metod för att inaktivera rökdetektorn
    @Override
    public void deactivate() {
        isActivated = false;
    }

    // En "setter" metod för att ändra aktiveringsstatusen av rökdetektorn
    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    // En metod för att hämta aktiveringsstatusen av rökdetektorn
    public boolean isActivated() {
        return isActivated;
    }

    // Överlagrad handleAlarm-metod för att hantera larm i samband med rökdetektorn
    @Override
    public void handleAlarm(String roomName) {
        setActivated(true); // Markera rökdetektorn som aktiverad
        System.out.println(getName() + " har aktiverats");

        // Aktivera sirenen när rökdetektorn utlöses
        siren.handleAlarm(roomName);

        // Aktivera sprinklersystemet från rökdetektorn
        sprinklerSystem.activateFromSmokeDetector(roomName);
    }
}
