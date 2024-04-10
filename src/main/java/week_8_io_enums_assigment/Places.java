package week_8_io_enums_assigment;

public enum Places {
    Winner("Winner"),
    Runner_up("Runner-up"),
    Third_Place("Third Place");

    private final String name;

    Places(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
