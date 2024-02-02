package org.harvey.ci.web;

import org.harvey.ci.core.HJob;
import org.harvey.ci.core.service.Info;
import org.harvey.ci.core.service.InfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    public InfoFactory infoFactory;
    
    @GetMapping("/jobs/{id}")
    public HJob findJob(@PathVariable String id) {
        Info<HJob> info = infoFactory.get(HJob.class);
        return info.find(id);
    }

}
