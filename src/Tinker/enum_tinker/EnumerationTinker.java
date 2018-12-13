package Tinker.enum_tinker;

public class EnumerationTinker {
    Day day;

    public EnumerationTinker(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }


    public static void main(String[] args) {
        // displays each value of the ChessToken enum on one row with a ", " separator inbetween the values unless it's
        // the last value of the ChessToken enum (in which case, it inserts a new line).
        int count0 = 0;
        int lengthChessTokenEnum = ChessToken.values().length;
        for (ChessToken token: ChessToken.values()) {
            count0++;
            System.out.print(token);
            if (count0 != lengthChessTokenEnum) {
                System.out.print(", ");
            } else {
                System.out.println("\n");
            }
        }

        // displays each value of the Day enum on one row with a ", " separator inbetween the values unless it's the
        // last value of the Day enum (in which case, it inserts a new line).
        int count = 0;
        int lengthDayEnum = Day.values().length;
        for (Day d: Day.values()) {
            count++;
            System.out.print(d);
            if (count != lengthDayEnum) {
                System.out.print(", ");
            } else {
                System.out.println("\n");
            }
        }

        // practice using the Day enum.
        EnumerationTinker firstDay = new EnumerationTinker(Day.MONDAY);
        firstDay.tellItLikeItIs();

        EnumerationTinker thirdDay = new EnumerationTinker(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();

        EnumerationTinker fifthDay = new EnumerationTinker(Day.FRIDAY);
        fifthDay.tellItLikeItIs();

        EnumerationTinker sixthDay = new EnumerationTinker(Day.SATURDAY);
        sixthDay.tellItLikeItIs();

        EnumerationTinker seventhDay = new EnumerationTinker(Day.SUNDAY);
        seventhDay.tellItLikeItIs();

    }

}
