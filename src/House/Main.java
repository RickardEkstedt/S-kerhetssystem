package House;

import Alarm.Siren;
import Alarm.SmokeDetector;
import Alarm.SprinklerSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Skapa en central enhet och larmkomponenter
        // Instanser
        CentralUnit centralUnit = new CentralUnit();
        Siren siren = new Siren("Siren");
        SprinklerSystem sprinklerSystem = new SprinklerSystem("Sprinkler");
        SmokeDetector smokeDetector = new SmokeDetector("SmokeDetector", sprinklerSystem, siren);

        Scanner scanner = new Scanner(System.in);
        boolean alarmActivated = false;
        boolean programRunning = true;

        while (programRunning) {
            // Visa användaralternativ
            System.out.println("Välj en åtgärd:");
            System.out.println("1. Aktivera larmsystemet");
            System.out.println("2. Avaktivera larmsystemet");
            System.out.println("3. Simulera en händelse");
            System.out.println("4. Återställ larm");
            System.out.println("5. Avsluta");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Aktivera larmsystemet med behörighetskod
                    System.out.print("Ange behörighetskod för att aktivera larmsystemet: ");
                    String enteredCode = scanner.next();
                    centralUnit.activateAlarmSystem(enteredCode);
                    alarmActivated = true;
                    break;
                case 2:
                    // Avaktivera larmsystemet med behörighetskod
                    System.out.print("Ange behörighetskod för att inaktivera larmsystemet: ");
                    String enteredCodeToDeactivate = scanner.next();
                    centralUnit.deactivateAlarmSystem(enteredCodeToDeactivate);
                    alarmActivated = false;
                    break;
                case 3:
                    // Simulera en händelse om larmsystemet är aktiverat
                    centralUnit.simulateEvent();
                    break;
                case 4:
                    if (alarmActivated) {
                        // Återställ larm om larmsystemet är aktiverat
                        centralUnit.resetAlarm();
                    } else {
                        System.out.println("Larmsystemet är inte aktiverat.");
                    }
                    break;
                case 5:
                    // Avsluta programmet
                    System.out.println("Avslutar programmet.");
                    programRunning = false;
                    break;
                default:
                    System.out.println("Ogiltigt val. Välj igen.");
            }
        }
    }
}