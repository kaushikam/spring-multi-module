extra["applicationProperties"] = hashMapOf(
    "datasourceUrl" to "jdbc:h2:mem:testdb",
    "datasourceDriverClassName" to "org.h2.Driver",
    "datasourceUsername" to "kaushik",
    "datasourcePassword" to "redhat",
    "datatypeFactory" to "org.dbunit.ext.h2.H2DataTypeFactory",
    "shouldShowSQL" to "true",
    "shouldFormatSQL" to "true",
    "hibernateDialect" to "org.hibernate.dialect.H2Dialect",
    "shouldGenerateStatistics" to "true",
    "shouldUseSecondLevelCache" to "true",
    "hibernateCacheRegionFactoryClass" to "org.hibernate.cache.ehcache.EhCacheRegionFactory",
    "sharedCacheMode" to "ENABLE_SELECTIVE"
)
