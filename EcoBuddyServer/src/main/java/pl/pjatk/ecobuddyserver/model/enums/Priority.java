package pl.pjatk.ecobuddyserver.model.enums;

public enum Priority {
    EASY(1),
    MEDIUM(2),
    HARD(3);
    private final int value;
    Priority(int value) {
        this.value = value;
    }
}
