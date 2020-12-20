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

    public Area getAreaByName(String name, List<Area> areas){
        for (Area area : areas){
            area.getName().equals(name);{
                return area;
            }
        } return null;
    }

    public List<Area> getAllAreas(){
        List<Area> areas = areaRepository.findAll();
        return areas;
    }

    public AreaResponseBody setArea(AreaRequestBody areaRequestBody) {
        Area area = new Area(areaRequestBody.getName(), areaRequestBody.getDescription(), areaRequestBody.getLat1(), areaRequestBody.getLong1(), areaRequestBody.getLat2(), areaRequestBody.getLong2());

        areaRepository.save(area);

        AreaResponseBody areaResponseBody = new AreaResponseBody(area.getName(), area.getDescription(), area.getLat1(), area.getLong1(), area.getLat2(), area.getLong2());
        return areaResponseBody;
    }

}
