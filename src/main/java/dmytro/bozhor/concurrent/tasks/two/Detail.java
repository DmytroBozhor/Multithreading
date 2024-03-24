package dmytro.bozhor.concurrent.tasks.two;

public enum Detail {
    HEAD,
    BODY,
    LEFT_ARM,
    RIGHT_ARM,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    public static Detail getRandomDetail() {
        var values = Detail.values();
        return values[RandomUtil.getRandomInt(values.length)];
    }
}
