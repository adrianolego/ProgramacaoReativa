import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventSource {
    public void quebraArray(List<Integer> dados) {
        notifyObservers(dados);
    }

    public interface Observer {
        void update(List<Integer> event);
    }

    private final List<Observer> observers = new ArrayList<>();

    private void notifyObservers(List<Integer> event) {
        observers.forEach(observer -> observer.update(event)); //alternative lambda expression: observers.forEach(Observer::update);
    }

    public void addObserver1(Observer observer) {
        observers.add(observer);
    }

    public void addObserver2(Observer observer) {
        observers.add(observer);
    }

    public void scanSystemIn() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
//            notifyObservers(line);
        }
    }
}
