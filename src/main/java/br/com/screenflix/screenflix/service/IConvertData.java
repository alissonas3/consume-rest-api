package br.com.screenflix.screenflix.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> classes);
}
