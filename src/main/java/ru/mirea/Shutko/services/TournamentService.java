package ru.mirea.Shutko.services;

import ru.mirea.Shutko.models.Tournament;
import ru.mirea.Shutko.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    @Transactional
    public void addTeams(ArrayList<String> newTeams, int id){
        var tournament = tournamentRepository.getOne(id);

        System.out.println(tournament.getTeams());

        ArrayList<String> teams = tournament.getTeams();

        if (teams == null)
            tournament.setTeams(newTeams);
        else {
            teams.addAll(newTeams);
            tournament.setTeams(teams);
        }

        System.out.println(tournament.getTeams());

        tournamentRepository.save(tournament);
    }
    @Transactional
    public void save(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    @Transactional
    public void delete(int id) {
        tournamentRepository.deleteById(id);
    }
}
