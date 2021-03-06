dataSource {
	pooled = true
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	show_sql = false
	//jdbc.batch_size=50

	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = 'none' // I'll handle my own table creations with 'migrations', thank you very much
			url = "jdbc:mysql://localhost/hon_log?useUnicode=yes&characterEncoding=UTF-8"
			username = "hon_log"
			password = "hon_log"
			dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
			driverClassName = "com.mysql.jdbc.Driver"
		}
	}
	test {
		dataSource {
			dbCreate = "create-drop"
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            url = "jdbc:h2:mem:testDb;MVCC=TRUE"
            dialect = 'org.hibernate.dialect.H2Dialect'
		}
	}
	production {
		dataSource {
			grails.config.locations=[
				"classpath:application.properties"
			]
			dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
			driverClassName = "com.mysql.jdbc.Driver"
			dbCreate = 'none' // I'll handle my own table creations with 'migrations', thank you very much
			
			// the following supposedly resolves problems with Broken Pipe exceptions in MySQL, per
			// http://stackoverflow.com/questions/2740987
			// /mysql-connection-timeout-issue-grails-application-on-tomcat-using-hibernate-an
			properties {
				validationQuery               = "select 1"
				testWhileIdle                 = true
				timeBetweenEvictionRunsMillis = 60000
			}
		}
	}
}
