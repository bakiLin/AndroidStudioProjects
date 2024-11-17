package ru.mirea.bakiev.domain;

public interface ApiCallback<T> {
    public void onSuccess(T result);
    public void onFailure(Exception e);
}
