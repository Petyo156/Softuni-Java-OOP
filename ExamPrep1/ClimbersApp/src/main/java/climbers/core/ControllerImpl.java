package climbers.core;

import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static climbers.common.ConstantMessages.*;
import static climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Climber> climberRepository;
    private Repository<Mountain> mountainRepository;

    private int count = 0;

    public ControllerImpl() {
        climberRepository = new ClimberRepository();
        mountainRepository = new MountainRepository();
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber = null;
        switch (type) {
            case "RockClimber":
                climber = new RockClimber(climberName);
                break;
            case "WallClimber":
                climber = new WallClimber(climberName);
                break;
            default:
                throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        }
        climberRepository.add(climber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);

        List<String> peaksList = new ArrayList<>(Arrays.asList(peaks));
        mountain.getPeaksList().addAll(peaksList);

        mountainRepository.add(mountain);
        return String.format(MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        for (Climber climber : climberRepository.getCollection()) {
            if (climber.getName().equals(climberName)) {
                climberRepository.remove(climber);
                return String.format(CLIMBER_REMOVE, climberName);
            }
        }
        throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
    }

    private Mountain getMountainByName(String mountainName) {
        return mountainRepository.getCollection().stream()
                .filter(mountain -> mountain.getName().equals(mountainName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String startClimbing(String mountainName) {
        if (climberRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }
        Mountain mountain = getMountainByName(mountainName);

        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climberRepository.getCollection());

        long removedClimbers = climberRepository.getCollection().stream()
                .filter(climber -> climber.getStrength() == 0)
                .count();

        this.count++;
        return String.format(PEAK_CLIMBING, mountainName, (int) removedClimbers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_MOUNTAIN_COUNT, this.count));
        sb.append(System.lineSeparator());
        sb.append(FINAL_CLIMBERS_STATISTICS);
        sb.append(System.lineSeparator());
        for (Climber climber : climberRepository.getCollection()) {
            sb.append(String.format(FINAL_CLIMBER_NAME, climber.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_CLIMBER_STRENGTH, climber.getStrength()));
            sb.append(System.lineSeparator());
            String message = String.join(FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks());
            sb.append(String.format(FINAL_CLIMBER_PEAKS, message));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
