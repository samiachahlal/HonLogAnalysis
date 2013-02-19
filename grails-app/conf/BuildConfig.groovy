grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.13'
		
		
		// it sucks, but I have to manually include the IpAddressToLocationCustomSqlChange.groovy here
		// or else the migration plugin doesn't work in development mode
        //compile 'ip-address-to-location-custom-sql-change:ip-address-to-location-custom-sql-change:1.0'
		
        test    "hsqldb:hsqldb:1.8.0.10"
    }
    
    plugins {
        
        
        build   ":tomcat:$grailsVersion"
		
        runtime   ":hibernate:$grailsVersion"
		runtime   ":database-migration:1.2"
		
        runtime ':blueprint:1.0.2'
        runtime ':blueprint-jquery-ui:0.2.0'
        runtime ':dynamic-jasper:0.6'
        runtime ':geoip:0.2'
        runtime ':google-visualization:0.6.1'
        
        runtime ':jasper:1.2.2'
        runtime ':jquery:1.6.1.1'
        runtime ':jquery-file-upload:0.2'
        runtime ':jquery-json:2.2.2'
        runtime ':jquery-ui:1.8.15'
        runtime ':jqueryui-widget:0.1.4.1'
        runtime  ':resources:1.1.1'
    }
}
