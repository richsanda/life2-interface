package w.whateva.service.life2.api;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import w.whateva.service.life2.api.dto.DtoShred;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@RequestMapping
public interface ShredOperations {

    @RequestMapping(value = "/keys", method = RequestMethod.GET, produces = "application/json")
    List<String> allKeys();

    void addShred(DtoShred shred);

    @RequestMapping(value = "/shreds/{key}", method = RequestMethod.GET, produces = "application/json")
    DtoShred readShred(@PathVariable("key") String key);

    @RequestMapping(value = "/shreds", method = RequestMethod.GET, produces = "application/json")
    List<DtoShred> allShreds();

    @RequestMapping(value = "/person/shreds", method = RequestMethod.GET, produces = "application/json")
    List<List<DtoShred>> allShreds(@RequestParam(value = "after", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate after,
                                   @RequestParam(value = "before", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate before,
                                   @RequestParam(value = "names", required = false) HashSet<String> names);
}