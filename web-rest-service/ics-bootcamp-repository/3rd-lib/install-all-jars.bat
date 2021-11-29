call mvn install:install-file -Dfile=jdbc-19c-java8.jar -DgroupId=oracle -DartifactId=jdbc -Dversion=19c-java8 -Dpackaging=jar
call mvn install:install-file -Dfile=orai18n-19c-java8.jar -DgroupId=oracle -DartifactId=orai18n -Dversion=19c-java8 -Dpackaging=jar

pause ...
