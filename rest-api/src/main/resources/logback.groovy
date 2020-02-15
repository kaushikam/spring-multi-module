import ch.qos.logback.classic.Level

class LoggingConfiguration {
    String filename
    Level rootLoggingLevel
    Level applicationLoggingLevel
    String loggingFile
    String rootPackageName
    int maxHistorySize
    String maxFileSize
    final String FILE = "FILE"
    final String CONSOLE = "CONSOLE"

    LoggingConfiguration(filename) {
        this.filename = filename
        init(createPropertiesFromFile(this.filename))
    }

    private Properties createPropertiesFromFile(String filename) {
        def properties = new Properties()
        new File(getClass().getClassLoader().getResource(filename).toURI()).withInputStream {
            stream -> properties.load(stream)
        }
        return properties
    }

    private void init(Properties properties) {
        this.rootPackageName = properties.getProperty("root.package.name")
        this.loggingFile = properties.getProperty("logging.file.path") + "/" +properties.getProperty("logging.file.name")
        this.maxHistorySize = properties.getProperty("logging.file.max-history").toInteger()
        this.maxFileSize = properties.getProperty("logging.file.max-size")
        this.rootLoggingLevel = toLevel(properties.getProperty("logging.level.root"))
        this.applicationLoggingLevel = toLevel(properties.getProperty("logging.level.${rootPackageName}"))
    }
}

def configuration = new LoggingConfiguration("application.properties")

appender(configuration.FILE, RollingFileAppender) {
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${configuration.loggingFile}.%d{dd-MM-yyyy}.%i.log.zip"
        maxHistory = configuration.maxHistorySize
        timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
            maxFileSize = configuration.maxFileSize
        }
    }

    encoder(PatternLayoutEncoder) {
        pattern = "%date{dd MMM yyyy; HH:mm:ss.SSS} %-5level %logger{36} - %msg%n"
    }
}

appender(configuration.CONSOLE, ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%date{dd MMM yyyy; HH:mm:ss.SSS} %-5level %logger{36} - %msg%n"
    }
}

logger(
        configuration.rootPackageName,
        configuration.applicationLoggingLevel,
        [configuration.FILE, configuration.CONSOLE],
        false
)
root(
        configuration.rootLoggingLevel,
        [configuration.FILE, configuration.CONSOLE]
)