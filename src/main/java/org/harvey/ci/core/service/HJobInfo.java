package org.harvey.ci.core.service;

import java.util.Optional;

import org.harvey.ci.core.HHarrisville;
import org.harvey.ci.core.HJob;
import org.springframework.beans.factory.annotation.Autowired;

public class HJobInfo implements Info<HJob> {

    @Autowired
    private HHarrisville hHarrisville;

    @Override
    public HJob find(String id) {
        Optional<HJob> found = hHarrisville.getHJobs().stream()
            .filter(x -> x.getId().equals(id))
            .findFirst();
        if (found.isPresent()) {
            return found.get();
        }

        return null;
    }

}
