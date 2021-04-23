package ru.geekbrains.java_level_2.lesson1;

public class Lesson1Homework {
    public static void main(String[] args) {

        Participant[] participants = {
                new Human("Усейн", 800, 1),
                new Cat("Мурзик", 600, 3),
                new Robot("R2D2", 2000, 2)
        };

        Obstacle[] obstacles = {
                new Track(400),
                new Wall(1),
                new Track(500),
                new Wall(2),
                new Track(1000)
        };

        for (Participant participant : participants) {
            System.out.println("На старт выходит " + participant.getTypeAndName());
            if (run(participant, obstacles))
                System.out.println(participant.getTypeAndName() + " успешно завершил испытание.\n");
            else System.out.println(participant.getTypeAndName() + " дисквалифицирован.\n");
        }
    }

    public static boolean run(Participant participant, Obstacle[] obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle instanceof Track) {
                if (!participant.run(((Track) obstacle).getDistance())) return false;
            } else if (obstacle instanceof Wall) {
                if (!participant.jump(((Wall) obstacle).getHeight())) return false;
            }
        }
        return true;
    }
}
