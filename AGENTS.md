# Workflow Rules

## Project Context

This repository is a Jmix fork of EclipseLink. Keep diffs merge-friendly: make minimal changes on top of upstream EclipseLink and avoid unnecessary public API surface.
Keep Jmix changes minimal; do not reformat surrounding upstream code.

## Jmix Change Marking

Mark Jmix-specific changes explicitly.
Do not mark imports with `// jmix`.

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

Do not silently add, remove, or resolve TODOs (`TODO`, `//todo`); ask what to do with them.