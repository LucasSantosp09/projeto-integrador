package projetointegrador.DigitalHouse.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configuração para corresponder campos mesmo que os nomes sejam diferentes
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Configuração para correspondência de campos privados
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        return modelMapper;
    }
}
