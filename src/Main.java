import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Створення бази даних про кіно
        CinemaDatabase database = new CinemaDatabase();

        // Створення акторів
        Actor actor1 = new Actor("Tom Hanks");
        Actor actor2 = new Actor("Angelina Jolie");
        Actor actor3 = new Actor("Serhiy Pritula");

        // Створення фільмів
        Set<Actor> actors1 = new HashSet<>(List.of(actor1, actor2));
        Set<Actor> actors2 = new HashSet<>(List.of(actor2, actor3, actor1));
        Set<Actor> actors3 = new HashSet<>(List.of(actor1, actor3));

        Film film1 = new Film("Avangers", actors1);
        Film film2 = new Film("Forest Gump", actors2);
        Film film3 = new Film("Interstellar", actors3);

        // Додавання фільмів до бази даних
        database.addFilm(film1);
        database.addFilm(film2);
        database.addFilm(film3);

        // Завдання 1: Визначити, чи є актор, який не зіграв в жодному фільмі
        System.out.println("актор, який не зіграв в жодному фільмі: " + database.hasActorWithNoFilms());

        // Завдання 2: Скласти список акторів, з якими коли-небудь в одному фільмі грав заданий актор
        Set<String> coactors = database.getCoactorsNames(actor1);
        System.out.println("Актори які зіграли в одному фільмі з Tom Hanks: " + coactors);

        // Завдання 3: Знайти фільм з найбільшою кількістю акторів
        Film mostActorsFilm = database.findFilmWithMostActors();
        System.out.println("Фільм з найбільшою кількостю акторів: " + mostActorsFilm.title);
        database.printActorsInFilm(mostActorsFilm);

        System.out.println("Фільми другого актора: " + database.getFilmsForActor(actor2));
    }
}