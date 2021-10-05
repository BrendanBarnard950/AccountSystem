package za.ac.nwu.as.web.sb.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountTypeController {
    @GetMapping("/all")
    public String StringDir(){
        return "Bruh";
    }
}
