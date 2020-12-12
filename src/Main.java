import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;

        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("1-) C <Name> ---> create a person profile\n2-) S <Name> <Song> ---> add a song for a person profile or create a person" +
                    " profile and then add a song\n3-) E <Name> <Song> ---> to delete a son for a profile\n4-) L <Name> --->  Lists the songs of the person" +
                    "\n5-) N ---> List all name of registered people\n6-) M ---> List all the songs that liked by anyone\n7-) R ---> Recommends the most popular 3 different songs\n8-) Stop ---> Exit the program");
            String process = input.nextLine().toLowerCase();
            String[] listOfInput = (process.toLowerCase().split(" "));

            switch (listOfInput[0]) {
                case "c":
                    if (listOfInput.length == 2)
                        list.create(listOfInput[1]);
                    else
                        System.out.println("isim gir ulan.");
                    break;
                case "s":
                    if (listOfInput.length >= 3) {
                        String song = "";
                        if (list.searchPerson(listOfInput[1]) != null) {
                            for (int j = 2; j < listOfInput.length; j++) {
                                song += listOfInput[j] + " ";
                            }
                            Person person = list.searchPerson(listOfInput[1]);
                            person.getLikedSong().addSong(song.trim());
                            System.out.println(person.getPersonName() + " adlı kişiye " + "'" + song.trim() + "'" + " adlı şarkı eklendi.");
                        } else {
                            System.out.println("First you should create a profile.");
                        }
                    } else
                        System.out.println("geçersiz değer ya isim ya şarkı girilmeli");
                    break;
                case "e":// şarkı olmayınca da çalışıyor
                    if (listOfInput.length >= 3) {
                        name = listOfInput[1];
                        String likedSong = "";
                        for (int j = 2; j < listOfInput.length; j++) {
                            likedSong += listOfInput[j] + " ";
                        }

                        list.deleteSong(name, likedSong.trim());
                        System.out.println(name + " doesn’t like the song " + "'" + likedSong.trim() + "'" + " anymore.");
                    } else
                        System.out.println("geçersiz değer");
                    break;
                case "l":
                    if (listOfInput.length == 1)
                        System.out.println("You should enter a name.");
                    else {
                        name = listOfInput[1];
                        list.printSong(name);
                    }
                    break;
                case "n":
                    if (listOfInput.length == 1)
                        list.printListAsPersonName();
                    else
                        System.out.println("Girdi yanlış.");
                    break;
                case "m":
                    if (listOfInput.length == 1)
                        list.printListAsSong();
                    else
                        System.out.println("Girdi yanlış.");
                    break;
                case "r":
                    if (listOfInput.length == 1) {
                        System.out.println("Recommended 3 songs:");
                        list.recSongs();
                    } else
                        System.out.println("Girdi yanlış.");
                    break;
                case "stop":
                    System.exit(0);
                default:
                    System.out.println("Geçersiz girdi, tekrar deneyin!");
            }


        }
    }
}
