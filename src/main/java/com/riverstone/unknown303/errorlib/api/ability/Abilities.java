package com.riverstone.unknown303.errorlib.api.ability;

import java.util.ArrayList;
import java.util.List;

public class Abilities {
    List<Ability> availableAbilities = new ArrayList<Ability>();
    List<Ability> readyAbilities = new ArrayList<Ability>();
    List<Ability> enabledAbilities = new ArrayList<>();

    public void scrollAbilities(ScrollDirection direction) {
        List<Ability> newAvailableAbilities = new ArrayList<Ability>();
        List<Ability> newReadyAbilities = new ArrayList<Ability>();
        switch (direction) {
            case DOWN -> {
                newReadyAbilities.add(0, availableAbilities.get(availableAbilities.size() - 1));
                availableAbilities.remove(availableAbilities.size() - 1);

                newAvailableAbilities.add(0, readyAbilities.get(readyAbilities.size() - 1));
                readyAbilities.remove(readyAbilities.size() - 1);

                newAvailableAbilities.addAll(availableAbilities);
                newReadyAbilities.addAll(readyAbilities);

                availableAbilities = newAvailableAbilities;
                readyAbilities = newReadyAbilities;
            } case UP -> {

            }
        }
    }

    public enum ScrollDirection {
        UP,
        DOWN;
    }
}
