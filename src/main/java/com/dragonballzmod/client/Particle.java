package com.dragonballzmod.client;

public enum Particle {

    COLOURED_SMOKE("colouredSmoke"); // there is a normal and tracking type

    private final String particleName;

    private Particle(String name) {
        this.particleName = name;
    }

    public String getName() {
        return particleName;
    }

}
