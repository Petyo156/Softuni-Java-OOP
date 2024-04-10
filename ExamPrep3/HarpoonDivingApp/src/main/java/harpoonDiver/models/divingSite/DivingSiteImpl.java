package harpoonDiver.models.divingSite;

import harpoonDiver.models.diver.Diver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static harpoonDiver.common.ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY;
import static harpoonDiver.common.ExceptionMessages.SITE_NAME_NULL_OR_EMPTY;

public class DivingSiteImpl implements DivingSite {
    private String name;
    Collection<String> seaCreatures;

    public DivingSiteImpl(String name) {
        setName(name);
        this.seaCreatures = new ArrayList<>();
    }

    private void setName(String name) {
        if (null == name || name.isBlank() || name.isEmpty()) {
            throw new NullPointerException(SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return seaCreatures;
    }

    @Override
    public String getName() {
        return name;
    }
}
