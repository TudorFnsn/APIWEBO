package ro.tudorfnsn.Converter;

import org.springframework.stereotype.Component;
import ro.tudorfnsn.Converter.ConverterInterface.ConverterInterface;
import ro.tudorfnsn.DataTransferObject.UserDTO;
import ro.tudorfnsn.Model.UserEntity;

import java.util.ArrayList;
import java.util.List;


@Component
public class ConverterUser implements ConverterInterface<UserEntity, UserDTO>
{





    @Override
    public UserDTO OneToDTO(UserEntity userEntity) {
        // we create the user dto
        UserDTO userDTO = new UserDTO();
        // we set the attributes
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword("***");

        // we return the dto
        return userDTO;
    }

    @Override
    public List<UserDTO> ManyToDTO(List<UserEntity> userEntities)
    {
        List<UserDTO> userDTOList = new ArrayList<>();

        for(UserEntity userEntity : userEntities )
        {
            userDTOList.add(OneToDTO(userEntity));
        }

        return userDTOList;
    }

    @Override
    public UserEntity OneToModel(UserDTO userDTO) {
        // we create a new user entity
        UserEntity userEntity = new UserEntity(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword());
        // we return the user entity
        return userEntity;
    }

    @Override
    public List<UserEntity> ManyToModel(List<UserDTO> userDTOS)
    {
        List<UserEntity> userEntityList = new ArrayList<>();

        for(UserDTO userDTO : userDTOS)
        {
            userEntityList.add(OneToModel(userDTO));
        }

        return userEntityList;

    }

}
