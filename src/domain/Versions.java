package domain;

public enum Versions {
    PILLS("таблетки"), CAPSULES("капсулы"), POWDER("порошок"), DROPS("капли");

    private String versions;

    public String getName() {
        return versions;
    }

    private Versions(String versions) {
        this.versions = versions;
    }
}
