package com.eventcraft.Services.PlanEvent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcraft.Repository.PlanEvent.HelperRepository;
import com.eventcraft.entities.PlanEvent.Helper;

import java.util.List;

@Service
public class HelperService {

    @Autowired
    private HelperRepository helperRepository;

    public List<Helper> getAllHelpers() {
        return helperRepository.findAll();
    }

    public Helper getHelperById(Long id) {
        return helperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Helper not found"));
    }

    public Helper createHelper(Helper helper) {
        return helperRepository.save(helper);
    }

    public Helper updateHelper(Long id, Helper updatedHelper) {
        Helper existingHelper = helperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Helper not found"));

        existingHelper.setPlanEvent(updatedHelper.getPlanEvent());
        existingHelper.setHelper(updatedHelper.getHelper());
        existingHelper.setHelperPrivileges(updatedHelper.getHelperPrivileges());

        return helperRepository.save(existingHelper);
    }

    public void deleteHelper(Long id) {
        helperRepository.deleteById(id);
    }
}

