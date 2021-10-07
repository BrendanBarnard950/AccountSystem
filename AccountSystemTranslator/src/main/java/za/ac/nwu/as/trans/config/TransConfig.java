package za.ac.nwu.as.trans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import za.ac.nwu.as.repo.config.RepoConfig;
import za.ac.nwu.as.repo.persistence.AccountTypeRepo;

@Import({RepoConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.as.trans"
})

public class TransConfig {

}
