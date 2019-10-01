package com.andrel.parkingsystem;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloWorld {

    /**
     * @return String
     */
    @GetMapping
    public String sayHello() {
        return "Hello from SpringBoot";
    }

    @PostMapping("/postMap")
    public String postHello(@RequestBody Map<String, Object> payload) {
        return payload.get("name").toString();
    }

    /**
     * @param name String
     * @return String
     */
    @GetMapping("/{dynamic}")
    public String dynamicHello(@PathVariable("dynamic") String name) {
        return "Hello " + name + ", this is dynamic route";
    }

    /**
     * @param name String
     * @return String
     */
    @GetMapping("/subpath")
    @ResponseBody
    public String requestParameters(@RequestParam(value = "name", required = false) String name) {
        return "The RequestParam for the param " + name;
    }

    /**
     * @param request String
     * @return String
     */
    @GetMapping("/webrequest")
    public String paramWebRequest(final WebRequest request) {
        String name = request.getParameter("name");
        return "The subpath for the WebRequest " + name;
    }
}
