package br.com.atech.test.flight;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.atech.test.aircraft.Aircraft;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import br.com.atech.test.airport.Airport;
import br.com.atech.test.pilot.Pilot;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
public class Flight {

    @Id
    @NonNull
    private Long id;

    @NonNull
    @Column(name = "depart_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departDate;

    @NonNull
    @Column(name = "arrive_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arriveDate;

    @NonNull
    @JoinColumn(name = "aircraft")
    @ManyToOne
    private Aircraft aircraft;

    @NonNull
    @JoinColumn(name = "pilot")
    @ManyToOne
    private Pilot pilot;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NonNull
    @JoinColumn(name = "depart")
    @ManyToOne
    private Airport depart;

    @NonNull
    @JoinColumn(name = "arrive")
    @ManyToOne
    private Airport arrive;
}
