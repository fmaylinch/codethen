package samples.serialization.gson;

import java.util.List;

public class GymList {

    private List<Gym> gyms;

    public GymList(List<Gym> gyms) {
        this.gyms = gyms;
    }

    public List<Gym> getGyms() {
        return gyms;
    }
}
