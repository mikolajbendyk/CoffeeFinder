package pl.bendyk.model.coffee;

public enum Composition {
    SINGLE("Single"),
    BLEND("Blend");

    private String displayName;

    Composition(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
