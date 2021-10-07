package za.ac.nwu.as.logic.config;

import org.springframework.context.annotation.*;
import za.ac.nwu.as.trans.config.TransConfig;

@Import({TransConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.as.logic.flow"
})
public class LogicConfig {
}
