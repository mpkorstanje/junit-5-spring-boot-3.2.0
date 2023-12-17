package com.example;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.springframework.stereotype.Component;

@Component
public class JUnitTestRunner {

    public void run() {
        var request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage("com.example"))
                .build();
        var initialLauncher = LauncherFactory.create();
        initialLauncher.execute(request);
    }
}
