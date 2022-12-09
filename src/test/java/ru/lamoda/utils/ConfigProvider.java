package ru.lamoda.utils;


import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {

    public static Properties config = ConfigFactory.create(Properties.class, System.getProperties());
}