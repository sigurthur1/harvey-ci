package org.harvey.ci.core.service;

import org.harvey.ci.core.HJob;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneralInfoFactory implements InfoFactory {

    @Autowired
    private HJobInfo hJobInfo;

    @Override
    public <T> Info<T> get(Class<T> type) {
        if (type == HJob.class) {
            return hJobInfo;
        }
        throw new NullPointerException("Non-existing Info implementation requested '" + type.getName() + "'");
    }

}
