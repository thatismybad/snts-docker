package dev.thatismybad.dockerapi.hello;

import dev.thatismybad.dockerapi.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping({"", "/"})
    public ResponseEntity<ApiResponse> hello() {
        return ResponseEntity.ok(new ApiResponse("Hello World.", null));
    }
}
