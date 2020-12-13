
public class Person {
    private String personName;
    Person next;
    private LinkedList likedSongs = new LinkedList();

    public Person(String personName) {
        this.personName = personName;
        this.next = null;

    }

    public String getPersonName() {
        if (personName != null)
            return personName;
        else
            return null;
    }

    public LinkedList getLikedSongs() {
        return likedSongs;
    }
}

