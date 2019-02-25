package br.com.atech.test.flight;

import lombok.Getter;

@Getter
public enum Status {
    SCHEDULED,
    DELAYED,
    DEPARTED,
    IN_AIR,
    EXPECTED,
    DIVERTED,
    RECOVERY,
    LANDED,
    ARRIVED,
    CANCELLED,
    PAST_FLIGHT
}