package s.mironov.MyFirstAppSpringBoot.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }
    private List<String> stringList = new ArrayList<>();
    private Map<String, String> stringMap = new HashMap<>();
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam("s") String s) {
        if (stringList.isEmpty()) {
            stringList = new ArrayList<>();
        }
        stringList.add(s);
        return "Value added to ArrayList: " + s;
    }
    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return stringList;
    }
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam("s") String s) {
        if (stringMap.isEmpty()) {
            stringMap = new HashMap<>();
        }
        stringMap.put(String.valueOf(stringMap.size() + 1), s);
        return "Value added to HashMap: " + s;
    }
    @GetMapping("/show-map")
    public Map<String, String> showHashMap() {
        return stringMap;
    }
    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arrayListSize = stringList.size();
        int hashMapSize = stringMap.size();
        return "ArrayList содержит " + arrayListSize + " элементов, а HashMap содержит " + hashMapSize + " элементов.";
    }
}
