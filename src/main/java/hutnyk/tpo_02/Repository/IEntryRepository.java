package hutnyk.tpo_02.Repository;

import hutnyk.tpo_02.Model.BasicEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface IEntryRepository extends JpaRepository<BasicEntry, Long> {
    Optional<BasicEntry> findByEnglish(String englishWord);

    @Query("DELETE FROM BasicEntry e WHERE e.english = :englishWord")
    @Modifying
    @Transactional
    int deleteByEnglish(@Param("englishWord") String englishWord);

    @Query(value = "SELECT * FROM basic_entry ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<BasicEntry> findRandom();

}
