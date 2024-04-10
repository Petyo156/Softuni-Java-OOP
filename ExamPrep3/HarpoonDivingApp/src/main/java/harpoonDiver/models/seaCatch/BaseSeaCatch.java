package harpoonDiver.models.seaCatch;

import java.util.ArrayList;
import java.util.Collection;

public class BaseSeaCatch implements SeaCatch{
    Collection<String> seaCreatures;

    public BaseSeaCatch() {
        this.seaCreatures = new ArrayList<>();
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return seaCreatures;
    }
}
