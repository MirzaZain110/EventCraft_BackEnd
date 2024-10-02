package com.eventcraft.Controller.PlanEvent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventcraft.Services.PlanEvent.HelperService;
import com.eventcraft.entities.PlanEvent.Helper;

import java.util.List;

@RestController
@RequestMapping("/api/helpers")
public class HelperController {

    @Autowired
    private HelperService helperService;

    @GetMapping
    public ResponseEntity<List<Helper>> getAllHelpers() {
        return ResponseEntity.ok(helperService.getAllHelpers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Helper> getHelperById(@PathVariable Long id) {
        return ResponseEntity.ok(helperService.getHelperById(id));
    }

    @PostMapping
    public ResponseEntity<Helper> createHelper(@RequestBody Helper helper) {
        return ResponseEntity.ok(helperService.createHelper(helper));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Helper> updateHelper(@PathVariable Long id, @RequestBody Helper helper) {
        return ResponseEntity.ok(helperService.updateHelper(id, helper));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHelper(@PathVariable Long id) {
        helperService.deleteHelper(id);
        return ResponseEntity.noContent().build();
    }
}
