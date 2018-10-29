package cinema.service.utils;

import cinema.service.repositories.CinemaServise;
import cinema.service.repositories.ICinemaService;

import cinema.service.reservation.ReservationService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class CinemasStorageServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        this.bind(CinemaServise.class).to(ICinemaService.class);
        this.bind(ReservationService.class).to(ReservationService.class);
    }
}
