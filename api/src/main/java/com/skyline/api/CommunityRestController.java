package com.skyline.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/community")
public class CommunityRestController {
    private CommunityRepository communityRepository;

    @Autowired
    CommunityRestController(CommunityRepository communityRepository, EventRepository eventRepository){
        this.communityRepository = communityRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new", headers="Accept=application/json")
    ResponseEntity<Object> add(@RequestBody Community input){
        Community result = communityRepository.save(new Community(input.name, input.city, input.state));
        if(result == null){
            throw new CommunityException("Could not create new community");
        }
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile", headers="Accept=application/json")
    @ResponseBody
    ResponseEntity<Object> getProfile(@RequestParam(name="id", required = false) String id, @RequestParam(name="name", required = false) String name){
        Community result = this.communityRepository.findCommunityByIdOrName(id, name);
        if(result == null){
            throw new CommunityException("Could not retrieve community. ID:" + id + ". Name: " + name);
        }
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile/all", headers="Accept=application/json")
    ResponseEntity<Object> getAll(){
        List<Community> result = this.communityRepository.findAll();
        if(result == null){
            throw new CommunityException("Could not get all communities");
        }
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }
}
