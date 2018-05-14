package ro.tudorfnsn.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.tudorfnsn.Converter.ConverterUser;
import ro.tudorfnsn.DataTransferObject.UserDTO;
import ro.tudorfnsn.Model.UserEntity;
import ro.tudorfnsn.Repository.RepositoryRole;
import ro.tudorfnsn.Repository.RepositoryUser;


import java.util.HashSet;


@Service
public class ServiceUser
{
    private RepositoryUser userRepository;
    private RepositoryRole roleRepository;
    private ConverterUser converterUserEntityDTO;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ServiceUser(RepositoryUser userRepository, RepositoryRole roleRepository, ConverterUser converterUser)
    {
       this.converterUserEntityDTO = converterUser;
        // we initialize the user repository
        this.userRepository = userRepository;
        // we initialize the role repository
        this.roleRepository = roleRepository;
        // we initialize the user validator
        // we initialize the converter
        this.converterUserEntityDTO = converterUser;
        // we initialize the password encoder
        this.passwordEncoder = new BCryptPasswordEncoder();

    }


    public void create(UserDTO userDTO) throws Exception
    {
        // we check if the user is existent
        if(containsUser(userDTO))
        {
            throw new Exception("Email already registered");
        }



        // we convert the user to an entity
        UserEntity userEntity = converterUserEntityDTO.OneToModel(userDTO);




        System.out.println("Converted checked");

        // we set the roles of the user
        userEntity.setRoles(new HashSet<>(roleRepository.findAll()));

        System.out.println("Roles checked");

        // we encode the password
        userEntity.setPassword(encodePassword(userEntity.getPassword()));


        System.out.println(userEntity.getUsername());
        System.out.println(userEntity.getPassword());
        System.out.println(userEntity.getRoles());
        System.out.println(userEntity.getId());

        // we save the user
        userRepository.save(userEntity);

    }

    private String encodePassword(String password)
    {
        // we encode the password
        String encodedPassword = passwordEncoder.encode(password);

        // we return the encoded password
        return encodedPassword;
    }

    private boolean containsUser(UserDTO userDTO)
    {
        // we get the user with the given email
        UserEntity foundUser = userRepository.findByUsername(userDTO.getUsername());
        // we check if a user was found
        if(foundUser == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
