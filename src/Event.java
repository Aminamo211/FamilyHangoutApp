
public class Event {
    String eventName;
    String location;
    String eventDate;
    int familyMemberNumber;


// store them
    Event(String eventName, String location, String eventDate, int familyMemberNumber) {
        this.eventName = eventName;
        this.location = location;
        this.eventDate = eventDate;
        this.familyMemberNumber = familyMemberNumber;
//
    }
    @Override
    public String toString() {
        return "Name: " + eventName +
                "\nLocation: " + location +
                "\nDate: " + eventDate +
                "\nFamily members: " + familyMemberNumber;
    }

    String getEventName() {
        return this.eventName;
    }

    String getLocation() {
        return this.location;
    }

    String getEventDate() {
        return this.eventDate;
    }

    int getFamilyMemberNumber() {
        return this.familyMemberNumber;
    }

    void setEventName(String eventName) {
        this.eventName = eventName;
    }

    void setLocation(String location) {
        this.location = location;

    }

    void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    void setFamilyMemberNumber(int familyMemberNumber) {
        this.familyMemberNumber = familyMemberNumber;
    }

    void addFamilyMemberNumber() {
        familyMemberNumber++;
    }

    void changeLocation() {
        changeLocation();
    }
}