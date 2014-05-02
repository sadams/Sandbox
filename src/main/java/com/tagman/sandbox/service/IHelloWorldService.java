package com.tagman.sandbox.service;

/**
 * Created by antoine on 02/05/14.
 */
public interface IHelloWorldService {

    /**
     * Return greeting for a given user
     * @param name the name of the user to welcome
     * @return the greeting
     */
    public String greeting(String name);

    /**
     * Return generic greeting
     * @return the greeting
     */
    public String greeting();

}
