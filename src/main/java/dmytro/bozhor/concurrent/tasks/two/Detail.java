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
        var index = RandomUtil.getRandomInt(9);
        return switch (index) {
            case 0 -> HEAD;
            case 1 -> BODY;
            case 2 -> LEFT_ARM;
            case 3 -> RIGHT_ARM;
            case 4 -> LEFT_LEG;
            case 5 -> RIGHT_LEG;
            case 6 -> CPU;
            case 7 -> RAM;
            case 8 -> HDD;
            default -> throw new RuntimeException();
        };
    }
}
