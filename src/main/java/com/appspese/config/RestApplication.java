package com.appspese.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.appspese.controller.ProvaController;
import com.appspese.controller.SpesaController;
import com.appspese.controller.UtenteController;

import java.util.Set;
import java.util.HashSet;

@ApplicationPath("/")
public class RestApplication extends Application {


    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(SpesaController.class);
        resources.add(UtenteController.class);
        resources.add(ProvaController.class);
        return resources;
    }




}