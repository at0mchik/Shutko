package ru.mirea.Shutko.dto;

import ru.mirea.Shutko.models.Tournament;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TournamentDTO {
    private int id, prize;
    private String name;
    private String[] teams;
}
