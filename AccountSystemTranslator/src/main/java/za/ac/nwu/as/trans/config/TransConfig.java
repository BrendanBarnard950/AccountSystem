package za.ac.nwu.as.trans.config;

import org.springframework.context.annotation.*;
import za.ac.nwu.as.repo.config.RepoConfig;

@Import({RepoConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.as.trans"
})

public class TransConfig {

}
