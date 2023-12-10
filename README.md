# Running Cucumber scenarios inside a Spring Boot 3.2.0 app

This example application demonstrates that there's an issue with executing Cucumber features inside applications based on Spring Boot 3.2.0.

Creating an uberjar and running it via `./gradlew bootJar && java -jar build/libs/cucumber-spring-boot-3.2.0-0.0.1-SNAPSHOT.jar`
leads to the following error:

```
org.junit.platform.commons.JUnitException: TestEngine with ID 'cucumber' failed to discover tests
        at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discoverEngineRoot(EngineDiscoveryOrchestrator.java:160) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discoverSafely(EngineDiscoveryOrchestrator.java:132) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discover(EngineDiscoveryOrchestrator.java:107) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discover(EngineDiscoveryOrchestrator.java:78) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        at org.junit.platform.launcher.core.DefaultLauncher.discover(DefaultLauncher.java:99) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:85) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        at org.junit.platform.launcher.core.DelegatingLauncher.execute(DelegatingLauncher.java:47) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        at org.junit.platform.launcher.core.SessionPerRequestLauncher.execute(SessionPerRequestLauncher.java:63) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        at nl.cofx.cucumber.boot.CucumberTestRunner.run(CucumberTestRunner.java:18) ~[!/:0.0.1-SNAPSHOT]
        at nl.cofx.cucumber.boot.CucumberSpringBootApplication.run(CucumberSpringBootApplication.java:21) ~[!/:0.0.1-SNAPSHOT]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.context.event.ApplicationListenerMethodAdapter.doInvoke(ApplicationListenerMethodAdapter.java:365) ~[spring-context-6.1.1.jar!/:6.1.1]
        at org.springframework.context.event.ApplicationListenerMethodAdapter.processEvent(ApplicationListenerMethodAdapter.java:237) ~[spring-context-6.1.1.jar!/:6.1.1]
        at org.springframework.context.event.ApplicationListenerMethodAdapter.onApplicationEvent(ApplicationListenerMethodAdapter.java:168) ~[spring-context-6.1.1.jar!/:6.1.1]
        at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:178) ~[spring-context-6.1.1.jar!/:6.1.1]
        at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:171) ~[spring-context-6.1.1.jar!/:6.1.1]
        at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:149) ~[spring-context-6.1.1.jar!/:6.1.1]
        at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:445) ~[spring-context-6.1.1.jar!/:6.1.1]
        at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:378) ~[spring-context-6.1.1.jar!/:6.1.1]
        at org.springframework.boot.context.event.EventPublishingRunListener.started(EventPublishingRunListener.java:103) ~[spring-boot-3.2.0.jar!/:3.2.0]
        at org.springframework.boot.SpringApplicationRunListeners.lambda$started$5(SpringApplicationRunListeners.java:76) ~[spring-boot-3.2.0.jar!/:3.2.0]
        at java.base/java.lang.Iterable.forEach(Iterable.java:75) ~[na:na]
        at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:118) ~[spring-boot-3.2.0.jar!/:3.2.0]
        at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:112) ~[spring-boot-3.2.0.jar!/:3.2.0]
        at org.springframework.boot.SpringApplicationRunListeners.started(SpringApplicationRunListeners.java:76) ~[spring-boot-3.2.0.jar!/:3.2.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:329) ~[spring-boot-3.2.0.jar!/:3.2.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1342) ~[spring-boot-3.2.0.jar!/:3.2.0]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1331) ~[spring-boot-3.2.0.jar!/:3.2.0]
        at nl.cofx.cucumber.boot.CucumberSpringBootApplication.main(CucumberSpringBootApplication.java:16) ~[!/:0.0.1-SNAPSHOT]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.boot.loader.launch.Launcher.launch(Launcher.java:91) ~[cucumber-spring-boot-3.2.0-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.launch.Launcher.launch(Launcher.java:53) ~[cucumber-spring-boot-3.2.0-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.launch.JarLauncher.main(JarLauncher.java:58) ~[cucumber-spring-boot-3.2.0-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
Caused by: java.lang.IllegalArgumentException: 'path' must contain '/!'
        at org.springframework.boot.loader.net.protocol.nested.NestedLocation.parse(NestedLocation.java:98) ~[cucumber-spring-boot-3.2.0-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.net.protocol.nested.NestedLocation.fromUri(NestedLocation.java:89) ~[cucumber-spring-boot-3.2.0-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.nio.file.NestedFileSystemProvider.getPath(NestedFileSystemProvider.java:88) ~[cucumber-spring-boot-3.2.0-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at java.base/java.nio.file.Path.of(Path.java:208) ~[na:na]
        at java.base/java.nio.file.Paths.get(Paths.java:98) ~[na:na]
        at jdk.zipfs/jdk.nio.zipfs.ZipFileSystemProvider.uriToPath(ZipFileSystemProvider.java:76) ~[jdk.zipfs:na]
        at jdk.zipfs/jdk.nio.zipfs.ZipFileSystemProvider.newFileSystem(ZipFileSystemProvider.java:98) ~[jdk.zipfs:na]
        at java.base/java.nio.file.FileSystems.newFileSystem(FileSystems.java:339) ~[na:na]
        at java.base/java.nio.file.FileSystems.newFileSystem(FileSystems.java:288) ~[na:na]
        at io.cucumber.core.resource.JarUriFileSystemService.openFileSystem(JarUriFileSystemService.java:51) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.core.resource.JarUriFileSystemService.open(JarUriFileSystemService.java:32) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.core.resource.JarUriFileSystemService.handleJarUriScheme(JarUriFileSystemService.java:100) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.core.resource.JarUriFileSystemService.open(JarUriFileSystemService.java:71) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.core.resource.PathScanner.open(PathScanner.java:41) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.core.resource.PathScanner.findResourcesForUri(PathScanner.java:29) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.core.resource.ResourceScanner.findResourcesForUri(ResourceScanner.java:61) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.core.resource.ResourceScanner.lambda$findResourcesForUris$3(ResourceScanner.java:104) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197) ~[na:na]
        at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625) ~[na:na]
        at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509) ~[na:na]
        at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
        at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921) ~[na:na]
        at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
        at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682) ~[na:na]
        at io.cucumber.core.resource.ResourceScanner.findResourcesForUris(ResourceScanner.java:107) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.core.resource.ResourceScanner.scanForClasspathResource(ResourceScanner.java:115) ~[cucumber-core-7.14.1.jar!/:7.14.1]
        at io.cucumber.junit.platform.engine.FeatureResolver.resolveClasspathResource(FeatureResolver.java:188) ~[cucumber-junit-platform-engine-7.14.1.jar!/:na]
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
        at io.cucumber.junit.platform.engine.DiscoverySelectorResolver.resolve(DiscoverySelectorResolver.java:76) ~[cucumber-junit-platform-engine-7.14.1.jar!/:na]
        at io.cucumber.junit.platform.engine.DiscoverySelectorResolver.resolveSelectors(DiscoverySelectorResolver.java:48) ~[cucumber-junit-platform-engine-7.14.1.jar!/:na]
        at io.cucumber.junit.platform.engine.CucumberTestEngine.discover(CucumberTestEngine.java:43) ~[cucumber-junit-platform-engine-7.14.1.jar!/:na]
        at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discoverEngineRoot(EngineDiscoveryOrchestrator.java:152) ~[junit-platform-launcher-1.10.1.jar!/:1.10.1]
        ... 38 common frames omitted
```

Running the app from (for example) IntelliJ IDEA works fine.
The feature in `src/main/resources/features/example.feature` is executed without any errors in that case.

Using versions of Spring Boot before 3.2.0, the application runs without issues both from within IntelliJ and as an uberjar.
Replace the Spring Boot pluging version `3.2.0` with `3.1.6` in `build.gradle`, for example, to build an uberjar that functions as intended.

The problem is caused by recent changes to the code that supports Spring Boot's uberjar loading: https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.2-Release-Notes.
