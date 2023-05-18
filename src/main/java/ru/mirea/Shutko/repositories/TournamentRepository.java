package ru.mirea.Shutko.repositories;

import ru.mirea.Shutko.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository  extends JpaRepository<Tournament, Integer> {
}
