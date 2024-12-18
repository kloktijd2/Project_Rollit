package rollit;

public enum Color {
    //empty is for error scenarios
    RED, GREEN, BLUE, YELLOW, EMPTY;

    @Override
    public String toString() {
        String string;
        switch (this) {
            case GREEN -> {
                string = "groen";
            }
            case RED -> {
                string = "rood";
            }

            case BLUE -> {
                string = "blauw";
            }

            case YELLOW -> {
                string = "geel";
            }

            default -> {
                string = " ";
            }

        }
        return string;
    }

    public String getChar()

    {
        String string;
        switch (this) {
            case GREEN -> {
                string = "G";
            }
            case RED -> {
                string = "R";
            }

            case BLUE -> {
                string = "B";
            }

            case YELLOW -> {
                string = "Y";
            }

            default -> {
                string = "0";
            }
        }
        return string;
    }
}
