package ro.tudorfnsn.Converter.ConverterInterface;

import java.util.List;

public interface ConverterInterface<Model, DTO>
{
    DTO OneToDTO(Model model);
    List<DTO> ManyToDTO(List<Model> models);
    Model OneToModel(DTO dto);
    List<Model> ManyToModel(List<DTO> dtos);
}
