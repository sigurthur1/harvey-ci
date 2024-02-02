package org.harvey.ci.core.service;

public interface InfoFactory {
    public <T> Info<T> get(Class<T> type);
}
