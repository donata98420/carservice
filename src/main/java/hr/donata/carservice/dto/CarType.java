package hr.donata.carservice.dto;

import lombok.Getter;

@Getter
public enum CarType {
    BMW("S", "Z"),
    TOYOTA("B4", "B8"),
    OPEL("astra","vectra"),
    VOLVO("C40", "Ex90");
    private String label;
    private String shortLabel;
    CarType(String label, String shortLabel) {

        this.label = label;
        this.shortLabel = shortLabel;
    }

}
