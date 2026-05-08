# Workflow Rules

## Project Context

This repository is a Jmix fork of EclipseLink. Keep diffs merge-friendly: make minimal changes on top of upstream EclipseLink and avoid unnecessary public API surface.
Keep Jmix changes minimal; do not reformat surrounding upstream code.

## Test Execution

Before any test run, run a full reactor clean first:

```bash
mvn -fae clean
```

Do this even for targeted module test runs, so stale `target` artifacts cannot affect the result.

## Jmix Change Marking

Mark Jmix-specific changes explicitly.

```java
// jmix begin: short reason
...
// jmix end
```

```xml
<!-- jmix begin: short reason -->
...
<!-- jmix end -->
```

Jmix blocks must cover the whole structural change, not only the most visible added line.
Do not mass-normalize old Jmix comments unless required for the current change.
For one-line changes, use `// jmix <reason>` or just `// jmix` when obvious.
When disabling upstream code, keep the original lines commented inside the Jmix block.

Never mark import statements with `// jmix` or `// jmix begin/end`.
This rule has no exceptions, even when the import exists only because of a Jmix-specific change.

Correct:

```java
import org.junit.Ignore;

...
// jmix begin: disable unstable test
@Ignore("...")
// jmix end
```

Incorrect:

```java
import org.junit.Ignore; // jmix
```

Before finishing any Java change, run:

```bash
rg -n '^\s*import\s+[^;]+;\s*(//|/\*)\s*[Jj]mix\b' -g '*.java' .
```

The command must return no matches. If it finds matches, remove the Jmix marker from the import and keep the marker on the actual code block instead.

## TODO Handling

Do not silently add, remove, or resolve TODOs (`TODO`, `//todo`); ask what to do with them.
