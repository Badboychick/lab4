package Objects;

import java.util.Objects;

public class Weather {
    private String name;
    public Weather(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Weather weather = (Weather) obj;
        return Objects.equals(name, weather.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Objects.Weather{" +
                "name='" + name + '\'' +
                '}';
    }
    public void started() {
        System.out.println("Начался " + getName());
    }
}
