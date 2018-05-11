package co.uk.lingzone.datasource.perlin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.uk.lingzone.datasource.perlin.dto.Data3D;
import co.uk.lingzone.datasource.perlin.service.Data3DService;


@RestController
public class RESTController {
    
    @Autowired
    private Data3DService data3DService;
    
    
    
    
    @RequestMapping("/ping")
    public String ping() {
        return "Hi";
    }

    
    
    
    /*
     * Default to a small grid of x,y,z Perlin values
     */
    @RequestMapping("/perlin")
    public Data3D generate(@RequestParam(value = "xOffset", defaultValue = "0.5") double xOffset,
            @RequestParam(value = "xStep", defaultValue = "0.01") double xStep,
            @RequestParam(value = "xCount", defaultValue = "3") int xCount,

            @RequestParam(value = "yOffset", defaultValue = "0.5") double yOffset,
            @RequestParam(value = "yStep", defaultValue = "0.01") double yStep,
            @RequestParam(value = "yCount", defaultValue = "3") int yCount,

            @RequestParam(value = "zOffset", defaultValue = "0.3") double zOffset,
            @RequestParam(value = "zStep", defaultValue = "0.0") double zStep,
            @RequestParam(value = "zCount", defaultValue = "1") int zCount) {

        Data3D data = data3DService.generate3dnoise(xOffset, xStep, xCount, yOffset, yStep, yCount, zOffset, zStep, zCount);

        System.out.println(data);

        return data;
    }
	
}
