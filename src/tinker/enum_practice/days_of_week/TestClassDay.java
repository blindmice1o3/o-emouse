package tinker.enum_practice.days_of_week;

public class TestClassDay {
    Day day;

    public TestClassDay(Day day) {
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
        TestClassDay firstDay = new TestClassDay(Day.MONDAY);
        firstDay.tellItLikeItIs();

        TestClassDay thirdDay = new TestClassDay(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();

        TestClassDay fifthDay = new TestClassDay(Day.FRIDAY);
        fifthDay.tellItLikeItIs();

        TestClassDay sixthDay = new TestClassDay(Day.SATURDAY);
        sixthDay.tellItLikeItIs();

        TestClassDay seventhDay = new TestClassDay(Day.SUNDAY);
        seventhDay.tellItLikeItIs();

    } // end main()

} // end TestClassDay class