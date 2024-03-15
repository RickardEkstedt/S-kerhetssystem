package Alarm;

// Basenheten som representerar en larmkomponent.
public abstract class AlarmComponent {
    private final String name;

    public AlarmComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void deactivate();


    public abstract void handleAlarm(String roomName);
}