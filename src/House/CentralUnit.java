
package House;

import Alarm.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CentralUnit {
    private final List<Room> rooms;
    private boolean alarmSystemActivated = false;
    private boolean alarmReset = true;
    private final String securityCode = "1234";
    private static final Random random = new Random();

    public CentralUnit() {

        // Skapa och konfigurera rummen
        rooms = new ArrayList<>();

        // Instanser
        SprinklerSystem sprinklerSystem = new SprinklerSystem("Sprinkler");

        Siren siren = new Siren("Siren");


        // Skapa rum och lägg till larmkomponenter
        // Här skapas och konfigureras rummen
        Room garage = new Room("Garaget", siren);
        garage.addAlarmComponent(new WindowDetector("Fönsterdetektor i garaget", siren));
        garage.addAlarmComponent(new DoorDetector("Dörrdetektor i garaget", siren));
        garage.addAlarmComponent(new SmokeDetector("Rökdetektor i garaget", sprinklerSystem, siren));
        rooms.add(garage);

        Room livingRoom = new Room("Vardagsrummet", siren);
        livingRoom.addAlarmComponent(new WindowDetector("Fönsterdetektor i vardagsrummet", siren));
        livingRoom.addAlarmComponent(new DoorDetector("Dörrdetektor i vardagsrummet", siren));
        livingRoom.addAlarmComponent(new MotionDetector("Rörelsedetektor i vardagsrummet", siren));
        livingRoom.addAlarmComponent(new SmokeDetector("Rökdetektor i vardagsrummet", sprinklerSystem, siren));
        rooms.add(livingRoom);

        Room kitchen = new Room("Köket", siren);
        kitchen.addAlarmComponent(new WindowDetector("Fönsterdetektor i köket", siren));
        kitchen.addAlarmComponent(new SmokeDetector("Rökdetektor i köket", sprinklerSystem, siren));
        rooms.add(kitchen);

        Room bedroom1 = new Room("Sovrum 1", siren);
        bedroom1.addAlarmComponent(new WindowDetector("Fönsterdetektor i sovrum 1", siren));
        bedroom1.addAlarmComponent(new SmokeDetector("Rökdetektor i sovrum 1", sprinklerSystem, siren));
        rooms.add(bedroom1);

        Room bedroom2 = new Room("Sovrum 2", siren);
        bedroom2.addAlarmComponent(new WindowDetector("Fönsterdetektor i sovrum 2", siren));
        bedroom2.addAlarmComponent(new SmokeDetector("Rökdetektor i sovrum 2", sprinklerSystem, siren));
        rooms.add(bedroom2);

        Room bedroom3 = new Room("Sovrum 3", siren);
        bedroom3.addAlarmComponent(new WindowDetector("Fönsterdetektor i sovrum 3", siren));
        bedroom3.addAlarmComponent(new SmokeDetector("Rökdetektor i sovrum 3", sprinklerSystem, siren));
        rooms.add(bedroom3);

        Room bedroom4 = new Room("Sovrum 4", siren);
        bedroom4.addAlarmComponent(new WindowDetector("Fönsterdetektor i sovrum 4", siren));
        bedroom4.addAlarmComponent(new SmokeDetector("Rökdetektor i sovrum 4", sprinklerSystem, siren));
        rooms.add(bedroom4);

        Room bedroom5 = new Room("Sovrum 5", siren);
        bedroom5.addAlarmComponent(new WindowDetector("Fönsterdetektor i sovrum 5", siren));
        bedroom5.addAlarmComponent(new SmokeDetector("Rökdetektor i sovrum 5", sprinklerSystem, siren));
        rooms.add(bedroom5);

        Room hall = new Room("Hallen", siren);
        hall.addAlarmComponent(new DoorDetector("Dörrdetektor i hallen", siren));
        hall.addAlarmComponent(new WindowDetector("Fönsterdetektor i hallen", siren));
        hall.addAlarmComponent(new MotionDetector("Rörelsedetektor i hallen", siren));
        hall.addAlarmComponent(new SmokeDetector("Rökdetektor i hallen", sprinklerSystem, siren));
        rooms.add(hall);

        Room garden = new Room("Trädgården", siren);
        garden.addAlarmComponent(new MotionDetector("Rörelsedetektor i trädgården", siren));
        rooms.add(garden);


    }

    // Andra metoder i CentralUnit inkluderar aktivering, inaktivering, simulering och återställning av larm.
    public void activateAlarmSystem(String securityCodeEntered) {
        if (securityCodeEntered.equals(securityCode)) {
            alarmSystemActivated = true;
            System.out.println("Larmsystemet har aktiverats.");
        } else {
            System.out.println("Felaktig behörighetskod. Larmsystemet kunde inte aktiveras.");
        }
    }

    public void deactivateAlarmSystem(String securityCodeEntered) {
        if (securityCodeEntered.equals(securityCode)) {
            alarmSystemActivated = false;
            System.out.println("Larmsystemet har inaktiverats.");
        } else {
            System.out.println("Felaktig behörighetskod. Larmsystemet kunde inte inaktiveras.");
        }
    }

    // Dessa metoder använder rummen och deras larmkomponenter för att simulera och hantera larm.

    public void simulateEvent() {
        if (!alarmSystemActivated) {
            System.out.println("Larmsystemet måste aktiveras för att simulera en händelse.");
            return;
        }

        if (alarmReset) {
            if (!rooms.isEmpty()) {
                int randomIndex = random.nextInt(rooms.size());
                Room randomRoom = rooms.get(randomIndex);
                if (!randomRoom.hasActiveAlarm()) {
                    randomRoom.activateRandomDetector();
                    alarmReset = false;
                } else {
                    System.out.println("Det finns redan ett aktivt larm i " + randomRoom.getName() + ".");
                }
            }
        } else {
            System.out.println("Larmet måste återställas innan en ny simulerad händelse kan aktiveras.");
        }
    }

    public void resetAlarm() {
        alarmReset = true;
        System.out.println("Larmsystemet har återställts.");
        for (Room room : rooms) {
            room.resetComponents();
        }
    }
}