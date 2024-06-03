package Resources;

public abstract class Notes {

    private String noteProviderName1 = "Student-1";
    private String noteProviderID = "2200421**";
    private String noteProviderName2 = "Student-2";

    public Notes(String noteProviderName1, String noteProviderID) {
        this.noteProviderName1 = noteProviderName1;
        this.noteProviderID = noteProviderID;
    }

    public Notes() {
    }

    public String getNoteProviderName1() {
        return noteProviderName1;
    }
    public void setNoteProviderName1(String noteProviderName1) {
        this.noteProviderName1 = noteProviderName1;
    }

    public String getNoteProviderID() {
        return noteProviderID;
    }
    public void setNoteProviderID(String noteProviderID) {
        this.noteProviderID = noteProviderID;
    }

    public String getNoteProviderName2() {
        return noteProviderName2;
    }
    public void setNoteProviderName2(String noteProviderName2) {
        this.noteProviderName2 = noteProviderName2;
    }
}
