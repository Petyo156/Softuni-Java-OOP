package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving {
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        Collection<String> seaCreatures = divingSite.getSeaCreatures();
        for (Diver d : divers) {
            while(d.canDive() && seaCreatures.iterator().hasNext()){
                d.shoot();
                String creature = seaCreatures.iterator().next();
                d.getSeaCatch().getSeaCreatures().add(creature);
                seaCreatures.remove(creature);
            }
        }
    }
}
