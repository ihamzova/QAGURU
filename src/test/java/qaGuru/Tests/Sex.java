package qaGuru.Tests;

public enum Sex {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    public final String desc;

    Sex(String desc) {
        this.desc = desc;
    }
}