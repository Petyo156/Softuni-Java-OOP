package harpoonDiver.core;

import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.models.seaCatch.SeaCatch;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static harpoonDiver.common.ConstantMessages.*;
import static harpoonDiver.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Diver> diverRepository = new DiverRepository();
    private Repository<DivingSite> divingSiteRepository = new DivingSiteRepository();

    private int count;

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        switch (kind) {
            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;
            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;
            default:
                throw new IllegalArgumentException(DIVER_INVALID_KIND);
        }
        diverRepository.add(diver);
        return String.format(DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        for (String creature : seaCreatures) {
            divingSite.getSeaCreatures().add(creature);
        }
        divingSiteRepository.add(divingSite);
        return String.format(DIVING_SITE_ADDED, siteName);
    }

    private Diver getByName(String diverName) {
        return diverRepository.getCollection().stream()
                .filter(diver -> diver.getName().equals(diverName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = getByName(diverName);
        if (null == diver) {
            throw new IllegalArgumentException(String.format(DIVER_DOES_NOT_EXIST, diverName));
        }
        diverRepository.remove(diver);
        return String.format(DIVER_REMOVE, diverName);
    }

    private DivingSite getSiteByName(String siteName) {
        return divingSiteRepository.getCollection().stream()
                .filter(site -> site.getName().equals(siteName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String startDiving(String siteName) {
        List<Diver> diverList = this.diverRepository.getCollection()
                .stream()
                .filter(diver -> diver.getOxygen() > 30)
                .collect(Collectors.toList());

        if (diverList.isEmpty()) {
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }

        DivingSite divingSite = getSiteByName(siteName);

        Diving diving = new DivingImpl();
        diving.searching(divingSite, diverList);
        long removedDivers = diverList.stream().filter(diver -> diver.getOxygen() == 0).count();

        this.count++;
        return String.format(SITE_DIVING, siteName, (int)removedDivers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_DIVING_SITES, this.count));
        sb.append(System.lineSeparator());
        sb.append(FINAL_DIVERS_STATISTICS);
        sb.append(System.lineSeparator());
        for (Diver diver : diverRepository.getCollection()) {
            sb.append(String.format(FINAL_DIVER_NAME, diver.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_DIVER_OXYGEN, diver.getOxygen()));
            sb.append(System.lineSeparator());

            String message;
            if(diver.getSeaCatch().getSeaCreatures().isEmpty()){
                message = "None";
            } else {
                message = String.join(FINAL_DIVER_CATCH_DELIMITER, diver.getSeaCatch().getSeaCreatures());
            }

            sb.append(String.format(FINAL_DIVER_CATCH, message));

            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
