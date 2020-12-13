package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.AreaRepository;
import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.controller.model.AreaRequestBody;
import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.services.model.AreaResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AreaServices {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private StoryRepository storyRepository;

    public Area getAreaById(UUID areaId){
        Optional<Area> area = areaRepository.findById(areaId);
        if(area.isEmpty()){
            return null;
        }
        return area.get();
    }

    public List<Area> getAllAreas(){
        List<Area> areas = areaRepository.findAll();
        return areas;
    }

    public AreaResponseBody setArea(AreaRequestBody areaRequestBody) {
        Area area = new Area(areaRequestBody.getName(), areaRequestBody.getDescription());

        areaRepository.save(area);

        AreaResponseBody areaResponseBody = new AreaResponseBody(area.getName(), area.getDescription());
        return areaResponseBody;
    }

}
