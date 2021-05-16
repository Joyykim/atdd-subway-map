package wooteco.subway.facade;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wooteco.subway.domain.Station;
import wooteco.subway.service.StationService;

@Service
@Transactional
public class StationFacade {

    private final StationService stationService;

    public StationFacade(StationService stationService) {
        this.stationService = stationService;
    }

    public Station add(Station station) {
        Long id = stationService.save(station);
        return stationService.findById(id);
    }

    public List<Station> findAll() {
        return stationService.findAll();
    }

    public void delete(Long id) {
        stationService.findById(id);
        stationService.delete(id);
    }
}