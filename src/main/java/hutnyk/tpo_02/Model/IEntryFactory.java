package hutnyk.tpo_02.Model;

public interface IEntryFactory {
    IEntry createEntry(String english, String german, String polish);
}
