package pl.bendyk.model.coffee;

public enum Roast {
    LIGHT("Jasne"),
    MEDIUM("Średnie"),
    DARK("Ciemne");

    private String displayName;

    Roast(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
