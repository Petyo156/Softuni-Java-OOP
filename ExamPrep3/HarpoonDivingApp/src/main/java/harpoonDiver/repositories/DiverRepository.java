package harpoonDiver.repositories;

import harpoonDiver.models.diver.Diver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiverRepository implements Repository<Diver>{
    Collection<Diver> divers;

    public DiverRepository() {
        divers = new ArrayList<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(divers);
    }

    @Override
    public void add(Diver entity) {
        divers.add(entity);
    }

    @Override
    public boolean remove(Diver entity) {
        return divers.remove(entity);
    }

    @Override
    public Diver byName(String name) {
        return divers.stream()
                .filter(diver -> diver.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
