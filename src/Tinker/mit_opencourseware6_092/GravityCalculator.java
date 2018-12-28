package Tinker.mit_opencourseware6_092;

import java.util.Scanner;

public class GravityCalculator {

    public static void main(String[] args) {

        double gravity = -9.81;     // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.0;

        // Part One
        System.out.println("The object's position after " + fallingTime +
                " seconds is " + finalPosition + " m.");
        // Part One's output: "The object's position after 10.0 seconds is 0.0 m.



        // Part Two
        // x(t) = 0.5 * at^2 + v(initial)t + x(initial)
        System.out.println("x(" + fallingTime + ") = " + (0.5 * ((gravity)*(fallingTime*fallingTime)) +
                        (initialVelocity*fallingTime) + initialPosition) + " m.");
        // Part Two's output: x(10.0) = -490.5 m.

    } // end main(String[])

} // end GravityCalculator class
