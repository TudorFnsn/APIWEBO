package ro.tudorfnsn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tudorfnsn.DataTransferObject.UserDTO;
import ro.tudorfnsn.Model.UserEntity;
import ro.tudorfnsn.Service.ServiceUser;


@RestController
@RequestMapping("/user")
public class ControllerUser
{

    private ServiceUser serviceUser;


    @Autowired
    public ControllerUser(ServiceUser service)
    {
        this.serviceUser = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUser(@RequestBody UserDTO userDTO)
    {
        try {
            serviceUser.create(userDTO);
        }
        catch (Exception e){

        }
    }

}