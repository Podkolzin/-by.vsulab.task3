package domain;

public enum MedicationGroup {
    ANTIBIOTIC ("антибиотики"), PAINRELIEVER ("болеутоляющие"), VITAMIN ("витамины");

    private String name;

    public String getName() {
        return name;
    }

    private MedicationGroup(String name) {
        this.name = name;
    }
}
