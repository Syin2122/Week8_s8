import java.util.Scanner;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {
    double peakFactor;

    Metro(double distance, double peakFactor) {
        super(distance);
        this.peakFactor = peakFactor;
    }

    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakFactor;
    }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport t;

            switch (type) {
                case "BUS":
                    t = new Bus(distance);
                    break;

                case "TRAIN":
                    t = new Train(distance);
                    break;

                default:
                    double factor = sc.nextDouble();
                    t = new Metro(distance, factor);
            }

            double fare = t.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
