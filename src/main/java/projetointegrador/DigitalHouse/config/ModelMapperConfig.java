package projetointegrador.DigitalHouse.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projetointegrador.DigitalHouse.dto.response.CarroResponseDTO;
import projetointegrador.DigitalHouse.model.CaracteristicaCarro;
import projetointegrador.DigitalHouse.model.Carro;

import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configuração para corresponder campos mesmo que os nomes sejam diferentes
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Configuração para correspondência de campos privados
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        // Configurando o mapeamento
        modelMapper.addMappings(carroMap());

        return modelMapper;
    }

    private PropertyMap<Carro, CarroResponseDTO> carroMap() {
        return new PropertyMap<>() {
            protected void configure() {
                map().setCategoriaResponse(source.getCategoriaCarro().getNome());
                map().setLocadoraResponse(source.getLocadoraCarro().getNome());
                map().setCaracteristicasResponse(source.getCaracteristicaCarro().stream().map(CaracteristicaCarro::getNome).collect(Collectors.toList()));
            }
        };
    }
}