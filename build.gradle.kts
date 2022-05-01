plugins {
    application
}

subprojects {
    tasks.register<DependencyReportTask>("allDep") {}
}