package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.AreaRepository;
import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.controller.model.Request.AreaRequestBody;
import BinckMap.BinckAPI.entity.Area;
import BinckMap.BinckAPI.services.model.AreaResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AreaServices {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private StoryRepository storyRepository;

    public Area getAreaById(long areaId){
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

    public List<Area> setAreas(List<AreaRequestBody> areaRequestBodies) {
        List<Area> areas = new ArrayList();

        for(AreaRequestBody areaRequestBody : areaRequestBodies){
            Area area = new Area();
            area.setName(areaRequestBody.getName());
            area.setLabelType(areaRequestBody.getLabelType());
            area.setOntwikkelaar(areaRequestBody.getOntwikkelaar());
            area.setStatus(areaRequestBody.getStatus());
            area.setProgramma(areaRequestBody.getProgramma());
            area.setStatus(areaRequestBody.getStatus());
            area.setDescription(areaRequestBody.getDescription());
            area.setLat1(areaRequestBody.getLat1());
            area.setLong1(areaRequestBody.getLong1());
            area.setLat2(areaRequestBody.getLat2());
            area.setLong2(areaRequestBody.getLong2());

            areas.add(area);
            areaRepository.save(area);
        }

        return areas;
    }

}
