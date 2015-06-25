package ua.uc.framework.mappers;

/**
 * Created by kostya on 23.06.15.
 */
public interface Mapper<From, To> {
    To map(From from);
}
