package rollit;

public enum Color {
    //empty is for error scenarios
    RED, GREEN, BLUE, YELLOW;

    @Override
    public String toString() {
        String string;
        switch (this) {
            case GREEN -> string = "groen";
            case RED -> string = "rood";

            case BLUE -> string = "blauw";

            case YELLOW -> string = "geel";

            default -> string = " ";

        }
        return string;
    }

    public String getChar()

    {
        String string;
        switch (this) {
            case GREEN -> string = "\u001B[32m"+ "G" + "\u001B[0m";
            case RED -> string = "\u001B[31m"+ "R"+ "\u001B[0m";

            case BLUE -> string = "\u001B[34m"+ "B"+"\u001B[0m";

            case YELLOW -> string = "\u001B[33m"+ "Y" +"\u001B[0m";

            default -> string = "0";
        }
        return string;
    }
}
