### "Performance testing"

Very simple setup to benchmark startup-times of a spring-boot application,
to see how component scanning and amount of files, affects the startup time

Generate files with `create-classes.sh`, adjust amount of files in the script. Startup time should
increase with more files
* Use `PerformanceApplicationScanning` to test startup with component scanning
* Use `PerformanceApplicationNotScanning` to test without component scanning