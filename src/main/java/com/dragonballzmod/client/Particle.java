package com.dragonballzmod.client;

/**
 * Created by Alastair on 01/03/2015.
 */
public enum Particle {

    COLOURED_SMOKE("colouredSmoke");

    private final String particleName;

    private Particle(String name) {
        this.particleName = name;
    }

    public String getName() {
        return particleName;
    }

}
