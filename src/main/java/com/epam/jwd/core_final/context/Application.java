package com.epam.jwd.core_final.context;

import com.epam.jwd.core_final.context.impl.NasaContext;
import com.epam.jwd.core_final.context.impl.NasaMenu;
import com.epam.jwd.core_final.exception.InvalidStateException;

import java.util.function.Supplier;
public interface Application {

    static ApplicationMenu start() throws InvalidStateException {
        final NasaMenu nasaMenu = NasaMenu.getInstance();
        final Supplier<ApplicationContext> applicationContextSupplier = nasaMenu::getApplicationContext; // todo
        final NasaContext nasaContext = NasaContext.getInstance();

        nasaContext.init();
        nasaMenu.init();
        return applicationContextSupplier::get;
    }
}
