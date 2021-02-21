package pl.bendyk.model.coffee;

public enum Process {
    NATURAL("Natural"),
    WASHED("Washed"),
    PULPED_NATURAL("Pulped natural"),
    HONEY("Honey"),
    SEMI_WASHED("Semi-washed");

    private String displayName;

    Process(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
