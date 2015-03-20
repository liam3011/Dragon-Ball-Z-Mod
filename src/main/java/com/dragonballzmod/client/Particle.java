package com.dragonballzmod.client;

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
