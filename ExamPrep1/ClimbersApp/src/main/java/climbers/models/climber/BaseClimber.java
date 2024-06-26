package climbers.models.climber;

import climbers.models.roster.Roster;
import climbers.models.roster.RosterImpl;

import static climbers.common.ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY;
import static climbers.common.ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseClimber implements Climber {
    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        setName(name);
        setStrength(strength);
        this.roster = new RosterImpl();
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public boolean canClimb() {
        return this.strength > 0;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }

    @Override
    public void climb() {
        if (getClass().getSimpleName().equals("WallClimber")) {
            this.strength -= 30;
        } else if (getClass().getSimpleName().equals("RockClimber")) {
            this.strength -= 60;
        }
        if (this.strength < 0) {
            this.strength = 0;
        }
    }
}
