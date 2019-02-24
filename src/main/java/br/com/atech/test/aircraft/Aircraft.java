package br.com.atech.test.aircraft;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(of = "serialNumber")
@NoArgsConstructor
@RequiredArgsConstructor
public class Aircraft {

    @Id
    @NonNull
    @Column(name = "serial_number")
    private String serialNumber;

    @NonNull
    private String model;
}
