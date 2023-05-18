package ru.mirea.Shutko.controllers;

import org.springframework.http.MediaType;
import ru.mirea.Shutko.models.Tournament;
import ru.mirea.Shutko.dto.TournamentDTO;
import ru.mirea.Shutko.services.TournamentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/t")
public class TournamentController {
    private final ModelMapper modelMapper;
    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(ModelMapper modelMapper, TournamentService tournamentService) {
        this.modelMapper = modelMapper;
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public List<TournamentDTO> getAll() {
        return tournamentService.findAll().stream().map(this::convertToTournamentDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable("id")int id) {
        tournamentService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus add(@RequestBody TournamentDTO tournamentDTO) {
        tournamentService.save(convertToManufacture(tournamentDTO));
        return HttpStatus.OK;
    }


    @RequestMapping(value="/addT/{id}",
            method=RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public HttpStatus addMoreTeams(@PathVariable("id")int id, @RequestParam ArrayList<String> teams){
        System.out.println("teams: " + teams);
        tournamentService.addTeams(teams, id);
        return HttpStatus.OK;
    }

    private TournamentDTO convertToTournamentDTO(Tournament tournament) {
        return modelMapper.map(tournament, TournamentDTO.class);
    }

    private Tournament convertToManufacture(TournamentDTO tournamentDTO) {
        return modelMapper.map(tournamentDTO, Tournament.class);
    }
}
