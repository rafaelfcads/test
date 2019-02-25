package br.com.atech.test.pilot;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.atech.test.flight.Flight;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(of = "brevete")
@NoArgsConstructor
@RequiredArgsConstructor
public class Pilot {

    @Id
    @NonNull
    private String brevete;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pilot")
    private List<Flight> flights;
}
