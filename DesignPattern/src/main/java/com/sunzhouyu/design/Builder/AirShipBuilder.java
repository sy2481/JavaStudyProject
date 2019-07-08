package com.sunzhouyu.design.Builder;

public interface AirShipBuilder {
    Engine builderEngine();

    OrbitalModule builderOrbitalModule();

    EscapeTower builderEscapeTower();
}
