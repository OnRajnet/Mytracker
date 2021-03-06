package cz.uhk.rajneon1.tracker.dao;

import cz.uhk.rajneon1.tracker.model.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballMatchRepository extends JpaRepository<FootballMatch, Integer> {

    @Nullable
    FootballMatch getOneById(int id);

}
