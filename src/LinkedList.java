import java.util.*;

public class LinkedList {
    Person headP;
    Song headS;

    /**
     * create--> person +
     * addSong-->song +
     * delete-->song +
     * print all person +
     * print all songs +
     * print song for a person +
     * recommended songs +
     */

    public void create(String personName) {
        if (searchPerson(personName) != null) {
            System.out.println("This person is already existed!");
            return;
        } else {
            Person new_node = new Person(personName);

            if (headP == null) {
                headP = new Person(personName);
                System.out.println(personName+" adlı kişi oluşturuldu.");
                return;
            }

            new_node.next = null;

            Person copyOfHead = headP;
            while (copyOfHead.next != null)
                copyOfHead = copyOfHead.next;

            copyOfHead.next = new_node;

        }
        System.out.println(personName+" adlı kişi oluşturuldu");
    }

    public void addSong(String songName) {
        if (searchSong(songName) != null) {
            System.out.println("This song has already in the list.");
        } else {
            Song new_node = new Song(songName);

            if (headS == null) {
                headS = new Song(songName);
                return;
            }

            new_node.next = null;

            Song copyOfHead = headS;
            while (copyOfHead.next != null)
                copyOfHead = copyOfHead.next;

            copyOfHead.next = new_node;
        }

    }

    void deleteSong(String personName, String songName) {
        Person selectedPerson = searchPerson(personName);
        Song temp = selectedPerson.getLikedSong().headS, prev = null;

        if (temp != null && temp.getSongName().equals(songName)) {
            headS = temp.next;
            return;
        }
        while (temp != null && !temp.getSongName().equals(songName)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;


        prev.next = temp.next;
    }

    public void printListAsPersonName() {
        if (headP == null)
            System.out.println("There is no person registered.");
        else {
            Person currentPerson = headP;
            System.out.println("Registered people :");
            while (currentPerson != null) {
                System.out.println(currentPerson.getPersonName() + " ");
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
            System.out.println("Liked songs: ");
            int counter = 1;
            while (currentPerson != null) {
                Song currentSong = currentPerson.getLikedSong().headS;
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
                    System.out.println(counter++ + ". " + s);


        }
    }

    void printSong(String name) {
        Person currentPerson = searchPerson(name);

        if (searchPerson(name).getLikedSong() == null)// *************************************
            System.out.println("There is no song in the list");
        else {
            Song temp = currentPerson.getLikedSong().headS;
            int numOfSong = 1;
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
            Song currentSong = copyOfHead.getLikedSong().headS;
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
                    if (listOfAllSong.get(i).equals(listOfAllSong.get(j)))
                        counter++;
                }
                map.put(listOfAllSong.get(i), counter);
                Collections.replaceAll(listOfAllSong, listOfAllSong.get(i), " ");
            }
        }
        printMap(map);

    }

    private void printMap(Map<String, Integer> map) {
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
            map.remove(key);
            max = 0;
            counter++;
            System.out.println(key);
        }
    }

    Person searchPerson(String name) {
        Person temp = headP;
        while (temp != null) {
            if (temp.getPersonName().toLowerCase().equals(name.toLowerCase())) {
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

