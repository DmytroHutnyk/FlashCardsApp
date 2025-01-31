package flashCards.Model;

public interface IEntryFactory {
    IEntry createEntry(String english, String german, String polish);
}
