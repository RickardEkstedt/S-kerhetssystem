
package House;

import Alarm.*;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final List<AlarmComponent> alarmComponents;
    private final Siren siren;
    private boolean activeAlarm;

    public Room(String name, Siren siren) {
        this.name = name;
        this.alarmComponents = new ArrayList<>();
        this.siren = siren;
        this.activeAlarm = false; // Initialt finns inget aktivt larm
    }

    public void addAlarmComponent(AlarmComponent alarmComponent) {
        alarmComponents.add(alarmComponent);
    }

    public String getName() {
        return name;
    }

    public void activateRandomDetector() {
        if (!alarmComponents.isEmpty() && !activeAlarm) { // Kontrollera om alarmComponents är tom och om det redan finns ett aktivt larm.
            int randomIndex = (int) (Math.random() * alarmComponents.size());
            AlarmComponent randomComponent = alarmComponents.get(randomIndex);
            randomComponent.handleAlarm(name);
            activeAlarm = true; // Markera att ett larm är aktivt i rummet
        }
    }

    public void resetComponents() {
        for (AlarmComponent component : alarmComponents) {
            component.deactivate();
        }
        activeAlarm = false; // Återställ aktivt larm när alla komponenter återställs
    }

    public boolean hasActiveAlarm() {
        return activeAlarm;
    }

    public Siren getSiren() {
        return siren;
    }
}