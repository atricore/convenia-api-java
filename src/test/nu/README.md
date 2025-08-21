# Executing Sripts

## Configuraiton

Set convenia toke in environment variable `CONVENIA_API_TOKEN`

## Logging

Scripts generate a log, to create a log file use the `e>` output

```nushell
./api.nu e> test.log
```

## Examples

### Get all employes, 

```nushell
./api.nu 2> test.log | from json
```

### Review an employee

```nushell
./api.nu c0b27562-b81a-4d8d-928f-935e9731eff9  | from json | get custom_fields | select name value
```

```nushell
./api.nu e> test.log | from json | where email == 'user@company.com' | get 0 | explore
```

```nushell
./api.nu employees/dismissed | from json | where ( get corporate_email | is-not-empty  ) | where corporate_email like 'pric' | get id
```

```nusshell
./api.nu employees/dismissed --query "from_date=2024-01-01" | from json | where ( get corporate_email | is-not-empty  ) | length
```