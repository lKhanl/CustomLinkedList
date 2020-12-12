

public class Person {
    private String personName;
    Person next;
    private LinkedList likedSong = new LinkedList();

    public Person(String personName) {
        this.personName = personName;
        this.next = null;

    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        if (personName != null)
            return personName;
        else
            return null;
    }

    public LinkedList getLikedSong() {
        return likedSong;
    }


}

