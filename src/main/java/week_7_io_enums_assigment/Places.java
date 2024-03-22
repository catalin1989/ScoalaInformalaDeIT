package week_7_io_enums_assigment;

public enum Places {
    Winner("Winner"),
    Runner_up("Runner-up"),
    Third_Place("Third Place");

    private String name;
    private Places(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
