import java.util.*;

public class LinkedList {
    Person headP;
    Song headS;

    public void create(String personName) {
        if (searchPerson(personName) != null) {
            System.out.println("This person is already existed!");
            return;
        } else {
            Person new_node = new Person(personName);

            if (headP == null) {
                headP = new Person(personName);
                System.out.println("The person profile named " + "'" + personName + "'" + " is created.");
                return;
            }

            new_node.next = null;

            Person copyOfHead = headP;
            while (copyOfHead.next != null)
                copyOfHead = copyOfHead.next;

            copyOfHead.next = new_node;

        }
        System.out.println("The person profile named " + "'" + personName + "'" + " is created.");
    }

    public void addSong(String songName) {
        if (searchSong(songName) != null) {
            System.out.println("This song has already in the list.");
            return;
        } else {
            Song new_node = new Song(songName);

            if (headS == null) {
                headS = new Song(songName);
                System.out.println("The song " + "'" + songName + "'" + " is added.");
                return;
            }

            new_node.next = null;

            Song copyOfHead = headS;
            while (copyOfHead.next != null)
                copyOfHead = copyOfHead.next;

            copyOfHead.next = new_node;
            System.out.println("The song " + "'" + songName + "'" + " is added.");
        }

    }

    public void deleteSong(String personName, String songName) {
        Person selectedPerson = searchPerson(personName);
        Song temp = selectedPerson.getLikedSongs().headS, prev = null;
        if (temp == null) {
            System.out.println("There is no song in the list.");
            return;
        }
        if (temp.getSongName().equalsIgnoreCase(songName)) {
            selectedPerson.getLikedSongs().headS = null;
            System.out.println("'" + selectedPerson.getPersonName() + "'" + " doesn’t like the song " + "'" + songName + "'" + " anymore.");
            return;
        }
        while (temp != null) {
            if (temp.getSongName().equalsIgnoreCase(songName)) {
                prev.next = temp.next;
                System.out.println("'" + selectedPerson.getPersonName() + "'" + " doesn’t like the song " + "'" + songName + "'" + " anymore.");
                return;
            } else
                System.out.println("The song is not in the list. ");
            prev = temp;
            temp = temp.next;
        }


    }

    public void printListAsPersonName() {
        if (headP == null)
            System.out.println("There is no person registered.");
        else {
            Person currentPerson = headP;
            System.out.println("Registered people :");
            int numOfPeople = 1;
            while (currentPerson != null) {
                System.out.println(numOfPeople++ + ". " + currentPerson.getPersonName() + " ");
                currentPerson = currentPerson.next;
            }
        }
    }

    public void printListAsSong() {
        if (headP == null)
            System.out.println("There is no person registered.");
        else {
            Person currentPerson = headP;

            Set<String> allSongs = new HashSet<>();
            System.out.println("The songs that registered people like : ");
            int numOfSongs = 1;
            while (currentPerson != null) {
                Song currentSong = currentPerson.getLikedSongs().headS;
                while (currentSong != null) {
                    allSongs.add(currentSong.getSongName());
                    currentSong = currentSong.next;
                }
                currentPerson = currentPerson.next;
            }
            if (allSongs.isEmpty())
                System.out.println("No song found.");
            else
                for (String s : allSongs)
                    System.out.println(numOfSongs++ + ". " + s);


        }
    }

    void printSong(String name) {
        Person currentPerson = searchPerson(name);

        if (currentPerson.getLikedSongs().headS == null)
            System.out.println("There is no song in the list.");
        else {
            Song temp = currentPerson.getLikedSongs().headS;
            int numOfSong = 1;
            System.out.println("The liked songs for " + "'" + currentPerson + "' :");
            while (temp != null) {
                System.out.println(numOfSong + ". " + temp.getSongName());
                numOfSong++;
                temp = temp.next;
            }
        }
    }

    public void recSongs() {
        ArrayList<String> listOfAllSong = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Person copyOfHead = headP;
        while (copyOfHead != null) {
            Song currentSong = copyOfHead.getLikedSongs().headS;
            while (currentSong != null) {
                listOfAllSong.add(currentSong.getSongName());
                currentSong = currentSong.next;
            }
            copyOfHead = copyOfHead.next;
        }

        for (int i = 0; i < listOfAllSong.size(); i++) {
            int counter = 1;
            if (!listOfAllSong.get(i).equals(" ")) {
                for (int j = i + 1; j < listOfAllSong.size(); j++) {
                    if (listOfAllSong.get(i).equalsIgnoreCase(listOfAllSong.get(j)))
                        counter++;
                }
                map.put(listOfAllSong.get(i), counter);
                Collections.replaceAll(listOfAllSong, listOfAllSong.get(i), " ");
            }
        }
        if (map.isEmpty())
            System.out.println("There is no song is the environment.");
        if (map.size() < 3) {

            for (Map.Entry<String, Integer> iterator : map.entrySet()) {
                System.out.println("The song " + "'" + iterator.getKey() + "'" + " is liked from " + iterator.getValue() + " people.");

            }
        } else {
            map.size();
            int max = 0;
            int counter = 0;
            String key = "";
            while (counter < 3) {

                for (Map.Entry<String, Integer> iterator : map.entrySet()) {
                    if (iterator.getValue() > max) {
                        max = iterator.getValue();
                        key = iterator.getKey();
                    }
                }
                System.out.println("The song " + "'" + key + "'" + " is liked from " + max + " people.");
                map.remove(key);
                max = 0;
                counter++;

            }
        }


    }

    private void printTopThree(Map<String, Integer> map) {
        if (map.isEmpty())
            System.out.println("There is no song is the environment.");
        if (map.size() < 3) {

            for (Map.Entry<String, Integer> iterator : map.entrySet()) {
                System.out.println("The song " + "'" + iterator.getKey() + "'" + " is liked from " + iterator.getValue() + " people.");

            }
        } else {
            map.size();
            int max = 0;
            int counter = 0;
            String key = "";
            while (counter < 3) {

                for (Map.Entry<String, Integer> iterator : map.entrySet()) {
                    if (iterator.getValue() > max) {
                        max = iterator.getValue();
                        key = iterator.getKey();
                    }
                }
                System.out.println("The song " + "'" + key + "'" + " is liked from " + max + " people.");
                map.remove(key);
                max = 0;
                counter++;

            }
        }
    }

    Person searchPerson(String name) {
        Person temp = headP;
        while (temp != null) {
            if (temp.getPersonName().equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    Song searchSong(String name) {
        Song temp = headS;
        while (temp != null) {
            if (temp.getSongName().equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


}

