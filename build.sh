#!/usr/bin/env bash
set -euo pipefail

if [[ "${1:-}" == "--help" || "${1:-}" == "-h" ]]; then
  cat <<'HELP'
Usage: ./build.sh [Gradle options]

Builds the Enforce Bukkit plugin using JDK 21 and the Gradle wrapper.
Uses JAVA_HOME, discovers JDK 21 on macOS, or checks Java on PATH.
Additional options such as --offline or --no-daemon are passed to Gradle.
The build log is saved to build/enforce-build.log.
The plugin JAR is written to bukkit/build/libs/enforce.jar.
HELP
  exit 0
fi

enforce_root="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
cd -- "$enforce_root"

is_jdk_21() {
  [[ -n "$1" && -x "$1/bin/java" && -x "$1/bin/javac" ]] || return 1
  local enforce_javac_version
  enforce_javac_version="$("$1/bin/javac" -version 2>&1)" || return 1
  [[ "$enforce_javac_version" == "javac 21" || "$enforce_javac_version" == "javac 21."* ]]
}

enforce_java_home="${JAVA_HOME:-}"
if ! is_jdk_21 "$enforce_java_home" && [[ -x /usr/libexec/java_home ]]; then
  enforce_java_home="$(/usr/libexec/java_home -v 21 2>/dev/null || true)"
fi
if ! is_jdk_21 "$enforce_java_home" && command -v java >/dev/null 2>&1; then
  enforce_java_home="$(java -XshowSettings:properties -version 2>&1 |
    sed -n 's/^[[:space:]]*java.home = //p' || true)"
fi
if ! is_jdk_21 "$enforce_java_home"; then
  printf '%s\n' 'JDK 21 was not found. Install it and set JAVA_HOME to its installation directory.' >&2
  exit 1
fi
export JAVA_HOME="$enforce_java_home"
export PATH="$JAVA_HOME/bin:$PATH"

mkdir -p build
enforce_log="$enforce_root/build/enforce-build.log"
printf 'Building Enforce with JDK 21: %s\n' "$JAVA_HOME"
if ./gradlew :bukkit:shadowJar -PmavenLocalOverride=false --console=plain "$@" 2>&1 | tee "$enforce_log"; then
  enforce_jar="$enforce_root/bukkit/build/libs/enforce.jar"
else
  enforce_status=$?
  printf '\nBuild failed. Full log: %s\n' "$enforce_log" >&2
  exit "$enforce_status"
fi

if [[ ! -f "$enforce_jar" ]]; then
  printf '\nCould not locate the built JAR. Check %s\n' "$enforce_log" >&2
  exit 1
fi
printf '\nEnforce built successfully:\n%s\n' "$enforce_jar"
