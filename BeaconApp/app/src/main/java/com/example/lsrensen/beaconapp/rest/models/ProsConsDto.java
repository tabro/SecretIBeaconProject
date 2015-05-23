package com.example.lsrensen.beaconapp.rest.models;

public class ProsConsDto {
    private String description;
    private boolean isPros;

    public ProsConsDto(String description, boolean isPros) {
        this.description = description;
        this.isPros = isPros;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPros() {
        return isPros;
    }

    public void setIsPros(boolean isPros) {
        this.isPros = isPros;
    }
}
