import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;

        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("-----------------------------------------------------\nC <Name> ---> Create a person profile\nS <Name> <Song> ---> Add a song for a person profile \nE <Name> <Song> ---> Delete a song in a profile\nL <Name> --->  Lists the songs of the person" +
                    "\nN ---> List all names of registered people\nM ---> List all the songs that liked by anyone\nR ---> Recommends the most popular 3 different songs\nStop ---> Exit the program\n-----------------------------------------------------");
            String process = input.nextLine().toLowerCase();
            String[] listOfInput = (process.toLowerCase().split(" "));

            switch (listOfInput[0]) {
                case "c":
                    if (listOfInput.length == 2)
                        list.create(listOfInput[1]);
                    else
                        System.out.println("Please enter a name.");
                    break;
                case "s":
                    if (listOfInput.length >= 3) {
                        String song = "";
                        if (list.searchPerson(listOfInput[1]) != null) {
                            for (int j = 2; j < listOfInput.length; j++) {
                                song += listOfInput[j] + " ";
                            }
                            Person person = list.searchPerson(listOfInput[1]);
                            person.getLikedSongs().addSong(song.trim());

                        } else {
                            System.out.println("First you should create a profile.");
                        }
                    } else
                        System.out.println("Missing input. Please check the guidance.");
                    break;
                case "e":
                    if (listOfInput.length >= 3) {
                        name = listOfInput[1];
                        String likedSong = "";
                        for (int j = 2; j < listOfInput.length; j++) {
                            likedSong += listOfInput[j] + " ";
                        }

                        list.deleteSong(name, likedSong.trim());
                    } else
                        System.out.println("Missing input. Please check the guidance.");
                    break;
                case "l":
                    if (listOfInput.length == 1)
                        System.out.println("You should enter a name.");
                    else {
                        name = listOfInput[1];
                        list.printSongsForPerson(name);
                    }
                    break;
                case "n":
                    if (listOfInput.length == 1)
                        list.printListAsPersonName();
                    else
                        System.out.println("Invalid input. Please check the guidance. ");
                    break;
                case "m":
                    if (listOfInput.length == 1)
                        list.printListAsSongName();
                    else
                        System.out.println("Invalid input. Please check the guidance. ");
                    break;
                case "r":
                    if (listOfInput.length == 1) {
                        System.out.println("Recommended 3 songs:");
                        list.recSongs();
                    } else
                        System.out.println("Invalid input. Please check the guidance. ");
                    break;
                case "stop":
                    System.out.println("Program is stopping...");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please check the guidance. ");
            }
        }
    }
}
